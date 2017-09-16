package whitefeather.xedge.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import whitefeather.xedge.core.DataGenerator;
import whitefeather.xedge.core.Page_GlobalSearch;
import whitefeather.xedge.facilitator.HelperHand;

public class GlobalSearch extends HelperHand
{
	@Test
	public void verifyGlobalSearchBar()
	{
		try {
			Assert.assertTrue(Page_GlobalSearch.displayGlobalSearchBar());
			Reporter.log("Global Search Bar is displayed.", true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Global Search Bar is not displayed.", true);
		}
	}
	
	@Test
	public void verifyGlobalSearchPlaceholder()
	{
		try {
			Assert.assertTrue(Page_GlobalSearch.displayPlaceHolder().isDisplayed());
			Reporter.log("Global Search placeholder is displayed.", true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Global Search placeholder is not displayed.", true);
		}
	}
	
	@Test
	public void verifyLenseIcon()
	{
		try {
			Assert.assertTrue(Page_GlobalSearch.displayLenseIcon().isDisplayed());
			Reporter.log("Global Search Lense Icon is displayed.", true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Global Search Lense Icon is not displayed.", true);
		}
	}
	
	@Test
	public void verifyGoButton()
	{
		try {
			Assert.assertTrue(Page_GlobalSearch.displayGoButton().isDisplayed());
			Reporter.log("Global Search Go button is displayed.", true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Global Search Go button is not displayed.", true);
		}
	}
	
	@Test
	public void performGlobalSearch() throws Exception
	{
		String str="ss";
		Thread.sleep(2000);
		try {
			if(Page_GlobalSearch.displayPlaceHolder().isDisplayed())
			{
				Page_GlobalSearch.displayPlaceHolder().sendKeys(DataGenerator.prospectEmail+"s");
				Page_GlobalSearch.displayGoButton().click();
				Thread.sleep(1000);
//				Assert.assertTrue(driver.findElement(By.xpath(".//span[contains(text(),'"+DataGenerator.prospectEmail+"')]")).isDisplayed());
//				Assert.assertTrue(driver.findElement(By.xpath(".//span[contains(text(),'"+"shekhar"+"')]")).isDisplayed());
//				Assert.assertEquals(DataGenerator.prospectEmail, driver.findElement(By.xpath(".//span[contains(text(),'"+DataGenerator.prospectEmail+"')]")).getText());
				Assert.assertEquals(DataGenerator.prospectEmail, driver.findElement(By.xpath(".//span[contains(text(),'"+DataGenerator.prospectEmail+"')]")).getText());
				HelperHand.getscreenshot();
				Reporter.log("Screenshot is taken and stored at specified location successfully.", true);
			}
			Reporter.log("Specified user details are successfully located in the system.", true);
		} catch (Exception e) {
			e.printStackTrace();
			HelperHand.getscreenshot();
			Reporter.log("Screenshot is taken and stored at specified location successfully.", true);
			Assert.fail();
			Reporter.log("No specified details have been found in the system.", true);
		}
	}

}
