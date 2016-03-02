package week1;

public class HackNumbers {

	public static void main(String[] args) {
		HackNumbers num= new HackNumbers();
		//isHack(1)= True //isHack(21);= True //isHack(8191)// = True
		//nextHack(10); = 21 //nextHack(0);// = 1 //nextHack(8031);// = 8191
		//int[] numbers={1,21,8191,8};
		int[] numbers={10,0,8031};
		for(int i=0; i<numbers.length; i++){
			System.out.println(num.isHack(numbers[i]));
			System.out.println(num.nextHack(numbers[i]));
		}
	}
	
	boolean isHack(int number){
		//number to binary string
		String hackNum=Integer.toBinaryString(number);
		//check if is palindrom
		boolean palindrom=hackNum.equals(new StringBuffer().append(hackNum).reverse().toString());
		//remove all zeroes
		hackNum=hackNum.replaceAll("0","");
		
		return palindrom && (hackNum.length()%2==1);
		
	}
	
	long nextHack(int number){
		//start from next number
		for(int i=number+1;;i++){
			//if its hack num return the number
			if(isHack(i)){
				return i;
			}
		}
	}
	
}


