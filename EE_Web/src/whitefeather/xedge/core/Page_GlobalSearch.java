package whitefeather.xedge.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_GlobalSearch extends HelperHand
{
	public static WebElement element;
	public static String elementText;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);
	private static int switchCounter;
	private static String caseValues[] = new String[3];
	
	public static boolean displayGlobalSearchBar() throws Exception
	{
		try {
			visibleFlag = driver.findElement(properties.selectLocator("GLobal_SeachBar")).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return visibleFlag;
	}

	public static WebElement displayLenseIcon() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("LenseIcon_GlobalSearchBar"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	public static WebElement displayGoButton() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Go_button_globalSearchBar"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	public static WebElement displayPlaceHolder() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Placeholder_GlobalSearchBar"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayResultPageText() throws Exception
	{
		try {
			Thread.sleep(2000);
			element = driver.findElement(properties.selectLocator("SearchValidator_HTMLElement"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySuccessResult() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("GlobalSearch_SuccessResult"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	public static String getElementText(WebElement ele)
	{
		try {
			elementText = ele.getText();
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		return elementText;
	}

	public static WebElement getSearchedString()
	{
		try {
			element = driver.findElement(By.xpath(".//span[contains(text(),'"+leadEmail+"')]"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement knowErrorMessage() throws Exception
	{
		Thread.sleep(2000);
				if(getSearchedString().getText().contains(leadEmail))
				{
					try {
						switchCounter=0;
						caseValues[switchCounter] =getSearchedString().getText();
						visibleFlag = true;
					} catch (org.openqa.selenium.NoSuchElementException e) {
						e.printStackTrace();
					}
				}
				else if(displayResultPageText().getText().contains("Oops"))
				{
					try {
						switchCounter=1;
						caseValues[switchCounter] = displayResultPageText().getText();
						visibleFlag = false;
					} catch (org.openqa.selenium.NoSuchElementException e) {
						e.printStackTrace();
					}
				}
				else
				{
					try {
						switchCounter=2;
						caseValues[switchCounter] = displayResultPageText().getText();
						visibleFlag = true;
					} catch (org.openqa.selenium.NoSuchElementException e) {
						e.printStackTrace();
					}
				}
		return element;
	}
	
	public static boolean validateGlobalSearch(String validatorString) throws Exception
	{		
		helperString = Thread.currentThread().getStackTrace()[1].getMethodName(); 	
		try 
		{	
		switch (switchCounter) 
			{		
			case 1:
				try 
				{
					System.out.println(caseValues[switchCounter]);
					HelperHand.getscreenshot(helperString); 
					Reporter.log("Screenshot is taken and stored at specified location successfully.", true); 
					Reporter.log("No results found for provided string.", true); 
				} catch (Exception e) {
					System.out.println("Exception Handled for No Result.");
					e.printStackTrace();
				}
				break;
			case 2:	

				try 
				{
					System.out.println(caseValues[switchCounter]);
					HelperHand.getscreenshot(helperString); 
					Reporter.log("Screenshot is taken and stored at specified location successfully.", true); 
					Reporter.log("User has not provided any string to search.", true); 
				} catch (Exception e) {
					System.out.println("Exception Handled for Null Result.");
					e.printStackTrace();
				}
				break;
				
			default:
				try {
					System.out.println("Result Found "+caseValues[switchCounter]);
					Reporter.log("Specified user details are successfully located in the system.", true); 
					HelperHand.getscreenshot(helperString);				 
					Reporter.log("Screenshot is taken and stored at specified location successfully.", true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		} catch (org.openqa.selenium.NoSuchElementException e) 
		{
			System.out.println(e);
		}
		return visibleFlag;
	}
}
