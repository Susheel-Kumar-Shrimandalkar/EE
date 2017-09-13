package whitefeather.xedge.core;

import org.openqa.selenium.WebElement;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class GlobalIcons extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	
	public static WebElement clickAddLeadPlusIcon()
	{
			try {
				element = driver.findElement(properties.selectLocator("addLead_plusIcon"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}

}
