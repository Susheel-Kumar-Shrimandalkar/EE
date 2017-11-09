package whitefeather.xedge.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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
			driver.switchTo().alert();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
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
}
