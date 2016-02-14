package week2;
/*21. Longest subsequence of increasing consecutive elements

Implement the function int maxIncreasingConsecutive(int[] items),
 which takes an array of ints and returns an integer - the count of 
 elements in the longest subsequence of increasing consecutive elements.
For example, in the array [1, 2, 3, 3, 3, 3, 4, 3, 3], the result is 7,
where the longest subsequence is formed by 1, 2, 3, 3, 3, 3, 4*/
public class LongSubseqOfInc {

	public static void main(String[] args) {
		LongSubseqOfInc num=new LongSubseqOfInc();
		int[] test1={1, 2, 3, 3, 3, 3, 4, 3, 3};
		int[] test2={1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5};
		int[] test3={2, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5};
		System.out.println(num.maxIncrConsec(test1));
		System.out.println(num.maxIncrConsec(test2));
		System.out.println(num.maxIncrConsec(test3));
	}

	int maxIncrConsec(int[] sequence){
		int max=0,currMax=1;
		for(int i=0; i<sequence.length-1; i++){
			if(sequence[i]<=sequence[i+1]){
				currMax++;
			}
			else{
				currMax=1;
			}
			if(currMax>max){
				max=currMax;
			}
		}	
		return max;
	}
}
