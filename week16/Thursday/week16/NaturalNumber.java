package week16;

public abstract class NaturalNumber {

	abstract boolean isZero();
	
	 NaturalNumber next(){
		 return new Succ(this);
	 }
	
	abstract NaturalNumber prev();
	
	abstract NaturalNumber add(NaturalNumber a);
	
	abstract NaturalNumber minus(NaturalNumber a);
	
	abstract Integer toInt();
	
	public abstract String toString();
	
	
	public abstract boolean equals(Object n);
}
