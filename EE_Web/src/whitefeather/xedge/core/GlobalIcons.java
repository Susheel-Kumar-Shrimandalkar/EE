package whitefeather.xedge.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;
import whitefeather.xedge.testcases.AddNewLeadWithAllValues;

public class GlobalIcons extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);
	
	public static WebElement displayCompanyLogoInHeader()
	{
			try {
				element = driver.findElement(properties.selectLocator("Header_CompanyLogo"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	
	public static WebElement displayGoButtonInGlobalSearchBar()
	{
			try {
				element = driver.findElement(properties.selectLocator("Go_button_globalSearchBar"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	
	public static WebElement displayLenseInGlobalSearchBar()
	{
			try {
				element = driver.findElement(properties.selectLocator("LenseIcon_GlobalSearchBar"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	public static WebElement displayPlaceholderInGlobalSearchBar()
	{
			try {
				element = driver.findElement(properties.selectLocator("Placeholder_GlobalSearchBar"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	
	public static WebElement displayOutStandingActivityIcon()
	{
			try {
				element = driver.findElement(properties.selectLocator("Header_OutstandingActivityIcon"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	
	public static WebElement displayOutStandingActivityCount()
	{
			try {
				element = driver.findElement(properties.selectLocator("Header_OutstandingActivityCount"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}

	public static WebElement displayCounselorName()
	{
			try {
				element = driver.findElement(properties.selectLocator("Header_CounserlorName"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	
	public static WebElement displayCounselorPhoto()
	{
			try {
				element = driver.findElement(properties.selectLocator("Header_CounselorPhoto"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	
	public static WebElement displaySignOutLink()
	{
			try {
				element = driver.findElement(properties.selectLocator("Header_SignOutLink"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	
	public static WebElement displayJoyRideButton()
	{
			try {
				element = driver.findElement(properties.selectLocator("JoyRide_Button"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	
	public static WebElement displayBulkUploadIcon()
	{
			try {
				element = driver.findElement(properties.selectLocator("BulkUpload_Icon"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	
	public static WebElement displayAddLeadPlusIcon()
	{
			try {
				element = driver.findElement(properties.selectLocator("AddLeadPlusIcon"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	
	public static WebElement openEditLeadPanel()
	{
			try {
				Thread.sleep(2000);
				element = driver.findElement(By.xpath(".//span[contains(text(),'"+AddNewLeadWithAllValues.globalSearchLeadName+"')]"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;	
	}
	
}
