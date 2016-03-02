package week1;


/*8. Smallest multiple
long getSmallestMultiple(int upperBound);
Find the smallest (positive) number, that can be divided
 by each of the numbers from 1 to upperBound.*/
public class SmallestMultiple {

	long getSmallestMultiple(long upper){
		long number = upper;
		boolean flag = false;
		while (!flag){
			flag = true;
			for (int i = 2; i <= upper; i++){
				if (number%i != 0)
					flag = false;
			}
			if (!flag)
				number++;
			else return number;
		}
		return number;
	}
	public static void main(String[] args) {
		SmallestMultiple num=new SmallestMultiple();
		System.out.println(num.getSmallestMultiple(6));

	}

}