package consumerProducer;

public class Main {

	static class Run implements Runnable{

		@Override
		public void run() {	}
	}
	
	public static void main(String[] args) {
		Thread thread=new Thread(new Run());
	}
	//static class B{
	int a=0;
	Object obj1=new Object();
	Object obj2=new Object();
	public void incremment(){
		synchronized (obj1) {
			this.a+=1;
			System.out.println(a);
		}
	}
//ako sa razlichni promenlivit ima smisyl da izpolzvame razichni kluchove
	public void decremment(){
		synchronized (obj2) {
			this.a-=1;
			System.out.println(a);
		}
	}

	
	static class B{
		static int a=0;
		public synchronized void incr(){		
			this.a+=1;
			System.out.println(a);	
		}
	//ako sa razlichni promenlivit ima smisyl da izpolzvame razichni kluchove
		public void decremment(){
			synchronized (B.class) {
				B.a-=1;
				System.out.println(a);
			}
		}
	}
}
