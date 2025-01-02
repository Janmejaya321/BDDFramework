package Engine;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverFactory.Driverfactory;
import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseClass {
	
	private Driverfactory driverFactory;
	private WebDriver driver;
	private ConfigReader reader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty()
	{
		reader= new ConfigReader();
		prop= reader.init_prop();
	}
	@Before(order = 1)
	public void launchBrowser()
	{
		String browsername = prop.getProperty("browser");
		driverFactory =new Driverfactory();
		driver=driverFactory.init_driver(browsername);
	}
	
	@After(order=0)
	public void quitBrowser()
	{
		//driver.quit();
	}
	
	@After(order=1)
	public void takeScreenshot(Scenario scenario)
	{
		if (scenario.isFailed()) try {
		//String screenshotName = scenario.getName().replaceAll("", "");
		byte [] sourcepath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcepath, "image/png", scenario.getName());
		} catch (ClassCastException e) {
	        e.printStackTrace();
	    }
		
			        	
	}


}

