package generics;

public class GenericBackpack<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private T x;

	GenericBackpack(){
		setBackpack(x);
	}
	
	void setBackpack(T x){
		this.x=x;
	}
	
	T getBackpack(){
		return x;
	}
	
}
