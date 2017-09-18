package whitefeather.xedge.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_UpcomingTask extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	
	public static WebElement displayRecentNewTab()
	{
		try {
			element = driver.findElement(properties.selectLocator("Dashboard_RecentNewTabCount"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static String displayRecentNewTabCount()
	{
		try {
			element = driver.findElement(properties.selectLocator("Dashboard_RecentNewTabCount"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("Dashboard_RecentNewTabCount")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("New: "+element.getText().replaceAll("\\D+", ""));
		return element.getText().replaceAll("\\D+", "");

	}
	
	public static String getDashboardPageURL()
	{
		try {
			driver.findElement(properties.selectLocator("UpcomingTaks_Tab")).click();
			helperString = driver.getCurrentUrl();
		} catch (Exception e) {
			Assert.fail();
		}
		return helperString;
		
	}
}
