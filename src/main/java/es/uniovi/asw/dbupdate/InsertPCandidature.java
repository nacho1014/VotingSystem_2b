package es.uniovi.asw.dbupdate;

import java.util.List;

import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.parser.CheckFailsCandidature;

public class InsertPCandidature implements InsertCandidature{

	public List<Candidature> insert(List<Candidature> candidaturas) {
		for(Candidature c:candidaturas){
			if(CheckFailsCandidature.check(c))
				Repository.candidatureR.save(c);
		}

		System.out.println("Se han registrado " + candidaturas.size() + " candidaturas");
		
		return candidaturas;
	}

}
