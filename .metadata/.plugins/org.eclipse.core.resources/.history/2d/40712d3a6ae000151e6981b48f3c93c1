package week1;
/*14. Max span
int maxSpan(int[] numbers) Consider the leftmost and righmost appearances of some value in an array. 
We'll say that the "span" is the number of elements between the two inclusive. A single value has a span of 1.
Returns the largest span found in the given array.
maxSpan({1, 2, 1, 1, 3})  4 maxSpan({1, 4, 2, 1, 4, 1, 4})  6 maxSpan({1, 4, 2, 1, 4, 4, 4}) 6*/
public class MaxSpan {

	int maxSpan(int[] numbers)
	{
		int max = 0;
		int currMax = 0;
		for (int i = 0; i< numbers.length; i++)
		{
			for (int j = i+1; j < numbers.length; j++)
			{
				if (numbers[i] == numbers[j])
				{
					currMax = j - i + 1;
					if (currMax>max)
					{
						max = currMax;
					}
				}
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		MaxSpan num=new MaxSpan();
		int[] n={1, 4, 2, 1, 4, 4, 4};
		
		System.out.println(num.maxSpan(n));
	}

}