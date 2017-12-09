package whitefeather.xedge.testcases;

import java.sql.SQLException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import whitefeather.xedge.core.Page_GenerateLeadApplicationForm;
import whitefeather.xedge.facilitator.HelperHand;

public class GenerateLeadForApplicationForm extends HelperHand 
{
	public static String fullName, mobileNumber, emailAddress;
	public static String [] splitEntityValues=null;
	
	@Test	
	public static void enterFullName() throws Exception
	{
		System.out.println("\n"+"*********************** Filling up Basic Information ***************************"+"\n");
		
		try {
			Page_GenerateLeadApplicationForm.displayFullNameInputField().clear();
			Page_GenerateLeadApplicationForm.displayFullNameInputField().sendKeys(getAppFormData().get("personName"));
			fullName =Page_GenerateLeadApplicationForm.displayFullNameInputField().getAttribute("value");
			System.out.println("Provided Lead Name is: "+fullName);
			Reporter.log("User has entered Full Name successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to enter Full Name.",true);
		}
	}
	
	
	
	@Test
	public static void enterEmailAddress() throws Exception
	{
		try {
			Page_GenerateLeadApplicationForm.displayEmailInputField().clear();
			Page_GenerateLeadApplicationForm.displayEmailInputField().sendKeys(getAppFormData().get("personEmailAddress"));
			emailAddress =Page_GenerateLeadApplicationForm.displayEmailInputField().getAttribute("value");
			System.out.println("Provided Lead's Email Address is: "+emailAddress);
			Reporter.log("User has entered Email Address successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to enter Email Addres.",true);
		}
	}
	
	@Test
	public static void enterMobileNumber() throws Exception
	{
		try {
			Page_GenerateLeadApplicationForm.displayMobileNumberInputField().clear();;
			Page_GenerateLeadApplicationForm.displayMobileNumberInputField().sendKeys(getAppFormData().get("personMobileNumber"));
			mobileNumber =Page_GenerateLeadApplicationForm.displayMobileNumberInputField().getAttribute("value");
			System.out.println("Provided Lead's Mobile Number is: "+mobileNumber);
			Reporter.log("User has entered Mobile successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to enter Mobile Number.",true);
		}
	}
	
	@Test
	@Parameters({"emailId"})
	public static void enterEmailAddressManually(String emailId) throws Exception
	{
		try {
			Page_GenerateLeadApplicationForm.displayEmailInputField().clear();
			Page_GenerateLeadApplicationForm.displayEmailInputField().sendKeys(emailId);
			emailAddress = emailId;
			Reporter.log("User has entered Email Address successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to enter Email Addres.",true);
		}
	}
	
	@Test
	@Parameters({"mobileN"})
	public static void enterMobileNumberManually(String mobileN) throws Exception
	{
		try {
			Page_GenerateLeadApplicationForm.displayMobileNumberInputField().clear();;
			Page_GenerateLeadApplicationForm.displayMobileNumberInputField().sendKeys(mobileN);
			mobileNumber = mobileN;
			Reporter.log("User has entered Mobile successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to enter Mobile Number.",true);
		}
	}
	
	@Test
	public static void provideEntity() throws Exception
	{
		try 
		{
			Actions builder = new Actions(driver);
			Action seriesOfActions = builder
		              .moveToElement(driver.findElement(By.cssSelector("#showEntity > span")))
		              .click()
		              .sendKeys(Keys.RETURN)
		              /*.sendKeys(Keys.RETURN)
		              .sendKeys(Keys.DOWN)
		              .sendKeys(Keys.RETURN)
		              .sendKeys(Keys.RETURN)
		              .sendKeys(Keys.DOWN)
		              .sendKeys(Keys.DOWN)
		              .sendKeys(Keys.RETURN)*/
		              .build();
			seriesOfActions.perform();

//			Page_GenerateLeadApplicationForm.displayEntityDropDown().selectByIndex(2);
			//Temp value for test purpose. Use above line of code for actual execution
//			Page_GenerateLeadApplicationForm.displayEntityDropDown().selectByVisibleText("Junior KG");

//			providedEntityValue = Page_GenerateLeadApplicationForm.displayEntityDropDown().getFirstSelectedOption().getText();
			providedEntityValue = Page_GenerateLeadApplicationForm.displayEntityDropDown1().getText();

			System.out.println("old_providedEntityValue: "+providedEntityValue);
			providedEntityValue = providedEntityValue.replaceAll("(\\r|\\n)", "");
			System.out.println("New providedEntityValue: "+ providedEntityValue);
			splitEntityValues = providedEntityValue.split("×");
			
			/*for (int i = 0 ; i<splitEntityValues.length; i++)
			{
		        	System.out.println("Value: "+splitEntityValues[i]);
			}*/

			Reporter.log("User has entered Entity value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Entity value.",true);
		}
	}
	
	@Test
	public static void clickSubmitButton() throws Exception
	{
		try {
			Assert.assertTrue(Page_GenerateLeadApplicationForm.displaySubmitButton().isDisplayed());
			Page_GenerateLeadApplicationForm.displaySubmitButton().click();
			Thread.sleep(5000);
			Reporter.log("User has clicked Submit button successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to click Submit button.",true);
		}
	}
	
	@Test
	public static void validateLeadFirstName() throws SQLException, InterruptedException
	{
		System.out.println("\n"+"*********************** Validating information filled up while creating lead ***************************"+"\n");

		try {
			System.out.println("--------------Validating First Name--------------");
			System.out.println("Provided First Name: "+fullName);
			//Intentional Pause
			Thread.sleep(2000);
			String firstName = extractDataFromDatabase("userName");
			System.out.println("First Name value frm DB: "+firstName);
			Assert.assertEquals(fullName, firstName);
			Reporter.log("Provided First Name matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided First Name doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateLeadMobileNumber() throws SQLException, InterruptedException
	{
		try {
			System.out.println("--------------Validating Mobile Number--------------");
			System.out.println("Provided Mobile Number: "+mobileNumber);
			//Intentional Pause
			Thread.sleep(1000);
			String mobileN = extractDataFromDatabase("userMobile");
			System.out.println("Mobile Number value frm DB: "+mobileN);
			Assert.assertEquals(mobileNumber, mobileN);
			Reporter.log("Provided Mobile Number matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Mobile Number doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateLeadEmailAddress() throws SQLException, InterruptedException
	{
		try {
			System.out.println("--------------Validating Email Address--------------");
			System.out.println("Provided Email Address: "+emailAddress);
			//Intentional Pause
			Thread.sleep(1000);
			String email = extractDataFromDatabase("userEmail");
			System.out.println("Email Address value frm DB: "+email);
			Assert.assertEquals(emailAddress, email);
			Reporter.log("Provided Email Address matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Email Address doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateEntityValue() throws SQLException, InterruptedException
	{
		try {
			System.out.println("--------------Validating Entity Value--------------");
			System.out.println("Provided Entity Value: "+providedEntityValue);
			//Intentional Pause
			Thread.sleep(1000);
			String storedEntity = extractDataFromDatabase("entity2Entity");
			System.out.println("Entity Value value frm DB: "+storedEntity);
			Assert.assertEquals(providedEntityValue, storedEntity);
			Reporter.log("Provided Entity Value matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Entity Value doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateLeadDetailsSuccessfulSumbission() throws Exception
	{
		try {
			System.out.println("--------------Validating successful submission of Lead Details--------------");
			Assert.assertTrue(Page_GenerateLeadApplicationForm.displaySuccessRegMessage().isDisplayed(),"Successful registration message is displayed.");
			Assert.assertTrue(Page_GenerateLeadApplicationForm.displaySuccessInstructionMessage().isDisplayed(),"Instruction Message for further actions is displayed");
			Reporter.log("Provided Lead details are submitted successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Lead details are failed to submit.",true);
		}
	}

	/*@AfterClass	
	public void endTest() throws IOException, InterruptedException
	{
		setDownTestSuit();
	}*/
}
