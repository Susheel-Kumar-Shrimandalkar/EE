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

	/*@Test 
 	public void performGlobalSearch() throws Exception 
 	{ 
 		helperString = Thread.currentThread().getStackTrace()[1].getMethodName(); 
 		Thread.sleep(2000); 
 			try { 
				if(Page_GlobalSearch.displayPlaceHolder().isDisplayed()) 
					{ 
//					Page_GlobalSearch.displayPlaceHolder().sendKeys(DataGenerator.prospectEmail); 
					Page_GlobalSearch.displayPlaceHolder().sendKeys("f176pqvmbs@domain.in"); 
					Thread.sleep(1000); 
					Page_GlobalSearch.displayGoButton().click(); 
					 
					(new WebDriverWait(driver, 10)) 
//				   .until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[contains(text(),'"+DataGenerator.prospectEmail+"')]"))); 
					   .until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[contains(text(),'f176pqvmbs@domain.in')]"))); 

//					Assert.assertEquals(DataGenerator.prospectEmail, driver.findElement(By.xpath(".//span[contains(text(),'"+DataGenerator.prospectEmail+"')]")).getText()); 
					Assert.assertEquals(DataGenerator.prospectEmail, driver.findElement(By.xpath(".//span[contains(text(),'f176pqvmbs@domain.in')]")).getText()); 

					
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
 	}
	*/
	@Test 
 	public void performGlobalSearch1() throws Exception 
 	{ 
 		helperString = Thread.currentThread().getStackTrace()[1].getMethodName(); 
 		Thread.sleep(2000); 
 		
 		if(Page_GlobalSearch.displayPlaceHolder().isDisplayed()) 
 		{
 			Page_GlobalSearch.displayPlaceHolder().sendKeys(DataGenerator.prospectEmail); //f176pqvmbs@domain.ins
			Thread.sleep(1000); 
			Page_GlobalSearch.displayGoButton().click(); 
 		}
 		try {
			Assert.assertTrue(Page_GlobalSearch.validateGlobalSearch(Page_GlobalSearch.getElementText(Page_GlobalSearch.knowErrorMessage())));
		} catch (AssertionError e) {
			System.out.println("Global Search failed due to incorrect input or no input.");
			Assert.fail();
			e.printStackTrace();
		}
 		
 		
 		/*(new WebDriverWait(driver, 10)) 
		.until(ExpectedConditions.visibilityOf(Page_GlobalSearch.displayResultPageText()));
		Thread.sleep(5000);

		if(Page_GlobalSearch.displayResultPageText().isDisplayed())
		{
			if(Page_GlobalSearch.displayNoResultMessage().isDisplayed())
			{
				try {
					Page_GlobalSearch.element = Page_GlobalSearch.displayNoResultMessage();
					
					Page_GlobalSearch.validator = Page_GlobalSearch.element.getText();
				} catch (org.openqa.selenium.NoSuchElementException e) {}
			}
			else if(!Page_GlobalSearch.displayNoResultMessage().isDisplayed())
			{		try {
				Page_GlobalSearch.element = Page_GlobalSearch.displayNullResultMessage();
				Page_GlobalSearch.validator =Page_GlobalSearch.element.getText();
					} catch (org.openqa.selenium.NoSuchElementException e1) {
						e1.printStackTrace();
					}
			}
			
		}	*/
// 		Page_GlobalSearch.findElement();
 		
 		
 		
 	/*	switch (Page_GlobalSearch.getElementText(Page_GlobalSearch.element))
 		{
		case "Oops! No data found! Please try again.":
			Thread.sleep(2000);
			Page_GlobalSearch.getElementText(Page_GlobalSearch.displayNoResultMessage()).equalsIgnoreCase("Oops! No data found! Please try again.") ;
			try {	
				System.out.println("No Result Found");
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("Exception Handled for No Result.");
				e.printStackTrace();
			}
			break;
		case "Please Enter Value":
			Thread.sleep(2000);
			Page_GlobalSearch.getElementText(Page_GlobalSearch.displayNullResultMessage()).equalsIgnoreCase("Please Enter Value") ;
			try {
				System.out.println("No Result Found");
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("Exception Handled for No Result.");
				e.printStackTrace();
			}
			break;
			
		case "Search Result for f176pqvmbs@domain.in":
			Thread.sleep(2000);
			try {
				System.out.println("Result Found");
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("Exception Handled for Success Result.");
				e.printStackTrace();
			}
			break;
			
		/*default:
			try {
				System.out.println("Result Found");
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("Exception Handled for Success Result.");
				e.printStackTrace();
			}
			break;*/
 	}

}
 	
 		
 		
 		
 		/*
 		
 			try { 
 					if(Page_GlobalSearch.displaySuccessResultMessage().isDisplayed()) 
					{ 
					
					System.out.println("Search: "+Page_GlobalSearch.displaySuccessResultMessage().getText());
//					Page_GlobalSearch.displayPlaceHolder().sendKeys(DataGenerator.prospectEmail); 
					
					 
					(new WebDriverWait(driver, 10)) 
//				   .until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[contains(text(),'"+DataGenerator.prospectEmail+"')]"))); 
//					.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[contains(text(),'f176pqvmbs@domain.in')]"))); 
					.until(ExpectedConditions.elementToBeClickable(Page_GlobalSearch.displaySuccessResultMessage())); 
					Thread.sleep(4000);
					String successResult = driver.findElement(By.xpath(".//span[contains(text(),'f176pqvmbs@domain.in')]")).getText();
			 		System.out.println("Email: "+successResult);
//					Assert.assertEquals(DataGenerator.prospectEmail, driver.findElement(By.xpath(".//span[contains(text(),'"+DataGenerator.prospectEmail+"')]")).getText()); 
					Assert.assertEquals("f176pqvmbs@domain.in", driver.findElement(By.xpath(".//span[contains(text(),'f176pqvmbs@domain.in')]")).getText()); 

					Reporter.log("Specified user details are successfully located in the system.", true); 
					HelperHand.getscreenshot(helperString);				 
					Reporter.log("Screenshot is taken and stored at specified location successfully.", true); 
					} 
 				}
				catch (AssertionError | NoSuchElementException | TimeoutException e)  
				{ 
					e.printStackTrace(); 
					Assert.fail();	 
				}
 				try
 				{
					if(Page_GlobalSearch.displayNoResultMessage().isDisplayed()) 
					{ 
						(new WebDriverWait(driver, 10)) 
						.until(ExpectedConditions.elementToBeClickable(Page_GlobalSearch.displayNoResultMessage())); 
						HelperHand.getscreenshot(helperString); 
						Reporter.log("Screenshot is taken and stored at specified location successfully.", true); 
						Reporter.log("No results found for provided string.", true); 
					} 
 				}
				catch (AssertionError | NoSuchElementException | TimeoutException e)  
				{ 
					e.printStackTrace(); 
					Assert.fail();	 
				}
				try
				{
					if(Page_GlobalSearch.displayNullResultMessage().isDisplayed()) 
					{ 
						(new WebDriverWait(driver, 10)) 
						.until(ExpectedConditions.elementToBeClickable(Page_GlobalSearch.displayNullResultMessage())); 
						HelperHand.getscreenshot(helperString); 
						Reporter.log("Screenshot is taken and stored at specified location successfully.", true); 
						Reporter.log("User has not provided any string to search.", true); 
					} 
				}
				catch (AssertionError | NoSuchElementException | TimeoutException e)  
				{ 
					e.printStackTrace(); 
					Assert.fail();	 
				}*/

