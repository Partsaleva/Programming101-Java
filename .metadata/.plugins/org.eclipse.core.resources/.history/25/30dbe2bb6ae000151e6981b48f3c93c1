package week1;
/*27. Is an anagram of String A a SUBSEQUENCE in B?
boolean hasAnagramOf(A,B) 
Return whether an anagram of String A can be found in String B.*/
public class HasAnagramOf {

	public static void main(String[] args) {
		HasAnagramOf str=new HasAnagramOf();
		String s="jadg";
		String t="akdsljgfkjdkj";
		//String s="acc";
		//String t="cda";
		System.out.println(str.hasAnagramOf(s, t));

	}

	//if contains all lettes and they are in diff order return true
	boolean hasAnagramOf(String shorter, String longer)
	{
		if(!isSubseq(shorter, longer)&& deleteChars(shorter, longer))
		{
			return true;
		}		
		return false;
	}
	
	//check if is subsequence(if its ordered its not an anagram)
	boolean isSubseq(String shorter, String longer) {
	    int i = 0;
	    for (char c : shorter.toCharArray()) {
	        i = longer.indexOf(c, i) + 1;
	        if (i <= 0)
	        { 
	        	return false;
	        }
	    }
	    return true;
	}
	
	boolean deleteChars(String A, String B)
	{
		StringBuilder stringA = new StringBuilder(A);
		StringBuilder stringB = new StringBuilder(B);
		int index=0;
		for(int i=0; i<stringA.length();i++)
		{
			//find index of B=index of A
			index=stringB.toString().indexOf(stringA.toString().charAt(i));
			//if char is found..
			if(index!=-1){
				//delete char from both strings
				stringA = stringA.deleteCharAt(i);
				stringB = stringB.deleteCharAt(index);
				i--;//and reduce i
			}
			else //if its not found
			{
				return false;
			}
		}
		//if stringA is empty, string B contains all letter from A
		return (stringA.toString().length()==0);
		
		
	}
}