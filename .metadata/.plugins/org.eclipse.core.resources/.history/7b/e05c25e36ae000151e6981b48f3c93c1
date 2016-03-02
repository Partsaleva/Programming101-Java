package week1;

import java.util.Arrays;

/*13. Maximal scalar product long maximalScalarSum(int[] a, int[] b) 
You are given two vectors, a and b. Let a be {a1,a2,a3} and b be {b1,b2,b3}. 
The scalar product of vectors a and b is the number a1*b1 + a2*b2 + a3*b3
Find a permutation of a, and a permutation of b,
for which their scalar product is the largest possible.*/
public class MaximalScalarSum {

	public static void main(String[] args) {
		MaximalScalarSum number=new MaximalScalarSum();
		int[] a={4,5,3,10};
		int[] b={40,15,3,1};
		System.out.println(number.maximalScalarSum(a, b));

	}
	
	long maximalScalarSum(int[] a, int[] b)
	{
		long num=0;
		//
		Arrays.sort(a);Arrays.sort(b);
		for(int i=0;i<a.length;i++)
		{
			num+=a[i]*b[i];
		}
		return num;
	}
	
}