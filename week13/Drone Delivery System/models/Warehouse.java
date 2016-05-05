package models;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Warehouse {

	private String id;
	private Location location;
	//Product and quantity 
	private Map<Product, Integer> products=new HashMap<>();
	private Queue<Drone> warehouseDrones=new LinkedBlockingQueue<>();

	public Warehouse(String id, Location location, Map<Product, Integer> products) {
		this.id = id;
		this.location = location;
		this.products = products;
	}

	
	public String getId() {
		return id;
	}


	public Location getLocation() {
		return location;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}
	
	public Queue<Drone> getWarehouseDrones() {
		return warehouseDrones;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warehouse other = (Warehouse) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}
	
	
}
