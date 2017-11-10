package whitefeather.xedge.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import whitefeather.xedge.core.Page_AppFormPayment;
import whitefeather.xedge.facilitator.HelperHand;

public class DoPaymentInApplicationForm extends HelperHand
{
	public static String providedCourseFeeAmount, performedPaymentMode, displayedTransactionId, displayedAmount;
	
	@Test
	public static void clickLoginLinkForPaytmPayment() throws Exception
	{
		System.out.println("\n"+"*********************** Filling up Payment Information ***************************"+"\n");

		try 
		{
			Thread.sleep(3000);
			Page_AppFormPayment.displayLoginLink().click();
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
			Thread.sleep(3000);
			Page_AppFormPayment.moveToLoginModal();
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
	
	@Test
	public static void validateAmountToBePaid() throws Exception
	{
		try {
			System.out.println("--------------Validating Amount To Be Paid--------------");
			WebDriverWait wait4 = new WebDriverWait(driver, 30);
			wait4.until(ExpectedConditions.visibilityOf(Page_AppFormPayment.displayAmountToBePaidOnPaymentPage()));
			Thread.sleep(3000);
			providedCourseFeeAmount = Page_AppFormPayment.displayAmountToBePaidOnPaymentPage().getText();
			System.out.println("Provided Amount To Be Paid: "+providedCourseFeeAmount);
			//Intentional Pause
			Thread.sleep(1000);
			String storedCourseFee = extractDataFromDatabase("pricingAmount");
			System.out.println("Amount To Be Paid value from DB: "+storedCourseFee);
			Assert.assertEquals(providedCourseFeeAmount, storedCourseFee);
			Reporter.log("Provided Amount To Be Paid matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Amount To Be Paid doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void clickPayNowButtonPaytmPaymentPage() throws Exception
	{
		try 
		{
			Thread.sleep(3000);
			Page_AppFormPayment.displayPayNowButtonOnPaymentPage().click();
			Reporter.log("User has clicked Pay Now Button on Payment window of Paytm Account successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Pay Now Button on Payment window of Paytm Account.",true);
		}
	}
	
	@Test
	public static void validateSuccessfulPayment() throws Exception
	{
		try 
		{
			Thread.sleep(3000);
			Assert.assertTrue(Page_AppFormPayment.displaySuccessulPaymentMessage().isDisplayed());
			Assert.assertTrue(Page_AppFormPayment.displayPaymentModeSectionInSuccessMessage().isDisplayed());
			Assert.assertTrue(Page_AppFormPayment.displayTranscnIdSectionInSuccessMessage().isDisplayed());
			Assert.assertTrue(Page_AppFormPayment.displayAmountSectionInSuccessMessage().isDisplayed());
			
			performedPaymentMode = Page_AppFormPayment.displayPaymentModeValueInSuccessMessage().getText();
			displayedTransactionId = Page_AppFormPayment.displayTranscnIdValueInSuccessMessage().getText();
			displayedAmount = Page_AppFormPayment.displayAmountValueInSuccessMessage().getText();
			
			//Validate Payment Mode
			Assert.assertEquals(performedPaymentMode, extractDataFromDatabase("pmntDetailsPmntMode"));
			
			//Validate Transaction ID
			Assert.assertEquals(displayedTransactionId, extractDataFromDatabase("pmntDetailsTranscnID"));
			
			//Validate Payment Amount
			Assert.assertEquals(displayedAmount, extractDataFromDatabase("pmntDetailsAmount"));

			
			Reporter.log("All Details diplayed on Successful Payment Message are correct.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("Some or all details diplayed on Successful Payment Message are incocorrect",true);
		}
	}
}
