package wednesday;


public class CircleStructure<T>{

	public CircleStructure() {
		this.head=null; this.tail=null; this.size=0;
	}
	
	public void add(T elem){
		Node newNode = new Node(elem,null);
		if (head == null && tail == null){
			head = tail = newNode;
		}
		else{
			tail.next = newNode;
			newNode.next=head;
			tail = newNode;
		}
		size++;
	}
	
	public int cSize(){
		return size;
	}
	void print(int index){
		Node temp=rotate(index);
		for(int i=0; i<cSize(); i++){
			System.out.print(temp.value+" ");
			temp=temp.next;					
		}
	}
	
	Node rotate(int index){	
		int ind=index%cSize();
		for(int i=0; i<cSize()-ind; i++){	
			head=head.next;	
			tail=tail.next;
		}
		return head;
	}
	
	private class Node{
		T value;
		Node next;
		public Node(T value, Node next){
			this.value=value;
			this.next=next;
		}
	}
	Node head;
	Node tail;
	int size;
	
}
