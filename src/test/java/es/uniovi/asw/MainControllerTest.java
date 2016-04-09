package es.uniovi.asw;

import es.uniovi.asw.dataBase.CandidatureRepository;
import es.uniovi.asw.dataBase.DataBase;
import es.uniovi.asw.model.*;
import org.h2.store.Data;
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
import org.springframework.orm.jpa.vendor.Database;
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
        candidate.setCandidature(candidature);

        DataBase.candidatureRepository.save(candidature);

        Candidature candidature1 = DataBase.candidatureRepository.findByName("Union progreso y democracia");

        assertEquals("MismaCandidaturas",candidature,candidature1);




    }

}