package whitefeather.xedge.testcases;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import whitefeather.xedge.core.Page_AppFormPayment;
import whitefeather.xedge.facilitator.HelperHand;

public class DoPaymentInApplicationForm extends HelperHand
{
	
	@Test
	public static void clickLoginLinkForPaytmPayment() throws Exception
	{
		try 
		{
			Page_AppFormPayment.displayLoginLink().click();
			Thread.sleep(3000);
			Reporter.log("User has clicked Login Link for Paytm Account successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Login Link for Paytm Account.",true);
		}
	}

	@Test
	@Parameters({"paytmUsername"})	
	public static void providePaytmAccoutUsername(String paytmUsername) throws Exception
	{
		try 
		{
			Page_AppFormPayment.displayLoginUsername().click();
			Thread.sleep(1000);
			Page_AppFormPayment.displayLoginUsername().sendKeys(paytmUsername);
			Reporter.log("User has entered Username value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Username value.",true);
		}
	}
	
	@Test
	public static void clickRequestOTPButtonForPaytmPayment() throws Exception
	{
		try 
		{
			Page_AppFormPayment.displayRequestOTPButton().click();
			Thread.sleep(2000);
			Reporter.log("User has clicked Request OTP Button on Login window of Paytm Account successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Request OTP Button on Login window of Paytm Account.",true);
		}
	}
	
	@Test
	@Parameters({"paytmPaymentOTP"})	
	public static void provideLoginOTPReceived(String paytmPaymentOTP) throws Exception
	{
		try 
		{
			Thread.sleep(3000);
			Page_AppFormPayment.displayOTPInputField().sendKeys(paytmPaymentOTP);
			Reporter.log("User has entered OTP value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide OTP value.",true);
		}
	}
	
	@Test
	public static void clickLoginButtonPaytmLoginWindow() throws Exception
	{
		try 
		{
			Thread.sleep(3000);
			Page_AppFormPayment.displayLoginButtonPaytmLoginWindow().click();
			Reporter.log("User has clicked Login Button on Login window of Paytm Account successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Login Button on Login window of Paytm Account.",true);
		}
	}
}
