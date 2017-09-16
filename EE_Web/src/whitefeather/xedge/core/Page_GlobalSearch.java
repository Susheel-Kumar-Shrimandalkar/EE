package whitefeather.xedge.core;

import org.openqa.selenium.WebElement;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_GlobalSearch extends HelperHand
{
	public static WebElement element;
	
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	
	public static boolean displayGlobalSearchBar()
	{
		try {
			visibleFlag = driver.findElement(properties.selectLocator("GLobal_SeachBar")).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibleFlag;
	}

	public static WebElement displayLenseIcon()
	{
		try {
			element = driver.findElement(properties.selectLocator("LenseIcon_GlobalSearchBar"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	public static WebElement displayGoButton()
	{
		try {
			element = driver.findElement(properties.selectLocator("Go_button_globalSearchBar"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	public static WebElement displayPlaceHolder()
	{
		try {
			element = driver.findElement(properties.selectLocator("Placeholder_GlobalSearchBar"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
}
