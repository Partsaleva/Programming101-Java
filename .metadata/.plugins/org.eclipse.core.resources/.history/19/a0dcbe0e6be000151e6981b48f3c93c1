package week1;
/*25. Sum all the numbers in a String
int sumOfNumbers(String input)
Sum all of the numbers in the String. Ignore the characters. 
sumOfNumbers("abc123dd34") => 157 sumOfNumbers("12 99 1) => 112*/
public class SumOfNumbers {

	public static void main(String[] args) {
		SumOfNumbers str=new SumOfNumbers();
		String test1="abc123dd34";
		String test2="12 99 1";
		
		System.out.println(str.sumOfNumbers(test1));
		System.out.println(str.sumOfNumbers(test2));
	}
	
	int sumOfNumbers(String input)
	{
		String[] numbers=input.split("\\D");
		int sum = 0;
		for(int i=0;i<numbers.length;i++){
		    try{
		        sum+=Integer.parseInt(numbers[i]);
		    }
		    catch( Exception e ) {
		         //Just in case, the element in the array is 
		    	//not parse-able into Integer, Ignore it
		    }
		}
		return sum;
	}

}