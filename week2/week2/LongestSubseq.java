package week2;
/*20. Longest subsequence of equal consecutive elements
Implement the function int maxEqualConsecutive(int[] items), which takes an array of ints and returns an integer - the count of elements in the longest subsequence of equal consecutive elements.
For example, in the array [1, 2, 3, 3, 3, 3, 4, 3, 3], the result is 4, where the longest subsequence is formed by 3, 3, 3, 3
Test examples::
maxEqualConsecutive(new int[] {1, 2, 3, 3, 3, 3, 4, 3, 3}) == 4
maxEqualConsecutive(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5}) == 3*/
public class LongestSubseq {

	public static void main(String[] args) {
		LongestSubseq seq=new LongestSubseq();
		int[] test1={1, 2, 3, 3, 3, 3, 4, 3, 3};
		int[] test2={1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5};
		System.out.println(seq.maxEqualConsecutive(test1));
		System.out.println(seq.maxEqualConsecutive(test2));

	}

	
	int maxEqualConsecutive(int[] sequence){
		int max=0,currMax=1;
		for(int i=0; i<sequence.length-1; i++){
			if(sequence[i]==sequence[i+1]){
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
