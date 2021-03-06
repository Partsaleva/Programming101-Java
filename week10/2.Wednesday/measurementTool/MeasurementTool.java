package measurementTool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import concurrentDataStructure.*;

public class MeasurementTool {

	private static final int NUMBER_OF_ELEMENTS = 1000000;
	
	public static void main(String[] args) throws InterruptedException {
		int timesToRun = 5;
		int totalTime = 0;
		for (int i = 0; i < timesToRun ; i++) {
			long timeToFinish = mesure(3,10, 1000);
			totalTime += timeToFinish;
		}
		
		System.out.println("time: " + totalTime / timesToRun);

	}

	private static long mesure(int producerCount, int consumerCount, int capacity) throws InterruptedException{
		IMemory memory = Memory.Factory.createMemory(capacity);
		AtomicInteger elementsToProduce = new AtomicInteger(NUMBER_OF_ELEMENTS);
	    AtomicInteger elementsToConsume = new AtomicInteger(NUMBER_OF_ELEMENTS);
	    
	    List<Thread> threads=new ArrayList<>();
	    for (int i = 0; i < producerCount; i++) {
	    	Producer producer= new Producer(memory, elementsToProduce);
	        threads.add(new Thread(producer));
		}
	    
	    for (int i = 0; i < consumerCount; i++) {
	        Consumer consumer= new Consumer(memory, elementsToConsume);
	        threads.add(new Thread(consumer));
	    }
	    
	    long startTime = System.currentTimeMillis();
	    for (Thread thread : threads) {
	      thread.start();
	    }
	    for (Thread thread : threads) {
	      thread.join();
	    }
	    return (System.currentTimeMillis() - startTime );
		
	}
	
	static class Producer implements Runnable{

		private int count=0;
		private IMemory memory;
		private AtomicInteger totalElemToProduce;
		
		
		public Producer(IMemory memory, AtomicInteger totalElemToProduce) {
			this.memory = memory;
			this.totalElemToProduce = totalElemToProduce;
		}


		@Override
		public void run() {
			int elementsToProduce=-1;
			while((elementsToProduce=totalElemToProduce.getAndDecrement()) > 0){
				try {
					//Thread.sleep(100);
					memory.put(elementsToProduce);
					System.out.println("Produced " + (NUMBER_OF_ELEMENTS - elementsToProduce) + " " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	static class Consumer implements Runnable {
	    IMemory memory;
	    private AtomicInteger totalElementsToConsume;
	    public Consumer(IMemory memory, AtomicInteger totalElementsToConsume) {
	      this.memory = memory;
	      this.totalElementsToConsume = totalElementsToConsume;
	    }

	    @Override
	    public void run() {
	      while(totalElementsToConsume.getAndAdd(0) > 0) {
	        try {
	          Object result = memory.get();
	          totalElementsToConsume.decrementAndGet();
	          System.out.println("Consumed " + result + " " + Thread.currentThread().getName());
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        }
	      }
	    }
	  }
}
