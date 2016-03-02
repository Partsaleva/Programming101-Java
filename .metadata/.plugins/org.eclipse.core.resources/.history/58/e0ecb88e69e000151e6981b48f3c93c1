package week1;
/*31. Consonants in a string
Implement a function, called countConsonants(str), which returns the count of all consonants in the string str.
Count uppercase consonants as well!
The English consonants are bcdfghjklmnpqrstvwxz.
*/
public class CountConsonants {

	public static void main(String[] args) {
		CountConsonants  str=new CountConsonants ();
		String[] words= {"Theistareykjarbunga","grrrrgh!","Github is the second best thing that"
				+ " happend to programmers, after the keyboard!","A nice day to code!"};
		
		for(int i=0; i<words.length; i++){		
			System.out.println(str.countConsonants(words[i]));
		}
		
		
	}
	
	public int countConsonants(String str){
		//replace all Non-word characters and subtract vowels
		int count=str.replaceAll("[^A-Za-z0-9_]", "").length()
				-str.toLowerCase().replaceAll("[^aeiouy]","").length();
		return count;
	}

}
