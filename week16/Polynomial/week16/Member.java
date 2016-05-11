package week16;

public class Member {

	private int coef;
	private int degree;
	
	public Member(int coef, int degree) {
		this.coef = coef;		
		this.degree = degree;
	}

	public int getCoef() {
		return coef;
	}


	public int getDegree() {
		return degree;
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
	
	
}
