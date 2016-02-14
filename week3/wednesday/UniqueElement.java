package wednesday;

import java.util.Arrays;
import java.util.Collection;

public class UniqueElement<T> {

	public static void main(String[] args) {
		UniqueElement<Object> res=new UniqueElement<>();
		Collection<Object> ints = Arrays.asList(1,2,3,4,5,5,4,3,1);
		res.uniqueElement(ints); //2;
	}

	void uniqueElement(Collection<Object> ints) {
		OnOffCollection<Object> coll=new OnOffCollection<>();
		for(Object t:ints){
			coll.addElem(t.toString());
		}
		coll.print();
	}
}
