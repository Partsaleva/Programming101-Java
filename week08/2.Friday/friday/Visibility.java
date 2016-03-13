package friday;

class VisibilityExampleThread extends Thread{

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

public class Visibility {

	public static void main(String[] args) {
		VisibilityExampleThread v=new VisibilityExampleThread();
		v.start();

	}

}
