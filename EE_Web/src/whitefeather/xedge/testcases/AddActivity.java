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
	public static void addActivity() throws InterruptedException
	{
		Thread.sleep(4000);
		try {
			Page_AddActivity.selectActivityType();
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
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provided activity type.", true);
		}
		
		try {
			Thread.sleep(1000);

			Page_AddActivity.clickAddActivityButton().click();;
			Reporter.log("Activity is added successfully", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Add Activity button.", true);

		}
	}
}
