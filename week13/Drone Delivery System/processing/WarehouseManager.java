package processing;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import models.Drone;
import models.Location;
import models.Product;
import models.Warehouse;


public class WarehouseManager {

	public static void main(String[] args) {
		
		WarehouseManager wm=new WarehouseManager();
		wm.addWarehouse(new Warehouse("w1", new Location(42,42)));
	}

	//get all warehouses from file
	@SuppressWarnings("unchecked")
	public Map<String, Warehouse> getWarehouses(){
		Map<String, Warehouse> map=new HashMap<>();

		try(ObjectInputStream in=new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("warehouses")))){
			
			map= (Map<String, Warehouse>) in.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return map;		
	}
	
	//if we want to save data
	public void updateWarehouseData(Warehouse w){	
		Map<String, Product>  products=w.getProducts();
		System.out.println(products.size());
		Queue<Drone> drones=w.getDrones();
		
		WarehouseFilesControl c=new WarehouseFilesControl();		
		c.createUpdatedProductFile(w,products);
		c.createUpdatedDroneFile(w,drones);
		c.createUpdatedWarehouseFile(w);
	}
	
	
	public void addWarehouse(Warehouse w){
		Map<String, Warehouse> warehouses=getWarehouses();
		WarehouseFilesControl t=new WarehouseFilesControl();
		
		Map<String, Product> products=t.getProductsForWarehouse(w.getId());
		List<Queue<Drone>> drones=t.getDronesForWarehouse(w.getId());
		
		w.setProducts(products);
		w.setDrones(drones.get(0));
		w.setChineseDrones(drones.get(1));
		if (!warehouses.containsKey(w.getId())) {
			warehouses.put(w.getId(), w);
		}else{
			//replace
			warehouses.put(w.getId(), warehouses.get(w.getId()));
		}
		
		try (ObjectOutputStream objStream=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("warehouses")))){
			//save warehouse as object in file
			objStream.writeObject(warehouses);

		} catch (FileNotFoundException e1) {				
			e1.printStackTrace();
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
	}
	
		
	
	public Warehouse getWarehouseById(String id){
		Map<String, Warehouse> warehouses=getWarehouses();
		return warehouses.get(id);
	}
	
	
}
