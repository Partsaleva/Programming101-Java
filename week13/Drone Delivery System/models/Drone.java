package models;

import java.io.Serializable;

public class Drone implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private int batteryUnits;
	private int weightCapacity;
	private int chargingRate;
	
	public Drone(String id, int batteryUnits, int weightCapacity,int chargingRate) {
		this.id = id;
		this.batteryUnits = batteryUnits;
		this.weightCapacity = weightCapacity;
		this.chargingRate = chargingRate;

	}

	public String getId() {
		return id;
	}

	public int getBatteryUnits() {
		return batteryUnits;
	}

	public int getWeightCapacity() {
		return weightCapacity;
	}

	public int getChargingRate() {
		return chargingRate;
	}

	
	@Override
	public String toString() {
		return "Drone [id=" + id + ", batteryUnits=" + batteryUnits
				+ ", weightCapacity=" + weightCapacity + ", chargingRate="
				+ chargingRate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batteryUnits;
		result = prime * result + chargingRate;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + weightCapacity;
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
		Drone other = (Drone) obj;
		if (batteryUnits != other.batteryUnits)
			return false;
		if (chargingRate != other.chargingRate)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (weightCapacity != other.weightCapacity)
			return false;
		return true;
	}
	
	
}
