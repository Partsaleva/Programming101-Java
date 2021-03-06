package polynomial;

public class Member<C extends Number, D extends Number> implements Comparable<Member<C,D>>  {

	private C coef;
	private D degree;
	private boolean mark;
	
	public Member(C  coef, D degree) {
		this.coef = coef;		
		this.degree = degree;
		setMark(mark);
	}
	
	public void setMark(boolean mark2) {
		this.mark=mark2;	
	}

	public C getCoef() {
		return coef;
	}

	public D getDegree() {
		return degree;
	}

	public boolean getmark(){
		return mark;
	}
	@Override
	public String toString() {
		return "" + coef + "x^" + degree + "";
	}



	@Override
	public int compareTo(Member<C, D> o) {		
		return this.getDegree().intValue() - o.getDegree().intValue();
	}



	
	
}
