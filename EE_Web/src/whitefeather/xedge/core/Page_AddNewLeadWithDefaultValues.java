package whitefeather.xedge.core;

import org.openqa.selenium.WebElement;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_AddNewLeadWithDefaultValues extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	
	public static WebElement enterProspectEmailAddress()
	{
			try {
				element = driver.findElement(properties.selectLocator("addLead_emailBox"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	
	public static WebElement enterProspectMobileNumber()
	{
			try {
				element = driver.findElement(properties.selectLocator("addLead_mobileNumber"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	
	public static WebElement clickAddLeadButtonOnRHSPanel()
	{
			try {
				element = driver.findElement(properties.selectLocator("addLead_RHSPanel_AddLeadButton"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}

}
