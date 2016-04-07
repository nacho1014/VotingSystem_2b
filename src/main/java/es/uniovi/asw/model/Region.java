package es.uniovi.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Region {

	@Id @GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="region")
	private Set<Constituency> constituencies = new HashSet<>();
	
	public Region() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Constituency> getConstituencies() {
		return constituencies;
	}
	
	public Long getId() {
		return id;
	}
}
