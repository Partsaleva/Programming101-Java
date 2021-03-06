package searchingAlgorithms;

import java.util.Arrays;
import java.util.Collections;

import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(5,4,9,7,8,0,3,1,5,4,8,77,41,52,63,25,14,36);
		System.out.println(search(list, 14));
		System.out.println(search(list, 4));
		System.out.println(search(list, 77));
		System.out.println(search(list, 51));

	}

	public static boolean search(List<Integer> list,int x){
		Collections.sort(list);
		int left=0;
		int right=list.size()-1;
		while(left<=right){
			if (list.get(left)==list.get(right)) {
				if (list.get(left)==x) {
					return true;
				} else {
					return false;
				}
			}
			
			int mid=( left + right ) / 2;
			if (x < list.get(mid)) {
				right=mid-1;
			} else if(x > list.get(mid)){
				left=mid+1;
			}else{
				return true;
			}
		}
		return false;
		
	}
	
}
