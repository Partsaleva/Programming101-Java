package week17;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Func1 implements Runnable{

	BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);

	
	public Func1(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		int sum=0;
		for (int i = 0; i < 1_000_000; i++) {
			sum+=i;
		}
		queue.add(sum);
	}
	
	public BlockingQueue<Integer> getQueue() {
		return queue;
	}
	
}
