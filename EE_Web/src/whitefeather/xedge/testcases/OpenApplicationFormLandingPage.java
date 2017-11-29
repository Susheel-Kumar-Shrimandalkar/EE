package whitefeather.xedge.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.facilitator.HelperHand;

public class OpenApplicationFormLandingPage extends HelperHand
{
	
	@BeforeClass
	@Parameters({"browser"})	
	public void selectBrowser(String browser)
	{
		setUpTestSuit(browser);
	}
	
//	@Parameters({"appFormURL"})	
	@Test
	public void openAppForm() throws InterruptedException
	{
		driver = new ChromeDriver();
		Reporter.log("Chrome Browser is opened",true);
		driver.manage().window().maximize();
		Reporter.log("Browser is maximized.",true);
		driver.get(Constants.SELECT_APPLICATION_FORM_TYPE);
		Thread.sleep(20000);
		appFormURL = driver.findElement(By.id("customAppURL")).getText();
		System.out.println(appFormURL);
		driver.get(appFormURL);
		Thread.sleep(500);

		try 
		{
			Assert.assertEquals(appFormURL,driver.getCurrentUrl());
			Reporter.log("User has opened correct Application Form page.",true);
		} catch (AssertionError e) {
			Assert.fail();
			Reporter.log("User has opened incorrect Application Form page.",true);
		}
	}

}
