package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.dbupdate.InsertCandidate;
import es.uniovi.asw.dbupdate.InsertRCandidate;
import es.uniovi.asw.model.Candidate;

public abstract class RCandidate implements ReadCandidate{

	private static InsertCandidate insertDB = new InsertRCandidate();
	
	@Override
	public List<Candidate> read(String path) {
		
		List<Candidate> candidatos = readFile(path);
		
		List<Candidate> candidatosInsertados = insertDB.insert(candidatos, path);
		
		return candidatosInsertados;
	}
	
	abstract List<Candidate> readFile(String path);
}
