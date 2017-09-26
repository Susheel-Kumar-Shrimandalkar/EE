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
	public static void verifyDashboardURL()
	{
		try {
			Refresh_Page.refreshWebPage();
			Assert.assertEquals(Page_UpcomingTask.getDashboardPageURL(), properties.getDashboardPageURL());
			Thread.sleep(3000);
			Reporter.log("Dashboard URL is correct.", true);
		}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Dashboard URL is incorrect.");
		}
	}
	
	@Test
	public static void verifyRecentNewTabIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_UpcomingTask.displayRecentNewTab().isDisplayed());
				Reporter.log("Recent New Tab is displayed.", true);
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
			Assert.assertEquals(Page_UpcomingTask.displayRecentNewTabCount(), APIDataProvider.getRecentNewTabCount());
				Reporter.log("Recent New Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Recent New Tab Count displayed is incorrect.");
		}
	}
	
	@Test
	public static void verifyRecentOnlineTabIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_UpcomingTask.displayRecentOnlineTab().isDisplayed());
				Reporter.log("Recent Online Tab is displayed.", true);
		} catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Recent Online Tab is not displayed");
		}
	}
	
	@Test
	public static void verifyRecentOnlineTabCount()
	{
		try {
				Assert.assertEquals(Page_UpcomingTask.displayRecentOnlineTabCount(), APIDataProvider.getRecentOnlineTabCount());
				Reporter.log("Recent Online Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Recent Online Tab Count displayed is incorrect");
		}
	}
	
	@Test
	public static void verifyUpcomingFollowupTabIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_UpcomingTask.displayUpcomingFollowupTab().isDisplayed());
				Reporter.log("Upcoming Followup Tab is displayed.", true);
		} catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Upcoming Followup Tab is not displayed");
		}
	}
	
	@Test
	public static void verifyUpcomingFollowupTabCount()
	{
		try {
				Assert.assertEquals(Page_UpcomingTask.displayUpcomingFollowupTabCount(), APIDataProvider.getUpcomingFollowupTabCount());
				Reporter.log("Upcoming Followup Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Upcoming Followup Tab Count displayed is incorrect");
		}
	}
	
	@Test
	public static void verifyUpcomingWalkinsTabIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_UpcomingTask.displayUpcomingWalkinsTab().isDisplayed());
				Reporter.log("Upcoming Walkins Tab is displayed.", true);
		} catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Upcoming Walkins Tab is not displayed");
		}
	}
	
	@Test
	public static void verifyUpcomingWalkinsTabCount()
	{
		try {
				Assert.assertEquals(Page_UpcomingTask.displayUpcomingWalkinsTabCount(), APIDataProvider.getUpcomingWalkinsTabCount());
				Reporter.log("Upcoming Walkins Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Upcoming Walkins Tab Count displayed is incorrect");
		}
	}
	
	@Test
	public static void verifyHighPriorityTabIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_UpcomingTask.displayHighPriorityTab().isDisplayed());
				Reporter.log("High Priority Tab is displayed.", true);
		} catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("High Priority Tab is not displayed");
		}
	}
	
	@Test
	public static void verifyHighPriorityTabCount()
	{
		try {
				Assert.assertEquals(Page_UpcomingTask.displayHighPriorityTabCount(), APIDataProvider.getHighPriorityTabCount());
				Reporter.log("High Priority Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("High Priority Tab Count displayed is incorrect");
		}
	}
}
