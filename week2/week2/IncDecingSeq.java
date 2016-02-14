package week2;
/*19. Increasing and Decreasing Sequences
Implement the following functions:
boolean IsIncreasing(int[] sequence) which returns true if for every two consecutive elements a and b, a < b holds.
boolean IsDecreasing(int[] sequence) which returns true if for every two consecutive elements a and b, a > b holds.*/
public class IncDecingSeq {

	public static void main(String[] args) {
          IncDecingSeq num=new IncDecingSeq();
          int[] test1={1,2,3,5,9,10};//incr
          int[] test2={10,9,7,5,4,3};//decr
          int[] test3={5,6,4,8,9};
          int[] test4={2};
          System.out.println(num.isIncreasing(test1));
          System.out.println(num.isIncreasing(test2));
          System.out.println(num.isIncreasing(test3));
          System.out.println(num.isIncreasing(test4));
          System.out.println();
          System.out.println(num.isDecreasing(test1));
          System.out.println(num.isDecreasing(test2));
          System.out.println(num.isDecreasing(test3));
          System.out.println(num.isDecreasing(test4));
          
        
  
	}

	boolean isIncreasing(int[] sequence){
		
		for (int i = 0; i < sequence.length-1; i++){
			if (sequence[i]>=sequence[i+1])
				return false;
		}
		return true;
	} 
	
	boolean isDecreasing(int[] sequence){
		
		for (int i = 0; i < sequence.length-1; i++){
			if (sequence[i]<=sequence[i+1])
				return false;
		}
		return true;
	}
}
