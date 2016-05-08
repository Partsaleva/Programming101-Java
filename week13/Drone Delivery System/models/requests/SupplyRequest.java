package models.requests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Product;

public class SupplyRequest implements Loggable{

	//<id> <timestamp YYYY-MM-DD HH:MM> 
	private String id;
	private Date timeStamp;
//	<product name 1> <product weight> <quantity>
	private List<Product> products=new ArrayList<>();
	
	public SupplyRequest(String id, Date timeStamp,  List<Product> products) {
		this.id = id;
		this.timeStamp = timeStamp;
		this.products = products;
	}

	public String getId() {
		return id;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public  List<Product> getProducts() {
		return products;
	}

	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		
	};
	
	@Override
	public String toString() {
		return "SupplyRequest [id=" + id + ", timeStamp=" + timeStamp
				+ ", products=" + products + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((products == null) ? 0 : products.hashCode());
		result = prime * result
				+ ((timeStamp == null) ? 0 : timeStamp.hashCode());
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
		SupplyRequest other = (SupplyRequest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		return true;
	}

	
	
	
	
}