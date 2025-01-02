package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Selenide;

public class AssetAllocationPage {
	WebDriver driver;

	@FindBy(css = "a[title='View All Cases']")
	WebElement assetallocation_viewallallocationcase_icon;

	@FindBy(xpath = "//a[text()='Add']")
	WebElement addAllocation;
	
	@FindBy(xpath= "//i[@title='Add Allocation Case']")
	WebElement addAllocationCase;

	public AssetAllocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickTopMenuLinks(String menu) throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//a/span[normalize-space()='" + menu + "']"));
		ele.click();
		Selenide.Wait(20);
	}

	public void VerifyColumnHeaderLabels(String labels) throws Exception {
		WebElement locator = driver
				.findElement(By.xpath("//div[contains(@id, 'slickgrid')]/span[text()='" + labels + "']"));
		Selenide.VerifyVisible(driver, locator);
		Selenide.Wait(5);
	}

	public void ClickLeftMenu(String menu) {
		WebElement locator = driver
				.findElement(By.xpath("//a[@class='navLink']/descendant::span[text()='" + menu + "']"));
		locator.click();
		Selenide.WaitForLoadingComplete(25000);
	}

	public void VerifyNoAllocationCasesMessage() throws Exception {
		WebElement locator = driver.findElement(By.xpath("//div[text() = 'No Allocation Cases defined']"));
		Selenide.VerifyVisible(driver, locator);
	}

	public void ClickAddAllocationCase() throws InterruptedException {
		Selenide.Wait(3);
		addAllocationCase.click();

	}

	public void ClickViewAllAllocationCases() throws InterruptedException {
		assetallocation_viewallallocationcase_icon.click();
		ClickTopMenuLinks("Assumption Sets");
		ClickTopMenuLinks("Allocation Cases");
		Selenide.Wait(3);	
		}

	public void EnterAllocationName(String name) {
		WebElement locator = driver.findElement(By.cssSelector("input.form-control"));
		locator.clear();
		locator.sendKeys(name);
	}

	public void ClickAddAllocationButton() throws InterruptedException {
		addAllocation.click();
		Selenide.Wait(5);
	}

	public void VerifyHeaderIcon(String icons) throws Exception {
		WebElement locator = driver.findElement(By.xpath("a[title='" + icons + "']"));
		Selenide.Wait(5);
		Selenide.VerifyVisible(driver, locator);
	}

	public void VerifyTabIsSelected(String labels, Boolean IsSelected) throws Exception {
		Selenide.Wait(5);
		WebElement locator = driver.findElement(By.xpath("//a[span[text()='" + labels + "']"));
		if (IsSelected) {
			if (!Selenide.GetCSSValue(driver, locator, "border-bottom").contains("solid"))
				throw new Exception("TAB not selected");
		}
		  
	}
	public void OpenList_DownArrowIcon()
	  {
			WebElement locator = driver.findElement(By.cssSelector("div[class='dropdown quick-nav '] a.dropdown-toggle>span"));
			locator.click();
	  }
	
	 public void OpenTitleList()
	 {
	     OpenList_DownArrowIcon();
	 }
	 
	 public void VerifyAllocationCaseVisible(String AllocationCase) throws Exception
	 {
	     WebElement locator = driver.findElement(By.xpath("//ul[@class='list-group']/descendant::a[text()='" + AllocationCase +"']"));
	     locator.isDisplayed();
	 }
	 
	 public void ClickLogOut()
	 {
	     WebElement locator = driver.findElement(By.cssSelector("span.user-welcome-name"));
	     locator.click();
	     WebElement locator1 = driver.findElement(By.id("sessionStatus"));

	 }


}
