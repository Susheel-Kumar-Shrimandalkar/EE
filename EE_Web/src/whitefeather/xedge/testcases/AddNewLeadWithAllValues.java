package whitefeather.xedge.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import whitefeather.xedge.appconfig.ConfigMethods;
import whitefeather.xedge.core.Page_AddNewLead;
import whitefeather.xedge.facilitator.HelperHand;

public class AddNewLeadWithAllValues extends HelperHand
{
	@Test
	public static void enterFirstName()
	{
		try {
			Page_AddNewLead.displayFirstNameInputField().clear();
			Page_AddNewLead.displayFirstNameInputField().sendKeys(prospectName);
			Reporter.log("User has entered First Name successfully",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter First Name.",true);
		}
	}
	
	@Test
	public static void enterLastName()
	{
		try {
			Page_AddNewLead.displayLastNameInputField().sendKeys("Last Name");
			Reporter.log("User has entered Last Name successfully",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter Last Name.",true);
		}
	}
	
	@Test
	public static void enterEmailAddress()
	{
		try {
			Page_AddNewLead.displayEmailInputField().sendKeys(prospectEmail);
			//Handle Existing Email  scenario later
			Reporter.log("User has entered Email Address successfully",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter Email Address.",true);
		}
	}
	
	@Test
	public static void enterMobileNumber()
	{
		try {
			Page_AddNewLead.displayMobileInputField().sendKeys(prospectMobile);
			//Handle Existing Mobile scenario later
			Reporter.log("User has entered Mobile Number successfully",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter Mobile Number.",true);
		}
	}
	
	@Test
	public static void enterHighestQualification()
	{
		try {
			Page_AddNewLead.displayQualificationInputField().sendKeys("Bachelors in Astronomy");
			Reporter.log("User has entered Highest Qualification successfully",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to enter Highest Qualification.",true);
		}
	}
	
	@Test
	public static void selectSeason()
	{
		try {
			Page_AddNewLead.displaySelectSeasonDropdown().click();
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectSeasonDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Season value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Season value.",true);
		}
	}
	
	@Test
	public static void selectSource()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectSourceDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Source value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Source value.",true);
		}
	}
	
	@Test
	public static void selectChannel()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectChannelDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Channel value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Channel value.",true);
		}
	}
	
	@Test
	public static void selectPriority()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectPriorityDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Priority value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Priority value.",true);
		}
	}
	
	@Test
	public static void selectStatus()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectStatusDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Status value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Status value.",true);
		}
	}
	
	@Test
	public static void selectReason()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectReasonDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Reason value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Reason value.",true);
		}
	}
	
	@Test
	public static void selectReferredTo()
	{
		try {
			
			
			/*************************/
			//Temp Code. To be removed later
			Actions builder = new Actions(driver);
			Page_AddNewLead.displaySelectReferredToDropdown().click();
			Action seriesOfActions = builder
		              .moveToElement(Page_AddNewLead.displaySelectReferredToDropdown())
		              .click()
		              .sendKeys(Keys.DOWN)
		              .sendKeys(Keys.DOWN)//Number of Down Key Press = Position of value from drop down
		              .sendKeys(Keys.DOWN)
		              .sendKeys(Keys.DOWN)
		              .sendKeys(Keys.DOWN)
		              .sendKeys(Keys.RETURN)
		              .build();
			seriesOfActions.perform();
			/*************************/
			
//			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectReferredToDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided ReferredTo value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide ReferredTo value.",true);
		}
	}
	
	@Test
	public static void selectEntity1()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectEntity1Dropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Entity1 value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Entity1 value.",true);
		}
	}
	
	@Test
	public static void selectEntity2()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectEntity2Dropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Entity2 value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Entity2 value.",true);
		}
	}
	
	@Test
	public static void selectEntity3()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectEntity3Dropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Entity3 value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Entity3 value.",true);
		}
	}
	
	@Test
	public static void selectEntity4()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectEntity4Dropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Entity4 value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Entity4 value.",true);
		}
	}
	
	@Test
	public static void selectBestCall()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectBestTimeDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Best Call value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Best Call value.",true);
		}
	}
	
	@Test
	public static void selectLeadQualified()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectLeadQualifiedDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Lead Qualified value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Lead Qualified value.",true);
		}
	}
	
	@Test
	public static void selectLeadContactable()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displaySelectLeadContactableDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Lead Contactable value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Lead Contactable value.",true);
		}
	}
	
	@Test
	public static void selectMobileVerified()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displayMobileVerifiedDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Mobile Verified value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Mobile Verified value.",true);
		}
	}
	
	@Test
	public static void selectField1()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displayField1Dropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Field1 value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Field1 value.",true);
		}
	}
	
	@Test
	public static void selectField2()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displayField2Dropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Field2 value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Field2 value.",true);
		}
	}
	
	@Test
	public static void selectField3()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displayField3Dropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Field3 value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Field3 value.",true);
		}
	}
	
	@Test
	public static void selectField4()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displayField4Dropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Field4 value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Field4 value.",true);
		}
	}
	
	@Test
	public static void selectField5()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displayField5Dropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Field5 value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Field5 value.",true);
		}
	}
	
	@Test
	public static void selectCountry()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displayCountryDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided Country value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Country value.",true);
		}
	}
	
	@Test
	public static void selectState()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displayStateDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided State value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide State value.",true);
		}
	}
	
	@Test
	public static void selectCity()
	{
		try {
			ConfigMethods.selectValueFromDropDown(Page_AddNewLead.displayCityDropdown(),Page_AddNewLead.driver);
			Reporter.log("User has provided City value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide City value.",true);
		}
	}
	
	@Test
	public static void enterLeadComment()
	{
		try {
			Page_AddNewLead.displayCommentInputField().sendKeys("Comments for :"+"\n"+"Lead Name: "+prospectName+"\n"+"Lead Email: "+prospectEmail);
			Reporter.log("User has provided City value successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide City value.",true);
		}
	}
	
	@Test
	public static void clickAddLeadButton()
	{
		try {
			Page_AddNewLead.displayAddLeadButton().click();
			Reporter.log("User has clicked on Add Lead button successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to click on Add Lead button.",true);
		}
	}
}
