package practice;

public class VisibilityExampleThread extends Thread{

	volatile boolean keepRunning=true;
	
	public void setToFalse(){
		keepRunning=false;
	}
	
	public boolean getValue(){
		return keepRunning;
	}
	
	public void run(){
		while(getValue()){
			setToFalse();
		}
	}
}
