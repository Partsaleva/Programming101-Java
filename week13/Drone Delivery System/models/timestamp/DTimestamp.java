package models.timestamp;

public class DTimestamp implements Comparable<DTimestamp>{

	private DDate date;
	private DTime time;
	
	public DTimestamp(DDate date, DTime time) {
		this.date = date;
		this.time = time;
	}

	public DDate getDate() {
		return date;
	}

	public DTime getTime() {
		return time;
	}

	@Override
	public String toString() {
		return date + " " + time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		DTimestamp other = (DTimestamp) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	@Override
	public int compareTo(DTimestamp o) {
		if(this.date.compareTo(o.date) < 0 ){
			return -1;
		}
		if(this.date.compareTo(o.date) == 0 && this.time.compareTo(o.time)< 0){
			return -1;
		}
		if(this.date.compareTo(o.date) > 0 ){
			return -1;
		}
		if(this.date.compareTo(o.date) == 0 && this.time.compareTo(o.time) > 0){
			return -1;
		}
		return 0;
	}
	
	
}
