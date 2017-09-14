package whitefeather.xedge.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import whitefeather.xedge.core.Page_ForgotPassword;
import whitefeather.xedge.core.Page_Login;
import whitefeather.xedge.facilitator.HelperHand;

public class ForgotPassword extends HelperHand
{
	@Test
	public void openForgotPasswordWindow()
	{
		try {
			Page_Login.displayForgotPasswordLink().click();
			Reporter.log("User has clicked Forgot Password Link on Login window.", true);
			Assert.assertTrue(Page_ForgotPassword.displayRecoveryLabel().isDisplayed(), "User has opened Forgot Password window.");
//			System.out.println("Check: "+Reporter.getCurrentTestResult());
		} catch (Exception e) {
			Assert.fail();
			Reporter.log("User has failed to open Forgot Password window.", true);
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyCompanyLogo()
	{
		try {
			Assert.assertTrue(Page_ForgotPassword.displayCompanyLogo().isDisplayed(), "Company Logo on Forgot Password window is displayed");
			Reporter.log("Company Logo on Forgot Password is displayed",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Company Logo on Forgot Password is not displayed",true);

		}
	}
	
	@Test
	public void verifyRecoveryLabel()
	{
		try {
			Assert.assertTrue(Page_ForgotPassword.displayRecoveryLabel().isDisplayed(), "Recovery Label on Forgot Password window is displayed");
			Reporter.log("Recovery Label on Forgot Password is displayed",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Recovery Label on Forgot Password is not displayed",true);

		}
	}
	
	@Test
	public void verifyRecoveryMessage()
	{
		try {
			Assert.assertTrue(Page_ForgotPassword.displayRecoveryMessage().isDisplayed(), "Recovery Message on Forgot Password window is displayed");
			Reporter.log("Recovery Message on Forgot Password is displayed",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Recovery Message on Forgot Password is not displayed",true);

		}
	}
	
	@Test
	public void verifyEmailInputBox()
	{
		try {
			Assert.assertTrue(Page_ForgotPassword.displayEmailInputBox().isDisplayed(), "Email Input Box on Forgot Password window is displayed");
			Reporter.log("Email Input Box on Forgot Password is displayed",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Email Input Box on Forgot Password is not displayed",true);

		}
	}
	
	@Test
	public void verifyLoginLink()
	{
		try {
			Assert.assertTrue(Page_ForgotPassword.displayLoginLink().isDisplayed(), "Login Link on Forgot Password window is displayed");
			Reporter.log("Login Link on Forgot Password is displayed",true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Login Link on Forgot Password is not displayed",true);

		}
	}
	
	@Test
	public void verifySubmitButton()
	{
		try {
			Assert.assertTrue(Page_ForgotPassword.displaySubmitButton().isDisplayed(), "Login Link on Forgot Password window is displayed");
			Reporter.log("Login Link on Forgot Password is displayed",true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Login Link on Forgot Password is not displayed",true);

		}
	}
	
	@Parameters({"recoveryEmail"})
	@Test
	public void enterRecoveryEmail(String recoveryEmail)
	{
		try {
			Page_ForgotPassword.displayEmailInputBox().sendKeys(recoveryEmail);
			Page_ForgotPassword.displaySubmitButton().click();
			Thread.sleep(1000);
			if(Page_ForgotPassword.displayResetPasswordLinkSuccessMessage().isDisplayed())
			{
				Page_ForgotPassword.displayLoginButton().click();
				Thread.sleep(1000);//Implement explicit wait later
				Refresh_Page.refreshWebPage();
				Page_Login.enterValidUsername().click();
				Reporter.log("Reset Password Link is successfully sent to provided email address",true);
			}
			else if(Page_ForgotPassword.displayResetPasswordLinkFailureMessage().isDisplayed())
			{
				Page_ForgotPassword.displayForgotPasswordButton().click();
				Page_ForgotPassword.displayLoginLink().click();
				Assert.fail();
				Reporter.log("Provided email address is not registered with the system.",true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
