package threadPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Practice3 {

	public static void main(String[] args) throws InterruptedException {
		List<Thread> threads=new ArrayList<Thread>();
		for (int i = 0; i < 100; i++) {
			Thread t=new Thread(new RunnableImpl());
			t.start();
			threads.add(t);
		}
		for (Thread thread : threads) {
			thread.join();
		}
		System.out.println(sum);

	}
	
	private static AtomicInteger sum=new AtomicInteger(0);
	//private static int sum=0;
	public static class RunnableImpl implements Runnable{
		@Override
		public void run() {
			for (int i = 0; i <1000; i++) {
				sum.addAndGet(1);
				//sum+=1;
			}			
		}		
	}
	
	
}
