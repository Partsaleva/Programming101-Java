 package models;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 181543857048126583L;

	private String name;
	private int weight;
	private int quantity;
	

	public Product(String name, int weight, int quantity) {
		this.name = name;
		this.weight = weight;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public int getQuantity() {
		return quantity;
	}


	@Override
	public String toString() {
		return "Product [ name=" + name + ", weight=" + weight
				+ ", quantity=" + quantity +  "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + quantity;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity != other.quantity)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	
	
}
