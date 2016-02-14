package list;
import list.DoublyLinkedList;
public class ListStack {

	public static void main(String[] args) {
		ListStack ls=new ListStack();
		ls.push(1);ls.push(2);ls.push(7);ls.push(5);ls.print();
		ls.pop();ls.pop();ls.pop();ls.print();

	}

	private DoublyLinkedList list=new DoublyLinkedList();
	
	public void push(int elem){
		list.pushFront(elem);
	}
	public int pop(){
		return list.popFront();
	}
	public int size(){
		return list.listSize();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}

	public void print(){
		list.print();
	}

}
