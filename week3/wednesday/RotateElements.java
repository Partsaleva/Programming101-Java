package wednesday;

import wednesday.CircleStructure;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class RotateElements<T> {

	public static void main(String[] args) {
		RotateElements<Object> collection=new RotateElements<>();
		Collection<Object> list=new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7));
		collection.rotateElements(list, 9);
	}
	
	void rotateElements(Collection<T> collection, int rotateStep ){
		CircleStructure<T>  coll=new CircleStructure<>();
		for(T t: collection){
			coll.add(t);
		}
		coll.print(rotateStep);
	}
	
}
