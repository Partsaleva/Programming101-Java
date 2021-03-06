package stack;

public class NoClonesAllowed<T> implements Stack<T>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private Node top;
	private int size;

	public NoClonesAllowed(){
		size=0;
		top=null;
	}
	private class Node{
		private T elem;
		private Node link;
		public Node(T elem, Node link){
			this.elem=elem;
			this.link=link;
		}	
	}
	
	private void throwIfEmpty(){
		if(top==null){
			throw new java.util.NoSuchElementException();
		}
	}
	
	public void push(T elem){
		if(hasElem(elem)){;}
		else{
			top=new Node(elem,top);
			size++;
		}
	}
	
	public T pop(){
		throwIfEmpty();
		T e=top.elem;
		top=top.link;
		size--;
		return e;
	}
	
	public int size(){
		return size;
	}
	
	public void clear(){
		throwIfEmpty();
		while(top!=null){
			pop();
		}
	}
	public boolean isEmpty(){
		return top==null;
	}
	public T peek(){
		throwIfEmpty();
		return top.elem;
	}
	
	public void print(){
		Node temp=top;
		while(temp!=null)
		{
			System.out.println(temp.elem+" ");
			temp=temp.link;
		}
	}
	
	public boolean hasElem(T e){
		Node temp=top;
		while(temp!=null)
		{
			if(e==temp.elem){
				System.out.println("No duplicates allowed");
				return true;				
			}
			temp=temp.link;
		}
		return false;
	}

}
