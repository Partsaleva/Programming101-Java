package friday;

class ThreadClass extends Thread{
	public void run(){
		System.out.println("This is a Thread Class");
	}
}
public class SimpleThreadClass {

	public static void main(String[] args) {
		ThreadClass tr=new ThreadClass();
		tr.start();
	}

}
