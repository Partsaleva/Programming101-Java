package friday;

import java.util.Scanner;

class sumInts implements Runnable{

	private int a;
	private int b;
	
	public sumInts(int a,int b) {
		this.a=a;
		this.b=b;
	}
	@Override
	public void run() {
		System.err.println(add());
	}
	private int add(){
		return a+b;
	}
	
}
public class ThreadSumsInts {

	public static void main(String[] args) {
		Scanner c=new Scanner(System.in);
		int a,b;
		a=c.nextInt();
		b=c.nextInt();
		c.close();
		Thread sum=new Thread(new sumInts(a,b));
		sum.start();
		
	}

}
