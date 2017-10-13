package whitefeather.xedge.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_AddNewLead extends HelperHand
{
	public static WebElement element;
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);	
	
	public static WebElement displayFirstNameInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_firstName"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayLastNameInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_lastName"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayEmailInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_email"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayEmailExistsErrorMessage() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_EmailExistsError"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayMobileInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_mobileNumber"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayMobileExistsErrorMessage() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_MobileExistsError"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayQualificationInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Qualification"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectSeasonDropdown() throws Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("AddLead_SelectSeason")));
			element = driver.findElement(properties.selectLocator("AddLead_SelectSeason"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectSourceDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectSource"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectChannelDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectChannel"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectPriorityDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectPriority"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectStatusDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectStatus"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectReasonDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectReason"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectReferredToDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectReferredTo"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectEntity1Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectEntity1"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectEntity2Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectEntity2"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectEntity3Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectEntity3"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectEntity4Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectEntity4"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectBestTimeDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_BestTime"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectLeadQualifiedDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_LeadQualified"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displaySelectLeadContactableDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_LeadContactable"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayMobileVerifiedDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_MobileVerified"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayField1Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Field1"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayField2Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Field2"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayField3Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Field3"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayField4Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Field4"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayField5Dropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Field5"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayCountryDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectCountry"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayStateDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectState"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayCityDropdown() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_SelectCity"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayCommentInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_Comment"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement displayAddLeadButton()
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_AddLeadButton"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;	
	}

	public static WebElement displayCancelButton()
	{
		try {
			element = driver.findElement(properties.selectLocator("AddLead_CancelButton"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;	
	}

}

/*
WebElement season = driver.findElement(By.xpath(".//div[starts-with(.,'Select Season')]"));
Actions seasonbuilder = new Actions(driver);
season.click();
Action seasonA = seasonbuilder
          .moveToElement(season)
          .click()
          .sendKeys(Keys.DOWN)
          .sendKeys(Keys.DOWN)
          .sendKeys(Keys.TAB)
          .build();
seasonA.perform();

WebElement source = driver.findElement(By.cssSelector("#leadSource"));
Actions sourcebuilder = new Actions(driver);
source.click();
Action sourceA = sourcebuilder
          .moveToElement(source)
          .click()
          .sendKeys(Keys.BACK_SPACE)
          .sendKeys(Keys.DOWN)
          .sendKeys(Keys.DOWN)
          .sendKeys(Keys.TAB)
          .build();
sourceA.perform();

WebElement entity1 = driver.findElement(By.cssSelector("#entity1"));
Actions entity1builder = new Actions(driver);
entity1.click();
Action entity1A = entity1builder
          .moveToElement(entity1)
          .click()
//          .sendKeys(Keys.BACK_SPACE)
          .sendKeys(Keys.DOWN)
          .sendKeys(Keys.TAB)
          .build();
entity1A.perform();
Thread.sleep(1000);


//		WebElement entity2 = driver.findElement(By.cssSelector("#entity2"));
		WebElement entity2 = driver.findElement(By.xpath(".//div[contains(text(),'Select Course')]"));
		Actions entity2builder = new Actions(driver);
		entity2.click();
		Action entity2A = entity2builder
	              .moveToElement(entity2)
//	              .click()
	              .doubleClick()
//	              .sendKeys(Keys.BACK_SPACE)
	              .sendKeys("s")
	              .sendKeys(Keys.DOWN)
	              .sendKeys(Keys.DOWN)
	              .sendKeys(Keys.TAB)
	              .build();
		entity2A.perform();

//WebElement entity3 = driver.findElement(By.cssSelector("#entity3"));
WebElement entity3 = driver.findElement(By.xpath(".//div[contains(text(),'Select Location')]"));
Actions entity3builder = new Actions(driver);
entity3.click();
Action entity3A = entity3builder
          .moveToElement(entity3)
          .click()
          .sendKeys(Keys.BACK_SPACE)
          .sendKeys(Keys.DOWN)
          .sendKeys(Keys.DOWN)
          .sendKeys(Keys.TAB)
          .build();
entity3A.perform();

//WebElement entity4 = driver.findElement(By.cssSelector("#entity4"));
WebElement entity4 = driver.findElement(By.xpath(".//div[contains(text(),'Select Year')]"));
Actions entity4builder = new Actions(driver);
entity4.click();
Action entity4A = entity4builder
          .moveToElement(entity4)
          .click()
          .sendKeys(Keys.BACK_SPACE)
          .sendKeys(Keys.DOWN)
          .sendKeys(Keys.DOWN)
          .sendKeys(Keys.TAB)
          .build();
entity4A.perform();
Thread.sleep(3000);*/

