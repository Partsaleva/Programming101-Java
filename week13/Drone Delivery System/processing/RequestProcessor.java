package processing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.ProductsNotFoundException;
import exceptions.noSuitableDroneFoundException;
import models.Location;
import models.Product;
import models.Warehouse;
import models.requests.DeliveryRequest;
import models.requests.SupplyRequest;
import models.timestamp.DDate;
import models.timestamp.DTime;
import models.timestamp.DTimestamp;

public class RequestProcessor implements Runnable{

	Warehouse warehouse;
	String type;
	String request;
	
	

	public RequestProcessor(Warehouse warehouse, String type, String request) {
		this.warehouse = warehouse;
		this.type = type;
		this.request = request;
	}

	@Override
	public void run() {
		
		synchronized(this){
			try {
				
				processRequest();
				
			} catch (noSuitableDroneFoundException e) {
				System.err.println(e);
			} catch (ProductsNotFoundException e) {
				System.err.println(e);
			}
			//notify when its ready
			notify();
		}
					
	}
	
	public void processRequest() 
			throws noSuitableDroneFoundException, ProductsNotFoundException{
		if (type.equals("supply")) {
			SupplyRequest s=runSupplyRequest(warehouse,request);
			s.log(request);
		} else {
			DeliveryRequest d=runDeliveryRequest(warehouse,request);
			d.log(request);
		}
	}

	
	
	private DeliveryRequest runDeliveryRequest(Warehouse warehouse,String request) 
			throws noSuitableDroneFoundException, ProductsNotFoundException {
		String[] data=request.split(" ");
		String id=data[1];
		
		String[] location=data[4].split(",");
		double X=Double.parseDouble(location[0]);
		double Y=Double.parseDouble(location[1]);
		
		Location deliveryLocation=null;
		//check if coordinates are valid
		if(X > 1000 || Y > 1000){
			throw new IllegalArgumentException("Coodrdinates outside city ");
			
		}else if(X < 0 || Y < 0){
			throw new IllegalArgumentException("Coodrdinates < 0 ");
			
		}else{
			deliveryLocation=new Location(X,Y);
		}
		
		Map<String, Integer> order=new HashMap<String, Integer>();
		
		for (int i = 5; i < data.length; i=i+2) {
			String name=data[i]; 
			int quantity=Integer.parseInt(data[i+1]);			
			order.put(name, quantity);
		}
		DeliveryRequest deliveryRequest=new DeliveryRequest(id, getTimestamp(data[2], data[3]),
				deliveryLocation, order);
		
		DeliveryManager delM = new DeliveryManager();
		delM.executeDelivery(warehouse,deliveryRequest);
		return deliveryRequest;		
	}

	
	
	private SupplyRequest runSupplyRequest(Warehouse warehouse,String request) {
		String[] data=request.split(" ");
		String id=data[1];

		List<Product> products=new ArrayList<Product>();
		
		for (int i = 4; i < data.length; i=i+3) {
			String name=data[i]; 
			int weight=Integer.parseInt(data[i+1]);
			int quantity=Integer.parseInt(data[i+2]);
			
			products.add(new Product(name, weight, quantity));
		}
		
		SupplyRequest supplyRequest=new SupplyRequest(id, getTimestamp(data[2], data[3]), products);
		//TODO change when can choose warehouse
		addProducts(warehouse, supplyRequest.getProducts());	
		return supplyRequest;
				
	}
	
	
	public void addProducts(Warehouse w,List<Product> products){
		Map<String, Product> warehouseProducts=w.getProducts();
		for (Product p :products) {
			if (warehouseProducts.containsKey(p)) {
				int quantity=p.getQuantity()+ warehouseProducts.get(p.getName()).getQuantity();
				p=new Product(p.getName(), p.getWeight(),quantity);
				warehouseProducts.put(p.getName(), p);
			} else {
				warehouseProducts.put(p.getName(), p);
			}		
		}
		w.setProducts(warehouseProducts);
	}

	private int toInt(String s){
		return Integer.parseInt(s);
	}
	
	private DTimestamp getTimestamp(String date, String time){
		String[] d=date.split("-");
		String[] t=time.split(":");
		
		return new DTimestamp(new DDate( toInt(d[0] ), toInt( d[1] ), toInt( d[2] ) ),
				new DTime(toInt( t[0] ), toInt( t[1] ) ));
	}

}
