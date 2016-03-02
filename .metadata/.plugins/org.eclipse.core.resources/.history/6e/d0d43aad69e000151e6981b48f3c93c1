package week1;

import java.util.ArrayList;
import java.util.List;


public class HundredSMS {

	
	public static void main(String[] args) {
		HundredSMS sms=new HundredSMS();
		int[] arr={2, -1, 2, 2, -1, 2, 2, 2};
		int[] arr1={1, 4, 4, 4, 8, 8, 8, 6, 6, 6, 0, 3, 3, 0, 1, 7, 7, 7, 7, 7, 2, 6, 6, 3, 2};
		System.out.println(sms.numbersToMessage(arr));
		System.out.println(sms.numbersToMessage(arr1));
		System.out.println(sms.messageToNumbers("Ivo e panda"));
		System.out.println(sms.messageToNumbers("aabbcc"));
		System.out.println(sms.messageToNumbers("dempq"));
	}
		
	

	String numbersToMessage(int[] pressedSeq){
		String[] letters={"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		int index=0;
		String result="", s="";
		boolean flag=false;
		for(int i=0; i<pressedSeq.length; i++){
			if(pressedSeq[i]>1&&pressedSeq[i]<10){	
				 s=letters[pressedSeq[i]-2];
				while((i<pressedSeq.length-1) &&(pressedSeq[i]==pressedSeq[i+1])){
					index++;i++;
					if(index==s.length()){
						index=0;
					}				
				}
				if(flag){
					result+=s.toUpperCase().charAt(index);
					flag=false;
				}else{
					result+=s.charAt(index);
				}
				index=0;
			}
			else if(pressedSeq[i]==0){
				result+=" ";
			}
			else if(pressedSeq[i]==1){
				flag=true;
			}
		}
		return result;
	}
	
	
	List<Integer> messageToNumbers(String message){
		List<Integer> result = new ArrayList<Integer>();
		String[] letters={"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		char s=' ';int indStr=-1;
		for(int i=0; i<message.length();i++){
			s=message.charAt(i);
			if(s>='A'&& s<='Z'){
				
				result.add(1);
				s=message.toLowerCase().charAt(i);
			}
			if(s==' '){
				result.add(0);
			}
			else{			
				for(int j=0; j<letters.length;j++){	
					int index=letters[j].indexOf(s);
					if(index>=0&&index<letters.length){
						if(indStr==j){
							result.add(-1);
						}
						indStr=j;
						while(index>=0){						
							result.add(j+2);
							index--;
						}
						break;						
					}										
				}				
			}		
		}
		return result;
	}
	
}
	
