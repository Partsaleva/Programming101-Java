package practice;

public class Mult implements Runnable{
	private int _a,_b;
	
	public Mult(int a, int b) {
		 _a = a;
		 _b = b;
	}

	@Override
	public void run() {
		System.err.println(mult());
		
	}

	public int mult(){
		return _a *_b;
	}
}
