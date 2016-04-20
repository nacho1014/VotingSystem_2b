package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.dbupdate.RepositoryConfiguration;
import es.uniovi.asw.model.Candidate;
import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.parser.RCandidateExcel;
import javassist.bytecode.Descriptor.Iterator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, RepositoryConfiguration.class})

public class InsertCandidateTest {

	@Test
	public void test() {
		List<Candidate> candidatos = new RCandidateExcel().read("src/test/resources/testCandidatosNombre.xlsx");
		assertEquals(2,candidatos.size());
		
	}
	
	@Test
	public void testPartido() {
		List<Candidate> candidatos = new RCandidateExcel().read("src/test/resources/testCandidatosPartido.xlsx");
		assertEquals(1,candidatos.size());
	}
	
	
	@Test
	public void testDeComprobacion() {
		new RCandidateExcel().read("src/test/resources/testCandidatosInsercion.xlsx");
		System.out.println(Repository.candidateR.count());
		Candidature c = new Candidature();
		c = Repository.candidatureR.findByName("EE");
		List<Candidate> candidato = Repository.candidateR.findByCandidature(c);
		for(Candidate cand:candidato){
			System.out.println(cand.getName());
			System.out.println(cand.getDNI());
			System.out.println(cand.getSurname());
		}		
	}

}
