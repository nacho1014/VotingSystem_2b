package es.uniovi.asw;

import es.uniovi.asw.bussiness.Factories;
import es.uniovi.asw.dbupdate.InsertRCandidate;
import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.dbupdate.RepositoryConfiguration;
import es.uniovi.asw.model.*;
import es.uniovi.asw.parser.RCandidateExcel;
import es.uniovi.asw.parser.RCandidatureExcel;
import org.hibernate.annotations.Table;
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

import static org.junit.Assert.*;


import java.util.Calendar;
import java.util.List;

import static es.uniovi.asw.TestingUtils.insertVoterDB;
import static es.uniovi.asw.TestingUtils.restoreDB;
import static es.uniovi.asw.TestingUtils.textoPresentePagina;

/**
 * Created by Ignacio Fernandez on 21/04/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, RepositoryConfiguration.class})
@WebAppConfiguration
@IntegrationTest("server.port:8080")
public class VotarAbiertasTest {



    WebDriver driver;
    WebElement iterator;

    @Before
    public void setUp() {

        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/index.xhtml");
    }

    @After
    public void closeDriver() {
        //driver.close();

    }


    public void insertEleccionesAbiertasTest() {
        restoreDB();
        Calendar c = Calendar.getInstance();
        OpenList openList = new OpenList();
        openList.setName("ClosedList");
        openList.setStartDate(c.getTime());
        openList.setNumChoices(1);
        c.add(Calendar.DATE, 2);
        openList.setExpiryDate(c.getTime());
        boolean result = Factories.services.createElectionFactory().createAbiertas(openList, true);
        assertTrue(result);


    }


    @Test
    public void VoteAbiertasTest() {

        insertEleccionesAbiertasTest();
        iterator = driver.findElement(By.id("form:botonPrimario"));
        iterator.click();
        logIN("1234567", "1");
        iterator = driver.findElement(By.cssSelector("#formulario\\:j_idt7\\:0\\:j_idt13 > div:nth-child(2)\n"));
        iterator.click();
        iterator = driver.findElement(By.id("formulario:botonLogin"));
        iterator.click();
        textoPresentePagina(driver, "¡Gracias por votar!");

    }





    private void logIN(String user, String password) {
        iterator = driver.findElement(By.name("j_idt6:nombreUsuario"));
        iterator.sendKeys(user);
        iterator = driver.findElement(By.name("j_idt6:contrasenya"));
        iterator.sendKeys(password);
        iterator = driver.findElement(By.id("j_idt6:botonLogin"));
        iterator.click();
    }



}
