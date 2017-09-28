package whitefeather.xedge.appconfig;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import whitefeather.xedge.facilitator.RootDriver;


public class ConfigMethods extends RootDriver
{
	
	public ConfigMethods(WebDriver cm_driver) 
	{
		super(cm_driver);
	}
	
	public static WebDriver OpenBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\External_Physical_Bindings\\chromedriver.exe");
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
}
