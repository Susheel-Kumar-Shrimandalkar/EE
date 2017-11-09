package whitefeather.xedge.testcases;

import java.sql.SQLException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import whitefeather.xedge.core.Page_DetailedApplicationForm;
import whitefeather.xedge.core.Page_GenerateLeadApplicationForm;
import whitefeather.xedge.facilitator.HelperHand;

public class GenerateLeadForApplicationForm extends HelperHand 
{
	//Do later. Work upon 'final' keyword logic later.
	public static final String fullName=thirdPartyLeadFullName;
	public static  final  String mobileNumber=thirdPartyLeadMobile;
	public static final String emailAddress=thirdPartyLeadEmail;
	public static String providedEntityValue;
	
	@Test	
	public static void enterFullName() throws Exception
	{
		System.out.println("\n"+"*********************** Filling up Basic Information ***************************"+"\n");
		try {
			Page_GenerateLeadApplicationForm.displayFullNameInputField().sendKeys(fullName);
			Reporter.log("User has entered Full Name successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to enter Full Name.",true);
		}
	}
	
	@Test
	public static void enterMobileNumber() throws Exception
	{
		try {
			Page_GenerateLeadApplicationForm.displayMobileNumberInputField().sendKeys(mobileNumber);
			Reporter.log("User has entered Mobile successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to enter Mobile Number.",true);
		}
	}
	
	@Test
	public static void enterEmailAddress() throws Exception
	{
		try {
			Page_GenerateLeadApplicationForm.displayEmailInputField().sendKeys(emailAddress);
			System.out.println("Entered Email is: "+emailAddress);
			Reporter.log("User has entered Email Address successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to enter Email Addres.",true);
		}
	}
	

	@Test
	public static void provideEntity() throws Exception
	{
		try 
		{
			Page_GenerateLeadApplicationForm.displayEntityDropDown().selectByIndex(4);
			providedEntityValue = Page_GenerateLeadApplicationForm.displayEntityDropDown().getFirstSelectedOption().getText();
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
			String storedEntity = extractDataFromDatabase("entityEntity");
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

}
