package generics;

public class PowerFunction {

	public static void main(String[] args) {
		System.out.println(pow(2,3));

	}

	public static <T extends Number> double pow(T first, T second)
	{
		double dx = first.doubleValue();
	    double result = 1;

	    for(int i=0; i<second.doubleValue(); i++){
	        result *= dx;
	    }
	    return result;
	}
}
