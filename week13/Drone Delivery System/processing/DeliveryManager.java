package processing;

import java.util.List;
import java.util.Map;

import exceptions.ProductsNotFoundException;
import exceptions.noSuitableDroneFoundException;
import models.Drone;
import models.Location;
import models.Product;
import models.Warehouse;
import models.requests.DeliveryRequest;

public class DeliveryManager {

	

	public void executeDelivery(Warehouse warehouse,DeliveryRequest deliveryRequest) 
			throws noSuitableDroneFoundException, ProductsNotFoundException {
		DronesControl control=new DronesControl(); 
		if(isAllProductsInStock(warehouse.getProducts(), deliveryRequest.getOrder())){
			
			int deliveryWeight=getProdustsFromWarehouse(warehouse.getProducts(), deliveryRequest.getOrder());
			int distance=(int) calculateDistance(warehouse.getLocation(), deliveryRequest.getTargetCoordinates());
			List<Drone> dronesForDelivery=control.getDronesForDelivery(warehouse ,deliveryWeight, distance);
			control.chargeUsedDrones(warehouse,dronesForDelivery, distance, deliveryRequest.getTimestamp());
			estimateTimeOfArrival(deliveryRequest, distance);

		}
		
	}


	private void estimateTimeOfArrival(DeliveryRequest deliveryRequest, int distance) {	
		int timeForLoadUnload=deliveryRequest.getOrder().size() *2 ;
		int time=distance+timeForLoadUnload;
		int hours = time / 60; 
		int min = time % 60;
		System.out.printf("Estimated time of arrival: %d:%02d (hours)\n",hours, min );
	}

	

	//getProducts and calculate weightUnits
	private int getProdustsFromWarehouse(Map<String, Product> products,
			Map<String, Integer> order) {
		int weightUnits=0;
		for (String key : order.keySet()) {
			weightUnits +=  products.get(key).getWeight() * order.get(key);
			
			Product updatedProduct=new Product(key, products.get(key).getWeight(), 
					products.get(key).getQuantity()- order.get(key));
			products.put(key, updatedProduct);
		}
		return weightUnits;
	}

	private boolean isAllProductsInStock(Map<String, Product> warehouseProducts, Map<String, Integer> order) 
			throws ProductsNotFoundException{
		for (String key : order.keySet()) {
			if(!warehouseProducts.containsKey(key)){
				throw new ProductsNotFoundException("One or more Products not in stock");
			}
		}
		return true;		
	}
	
	//distance between warehouse and delivery location
	private double calculateDistance(Location w, Location d){
		//The distance from cell [x1, y1] to cell [x2, y2] is calculated as 
		//((x1 - x2)^2 + (y1 - y2)^2)^-2 (two-dimensional Euclidean distance).
		double distanceUnits=Math.sqrt((w.getX()-d.getX()) * (w.getX()-d.getX()) + 
				( (w.getY() - d.getY()) * (w.getY() - d.getY()) ));
		return distanceUnits;		
	}
	
}
