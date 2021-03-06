package threadTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Pract1 {

	public static void main(String[] args) {
		List<String> l =Arrays.asList( "four","one", "two", "eight");
	
		
		l.forEach(new Consumer<String>(){		
			public void accept(String s){
				System.out.print(s + " ");
			}			
		});

		
		l.forEach(s-> System.out.print(s + " "));
		
		
		l.forEach(System.out::println);
		
		System.out.println("---------------------");
		//Comparator
		Collections.sort(l,new Comparator<String>(){
			@Override
			public int compare(String a, String b) {
				return Integer.compare(a.length(), b.length());
			}
	    	
	    });
	    l.forEach(System.out::println);
	    
	    System.out.println("---------------------");
		//with lambdas
		System.out.println();
	    Collections.sort(l, (a,b) -> Integer.compare(a.length(), b.length()));
	    l.forEach(System.out::println);
	    
	    
	    System.out.println("---------------------");
	    
	    List<String> list=new ArrayList<String>(3);
	    for (String s : l) {
			if (s.contains("o")) {
				list.add(s);
			}		
		}
	    
	    Collections.sort(list, (a,b) -> Integer.compare(a.length(), b.length()));
	    StringBuilder z=new StringBuilder(list.get(0));
	    for (int i = 1; i < list.size(); i++) {
			z.append(";"); z.append(list.get(i));
		}
	    System.out.println(z);
	    
	    
	    String result =l.stream()
	    		.filter(s-> s.contains("o"))
	    		.sorted((a,b)-> Integer.compare(a.length(), b.length()))
	    		.collect(Collectors.joining(";"));
	    System.out.println(result);
	    
	    
	    List<Integer> listOgIntegers=Arrays.asList(1,3,2,4,6,4,8);
	    int res=listOgIntegers.stream()
	    		.filter(s -> s%2 == 0)
	    		.mapToInt(s -> s*2)
	    		.sum();
	    System.out.println(res);
	}
	
	
}
