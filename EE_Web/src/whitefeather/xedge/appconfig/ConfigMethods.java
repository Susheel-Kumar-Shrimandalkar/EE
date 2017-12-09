package whitefeather.xedge.appconfig;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import whitefeather.xedge.facilitator.RootDriver;


public class ConfigMethods extends RootDriver
{
	static String operaBrowserLocation="C:\\Program Files\\Opera\\launcher.exe";
	public ConfigMethods(WebDriver cm_driver) 
	{
		super(cm_driver);
	}
	
	public static WebDriver OpenBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\External_Physical_Bindings\\chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("Chrome Browser is opened",true);
			driver.manage().window().maximize();
			Reporter.log("Browser is maximized.",true);
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\External_Physical_Bindings\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", ".\\External_Physical_Bindings\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", ".\\External_Physical_Bindings\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("Opera"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\External_Physical_Bindings\\operadriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\Opera\\49.0.2725.47\\opera.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("Safari"))
		{
			System.setProperty("webdriver.safari.noinstall", "true");
			driver = new SafariDriver();
			driver.manage().window().maximize();
		}
		
		return driver;
	}

	
	public static void selectValueFromDropDown(WebElement element, WebDriver idriver)
	{
		//Check the number of values present in the drop down and then select - to be done later
		//Implement logic for mouse hover (select element by hovering cursor) later
		Actions builder = new Actions(idriver);
		element.click();
		Action seriesOfActions = builder
	              .moveToElement(element)
	              .click()
	              .sendKeys(Keys.DOWN)
	              .sendKeys(Keys.DOWN)//Number of Down Key Press = Position of value from drop down
	              .sendKeys(Keys.RETURN)
	              .build();
		seriesOfActions.perform();
	}
	
	public static void waitForPageToLoad() 
	{
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) { }
		
		/*new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
        ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));*/
      }
	
	 public static void getscreenshot() throws Exception 
     {
             File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          //The below method will save the screen shot in d drive with name "screenshot.png"
             FileUtils.copyFile(scrFile, new File(".\\src\\whitefeather\\xedge\\testreports\\screenshot.png"));
     }
	 
	 /*public static void waitForElementToLoad(String locator)
	 {
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
	 }
	 
	 public static void ExecuteCustomJavascript() throws NoSuchMethodException, ScriptException, FileNotFoundException
	 {
		 try 
		 {
	        ScriptEngineManager manager = new ScriptEngineManager();
	        ScriptEngine javascriptEngine = manager.getEngineByExtension("js");
	         
	        // Get script from JS File
	        FileInputStream fileInputStream = new FileInputStream(".\\src\\whitefeather\\xedge\\appconfig\\CustomExecutionFunctions.js");
	        if (fileInputStream != null)
	        {
	            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
	
	            javascriptEngine.eval(reader);
	            Invocable invocableEngine = (Invocable)javascriptEngine;    
	            invocableEngine.invokeFunction("userProvidedDataType");
//	            System.out.println("Result: " + object);    
	        }
	      }
		    catch (Exception ex) 
		 	{
		        ex.printStackTrace();
		    }		 
	 }*/
	 
}
