package managers;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


import models.Drone;
import models.Product;
import models.Warehouse;


public class DatabaseManager {

	public static void main(String[] args) {
		
	}

	public Warehouse addWarehouse(Warehouse w){
		Map<Product, Integer> products=getProductsForDb(w.getId());
		Queue<Drone> drones=getDronesForDb(w.getId());
		
		w.setProducts(products);
		w.setDrones(drones);
		return w;	
	}

	@SuppressWarnings("unchecked")
	private Map<Product, Integer> getProductsForDb(String wId){		
		Map<Product, Integer> prod=new HashMap<Product, Integer>();
		List<Product> p=null;
		
		try(ObjectInputStream in =new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("products")))){
			
			p=(List<Product>) in.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		for (Product product : p) {
			if (product.getWarehouseId().equals(wId)) {
				prod.put(product, product.getQuantity());
			}
		}
		return prod;
		
	}
	
	private Queue<Drone> getDronesForDb(String warehouseId){
		Queue<Drone> drones=new LinkedList<>();
		try(ObjectInputStream in =new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("drones")))){
			
			@SuppressWarnings("unchecked")
			List<Drone> d=(List<Drone>) in.readObject();
			for (Drone drone : d) {
				if (drone.getWarehouseId().equals(warehouseId)) {
					drones.add(drone);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return drones;
	}
	 
	
	
}
