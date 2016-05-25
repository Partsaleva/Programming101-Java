package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort {

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(3,4,8,1,14,25,13);
		System.out.println(countSort(list,1, 25));

	}

	public static List<Integer> countSort(List<Integer> list, int min, int max) {
		int[] cnt=new int[max - min];
		List<Integer> sortedList=new ArrayList<>();
		
		for (int i = min; i < max-min; i++) {
			cnt[list.get(i)]++;	
		}
	
		    
		for (int i = cnt.length-1; i >0; i--) {
			int j=cnt[i];
			while(j!=0){
				sortedList.add(i);
				j--;
			}
		}

		return sortedList;
	}

}
