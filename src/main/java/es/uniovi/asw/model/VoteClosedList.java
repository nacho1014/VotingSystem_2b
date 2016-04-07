package es.uniovi.asw.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VotesClosedList")
public class VoteClosedList extends Vote {
	
	@ManyToOne
	private Candidature candidature;
	
	public VoteClosedList() {}

	public Candidature getCandidature() {
		return candidature;
	}

	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}
	
}
