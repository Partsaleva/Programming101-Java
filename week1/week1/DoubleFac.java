package week1;


public class DoubleFac {

	public static void main(String[] args) {
		DoubleFac num=new DoubleFac();
		System.out.println(num.doubleFac(3));
	}
	
	//call factorial twice
	long doubleFac(int n)
	{
		n=factorial(factorial(n));
		return n;
	}
	
	
	int factorial(int n)
	{
		int fact=n;
		if(n>1){		
			while(n!=1){
				fact=fact*(n-1);
				n--;		
			}
		}else{
			fact=1;
		}
		return fact;
	}
	
}