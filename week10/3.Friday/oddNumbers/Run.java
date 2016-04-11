package oddNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Run {

	public static void main(String[] args) throws Exception {
		Random random = new Random();
		
		long start = System.currentTimeMillis(); 
		
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			numbers.add(random.nextInt());
		}

		int count=0;
		for (Integer integer : numbers) {
			if ((integer % 2) == 0) {
				count++;
			}
		}
		System.out.println("single Thread Result: " + count);
		long end = System.currentTimeMillis();
		System.out.println("Time in millis: "+ (end - start));
		
        start = System.currentTimeMillis(); 
		
		int res = CountOddNumbers.count(numbers);
		
		end = System.currentTimeMillis();
		
		System.out.println("Multithread result: "+res);

		System.out.println("Time in millis: "+ (end - start));
	}

}
