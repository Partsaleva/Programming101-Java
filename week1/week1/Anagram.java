package week1;

import java.util.Arrays;

/*26. Is String A an anagram of String B?
boolean anagram(String A, String B) 
See http://en.wikipedia.org/wiki/Anagram
No HashMaps, hashSets, or such stuff allowed : )*/
public class Anagram {

	public static void main(String[] args) {
		Anagram str=new Anagram();
		//test1- same number of spaces
		String s1="Arrigo Boito";
		String s2="Tobia Gorrio";
		
		//test2- diff number of spaces
		String s3="Anna Madrigal";
		String s4="A man and a girl";
		
		//test3- empty strings(not anagram)
		String s5="";
		String s6="";
		
		System.out.println(str.anagram(s1, s2));
		System.out.println(str.anagram(s3, s4));
		System.out.println(str.anagram(s5, s6));
		

	}
	boolean anagram(String A, String B){
		//remove all empty spaces
		A=A.replaceAll("\\s+","");
		B=B.replaceAll("\\s+","");
		//compare size 
		if(A.length()!=B.length()){
			return false;
		}
		else{
			//if strings are eq, but empty- return false
			if(A.length()==0&&B.length()==0){
				return false;
			}
			//convert to lower case, sort and compare
	        char[] str1 = A.toLowerCase().toCharArray();
	        char[] str2 = B.toLowerCase().toCharArray();
	        Arrays.sort(str1); 
	        Arrays.sort(str2);
	        String sorted1 = new String(str1);
	        String sorted2 = new String(str2);
	        if(sorted1.equals(sorted2)){
	        	return true;
	        }

		}
		return false;
	}
}