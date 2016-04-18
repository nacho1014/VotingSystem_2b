package es.uniovi.asw.dbupdate;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.model.Candidate;
import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.parser.CheckFailsCandidate;
import es.uniovi.asw.parser.CheckFailsCandidature;

public class InsertPCandidature implements InsertCandidature{

	public List<Candidature> insert(List<Candidature> candidaturas, String path) {
		CheckFailsCandidate.file=path;
		List<Candidature> candidaturasInsertadas = new ArrayList<Candidature>();
		for(Candidature c:candidaturas){
			if(CheckFailsCandidature.check(c)){
				Repository.candidatureR.save(c);
				candidaturasInsertadas.add(c);
			}
		}
		System.out.println(candidaturas.size() + " filas leídas del fichero");
		
		if (candidaturas.size() > candidaturasInsertadas.size())
			System.out.println((candidaturas.size() - candidaturasInsertadas.size()) + " filas con errores en el fichero (ver fails.log para más información)");
		
		System.out.println("Se han registrado " + candidaturasInsertadas.size() + " candidaturas");
		
		return candidaturasInsertadas;
	}

}
