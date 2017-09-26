package whitefeather.xedge.core;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_UpcomingTask extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	
	public static String getDashboardPageURL()
	{
		try {
			driver.findElement(properties.selectLocator("UpcomingTaks_Tab")).click();
			helperString = driver.getCurrentUrl();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return helperString;	
	}
	
	public static WebElement displayRecentNewTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("Dashboard_RecentNewTab"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayRecentNewTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("Dashboard_RecentNewTab"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("Dashboard_RecentNewTab")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("New: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");

	}
	
	public static WebElement displayRecentOnlineTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("Dashboard_RecentOnlineTab"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayRecentOnlineTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("Dashboard_RecentOnlineTab"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("Dashboard_RecentOnlineTab")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("RecentOnline: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");
	}
	
	public static WebElement displayUpcomingFollowupTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("Dashboard_UpcomingFollowupTab"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayUpcomingFollowupTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("Dashboard_UpcomingFollowupTab"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("Dashboard_UpcomingFollowupTab")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("UpcomingFollowup: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");
	}
	
	public static WebElement displayUpcomingWalkinsTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("Dashboard_UpcomingWalkinsTab"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayUpcomingWalkinsTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("Dashboard_UpcomingWalkinsTab"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("Dashboard_UpcomingWalkinsTab")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("UpcomingWalkins: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");
	}
	
	public static WebElement displayHighPriorityTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("Dashboard_HighPriorityTab"));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayHighPriorityTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("Dashboard_HighPriorityTab"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("Dashboard_HighPriorityTab")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("HighPriority: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");
	}
	
}
