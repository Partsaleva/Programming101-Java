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
		int result=0,count=0;
		for (int i = 0; i < cores; i++) {
			end = start + step;
			Task t=new Task(nums, start, end,count);	
			executor.execute(t);
			System.out.println(t.start +" "+t.end+ " "+t.count);
			result+=t.getCount();
			start = end;
		}
		executor.shutdown();
		executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);	
		return result;
		
	}
}
