package practice;

public class uprTread {

	public static void main(String[] args) {
		MyThread tr1=new MyThread();
		MyThread tr2=new MyThread();
		
		tr1.start();
		tr2.start();
		
		tr1.join();
		tr2.join();
		
		System.out.println(Counter.getCounter());
		
		
		
		/*MyRunnable myRunnable =new MyRunnable();
		Thread thread=new Thread(myRunnable);
		thread.start();
		
		Example runExample=new Example(3, 3);
		Thread tr3=new Thread(runExample);
		tr3.start();*/
		
		
		/*MyThread thread1=new MyThread();
		thread1.start();
		thread1.join();
		System.out.println("I'm MAIN thread");*/
		
	
	}
	
}
