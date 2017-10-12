package whitefeather.xedge.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_DetailedApplicationForm extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);
	
	public static WebElement displayDateOfBirthInputFieldStep1() throws Exception
	{
		try {
			element =driver.findElement(properties.selectLocator("Step1_DateOfBirth"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
		
	}
	
	public static WebElement displayDayOfDateOfBirthStep1() throws Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("Step1_DayOfDateOfBirth")));
			element = driver.findElement(properties.selectLocator("Step1_DayOfDateOfBirth"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
		
	}
		
		/*			
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement ele:allDates)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase("28"))
			{
				ele.click();
				break;
			}
			
		}
		return element;
	*/
	
	public static WebElement displayBloodGroupInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_BloodGroup"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static Select displayGenderDropDown() throws Exception
	{
		Select dropdown = null;
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_Gender"))));
//			dropdown.selectByIndex(1);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;
	}
	
	public static WebElement displayCitizenshipInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_Citizenship"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayNationalityInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_Natinality"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static Select displayDomicileDropDown() throws Exception
	{
		Select dropdown = null;
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_Domicile"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}

}
