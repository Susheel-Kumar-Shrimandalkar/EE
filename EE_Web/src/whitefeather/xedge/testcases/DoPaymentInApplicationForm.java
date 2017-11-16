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
	public static void validatePaymentMode() throws Exception
	{
		try {
			System.out.println("--------------Validating Payment Mode--------------");
			WebDriverWait wait4 = new WebDriverWait(driver, 30);
			wait4.until(ExpectedConditions.visibilityOf(Page_AppFormPayment.displayPaymentModeSectionInSuccessMessage()));
			Thread.sleep(3000);
			performedPaymentMode = Page_AppFormPayment.displayPaymentModeValueInSuccessMessage().getText();
			System.out.println("Provided Payment Mode: "+performedPaymentMode);
			//Intentional Pause
			Thread.sleep(1000);
			String storedPmntMode = extractDataFromDatabase("pmntDetailsPmntMode");
			System.out.println("Payment Mode value from DB: "+storedPmntMode);
			Assert.assertEquals(performedPaymentMode, storedPmntMode);
			Reporter.log("Provided Payment Mode matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Payment Mode doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateTransactionID() throws Exception
	{
		try {
			System.out.println("--------------Validating Transaction Id--------------");
			WebDriverWait wait4 = new WebDriverWait(driver, 30);
			wait4.until(ExpectedConditions.visibilityOf(Page_AppFormPayment.displayTranscnIdSectionInSuccessMessage()));
			Thread.sleep(3000);
			displayedTransactionId = Page_AppFormPayment.displayTranscnIdSectionInSuccessMessage().getText();
			System.out.println("Provided Transaction Id: "+displayedTransactionId);
			//Intentional Pause
			Thread.sleep(1000);
			String storedTrnscnId = extractDataFromDatabase("pmntDetailsTranscnID");
			System.out.println("Transaction Id value from DB: "+storedTrnscnId);
			Assert.assertEquals(displayedTransactionId, storedTrnscnId);
			Reporter.log("Provided Transaction Id matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Transaction Id doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateAmountPaid() throws Exception
	{
		try {
			System.out.println("--------------Validating Amount Paid--------------");
			WebDriverWait wait4 = new WebDriverWait(driver, 30);
			wait4.until(ExpectedConditions.visibilityOf(Page_AppFormPayment.displayAmountSectionInSuccessMessage()));
			Thread.sleep(3000);
			displayedAmount = Page_AppFormPayment.displayAmountSectionInSuccessMessage().getText();
			System.out.println("Provided Amount Paid: "+displayedAmount);
			//Intentional Pause
			Thread.sleep(1000);
			String storedPaidAmount = extractDataFromDatabase("pmntDetailsAmount");
			System.out.println("Amount Paid value from DB: "+storedPaidAmount);
			Assert.assertEquals(displayedAmount, storedPaidAmount);
			Reporter.log("Provided Amount Paid matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Amount Paid doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateSuccessfulPDFGenerationAndSending() throws Exception
	{
		try {
			System.out.println("--------------Validating PDF Generated and Sent Over Email--------------");
			WebDriverWait wait4 = new WebDriverWait(driver, 30);
			wait4.until(ExpectedConditions.visibilityOf(Page_AppFormPayment.displaySuccessulPaymentMessage()));
			Thread.sleep(3000);
			//Temp way to validate PDF is generated and sent to email successfully
			String pdfSentConfirmation = "ApplicationFormEmailPdf";
			//Intentional Pause
			Thread.sleep(1000);
			String storedPdfConfirmation = extractDataFromDatabase("pdfGeneratedAndSent");
			Assert.assertEquals(pdfSentConfirmation, storedPdfConfirmation);
			Reporter.log("PDF with all Lead Details and successful transaction details is generated and sent to lead's email address successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Transaction is failed and hence to PDF is generated.",true);
		}
	}
}
