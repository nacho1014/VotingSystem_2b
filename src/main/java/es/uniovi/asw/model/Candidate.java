package es.uniovi.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Candidate {

	@Id @GeneratedValue
	private Long id;
	private String name;
	private String surname;
	
	@ManyToOne
	private Election election;
	@ManyToOne
	private Candidature candidature;
	@OneToMany(mappedBy = "candidate")
	private Set<VoteOpenList> votes = new HashSet<>();
	
	public Candidate() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Long getId() {
		return id;
	}
	
}
