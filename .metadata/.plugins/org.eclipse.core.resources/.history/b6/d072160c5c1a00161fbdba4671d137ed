package processing;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import managers.DeliveryManager;
import models.Location;
import models.Product;
import models.Warehouse;
import models.requests.DeliveryRequest;
import models.requests.SupplyRequest;

public class RequestProcessor {

	
	public void processRequest(Warehouse warehouse,String type, String request){
		if (type.equals("supply")) {
			SupplyRequest s=runSupplyRequest(warehouse,request);
			s.log(request);
		} else {
			DeliveryRequest d=runDeliveryRequest(request);
			d.log(request);
		}
	}

	private DeliveryRequest runDeliveryRequest(String request) {
		String[] data=request.split(" ");
		String id=data[1];
		Date date=new Date();
		String[] location=data[4].split(",");
		Location deliveryLocation=new Location(Double.parseDouble(location[0]), Double.parseDouble(location[1]));
		Map<String, Integer> order=new HashMap<String, Integer>();
		
		for (int i = 5; i < data.length; i=i+2) {
			String name=data[i]; 
			int quantity=Integer.parseInt(data[i+1]);			
			order.put(name, quantity);
		}
		DeliveryRequest deliveryRequest=new DeliveryRequest(id, new Timestamp(date.getTime()),
				deliveryLocation, order);
		
		DeliveryManager delM = new DeliveryManager();
		delM.executeDelivery(deliveryRequest);
		return deliveryRequest;
		
	}

	private SupplyRequest runSupplyRequest(Warehouse warehouse,String request) {
		String[] data=request.split(" ");
		String id=data[1];
		Date date= new Date();

		List<Product> products=new ArrayList<Product>();
		
		for (int i = 4; i < data.length; i=i+3) {
			String name=data[i]; 
			int weight=Integer.parseInt(data[i+1]);
			int quantity=Integer.parseInt(data[i+2]);
			
			products.add(new Product(name, weight, quantity));
		}
		
		SupplyRequest supplyRequest=new SupplyRequest(id, new Timestamp(date.getTime()), products);
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
	

}
