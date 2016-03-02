package stack;



public interface Stack<T> {

	public void push(T elem);
	public T pop();
	public int size();
	public void clear();
	public boolean isEmpty();
	public T peek();
	public void print();
	public boolean hasElem(T e);
	
}
