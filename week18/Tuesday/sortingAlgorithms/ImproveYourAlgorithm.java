package sortingAlgorithms;

import java.util.Arrays;

public class ImproveYourAlgorithm {

	public static void main(String[] args) {
		ImproveYourAlgorithm sort=new ImproveYourAlgorithm();
		//int[] arr  = new int[]{2, 5, 9, 7, 1, 14, 56, 11, 4};
		int[] arr  = new int[]{2, 5, 9, 7, 1, 14, 56, 11, 4,
								7,3,7,9,8,13,25,12,71,48,85,18,54,65,25,
								15,69,87,57,25,26,13,65,59,81,32,35,34,37,
								15,69,87,57,25,26,13,65,59,81,32,35,34,37,
								15,69,87,57,25,26,13,65,59,81,32,35,34,37,
								15,69,87,57,25,26,13,65,59,81,32,35,34,37,
								15,69,87,57,25,26,13,65,59,81,32,35,34,37,
								15,69,87,57,25,26,13,65,59,81,32,35,34,37};

		sort.smartSorting(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	public void smartSorting(int[] arr){
		if (arr.length < 33) {
			bubbleSort(arr);
		} else {
			mergeSort(arr, 0, arr.length-1);
		}
	}
	
	public static void bubbleSort(int[] arr){
		for (int i = 0; i < arr.length; i++) {		
			for (int j = 1; j < arr.length-i; j++) {
				
				 if(arr[j-1] > arr[j]){
	                 //swap the elements!
					 swap(j-1, j, arr);	                 
				 }
			}
		}
	}
	
	private static void swap(int a, int b, int[] arr){
		int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
	}
	
	public static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(arr, low, middle);
			mergeSort(arr, middle + 1, high);
			merge(arr, low, middle, high);
		}

	}

	private static void merge(int[] arr , int low, int middle, int high){
		int[] temp=Arrays.copyOf(arr, arr.length);
	
		int i = low;
		int j = middle+1;
		int k=low;
		while(i<=middle && j <= high){
			if (temp[i] <= temp[j]) {
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
