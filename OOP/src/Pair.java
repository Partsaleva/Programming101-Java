
public final class Pair <F,S>{
	
	public static void main(String[] args) {
		Pair<Integer,Integer> pair1=new Pair<Integer,Integer>(3,4);
		Pair<Integer,Integer> pair2=new Pair<Integer,Integer>(3,4);
		Pair<Integer,Integer> pair3=new Pair<Integer,Integer>(4,4);
		
		System.out.println(pair1.toString());
		System.out.println(pair3.toString());
		
		System.out.println(pair1.equals(pair2));
		System.out.println(pair1.equals(pair3));
	}
	
	private final F first;
	private final S second;
	
	public Pair(F first,S second){
		this.first=first;
		this.second=second;
	}
	
	public F getFirst() {
		return first;
	}
	
	public S getSecond() {
		return second;
	}
	
	public String toString(){
		String str="first: "+getFirst()+" second: "+getSecond();
		return str;
	}
	
	public boolean equals(Pair<F,S> p){
		return this.first==p.first && this.second==p.second;
	}

}
