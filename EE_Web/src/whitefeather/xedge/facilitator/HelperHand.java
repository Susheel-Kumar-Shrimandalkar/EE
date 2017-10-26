package whitefeather.xedge.facilitator;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import whitefeather.xedge.appconfig.ConfigMethods;
import whitefeather.xedge.appservices.DatabaseManager;
import whitefeather.xedge.appservices.EmailerService;
import whitefeather.xedge.core.DataGenerator;


public class HelperHand
{
	protected static  WebDriver driver = RootDriver.driver;
	public static boolean visibleFlag;
	public static String helperString="";
	
	public static String prospectEmail = DataGenerator.randomEmailGenerator();
	public static String prospectMobile = Long.toString(DataGenerator.randomMobileNumberGenerator());
	public static String prospectName=DataGenerator.generateFirstName();
	
	public static String currectDate = DataGenerator.getDate();
	public static String currectTime = DataGenerator.getTime();
	
	public static String thirdPartyLeadEmail = DataGenerator.randomEmailGenerator();
	public static String thirdPartyLeadFullName = DataGenerator.generateFirstName();
	public static String thirdPartyLeadMobile = Long.toString(DataGenerator.randomMobileNumberGenerator());
	
	public static final String thirdPartyEmergencyLeadMobile = Long.toString(DataGenerator.randomMobileNumberGenerator());
	public static final String thirdPartyEmergencyLeadEmail = DataGenerator.randomEmailGenerator();
	public static final String thirdPartyAlternateContact = Long.toString(DataGenerator.randomMobileNumberGenerator());
	public static final String thirdPartyGuardiansContact = Long.toString(DataGenerator.randomMobileNumberGenerator());
	
	public static LinkedHashMap<String, String> dbValues = new LinkedHashMap<String, String>();
	
//	public static String globalSearch=AddNewLeadWithAllValues.prospectEmail;

	public void setUpTestSuit(String browser) 
	{
		if(driver==null)
		driver=ConfigMethods.OpenBrowser(browser);
	}
	
	public void setDownTestSuit() throws IOException, InterruptedException 
	{
		// close the browser
//		driver.quit();
		EmailerService.SendTestReport();
	}
	
	public static String CreateReportDirectory() 
	{
		String directory = ".\\src\\whitefeather\\xedge\\testreports\\Screenshots\\"+currectDate;
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
	
	
	
	 public static void getscreenshot(String fileName) throws Exception 
     {
             File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
             FileUtils.copyFile(scrFile, new File(CreateReportDirectory(),fileName+currectDate+"_"+currectTime+".png"));
     }
	
	 public static String getPRN() throws SQLException
	 {
		 DatabaseManager.getLeadDataFromDatabase();
		 return (String) dbValues.get("userPRN");
	 }
	 
	public static String extractDataFromDatabase(String columnName) throws SQLException
	{
		DatabaseManager.getLeadDataFromDatabase();
		return (String) dbValues.get(columnName);
	}
}

