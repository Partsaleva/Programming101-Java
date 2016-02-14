package generics;

public class SubtractionFunction {

	public static void main(String[] args) {
		System.out.println(subtract(987456,0.235));
	}

	public static <T extends Number> double subtract(T first, T second)
	{
	    return first.doubleValue() - second.doubleValue(); 
	}
}
