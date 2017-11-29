package whitefeather.xedge.facilitator;


import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import whitefeather.xedge.appconfig.ConfigMethods;
import whitefeather.xedge.appservices.DatabaseManager;
import whitefeather.xedge.appservices.EmailerService;
import whitefeather.xedge.core.DataGenerator;
import whitefeather.xedge.testcases.OpenApplicationFormLandingPage;


public class HelperHand
{
	
	//Half of below static strings are handled in generic method. Half are remaining.
	//To do: Create Generic methods in ExtraaEdge platform classes
	
	protected static  WebDriver driver = RootDriver.driver;
	public static boolean visibleFlag;
	public static String helperString="", dbUsername="", appFormURL="";
	
	public static String prospectEmail = DataGenerator.randomEmailGenerator();
	public static String prospectMobile = Long.toString(DataGenerator.randomMobileNumberGenerator());
	public static String prospectName=DataGenerator.generateFirstName();
	
	public static String currectDate = DataGenerator.getDate();
	public static String currectTime = DataGenerator.getTime();
	
	public static LinkedHashMap<String, String> appFormDataMap = new LinkedHashMap<String, String>();
	public static final String thirdPartyLeadEmail = DataGenerator.randomEmailGenerator();
	public static final String thirdPartyLeadFullName = DataGenerator.generateFirstName();
	public static final String  thirdPartyLeadMobile = Long.toString(DataGenerator.randomMobileNumberGenerator());
	public static final String step1PresentAddrContactNumber = Long.toString(DataGenerator.randomMobileNumberGenerator());
	public static final String step1PermanentAddrContactNumber = Long.toString(DataGenerator.randomMobileNumberGenerator());
	public static final String thirdPartyEmergencyLeadEmail = DataGenerator.randomEmailGenerator();
	public static final String thirdPartyAlternateContact = Long.toString(DataGenerator.randomMobileNumberGenerator());
	public static final String thirdPartyGuardiansContact = Long.toString(DataGenerator.randomMobileNumberGenerator());
	
	public static LinkedHashMap<String, String> dbValues = new LinkedHashMap<String, String>();
	public static List<WebElement> hscSubjects = new LinkedList<WebElement>();
	
	private static SecureRandom randomEmail = new SecureRandom();
	protected static LinkedHashMap<String, String> getAppFormData()
	{
		appFormDataMap.put("personName", DataGenerator.generateFirstName());
		appFormDataMap.put("personEmailAddress", (new BigInteger(50, randomEmail).toString(32)+"@domain.in"));
		appFormDataMap.put("personMobileNumber", Long.toString(DataGenerator.randomMobileNumberGenerator()));
		return appFormDataMap;
	}
	
	//Later sort out logic for this
	public static String providedEntityValue;
	
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
	
	
	//Write logic for listing file names in directory. This is specifically for attachments in Step3 of App Form
	/*List<String> results = new ArrayList<String>();


	File[] files = new File("/path/to/the/directory").listFiles();
	//If this pathname does not denote a directory, then listFiles() returns null. 

	for (File file : files) {
	    if (file.isFile()) {
	        results.add(file.getName());
	    }
	}*/
	
	public static String getDatabaseName(String formURL)
	{
		dbUsername = formURL;
		try {
			if(dbUsername ==null || dbUsername =="")
			{
				System.out.println("Failed to get database name. Forcefully stopping the execution.");
				System.exit(0);
			}
			else
			{
				System.out.println("\n >>> Establishing connection to database...");
				
				dbUsername  = dbUsername.substring(0, dbUsername.indexOf("="));

				dbUsername  = dbUsername .replace("https://", "");
				dbUsername  = dbUsername .replace(".extraaedge.com/application?inst", "");
				
				System.out.println("dbUsername: "+dbUsername);
//				dbUsername  = dbUsername .replace(".azurewebsites.net/application?inst", "");

//				dbUsername  = dbUsername .replaceAll("\\d", "");	//In case when db names will not contains any numeric chars
				
				if(dbUsername .equalsIgnoreCase("extraaedgev2"))
				{
					dbUsername = "ExtraaEdgeV2_Version1";
					System.out.println("\n >>> Connecting to "+dbUsername+"\n");
				}
				else if(dbUsername .equalsIgnoreCase("cmr"))
				{
					dbUsername = "extraaedge_cmr";
					System.out.println("\n >>> Connecting to "+dbUsername+"\n");
				}
				else if(dbUsername .equalsIgnoreCase("walnut"))
				{
					dbUsername = "extraaedge_walnut";
					System.out.println("\n >>> Connecting to "+dbUsername+"\n");
				}
				else
				{
					System.exit(0);
				}
			}
		} catch (Exception e) {
			System.out.println(e);	
		}
		return dbUsername;
	}
}

