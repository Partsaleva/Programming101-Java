package friday;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

private static AtomicInteger c=new AtomicInteger(0);
	
	public synchronized static void increment(){
		c.incrementAndGet();
	}
	
	
	public static int getCounter(){
		return c.get();
	}
}
