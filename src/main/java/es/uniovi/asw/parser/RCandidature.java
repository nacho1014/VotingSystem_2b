package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.dbupdate.InsertCandidate;
import es.uniovi.asw.dbupdate.InsertCandidature;
import es.uniovi.asw.dbupdate.InsertRCandidate;
import es.uniovi.asw.dbupdate.InsertRCandidature;
import es.uniovi.asw.model.Candidate;
import es.uniovi.asw.model.Candidature;

public abstract class RCandidature implements ReadCandidature{
	
	private static InsertCandidature insertDB = new InsertRCandidature();

	@Override
	public List<Candidature> read(String path) {
		
		List<Candidature> candidaturas = readFile(path);
		
		List<Candidature> candidaturasInsertados = insertDB.insert(candidaturas, path);
		
		return candidaturasInsertados;
	}
	
	abstract List<Candidature> readFile(String path);
}
