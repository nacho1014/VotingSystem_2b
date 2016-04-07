package es.uniovi.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PollingPlace {
	
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	private Constituency constituency;
	
	@OneToMany(mappedBy="pollingPlace")
	private Set<Vote> votes = new HashSet<>();
	@OneToMany(mappedBy="pollingPlace")
	private Set<Voter> voters = new HashSet<>();
	
	public PollingPlace() {}

	public Constituency getConstituency() {
		return constituency;
	}

	public void setConstituency(Constituency constituency) {
		this.constituency = constituency;
	}

	public Set<Vote> getVotes() {
		return votes;
	}
	
	public Set<Voter> getVoters() {
		return voters;
	}

	public Long getId() {
		return id;
	}

}
