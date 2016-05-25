package bonusTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Cook {

	public static void main(String[] args) {
		int testExample;
		try(Scanner scanner=new Scanner(System.in)){
			testExample=scanner.nextInt();
		}
		
	
		for (int i = 0; i < testExample; i++) {
			test();
		}
		
		
	}

	public static void test(){
		List<Integer> timesForHotPlates=new ArrayList<Integer>();
		int mekitsi; 
		int hotPlates; 
		String[] times;
		try(Scanner scanner=new Scanner(System.in)){
			System.out.print("Mekitsi: ");
			// TODO check input 0 < x <1015
			mekitsi=scanner.nextInt();
			//// TODO check input 0 < x < 20
			System.out.print("hot plates: ");
			hotPlates=scanner.nextInt();
			//// TODO check input < 500
			System.out.print("times for hot plates: ");
			times=scanner.nextLine().split(" ");
		}
		
		for (int i = 0; i < hotPlates; i++) {
			timesForHotPlates.add(Integer.parseInt(times[i]));
		}
		Collections.sort(timesForHotPlates);
		System.out.println(calculateTime(timesForHotPlates, mekitsi, hotPlates));
		
	}
	
	private static int calculateTime(List<Integer> times, int mekitsi, int hotPlates){
		//TODO implement
		return hotPlates;
		
	}
}
