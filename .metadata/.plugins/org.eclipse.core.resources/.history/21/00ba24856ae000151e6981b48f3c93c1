package week1;

import java.util.stream.IntStream;

/*15. Can balance?
boolean canBalance(int[] numbers)
canBalance({1, 1, 1, 2, 1}) -> true canBalance({2, 1, 1, 2, 1})->  false canBalance({10, 10}) -> true
Return true if there is an element in the array, where you can split the array in half and the sum
 of left side would be equal to the sum of the right part.*/
public class CanBalance {

	public static void main(String[] args) {
		CanBalance num=new CanBalance();
		//can be balanced
		int[] a={1, 1, 1, 2, 1};
		//cant be bananced
		int[] b={2, 1, 1, 2, 1};
		
		System.out.println(num.canBalance(a));
		System.out.println(num.canBalance(b));

	}
	
	boolean canBalance(int[] numbers){
		int first=0;
		//sum array
		int second=IntStream.of(numbers).sum();
		for(int i=0;i<numbers.length;i++){
			
			//accumulate numbers
			first+=numbers[i];
			//sum - every number
			second-=numbers[i];
			if(first==second){
				return true;
			}
		}
		return false;
	}
}

