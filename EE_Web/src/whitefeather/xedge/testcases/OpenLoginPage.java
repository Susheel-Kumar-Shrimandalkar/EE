package whitefeather.xedge.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
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
	
	@Parameters({"loginPageUrl"})	
	@Test
	public void openLoginPage(String loginPageUrl) throws InterruptedException
	{
		driver = new ChromeDriver();
		Reporter.log("Chrome Browser is opened",true);
		driver.manage().window().maximize();
		Reporter.log("Browser is maximized.",true);
		driver.get(loginPageUrl);
		try {
			Thread.sleep(1000);
			Assert.assertEquals(properties.getLoginPlatformUrl(),driver.getCurrentUrl(), "Login Page URL is incorrect.");
				Reporter.log("User has opened correct login page.",true);
		} catch (AssertionError e) {
			Assert.fail();
			Reporter.log("User has opened incorrect login page.",true);
		}
	}
}

