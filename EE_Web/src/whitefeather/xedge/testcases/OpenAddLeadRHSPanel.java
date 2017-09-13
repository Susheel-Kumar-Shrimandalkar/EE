package whitefeather.xedge.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import whitefeather.xedge.core.GlobalIcons;
import whitefeather.xedge.facilitator.HelperHand;

public class OpenAddLeadRHSPanel extends HelperHand
{
	@Test
	public static void clickAddLeadPlusIcon()
	{
		try {
			GlobalIcons.clickAddLeadPlusIcon().click();
			Reporter.log("User has clicked Add Lead icon.",true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Add Lead icon.",true);
		}
	}

}
