package oddNumbers;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountOddNumbers {

	static int count(List<Integer> nums) throws InterruptedException{
		int cores=Runtime.getRuntime().availableProcessors();
		ExecutorService executor=Executors.newFixedThreadPool(cores);
		int step=nums.size()/cores;
		int start = 0;
		int end;
		int result=0;
		for (int i = 0; i < cores-1; i++) {
			end = start + step;
			executor.submit(new Task(nums, start, end));
			
		
			start = end;
		}
		executor.shutdown();
		executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);	
		return result;
		
	}
}
