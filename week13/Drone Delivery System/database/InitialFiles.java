package database;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import managers.WarehouseManager;
import models.Drone;
import models.Location;
import models.Product;
import models.Warehouse;

public class InitialFiles {

	public static void main(String[] args) {
		InitialFiles init=new InitialFiles();
		init.createProductsFile("w1");
		init.createDronesFile("w1");
		WarehouseManager wm=new WarehouseManager();
		List<Warehouse> list=new ArrayList<Warehouse>(); 
		list.add(wm.addWarehouse(new Warehouse("w1", new Location(42, 42))));
		init.createWarehouseFile(list);
		init.createRequestsFile();
	}

	
	public void createProductsFile(String warehouseId){
		//create list of products
		List<Product> products=new ArrayList<Product>();
		Random rand=new Random();
		for (int i = 1; i < 101; i++) {
			int quantity= rand.nextInt(200);
			Product p=new Product("product"+i, rand.nextInt(100), quantity);
			products.add(p);
		}

		try (ObjectOutputStream objStream=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("products"+warehouseId,true)))){
			//save list as object to file
			objStream.writeObject(products);

		} catch (FileNotFoundException e1) {				
			e1.printStackTrace();
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
	}
	
	public void createDronesFile(String warehouseId){
		//create list of drones
		List<Drone> drones=new ArrayList<>();
		for (int i = 1; i < 51; i++) {
			drones.add(new Drone("d"+i, 2000, 500, 5));
		}
		for (int i = 1; i < 31; i++) {
			drones.add(new Drone("ch"+i, 1200, 200, 3));

		}

		try (ObjectOutputStream objStream=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("drones"+warehouseId,true)))){
			//save list as object in file
			objStream.writeObject(drones);

		} catch (FileNotFoundException e1) {				
			e1.printStackTrace();
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
	}
	
	public void createWarehouseFile(List<Warehouse> list){	
		try (ObjectOutputStream objStream=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("warehouses")))){
			//save warehouse as object in file
			objStream.writeObject(list);

		} catch (FileNotFoundException e1) {				
			e1.printStackTrace();
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
	}
	
	
	public void createRequestsFile(){
		try(BufferedWriter bs=new BufferedWriter(
				new FileWriter("requests", true))){
			String head="type,id,time,data";
			bs.write(head+"\n");		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
