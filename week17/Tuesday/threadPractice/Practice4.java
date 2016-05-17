package threadPractice;

public class Practice4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int sum=0;
	
	public synchronized void increment(){
		++sum;
	}
	
	public synchronized int getSum(){
		return sum;
	}
}
