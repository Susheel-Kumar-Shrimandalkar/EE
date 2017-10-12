package whitefeather.xedge.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import whitefeather.xedge.appconfig.ConfigMethods;
import whitefeather.xedge.core.CloseIconRHSPanels;
import whitefeather.xedge.core.DataGenerator;
import whitefeather.xedge.core.GlobalIcons;
import whitefeather.xedge.core.Page_AddActivity;
import whitefeather.xedge.core.Page_AddNewLead;
import whitefeather.xedge.facilitator.HelperHand;

public class AddNewLeadWithDefaultValues extends HelperHand
{
	@Test
	public static void clickAddLeadPlusIcon()
	{
		try {
			Thread.sleep(2000);
			GlobalIcons.displayAddLeadPlusIcon().click();
			Thread.sleep(2000);
			Reporter.log("User has clicked Add Lead icon.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Add Lead icon.",true);
		}
	}
	
	@Test
	public static void enterEmailAddress() throws Exception
	{
		try {
			try {
				Page_AddNewLead.displayEmailInputField().sendKeys(DataGenerator.randomEmailGenerator());
			/*	
				// Handle Email Already Exists scenario later
				if(Page_AddNewLead.displayEmailExistsErrorMessage().isDisplayed())
				{
					Reporter.log("User has entered already existing Email Address.",true);
					throw new org.openqa.selenium.NoSuchElementException("Email Exists");
				}*/
				Reporter.log("User has entered Email Address successfully",true);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				/*Page_AddNewLead.displayEmailInputField().clear();
				Page_AddNewLead.displayEmailInputField().sendKeys(DataGenerator.randomEmailGenerator());*/
				e.printStackTrace();
			}
		} catch (Exception e) {
			Reporter.log("User has failed to enter Email Address.",true);
			e.printStackTrace();
		}
	}
	
	@Test
	public static void enterMobileNumber()
	{
		try {
			try {
				Page_AddNewLead.displayMobileInputField().sendKeys(Long.toString(DataGenerator.randomMobileNumberGenerator()));
				/*
				//Handle Mobile Already exists scenario later
				if(Page_AddNewLead.displayMobileExistsErrorMessage().isDisplayed())
				{
					Reporter.log("User has entered already existing Mobile number.",true);
					throw new org.openqa.selenium.NoSuchElementException("Mobile Exists");
				}*/
				Reporter.log("User has entered Mobile Number successfully",true);
			} catch (Exception e) {
				/*Page_AddNewLead.displayMobileInputField().clear();
				Page_AddNewLead.displayMobileInputField().sendKeys(Long.toString(DataGenerator.randomMobileNumberGenerator()));*/
			}
		} catch (Exception e) {
			Reporter.log("User has failed to enter Mobile Number.",true);
			e.printStackTrace();
		}
	}
	
	@Test
	public static void selectSeason()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectSeasonDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Season value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Season value.",true);
		}
	}
	
	@Test
	public static void provideActivityType()
	{
		try {
			Thread.sleep(2000);
			ConfigMethods.selectValueFromDropDown(Page_AddActivity.displaySelectActivityTypeDropdown(), Page_AddActivity.driver);
			Page_AddActivity.displayAddActivityCommentBox().sendKeys("This is Activity Comment.");
			Thread.sleep(2000);
			Reporter.log("User has clicked Add Lead icon.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Add Lead icon.",true);
		}
	}
	
	@Test
	public static void clickAddLeadButton()
	{
		try {
			try {
				Page_AddNewLead.displayAddLeadButton().click();
				Reporter.log("User has clicked on Add Lead button successfully.",true);
			} catch (Exception e) {
				e.printStackTrace();
				Reporter.log("User has failed to click on Add Lead button.",true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public static void closeRHSPanel() throws InterruptedException
	{
		try {
			Thread.sleep(3000);
			CloseIconRHSPanels.displayCloseIcon().click();
			Reporter.log("User has clicked Close(X) button on RHS panel.",true);
		} catch (Exception e) {
			Reporter.log("User has failed to click Close(X) button on RHS panel.",true);
			e.printStackTrace();
		}
	}
	
	
}
