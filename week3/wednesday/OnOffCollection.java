package wednesday;

import java.util.ArrayList;

public class OnOffCollection<T> {

	public static void main(String[] args) {
		OnOffCollection<Object> coll=new OnOffCollection<>();
		coll.addElem(1);coll.addElem(2);coll.addElem(3);coll.addElem("abc");coll.addElem(5);
		coll.print();
		coll.addElem(1);
		coll.print();
	}

	public OnOffCollection() {
		list=new ArrayList<>();
	}

	public void addElem(T elem){
		if(!found(elem)){
			list.add(elem);
		}
		else{
			removeItem(elem);
		}
	}
	
	public void print(){
		System.out.println(list.toString());
		
	}
	private boolean found(T elem){
		return list.contains(elem);	
	}
	
	private void removeItem(T elem){
		list.remove(elem);
	}
	private ArrayList<T> list;
	
}
