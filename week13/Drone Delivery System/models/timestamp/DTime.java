package models.timestamp;

public class DTime implements Comparable<DTime>{

	private int hh;
	private int mm;
	
	public DTime(int hh, int mm) {
		this.hh = hh;
		this.mm = mm;
	}
	public int getHh() {
		return hh;
	}
	public int getMm() {
		return mm;
	}
	@Override
	public String toString() {
		return hh + ":" + mm;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hh;
		result = prime * result + mm;
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
		DTime other = (DTime) obj;
		if (hh != other.hh)
			return false;
		if (mm != other.mm)
			return false;
		return true;
	}
	@Override
	public int compareTo(DTime o) {
		if(this.hh - o.hh < 0){
			return -1;
		}
		if(this.hh - o.hh == 0 && this.mm - o.mm < 0){
			return -1;
		}
		if(this.hh - o.hh > 0){
			return 1;
		}
		if(this.hh - o.hh == 0 && this.mm - o.mm > 0){
			return 1;
		}
		return 0;
	}
	
	
}
