package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.uniovi.asw.dbupdate.RepositoryConfiguration;
import es.uniovi.asw.model.Candidate;
import es.uniovi.asw.parser.RCandidateExcel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, RepositoryConfiguration.class})

public class InsertCandidateTest {

	@Test
	public void test() {
		List<Candidate> candidatos = new RCandidateExcel().read("src/test/resources/testCandidatosNombre.xlsx");
		assertEquals(2,candidatos.size());
	}

}
