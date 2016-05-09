package database;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import managers.DatabaseManager;
import models.Drone;
import models.Location;
import models.Product;
import models.Warehouse;

public class DbFilesCreation {

	public static void main(String[] args) {
		createProductsFile();
		createDronesFile();
		createWarehouseFile();
		//createRequestsFile();
	}

	
	public static void createProductsFile(){
		//create list of products
		List<Product> products=new ArrayList<Product>();
		Random rand=new Random();
		for (int i = 1; i < 101; i++) {
			int quantity= rand.nextInt(200);
			Product p=new Product(i, "product"+i, rand.nextInt(100), quantity, "w1");
			products.add(p);
		}

		try (ObjectOutputStream objStream=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("products",true)))){
			//save list as object to file
			objStream.writeObject(products);

		} catch (FileNotFoundException e1) {				
			e1.printStackTrace();
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
	}
	
	public static void createDronesFile(){
		//create list of drones
		List<Drone> drones=new ArrayList<>();
		for (int i = 1; i < 51; i++) {
			drones.add(new Drone("d"+i, 2000, 500, 5,"w1"));
		}
		for (int i = 1; i < 31; i++) {
			drones.add(new Drone("ch"+i, 1200, 200, 3,"w1"));

		}

		try (ObjectOutputStream objStream=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("drones",true)))){
			//save list as object in file
			objStream.writeObject(drones);

		} catch (FileNotFoundException e1) {				
			e1.printStackTrace();
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
	}
	public static void createWarehouseFile(){
		DatabaseManager d=new DatabaseManager();
		Warehouse w= d.addWarehouse(new Warehouse("w1", new Location(42, 42)));
		try (ObjectOutputStream objStream=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("warehouses",true)))){
			//save warehouse as object in file
			objStream.writeObject(w);

		} catch (FileNotFoundException e1) {				
			e1.printStackTrace();
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
	}
	
	
	public static void createRequestsFile(){
		try(BufferedWriter bs=new BufferedWriter(new FileWriter("requests.txt", true))){
			String head="type,id,time,data";
			bs.write(head+"\n");		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
