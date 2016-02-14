package week2;

import java.util.HashSet;

/*22. Unique words
Implement a function, called int uniqueWordsCount(String[] arr) which returns the number of different words in arr.
Test examples
uniqueWordsCount(new String[] {"apple", "banana", "apple", "pie"}) == 3
uniqueWordsCount(new String[] {"java", "java", "java", "android"}) == 2
uniqueWordsCount(new String[] {"HELLO!", "HELLO!", "HELLO!" "HELLO!"}) == 1*/
public class UniqueWords {

	public static void main(String[] args) {
		UniqueWords words=new UniqueWords();
		String[] test1= {"apple", "banana", "apple", "pie"};
		String[] test2= {"java", "java", "java", "android"};
		String[] test3= {"HELLO!", "HELLO!", "HELLO!" ,"HELLO!"};
		System.out.println(words.uniqueWordsCount(test1));
		System.out.println(words.uniqueWordsCount(test2));
		System.out.println(words.uniqueWordsCount(test3));

	}

	int uniqueWordsCount(String[] words){
		HashSet<String> noDupSet = new HashSet<String>();
		for(int i=0; i<words.length;i++){
			noDupSet.add(words[i]);
		}
		return noDupSet.size();
	}
}
