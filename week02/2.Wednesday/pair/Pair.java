package pair;

public final class Pair <F,S>{

	public static void main(String[] args) {
		Pair<Integer,Integer> t1=new Pair<>(3, 4);
		Pair<Integer,Integer> t2=new Pair<>(3, 4);
		Pair<Integer,Integer> t3=new Pair<>(4, 4);
		System.out.println(t1.toString());
		System.out.println(t2.toString()); 
		System.out.println(t3.toString());
		System.out.println(t1.equal(t2));
		System.out.println(t2.equal(t3));
	}

	private final F first;
	private final S second;
	
	public Pair(F first,S second){
		this.first=first;
		this.second=second;
	}
 
	private final F getFirst(){
		return this.first;
	}
	
	private final S getSecond(){
		return this.second;
	}
	
	public final String toString(){
		String str=getFirst()+" "+getSecond();
		return str;
	}
	public final boolean equal(Pair<F,S> p){
		return this.first==p.first && this.second==p.second;
	}
}
