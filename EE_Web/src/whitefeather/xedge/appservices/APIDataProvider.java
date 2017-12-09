package whitefeather.xedge.appservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;

public class APIDataProvider 
{
	public static ObjectMapping properties = new ObjectMapping(Constants.URLs);
	static Object obj=null;
	static JSONObject jObject1 = null, jObject2 = null, jObject3 = null;
    
	static JSONArray jArray = null;
	static Iterator<?> jIterator = null;
	static String [] keyNames=null;
	static String standAloneKey=null;
    static String accesstoken,_dashboardCountJSONResponse,_leadListCountJSONResponse, getAllMasterJSONResp, childValueArray;
	
	private static HashMap<String,String > dashboardCountmap = new HashMap <String,String>();
	private static HashMap<String,String > leadListCountmap = new HashMap <String,String>();
	private static HashMap<String,String > getAllMasterMap = new HashMap <String,String>();
	
	public static String APILogin() throws IOException, MalformedURLException
	{
		//Establish QAStaging API connection
				URL _loginURL = new URL(properties.getAPILoginURL());
				HttpURLConnection connPost = (HttpURLConnection) _loginURL.openConnection();
				
				connPost.setDoOutput(true);
				connPost.setRequestMethod("POST");
				OutputStream osPost = connPost.getOutputStream();
				
				//Provide QAStaging Login Credentials
				osPost.write(properties.getAPILoginDetails().getBytes());
				osPost.flush();
				osPost.close();
				
				//Get response code after hitting Login API
				int respCode = connPost.getResponseCode();
//				System.out.println("Response Code received is: "+respCode);
				
				//Check and move ahead if connection is successful
				if(respCode==HttpURLConnection.HTTP_OK)
				{
					BufferedReader brPost = new BufferedReader(new InputStreamReader(connPost.getInputStream()));
					String _postStream="";
					StringBuffer respPost = new StringBuffer();
					while((_postStream=brPost.readLine())!=null)
					{
						//Store JSON response
						respPost.append(_postStream);
					}
					brPost.close();
//					System.out.println("API Login Successful. Details: "+respPost.toString());
					
					//Extract access token from stored JSON response and set it in a string
					String splitJson = respPost.toString();
					String part_1 = splitJson.split(",")[0];
					String part_2 = part_1.split(":")[1];
					accesstoken = part_2.replace("\"", "");
				}
		return accesstoken;
	}
	
	/***************Upcoming Tasks Page*************************/
	public static HashMap<String,String > getDashboardPageCounts() throws IOException, MalformedURLException
	{		
		//Establish connection to Dashboard Count API
		URL _dashboardAPI = new URL(properties.getDashboardCountAPIQAStaging());
		HttpURLConnection connGet = (HttpURLConnection)_dashboardAPI.openConnection();
		connGet.setRequestMethod("GET");
		connGet.setRequestProperty("Authorization", "bearer "+APILogin());
		
		//Get response code after hitting Dashboard Count API
		int _respCode = connGet.getResponseCode();
//		System.out.println("Response Code received is: "+_respCode);
		
		if(_respCode==HttpURLConnection.HTTP_OK)
		{
			BufferedReader brGet = new BufferedReader(new InputStreamReader(connGet.getInputStream()));
			String _getStream;
			StringBuffer respGet = new StringBuffer();
			
			while((_getStream=brGet.readLine())!=null)
			{
				respGet.append(_getStream);
			}
			
			//Store the Dashboard Count API response in a String
			_dashboardCountJSONResponse = respGet.toString();
//			System.out.println("Dashboard Count JSON Response: "+_dashboardCountJSONResponse);
			brGet.close();
		}
		
		//Parse JSON response and store it into Hashmap
		_dashboardCountJSONResponse = _dashboardCountJSONResponse.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll(":", ",").replaceAll("\"", "").toString();
		String [] countData = _dashboardCountJSONResponse.split(",");
		for(int i=0;i<countData.length;i+=2)
		{
			dashboardCountmap.put(countData[i], countData[i+1]);
		}
		
		return dashboardCountmap;	
	}
	
	//Get Recent New Tab Count on Dashboard
	public static String getRecentNewTabCount() throws MalformedURLException, IOException
	{
		return getDashboardPageCounts().get("newCount");
	}
	
	//Get Recent Online Tab Count on Dashboard
	public static String getRecentOnlineTabCount() throws MalformedURLException, IOException
	{
		return getDashboardPageCounts().get("onlineCount");
	}
	
	//Get  Upcoming Followup Tab Count on Dashboard
	public static String getUpcomingFollowupTabCount() throws MalformedURLException, IOException
	{
		return getDashboardPageCounts().get("upcomingFollowupCallCount");
	}
	
	//Get Upcoming Walkins Tab Count on Dashboard
	public static String getUpcomingWalkinsTabCount() throws MalformedURLException, IOException
	{
		return getDashboardPageCounts().get("personalVisitWalkInCount");
	}
	
	//Get High Priority Tab Count on Dashboard
	public static String getHighPriorityTabCount() throws MalformedURLException, IOException
	{
		return getDashboardPageCounts().get("highPriorityCount");
	}
	
	/***************Lead List Page*************************/
	public static HashMap<String,String > getLeadListPageCounts() throws IOException, MalformedURLException
	{		
		//Establish connection to Lead List Count API
		URL _leadListAPI = new URL(properties.getLeadListCountAPIQAStaging());
		HttpURLConnection connGet = (HttpURLConnection)_leadListAPI.openConnection();
		connGet.setRequestMethod("GET");
		connGet.setRequestProperty("Authorization", "bearer "+APILogin());
		
		//Get response code after hitting Lead List  Count API
		int _respCode = connGet.getResponseCode();
//		System.out.println("Response Code received is: "+_respCode);
		
		if(_respCode==HttpURLConnection.HTTP_OK)
		{
			BufferedReader brGet = new BufferedReader(new InputStreamReader(connGet.getInputStream()));
			String _getStream;
			StringBuffer respGet = new StringBuffer();
			
			while((_getStream=brGet.readLine())!=null)
			{
				respGet.append(_getStream);
			}
			
			//Store the Lead List Count API response in a String
			_leadListCountJSONResponse = respGet.toString();
//			System.out.println("Lead List Page Count JSON Response: "+_leadListCountJSONResponse);
			brGet.close();
		}
		
		//Parse JSON response and store it into Hashmap
		_leadListCountJSONResponse = _leadListCountJSONResponse.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll(":", ",").replaceAll("\"", "").toString();
		String [] countData = _leadListCountJSONResponse.split(",");
		for(int i=0;i<countData.length;i+=2)
		{
			leadListCountmap.put(countData[i], countData[i+1]);
		}	
		
		return leadListCountmap;	
	}
	
	//Get All Tab Count on Lead List
	public static String getAllTabCount() throws MalformedURLException, IOException
	{
		return getLeadListPageCounts().get("allCount");
	}
	
	//Get New Tab Count on Lead List
	public static String getNewTabCount() throws MalformedURLException, IOException
	{
		return getLeadListPageCounts().get("newCount");
	}
		
	//Get CallBack Tab Count on Lead List
	public static String getCallBackTabCount() throws MalformedURLException, IOException
	{
		return getLeadListPageCounts().get("callBackCount");
	}
		
	//Get Walkin Tab Count on Lead List
	public static String getWalkinTabCount() throws MalformedURLException, IOException
	{
		return getLeadListPageCounts().get("walkinCount");
	}
		
	//Get Enrolled Tab Count on Lead List
	public static String getEnrolledTabCount() throws MalformedURLException, IOException
	{
		return getLeadListPageCounts().get("enrollCount");
	}
		
	//Get Closed Tab Count on Lead List
	public static String getClosedTabCount() throws MalformedURLException, IOException
	{
		return getLeadListPageCounts().get("closeCount");
	}
		
	//Get Online Tab Count on Lead List
	public static String getOnlineTabCount() throws MalformedURLException, IOException
	{
		return getLeadListPageCounts().get("onlineCount");
	}
		
	//Get ReferredFromMe Tab Count on Lead List
	public static String getReferredFromMeTabCount() throws MalformedURLException, IOException
	{
		return getLeadListPageCounts().get("referredFromMeCount");
	}
	
	
	/***************Get All Masters API
	 * @throws ParseException *************************/
	//HashMap<String,String >
	public static String getAllMasterData() throws IOException, MalformedURLException, ParseException
	{		
		//Establish connection to Lead List Count API
		URL getAllMasterAPI = new URL(properties.getAllMastersEEV2API());
		HttpURLConnection connGet = (HttpURLConnection)getAllMasterAPI.openConnection();
		connGet.setRequestMethod("GET");
//		connGet.setRequestProperty("Authorization", "bearer "+APILogin());
		
		//Get response code after hitting Lead List  Count API
		int _respCode = connGet.getResponseCode();
		System.out.println("Response Code received is: "+_respCode);
		
		if(_respCode==HttpURLConnection.HTTP_OK)
		{
			BufferedReader brGet = new BufferedReader(new InputStreamReader(connGet.getInputStream()));
			String _getStream;
			StringBuffer respGet = new StringBuffer();
			while((_getStream=brGet.readLine())!=null)
			{
				respGet.append(_getStream);
			}
//			System.out.println("JSON - without string: "+respGet);
			//Store the Lead List Count API response in a String
			getAllMasterJSONResp = respGet.toString();
			System.out.println("getAllMaster JSON Response: "+getAllMasterJSONResp);
//			System.out.println("JSON-in string: "+respGet);
			brGet.close();
		}	
		return getAllMasterJSONResp;
	}
	
	public static void getJSONValuesFromArrays(String parent, String child) throws ParseException, MalformedURLException, IOException
	{
		// parsing file 
		obj = new JSONParser().parse(getAllMasterData());
        
		// Type casting object to JSONObject
		jObject1 = (JSONObject) obj;
		jArray = (JSONArray) jObject1.get(parent);
		jIterator = jArray.iterator();

        while (jIterator.hasNext()) {
        	jObject2 = (JSONObject) jIterator.next();
            childValueArray = (String)jObject2.get(child);
            keyNames = childValueArray.split(" ");
            for (int i = 0; i < keyNames.length; i++) {
				System.out.println("keyNames["+i+"]: "+keyNames[i]);
			}
        }
	}
	
	public static String getStandAloneJSONValues(String key) throws ParseException, MalformedURLException, IOException
	{
		// parsing file 
		obj = new JSONParser().parse(getAllMasterData());
				
		jObject3 = (JSONObject) obj;
        standAloneKey = (String)jObject3.get(key);
		return standAloneKey;
	}
	
	public static void tempMethodToMapValues()
	{
		Iterator<Entry<String, String>> trav=getAllMasterMap.entrySet().iterator();
		   while(trav.hasNext())
		   {
		      @SuppressWarnings("rawtypes")
			Map.Entry record=(Map.Entry)trav.next(); 
		 
		      System.out.println(record.getKey()+" : "+record.getValue());
		   }
	}
	
	public static void main(String[] args) {
		try {
			DecimalFormat time = new DecimalFormat("#0.0000");
			double starttime = System.currentTimeMillis();
			System.out.println("Start: "+ starttime+"\n===========================================================");
//			getJSONValuesFromArrays("leadStatuses","name");
			System.out.println(getStandAloneJSONValues("applicationFormCriteria"));
			double endtime = System.currentTimeMillis();
			System.out.println("\n===========================================================\nEnd: "+ endtime);
    		System.out.println("\nTotal: "+ time.format((endtime-starttime)/1000)+" seconds");
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

