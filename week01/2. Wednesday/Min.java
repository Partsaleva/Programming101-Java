
import java.util.Arrays;

public class Min {

	
	public static void main(String[] args) {
	//	int[] array = new int[]{3,4,5,1,3,6,7};
	//	int[] array = new int[]{3,4,5,3,6,7,1};
		int[] array = new int[]{1,3,4,5,3,6,7};
		System.out.println(min(array));
		System.out.println(minElement(array));

	}

	public static int minElement(int[] arr){
		int min=arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min=arr[i];
			}
		}
		return min;
		
	}
	
	//used sort
	public static int min(int[] arr){
		Arrays.sort(arr);
		return arr[0];
	}
	
}