package practice;

public class Example implements Runnable{

	private int _a;
	private int _b;
	
	public Example(int a, int b) {
		if(b==0){
			throw new IllegalArgumentException("Cannot devide by 0");
		}
		_a=a;
		_b=b;
	}
	@Override
	public void run() {
		System.err.println(divide());
		
	}
	private double divide(){
		
		return _a/_b;
	}
	
}
