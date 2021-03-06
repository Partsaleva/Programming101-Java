package pointCalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



public class PointCalculator {

	public static void main(String[] args) {
		generatePoints();
		getNearestPoints();
		for (Point key : nearestPoints.keySet()) {
			System.out.println(key.toString() + " nearest is " + nearestPoints.get(key).toString());
		}

	}

	private static List<Point> listOfPoints = new ArrayList<>();
	private static Map<Point,Point> nearestPoints=new HashMap<>();

	public static List<Point> generatePoints() {
		Random random = new Random();
		while(listOfPoints.size()<100000){
			listOfPoints.add(new Point(random.nextInt(10001),random.nextInt(10001)));
		}
		return listOfPoints;
	}
	
	static void getNearestPoints(){
		Thread tr1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					doCalculations(listOfPoints, 0, 25000,nearestPoints);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		
        Thread tr2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					doCalculations(listOfPoints, 25000, 50000,nearestPoints);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
        
        Thread tr3=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					doCalculations(listOfPoints, 50000, 75000,nearestPoints);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
        
   Thread tr4=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					doCalculations(listOfPoints,75000,100000,nearestPoints);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		tr1.start();tr2.start();tr3.start();tr4.start();	
		try {
			tr1.join();
			tr2.join();
			tr3.join();
			tr4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static double doCalculations(List<Point> inPoints, int indexFrom, int indexTo, Map<Point, Point> outMap)throws InterruptedException{
		Point target = null;
		double minDistance=0;
		double current=0;
		for(int i=indexFrom; i<indexTo; i++){
			minDistance=10000;
			for(int j=indexFrom+1; j<indexTo-1;j++){
				current=inPoints.get(i).calculateDist(inPoints.get(j));
				
				if(current < minDistance){
					minDistance = current;
					target=inPoints.get(j);
				}
			}
			outMap.put(inPoints.get(i), target);
		}
		return indexTo;}
	
	
}
