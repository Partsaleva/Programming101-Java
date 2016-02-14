package wednesday;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class OccurencesOfWords {

	public static void main(String[] args) {
		OccurencesOfWords words=new OccurencesOfWords();
		LinkedHashMap<String, Integer> result = words.fill("Ninjas are all over the place! We are all going to die!");
		System.out.print(words.mapToString(result));

	}

	private String mapToString(LinkedHashMap<String, Integer> res) {
		String result="";
		Set<?> set=res.entrySet();
		Iterator<?> iter=set.iterator();
		while(iter.hasNext()){
			 Map.Entry m = (Map.Entry)iter.next();
	         result+=m.getKey() + ":"+m.getValue()+ ",  ";
		}
		return result;
	}

	public LinkedHashMap<String, Integer> fill(String str){
		LinkedHashMap<String, Integer> res=new LinkedHashMap<>();
		String[] splitedString=str.split(" ");
		int occur=1;
		for(int i=0; i<splitedString.length; i++){
			if(res.containsKey(splitedString[i])){
				occur = (res.get(splitedString[i]));
			    res.put(splitedString[i],occur+1);
			}
			else{
				res.put(splitedString[i],occur);
			}
		}
		return res;
	}
}
