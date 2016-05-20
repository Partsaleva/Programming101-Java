package models;


import java.util.List;

import models.timestamp.DTime;

public class ChargingStation {

	private List<Drone> drones;
	private int unitsForCharging;
	private DTime timestamp;
	
	public ChargingStation(List<Drone> drones, int unitsForCharging,DTime dTime) {
		this.drones = drones;
		this.unitsForCharging = unitsForCharging;
		this.timestamp=dTime;
	}

	public List<Drone> getDrones() {
		return drones;
	}

	public int getUnitsForCharging() {
		return unitsForCharging;
	}

	
	public DTime getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "ChargingStation [drones=" + drones + ", unitsForCharging="
				+ unitsForCharging + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drones == null) ? 0 : drones.hashCode());
		result = prime * result + unitsForCharging;
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
		ChargingStation other = (ChargingStation) obj;
		if (drones == null) {
			if (other.drones != null)
				return false;
		} else if (!drones.equals(other.drones))
			return false;
		if (unitsForCharging != other.unitsForCharging)
			return false;
		return true;
	}
	
	
	
}
