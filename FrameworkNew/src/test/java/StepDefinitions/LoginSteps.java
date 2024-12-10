package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginSteps {

	WebDriver driver;
	@Given("User is in Log in Page")
	public void user_is_in_log_in_page() throws Exception {
	    System.setProperty(
	            "webdriver.chrome.driver",
	            "C:\\Users\\Janmejaya Pradhan\\eclipse-workspace\\FrameworkNew\\Utils\\chromedriver.exe");
	        // Instantiate a ChromeDriver class.
	        driver = new ChromeDriver();
	 
	        // Maximize the browser
	        driver.manage().window().maximize();
	        Thread.sleep(100000);
	}

	@When("User put valid id and password")
	public void user_put_valid_id_and_password() {
	    System.out.println("add id and pass");
	}

	@And("User click on log in button")
	public void user_click_on_log_in_button() {
	    System.out.println("click");
	}

	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
	   System.out.println("home page");
	}

}
