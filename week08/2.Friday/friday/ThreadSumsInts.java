package friday;

import java.util.Scanner;

class sumInts implements Runnable{

	@Override
	public void run() {
		Scanner c=new Scanner(System.in);
		int a,b;
		a=c.nextInt();
		b=c.nextInt();
		c.close();
		System.out.println(a+b);
	}
	
}
public class ThreadSumsInts {

	public static void main(String[] args) {
		Thread sum=new Thread( new sumInts());
		sum.start();
		
	}

}