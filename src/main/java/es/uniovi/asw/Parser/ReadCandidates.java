package es.uniovi.asw.Parser;
import java.util.List;

import es.uniovi.asw.model.Candidate;


public interface ReadCandidates {

	List<Candidate> readFile(String path);
}
