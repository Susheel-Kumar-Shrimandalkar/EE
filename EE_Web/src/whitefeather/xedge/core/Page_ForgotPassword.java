package whitefeather.xedge.core;

import org.openqa.selenium.WebElement;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_ForgotPassword extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	
	public static WebElement displayCompanyLogo()
	{
		try {
			element = driver.findElement(properties.selectLocator("forgotPassword_CompanyLogo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayRecoveryLabel()
	{
		try {
			element = driver.findElement(properties.selectLocator("forgotPassword_RecoveryLabel"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayRecoveryMessage()
	{
		try {
			element = driver.findElement(properties.selectLocator("forgotPassword_RecoveryMessage"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayEmailInputBox()
	{
		try {
			element = driver.findElement(properties.selectLocator("forgotPassword_emailInput"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayResetPasswordLinkSuccessMessage()
	{
		try {
			element = driver.findElement(properties.selectLocator("forgotPassword_ResetPasswordSuccessMessage"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayResetPasswordLinkFailureMessage()
	{
		try {
			element = driver.findElement(properties.selectLocator("forgotPassword_ResetPasswordFailureMessage"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySubmitButton()
	{
		try {
			element = driver.findElement(properties.selectLocator("forgotPassword_SubmitButton"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayForgotPasswordButton()
	{
		try {
			element = driver.findElement(properties.selectLocator("forgotPassword_ForgotPasswordButton"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayLoginButton()
	{
		try {
			element = driver.findElement(properties.selectLocator("forgotPassword_LoginButtonOnPasswordRecovery"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayLoginLink()
	{
		try {
			element = driver.findElement(properties.selectLocator("forgotPassword_LogInLink"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
}
