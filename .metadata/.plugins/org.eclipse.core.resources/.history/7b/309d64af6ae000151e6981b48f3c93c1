package week1;
/*12. Find the only number, that occurs odd times in an array
int getOddOccurrence(int... array)
Every element in array will occur an even ammount of times. 
There will be exactly one element Example:
{1,2,2,1,3,4,3,4,4,6,5,6,5} => 4 occurs only an odd number of times.*/

public class GetOddOccurrence {

	public static void main(String[] args) {
		GetOddOccurrence num=new GetOddOccurrence();
		int[] arr=new int[]{1,2,2,1,3,4,3,4,4,6,5,6,5};
		
		System.out.println(num.getOddOccurrence(arr));

	}
	int getOddOccurrence(int arr[]){
	     int res = 0; 
	     for (int i=0; i < arr.length; i++)
	     {
	    	 //using XOR: number+same number=0
	    	 //works for every number but if its only one
	        res = res ^ arr[i];
	     }	      
	     return res;
	}

}