package es.uniovi.asw.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VotesOpenList")
public class VoteOpenList extends Vote {
	
	@ManyToOne
	private Candidate candidate;
	
	public VoteOpenList() {}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

}
