package polynomial;

public class Member implements Comparable<Member>  {

	private int coef;
	private int degree;
	private boolean mark;
	
	public Member(int coef, int degree) {
		this.coef = coef;		
		this.degree = degree;
		setMark(mark);
	}
	
	

	public void setMark(boolean mark2) {
		this.mark=mark2;	
	}



	public int getCoef() {
		return coef;
	}


	public int getDegree() {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coef;
		result = prime * result + degree;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (coef != other.coef)
			return false;
		if (degree != other.degree)
			return false;
		return true;
	}

	@Override
	public int compareTo(Member o) {
		return (this.degree-o.degree);
	}
	
	
}
