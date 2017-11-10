package whitefeather.xedge.core;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_AppFormPayment extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);
	
	public static WebElement displayLoginLink() throws Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("AppFormPaymentPage_LoginLink")));
			element =driver.findElement(properties.selectLocator("AppFormPaymentPage_LoginLink"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static void moveToLoginModal()
	{
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
		driver.switchTo().frame("login-iframe");
	}
	public static WebElement displayLoginUsername() throws Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("AppFormPaymentPage_LoginId")));
			element =driver.findElement(properties.selectLocator("AppFormPaymentPage_LoginId"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayRequestOTPButton() throws Exception
	{
		try {
			element =driver.findElement(properties.selectLocator("AppFormPaymentPage_RequestOTPButton"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayOTPInputField() throws Exception
	{
		try {
			element =driver.findElement(properties.selectLocator("AppFormPaymentPage_OTPInputField"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayLoginButtonPaytmLoginWindow() throws Exception
	{
		try {
			element =driver.findElement(properties.selectLocator("AppFormPaymentPage_LoginButton"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayAmountToBePaidOnPaymentPage() throws Exception
	{
		try {
			Thread.sleep(2000);
			element =driver.findElement(properties.selectLocator("AppFormPaymentPage_AmountToBePaid"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayPayNowButtonOnPaymentPage() throws Exception
	{
		try {
			element =driver.findElement(properties.selectLocator("AppFormPaymentPage_PayNowButton"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displaySuccessulPaymentMessage() throws Exception
	{
		try {
			element =driver.findElement(properties.selectLocator("SuccessPaymentPage_Message"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayPaymentModeSectionInSuccessMessage() throws Exception
	{
		try {
			element =driver.findElement(properties.selectLocator("SuccessPaymentPage_PaymentModeSection"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayTranscnIdSectionInSuccessMessage() throws Exception
	{
		try {
			element =driver.findElement(properties.selectLocator("SuccessPaymentPage_TransactionIDSection"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayAmountSectionInSuccessMessage() throws Exception
	{
		try {
			element =driver.findElement(properties.selectLocator("SuccessPaymentPage_AmountSection"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayPaymentModeValueInSuccessMessage() throws Exception
	{
		try {
			element =driver.findElement(properties.selectLocator("SuccessPaymentPage_PaymentModeValue"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayTranscnIdValueInSuccessMessage() throws Exception
	{
		try {
			element =driver.findElement(properties.selectLocator("SuccessPaymentPage_TransactionIDValue"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayAmountValueInSuccessMessage() throws Exception
	{
		try {
			element =driver.findElement(properties.selectLocator("SuccessPaymentPage_AmountValue"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
}
