package es.uniovi.asw;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.dbupdate.RepositoryConfiguration;

import java.util.List;

import static es.uniovi.asw.TestingUtils.EsperaCargaPaginaxpath;
import static es.uniovi.asw.TestingUtils.textoPresentePagina;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, RepositoryConfiguration.class})
@WebAppConfiguration
@IntegrationTest("server.port:8080")
public class MainControllerTest {


    WebDriver driver;
    WebElement iterator;

    @Before
    public void setUp() {

        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/index.xhtml");
    }

    @After
    public void closeDriver() {
        //  driver.close();

    }

    @Test
    public void hitLogButton() {

         iterator = driver.findElement(By.id("form:botonPrimario"));
        iterator.click();

    }


    @Test
    public void pruebaIncorrectaLogAdmin() {

        hitLogButton();
        logIN("pepin", "pepon");
        textoPresentePagina(driver, "No existe el usuario o la contraseña es erronea");

    }

    @Test
    public void pruebaCorrectaLogAdmin() {

        hitLogButton();
        logIN("admin", "admin");
        textoPresentePagina(driver, "Portal de administración");

    }

    @Test
    public void pruebaLlegarConfiguracion() {

        pruebaCorrectaLogAdmin();
        iterator = EsperaCargaPaginaxpath(driver,"/html/body/div/ul/li[1]/div[2]/div[1]/a",1);
        iterator.click();
        textoPresentePagina(driver,"Configure el sistema electoral");

    }

    @Test
    public void pruebaCrearReferendum() {

       pruebaLlegarConfiguracion();
        iterator =EsperaCargaPaginaxpath(driver,"//*[@id=\"j_idt7:treebox\"]/div/div",1);
        iterator.click();
        iterator.sendKeys("ref");
        iterator.sendKeys(Keys.ARROW_DOWN);
        iterator.sendKeys(Keys.ENTER);

    }


//*[@id="j_idt7:treebox"]/div/div/input

    private void logIN(String user, String password) {
        iterator = driver.findElement(By.name("j_idt6:nombreUsuario"));
        iterator.sendKeys(user);
        iterator = driver.findElement(By.name("j_idt6:contrasenya"));
        iterator.sendKeys(password);
        iterator = driver.findElement(By.id("j_idt6:botonLogin"));
        iterator.click();
    }



}