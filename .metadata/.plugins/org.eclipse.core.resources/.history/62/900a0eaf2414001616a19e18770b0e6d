package models.requests;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import models.Location;

public class DeliveryRequest extends Request{

	private String id;
	private Date timestamp;
	private Location targetCoordinates; 
	 //<product name > <quantity>
	private Map<String, Integer> order=new HashMap<>();
	
	public DeliveryRequest(String type, String id, Date timestamp,
			Location targetCoordinates, Map<String, Integer> order) {
		super(type);
		this.id = id;
		this.timestamp = timestamp;
		this.targetCoordinates = targetCoordinates;
		this.order = order;
	}

	public String getId() {
		return id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public Location getTargetCoordinates() {
		return targetCoordinates;
	}

	public Map<String, Integer> getOrder() {
		return order;
	}

	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "DeliveryRequest [id=" + id + ", timestamp=" + timestamp
				+ ", targetCoordinates=" + targetCoordinates + ", order="
				+ order + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime
				* result
				+ ((targetCoordinates == null) ? 0 : targetCoordinates
						.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
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
		DeliveryRequest other = (DeliveryRequest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (targetCoordinates == null) {
			if (other.targetCoordinates != null)
				return false;
		} else if (!targetCoordinates.equals(other.targetCoordinates))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	
	
	
}
