package models;

import java.util.ArrayList;
import java.util.List;

public class City {

	private String name;
	private int x;
	private int y;
	private List<Warehouse> warehouseList=new ArrayList<>();
	
	public City(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public List<Warehouse> getWarehouse() {
		return warehouseList;
	}
	
	public void addWarehouse(Warehouse w){
		warehouseList.add(w);
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", warehouseList=" + warehouseList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + x;
		result = prime * result + y;
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
		City other = (City) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}
