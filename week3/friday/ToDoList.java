package friday;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;

public class ToDoList {

	public static void main(String[] args) {
		ToDoList toDoList = new ToDoList(11); //11 hours remaining!
		
		toDoList.addTask(new Task("Algebra",10,2));
		toDoList.addTask(new Task("Math",5,1));
		toDoList.addTask(new Task("Statistics",3,1));
		toDoList.print();
		System.out.println("Remaining time: "+toDoList.getRemainigTime());
		System.out.print("First task: ");toDoList.getTop();
		
		if (toDoList.canFinish()){
		    System.out.println("Woohoo!");
		} else {
		    System.out.println("I am ...screwed :(");
		}
		
	}

	
	private int hoursRemaining;
	PriorityQueue<Task> todo;
	
	public ToDoList(int hoursRemaining){
		this.hoursRemaining=hoursRemaining;	
		todo = new PriorityQueue<Task>(10, new Comparator<Task>() {
	        public int compare(Task task1, Task task2) {
	        	Double v1 = task1.getPriority(); 
				Double v2 = task2.getPriority(); 
				return v2.compareTo(v1); 
				}                                                
	    });
	}
	
	void addTask(Task t){
		todo.add(t);
		hoursRemaining-=t.getTime();
		
	}
	void markFinished(Task t){
		
	}
	void markCancelled(Task t){}
	void getTop(){
		Task s=todo.peek();
		System.out.println(s.getName() + "-"+s.getPriority()+" - "+s.getTime()); 
	}
	
	boolean canFinish(){		
		return this.hoursRemaining>0;
	}
	
	int getRemainigTime(){
		return this.hoursRemaining;
	}
	
	public void print(){
		for(Task s :todo){
		    System.out.println(s.getName() + "-"+s.getPriority()+" - "+s.getTime());
		}
	}
		
}


class Task{
	private String name;
	private double priority;
	private int timeToFinish;
	public Task(String name,double priority,int timeToFinish){
		this.name=name;
		setPriority(priority);
		this.timeToFinish=timeToFinish;
	}
	public void setPriority(double priority) {
		if(priority==10){
			this.priority = priority;
		}
	}
	double getPriority(){
		return this.priority;
	}
	String getName(){
		return this.name;
	}
	int getTime(){
		return this.timeToFinish;
	}
}
