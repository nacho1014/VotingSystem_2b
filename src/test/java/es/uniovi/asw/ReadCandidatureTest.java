package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import es.uniovi.asw.parser.RCandidatureExcel;
import es.uniovi.asw.model.Candidature;

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
