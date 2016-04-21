package es.uniovi.asw;

import java.util.List;

import org.junit.Test;

import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.parser.RCandidatureExcel;

public class ReadCandidatureTest {

	@Test
	public void test() {
		List<Candidature> candidaturas = new RCandidatureExcel().readFile("src/test/resources/testCandidatures.xlsx");
		
		for(Candidature c:candidaturas){
			System.out.println(c.getName());
			System.out.println(c.getInitial());
			System.out.println(c.getDescription());

		}
	}

}
