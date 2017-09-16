package whitefeather.xedge.core;

import org.openqa.selenium.WebElement;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class CloseIconRHSPanels extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	
	public static WebElement displayCloseIcon()
	{
		try {
			element = driver.findElement(properties.selectLocator("CloseIconRHSPanels"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

}
