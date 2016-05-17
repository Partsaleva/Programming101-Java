package threadPractice;

public class Practice1 {

	public static void main(String[] args) throws InterruptedException {
		Thread thread=new Thread(new RunnableImpl());
		System.out.println("Started thread");
		thread.start();
		thread.join();
		System.out.println("Finished thread");
		
	}

	public static class RunnableImpl implements Runnable{

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println("line "+ i);
			}
			
		}
		
	}
}
