package advancedFileSearch;

public class Get implements Runnable{
    Memory m;
	
	public Get(Memory m) {
		this.m=m;
	}
	@Override
	public void run() {
		while(true) {
	        try {
//	          Thread.sleep(110);
	          Object result = m.get();
	          System.out.println("Consumed " + result + " " + Thread.currentThread().getName());
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        }
	        
	      }
		
	}

}
