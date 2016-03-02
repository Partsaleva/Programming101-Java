
/*2. Palindrome Score
We denote the "Palindrome score" of an integer by the following function:
P(n) = 1, if n is palindrome
P(n) = 1 + P(s) where s is the sum of n and the reverse of n
Implement a function, called pScore(n), which finds the palindrome score for n.
P(48) = 1 + P(48 + 84) = 132
P(132) = 1 + 1 + P(132 + 231 = 363)
P(363) = 1. */

public class PalindromeScore {

	public static void main(String[] args) {
		PalindromeScore num= new PalindromeScore();
		int[] arr={121,48,198};
		for(int i=0; i<arr.length; i++){
			System.out.println(num.pScore(arr[i]));
		}
        //System.out.println(num.reverseInt(48));
	}
	
	public long pScore(int n){
		if(isPalindrome(n)){
			return 1;
		}
		else{
			return 1+ pScore(n + reverseInt(n));
		}
	}
	
	//check if is palindrome
	public boolean isPalindrome(int n){
		String s=Integer.toString(n);
		return s.equals(new StringBuffer().append(s).reverse().toString());

	}
	
	public int reverseInt(int input){
		int reverse=0;
		while (input != 0) {
		    reverse = reverse * 10 + input % 10;
		    input = input / 10;   
		}
		return reverse;
	}

}