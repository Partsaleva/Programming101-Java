package wednesday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DuplicatingElements<T> {

	public static void main(String[] args) {
		List <Object> list1 = new ArrayList <Object> (Arrays.<Object>asList (1,2,3,4,5,5,5));
	    List <Object> list2 = new ArrayList <Object> (Arrays.<Object>asList (4,5,5,6));
	    List <Object> list3 = new ArrayList <Object> (Arrays.<Object>asList (5,6,7,8));

	    System.out.println (intersect (list1, intersect (list2, list3)));
			
	}


	public static <T> Collection <T> intersect (Collection <? extends T> a, Collection <? extends T> b)
	{
	    Collection <T> result = new ArrayList <T> ();

	    for (T t: a){
	        if (b.remove (t)){
	        	result.add (t);
        	}
	    }

	    return result;
	}


	
	
}
