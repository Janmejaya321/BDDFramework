package Utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.helpers.Util;

public class Selenide {
	 private WebDriver driver;

	public enum ControlType {
		Textbox, Select, Label, Checkbox, Button, IFrame, Listbox
	}

	public static void NavigateTo(WebDriver driver, String location) {
		driver.navigate().to(location);
	}

	private static Wait<WebDriver> GetWaiter(WebDriver driver, int seconds) {

		return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(seconds > 0 ? seconds : 100000))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
	}

	public static void WaitForPageLoad(WebDriver driver, int time) {
		GetWaiter(driver, time).until(driver1 -> ((JavascriptExecutor) driver)
				.executeScript("return document.readyState").equals("complete"));
	}

	public static void WaitForElementNotVisible(WebDriver driver, By locator, int seconds) {
		GetWaiter(driver, seconds).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static void WaitForElementVisible(WebDriver driver, By locator, int seconds) {
		Highlight(driver, GetWaiter(driver, seconds).until(ExpectedConditions.visibilityOfElementLocated(locator)));
	}

	private static void Highlight(WebDriver driver, WebElement element) {
		boolean shouldHighlight = true;
		if (shouldHighlight) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].style.cssText='border:2px solid orange';", element);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			jsExecutor.executeScript("arguments[0].style.cssText='border:none';", element);
		}
	}

	public static void WaitForSpinnerComplete(WebDriver driver,int timeinSeconds)
			  {
		         WebElement locator=driver.findElement(By.cssSelector("div#loadingView.loading svg"));
			   //   Selenide.WaitForElementNotVisible(driver, locator, timeinSeconds);
			  }

	public static void FocusAndClick(WebDriver driver, WebElement locator) {
		WebElement element = GetElement(driver, locator);
		new Actions(driver).moveToElement(element).click(element).build().perform();
	}
	
	 public static void VerifyVisible(WebDriver driver, WebElement locator) throws Exception
	 {
	     if (!((WebElement) driver.findElements((By) locator)).isDisplayed()) {
	         throw new Exception("Element state is not matching with expected: <br>" + locator);
	 }
	 }

	private static WebElement GetElement(WebDriver driver, WebElement locator) {

		return driver.findElement(((UserDefinedLocator) locator).GetBy());

	}
	
	 public static  void WaitForLoadingComplete(int wait)
	 {
         By locator=By.cssSelector("div#loadingView.loading svg");
	   //  Selenide.WaitForElementNotVisible(driver, locator, wait);
	 }
	 
	
	 
	 public static void Wait(double seconds)
	 {
		 try {
	     int sec = (int) (seconds * 1000);
	         Thread.sleep(sec);
		 }catch(InterruptedException e) {
			 e.printStackTrace();
		 }

	 }
	 
	 public static String GetCSSValue(WebDriver driver, WebElement locator, String cssobject)
	 {
	     return GetElement(driver, locator).getCssValue(cssobject);
	 }

	 public static void VerifyInvisible(WebDriver driver, WebElement locator)
	 {
	     boolean isdispaly = true;
	     try
	     {
	         isdispaly = driver.findElement((By) locator).isDisplayed();
	     }
	     catch (NoSuchElementException ex)
	     {
	         isdispaly = false;
	     }
	     catch (Exception ex)
	     {
	         throw new RuntimeException("Expected Element condition not match");
	     }

	     if (isdispaly) { throw new RuntimeException("Expected Element condition not match"); }
	 }

}
