

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class ReverseGenericCollection <T>{


	public static void main(String[] args) {
		ReverseGenericCollection<Object> collection=new ReverseGenericCollection<>();
		Collection<Object> list=new LinkedList<>(Arrays.asList('a','b',1));
		//collection.reverse(list);
		System.out.println(collection.reverse(list));
		
	}

	 Collection<T> reverse (Collection<T> collection){
		ArrayList<T> rev=new ArrayList<>(collection);	
		Collection<T> result = new ArrayList<>();
		//iterate from end to 0 and add element in result
		for(int i=rev.size()-1;i>=0;i--){
			result.add(rev.get(i));
		}
		return result;
	}
}
