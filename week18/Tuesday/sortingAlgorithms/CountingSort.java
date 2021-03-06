package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort {

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(3,4,8,1,14,25,13);
		System.out.println(countSort(list));

	}

	public static List<Integer> countSort(List<Integer> list) {
		int min = list.get(0);
		int max = list.get(0);
	    for (int i = 1; i < list.size(); i++) {
	        if (min > list.get(i)){
	        	min = list.get(i);
	        }
	        
	        if (max < list.get(i)){
	        	max =list.get(i);
	        }
	        
	    }
	    
		int[] cnt=new int[max - min + 2];
		List<Integer> sortedList=new ArrayList<>();
		
		for (int i = min; i < list.size(); i++) {
			cnt[list.get(i) - min]++;	
		}
	
		    
		for (int i = cnt.length-1; i >0; i--) {
			int j=cnt[i];
			while(j!=0){
				sortedList.add(i + min);
				j--;
			}
		}

		return sortedList;
	}

}
