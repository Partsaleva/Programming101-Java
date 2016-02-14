package week1;

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
	
	public boolean isPrime(int number)
	{
		//only positive numbers can be prime
		if(number<2)
		{
			return false;
		}
		else
		{
			//we need to check only to sqrt of num
			double max=Math.sqrt(number);
			int i = 2;
			if (number == 2)
			{
			    return true;
			}
			while (i <= max)
			{
				//if we can divide number return false
				if (number % i == 0)
				{
					return false;
				}
				i++;
			}
		}
		return true;	
	}

}