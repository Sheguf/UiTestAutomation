package stepDefination;

import static org.junit.Assert.assertTrue;

import helper.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;



public class LoginPageSteps {
	
	LoginPage login= new LoginPage();
	
	

	@When("user enter username and password")
	public void user_enter_username_and_password() {
		login.user_Login_Application();
		
	}
	
	@And("user click on button")
	public void user_click_on_button() {
		LoginPage click = login;
		click.user_click_on_button();
	}
	
	@Then("validate successful login")
	public void validate_successful_login() {
		assertTrue(login.validate_successful_login());
	}
	
	@Then("validate unsuccessful login")
	public void validate_unsuccessful_login() {
		assertTrue(login.validate_successful_login());
	}	
}
	
	
	
