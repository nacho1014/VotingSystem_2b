package es.uniovi.asw;

import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.dbupdate.RepositoryConfiguration;
import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.model.ClosedList;
import es.uniovi.asw.parser.RCandidatureExcel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static es.uniovi.asw.TestingUtils.esperar;
import static es.uniovi.asw.TestingUtils.insertVoterDB;
import static es.uniovi.asw.TestingUtils.textoPresentePagina;

/**
 * Created by Ignacio Fernandez on 21/04/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, RepositoryConfiguration.class})
@WebAppConfiguration
@IntegrationTest("server.port:8080")
public class TestVotarCerradas {

    WebDriver driver;
    WebElement iterator;

    @Before
    public void setUp() {

        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/index.xhtml");
    }

    @After
    public void closeDriver() {
        driver.close();

    }

    @Test
    public void ShowCerradas() {
        restoreDB();
        insertEleccionesCerradas();
        insertVoterDB();
        iterator = driver.findElement(By.id("form:botonPrimario"));
        iterator.click();
        logIN("1234567", "1");
        iterator = driver.findElement(By.id("j_idt7:table:0:j_idt10"));
        iterator.click();
        textoPresentePagina(driver,"Ha votado correctamente, muchas gracias por su participación.");



    }

    public  void restoreDB(){
        Repository.voteR.deleteAll();
        Repository.turnoutR.deleteAll();
        Repository.electionR.deleteAll();
        Repository.voterR.deleteAll();
        Repository.candidatureR.deleteAll();
        Repository.pollingPlaceR.deleteAll();
        Repository.constituencyR.deleteAll();
        Repository.regionR.deleteAll();
    }


    private void logIN(String user, String password) {
        iterator = driver.findElement(By.name("j_idt6:nombreUsuario"));
        iterator.sendKeys(user);
        iterator = driver.findElement(By.name("j_idt6:contrasenya"));
        iterator.sendKeys(password);
        iterator = driver.findElement(By.id("j_idt6:botonLogin"));
        iterator.click();
    }

    private void insertEleccionesCerradas() {

        Calendar c = Calendar.getInstance();
        ClosedList closedList = new ClosedList();
        closedList.setName("ClosedList");
        closedList.setStartDate(c.getTime());
        c.add(Calendar.DATE, 2);
        closedList.setExpiryDate(c.getTime());
        List<Candidature> candidaturas = new RCandidatureExcel().readFile("src/test/resources/testCandidatures.xlsx");
        Repository.electionR.save(closedList);
        candidaturas.forEach(x->x.addElection(closedList));
        candidaturas.forEach(x->Repository.candidatureR.save(x));






    }


}
