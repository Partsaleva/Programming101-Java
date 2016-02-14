package week1;

import java.util.Arrays;
//import java.util.Scanner;

public class KthMin {

	
	public static void main(String[] args) {
		KthMin num=new KthMin();
		int[] array = new int[]{8,40,5,1,3,60,7};
		int k=3;
		int l=-1;
		/*Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		in.close();*/
		
		System.out.println(num.kthMin(k,array));
		System.out.println(num.kthMin(l,array));

	}
	
	//sort array and return k-1 element
	int kthMin(int k,int[] arr)
	{
		if(k>0 && k<arr.length)
		{
			Arrays.sort(arr);
			return arr[k-1];
		}
		else
		{
			System.out.println("no such element");
			return -1;
		}
	}

}