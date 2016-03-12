package friday;

class RunnableClass implements Runnable{

	@Override
	public void run() {
		System.out.println("This is a Runnable Class");
		
	}
	
}
public class SimpleRunnableClass {

	public static void main(String[] args) {
		Thread tr1=new Thread(new RunnableClass());
		ThreadClass tr2=new ThreadClass();
		
		try {
			tr1.join();
			tr1.start();
			tr2.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
