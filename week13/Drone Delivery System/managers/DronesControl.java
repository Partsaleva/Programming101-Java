package managers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import exceptions.noSuitableDroneFoundException;
import models.ChargingStation;
import models.Drone;
import models.Warehouse;

public class DronesControl {

	 List<Drone> getDronesForDelivery(Warehouse warehouse, int deliveryWeight, int distance) 
			throws noSuitableDroneFoundException {
		
		List<Drone> dronesForDelivery=chooseDrones(warehouse, deliveryWeight,distance);
		return dronesForDelivery;	
	}
	
	public List<Drone> chooseDrones(Warehouse warehouse, int deliveryWeight,int distance) 
			throws noSuitableDroneFoundException {
		List<Drone> dronesForDelivery=null;
		Queue<Drone> west=warehouse.getDrones();
		Queue<Drone> chinese=warehouse.getChineseDrones();
		
		int neededBatteryUnits= distance*2;
		//we use smaller drones if enough
		if(chinese.peek()!= null && canDeliver(chinese.peek(), neededBatteryUnits)){
			dronesForDelivery=getNeededAmountDrones(chinese,deliveryWeight);
			
		}else if(west.peek() != null && canDeliver(west.peek(), neededBatteryUnits)){
			dronesForDelivery=getNeededAmountDrones(west,deliveryWeight);
			
		}else{
			throw new noSuitableDroneFoundException("There is no drone that can execute the order");
		}
		
		return dronesForDelivery;
	}

	private List<Drone> getNeededAmountDrones(Queue<Drone> drones,int deliveryWeight){
		List<Drone> dronesForDelivery=new ArrayList<Drone>();
		int weight=deliveryWeight;
		while(weight>0){
			Drone drone=drones.poll();
			dronesForDelivery.add(drone);
			weight -= drone.getWeightCapacity();
		}
		return dronesForDelivery;
	}
	
	
	private boolean canDeliver(Drone drone, int battery){
		
		return drone.getBatteryUnits()>battery;		
	}

	public void chargeUsedDrones(Warehouse warehouse,List<Drone> dronesForDelivery,int distance, Date timestamp) {
		List<ChargingStation> charge=new ArrayList<>(32);
		//save drones with time and used battery
		charge.add(new ChargingStation(dronesForDelivery, distance*2, timestamp.getTime()));
		
		for (ChargingStation chStat : charge) {
			//calculate minutes between current time and saved for drones before
			long minutes = TimeUnit.MILLISECONDS.toMinutes(timestamp.getTime() - chStat.getTimestamp());
			//if BU spent < passed time we add drones back to warehouse
			if (chStat.getUnitsForCharging() < minutes) {
				Queue<Drone> warehouseDrones=null;
				//check type of drones used and add
				if (typeOfDrone(chStat.getDrones().get(0)).equals("west")) {
					warehouseDrones =warehouse.getDrones();
				}else{
					warehouseDrones =warehouse.getChineseDrones();
				}
				warehouseDrones.addAll(chStat.getDrones());
				warehouse.setDrones(warehouseDrones);
			}
		}
		
	}
	
	private String typeOfDrone(Drone d){
		if (d.getId().contains("d")) {
			return "west";
		} else {
			return "chinese";
		}
	}
}