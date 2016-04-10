package oddNumbers;

import java.util.List;

public class Task implements Runnable{
	
	private List<Integer> numbers;
	private int count;
	private int start;
	private int end;
	public Task(List<Integer> numbers, int start, int end){
		this.numbers=numbers;
		this.start=start;
		this.end=end;
		this.count=0;
	}
	
	public int getCount() {
		return count;
	}

	@Override
	public void run() {
		for (int i = start; i < end; i++) {
			if ((numbers.get(i) % 2) == 0) {
				count++;
			}
		}
		
	}

}
