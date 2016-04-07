package es.uniovi.asw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vote {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
//	@Id
	@ManyToOne
	private Election election;
//	@Id
	@ManyToOne
	private PollingPlace pollingPlace;
	
	private int numVotes;
	
	public Vote() {}

	public int getNumVotes() {
		return numVotes;
	}

	public void setNumVotes(int numVotes) {
		this.numVotes = numVotes;
	}
	
}
