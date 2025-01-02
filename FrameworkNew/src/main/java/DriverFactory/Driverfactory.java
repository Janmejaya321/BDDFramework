package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {
	public WebDriver driver;
	//ThreadLocal to achive parallesim and lunch browser
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<>();
	
	public WebDriver init_driver(String browser)
	{
		if(browser.equals("chrome"))
				{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			
				}
		else if(browser.equals("msedge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
			
		}
		//getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	public static WebDriver getDriver() {
		return tlDriver.get();
	}

}
