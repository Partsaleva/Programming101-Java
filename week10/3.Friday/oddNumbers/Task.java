package oddNumbers;

import java.util.List;

public class Task implements Runnable{
	
	private List<Integer> numbers;
	 int count;
	 int start;
	 int end;
	public Task(List<Integer> numbers, int start, int end, int count){
		this.numbers=numbers;
		this.start=start;
		this.end=end;
		this.count=count;
	}
	
	public int getCount() {
		return count;
	}

	@Override
	public void run() {
		System.out.println("Execute");
		for (int i = start; i < end; i++) {
			if ((numbers.get(i) % 2) == 0) {
				count++;
			}
		}
		//System.out.println(count);
		
	}

}