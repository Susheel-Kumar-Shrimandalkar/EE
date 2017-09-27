package whitefeather.xedge.core;

import org.openqa.selenium.WebElement;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_EditLead extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	
	public static WebElement editFirstName() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("addLead_firstNameBox"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}


}
