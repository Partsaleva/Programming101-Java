package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {
		List<Integer>a=Arrays.asList(2,5,9,7,1,14,56,11,4,7);
		System.out.println(mergeSort(a, 0, a.size()-1));
		

	}

	

	public static List<Integer> mergeSort(List<Integer> A , int begin, int end){
		if(end - begin < 2){
			 return A; 
		}                                                  
	    
	    int middle = (end + begin) / 2;              
	    mergeSort(A, begin,  middle);  
	    mergeSort(A, middle, end);  
	    return merge(A, begin, middle, end);
	    
	}
	
	
	public static List<Integer> merge(List<Integer> A , int begin, int middle, int end){
		int iBegin=begin;
		int iMid=middle;
		List<Integer> B=new ArrayList<Integer>();
		
		for (int i = iBegin; i < end; i++){
			
			if (iBegin < iMid && (A.get(iMid) >= A.get(end) || A.get(iBegin)< A.get(iMid))) {
				
				B.add(A.get(iBegin));
				iBegin++;
				
			}else{
				
				B.add(A.get(iMid));
				iMid++;
			}
		}
		System.out.println(B);
		return B;
	}
}
