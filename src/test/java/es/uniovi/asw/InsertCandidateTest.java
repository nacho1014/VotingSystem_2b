package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.uniovi.asw.dbupdate.InsertRCandidate;
import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.dbupdate.RepositoryConfiguration;
import es.uniovi.asw.model.Candidate;
import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.parser.RCandidateExcel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, RepositoryConfiguration.class})

public class InsertCandidateTest {

	@Test
	public void test() {
		List<Candidate> candidatos = new RCandidateExcel().read("src/test/resources/testCandidatosNombre.xlsx");
		assertEquals(3,candidatos.size());
		
	}
	
	@Test
	public void testPartido() {
		List<Candidate> candidatos = new RCandidateExcel().read("src/test/resources/testCandidatosPartido.xlsx");
		assertEquals(3,candidatos.size());
	}
	
	
	@Test
	public void testDeComprobacion() {
		List<Candidate> candidatos = new RCandidateExcel().read("src/test/resources/testCandidatosInsercion.xlsx");
		new InsertRCandidate().insert(candidatos);
		System.out.println(Repository.candidateR.count());
		Candidature c = new Candidature();
		c = Repository.candidatureR.findByName("EE");
		List<Candidate> candidato = Repository.candidateR.findByCandidature(c);
		for(Candidate cand:candidato){
			System.out.println(cand.getName());
			System.out.println(cand.getDNI());
			System.out.println(cand.getSurname());
		}
		new InsertRCandidate().insert(candidatos);
	}

}
