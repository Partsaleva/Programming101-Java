package week1;
/*30. Vowels in a string
Implement a function, called countVowels(str), which returns the count of all vowels in the string str.
Count uppercase vowels aswell!
The English vowels are aeiouy and their Cappital versions.
Examples:
* countVowels("Java") = 2
* countVowels("Theistareykjarbunga") =  8
* countVowels("grrrrgh!") = 0
* count_vowels("Github is the second best thing that happend to programmers, after the keyboard!") = 22
* count_vowels("A nice day to code!") = 8*/
public class CountVowels {

	public static void main(String[] args) {
		CountVowels str=new CountVowels();
		String[] words= {"Theistareykjarbunga","grrrrgh!","Github is the second best thing that"
				+ " happend to programmers, after the keyboard!","A nice day to code!"};
		
		for(int i=0; i<words.length; i++){			
			System.out.println(str.countVowels(words[i]));
		}
		
	}
	
	public int countVowels(String str){		
		int count=str.toLowerCase().replaceAll("[^aeiouy]","").length();
		return count;
	}
}
