package week16;

public class Succ extends NaturalNumber{

	public static void main(String[] args) {
		Succ s=new Succ();
		System.out.println(s.toString());

	}

	private NaturalNumber n;
	
	public  Succ(NaturalNumber n) {
		this.n=n;
	}
	
	
	@Override
	boolean isZero() {
		return false;
	}

	@Override
	NaturalNumber next() {
		return new Succ(this);
	}

	@Override
	NaturalNumber prev() {
		return n;
	}

	@Override
	NaturalNumber add(NaturalNumber a) {
		if (a.isZero()) {
			return this;
		}
		return this.next().add(a.prev());
	}

	@Override
	NaturalNumber minus(NaturalNumber a) {
		if (a.isZero()) {
			return this;
		}
		return this.prev().add(a.prev());
	}

	@Override
	Integer toInt() {
		return 1+prev().toInt();
	}

	@Override
	public String toString() {
		return "Succ + "+ prev().toString() ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Succ other = (Succ) obj;
		if (n == null) {
			if (other.n != null)
				return false;
		} else if (!n.equals(other.n))
			return false;
		return true;
	}

	



	

}
