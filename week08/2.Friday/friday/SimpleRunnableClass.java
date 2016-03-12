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
		tr1.start();

	}

}
