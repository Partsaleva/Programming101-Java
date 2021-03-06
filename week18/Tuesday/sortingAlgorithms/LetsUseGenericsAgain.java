package sortingAlgorithms;

import java.util.Arrays;

public class LetsUseGenericsAgain {

	public static void main(String[] args) {
		Integer[] arr  = {2, 5, 9, 7, 1, 14, 56, 11, 4,
				7,3,7,9,8,13,25,12,71,48,85,18,54,65,25,
				15,69,87,57,25,26,13,65,59,81,32,35,34,37,
				15,69,87,57,25,26,13,65,59,81,32,35,34,37,
				15,69,87,57,25,26,13,65,59,81,32,35,34,37,
				15,69,87,57,25,26,13,65,59,81,32,35,34,37,
				15,69,87,57,25,26,13,65,59,81,32,35,34,37,
				15,69,87,57,25,26,13,65,59,81,32,35,34,37};

		genericSort(arr);
		for (int T : arr) {
			System.out.print(T + " ");
		}

	}

	public static <T extends Comparable<T>> void genericSort(T[] arr){
		if (arr.length < 33) {
			bubbleSort(arr);
		} else {
			mergeSort(arr, 0, arr.length-1);
		}
	}
	
	public static <T extends Comparable<T>> void bubbleSort(T[] arr){
		for (int i = 0; i < arr.length; i++) {		
			for (int j = 1; j < arr.length-i; j++) {
				
				 if(arr[j-1].compareTo(arr[j]) >0){
	                 //swap the elements!
					 swap(j-1, j, arr);	                 
				 }
			}
		}
	}
	
	private static <T extends Comparable<T>> void swap(int a, int b, T[] arr){
		T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
	}
	
	public static <T extends Comparable<T>> void mergeSort(T[] arr, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(arr, low, middle);
			mergeSort(arr, middle + 1, high);
			merge(arr, low, middle, high);
		}

	}

	private static <T extends Comparable<T>> void merge(T[] arr , int low, int middle, int high){
		T[] temp=Arrays.copyOf(arr, arr.length);
	
		int i = low;
		int j = middle+1;
		int k=low;
		while(i<=middle && j <= high){
			if (temp[i].compareTo(temp[j]) <0 || temp[i].compareTo(temp[j]) ==0) {
				arr[k]=temp[i];
				++i;
			} else {
				arr[k]=temp[j];
				++j;
			}
			++k;
		}
		
		while(i <= middle){
			arr[k]=temp[i];
			++k; ++i;
		}
	}
}
