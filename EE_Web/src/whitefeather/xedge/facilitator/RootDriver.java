package whitefeather.xedge.facilitator;

import org.openqa.selenium.WebDriver;

public class RootDriver 
{
	public static WebDriver driver;
	protected static boolean _condition;
	
	public RootDriver(WebDriver _driver)
	{
		if(RootDriver.driver == null)
		{
			RootDriver.driver = _driver;
			_condition=true;
		}
		else
		{
			RootDriver.driver = _driver;
		}
	}
	
	

}
