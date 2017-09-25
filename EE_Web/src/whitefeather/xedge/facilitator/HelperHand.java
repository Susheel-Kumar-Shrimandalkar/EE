package whitefeather.xedge.facilitator;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import whitefeather.xedge.appconfig.ConfigMethods;
import whitefeather.xedge.appservices.EmailerService;
import whitefeather.xedge.core.DataGenerator;


public class HelperHand
{
	protected static  WebDriver driver = RootDriver.driver;
	public static boolean visibleFlag;
	public static String helperString="";
	public static String leadEmail = DataGenerator.randomEmailGenerator();

	public void setUpTestSuit(String browser) 
	{
		if(driver==null)
		driver=ConfigMethods.OpenBrowser(browser);
	}
	
	public void setDownTestSuit() throws IOException, InterruptedException 
	{
		// close the browser
		driver.quit();
		EmailerService.SendTestReport();
	}
	
	public static String getDate()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date = dateFormat.format(new Date());
		return date;
	}
	
	public static String CreateReportDirectory() 
	{
		String directory = ".\\src\\whitefeather\\xedge\\testreports\\Screenshots\\"+getDate();
		Path path = Paths.get(directory);
		if(!Files.exists(path))
		{
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return directory.replace("\\", "\\\\");
	}
	
	public static String getTime()
	{
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH_mm_ss"));
	}
	
	 public static void getscreenshot(String fileName) throws Exception 
     {
             File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
             FileUtils.copyFile(scrFile, new File(CreateReportDirectory(),fileName+getDate()+"_"+getTime()+".png"));
     }
	
}

