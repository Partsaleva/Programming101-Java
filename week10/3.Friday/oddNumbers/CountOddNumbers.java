package oddNumbers;

import java.util.List;

public class CountOddNumbers {

	static int count(List<Integer> nums) throws Exception{
		int cores=Runtime.getRuntime().availableProcessors();
		int step=nums.size()/cores;
		int start = 0;
		int end;
		int result=0;
		for (int i = 0; i < cores; i++) {
			end = start + step;
			Task t=new Task(nums, start, end);
			result+=t.call();
			System.out.println(t.start +" "+t.end+ " "+t.getCount());
			start = end;	
		}
		return result;
		
	}
}
