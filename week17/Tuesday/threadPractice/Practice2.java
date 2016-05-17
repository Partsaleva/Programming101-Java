package threadPractice;

import java.util.ArrayList;
import java.util.List;

public class Practice2 {

	public static void main(String[] args) throws InterruptedException {
		List<Thread> threads=new ArrayList<>();
		for (int i = 0; i < 11; i++) {
			Thread t=new Thread(new RunnableImpl(i));
			t.start();
			threads.add(t);
		}
	
		for (Thread thread : threads) {
			thread.join();
		}
		System.out.println("After all");
	}

	public static class RunnableImpl implements Runnable{

		private int id;
		
		public RunnableImpl(int id) {
			this.id=id;
		}
		@Override
		public void run() {
			for (int i = 0; i < 11; i++) {
				System.out.println("Thread id "+ id +", line "+i);
			}
			
		}
		
	}
}
