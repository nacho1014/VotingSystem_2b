package es.uniovi.asw.model.types;

import java.io.Serializable;

public class VoteOpenListKey extends VoteKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Long candidate;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((candidate == null) ? 0 : candidate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoteOpenListKey other = (VoteOpenListKey) obj;
		if (candidate == null) {
			if (other.candidate != null)
				return false;
		} else if (!candidate.equals(other.candidate))
			return false;
		return true;
	}
	
	

}
