package whitefeather.xedge.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.appservices.APIDataProvider;
import whitefeather.xedge.core.Page_UpcomingTask;
import whitefeather.xedge.facilitator.HelperHand;

public class UpcomingTasks extends HelperHand
{
	public static ObjectMapping properties = new ObjectMapping(Constants.URLs);
	
	@Test
	public static void verifyRecentNewTabIsDisplayed()
	{
		try {
			if(Page_UpcomingTask.displayRecentNewTab().isDisplayed())
			{
				Assert.assertTrue(Page_UpcomingTask.displayRecentNewTab().isDisplayed());
				Reporter.log("Recent New Tab and Count are displayed.", true);
			}
		} catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Recent New Tab is not displayed");
		}
	}
	
	@Test
	public static void verifyRecentNewTabCount()
	{
		try {
				Assert.assertEquals(Page_UpcomingTask.displayRecentNewTabCount(), APIDataProvider.getNewTabCount());
				Reporter.log("Recent New Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Recent New Tab Count displayed is incorrect");
		}
	}
	
	@Test
	public static void verifyDashboardURL()
	{
		try {
			Refresh_Page.refreshWebPage();
			Assert.assertEquals(Page_UpcomingTask.getDashboardPageURL(), properties.getDashboardPageURL());
			Reporter.log("Recent New Tab Count displayed is correct.", true);
		}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Recent New Tab Count displayed is incorrect");
		}
	}
}
