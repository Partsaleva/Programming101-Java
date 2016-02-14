package week1;

public class WordFromAnBn {

	
	public static void main(String[] args) {
		WordFromAnBn word=new WordFromAnBn();
		String[] test={"","hack","aaabb","aaabbb","aabbaabb","bbbaaa","aaaaabbbbb"};
		for(int i=0;i<test.length;i++){
			System.out.println(word.is_an_bn(test[i]));
		}
	}

	public boolean is_an_bn(String number){
		if(number.length()%2!=0){
			return false;
		}
		char a='a'; int countA=0;
		char b='b'; int countB=0;
		int half=number.length()/2;
		for(int i=0; i<number.length();i++){
			while(i<half){			
				if(number.charAt(i)==a){
					countA++;
					i++;
				}else return false;
			}
			if(number.charAt(i)==b){
				countB++;
			}else return false;
		}
		return countA==countB;
	}
}