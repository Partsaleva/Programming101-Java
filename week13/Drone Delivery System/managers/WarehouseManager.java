package managers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import models.Drone;
import models.Product;
import models.Warehouse;


public class WarehouseManager {

	public static void main(String[] args) {
		WarehouseManager w=new WarehouseManager();
		System.out.println(w.getWarehouses());
		Map<Product, Integer> map=w.getProductsForWarehouse("w1");
		System.out.println(map.size());
	}

	@SuppressWarnings("unchecked")
	public List<Warehouse> getWarehouses(){
		List<Warehouse> warehouses=null;
		try(ObjectInputStream in=new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("warehouses")))){
			
			warehouses=(List<Warehouse>) in.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return warehouses;
		
	}
	public void updateWarehouseData(Warehouse w){
		
		Map<Product, Integer> products=w.getProducts();
		Queue<Drone> drones=w.getDrones();
		
		createUpdatedProductFile(w.getId(),products);
		createUpdatedDroneFile(w.getId(),drones);
	}
	
	private void createUpdatedProductFile(String warehouseId,Map<Product, Integer> products ){
		List<Product> prod=new ArrayList<Product>();
		//iterate over map; put in List; save in file
		for (Entry<Product, Integer> entry : products.entrySet()) {
			prod.add(entry.getKey());
		}
		
		try (ObjectOutputStream objStream=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("products"+warehouseId)))){
			
			objStream.writeObject(prod);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createUpdatedDroneFile(String warehouseId,Queue<Drone> drones){
		List<Drone> dr=new ArrayList<Drone>();
		//iterate over queue; put in List; save in file
		for (Drone drone : drones) {
			dr.add(drone);
		}
		
		try (ObjectOutputStream objStream=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("drones"+warehouseId)))){
			
			objStream.writeObject(dr);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Warehouse addWarehouse(Warehouse w){
		Map<Product, Integer> products=getProductsForWarehouse(w.getId());
		Queue<Drone> drones=getDronesForWarehouse(w.getId());
		
		w.setProducts(products);
		w.setDrones(drones);
		return w;	
	}

	@SuppressWarnings("unchecked")
	private Map<Product, Integer> getProductsForWarehouse(String warehouseId){		
		Map<Product, Integer> prod=new HashMap<Product, Integer>();
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
			prod.put(product, product.getQuantity());		
		}
		return prod;
		
	}
	
	private Queue<Drone> getDronesForWarehouse(String warehouseId){
		Queue<Drone> drones=new LinkedList<>();
		try(ObjectInputStream in =new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("drones"+warehouseId)))){
			
			@SuppressWarnings("unchecked")
			List<Drone> d=(List<Drone>) in.readObject();
			for (Drone drone : d) {
				drones.add(drone);				
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
	 
	public void addProducts(Warehouse w,List<Product> products){		
		for (Product p :products) {
			w.getProducts().put(p, p.getQuantity());
		}
	}
	
}