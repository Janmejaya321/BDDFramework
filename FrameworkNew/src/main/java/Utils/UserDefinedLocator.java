package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.Locator;


public class UserDefinedLocator {
	
	

		 public enum LocatorType
		 {
		     XPath,
		     LinkText,
		     ID,
		     ClassName,
		     Name,
		     CSS
		 }
		 private LocatorType locatorType;
		 private String location;
		    public UserDefinedLocator(LocatorType locatorType, String location)
		    {
		        this.location = location;
		        this.locatorType = locatorType;
		    }

		    public static UserDefinedLocator Get(LocatorType locatorType, String location)
		    {
		        return new UserDefinedLocator(locatorType, location);
		    }

		    public By GetBy()
		    {
		        By by = null;
		        switch (locatorType)
		        {
		            case ID:
		                by = By.id(location);
		                break;

		            case Name:
		                by = By.name(location);
		                break;

		            case ClassName:
		                by = By.className(location);
		                break;

		            case XPath:
		                by = By.xpath(location);
		                break;

		            case CSS:
		                by = By.cssSelector(location);
		                break;

		            case LinkText:
		                by = By.linkText(location);
		                break;
		        }

		        return by;
		    }

		  
		}




