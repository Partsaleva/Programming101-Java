package week1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*23. Count number of (non-overlapping) occurences
int countOcurrences(String needle, String haystack)
 countOcurrences("da", "daaadaadada") => 4*/
public class CountOcurrences {

	public static void main(String[] args) {
		CountOcurrences str=new CountOcurrences();
		String needle="da", haystack="daaadaadada";
		System.out.println(str.countOcurrences(needle, haystack));
	}
	
	int countOcurrences(String needle, String haystack){
		int count=0;
		//regex 
	    Pattern pattern = Pattern.compile(needle);		    
	    Matcher m = pattern.matcher(haystack);
	    // if needle is found count++
	    while (m.find()){
	    	count +=1;
	    }
	    return count;
	}
	
}