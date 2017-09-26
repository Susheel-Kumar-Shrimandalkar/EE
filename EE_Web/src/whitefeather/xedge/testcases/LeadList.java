package whitefeather.xedge.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.appservices.APIDataProvider;
import whitefeather.xedge.core.Page_LeadList;
import whitefeather.xedge.facilitator.HelperHand;

public class LeadList extends HelperHand
{
	public static ObjectMapping properties = new ObjectMapping(Constants.URLs);
	
	@Test
	public static void verifyLeadListPageURL()
	{
		try {
			Page_LeadList.getLeadListPageURL().click();
			Assert.assertEquals(driver.getCurrentUrl(), properties.getLeadListPageURL());
			Thread.sleep(3000);
			Reporter.log("Lead List Page URL is correct.", true);
		}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Lead List Page URL is incorrect.", true);
		}
	}
	
	@Test
	public static void verifyAllTabIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displayAllTab().isDisplayed());
				Reporter.log("All Tab is displayed.", true);
		} catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("All Tab is not displayed", true);
		}
	}
	
	@Test
	public static void verifyAllTabCount()
	{
		try {
				Assert.assertEquals(Page_LeadList.displayAllTabCount(), APIDataProvider.getAllTabCount());
				Reporter.log("All Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("All Tab Count displayed is incorrect.", true);
		}
	}
	
	@Test
	public static void verifyNewTabIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displayNewTab().isDisplayed());
				Reporter.log("New Tab is displayed.", true);
		} catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("New Tab is not displayed", true);
		}
	}
	
	@Test
	public static void verifyNewTabCount()
	{
		try {
				Assert.assertEquals(Page_LeadList.displayNewTabCount(), APIDataProvider.getNewTabCount());
				Reporter.log("New Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("New Tab Count displayed is incorrect.", true);
		}
	}
	
	@Test
	public static void verifyCallbackTabIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displayCallBackTab().isDisplayed());
				Reporter.log("Callback Tab is displayed.", true);
		} catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Callback Tab is not displayed", true);
		}
	}
	
	@Test
	public static void verifyCallbackTabCount()
	{
		try {
				Assert.assertEquals(Page_LeadList.displayCallBackTabCount(), APIDataProvider.getCallBackTabCount());
				Reporter.log("Callback Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Callback Tab Count displayed is incorrect.", true);
		}
	}
	
	@Test
	public static void verifyWalkinTabIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displayWalkinTab().isDisplayed());
				Reporter.log("Walkin Tab is displayed.", true);
		} catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Walkin Tab is not displayed", true);
		}
	}
	
	@Test
	public static void verifyWalkinTabCount()
	{
		try {
				Assert.assertEquals(Page_LeadList.displayWalkinTabCount(), APIDataProvider.getWalkinTabCount());
				Reporter.log("Walkin Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Walkin Tab Count displayed is incorrect.", true);
		}
	}
	
	@Test
	public static void verifyEnrolledTabIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displayEnrolledTab().isDisplayed());
				Reporter.log("Enrolled Tab is displayed.", true);
		} catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Enrolled Tab is not displayed", true);
		}
	}
	
	@Test
	public static void verifyEnrolledTabCount()
	{
		try {
				Assert.assertEquals(Page_LeadList.displayEnrolledTabCount(), APIDataProvider.getEnrolledTabCount());
				Reporter.log("Enrolled Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Enrolled Tab Count displayed is incorrect.", true);
		}
	}
	
	@Test
	public static void verifyClosedTabIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displayClosedTab().isDisplayed());
				Reporter.log("Closed Tab is displayed.", true);
		} catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Closed Tab is not displayed", true);
		}
	}
	
	@Test
	public static void verifyClosedTabCount()
	{
		try {
				Assert.assertEquals(Page_LeadList.displayClosedTabCount(), APIDataProvider.getClosedTabCount());
				Reporter.log("Closed Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Closed Tab Count displayed is incorrect.", true);
		}
	}
	
	@Test
	public static void verifyOnlineTabIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displayOnlineTab().isDisplayed());
				Reporter.log("Online Tab is displayed.", true);
		} catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Online Tab is not displayed", true);
		}
	}
	
	@Test
	public static void verifyOnlineTabCount()
	{
		try {
				Assert.assertEquals(Page_LeadList.displayOnlineTabCount(), APIDataProvider.getOnlineTabCount());
				Reporter.log("Online Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Online Tab Count displayed is incorrect.", true);
		}
	}
	
	@Test
	public static void verifyReferredFromMeTabIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displayReferredFromMeTab().isDisplayed());
				Reporter.log("Referred From Me Tab is displayed.", true);
		} catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Referred From Me Tab is not displayed", true);
		}
	}
	
	@Test
	public static void verifyReferredFromMeTabCount()
	{
		try {
				Assert.assertEquals(Page_LeadList.displayReferredFromMeTabCount(), APIDataProvider.getReferredFromMeTabCount());
				Reporter.log("Referred From Me Tab Count displayed is correct.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Referred From Me Tab Count displayed is incorrect.", true);
		}
	}
	
	@Test
	public static void verifyCampaignIconIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displayCampaignIcon().isDisplayed());
				Reporter.log("Campaign Icon is displayed.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Campaign Icon is not 	displayed.", true);
		}
	}
	
	@Test
	public static void addNewCampaign()
	{
		try {
			Page_LeadList.displayCampaignIcon().click();
			if (Page_LeadList.displayModal().isDisplayed())
			{
				Assert.assertEquals("Add Campaign", Page_LeadList.displayModal().getText());
				Reporter.log("User has successfully added new campaign.", true);
				Page_LeadList.displayModalCloseButton().click();
			}		
			//Validation to be done later
			
		} catch (AssertionError e) {
			Assert.fail();
			Reporter.log("User has failed to add new campaign.", true);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public static void verifyReferAllLeadsIconIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displayReferAllLeadsIcon().isDisplayed());
				Reporter.log("Refer All Leads Icon is displayed.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Refer All Leads Icon is not displayed.", true);
		}
	}
	
	@Test
	public static void referAllLeads()
	{
		try {
			Page_LeadList.displayReferAllLeadsIcon().click();
			if (Page_LeadList.displayModal().isDisplayed())
			{
				Assert.assertEquals("Refer Lead", Page_LeadList.displayModal().getText());
				Reporter.log("User has referred all leads successfully.", true);
				Page_LeadList.displayModalCloseButton().click();
			}		
			//Validation to be done later
			
		} catch (AssertionError e) {
			Assert.fail();
			Reporter.log("User has failed to refer all leads.", true);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public static void verifySendSMSToAllLeadsIconIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displaySendSMSToAllLeadsIcon().isDisplayed());
				Reporter.log("Send SMS To All Icon is displayed.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Send SMS To All Icon is not displayed.", true);
		}
	}
	
	@Test
	public static void sendSMSToAllLeads()
	{
		try {
			Page_LeadList.displaySendSMSToAllLeadsIcon().click();
			if (Page_LeadList.displayModal().isDisplayed())
			{
				Assert.assertEquals("Send Sms", Page_LeadList.displayModal().getText());
				Reporter.log("User has sent SMS to all leads successfully.", true);
				Page_LeadList.displayModalCloseButton().click();
			}		
			//Validation to be done later
			
		} catch (AssertionError e) {
			Assert.fail();
			Reporter.log("User has failed to send SMS to all leads.", true);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public static void verifySendEmailToAllLeadsIconIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displaySendEmailToAllLeadsIcon().isDisplayed());
				Reporter.log("Send Email To All Icon is displayed.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Send Email To All Icon is not displayed.", true);
		}
	}
	
	@Test
	public static void sendEmailToAllLeads()
	{
		try {
			Page_LeadList.displaySendEmailToAllLeadsIcon().click();
			if (Page_LeadList.displayModal().isDisplayed())
			{
				Assert.assertEquals("Send Email", Page_LeadList.displayModal().getText());
				Reporter.log("User has sent Email to all leads successfully.", true);
				Page_LeadList.displayModalCloseButton().click();
			}		
			//Validation to be done later
			
		} catch (AssertionError e) {
			Assert.fail();
			Reporter.log("User has failed to send Email to all leads.", true);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public static void verifyRefreshLeadDataIconIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displayRefreshIcon().isDisplayed());
				Reporter.log("Send Email To All Icon is displayed.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Send Email To All Icon is not displayed.", true);
		}
	}
	
	@Test
	public static void refreshAllLeadsData()
	{
		//To be done later
	}
	
	@Test
	public static void verifyDownloadDataIconIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displayDownloadLeadsDataIcon().isDisplayed());
				Reporter.log("Download Leads Data Icon is displayed.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Download Leads Data Icon is not displayed.", true);
		}
	}
	
	@Test
	public static void downloadLeadsData()
	{
		try {
			Page_LeadList.displayDownloadLeadsDataIcon().click();
			if (Page_LeadList.displayModal().isDisplayed())
			{
				Assert.assertEquals("Download Data", Page_LeadList.displayModal().getText());
				Reporter.log("User has successfully downloaded the leads data.", true);
				//Validation to be done later
				Page_LeadList.displayModalCloseButton().click();
			}		
			//Validation to be done later
			
		} catch (AssertionError e) {
			Assert.fail();
			Reporter.log("User has failed to download the leads data.", true);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public static void verifyFilterLeadsIconIsDisplayed()
	{
		try {
				Assert.assertTrue(Page_LeadList.displayFilterLeadsDataIcon().isDisplayed());
				Reporter.log("Filter Leads Data Icon is displayed.", true);
			}
		catch (AssertionError | Exception e) 
		{
			Assert.fail();
			Reporter.log("Filter Leads Data Icon is not displayed.", true);
		}
	}
	
	@Test
	public static void filterLeadsData()
	{
		try {
			Page_LeadList.displayFilterLeadsDataIcon().click();
			Assert.assertTrue(Page_LeadList.displayFilterLeadsPanel().isDisplayed());
				Reporter.log("User has successfully filtered the leads data.", true);
				//Validation to be done later
		} catch (AssertionError e) {
			Assert.fail();
			Reporter.log("User has failed to Filter the leads data.", true);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
