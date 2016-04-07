package es.uniovi.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class OpenList extends Election {

	private int numChoices;
	
	@OneToMany(mappedBy="election")
	private Set<Candidate> candidates = new HashSet<>();

	public OpenList() { }
	
	public int getNumChoices() {
		return numChoices;
	}

	public void setNumChoices(int numChoices) {
		this.numChoices = numChoices;
	}

	public Set<Candidate> getCandidates() {
		return candidates;
	}
	
}
