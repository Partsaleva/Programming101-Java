package week1;


//7. Kth factorial

//long kthFac(int k, int n); Get the kthFactorial
//of n. k is guaranteed to be positive. Bonus no "helper" methods, 
//no recursion :)
public class KthFac {
	
	public static void main(String[] args) {		
		KthFac num=new KthFac();		
		System.out.println(num.kthFac(2,3));
	}

	long kthFac(int k, int n)
	{
		long x1 = n;
		for (int i = 0; i <k; i++)
		{
			x1 = factorial(x1);
		}
		return x1;
	}
	
	
	long factorial(long x1)
	{
		long fact = x1;
		if (x1>1)
		{
			while (x1 != 1)
			{
				fact = fact*(x1 - 1);
				x1--;
			}
		}
		else 
		{
			fact = 1;
		}
		return fact;
	}
	
}