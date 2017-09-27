package whitefeather.xedge.core;

import org.openqa.selenium.WebElement;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_AddNewLead extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	
	public static WebElement displayFirstNameInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_firstName"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayLastNameInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_lastName"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayEmailInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_email"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayMobileInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_mobileNumber"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayQualificationInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Qualification"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectSeasonDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectSeason"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectSourceDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectSource"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectChannelDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectChannel"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectPriorityDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectPriority"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectStatusDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectStatus"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectReasonDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectReason"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectReferredToDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectReferredTo"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectEntity1Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectEntity1"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectEntity2Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectEntity2"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectEntity3Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectEntity3"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectEntity4Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectEntity4"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectBestTimeDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_BestTime"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectLeadQualifiedDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_LeadQualified"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectLeadContactableDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_LeadContactable"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayMobileVerifiedDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_MobileVerified"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayField1Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Field1"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayField2Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Field2"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayField3Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Field3"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayField4Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Field4"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayField5Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Field5"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayCountryDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectCountry"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayStateDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectState"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayCityDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectCity"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayCommentInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Comment"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayAddLeadButton()
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_AddLeadButton"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;	
	}

	public static WebElement displayCancelButton()
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_CancelButton"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;	
	}

}

