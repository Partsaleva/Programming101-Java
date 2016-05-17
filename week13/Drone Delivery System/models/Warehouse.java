package models;

import java.io.Serializable;
import java.util.Map;
import java.util.Queue;

public class Warehouse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private Location location;
	private Map<String, Product>  products;
	private Queue<Drone> drones;
	private Queue<Drone> chineseDrones;
	
	public Warehouse(String id, Location location) {
		this.id = id;
		this.location = location;
		setProducts(products);
		setDrones(drones);
		setChineseDrones(chineseDrones);
	}
	
	public void setProducts(Map<String, Product>  products) {
		this.products = products;
	}

	public void setDrones(Queue<Drone> drones) {
		this.drones = drones;
	}

	public String getId() {
		return id;
	}
	public Location getLocation() {
		return location;
	}
	public Map <String, Product>  getProducts() {
		return products;
	}
	public Queue<Drone> getDrones() {
		return drones;
	}
	
	
	public Queue<Drone> getChineseDrones() {
		return chineseDrones;
	}

	public void setChineseDrones(Queue<Drone> chineseDrones) {
		this.chineseDrones = chineseDrones;
	}

	@Override
	public String toString() {
		return "Warehouse [id=" + id + ", location=" + location + ", products="
				+ products + ", drones=" + drones + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result
				+ ((products == null) ? 0 : products.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}
	
	
	
}
