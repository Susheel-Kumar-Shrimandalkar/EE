package whitefeather.xedge.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import whitefeather.xedge.core.GlobalIcons;
import whitefeather.xedge.facilitator.HelperHand;

public class VerifyGlobalIcons extends HelperHand
{
	
	@Test
	public void verifyCompanyLogoInHeader()
	{
		try {
			Assert.assertTrue(GlobalIcons.displayCompanyLogoInHeader().isDisplayed(), "Company Logo in header is displayed");
			Reporter.log("Company Logo in header is displayed",true);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			Reporter.log("Company Logo in header is not displayed",true);
		}
	}
	
	@Test
	public void verifyGoButtonInGlobalSearchBar()
	{
		try {
			Assert.assertTrue(GlobalIcons.displayGoButtonInGlobalSearchBar().isDisplayed(), "Go Button in header is displayed");
			Reporter.log("Go Button in header is displayed",true);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			Reporter.log("Go Button in header is not displayed",true);
		}
	}
	
	@Test
	public void verifyOutStandingActivityIcon()
	{
		try {
			Assert.assertTrue(GlobalIcons.displayOutStandingActivityIcon().isDisplayed(), "OutStanding Activity Icon in header is displayed");
			Reporter.log("OutStanding Activity Icon in header is displayed",true);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			Reporter.log("OutStanding Activity Icon in header is not displayed",true);
		}
	}
	
	@Test
	public void verifyOutStandingActivityCount()
	{
		try {
			Assert.assertTrue(GlobalIcons.displayOutStandingActivityCount().isDisplayed(), "OutStanding Activity Count in header is displayed");
			Reporter.log("OutStanding Activity Count in header is displayed",true);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			Reporter.log("OutStanding Activity Count in header is not displayed",true);
		}
	}
	
	@Test
	public void verifyCounselorName()
	{
		try {
			Assert.assertTrue(GlobalIcons.displayCounselorName().isDisplayed(), "Counselor Name in header is displayed");
			Reporter.log("Counselor Name in header is displayed",true);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			Reporter.log("Counselor Name in header is not displayed",true);
		}
	}
	
	@Test
	public void verifyCounselorPhoto()
	{
		try {
			Assert.assertTrue(GlobalIcons.displayCounselorPhoto().isDisplayed(), "Counselor Photo in header is displayed");
			Reporter.log("Counselor Photo in header is displayed",true);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			Reporter.log("Counselor Photo in header is not displayed",true);
		}
	}
	
	@Test
	public void verifySignOutLink()
	{
		try {
			Assert.assertTrue(GlobalIcons.displaySignOutLink().isDisplayed(), "Sign Out link in header is displayed");
			Reporter.log("Sign Out link in header is displayed",true);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			Reporter.log("Sign Out link in header is not displayed",true);
		}
	}
	
	@Test
	public void verifyBulkUploadIcon()
	{
		try {
			Assert.assertTrue(GlobalIcons.displayBulkUploadIcon().isDisplayed(), "Bulk Upload icon is displayed");
			Reporter.log("Bulk Upload icon is displayed",true);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			Reporter.log("Bulk Upload icon is not displayed",true);
		}
	}
	
	@Test
	public void verifyAddLeadPlusIcon()
	{
		try {
			Assert.assertTrue(GlobalIcons.displayAddLeadPlusIcon().isDisplayed(), "Add LeadPlus icon is displayed");
			Reporter.log("Add LeadPlus icon is displayed",true);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			Reporter.log("Add LeadPlus icon is not displayed",true);
		}
	}
	
	@Test
	public void verifyJoyRideButton()
	{
		try {
			Assert.assertTrue(GlobalIcons.displayJoyRideButton().isDisplayed(), "JoyRide button is displayed");
			Refresh_Page.refreshWebPage();
			Reporter.log("JoyRide button is displayed",true);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
			Reporter.log("JoyRide button is not displayed",true);
		}
	}

}
