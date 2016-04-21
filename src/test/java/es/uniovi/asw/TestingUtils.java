package es.uniovi.asw;

import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.model.Constituency;
import es.uniovi.asw.model.PollingPlace;
import es.uniovi.asw.model.Region;
import es.uniovi.asw.model.Voter;
import org.apache.tomcat.jni.Thread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * Created by Ignacio Fernandez on 21/04/2016.
 */
public class TestingUtils {

    static public void textoPresentePagina(WebDriver driver, String texto)
    {
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + texto + "')]"));
        assertTrue("Texto " + texto + " no localizado!", list.size() > 0);
    }

    static public WebElement EsperaCargaPaginaxpath(WebDriver driver, String xpath, int timeout)
    {
        WebElement resultado =
                (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        List<WebElement> elementos = driver.findElements(By.xpath(xpath));

        return resultado;
    }

    static public void esperar(int seconds){
        try {
            java.lang.Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void insertVoterDB() {

        Voter v = new Voter();
        v.setEmail("pepe@gmail.com");
        v.setName("pepe");
        v.setNif("1234567");
        v.setPassword("1");
        Region r = new Region();
        r.setName("Jaen");
        Constituency cons = new Constituency();
        cons.setName("Oviedo");
        cons.setRegion(r);
        PollingPlace pp = new PollingPlace();
        pp.setConstituency(cons);
        pp.setId(1L);
        v.setPollingPlace(pp);

        Repository.regionR.save(r);
        Repository.constituencyR.save(cons);
        Repository.pollingPlaceR.save(pp);
        Repository.voterR.save(v);

    }


}
