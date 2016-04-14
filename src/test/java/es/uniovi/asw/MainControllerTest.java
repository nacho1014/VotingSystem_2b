package es.uniovi.asw;

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

import es.uniovi.asw.dbupdate.RepositoryConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, RepositoryConfiguration.class})
@WebAppConfiguration
@IntegrationTest("server.port:8080")
public class MainControllerTest {

    @Test
    public void tryingSeleniumTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/index.xhtml");

        WebElement boton = driver.findElement(By.id("form:botonPrimario"));
        boton.click();
        driver.close();

    }

}