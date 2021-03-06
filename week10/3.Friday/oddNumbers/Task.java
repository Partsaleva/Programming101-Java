package oddNumbers;

import java.util.List;
import java.util.concurrent.Callable;

public class Task implements Callable<Object>{
	
	private List<Integer> numbers;
	 int count;
	 int start;
	 int end;
	public Task(List<Integer> numbers, int start, int end){
		this.numbers=numbers;
		this.start=start;
		this.end=end;
	}
	
	public int getCount() {
		return count;
	}

	

	@Override
	public Integer call() throws Exception {
		System.out.println("Execute");
		for (int i = start; i < end; i++) {
			if ((numbers.get(i) % 2) == 0) {
				count++;
			}
		}	
		return count;
	}

}
