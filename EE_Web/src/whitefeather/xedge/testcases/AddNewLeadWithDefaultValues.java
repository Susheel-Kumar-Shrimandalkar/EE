package whitefeather.xedge.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import whitefeather.xedge.core.DataGenerator;
import whitefeather.xedge.core.Page_AddNewLeadWithDefaultValues;

public class AddNewLeadWithDefaultValues
{
	@Test
	public static void addNewLeadWithDefaultValues() throws InterruptedException
	{
		try {
			Page_AddNewLeadWithDefaultValues.enterProspectEmailAddress().sendKeys(DataGenerator.randomEmailGenerator());
			Reporter.log("User has entered email address successfully",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter email address.",true);
		}
		
		try {
			Page_AddNewLeadWithDefaultValues.enterProspectMobileNumber().sendKeys(Long.toString(DataGenerator.randomMobileNumberGenerator()));
			Reporter.log("User has entered mobile number successfully",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter mobile number.",true);
		}
		
		try {
			Thread.sleep(1000);
			Page_AddNewLeadWithDefaultValues.clickAddLeadButtonOnRHSPanel().click();
			Reporter.log("User has clicked Add Lead button on RHS panel.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Add Lead button on RHS panel.",true);
			Assert.fail();
		}
		
	}
	
	
}
