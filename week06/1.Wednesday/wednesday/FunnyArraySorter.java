package wednesday;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FunnyArraySorter {

	public static void main(String[] args) {
		FunnyArraySorter sort=new FunnyArraySorter(5);
		Integer[] values = { 1, 10, 5,13,18,3, 7 };
		List<Integer> list = Arrays.asList(values);
		
		sort.pivotDivisionSort(list);
		System.out.println(list);
		
		sort.pivotSubtractionSort(list);
		System.out.println(list);
	}

	private int pivot;
	
	public FunnyArraySorter(Integer pivot){
		this.pivot=pivot;
	}
	public void incrementP() {
		pivot++;
	}
	
    public void reverseSort(ArrayList<Integer> list){
    	class ReverseComperator implements Comparator<Integer>{
//(a>b iff a-pivot>b, a=b iff a-pivot=b)
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1-pivot > o2) {
					return -1;
				} else if (o1-pivot == o2) {
					return 0;
				}
				return 1;
			}
		}
    	Collections.sort(list, new ReverseComperator());
    }

//a>b iff a/pivot>b, a=b iff a/pivot=b)
	public void pivotSubtractionSort(List<Integer> list) {
		class PivotSubComperator implements Comparator<Integer> {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1/pivot > o2) {
					return 1;
				} else if (o1/pivot == o2) {
					return 0;
				}
				return -1;
			}
		}
		Collections.sort(list, new PivotSubComperator());
	}
	
	public void pivotDivisionSort(List<Integer> list) {
		class PivotDivComperator implements Comparator<Integer> {
			@Override
			public int compare(Integer o1, Integer o2) {
				incrementP();
				if(o1 / pivot < o2) {
					return -1;
				} else if (o1 - pivot == o2) {
					return 0;
				}
				return 1;
			}
		}
		Collections.sort(list, new PivotDivComperator());
	}
	
}
