package week16;

public class Zero extends NaturalNumber{

	public static void main(String[] args) {
		Zero z=new Zero();
		System.out.println(z.toString());

	}

	
	String num;
	private Zero(){}
	private static Zero instance=null;
	
	public static Zero getInstance(){
		if (instance == null) {
			instance=new Zero();
		}
		return instance;
		
	}
	
	@Override
	boolean isZero() {
		return true;
	}

	@Override
	NaturalNumber next() {
		return new Succ(new Zero());
	}

	@Override
	NaturalNumber prev() {
		return null;
	}

	@Override
	NaturalNumber add(NaturalNumber a) {
		return a;
	}

	@Override
	NaturalNumber minus(NaturalNumber a) {
		if(a.isZero()){
			return a;
		}
		else
		throw new ArithmeticException("");
	}

	@Override
	Integer toInt() {
		return 0;
	}

	@Override
	public String toString() {
		return "Zero";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zero other = (Zero) obj;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}

	

}
