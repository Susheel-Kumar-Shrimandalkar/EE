package whitefeather.xedge.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import whitefeather.xedge.core.Page_AddActivity;
import whitefeather.xedge.facilitator.HelperHand;

public class AddActivity extends HelperHand
{
	@Test
	public static boolean verifySelectActivityTypeIsDisplayed()
	{
		try {
			visibleFlag = Page_AddActivity.selectActivityType().isDisplayed();
			Reporter.log("SelectActivityType dropdown is provided successfully", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("SelectActivityType dropdown is not provided successfully", true);
		}
		return visibleFlag;
	}
	
	@Test
	public static void verifySelectActivityType() throws InterruptedException
	{
		Thread.sleep(4000);
		try {
			if(verifySelectActivityTypeIsDisplayed())
			{
				Actions builder = new Actions(driver);
				Action seriesOfActions = builder
			              .moveToElement(Page_AddActivity.selectActivityType())
			              .click()
			              .sendKeys(Keys.DOWN)
			              .sendKeys(Keys.DOWN)//Number of Down Key Press = Position of value from drop down
			              .sendKeys(Keys.RETURN)
			              .build();
				seriesOfActions.perform();
				Reporter.log("Activity Type is provided successfully", true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provided activity type.", true);
		}
	}
	
	@Test
	public static boolean verifyAddActivityCommentBoxIsDisplayed()
	{
		try {
			visibleFlag = Page_AddActivity.displayAddActivityCommentBox().isDisplayed();
			Reporter.log("Add Activity Comment box is displayed.", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Add Activity Comment box is not displayed.", true);
		}
		return visibleFlag;
	}
	
	@Test
	public static void verifyAddActivityCommentBox()
	{
		try {
			Thread.sleep(1000);
			if(verifyAddActivityCommentBoxIsDisplayed())
			{
				Page_AddActivity.displayAddActivityCommentBox().sendKeys("Comment for "+prospectEmail);
			}
			Reporter.log("Activity Comment is added successfully", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to Add Activity Comment.", true);
		}
	}	
	
	@Test
	public static boolean verifyAddActivityButtonIsDisplayed()
	{
		try {
			visibleFlag = Page_AddActivity.displayAddActivityButton().isDisplayed();
			Reporter.log("Add Activity button is displayed.", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Add Activity button is not displayed.", true);
		}
		return visibleFlag;
	}
	
	@Test
	public static void verifyAddActivityButton()
	{
		try {
			Thread.sleep(1000);
			if(verifyAddActivityButtonIsDisplayed())
			{
				Page_AddActivity.displayAddActivityButton().click();
				//Validate later using Toaster Message
			}
			Reporter.log("Add Activity button is working successfully.", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to Add Activity Comment.", true);

		}	
	}
	
	//Date and Time - To be done later
	
}

