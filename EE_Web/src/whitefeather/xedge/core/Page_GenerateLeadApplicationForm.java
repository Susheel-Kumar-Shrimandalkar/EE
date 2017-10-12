package whitefeather.xedge.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_GenerateLeadApplicationForm extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);

	public static WebElement displayFullNameInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("BasicInfo_FullName"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayMobileNumberInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("BasicInfo_MobileNumber"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayEmailInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("BasicInfo_Email"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySubmitButton() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("BasicInfo_SubmitButton"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
}
