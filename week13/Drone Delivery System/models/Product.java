 package models;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 181543857048126583L;
	private int id;
	private String name;
	private int weight;
	private int quantity;
	private String warehouseId;
	
	public Product(int id, String name, int weight, int quantity,
			String warehouseId) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.quantity = quantity;
		this.warehouseId = warehouseId;
	}

	public Product(String name, int weight, int quantity) {
		this.name = name;
		this.weight = weight;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", weight=" + weight
				+ ", quantity=" + quantity + ", warehouseId=" + warehouseId
				+ "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + quantity;
		result = prime * result
				+ ((warehouseId == null) ? 0 : warehouseId.hashCode());
		result = prime * result + weight;
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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity != other.quantity)
			return false;
		if (warehouseId == null) {
			if (other.warehouseId != null)
				return false;
		} else if (!warehouseId.equals(other.warehouseId))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	
	
}
