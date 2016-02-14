package generics;

public class IsPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("12321"));
		System.out.println(isPalindrome(1232));
	}

	public static <T extends Object>boolean isPalindrome(T argument)
	{	
		String s=argument.toString();
		return s.equals(new StringBuffer().append(s).reverse().toString());		
	}
}
