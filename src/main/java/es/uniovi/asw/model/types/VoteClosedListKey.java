package es.uniovi.asw.model.types;

import java.io.Serializable;

public class VoteClosedListKey extends VoteKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Long candidature;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((candidature == null) ? 0 : candidature.hashCode());
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
		VoteClosedListKey other = (VoteClosedListKey) obj;
		if (candidature == null) {
			if (other.candidature != null)
				return false;
		} else if (!candidature.equals(other.candidature))
			return false;
		return true;
	}

}
