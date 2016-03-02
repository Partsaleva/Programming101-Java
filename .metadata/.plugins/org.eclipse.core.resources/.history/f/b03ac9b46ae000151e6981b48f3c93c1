package week1;
/*22. Check for palindrome length around '*'
int getPalindromeLength(String input)
getPalindromeLength("taz*zad") => 2*/
public class GetPalindromeLength {

	public static void main(String[] args) {
		GetPalindromeLength str=new GetPalindromeLength();
		String input="ataz*zada";
		System.out.println(str.getPalindromeLength(input));
	}
	
	int getPalindromeLength(String input)
	{
		//split to and from '*' 
		String[] parts = input.split("\\*");
		int count=0;
		//reverse first string
		String first=new StringBuffer(parts[0]).reverse().toString();
		//second is the same
		String second=parts[1];
		for(int i=0; i<first.length();i++)
		{
			char a=first.charAt(i);
			char b=second.charAt(i);
			//if are the same keep counting
			if(a==b)
			{
				count++;
			}else{
				//if there is a diff return count(we can have more but its not palindrome)
				return count;
			}
		}
		return count;
	}

}