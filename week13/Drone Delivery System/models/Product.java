 package models;

public class Product {

	private int id;
	private String name;
	private double weight;
	private int quantity;
	private String warehouseId;
	
	public Product(int id, String name, double weight, int quantity,
			String warehouseId) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.quantity = quantity;
		this.warehouseId = warehouseId;
	}

	public Product(String name, double weight, int quantity) {
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double
				.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	
	
	
}
