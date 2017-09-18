package whitefeather.xedge.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		helperString = Thread.currentThread().getStackTrace()[1].getMethodName();
		Thread.sleep(2000);
			try {
				if(Page_GlobalSearch.displayPlaceHolder().isDisplayed())
					{
					Page_GlobalSearch.displayPlaceHolder().sendKeys(DataGenerator.prospectEmail+"s");
					Thread.sleep(1000);
					Page_GlobalSearch.displayGoButton().click();
					
					(new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[contains(text(),'"+DataGenerator.prospectEmail+"')]")));
				
					Assert.assertEquals(DataGenerator.prospectEmail, driver.findElement(By.xpath(".//span[contains(text(),'"+DataGenerator.prospectEmail+"')]")).getText());
				
					Reporter.log("Specified user details are successfully located in the system.", true);
					HelperHand.getscreenshot(helperString);				
					Reporter.log("Screenshot is taken and stored at specified location successfully.", true);
					
					}
					else 
					{
						Thread.sleep(1000);
						if(Page_GlobalSearch.displayNoResultMessage().isDisplayed())
						{
							HelperHand.getscreenshot(helperString);
							Reporter.log("Screenshot is taken and stored at specified location successfully.", true);
							Reporter.log("No results found for provided string.", true);
						}
						else
						{
							Thread.sleep(1000);
							if(Page_GlobalSearch.displayNullResultMessage().isDisplayed())
							{
								HelperHand.getscreenshot(helperString);
								Reporter.log("Screenshot is taken and stored at specified location successfully.", true);
								Reporter.log("User has not provided any string to search.", true);
							}
						}	
					}
				}
				catch (AssertionError | NoSuchElementException | TimeoutException e) 
				{
					e.printStackTrace();
					Assert.fail();	
				}	
				/*try {
					if(Page_GlobalSearch.displayNoResultMessage().isDisplayed())
					{
						HelperHand.getscreenshot(helperString);
						Reporter.log("Screenshot is taken and stored at specified location successfully.", true);
						Reporter.log("No results found for provided string.", true);
					}
				} catch (AssertionError |Exception e) {
					e.printStackTrace();
					Assert.fail();	
				}
				
				try {
					if(Page_GlobalSearch.displayNullResultMessage().isDisplayed())
					{
						HelperHand.getscreenshot(helperString);
						Reporter.log("Screenshot is taken and stored at specified location successfully.", true);
						Reporter.log("User has not provided any string to search.", true);
					}
				} catch (AssertionError |Exception e) {
					e.printStackTrace();
					Assert.fail();	
				}	*/
		}
}
