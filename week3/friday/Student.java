package friday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Student {

	public static void main(String[] args) {
		Student st1=new Student("Mariana", 6);
		Student st2=new Student("Ani", 5);
		Student st3=new Student("Petyr", 3);
		Student st4=new Student("Milena", 4);
		Student st5=new Student("Ivan", 4);
		Student st6=new Student("Stoqn", 5);
		Student st7=new Student("Krasimir", 4);
		Student st8=new Student("Vladimir", 6);
		TreeMap<String, Integer> students = new TreeMap<String, Integer>();
		students.put(st1.name, st1.grade);
		students.put(st2.name, st2.grade);
		students.put(st3.name, st3.grade);
		students.put(st4.name, st4.grade);
		students.put(st5.name, st5.grade);
		students.put(st6.name, st6.grade);
		students.put(st7.name, st7.grade);
		students.put(st8.name, st1.grade);
		print(students);
		

	}

	private String name;
	private int grade;
	
	public Student(String name,int grade){
		this.setName(name);
		this.setGrade(grade);
	}
	
	public void setGrade(int grade) {
		if(grade>=2 && grade <=6){
			this.grade = grade;
		}
	}

	public void setName(String name) {
		if(name.length()>1){
			this.name = name;
		}
	}

	static Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String,Integer>>() {
		@Override 
		public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) { 
			Integer v1 = e1.getValue(); 
			Integer v2 = e2.getValue(); 
			return v2.compareTo(v1); 
			} 
	}; 
	
	static void print(TreeMap<String, Integer> students){
		// Sort method needs a List, so let's first convert Set to List in Java 
		List<Entry<String, Integer>> listOfEntries = new ArrayList<Entry<String, Integer>>(students.entrySet()); 
		// sorting HashMap by values using comparator 
		Collections.sort(listOfEntries, valueComparator);
		LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>(listOfEntries.size()); 
		// copying entries from List to Map 
		for(Entry<String, Integer> entry : listOfEntries){ 
			sortedByValue.put(entry.getKey(), entry.getValue()); 
		}
		for (Entry<String, Integer> entry : sortedByValue.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}
