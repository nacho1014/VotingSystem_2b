package es.uniovi.asw.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.uniovi.asw.Application;
import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.presentation.BeanLogIn;

@ContextConfiguration(classes=Application.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class IncorrectPasswordSteps {
	
	@Autowired
	  protected WebApplicationContext context;

	  protected MockMvc mvc;
	  protected MvcResult result;
	  
	  @Value("${local.server.port}")
	  protected int port;
	  
	  Exception exception;
	  
	  @Given("^the NIF is correct$")
	  public void nif_correct() throws Throwable{
//		  org.junit.Assert.assertNotNull(Repository.voterR.findByNif("admin"));
	  }
	  
	  @When("^the user try to access with an incorrect password$")
	  public void incorrect_password() throws Throwable{
		  
		  BeanLogIn bl = new BeanLogIn();
		  bl.setPassword("Incorrecto");
		  bl.setUser("admin");
		  bl.login();
	  }
	  
	  @Then("^the program shows an error$")
	  public void program_error() throws Throwable{
		  org.junit.Assert.
		  assertTrue(exception.getMessage().contains("No existe el usuario o la contraseña es erronea"));
	  }
	  

}
