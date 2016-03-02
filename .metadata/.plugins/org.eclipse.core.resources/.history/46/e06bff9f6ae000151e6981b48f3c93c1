package week1;
/*24. Decode an URL
Input 'kitten%20pic.jpg' 
Output 'kitten pic.jpg' %20=>' ' %3A=>':' %3D=>'?' %2F=>'/' 
String decodeUrl(String input)
*/

//import java.io.UnsupportedEncodingException; 

public class DecodeUrl {

	public static void main(String[] args){
		DecodeUrl str=new DecodeUrl();
		String input="%3Dkitten%20pic%3A.%2Fjpg";
		System.out.println(str.decodeUrl(input));

	}
	String decodeUrl(String input) 
	{
		//array to hold replacements
		String[][] replacements = {{"%20", " "}, {"%3A", ":"}, {"%3D","?"}, {"%2F","/"}};

		//loop over the array and replace
		String decoded = input;
		for(String[] replacement: replacements) {
		    decoded = decoded.replace(replacement[0], replacement[1]);
		}

		return decoded;
	}
	
	//ready function 
	/*String decodeUrl(String url) throws UnsupportedEncodingException 
	{
		String decoded = java.net.URLDecoder.decode(url, "UTF-8");
		return decoded;
	}*/

}