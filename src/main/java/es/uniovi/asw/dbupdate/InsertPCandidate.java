package es.uniovi.asw.dbupdate;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.model.Candidate;
import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.parser.CheckFailsCandidate;

public class InsertPCandidate implements InsertCandidate{

	@Override
	public List<Candidate> insert(List<Candidate> candidatos, String path) {
		CheckFailsCandidate.file=path;
		List<Candidate> candidatosInsertados = new ArrayList<Candidate>();
		for(Candidate c:candidatos){
			if(CheckFailsCandidate.check(c)){
				Candidature cand = new Candidature();
				cand.setName(c.getCandidature().getName());
				Repository.candidatureR.save(cand);
				c.setCandidature(cand);
				Repository.candidateR.save(c);
				candidatosInsertados.add(c);
			}
		}
		System.out.println(candidatos.size() + " filas leídas del fichero");
		
		if (candidatos.size() > candidatosInsertados.size())
			System.out.println((candidatos.size() - candidatosInsertados.size()) + " filas con errores en el fichero (ver fails.log para más información)");
		
		System.out.println("Se han registrado " + candidatosInsertados.size() + " candidatos");
		
		return candidatosInsertados;
	}

}
