package blockingQueue;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleBlockingQueue {

	private LinkedList<Integer> list=new LinkedList<>();
	private final int MAXSIZE=10;
	//Object lock=new Object();
	private Lock lock=new ReentrantLock();
	private Condition cond=lock.newCondition();

	public void produce()throws InterruptedException{
		int value=0;
		while(true){
			lock.lock();
			while(list.size()==MAXSIZE){
				cond.await();
			}
			cond.signal();
			try{
				list.add(value++);
			}
			finally{
				lock.unlock();
			}

		}
	}
	public void consume()throws InterruptedException{
		while(true){
			lock.lock();
			while(list.size()==0){
				cond.await();
			}
			cond.signalAll();
			try{

				System.out.print("Size: "+list.size());
				int value=list.removeFirst();
				System.out.println(", value: "+value);

			}
			finally{
				lock.unlock();
			}

			Thread.sleep(500);
		}		
	}

}
