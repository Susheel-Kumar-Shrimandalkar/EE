package whitefeather.xedge.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;
import whitefeather.xedge.core.Page_GenerateLeadApplicationForm;
import whitefeather.xedge.facilitator.HelperHand;

public class GenerateLeadForApplicationForm extends HelperHand 
{
	@Test
	public static void enterFullName() throws Exception
	{
		try {
			Page_GenerateLeadApplicationForm.displayFullNameInputField().sendKeys(thirdPartyLeadFullName);
			Reporter.log("User has entered Full Name successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter Full Name.",true);
		}
	}
	
	
	@Test
	public static void enterMobileNumber() throws Exception
	{
		try {
			Page_GenerateLeadApplicationForm.displayMobileNumberInputField().sendKeys(thirdPartyLeadMobile);
			Reporter.log("User has entered Mobile successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter Mobile Number.",true);
		}
	}
	
	@Test
	public static void enterEmailAddress() throws Exception
	{
		try {
			Page_GenerateLeadApplicationForm.displayEmailInputField().sendKeys(thirdPartyLeadEmail);
			System.out.println("Entered Email is: "+thirdPartyLeadEmail);
			Reporter.log("User has entered Email Address successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter Email Addres.",true);
		}
	}
	

	@Test
	public static void clickSubmitButton() throws Exception
	{
		try {
			Page_GenerateLeadApplicationForm.displaySubmitButton().click();
			Thread.sleep(5000);
			Reporter.log("User has clicked Submit button successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Submit button.",true);
		}
	}
}
