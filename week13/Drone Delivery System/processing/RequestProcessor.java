package processing;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import managers.DatabaseManager;
import models.Product;
import models.requests.SupplyRequest;

public class RequestProcessor {

	
	public void processRequest(String type, String request){
		if (type.equals("supply")) {
			processSupplyRequest(request);
		} else {
			processDeliveryRequest(request);
		}
	}

	private void processDeliveryRequest(String request) {
		
		
	}

	private void processSupplyRequest(String request) {
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
		//System.out.println(supplyRequest);
		DatabaseManager dm=new DatabaseManager();
		System.out.println(dm.loadProducts());
		
	}
}