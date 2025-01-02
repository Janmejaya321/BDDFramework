package StepDefinitions;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import DriverFactory.Driverfactory;
import Pages.LoginPage;

import io.cucumber.java.en.*;

public class LoginSteps{
	LoginPage loginpage= new LoginPage(Driverfactory.getDriver());
	
	@Given("User is on login page")
	public void user_is_on_login_page() throws InterruptedException{
	  Driverfactory.getDriver().get("https://zephyr-pp.fi.informais.com/");
	  Thread.sleep(10000);
	}


	@When("user type username and password")
	public void user_type_username_and_password() {
		loginpage.Login();
	    	    
	}

	@And("user click on signin")
	public void user_click_on_signin() throws InterruptedException {
		loginpage.ClickSignInBtn();

	}

	@Then("user should see welcome message and logout")
	public void user_should_see_welcome_message_and_logout() throws InterruptedException {
		loginpage.VerifyLogin();
		loginpage.Logout();
	   
	}
	
		


}
