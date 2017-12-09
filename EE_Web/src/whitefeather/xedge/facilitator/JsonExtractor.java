package whitefeather.xedge.facilitator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appservices.DatabaseManager;

//Separate Extractor class considering future possibility of more n more use of JSON files
public class JsonExtractor extends HelperHand
{
	
	public static String getDatabaseName(String dbName) throws FileNotFoundException, IOException, ParseException
	{
		// parsing file 
        Object obj = new JSONParser().parse(new FileReader(Constants.DBJSON));
         
        // Type casting object to JSONObject
        JSONObject jo = (JSONObject) obj;
         
        // getting dbname
        return (String) jo.get(dbName);
	}
	
	public static String getClientConfiguration(String configString) throws FileNotFoundException, IOException, ParseException
	{
		try {
			clientConfig = DatabaseManager.getClientConfigDetails();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// parsing file 
        Object obj = new JSONParser().parse(clientConfig);
         
        // Type casting object to JSONObject
        JSONObject jo = (JSONObject) obj;
        
     // First I take the global data
        String name = (String) jo.get("DBConnectionString");
        System.out.println(name);

        JSONArray slideContent1 = (JSONArray) jo.get("ReportDeviceConfig");
        Iterator<?> i = slideContent1.iterator();

        while (i.hasNext()) {
            JSONObject slide = (JSONObject) i.next();
            String title = (String)slide.get("chartDetails");
            System.out.println(title);
        }
        // getting dbname
        return (String) jo.get(configString);
	}
	
	
	public static void getConfigValue(String dbName) throws FileNotFoundException, IOException, ParseException
	{
		
        
        // getting dbname
//        return (String) jo.get(dbName);
	}

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws SQLException  
	{
		DecimalFormat time = new DecimalFormat("#0.0000");
		double starttime = System.currentTimeMillis();
		System.out.println("Start: "+ starttime+"\n===========================================================");
//			getClientConfig();
			clientConfig = DatabaseManager.getClientConfigDetails();
			// parsing file 
	        Object obj = null;
			try {
				obj = new JSONParser().parse(clientConfig);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         
	        // Type casting object to JSONObject
	        JSONObject jo = (JSONObject) obj;
	         
	     
	        HashMap<?, ?> StoreSetting = ((HashMap<?, ?>)jo.get("StoreSetting"));

            System.out.println("DomainUrl: "+StoreSetting.get("DomainUrl"));
            System.out.println("PricingCriterion: "+StoreSetting.get("PricingCriterion"));
            System.out.println("RegistrationEntityCriterion: "+StoreSetting.get("RegistrationEntityCriterion"));
            System.out.println("ApplicationFormCriteria: "+StoreSetting.get("ApplicationFormCriteria"));
            
            @SuppressWarnings("unchecked")
			HashMap<HashMap<?, ?>, HashMap<?, ?>> NIMBUS = (HashMap<HashMap<?, ?>, HashMap<?, ?>>)jo.get("NIMBUS");
            System.out.println("NIMBUS: "+NIMBUS.get("requestMappings"));
            double endtime = System.currentTimeMillis();
    		System.out.println("\n===========================================================\nEnd: "+ endtime);
    		System.out.println("\nTotal: "+ time.format((endtime-starttime)/1000)+" seconds");


	}
}
