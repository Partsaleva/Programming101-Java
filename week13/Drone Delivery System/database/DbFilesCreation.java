package database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DbFilesCreation {

	public static void main(String[] args) {
		//createProductsFile();
		//createWarehouseFile();
		//createDronesFile();
		//createRequestsFile();
	}

	public static void createProductsFile(){
		try(BufferedWriter bs=new BufferedWriter(new FileWriter("products.txt",true))){
			String head="id,name,weight,quantity,warehouseId";
			bs.write(head+"\n");
			Random rand=new Random();
			for (int i = 1; i < 101; i++) {
				bs.write(i+",product"+i+","+rand.nextInt(100)+","+rand.nextInt(200)+",w1");
				bs.write(System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createWarehouseFile(){
		try(BufferedWriter bs=new BufferedWriter(new FileWriter("warehouses.txt", true))){
			String head="id,location,cityName";
			bs.write(head+"\n");		
			
			bs.write("w1,42-42,Sofia");
			bs.write(System.getProperty("line.separator"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createDronesFile(){
		try(BufferedWriter bs=new BufferedWriter(new FileWriter("drones.txt", true))){
			String head="id,batteryUnits,weightCapacity,chargingRate,werehouseId";
			bs.write(head+"\n");		
			
			for (int i = 1; i < 51; i++) {
				bs.write("d"+i+",2000,500,5,w1");
				bs.write(System.getProperty("line.separator"));
			}
			for (int i = 1; i < 31; i++) {
				bs.write("ch"+i+",1200,200,3,w1");
				bs.write(System.getProperty("line.separator"));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
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
