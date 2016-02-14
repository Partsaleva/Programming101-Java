package friday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap{

	public static void main(String[] args) {
		MyHashMap hashT=new MyHashMap();
		hashT.addData("Mariana", 86457987); hashT.addData("Ani", 86413577); hashT.addData("Dida", 86456875);
		hashT.addData("Vili", 86478996); hashT.addData("Ivan", 56451567);hashT.addData("Georgi", 86555577);
		hashT.addData("Petyr", 865485526); hashT.addData("Nikola", 86516545); hashT.addData("Kalin", 84564155);
		hashT.addData("Maria", 86457987); hashT.addData("Anita", 86413577); hashT.addData("Dido", 86456875);
		hashT.addData("Viliana", 86478992); hashT.addData("Ivana", 56451567); hashT.addData("Gergana", 8655557);
		hashT.addData("Petq", 865485526); hashT.addData("Nikolina", 86516545); hashT.addData("Kalina", 84564155);
		hashT.print();
		//hashT.getVal("gaga");
		//hashT.removeData("Petyr");//1 name-  (index 0)
		//hashT.removeData("Kalin");//first name (index 1)
		//hashT.removeData("Nikolina");//second name (index 4)
		//hashT.print();

	}

	private int size;
	private List<List<Data>> tables;
	
	public MyHashMap(){
		size=19;
		tables=new ArrayList<>(size);
		for(int i=0; i<size; i++){
			tables.add(new LinkedList<Data>());
		}
	}
	
	private int hash(String key) {
		return Math.abs((key.hashCode() % size));
	}
	
	void addData(String key, int value) {
		if (key == null) {
			return;
		}
		if(size==0.75*tables.size()){
			size*=2;
		}
		int position = hash(key);
		List<Data> bucket = tables.get(position);

		if (bucket == null) {
			bucket = new LinkedList<>();
		}

		for (Data entry : bucket) {
			
			if (key.equals( entry.getKey() )) {
				entry.setValue(value);
				return;
			}
		}

		Data newData = new Data(key, value);
		bucket.add(newData);
	}
	
	
	public Integer getVal(String key) {
		if (key == null) {
			return null;
		}

		int position = hash(key);
		List<Data> bucket = tables.get(position);

		if (bucket == null) {
			return null;
		}

		for (Data entry : bucket) {
			if (key.equals(entry.getKey())) {
				return entry.getValue();
			}
		}

		return null;
	}

	public boolean containsKey(String key) {
		if (key == null) {
			return false;
		}

		Integer value = getVal(key);
		if (value != null) {
			return true;
		}
		return false;
	}
	
	public void resize(){}
	public void removeData(){}
	public void print(){
		List<Data> bucket;
		int counter=0;
		for(int i=0; i<size; i++){
			bucket = tables.get(i);
			System.out.print(counter+". ");
			counter++;
			for (Data entry : bucket) {	
				
				System.out.print(entry.getKey()+":"+entry.getValue()+" ; ");
			}
			System.out.println("");
		}
	}
}
