package generics;

public class SumationFunction<T> {

	public static void main(String[] args) {		
		System.out.println(add(0.9,3));
	}

	
	public static <T extends Number> double add (T first, T second)
	{
	    return first.doubleValue() + second.doubleValue(); 
	}
	
}

