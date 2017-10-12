package whitefeather.xedge.testcases;

import java.sql.SQLException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.core.Page_DetailedApplicationForm;
import whitefeather.xedge.facilitator.HelperHand;

public class FillUpApplicationForm  extends HelperHand
{
	@Test
	public static void openDetailedApplicationFormPage() throws SQLException, InterruptedException
	{
		try 
		{
			driver.get(Constants.APPLICATIONFORM+"?ref_no="+getPRN());
			Thread.sleep(2000);
			Reporter.log("User has opened Application Form successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to open Application Form.",true);
		}
	}
	@Test
	public static void fillUpApplicationFormStep1() throws Exception
	{
		try 
		{
			driver.navigate().refresh();
			Page_DetailedApplicationForm.displayDateOfBirthInputFieldStep1().click();
			Reporter.log("User has opened calender successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to open Caledar Form.",true);
		}
		
		try 
		{
			Thread.sleep(3000);
			Page_DetailedApplicationForm.displayDayOfDateOfBirthStep1().click();
			Reporter.log("User has selected date successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to select date.",true);
		}
		
		
		try 
		{
			Page_DetailedApplicationForm.displayBloodGroupInputField().sendKeys("B+");
			Reporter.log("User has entered blood group value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide blood group value.",true);
		}
		
		try 
		{
			Page_DetailedApplicationForm.displayGenderDropDown().selectByIndex(1);
			Reporter.log("User has entered Gender value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Gender value.",true);
		}
		
		try 
		{
			Page_DetailedApplicationForm.displayCitizenshipInputField().sendKeys("HQ"+" "+"of"+" "+"Moon"+" "+"Titan");
			Reporter.log("User has entered Citizenship value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Citizenship value.",true);
		}
		
		try 
		{
			Page_DetailedApplicationForm.displayNationalityInputField().sendKeys("Planet Saturn");
			Reporter.log("User has entered Nationality value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Nationality value.",true);
		}
		
		try 
		{
			Page_DetailedApplicationForm.displayDomicileDropDown().selectByIndex(1);
			Reporter.log("User has entered Domicile value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to Domicile Gender value.",true);
		}
		
	}
}
