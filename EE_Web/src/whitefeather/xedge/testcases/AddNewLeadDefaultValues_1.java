package whitefeather.xedge.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import whitefeather.xedge.core.CloseIconRHSPanels;
import whitefeather.xedge.core.DataGenerator;
import whitefeather.xedge.core.Page_AddActivity;
import whitefeather.xedge.core.Page_AddNewLeadWithDefaultValues;

public class AddNewLeadDefaultValues_1 
{
	@Test
	public static void enterProspectEmailID()
	{
		try {
			Page_AddNewLeadWithDefaultValues.enterProspectEmailAddress().sendKeys(DataGenerator.randomEmailGenerator());
			//Handle Email Already Exist Message Scenario later
			Reporter.log("User has entered email address successfully",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter email address.",true);
		}
	}
	
	@Test
	public static void enterProspectMobileNo()
	{
		try {
			Page_AddNewLeadWithDefaultValues.enterProspectMobileNumber().sendKeys(Long.toString(DataGenerator.randomMobileNumberGenerator()));
			//Handle Mobile Already Exist Message Scenario later
			Reporter.log("User has entered mobile number successfully",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter mobile number.",true);
		}
	}
	
	@Test
	public static void selectActivityType()
	{
		try {
			AddActivity.verifySelectActivityType();
			//Handle Mobile Already Exist Message Scenario later
			Reporter.log("User has entered email address successfully",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter email address.",true);
		}
	} 
	
	@Test
	public static void addActivityComment()
	{
		try {
			AddActivity.verifyAddActivityCommentBox();
			//Handle Mobile Already Exist Message Scenario later
			Reporter.log("User has entered email address successfully",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter email address.",true);
		}
	} 
	
	@Test
	public static void clickAddLeadButton() throws InterruptedException
	{
		
		try {
			Thread.sleep(1000);
			Page_AddNewLeadWithDefaultValues.clickAddLeadButtonOnRHSPanel().click();
			if(CloseIconRHSPanels.displayCloseIcon().isDisplayed())
			{
				CloseIconRHSPanels.displayCloseIcon().click();
			}
			Reporter.log("User has clicked Add Lead button on RHS panel.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Add Lead button on RHS panel.",true);
			Assert.fail();
		}
	}

}
