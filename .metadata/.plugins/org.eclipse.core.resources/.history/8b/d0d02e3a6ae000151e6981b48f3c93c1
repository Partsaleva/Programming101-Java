package week1;
/*18. Reverse each word in a String
String reverseEveryChar(String arg)
reverseEveryChar("What is this") => tahW si siht*/
public class ReverseEveryWord {

	String reverseEveryWord(String arg)
	{
		String[] parts = arg.split(" ");
		String result=new StringBuffer(parts[0]).reverse().toString();
		for (int i=1; i<parts.length; i++)
		{
			String reverse=new StringBuffer(parts[i]).reverse().toString();
			result+=" "+reverse;
		}
		return result;
	}
	public static void main(String[] args) {
		ReverseEveryWord str=new ReverseEveryWord();
		String s="Mariana Partsaleva";
		System.out.println(str.reverseEveryWord(s));
	}

}