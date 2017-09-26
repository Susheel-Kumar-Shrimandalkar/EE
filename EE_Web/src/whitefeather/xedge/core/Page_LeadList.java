package whitefeather.xedge.core;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_LeadList extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	
	public static WebElement getLeadListPageURL()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadList_Tab"));
			helperString = driver.getCurrentUrl();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayAllTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_AllTab"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayAllTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_AllTab"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("LeadListPage_AllTab")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("All: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");

	}
	
	public static WebElement displayNewTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_NewTab"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayNewTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_NewTab"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("LeadListPage_NewTab")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("New: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");

	}
	
	public static WebElement displayCallBackTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_CallBackTab"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayCallBackTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_CallBackTab"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("LeadListPage_CallBackTab")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("CallBack: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");

	}
	public static WebElement displayWalkinTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_WalkinTab"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayWalkinTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_WalkinTab"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("LeadListPage_WalkinTab")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Walkin: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");

	}
	
	public static WebElement displayEnrolledTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_EnrolledTab"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayEnrolledTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_EnrolledTab"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("LeadListPage_EnrolledTab")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Enrolled: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");

	}
	
	public static WebElement displayClosedTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_ClosedTab"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayClosedTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_ClosedTab"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("LeadListPage_ClosedTab")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Closed: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");

	}
	public static WebElement displayOnlineTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_OnlineTab"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayOnlineTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_OnlineTab"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("LeadListPage_OnlineTab")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Online: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");

	}
	
	public static WebElement displayReferredFromMeTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_ReferredFromMeTab"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayReferredFromMeTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_ReferredFromMeTab"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("LeadListPage_ReferredFromMeTab")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ReferredFromMe: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");

	}
	
	public static WebElement displayModal()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_ModalTitle"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayModalCloseButton()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_ModalCloseButton"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayCampaignIcon()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_CampaignIcon"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayReferAllLeadsIcon()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_ReferIcon"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public static WebElement displaySendSMSToAllLeadsIcon()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_SendSMSToAllIcon"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySendEmailToAllLeadsIcon()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_SendEmailToAllIcon"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayRefreshIcon()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_RefreshIcon"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	
	public static WebElement displayDownloadLeadsDataIcon()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_DownloadLeadsIcon"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayFilterLeadsDataIcon()
	{
		try {
			Thread.sleep(500);
			element = driver.findElement(properties.selectLocator("LeadListPage_FilterIcon"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayFilterLeadsPanel()
	{
		try {
			element = driver.findElement(properties.selectLocator("LeadListPage_FilterLeadsPanelHeading"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	

}
