package week1;
/*38. Zero Insertion
Given an integer, implement the function int zero_insert(int n), which returns a new int,
 constructed by the following algorithm:
If two neighboring digits are the same (like 55), insert a 0 between them (505)
Also, if we add two neighboring digits and take their module by 10 (% 10) and the result is 0 - add 0 between them.
For example, if we have the number 116457, result will be: 10160457:

1 and 1 are the same, so we insert 0 between them
6 + 4 % 10 = 0, so we insert 0 between them.*/
public class ZeroInsertion {

	public static void main(String[] args) {
		ZeroInsertion num=new ZeroInsertion();
		int[] test={116457,55555555,1,6446};
		
		for(int i=0; i<test.length; i++){
			
			System.out.println(num.zeroInsert(test[i]));
		}	
		
	}

	String zeroInsert(int number){
		String num=Integer.toString(number);
		String result="";
		for(int i=0; i<num.length()-1; i++){
			if(num.length()==0){
				result+=num.charAt(0);
			}
			else if(num.charAt(i)==num.charAt(i+1)||
					((Character.getNumericValue(num.charAt(i))+Character.getNumericValue(num.charAt(i+1)))%10==0)){
				result+=num.charAt(i);
				result+='0';
			}
			else{
				result+=num.charAt(i);
			}
		}
		return result+=num.charAt(num.length()-1);
	}
}