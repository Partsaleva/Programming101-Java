package bonusTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Cook {

	public static void main(String[] args) {
		
		
			test();
		
		
		
	
		
		
		
	}

	public static void test(){
		List<Integer> timesForHotPlates=new ArrayList<Integer>();
		int mekitsi; 
		int hotPlates; 
		String timesString;
		Scanner scanInt=new Scanner(System.in);
		
		System.out.print("Mekitsi: ");
		// TODO check input 0 < x <1015
		mekitsi=scanInt.nextInt();
		//// TODO check input 0 < x < 20
		System.out.print("hot plates: ");
		hotPlates=scanInt.nextInt();
		
		
		
		//// TODO check input < 500
		Scanner scanStr=new Scanner(System.in);
		System.out.print("times for hot plates: ");
		timesString=scanStr.nextLine();
		String[] times=timesString.split(" ");
		
		for (int i = 0; i < hotPlates; i++) {
			timesForHotPlates.add(Integer.parseInt(times[i]));
		}
		Collections.sort(timesForHotPlates);
		System.out.println(calculateTime(timesForHotPlates, mekitsi, hotPlates));
		 
		scanInt.close();
		scanStr.close();
		
		
		
	}
	
	private static int calculateTime(List<Integer> timesForHotPlates, int mekitsi, int hotPlates){
		//int mek=mekitsi;
		int minTime=0;
		for (int i = 0; i < timesForHotPlates.size(); i++) {
			
		}
		return minTime;
		
	}
	
	
}
