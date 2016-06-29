

public class IsPrime {

	public static void main(String[] args) {
		IsPrime num=new IsPrime();
		//not prime
		System.out.println(num.isPrime(24));
		//prime
		System.out.println(num.isPrime(7));
		//negative (not prime)
		System.out.println(num.isPrime(-7));

	}
	
	public boolean isPrime(int number){
		if (number < 2) {
			return false;
		}
		else{
			int max=(int) Math.sqrt(number);
			for (int i = 2; i < max; i++) {
				if (number % i ==0) {
					return false;
				}
			}
		}
		return true;
	}

}
