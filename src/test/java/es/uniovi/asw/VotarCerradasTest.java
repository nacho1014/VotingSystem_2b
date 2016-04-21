package es.uniovi.asw;

import es.uniovi.asw.bussiness.Factories;
import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.model.ClosedList;
import es.uniovi.asw.model.Election;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Calendar;

import static es.uniovi.asw.TestingUtils.insertVoterDB;
import static es.uniovi.asw.TestingUtils.restoreDB;
import static es.uniovi.asw.TestingUtils.textoPresentePagina;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ignacio Fernandez on 21/04/2016.
 */
public class VotarCerradasTest {

    @Test
    public void nadaDEmomento(){


    }

    /*

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
    public void ShowCerradasTest() {
        restoreDB();
        insertEleccionesCerradasTest();
        insertVoterDB();
        iterator = driver.findElement(By.id("form:botonPrimario"));
        iterator.click();
        logIN("1234567", "1");
        iterator = driver.findElement(By.id("j_idt7:table:0:j_idt10"));
        iterator.click();
        textoPresentePagina(driver, "Ha votado correctamente, muchas gracias por su participación.");


    }


    private void insertEleccionesCerradasTest() {

        Calendar c = Calendar.getInstance();
        ClosedList closedList = new ClosedList();
        closedList.setName("ClosedList");
        closedList.setStartDate(c.getTime());
        c.add(Calendar.DATE, 2);
        closedList.setExpiryDate(c.getTime());
        boolean result = Factories.services.createElectionFactory().createCerradas(closedList, true);
        assertTrue(result);

    }


    private void logIN(String user, String password) {
        iterator = driver.findElement(By.name("j_idt6:nombreUsuario"));
        iterator.sendKeys(user);
        iterator = driver.findElement(By.name("j_idt6:contrasenya"));
        iterator.sendKeys(password);
        iterator = driver.findElement(By.id("j_idt6:botonLogin"));
        iterator.click();
    }
*/

}
