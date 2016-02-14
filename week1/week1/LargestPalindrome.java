package week1;
/*9. Find the largest integer palindrome number up to N
long getLargestPalindrome(long N);
1234321 is a palindrome. You are given a number => N. Find the 
largest number < N, that is a palindrome.
Bonus do this without using Collections.sort*/
public class LargestPalindrome {

	public static void main(String[] args) {
		LargestPalindrome num=new LargestPalindrome();
		System.out.println(num.getLargestPalindrome(1234371));

	}
	
	long getLargestPalindrome(long N){
		//start from the end
		for (long i = N; i>0; i--)
		{
			if (isPalindrome(i)){
				return i;
			}
		}
		return 1;
	}
	
	
	boolean isPalindrome(long n){
		//long to string
		String s=Long.toString(n);
		//check if string is eq to reversed string
		return s.equals(new StringBuffer().append(s).reverse().toString());

	}
	

}