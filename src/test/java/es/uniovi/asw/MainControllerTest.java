package es.uniovi.asw;

import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.model.*;
import org.junit.After;
import org.junit.AfterClass;
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

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringJoiner;

import static es.uniovi.asw.TestingUtils.*;
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


        driver.close();

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
        iterator = EsperaCargaPaginaxpath(driver, "/html/body/div/ul/li[1]/div[2]/div[1]/a", 1);
        iterator.click();
        textoPresentePagina(driver, "Configure el sistema electoral");

    }


    @Test
    public void pruebaAbiertas() {

        chooseConfigOption("abi");
        esperar(1);
        textoPresentePagina(driver, "Listas Abiertas");
    }

    @Test
    public void pruebaCerradas() {

        chooseConfigOption("cerr");
        esperar(1);
        textoPresentePagina(driver, "Listas Cerradas");


    }


    @Test
    public void pruebaReferendumRight() {
        insertVoterDB();
        String fecha = fechaLater(-1);
        System.out.println(fecha + "de ayer");
        fillRef(driver, fecha, "Elecciones creadas con exito");
        iterator = driver.findElement(By.id("linkInicio"));
        esperar(1);
        iterator.click();
        esperar(3);
        hitLogButton();
        esperar(1);
        logIN("1234567", "1");
        Election e = Repository.electionR.findActual();
        System.out.println(e);
        textoPresentePagina(driver, "TestR");
        iterator = EsperaCargaPaginaxpath(driver, "//*[@id=\"formId:treebox\"]/div/div", 1);
        iterator.click();
        iterator = EsperaCargaPaginaxpath(driver, "//*[@id=\"formId:treebox\"]/div/div/input", 1);
        iterator.click();
        iterator.sendKeys("Si");
        iterator.sendKeys(Keys.ARROW_DOWN);
        iterator.sendKeys(Keys.ENTER);
        iterator = driver.findElement(By.id("formId:Votar"));
        iterator.click();
        esperar(1);
        textoPresentePagina(driver, "Ha votado correctamente, muchas gracias por su participación.");

    }





    private void chooseConfigOption(String choice) {


        pruebaLlegarConfiguracion();
        iterator = EsperaCargaPaginaxpath(driver, "//*[@id=\"j_idt7:treebox\"]/div/div", 1);
        iterator.click();
        iterator = EsperaCargaPaginaxpath(driver, " //*[@id=\"j_idt7:treebox\"]/div/div/input", 1);
        iterator.click();
        iterator.sendKeys(choice);
        iterator.sendKeys(Keys.ARROW_DOWN);
        iterator.sendKeys(Keys.ENTER);
        EsperaCargaPaginaxpath(driver, "//*[@id=\"j_idt7:Configurar\"]/span[2]", 1).click();


    }


    private void logIN(String user, String password) {
        iterator = driver.findElement(By.name("j_idt6:nombreUsuario"));
        iterator.sendKeys(user);
        iterator = driver.findElement(By.name("j_idt6:contrasenya"));
        iterator.sendKeys(password);
        iterator = driver.findElement(By.id("j_idt6:botonLogin"));
        iterator.click();
    }

    private void fillInput(String text, String idInput) {

        iterator = driver.findElement(By.name(idInput));
        iterator.click();
        iterator.sendKeys(text);

    }

    private void fillReferendum(String name, String fechaInicio, String fechafinal, String instrucciones, String question) {

        fillInput(name, "formReferendum:nombreElecciones");
        fillInput(fechaInicio, "formReferendum:calendarioInicio");
        fillInput(fechafinal, "formReferendum:calendarioFinal");
        fillInput(instrucciones, "formReferendum:instrucciones");
        fillInput(question, "formReferendum:referendumInput");
    }


    private void fillRef(WebDriver driver, String fechaInicio, String texto) {

        String fecha = fechaLater(1);
        System.out.println(fecha + "de mañana");


        chooseConfigOption("ref");
        esperar(1);
        textoPresentePagina(driver, "Referendum");
        esperar(2);
        fillReferendum("TestR", fechaInicio, fecha, "instrucciones", "RefQ");
        iterator = driver.findElement(By.id("formReferendum:crearReferendum"));
        iterator.click();
        esperar(3);
        textoPresentePagina(driver, texto);

    }


    private String fechaLater(int resta) {
        int day, month, year;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, resta);
        day = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        month = cal.get(Calendar.MONTH);
        month++;
        year = cal.get(Calendar.YEAR);
        String fecha = month + "/" + day + "/" + year + " 0:00 PM";
        return fecha;
    }
}