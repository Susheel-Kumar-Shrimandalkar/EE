package whitefeather.xedge.core;

import org.openqa.selenium.WebElement;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_ForgotPassword extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	
	public static WebElement displayCompanyLogo()
	{
		try {
			element = driver.findElement(properties.selectLocator("forgotPassword_CompanyLogo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayRecoveryLabel()
	{
		try {
			element = driver.findElement(properties.selectLocator("forgotPassword_RecoveryLabel"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayRecoveryMessage()
	{
		try {
			element = driver.findElement(properties.selectLocator("forgotPassword_RecoveryLabel"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
}
