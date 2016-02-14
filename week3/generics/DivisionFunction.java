package generics;

public class DivisionFunction {

	public static void main(String[] args) {
		System.out.println(dev(987,0.23));
	}

	public static <T extends Number> double dev(T first, T second)
	{
	    return first.doubleValue() / second.doubleValue(); 
	}
}
