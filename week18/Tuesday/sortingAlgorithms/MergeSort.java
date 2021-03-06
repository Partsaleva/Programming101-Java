package sortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr  = new int[]{2, 5, 9, 7, 1, 14, 56, 11, 4, 7};
		mergeSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	public static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(arr, low, middle);
			mergeSort(arr, middle + 1, high);
			merge(arr, low, middle, high);
		}

	}

	public static void merge(int[] arr , int low, int middle, int high){
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
