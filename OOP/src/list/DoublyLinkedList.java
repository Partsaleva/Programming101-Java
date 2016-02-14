package list;

import java.util.NoSuchElementException;
import list.Test;

public class DoublyLinkedList {

	public static void main(String[] args) {
		DoublyLinkedList r=new DoublyLinkedList();	
		r.pushBack(7);
		r.print();
		r.pushBack(1);r.pushBack(3);r.pushBack(5);
		r.pushBack(2);r.pushBack(4);r.pushBack(6);
		System.out.println("size: "+r.listSize());
		r.print(); 
		r.pushFront(9);r.print(); 
		System.out.println("size: "+r.listSize());
		r.popFront();r.print(); 
		System.out.println("size: "+r.listSize());
		r.popBack();r.print();  
		System.out.println("size: "+r.listSize());
		r.popBack();r.print(); 
		System.out.println("size: "+r.listSize());
		System.out.println();



		DoublyLinkedList  n=new DoublyLinkedList();
		n.pushBack(1);n.pushBack(2);
		n.pushBack(3);n.pushBack(4);
		n.pushBack(5);n.print(); 
		n.pushBack(6);n.print(); 
		n.pushFront(0);n.print(); 
		n.popBack();n.print();
		n.popFront();n.print(); 
		System.out.println();

		DoublyLinkedList  l=new DoublyLinkedList();
		l.pushBack(1);l.pushBack(2);
		l.remove(2);l.pushBack(3);
		l.print();
		

		DoublyLinkedList m=new DoublyLinkedList();
		m.pushBack(2);
		m.insert(0, 1);
		m.pushBack(3);
		m.print();
		
		Test test=new Test();
		test.test1();
		test.test2(); 
		test.test3();
		test.test4();
		test.test5(); 
		test.test6(); 
		test.test7(); 
		test.test8(); 
		test.test9(); 
		test.test10(); 

	}

	public DoublyLinkedList(){
		this.head=null; this.tail=null; this.size=0;
	}
	
	private class Node{
		private int value;
		private Node prev;
		private Node next;
		
		public Node(int value, Node prev,Node next){
			this.value=value;
			this.prev=prev;
			this.next=next;
		}
		public Node(int value){			
			this.value=value;
			this.prev=null;
			this.next=null;
		}	
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	void throwIfEmpty(){
		if (head == null)
		{
			throw new NoSuchElementException();
		}
	}
	boolean isEmpty(){
		return head==null;
	}
	void checkIfValidPosition(int pos){
		if(pos<0|| pos>=size){
			throw new IndexOutOfBoundsException();
		}
	}
	
	int listSize(){
		return size;
	}
	
	void pushFront(int value){
		System.out.println("pushFront: "+ value);
		head = new Node(value,null,head);
		if (tail == null){
			tail = head;
		}
		size++;
	}
	void pushBack(int value){
		System.out.println("pushBack: "+ value);
		Node newNode = new Node(value);
		if (head == null && tail == null){
			head = tail = newNode;
		}
		else{
			tail.next = newNode;
			newNode.prev=tail;
			tail = newNode;
		}
		size++;
	}
	
	int popFront(){
		throwIfEmpty();
		int val = head.value;
		System.out.println("popFront: "+val);
		if (head == tail){
			head = tail = null;
		}
		else{
			head = head.next;
			head.prev=null;
		}
		size--;
		return val;
	}
	int popBack(){
		throwIfEmpty();
		int val = tail.value;
		System.out.println("popBack: "+val);
		if (head == null){
			head = tail = null;
		}
		else{
			 tail = tail.prev;
		     tail.next = null;
		}
		size--;
		return val;
	}
	
	void insert(int position, int value){
		System.out.println("insert " +value+" at "+position+" index");
		Node newNode = new Node(value);
		Node curr = null;
		if (position == size){
			;
		}
		else{
			checkIfValidPosition(position);
		}

		curr = head;
		if (head == null && tail == null){
			head = tail = newNode;
		}
		else if (position == 0){
			head = newNode;
			newNode.next = curr;
		}
		else{
			for (int i = 0; i < position - 1; i++){
				curr = curr.next;
			}
			newNode.next = curr.next.prev;
			curr.next = newNode.prev;
		}
		size++;
	}
	
	
	void remove(int value){
		System.out.println("remove: "+ value);
		Node curr = head;

		while (curr != null && value != curr.value) {
			curr = curr.next;
		}
		if (curr != null) {
			if (curr == tail){
				tail = curr.prev;
			
			}
			else if (curr==head) {
				head = head.next;
			}
			else {
				curr.prev.next=curr.next.prev;
			}
		}
		size--;
	}
	
	
	boolean find(int value){
		Node temp=head;
		while(temp!=null)
		{
			if(temp.value==value){
				return true;
			}
			temp=temp.next;
		}
		return false;
	}
	
	int get(int elementIndex){
		Node temp=head;
		for (int i = 0; i < elementIndex - 1; i++){
			temp = temp.next;
		}
		return temp.value;
	}
	
	int getHead (int first){
		return head.value;
	}
	
	int getTail(int last){
		return tail.value;
	} 
	
	void print(){
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.value+" ");
			temp=temp.next;
		}
		System.out.println();
	 }
	
}

