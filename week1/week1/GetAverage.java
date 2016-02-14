package week1;
/*5. Find the average of the elements of an array
int getAverage(int[] array);*/
public class GetAverage {

	public static void main(String[] args) {
		GetAverage num=new GetAverage();
		int[] array ={3,4,5,1,3,6,7,3};
		int[] test={0,1};
		System.out.println(num.getAverage(array));
		System.out.println(num.getAverage(test));
		

	}
	
	double getAverage(int[] array)
	{
		double sum=0;
		int size=array.length;
		for(int i=0;i<size;i++){
			sum+=array[i];
		}
		return sum/size;
	}

}