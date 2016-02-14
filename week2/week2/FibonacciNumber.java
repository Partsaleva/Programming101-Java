package week2;
/*17. Fibonacci number
Implement a function long fibNumber(int n), which takes an integer n and returns
 a number, which is formed by concatenating the first n Fibonacci numbers.
Examples:
fibNumber(3) == 112
fibNumber(10) == 11235813213455*/
public class FibonacciNumber {

	public static void main(String[] args) {
		FibonacciNumber num=new FibonacciNumber();
		System.out.println(num.fibonacciNumber(6));
		
	}

	String fibonacciNumber(int n){
		int fib1=0,fib2=1, fibonacci=0;
		String res="1";
		for(int i=0; i<n;i++){
			fibonacci=fib1+fib2;
			fib1=fib2;
			fib2=fibonacci;
			res+=Integer.toString(fibonacci);
		}
		return res;
	}
	
}
