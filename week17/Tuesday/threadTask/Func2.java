package threadTask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Func2 implements Runnable{

	BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);

	public Func2(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		int sum=0;
		for (int i = 0; i < 5_000_000; i++) {
			sum+=i;
		}
		queue.add(sum);
		
	}

	public BlockingQueue<Integer> getQueue() {
		return queue;
	}
	
}
