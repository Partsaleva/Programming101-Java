package generics;

public class Pair <F,S>{

	public static void main(String[] args) {
		Pair<Integer,Integer> t1=new Pair<>(3, 4);
		Pair<Integer,Integer> t2=new Pair<>(5, 4);
		System.out.println(t1.toString());
		System.out.println(t2.toString()); 
	}

	private F first;
	private S second;
	
	public Pair(F first,S second){
		setFirst(first);
		setSecond(second);
	}
 
	private void setFirst(F first){
		this.first=first;
	}
	
	private void setSecond(S second){
		 this.second=second;
	}
	private F getFirst(){
		return this.first;
	}
	
	private S getSecond(){
		return this.second;
	}
	
	public String toString(){
		String str=getFirst()+" "+getSecond();
		return str;
	}
	
}
