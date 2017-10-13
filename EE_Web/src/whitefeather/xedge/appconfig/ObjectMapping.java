package whitefeather.xedge.appconfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import org.openqa.selenium.By;

public class ObjectMapping 
{
	Properties properties;
	
	public ObjectMapping(String _object)
	{
		properties = new Properties();
		
		try 
		{
			FileInputStream loadProperties = new FileInputStream(_object);
			properties.load(loadProperties);
			loadProperties.close();
			
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public By selectLocator(String _locatorType) throws Exception
	{
		String locator = properties.getProperty(_locatorType);
		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
		
		//For XPath
		if(locatorType.toLowerCase().equals("xpath"))
		return By.xpath(locatorValue);
		
		//For CSS Selector
		else if(locatorType.toLowerCase().equals("css"))
		return By.cssSelector(locatorValue);
		
		//For ID
		else if(locatorType.toLowerCase().equals("id"))
		return By.id(locatorValue);
		
		//For ClassName
		else if(locatorType.toLowerCase().equals("class"))
		return By.className(locatorValue);
		
		//For Name
		else if(locatorType.toLowerCase().equals("name"))
		return By.name(locatorValue);
		
		else
			throw new Exception("Unknown Locator Type: "+locatorType);
	}
	
	public String getUsername()
	{
		return properties.getProperty("staging_username");
	}

	public String getPassword()
	{
		return properties.getProperty("staging_password");
	}
	
	public String getFromEmailAddress()
	{
		return properties.getProperty("_fromEmailaddress");
	}
	
	public String getToEmailAddress()
	{
		return properties.getProperty("_toEmailAddress");
	}
	
	public String getCCEmailAddresses()
	{
		return properties.getProperty("_ccEmailAddress");
	}
	public String getFromEmailAccountPassword()
	{
		return properties.getProperty("_fromEmailAccPassword");
	}
	
	public String getAPILoginURL()
	{
		return properties.getProperty("APILogin");
	}
	public String getAPILoginClientId()
	{
		return "clientId="+properties.getProperty("APILogin_ClientId");
	}
	public String getAPILoginUsername()
	{
		return "username="+properties.getProperty("APILogin_Username");
	}
	public String getAPILoginPassword()
	{
		return "password="+properties.getProperty("APILogin_Password");
	}
	public String getAPILoginCredentials()
	{
		String cred= "clientId="+properties.getProperty("APILogin_ClientId")
		+"username="+properties.getProperty("APILogin_Username")
		+"password="+properties.getProperty("APILogin_Password").trim().toString().replaceAll("\\s+", "");;
		return cred;
	}
	public String getAPILoginDetails()
	{
		return properties.getProperty("APILogin_Credentials");
	}
	public String getDashboardCountAPIQAStaging()
	{
		return (String)properties.getProperty("Dashboard_CountAPI");
	}
	public String getLeadListCountAPIQAStaging()
	{
		return (String)properties.getProperty("LeadList_CountAPI");
	}

	/*public String getBCCEmailAddresses() 
	{		
		String [] _bccEmailIds = 
			{
				properties.getProperty("_bccEmail1"),
				properties.getProperty("_bccEmail2")
			};
		
		StringBuilder buildAddresses = new StringBuilder();
		buildAddresses.append("\"");
		for (int i = 0; i < _bccEmailIds.length; i++) 
		{
			
			buildAddresses.append(_bccEmailIds[i]);
			if(i<_bccEmailIds.length-1)
				buildAddresses.append("; ");
		}
		buildAddresses.append("\"");
		System.out.println(buildAddresses.toString());
		return buildAddresses.toString();
	}
*/
	
	public InternetAddress[] getBCCEmailAddresses() throws AddressException 
	{		
		String [] _bccEmailIds = 
			{
				properties.getProperty("_bccEmail1"),
				properties.getProperty("_bccEmail2")
			};
		
		InternetAddress [] iAddress = new InternetAddress[_bccEmailIds.length];
		for (int i = 0; i < _bccEmailIds.length; i++) 
		{
			iAddress[i]= new InternetAddress(_bccEmailIds[i]);		
		}
		return iAddress;
	}

	public Date getCurrentTime() {
		return new java.util.Date();
	}	
	
	public String getLoginPlatformUrl( )
	{
		return properties.getProperty("base_url");
	}
	
	public String getHomePageUrlAfterLogin( )
	{
		return properties.getProperty("HomePage_afterLogin");
	}
	public String getDashboardPageURL( )
	{
		return properties.getProperty("Dashboard_URL");
	}
	public String getLeadListPageURL( )
	{
		return properties.getProperty("LeadList_URL");
	}
}
