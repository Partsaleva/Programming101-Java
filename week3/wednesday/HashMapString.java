package wednesday;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapString {

	public static void main(String[] args) {
		HashMapString hash=new HashMapString();
		hash.fillMap();
		String result = hash.hashMapIntoString(hash.map);
		System.out.println(result); // { key1:value1, key2:value2, key3:value3 }

	}

	private HashMap<Object,Object> map;
	public HashMapString(){
		map=new HashMap<>();
	}
	
	public void fillMap(){
		map.put(3, 4);
		map.put("a", 5);
		map.put(2, 7);
		map.put("b", 1);
		map.put(4, 10);
	}
	
	String hashMapIntoString(HashMap<? extends Object, ? extends Object> map){
		String result="";
		 // Get a set of the entries
	      Set<?> set = map.entrySet();
	      // Get an iterator
	      Iterator<?> i = set.iterator();
	      // Display elements
	      while(i.hasNext()) {
	         Map.Entry m = (Map.Entry)i.next();
	         result+=m.getKey() + " : "+m.getValue()+ "\n";
	      }
		return result;
		
	}
}
