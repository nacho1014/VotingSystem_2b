package es.uniovi.asw;

import java.util.List;

import org.junit.Test;

import es.uniovi.asw.model.Candidate;
import es.uniovi.asw.parser.RCandidateExcel;

public class ReadCandidateTest {

	@Test
	public void test() {
		List<Candidate> candidates = new RCandidateExcel().readFile("src/test/resources/testCandidatos.xlsx");
		for(Candidate c: candidates){
			System.out.println(c.getName());
			System.out.println(c.getSurname());
			System.out.println(c.getCandidature().toString());
			System.out.println(c.getDNI());
		}
	}

}
