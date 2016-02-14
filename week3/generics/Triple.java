package generics;

public class Triple <F,S,T>{

	public static void main(String[] args) {
		Triple<Integer,Integer,String> t1=new Triple<>(3, 4,"M");
		Triple<Integer,Integer,String> t2=new Triple<>(5, 4,"A");
		System.out.println(t1.toString());
		System.out.println(t2.toString()); 
	}

	private F first;
	private S second;
	private T third;
	
	public Triple(F first,S second, T third){
		setFirst(first);
		setSecond(second);
		setThird(third);
	}
 
	private F getFirst(){
		return this.first;
	}
	
	private S getSecond(){
		return this.second;
	}
	
	private T getThird(){
		return this.third;
	}
	private void setFirst(F first){
		this.first=first;
	}
	
	private void setSecond(S second){
		 this.second=second;
	}
	
	private void setThird(T third){
		this.third=third;
	}
	
	public String toString(){
		String str=getFirst()+" "+getSecond()+" "+getThird();
		return str;
	}
}