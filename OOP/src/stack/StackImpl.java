package stack;

public class StackImpl<T> implements Stack<T>{
	
	public static void main(String[] args){
		StackImpl<Integer> test=new StackImpl<Integer>();
		try{
			test.push(13);
			test.push(13);
			test.push(23);
			test.push(37);
			test.push(41);
			test.print(); 
			System.out.println("size: "+test.size());
			System.out.println("returned value from the top(and removed)"+test.pop());
			test.print();
			System.out.println("size: "+test.size());
			System.out.println("Peek: "+ test.peek());
		}
		catch(Exception err)
		{
			System.out.println(err.getMessage());
		}
	}
	
	public StackImpl(){
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
	private Node top;
	private int size;
	
	private void throwIfEmpty(){
		if(top==null){
			throw new java.util.NoSuchElementException();
		}
	}
	
	public void push(T elem){
		if(!hasElem(elem)){
		top=new Node(elem,top);
		size++;
		}
		else return;
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
	
	

