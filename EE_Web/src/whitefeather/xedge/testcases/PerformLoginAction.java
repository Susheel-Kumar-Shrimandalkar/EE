package whitefeather.xedge.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.core.Page_Login;
import whitefeather.xedge.facilitator.HelperHand;

public class PerformLoginAction extends HelperHand
{

	public static ObjectMapping properties = new ObjectMapping(Constants.URLs);

	
	@Test
	public void verifyLoginPageBackground()
	{
		try {
			Assert.assertTrue(Page_Login.displayBackgroundImageLoginPage());
			Reporter.log("Background Image on Login Page is displayed",true);
		} catch (AssertionError | Exception e) {
			Reporter.log("Background Image on Login Page is not displayed",true);
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyClientAccountLogo()
	{
		try {
			Assert.assertTrue(Page_Login.displayClientAccountLogo());
			Reporter.log("Client Company Logo is displayed.",true);
		} catch (AssertionError | Exception e) {
			Reporter.log("Account Logo is not displayed.",true);
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyUsernameLabel()
	{
		try {
			Assert.assertTrue(Page_Login.displayUsernameLabel());
			Reporter.log("'Username' label is displayed",true);
		} catch (AssertionError | Exception e) {
			Reporter.log("'Username' label is not displayed",true);
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyUsernamePlaceholder()
	{
		try {
			Assert.assertTrue(Page_Login.displayUsernamePlaceholder());
			Reporter.log("'Username' placeholder is displayed",true);
		} catch (AssertionError | Exception e) {
			Reporter.log("'Username' placeholder is not displayed",true);
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void verifyPasswordLabel()
	{
		try {
			Assert.assertTrue(Page_Login.displayPasswordLabel());
			Reporter.log("'Password' label is displayed",true);
		} catch (AssertionError | Exception e) {
			Reporter.log("'Password' label is not displayed",true);
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void verifyPasswordPlaceholder()
	{
		try {
				Assert.assertTrue(Page_Login.displayPasswordPlaceholder());
				Reporter.log("'Password' placeholder is displayed",true);
		} catch (AssertionError | Exception e) {
			Reporter.log("'Password' placeholder is not displayed",true);
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyUsernameInputField()
	{
		try {
			Assert.assertTrue(Page_Login.displayUsernameInputBox());
			Reporter.log("'Username' input field is displayed",true);
		} catch (AssertionError | Exception e) {
			Reporter.log("'Username' input field is not displayed",true);
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyPasswordInputField()
	{
		try {
			Assert.assertTrue(Page_Login.displayPasswordInputBox());
			Reporter.log("'Password' input field is displayed",true);
		} catch (AssertionError | Exception e) {
			Reporter.log("'Password' input field is not displayed",true);
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyPasswordWrapper()
	{
		try {
			Assert.assertTrue(Page_Login.displayPasswordWrapper());
			Reporter.log("Password wrapper is displayed",true);
		} catch (AssertionError | Exception e) {
			Reporter.log("Password wrapper is not displayed",true);
			e.printStackTrace();
		}
	}
	
	@Test
	@Parameters({"_username"})
	public void enterLoginId(String _username)
	{
		try {
			Page_Login.enterValidUsername().sendKeys(_username);
			Reporter.log("Username is entered successfully.",true);
		} catch (AssertionError | Exception e) {
			Reporter.log("Username is not entered successfully.",true);
			e.printStackTrace();
		}
	}
	
	@Test
	@Parameters({"_password"})
	public void enterLoginPassword(String _password)
	{
		try {
			Page_Login.enterValidPassword().sendKeys(_password);
			Reporter.log("Password is entered successfully.",true);
		} catch (AssertionError | Exception e) {
			Reporter.log("Password is not entered successfully.",true);
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyLoginButton()
	{
		try {
			Assert.assertTrue(Page_Login.displayLoginButton());
			Reporter.log("Login Button is displayed",true);
		} catch (AssertionError | Exception e) {
			Reporter.log("Login Button is not displayed",true);
			e.printStackTrace();
		}
	}

	@Test
	public void clickLoginButton()
	{
		try {
			Page_Login.clickOnLoginButton().click();
			Thread.sleep(3000);
			Assert.assertEquals(driver.getCurrentUrl(), properties.getHomePageUrlAfterLogin(),  "User landed on correct page on Login.");
			Reporter.log("User has clicked Login button and landed on correct homepage.",true);
		} catch (AssertionError | Exception e) {
			Reporter.log("User has clicked Login button but not landed on incorrect homepage.",true);
			e.printStackTrace();
		}
	}
}
