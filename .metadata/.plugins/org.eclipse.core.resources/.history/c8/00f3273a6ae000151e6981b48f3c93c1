package week1;

import java.util.Arrays;

/*10. Grayscale image histogram
int[] histogram(short[][] image)
A histogram is a representation of distribution of some data.
Here you receive a grayscale image matrix (image). Each of 
the matrix's values will be between 0 and 255. Return an array
result, which is a histogram of image => the value of result[i]
should be the ammount of times i is in the matrix image.*/
public class Histogram {

	public static void main(String[] args) {
		Histogram hist=new Histogram();
		short[][] image = new short[][]{
			  { 0, 1, 1, 2, 2, 3, 4, 120, 120, 240 },
			  { 0, 1, 1, 1, 2, 2, 4, 120, 120, 240 },
			  { 0, 0, 0, 0, 0, 3, 4, 120, 120, 240 },
			  { 0, 0, 0, 100, 101, 0, 5, 125, 130, 240 },
			  { 0, 0, 0, 100, 101, 0, 5, 125, 130, 240 }
			};
		//result array
		int[] res=hist.histogram(image);
		
		//without formatting
		System.out.println(Arrays.toString(res));
		
		//outputs each number occurrence
		hist.readResult(res);
		
		
			
	}
	int[] histogram(short[][] image)
	{
		//all possible values
		int[] result=new int[256];
		//set result to 0
		for (int i = 0; i < result.length; i++)
		{
			result[i] = 0;
		}
		//add 1
		for (int i = 0; i < image.length; i++)
		{
			for (int j = 0; j < image[i].length; j++)
			{
				result[image[i][j]] += 1;
			}
		}
		return result;
	}
	
	//read result
	public void readResult(int[] result)
	{
		for (int i = 0; i < result.length; i++)
		{
			System.out.print(i+" - "+result[i]+"\n");
		}
	}

}