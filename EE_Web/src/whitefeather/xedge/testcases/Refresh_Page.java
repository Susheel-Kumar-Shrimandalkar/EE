package whitefeather.xedge.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import whitefeather.xedge.appconfig.ConfigMethods;
import whitefeather.xedge.facilitator.HelperHand;

public class Refresh_Page extends HelperHand
{
	@Test
	public static void refreshWebPage()
	{
		driver.navigate().refresh();
		ConfigMethods.waitForPageToLoad();
		Reporter.log("Web page is refreshed.",true);
	}

}
