package whitefeather.xedge.testcases;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
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
 		
 		Thread.sleep(2000); 
 		
 		if(Page_GlobalSearch.displayPlaceHolder().isDisplayed()) 
 		{
 			//Throws exceptions for non existing and null results. To be handled later.
 			System.out.println("Check1 :"+AddNewLeadWithAllValues.globalSearchLeadEmail);
 			Page_GlobalSearch.displayPlaceHolder().sendKeys(AddNewLeadWithAllValues.globalSearchLeadEmail);
			Page_GlobalSearch.displayGoButton().click();
 		}
 		try {	
			Assert.assertTrue(Page_GlobalSearch.validateGlobalSearch(Page_GlobalSearch.getElementText(Page_GlobalSearch.knowErrorMessage())));
		} catch (AssertionError e) {
			System.out.println("Global Search failed due to non existing data.");
			Assert.fail();
			e.printStackTrace();
		}
 	}
}