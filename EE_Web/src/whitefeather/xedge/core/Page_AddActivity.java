package whitefeather.xedge.core;

import org.openqa.selenium.WebElement;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_AddActivity extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	
	public static WebElement selectActivityType()
	{
		try {
			element = driver.findElement(properties.selectLocator("select_activityType_dropdown"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	public static WebElement displayAddActivityButton()
	{
		try {
			element = driver.findElement(properties.selectLocator("addActivtyButton"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	public static WebElement displayAddActivityCommentBox()
	{
		try {
			element = driver.findElement(properties.selectLocator("AddActivityCommentBox"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

}
