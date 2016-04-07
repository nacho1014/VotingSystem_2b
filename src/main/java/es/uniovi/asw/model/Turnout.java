package es.uniovi.asw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(es.uniovi.asw.model.types.TurnoutKey.class)
public class Turnout {

	@Id
	@ManyToOne
	private Election election;
	@Id
	@ManyToOne
	private Voter voter;
	
	public Turnout() {}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
	}
	
}
