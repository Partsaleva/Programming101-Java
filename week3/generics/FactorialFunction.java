package generics;

public class FactorialFunction {

	public static void main(String[] args) {
		System.out.println(fact(3));
	}

	public static <T extends Number> double fact(T first)
	{
		double fact = first.doubleValue();
		double helper=first.doubleValue();
		if (helper>1)
		{
			while (helper != 1)
			{
				fact = fact*(helper - 1);
				helper--;
			}
		}
		else 
		{
			fact = 1;
		}
		return fact;
	}
}
