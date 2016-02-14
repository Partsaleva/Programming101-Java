package week1;

public class IsOdd {
	
	public static void main(String[] args) {
		
		IsOdd num=new IsOdd();
		System.out.println(num.isOdd(3));
		System.out.println(num.isOdd(4));
		System.out.println(num.isOdd(0));
		System.out.println(num.isOdd(-3));
	}
	
	public boolean isOdd(int n){
		return Math.abs(n)%2==1;
	}

}