package practice;

public class MyThread extends Thread{
	
	public void run(){
		for(int i=0; i<1000000;i++){
			Counter.increment();
		}
	}
}
