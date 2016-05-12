package processing;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import models.Product;
import models.Warehouse;
import models.requests.SupplyRequest;

public class RequestProcessor {

	
	public void processRequest(Warehouse warehouse,String type, String request){
		if (type.equals("supply")) {
			SupplyRequest s=runSupplyRequest(warehouse,request);
			s.log(request);
		} else {
			runDeliveryRequest(request);
		}
	}

	private void runDeliveryRequest(String request) {
			
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
		Map<Product, Integer> warehouseProducts=w.getProducts();
		for (Product p :products) {
			warehouseProducts.put(p, p.getQuantity());
			w.setProducts(warehouseProducts);
		}
	}
	

}
