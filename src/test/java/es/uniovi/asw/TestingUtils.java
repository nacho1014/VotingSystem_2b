package es.uniovi.asw;

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

    static public void wait(int seconds){
        try {
            java.lang.Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
