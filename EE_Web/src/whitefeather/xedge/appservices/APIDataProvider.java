package whitefeather.xedge.appservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;

public class APIDataProvider 
{
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);
	
	public static void main(String[] args) throws IOException 
	{
		System.out.println("Recent New Tab Count: "+getNewTabCount());
		System.out.println("Recent Online Tab Count: "+getOnlineTabCount());
//		System.out.println("Upcming Followup Tab Count: "+getUpcomingFollowupTabCount());
//		System.out.println("Upcoming Walkin Tab Count: "+getUpcomingWalkinsTabCount());
//		System.out.println("High Priority Tab Count: "+getHighPriorityTabCount());
//		System.out.println(getDashboardTabCount());

	}
	
	public static String accesstoken, _dashboardCount, _leadListCount, _leadListData="", newCount,onlineCount,followupCount,walkinCount,highPriorityCount;
//	public static String [] tabCount=null;
	static HashMap<String,String > map = new HashMap <String,String>();
	
	/*public static String getRecentNewTabCount()
	{
		return map.get("newCount");
	}
	public static void generateJWTTOken() throws IOException
	
	{
		URL url = new URL(properties.getAPILoginURL());
		HttpURLConnection connPost = (HttpURLConnection) url.openConnection();
		connPost.setDoOutput(true);
		connPost.setRequestMethod("POST");
		OutputStream osPost = connPost.getOutputStream();
		osPost.write(properties.getAPILoginCredentials().getBytes());
		osPost.flush();
		osPost.close();
		
		int respCode = connPost.getResponseCode();
		System.out.println("Response Code is: "+respCode);
		
		if(respCode==HttpURLConnection.HTTP_OK)
		{
			BufferedReader brPost = new BufferedReader(new InputStreamReader(connPost.getInputStream()));
			String _postStream="";
			StringBuffer respPost = new StringBuffer();
			while((_postStream=brPost.readLine())!=null)
			{
				respPost.append(_postStream);
			}
			brPost.close();
			System.out.println("Login Successful. Details: "+respPost.toString());
			
			String splitJson = respPost.toString();
			String part_1 = splitJson.split(",")[0];
			String part_2 = part_1.split(":")[1];
			accesstoken = part_2.replace("\"", "");
		}
		
	}*/

	
	public static HashMap<String,String > getDashboardTabCount() throws IOException, MalformedURLException
	{
		URL _loginURL = new URL(properties.getAPILoginURL());
		HttpURLConnection connPost = (HttpURLConnection) _loginURL.openConnection();
		connPost.setDoOutput(true);
		connPost.setRequestMethod("POST");
		OutputStream osPost = connPost.getOutputStream();
		osPost.write(properties.getAPILoginDetails().getBytes());
		osPost.flush();
		osPost.close();
		
		int respCode = connPost.getResponseCode();
//		System.out.println("Response Code is: "+respCode);
		
		if(respCode==HttpURLConnection.HTTP_OK)
		{
			BufferedReader brPost = new BufferedReader(new InputStreamReader(connPost.getInputStream()));
			String _postStream="";
			StringBuffer respPost = new StringBuffer();
			while((_postStream=brPost.readLine())!=null)
			{
				respPost.append(_postStream);
			}
			brPost.close();
//			System.out.println("Login Successful. Details: "+respPost.toString());
			
			String splitJson = respPost.toString();
			String part_1 = splitJson.split(",")[0];
			String part_2 = part_1.split(":")[1];
			accesstoken = part_2.replace("\"", "");
		}
		URL _dashboardAPI = new URL(properties.getDashboardCountAPIStaging());
		HttpURLConnection connGet = (HttpURLConnection)_dashboardAPI.openConnection();
		connGet.setRequestMethod("GET");
		connGet.setRequestProperty("Authorization", "bearer "+accesstoken);
		
		int _respCode = connGet.getResponseCode();
//		System.out.println("Response Code is: "+_respCode);
		if(_respCode==HttpURLConnection.HTTP_OK)
		{
			BufferedReader brGet = new BufferedReader(new InputStreamReader(connGet.getInputStream()));
			String _getStream;
			StringBuffer respGet = new StringBuffer();
			
			while((_getStream=brGet.readLine())!=null)
			{
				respGet.append(_getStream);
			}
			_dashboardCount = respGet.toString();
//			System.out.println("Dashboard Count: "+_dashboardCount);
			brGet.close();
			
		}
		_dashboardCount = _dashboardCount.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll(":", ",").replaceAll("\"", "").toString();
		String [] countData = _dashboardCount.split(",");
		for(int i=0;i<countData.length;i+=2)
		{
			map.put(countData[i], countData[i+1]);
		}
		return map;	
	}
	public static String getNewTabCount() throws MalformedURLException, IOException
	{
		return getDashboardTabCount().get("newCount");
	}
	public static String getOnlineTabCount()throws MalformedURLException, IOException
	{
		return getDashboardTabCount().get("onlineCount");	
	}
	public static String getUpcomingFollowupTabCount()throws MalformedURLException, IOException
	{
		return getDashboardTabCount().get("upcomingFollowupCallCount");	
	}
	public static String getUpcomingWalkinsTabCount()throws MalformedURLException, IOException
	{
		return getDashboardTabCount().get("personalVisitWalkInCount");	
	}
	public static String getHighPriorityTabCount()throws MalformedURLException, IOException
	{
		return getDashboardTabCount().get("highPriorityCount");	
	}
	/*
	public static void mapDashboardTabCount()
	{
		_dashboardCount = _dashboardCount.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll(":", ",").replaceAll("\"", "").toString();
		String [] countData = _dashboardCount.split(",");
		for(int i=0;i<countData.length;i+=2)
		{
			map.put(countData[i], countData[i+1]);
		}
	}*/
	
	/*
	
	private static void getLeadListTabCounts() throws IOException
	{
		URL _getURL = new URL(LEADLISTCOUNT_URL);
		HttpURLConnection connGet = (HttpURLConnection)_getURL.openConnection();
		connGet.setRequestMethod("GET");
		connGet.setRequestProperty("Authorization", "bearer "+accesstoken);
		
		int _respCode = connGet.getResponseCode();
		System.out.println("Response Code is: "+_respCode);
		if(_respCode==HttpURLConnection.HTTP_OK)
		{
			BufferedReader brGet = new BufferedReader(new InputStreamReader(connGet.getInputStream()));
			String _getStream;
			StringBuffer respGet = new StringBuffer();
			
			while((_getStream=brGet.readLine())!=null)
			{
				respGet.append(_getStream);
			}
			_leadListCount = respGet.toString();
			System.out.println("LeadListCount: "+_leadListCount);
			_leadListCount.replaceAll("\"", " ");
			System.out.println("New LeadListCount: "+_leadListCount);
			tabCount = respGet.toString().split(",");
			brGet.close();
			
		}
	}
	private static void getLeadListData() throws IOException
	{
		URL _getURL = new URL(properties.get);
		HttpURLConnection connGet = (HttpURLConnection)_getURL.openConnection();
		connGet.setRequestMethod("GET");
		connGet.setRequestProperty("Authorization", "bearer "+accesstoken);
		
		int _respCode = connGet.getResponseCode();
		System.out.println("Response Code is: "+_respCode);
		if(_respCode==HttpURLConnection.HTTP_CREATED)
		{
			BufferedReader brGet = new BufferedReader(new InputStreamReader(connGet.getInputStream()));
			String _getStream;
			StringBuffer respGet = new StringBuffer();
			
			while((_getStream=brGet.readLine())!=null)
			{
				respGet.append(_getStream);
			}
			_leadListData = respGet.toString();
			brGet.close();
			System.out.println("Lead List Tabs Data: "+_leadListData);
		}
	}
	
	private static void mapTabCounts()
	{
		_leadListCount = _leadListCount.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll(":", ",").replaceAll("\"", "").toString();
		System.out.println("Formatted String: "+_leadListCount);
		String [] countData = _leadListCount.split(",");
		for(int i=0;i<countData.length;i+=2)
		{
			map.put(countData[i], countData[i+1]);
		}
		System.out.println("Map values"+map);
	}
	*/
	
	

}

