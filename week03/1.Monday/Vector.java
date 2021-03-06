import java.util.ArrayList;

public class Vector<T>{

	public static void main(String[] args) {
		Vector<Object> vec=new Vector<>();
		vec.add(4);
		vec.add(5);
		System.out.println(vec.toString());

	}
	private int size;
	private int capacity;
	private ArrayList<T> data;;
	
	Vector(){
		size=0;
		capacity=2;
		data=new ArrayList<T>(capacity);
	}
	
	public void add(T value){
		if(size==capacity){
			doubleSize();
		}
		data.add(value);
		size++;
	}
	
	public void remove(T value){
		data.remove(value);
		size--;
		reduceCapacity();
	}
	
	public void doubleSize(){
		capacity*=2;
	}
	
	public void reduceCapacity(){
		if(size==capacity/2){
			capacity/=2;
		}
	}
	int vectorSize(){
		return size;		
	}
	
	int vectorCapacity(){
		return capacity;
	}
	
	public String toString(){
		return this.data.toString();	
	}
}
