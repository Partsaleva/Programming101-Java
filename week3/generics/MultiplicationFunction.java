package generics;

public class MultiplicationFunction {

	public static void main(String[] args) {
		System.out.println(mult(987,0.235));
	}

	public static <T extends Number> double mult(T first, T second)
	{
	    return first.doubleValue() * second.doubleValue(); 
	}
}
