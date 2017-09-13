package whitefeather.xedge.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import whitefeather.xedge.core.Page_ForgotPassword;

public class ForgotPassword 
{
	@Test
	public void verifyCompanyLogo()
	{
		try {
			Assert.assertTrue(Page_ForgotPassword.displayCompanyLogo().isDisplayed(), "Company Logo on Forgot Password window is displayed");
			Reporter.log("Company Logo on Forgot Password is displayed");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Company Logo on Forgot Password is not displayed");

		}
	}
	
	@Test
	public void verifyRecoveryLabel()
	{
		try {
			Assert.assertTrue(Page_ForgotPassword.displayRecoveryLabel().isDisplayed(), "Recovery Label on Forgot Password window is displayed");
			Reporter.log("Recovery Label on Forgot Password is displayed");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Recovery Label on Forgot Password is not displayed");

		}
	}

}
