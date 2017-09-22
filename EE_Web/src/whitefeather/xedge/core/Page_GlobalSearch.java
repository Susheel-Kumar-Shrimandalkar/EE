package whitefeather.xedge.core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;
import whitefeather.xedge.testcases.Refresh_Page;

public class Page_GlobalSearch extends HelperHand
{
	public static WebElement element;
	public static String elementText="",validator="",noResult="",nullResult="";
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	public static final String prospectEmailCase = (DataGenerator.prospectEmail).toString();
	
	public static boolean displayGlobalSearchBar()
	{
		try {
			visibleFlag = driver.findElement(properties.selectLocator("GLobal_SeachBar")).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibleFlag;
	}

	public static WebElement displayLenseIcon()
	{
		try {
			element = driver.findElement(properties.selectLocator("LenseIcon_GlobalSearchBar"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	public static WebElement displayGoButton()
	{
		try {
			element = driver.findElement(properties.selectLocator("Go_button_globalSearchBar"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	public static WebElement displayPlaceHolder()
	{
		try {
			element = driver.findElement(properties.selectLocator("Placeholder_GlobalSearchBar"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayResultPageText()
	{
		try {
//			element = driver.findElement(properties.selectLocator("SearchResult_TextLabel"));
			Thread.sleep(2000);
			element = driver.findElement(properties.selectLocator("SearchValidator_HTMLElement"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	/*public static WebElement displayNoResultMessage()
	{
		try {
			element = driver.findElement(properties.selectLocator("NoResultMessage_GlobalSearch"));
			if(element.isDisplayed())
			{
				noResult = element.getText();
			}
			else
			{
				noResult = element.getText();
			}
			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayNullResultMessage()
	{
		try {
			element = driver.findElement(properties.selectLocator("NullResultMessage_GlobalSearch"));
			if(element.isDisplayed())
			{
				nullResult = element.getText();
			}
			else
			{
				nullResult = element.getText();
			}
			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}*/
	
	public static WebElement displaySuccessResult()
	{
		try {
			element = driver.findElement(properties.selectLocator("GlobalSearch_SuccessResult"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	public static String getElementText(WebElement ele)
	{
		try {
			elementText = ele.getText();
		} catch (NoSuchElementException e) {
		}
		return elementText;
	}

	
	public static WebElement knowErrorMessage() throws InterruptedException
	{
		
			if(displayResultPageText().getText().contains("Oops"))
			{
				Thread.sleep(2000);
				noResult = displayResultPageText().getText();
				visibleFlag = false;
			}
			else
			{
				Thread.sleep(2000);
				nullResult = displayResultPageText().getText();
				visibleFlag = false;
			}
			if(!displayResultPageText().isDisplayed())
			{
				Thread.sleep(2000);
				visibleFlag = true;
			}
			
		return element;
	}
	
	
	
	public static boolean validateGlobalSearch(String validatorString) throws Exception
	{		
		String errormsg="";
//		 String prospectEmailCase = (DataGenerator.prospectEmail).toString();
		 // prospectEmailCase.toString();
		errormsg = validatorString;			
		try 
		{	
			if(noResult.contains("Oops"))
			{
				errormsg = noResult;	
			}
			else if(nullResult.contains("enter"))
			{
				errormsg = nullResult;
			}
			else if(visibleFlag)
			{
				errormsg = DataGenerator.prospectEmail;
			}
			
			switch (errormsg) 
			{
			
			case "Oops! No data found! Please try again.":

				try 
				{
//					System.out.println("No Result Found.");
					HelperHand.getscreenshot(helperString); 
					Reporter.log("Screenshot is taken and stored at specified location successfully.", true); 
					Reporter.log("No results found for provided string.", true); 
				} catch (Exception e) {
					System.out.println("Exception Handled for No Result.");
					e.printStackTrace();
				}
				break;
			case "Please Enter Value":	

				try 
				{
//					System.out.println("No string is provided.");
					HelperHand.getscreenshot(helperString); 
					Reporter.log("Screenshot is taken and stored at specified location successfully.", true); 
					Reporter.log("User has not provided any string to search.", true); 
				} catch (Exception e) {
					System.out.println("Exception Handled for Null Result.");
					e.printStackTrace();
				}
				break;
			
			case "":
				try {
					System.out.println(prospectEmailCase);
//					System.out.println("Result Found.");
					Reporter.log("Specified user details are successfully located in the system.", true); 
					HelperHand.getscreenshot(helperString);				 
					Reporter.log("Screenshot is taken and stored at specified location successfully.", true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			default:

				try {
					System.out.println("No global search test case has matched the criteria.");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		} catch (NoSuchElementException e) 
		{
			System.out.println(e);
		}
		return visibleFlag;
	}
}
