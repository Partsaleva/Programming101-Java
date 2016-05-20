package processing;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import models.Drone;
import models.Product;
import models.Warehouse;

public class WarehouseFilesControl {

	
	void createUpdatedWarehouseFile(Warehouse w){
		WarehouseManager wm=new WarehouseManager();
		wm.addWarehouse(w);		
	}
	
	
	List<Queue<Drone>> getDronesForWarehouse(String warehouseId){
		List<Queue<Drone>> drones=new ArrayList<>();
		
		Queue<Drone> westDrones=new LinkedList<>();
		Queue<Drone> chineseDrones=new LinkedList<>();
		
		try(ObjectInputStream in =new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("drones"+warehouseId)))){
			
			@SuppressWarnings("unchecked")
			List<Drone> d=(List<Drone>) in.readObject();
			for (Drone drone : d) {
				if(drone.getId().contains("d")){
					westDrones.add(drone);
				}else
				chineseDrones.add(drone);				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		drones.add(westDrones);
		drones.add(chineseDrones);
		return drones;
	}
	
	@SuppressWarnings("unchecked") 
	Map<String, Product> getProductsForWarehouse(String warehouseId){		
		Map<String, Product> prod=new ConcurrentHashMap<>();
		List<Product> p=null;
		
		try(ObjectInputStream in =new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("products"+warehouseId)))){
			
			p=(List<Product>) in.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		for (Product product : p) {		
			prod.put(product.getName(), product);		
		}
		return prod;
		
	}
	
	void createUpdatedProductFile(Warehouse w,Map<String, Product> products ){
		List<Product> prod=new ArrayList<Product>();
		//iterate over map; put in List; save in file
		for (Entry<String, Product>  entry : products.entrySet()) {
			prod.add(entry.getValue());
		}
		
		try (ObjectOutputStream objStream=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("products"+w.getId())))){
			
			objStream.writeObject(prod);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void createUpdatedDroneFile(Warehouse w,Queue<Drone> drones){
		List<Drone> dr=new ArrayList<Drone>();
		//iterate over queue; put in List; save in file
		for (Drone drone : drones) {
			dr.add(drone);
		}
		
		try (ObjectOutputStream objStream=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("drones"+w.getId())))){
			
			objStream.writeObject(dr);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
