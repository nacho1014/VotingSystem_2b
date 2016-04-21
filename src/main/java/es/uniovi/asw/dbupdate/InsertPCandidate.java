package es.uniovi.asw.dbupdate;

import java.util.List;

import es.uniovi.asw.model.Candidate;
import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.parser.CheckFailsCandidate;

public class InsertPCandidate implements InsertCandidate{

	@Override
	public List<Candidate> insert(List<Candidate> candidatos) {
		Candidature cand;
		for(Candidate c:candidatos){
			if(CheckFailsCandidate.check(c)){
				cand = Repository.candidatureR.findByName(c.getCandidature().getName());
				if (cand == null) {
					cand = new Candidature();
					cand.setName(c.getCandidature().getName());
				}
				c.setCandidature(cand);
				Repository.candidatureR.save(cand);
				Repository.candidateR.save(c);
			}
		}
		
		System.out.println("Se han registrado " + candidatos.size() + " candidatos");
		
		return candidatos;
	}

}
