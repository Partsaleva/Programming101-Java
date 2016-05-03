package educationalSystem.models;

import java.util.List;

public class QuestionAnswers {

	private Question q;
	private List<Answer> ans;
	
	public QuestionAnswers(Question q, List<Answer> ans) {
		this.q = q;
		this.ans = ans;
	}

	
	public void setAns(List<Answer> ans) {
		this.ans = ans;
	}


	public Question getQ() {
		return q;
	}


	public List<Answer> getAns() {
		return ans;
	}


	
	@Override
	public String toString() {
		return "QuestionAnswers [q=" + q + ", ans=" + ans + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((q == null) ? 0 : q.hashCode());
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
		QuestionAnswers other = (QuestionAnswers) obj;
		if (q == null) {
			if (other.q != null)
				return false;
		} else if (!q.equals(other.q))
			return false;
		return true;
	}
	
	
	
}
