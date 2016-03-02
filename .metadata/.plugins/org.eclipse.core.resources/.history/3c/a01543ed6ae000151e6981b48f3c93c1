package week1;
/*11. Raise an integer to a power of another
long pow(int a, int b)
Write a O(log(b)) solution.*/

public class Pow {

	long custPow(int a, int b)
	{
		 int result = 1;
		    while (b!=0)
		    {
		        if ((b & 1)!=0)
		        {
		            result *= a;
		        }
		        b = b >> 1;
		        a *= a;
		    }

		    return result;
	}
	public static void main(String[] args) {
		Pow number=new Pow();
		System.out.println(number.custPow(2,3));
		System.out.println(number.custPow(2,5));
		
		System.out.println(number.custPow(0,5));
		System.out.println(number.custPow(5,0));

	}

}