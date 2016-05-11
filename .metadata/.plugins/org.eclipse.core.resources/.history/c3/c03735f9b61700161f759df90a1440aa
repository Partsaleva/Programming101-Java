package week16;


import java.util.List;

public class Polynomial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<Member> polinom;

	public Polynomial(List<Member> polinom) {
		this.polinom = polinom;
	}

	public List<Member> getPolinom() {
		return polinom;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(polinom.get(0));
		for (int i = 1; i < polinom.size(); i++) {
			sb.append("+"+polinom.get(i));
		}
		String p=sb.toString().replaceAll("\\+-", "-");
		return p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((polinom == null) ? 0 : polinom.hashCode());
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
		Polynomial other = (Polynomial) obj;
		if (polinom == null) {
			if (other.polinom != null)
				return false;
		} else if (!polinom.equals(other.polinom))
			return false;
		return true;
	}
	
	
	
	
}
