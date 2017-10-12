package whitefeather.xedge.testcases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import whitefeather.xedge.core.GlobalIcons;
import whitefeather.xedge.core.Page_AddNewLead;
import whitefeather.xedge.core.Page_GlobalSearch;
import whitefeather.xedge.facilitator.HelperHand;

public class EditLead extends HelperHand
{
	@Test
	public void openEditLeadPanel() throws Exception
	{
		try {
			System.out.println(AddNewLeadWithAllValues.globalSearchLeadName);
			Page_GlobalSearch.displayPlaceHolder().sendKeys(AddNewLeadWithAllValues.globalSearchLeadName);
			Page_GlobalSearch.displayGoButton().click();
			GlobalIcons.openEditLeadPanel().click();
			Reporter.log("User has opened Edit Lead Panel.", true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User is unable to open Edit Lead Panel.", true);
		}
	}
	
	@Test
	public void editFirstName() throws Exception
	{
		try {
			Page_AddNewLead.displayFirstNameInputField().clear();
			Page_AddNewLead.displayFirstNameInputField().sendKeys("EditedFN_"+AddNewLeadWithAllValues.globalSearchLeadName);
			Reporter.log("User has edited First Name.", true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User is unable to edit first name.", true);
		}
	}
	
	@Test
	public void editLastName() throws Exception
	{
		try {
			Page_AddNewLead.displayLastNameInputField().clear();
			Page_AddNewLead.displayLastNameInputField().sendKeys("EditedLN_"+AddNewLeadWithAllValues.globalSearchLeadName);
			Reporter.log("User has edited Last Name.", true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User is unable to edit Last name.", true);
		}
	}
	
	@Test
	public void editEmailAddress() throws Exception
	{
		try {
			Page_AddNewLead.displayEmailInputField().clear();
			Page_AddNewLead.displayEmailInputField().sendKeys("EditedEmail	_"+AddNewLeadWithAllValues.globalSearchLeadEmail);
			Reporter.log("User has edited Last Name.", true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User is unable to edit Last name.", true);
		}
	}
	
	@Test
	public static void clickAddLeadButton()
	{
		try {
			Page_AddNewLead.displayAddLeadButton().click();
			Reporter.log("User has clicked on Update Lead button successfully.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to click on Update Lead button.",true);
		}
	}
	
	//Editing remaining Fields - To be done later

}
