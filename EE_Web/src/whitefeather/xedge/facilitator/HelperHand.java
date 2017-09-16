package whitefeather.xedge.facilitator;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import whitefeather.xedge.appconfig.ConfigMethods;


public class HelperHand
{
	protected static  WebDriver driver = RootDriver.driver;
	public static boolean visibleFlag;

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
	
	 public static void getscreenshot() throws Exception 
     {
             File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          //The below method will save the screen shot in d drive with name "screenshot.png"
             FileUtils.copyFile(scrFile, new File(".\\src\\whitefeather\\xedge\\testreports\\screenshot.png"));
     }
	
}

