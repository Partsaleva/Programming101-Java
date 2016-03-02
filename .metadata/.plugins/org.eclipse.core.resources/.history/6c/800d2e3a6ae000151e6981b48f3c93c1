package week1;

/*21. Copy every character K times
String copyEveryChar(String input, int k)
copyEveryChar("tldr", 3) => "tttllldddrrr"*/


public class CopyEveryChar {
	
	public static void main(String[] args) {
		CopyEveryChar str=new CopyEveryChar();
		String input="tldr";
		System.out.println(str.copyEveryChar(input, 3));
	}

	String copyEveryChar(String input, int k){
	
		String result="";
		for(int i=0; i<input.length(); i++){
		
			char ch = input.charAt(i);
			for(int j=0; j<k; j++){		
				//add every char k times to string
				result+=ch;
			}
		}
		return result;
	}
	
}