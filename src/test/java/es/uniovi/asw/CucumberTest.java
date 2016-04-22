package es.uniovi.asw;

import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import es.uniovi.asw.dbupdate.RepositoryConfiguration;

@RunWith(Cucumber.class)
@SpringApplicationConfiguration(classes = {Application.class, RepositoryConfiguration.class})
@IntegrationTest("server.port:8080")
@CucumberOptions(features = "src/test/resources/features")
public class CucumberTest{
}


