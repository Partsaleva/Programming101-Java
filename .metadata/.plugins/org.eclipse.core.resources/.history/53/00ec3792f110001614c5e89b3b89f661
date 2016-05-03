package educationalSystem.models;

public class Answer {
	private int ansId;
	private int qustId;
	private String data;
	private boolean isCorrect;
	
	public Answer(int ansId, int qustId, String data, boolean isCorrect) {
		this.ansId = ansId;
		this.qustId = qustId;
		this.data = data;
		this.isCorrect = isCorrect;
	}

	public int getAnsId() {
		return ansId;
	}

	public int getQustId() {
		return qustId;
	}

	public String getData() {
		return data;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ansId;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + (isCorrect ? 1231 : 1237);
		result = prime * result + qustId;
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
		Answer other = (Answer) obj;
		if (ansId != other.ansId)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (isCorrect != other.isCorrect)
			return false;
		if (qustId != other.qustId)
			return false;
		return true;
	}
	
	
}
