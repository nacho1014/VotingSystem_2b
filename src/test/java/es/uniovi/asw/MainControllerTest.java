package es.uniovi.asw;

import es.uniovi.asw.dataBase.CandidatureRepository;
import es.uniovi.asw.dataBase.DataBase;
import es.uniovi.asw.model.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:8080")
public class MainControllerTest {



    @Autowired
    public static CandidatureRepository cR;

    @Test
    public void tryingSeleniumTest() throws InterruptedException {


        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/index.xhtml");
        System.out.println(driver.getPageSource());
        WebElement boton = driver.findElement(By.id("form:botonPrimario"));
        boton.click();
        driver.close();

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

        ClosedList closedList = new ClosedList();
        closedList.addCandidature(candidature);
        closedList.setName("Lista UpyD");
        closedList.setExpiryDate(new Date());
        closedList.setInstructions("Instrucciones");
        closedList.setStartDate(new Date());
        candidature.addElection(closedList);
        cR.save(candidature);

        Constituency cons = new Constituency();
        cons.setName("Arava");

        Region region = new Region();
        region.setName("BasqueContry");
        cons.setRegion(region);

        PollingPlace pp = new PollingPlace();
        pp.setConstituency(cons);

        Vote vote = new VoteClosedList();
        vote.setElection(closedList);
        vote.setNumVotes(10);
        vote.setPollingPlace(pp);


        Candidature candidatura1 = cR.findByName("Union progreso y democracia");
        assertEquals("Identicos",candidature,candidatura1);

        System.out.println(candidatura1.toString());



    }

}