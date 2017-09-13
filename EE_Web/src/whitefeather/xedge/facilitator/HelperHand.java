package whitefeather.xedge.facilitator;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import whitefeather.xedge.appconfig.ConfigMethods;


public class HelperHand
{
	protected static  WebDriver driver = RootDriver.driver;
	public boolean visibleFlag;

	public void setUpTestSuit(String browser) 
	{
		if(driver==null)
		driver=ConfigMethods.OpenBrowser(browser);
	}
	
	public void setDownTestSuit() throws IOException, InterruptedException 
	{
		// close the browser
		driver.close();
		
	}
	
	public static String getDate()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date = dateFormat.format(new Date());
		return date;
	}
	
	
}

