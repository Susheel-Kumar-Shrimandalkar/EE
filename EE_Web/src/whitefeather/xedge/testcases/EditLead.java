package whitefeather.xedge.testcases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import whitefeather.xedge.core.Page_EditLead;
import whitefeather.xedge.facilitator.HelperHand;

public class EditLead extends HelperHand
{
	@Test
	public void editFirstName() throws Exception
	{
		try {
			Page_EditLead.editFirstName().clear();
			Page_EditLead.editFirstName().sendKeys("Edited_"+prospectName);
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
			Page_EditLead.editFirstName().clear();
			Page_EditLead.editFirstName().sendKeys("Edited_"+prospectName);
			Reporter.log("User has edited First Name.", true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User is unable to edit first name.", true);
		}
	}

}
