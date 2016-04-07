package es.uniovi.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Constituency {

	@Id @GeneratedValue
	private Long id;
	private String name;
	
	@ManyToOne
	private Region region;
	@OneToMany(mappedBy="constituency")
	private Set<PollingPlace> pollingPlaces = new HashSet<>();
	
	public Constituency() { }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
}
