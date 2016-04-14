package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import es.uniovi.asw.Parser.RCandidateExcel;
import es.uniovi.asw.model.Candidate;

public class ReadCandidateTest {

	@Test
	public void test() {
		List<Candidate> candidates = new RCandidateExcel().readFile("src/test/resources/TestCandidatos.xlsx");
		for(Candidate c: candidates){
			System.out.println(c.getName());
		}
	}

}
