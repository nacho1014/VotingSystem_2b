package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.uniovi.asw.dbupdate.CandidatureRepository;
import es.uniovi.asw.dbupdate.RepositoryConfiguration;
import es.uniovi.asw.model.Candidate;
import es.uniovi.asw.model.Candidature;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, RepositoryConfiguration.class})
public class DataBaseTest {
	
    private CandidatureRepository cR;
    
    @Autowired
    public void setPollingPlaceRepository(CandidatureRepository productRepository) {
        this.cR = productRepository;
    }

    @Test
    public void testMySqlIntegration() {


        Candidature candidature = new Candidature();
        candidature.setName("Union progreso y democracia");
        candidature.setInitial("UpyD");
        candidature.setDescription("Candidatura electoral de unión progreso y democracia");

        Candidate candidate = new Candidate();

        candidate.setName("Andres");
        candidate.setDNI("67890976E");
        candidate.setSurname("Herzog");
        candidate.setCandidature(candidature);
        candidate.setCandidature(candidature);

        cR.save(candidature);

        Candidature candidature1 = cR.findByName("Union progreso y democracia");

        assertEquals("MismaCandidaturas",candidature,candidature1);

    }
}
