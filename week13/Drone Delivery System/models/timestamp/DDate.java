package models.timestamp;

public class DDate implements Comparable<DDate>{

	private int yyyy;
	private int mm;
	private int dd;
	
	public DDate(int yyyy, int mm, int dd) {
		this.yyyy = yyyy;
		this.mm = mm;
		this.dd = dd;
	}

	public int getYyyy() {
		return yyyy;
	}

	public int getMm() {
		return mm;
	}

	public int getDd() {
		return dd;
	}

	@Override
	public String toString() {
		return yyyy + "-" + mm + "-" + dd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dd;
		result = prime * result + mm;
		result = prime * result + yyyy;
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
		DDate other = (DDate) obj;
		if (dd != other.dd)
			return false;
		if (mm != other.mm)
			return false;
		if (yyyy != other.yyyy)
			return false;
		return true;
	}

	@Override
	public int compareTo(DDate o) {
		if((this.yyyy-o.yyyy)< 0 || (this.mm-o.mm) < 0 || (this.dd -o.dd) < 0 ){
			return -1;
		}else if((this.yyyy-o.yyyy)> 0 || (this.mm-o.mm) > 0 || (this.dd -o.dd) > 0 ){
			return 1;
		}else{
			return 0;
		}		
	}
	
	
	
}
