package es.uniovi.asw.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Election {

	@Id @GeneratedValue
	private Long id;
	private String name;
	private Date startDate;
	private Date expiryDate;
	private String instructions;
	
	@OneToMany(mappedBy = "election")
	private Set<Vote> votes = new HashSet<>();
	@OneToMany(mappedBy = "election")
	private Set<Turnout> turnout = new HashSet<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Set<Vote> getVotes() {
		return votes;
	}

	public Long getId() {
		return id;
	}
	
}
