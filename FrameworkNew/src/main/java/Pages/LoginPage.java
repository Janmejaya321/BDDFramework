package Pages;

import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverFactory.Driverfactory;
import Utils.ConfigReader;
import Utils.Selenide;

public class LoginPage {
	 private WebDriver driver;
	
	@FindBy(id="username")
	WebElement txt_username;
	
	@FindBy(id="password")
	WebElement txt_password;
	
	@FindBy(xpath="//span[text()='Sign In']")
	WebElement btn_signin;
	
	@FindBy(xpath="//a[@class='dropdown-toggle welcome-user']")
	WebElement dd_user;
	@FindBy(xpath="//i[@class='icon-logout']")
	WebElement btn_logout;
	
	@FindBy(xpath="//h3[text()='Welcome to ']")
	WebElement welcome_msg;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void NavigateTo()
	{
		String URL = ConfigReader.getProperty("URL");
		Driverfactory.getDriver().get(URL);
		Selenide.Wait(20);
	}
	
	public void Login(){
		String username = ConfigReader.getProperty("username");
		String passencod=ConfigReader.getProperty("password");
		String decodePass=new String(java.util.Base64.getDecoder().decode(passencod));
		txt_username.sendKeys(username);
		txt_password.sendKeys(decodePass);
	}
	
	public void ClickSignInBtn() throws InterruptedException
	{
		btn_signin.click();
		Selenide.Wait(25);
	}
	
	public void VerifyLogin()
	{
		welcome_msg.isDisplayed();
	}
	
	public void Logout() throws InterruptedException
	{
		dd_user.click();
		btn_logout.click();
		Selenide.Wait(5);
	}
	public void DoLogin() throws InterruptedException
	{
		//String username = ConfigReader.getProperty("username");
		//String passencod=ConfigReader.getProperty("password");
		//String decodePass=new String(Base64.getDecoder().decode(passencod));
		Login();
		ClickSignInBtn();
		Selenide.Wait(25);
	}
	

}
