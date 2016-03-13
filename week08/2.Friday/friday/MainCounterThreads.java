package friday;

public class MainCounterThreads {

	public static void main(String[] args) {
		ThreadForCounter tr1=new ThreadForCounter();
		ThreadForCounter tr2=new ThreadForCounter();
		tr1.start();
		tr2.start();
		
		try {
			tr1.join();
			tr2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println(Counter.getCounter());

		
	}

}