package managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import exceptions.noSuitableDroneFoundException;
import models.Drone;
import models.Warehouse;

public class DronesControl {

	public List<Drone> chooseDrones(Warehouse warehouse, int deliveryWeight,int distance) 
			throws noSuitableDroneFoundException {
		List<Drone> dronesForDelivery=null;
		Queue<Drone> west=warehouse.getDrones();
		Queue<Drone> chinese=warehouse.getChineseDrones();
		
		int neededBatteryUnits= distance*2;
		
		if(canDeliver(chinese.peek(), neededBatteryUnits, deliveryWeight)){
			dronesForDelivery=getPropDrones(chinese,deliveryWeight);
			
		}else if(canDeliver(west.peek(), neededBatteryUnits, deliveryWeight)){
			dronesForDelivery=getPropDrones(west,deliveryWeight);
			
		}else{
			throw new noSuitableDroneFoundException("There is no drone that can execute the order");
		}
		
		return dronesForDelivery;
	}

	private List<Drone> getPropDrones(Queue<Drone> drones,int deliveryWeight){
		List<Drone> dronesForDelivery=new ArrayList<Drone>();
		int weight=deliveryWeight;
		while(weight>0){
			Drone drone=drones.poll();
			dronesForDelivery.add(drone);
			weight -= drone.getWeightCapacity();
		}
		return dronesForDelivery;
	}
	private boolean canDeliver(Drone drone, int battery, int weight){
		
		return drone.getBatteryUnits()>battery && drone.getWeightCapacity()>weight;		
	}
}
