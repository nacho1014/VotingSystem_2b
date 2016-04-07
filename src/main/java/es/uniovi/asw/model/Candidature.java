package es.uniovi.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Candidature {

	@Id @GeneratedValue
	private Long id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy="candidature")
	private Set<Candidate> candidates = new HashSet<>();
	@ManyToOne
	private Election election;
	@OneToMany(mappedBy="candidature")
	private Set<VoteClosedList> votes = new HashSet<>();
	
	public Candidature() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	
}
