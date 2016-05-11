package processing;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import managers.WarehouseManager;
import models.Product;
import models.Warehouse;
import models.requests.SupplyRequest;

public class RequestProcessor {

	
	public void processRequest(String type, String request){
		if (type.equals("supply")) {
			SupplyRequest s=processSupplyRequest(request);
			s.log(request);
		} else {
			processDeliveryRequest(request);
		}
	}

	private void processDeliveryRequest(String request) {
			
	}

	private SupplyRequest processSupplyRequest(String request) {
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
		supplyWarehouse("w1",supplyRequest);
		return supplyRequest;
				
	}
	
	private void supplyWarehouse(String warehouseId,SupplyRequest supplyRequest){
		WarehouseManager wm=new WarehouseManager();
		List<Warehouse> warehouses=wm.getWarehouses();
		Warehouse w = null;
		for (Warehouse warehouse : warehouses) {
			if (warehouse.getId().equals(warehouseId)) {
				w=warehouse;
			}
		}
		wm.addProducts(w, supplyRequest.getProducts());	
	}

}
