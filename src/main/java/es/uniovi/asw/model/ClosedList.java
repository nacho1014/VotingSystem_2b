package es.uniovi.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class ClosedList extends Election {
	
	public ClosedList() {}
	
	@OneToMany(mappedBy="election")
	private Set<Candidature> candidatures = new HashSet<>();

	public Set<Candidature> getCandidatures() {
		return candidatures;
	}
	
}
