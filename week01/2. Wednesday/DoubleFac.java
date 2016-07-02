


public class DoubleFac {

	public static void main(String[] args) {
		DoubleFac num=new DoubleFac();
		long s=System.nanoTime();
		System.out.println(num.doubleFac(3));
		long e=System.nanoTime();
		System.out.println(e-s);
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