package whitefeather.xedge.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class OpenLoginPage extends HelperHand
{
	public static ObjectMapping properties = new ObjectMapping(Constants.URLs);

	@BeforeClass(alwaysRun = true)
	@Parameters({"browser"})	
	public void selectBrowser(String browser)
	{
		setUpTestSuit(browser);
	}
		
	@Test
	public void openLoginPage() throws InterruptedException
	{
		String loginPageUrl = "";
		driver.get(Constants.SELECT_DOMAIN);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("domainURL"))));
		loginPageUrl = driver.findElement(By.id("domainURL")).getText();
		System.out.println("loginPageUrl"+loginPageUrl);
		
		driver.get(loginPageUrl);
		try {
			Thread.sleep(1000);
			driver.navigate().refresh();
			System.out.println("getCurrentUrl"+driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), loginPageUrl);
				Reporter.log("User has opened correct login page.",true);
		} catch (AssertionError e) {
			Assert.fail();
			Reporter.log("User has opened incorrect login page.",true);
		}
	}
}

