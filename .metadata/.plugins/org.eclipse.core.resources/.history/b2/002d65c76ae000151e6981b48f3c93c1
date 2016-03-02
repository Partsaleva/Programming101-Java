package week1;

public class IsIntPalindrome {

	public static void main(String[] args) {
		IsIntPalindrome num=new IsIntPalindrome();
		int num1=123;
		int num2=12321;
		System.out.println(num.intPalindrome(num1));
		System.out.println(num.intPalindrome(num2));

	}
	
	boolean intPalindrome(int n){
		//convert integer to string
		String s=Integer.toString(n);
		//compare original and reversed string
		return s.equals(new StringBuffer().append(s).reverse().toString());

	}

}