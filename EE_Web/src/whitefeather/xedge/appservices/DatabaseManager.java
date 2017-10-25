package whitefeather.xedge.appservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import whitefeather.xedge.facilitator.HelperHand;

public class DatabaseManager extends HelperHand
{
	//to be done later - secure connection
	public static String connectionUrl = "jdbc:sqlserver://extraaedgedb.database.windows.net:1433;" +  
	         "databaseName=ExtraaEdgeV2_Version1;user=theextradbuser;password=Dagies#g4D%7$3@f9723Sdgs"; 
	
	static Connection con = null;  
	static Statement stmt = null;  
	static ResultSet rs = null;  
	static String userDob;
	static DateFormat  dobCustomFormat = new SimpleDateFormat("yyyy-mm-dd");;
	
	
	public static void establishDatabaseConnection() throws SQLException
	{
		
		try 
		 {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 }
		 catch (ClassNotFoundException e) 
		 {
			e.printStackTrace();
		 }  
	}
	
	public static void getLeadDataFromDatabase() throws SQLException
	{		
		con = DriverManager.getConnection(connectionUrl); 
		
//		String SQL = "SELECT * FROM Users WHERE EMAIL LIKE '%"+HelperHand.thirdPartyLeadEmail+"%'";
//		String SQL = "SELECT * FROM Users WHERE EMAIL LIKE '%"+"ausk245659@domain.in"+"%'";

		String SQL ="DECLARE \r\n" + 
				"@USER_EMAIL NVARCHAR(80),\r\n" + 
				"@USER_NAME NVARCHAR(60), \r\n" + 
				"@USER_MOBILE INT,\r\n" + 
				"@USER_ID INT,\r\n" + 
				"@CITIZENSHIP NVARCHAR(60),\r\n" + 
				"@USER_NAMETIME NVARCHAR(80),\r\n" + 
				"@USER_PRN NVARCHAR(80),\r\n" + 
				"@USER_DOB DATETIME,\r\n" + 
				"@USER_BLOODGRP NVARCHAR(10),\r\n" + 
				"@USER_GENDER NVARCHAR(10),\r\n" + 
				"@USER_ADDRESS NVARCHAR(100),\r\n" + 
				"@USER_COUNTRY NVARCHAR(40),\r\n" + 
				"@USER_STATE NVARCHAR(40),\r\n" + 
				"@USER_CITY NVARCHAR(40)\r\n" + 
				"SET @USER_NAMETIME = (SELECT CONCAT ('AppFormLead_',(SELECT TOP 1 CONVERT(VARCHAR(10), GETDATE(), 105))))\r\n" + 
				"SET @USER_EMAIL = (SELECT TOP 1 EMAIL FROM USERS WHERE FIRSTNAME LIKE '%'+@USER_NAMETIME+'%' ORDER BY ID DESC)\r\n" + 
				"--SET @USER_EMAIL = '\"+thirdPartyLeadEmail+\"'\"+ \r\n" + 
				"SET @USER_NAME = (SELECT TOP 1 FIRSTNAME FROM USERS WHERE FIRSTNAME LIKE '%'+@USER_NAMETIME+'%' AND EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_MOBILE = (SELECT TOP 1 MOBILENUMBER FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_ID = (SELECT TOP 1 ID FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_PRN = (SELECT TOP 1 PRN FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_DOB = (SELECT TOP 1 DATEOFBIRTH FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_BLOODGRP = (SELECT TOP 1 BLOODGROUP FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_GENDER = (SELECT TOP 1 GENDER FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_ADDRESS = (SELECT TOP 1 ADDRESS FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_COUNTRY = (SELECT TOP 1 COUNTRYID FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_STATE = (SELECT TOP 1 STATEID FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_CITY = (SELECT TOP 1 CITYID FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @CITIZENSHIP = (SELECT TOP 1 CITIZENSHIP FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"SELECT \r\n" + 
				"@USER_ID AS USERS_ID,\r\n" + 
				"@USER_EMAIL AS USERS_EMAIL, \r\n" + 
				"@USER_NAME AS USERS_FIRSTNAME, \r\n" + 
				"@USER_MOBILE AS USERS_MOBILENUMBER, \r\n" + 
				"@USER_PRN AS USRS_PRN,\r\n" + 
				"@USER_DOB AS USERS_DOB,\r\n" + 
				"@USER_BLOODGRP AS USERS_BLOODGROUP,\r\n" + 
				"@USER_GENDER AS USERS_GENDER,\r\n" + 
				"@USER_ADDRESS AS USERS_ADDRESS,\r\n" + 
				"@USER_COUNTRY AS USERS_COUNTRY,\r\n" + 
				"@USER_STATE AS USERS_STATE,\r\n" + 
				"@USER_CITY AS USERS_CITY,\r\n" + 
				"@CITIZENSHIP AS USERS_CITIZENSHIP";
		
		 stmt = con.createStatement();  
         rs = stmt.executeQuery(SQL);  

         // Iterate through the data in the result set and display it.  
         while (rs.next()) 
         {
//        	 userDob = dobCustomFormat.format(rs.getDate("USERS_DOB"));
        	 dbValues.put("userId", rs.getString(1));
        	 dbValues.put("userEmail", rs.getString(2));
        	 dbValues.put("userName", rs.getString(3));
        	 dbValues.put("userMobile", rs.getString(4));
        	 dbValues.put("userPRN", rs.getString(5));
        	 dbValues.put("userDOB", rs.getString(6));	//Use this format when both date and time is needed.
//        	 dbValues.put("userDOB",userDob );	//Use this format when only date is needed is needed.
        	 dbValues.put("userBloodGrp", rs.getString(7));
        	 dbValues.put("userGender", rs.getString(8));
        	 dbValues.put("userAddress", rs.getString(9));
        	 dbValues.put("userCountry", rs.getString(10));
        	 dbValues.put("userState", rs.getString(11));
        	 dbValues.put("userCity", rs.getString(12));
        	 dbValues.put("appFormCitizenship", rs.getString(13));
         }  
         con.close();
//         return userPRN;
	}
	
	@SuppressWarnings("rawtypes")
	public static void tempMethodToPrintDBValues()
	{
		Iterator<Entry<String, String>> trav=dbValues.entrySet().iterator();
		   while(trav.hasNext())
		   {
		      Map.Entry record=(Map.Entry)trav.next(); 
		 
		      System.out.println(record.getKey()+" : "+record.getValue());
		   }
	}
	public static void main(String[] args) throws SQLException {
		establishDatabaseConnection();
		getLeadDataFromDatabase();
		tempMethodToPrintDBValues();
//		System.out.println(Arrays.asList(dbValues)); // method 1
//	    System.out.println(Collections.singletonList(dbValues)); // method 2
	}

}
