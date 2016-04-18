package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.uniovi.asw.dbupdate.RepositoryConfiguration;
import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.parser.RCandidatureExcel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, RepositoryConfiguration.class})

public class InsertCandidatureTest {

	@Test
	public void testDescripcionVacia() {
		List<Candidature> candidaturas = new RCandidatureExcel().read("src/test/resources/testCandidaturesDescripcion.xlsx");
		assertEquals(2,candidaturas.size());
	}
	
	@Test
	public void testTodoCorrecto() {
		List<Candidature> candidaturas = new RCandidatureExcel().read("src/test/resources/testCandidatures.xlsx");
		assertEquals(3,candidaturas.size());
	}

}
