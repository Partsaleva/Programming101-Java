package week17;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class MultithrPract {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
		
		Thread t1=new Thread(new Func1(queue));
		Thread t2=new Thread(new Func2(queue));
		t1.start();
		t2.start();
		try {
			
			System.out.println(queue.take());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		
		CompletableFuture <Long> f1=CompletableFuture
				.supplyAsync(()-> {
					return LongStream
							.range(1,(long) 1e9).sum();
		});
		
		CompletableFuture <Long> f2=CompletableFuture
				.supplyAsync(()-> {
					return LongStream
							.range(1,(long) 1e9)
							.reduce(1, (a,b)->(a+b) % 1337);
		});
		
		f1.acceptEitherAsync(f2, System.out::println).join();
		
		
		
		List<Long> numbers =LongStream
				.range(0,(long) 1e7)
				.boxed().
				collect(Collectors.toList());
		long result=numbers.parallelStream()
				.reduce(0L, (x,y)-> x+y);
		System.out.println(result);
	}
	
}
