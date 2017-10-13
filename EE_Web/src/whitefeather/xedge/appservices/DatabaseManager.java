package whitefeather.xedge.appservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import whitefeather.xedge.facilitator.HelperHand;



public class DatabaseManager extends HelperHand
{
	public static String connectionUrl = "jdbc:sqlserver://extraaedgedb.database.windows.net:1433;" +  
	         "databaseName=ExtraaEdgeV2_Version1;user=theextradbuser;password=Dagies#g4D%7$3@f9723Sdgs"; 
	
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
	
	public static String getPRNofLeadAddedThroughAppForm() throws SQLException
	{
		Connection con = null;  
		Statement stmt = null;  
		ResultSet rs = null;  
		String prn = null;
		
		con = DriverManager.getConnection(connectionUrl); 
		
		String SQL = "SELECT * FROM Users WHERE EMAIL LIKE '%"+HelperHand.thirdPartyLeadEmail+"%'";
		/*String SQL = "DECLARE \r\n" + 
				"@USER_NAME NVARCHAR(60), \r\n" + 
				"@USER_MOBILE INT,\r\n" + 
				"@USER_ID INT,\r\n" + 
				"@CITIZENSHIP NVARCHAR(60)\r\n" + 
				"\r\n" + 
				"SET @USER_NAME = (SELECT TOP 1 FIRSTNAME FROM USERS WHERE FIRSTNAME LIKE '%LeadName_%' ORDER BY ID DESC)\r\n" + 
				"SET @USER_MOBILE = (SELECT TOP 1 MOBILENUMBER FROM USERS WHERE FIRSTNAME LIKE '%LeadName_%' ORDER BY ID DESC)\r\n" + 
				"SET @USER_ID = (SELECT TOP 1 ID FROM USERS WHERE FIRSTNAME LIKE '%LeadName_%' ORDER BY ID DESC)\r\n" + 
				"SET @CITIZENSHIP = (SELECT TOP 1 CITIZENSHIP FROM APPLICATIONFORM WHERE CITIZENSHIP = 'KOLHAPUR' AND USERID=@USER_ID)\r\n" + 
				"\r\n" + 
				"SELECT @USER_NAME, @USER_MOBILE, @USER_ID, @CITIZENSHIP";*/
		 stmt = con.createStatement();  
         rs = stmt.executeQuery(SQL);  

         // Iterate through the data in the result set and display it.  
         while (rs.next()) 
         {
        	 prn = rs.getString(14);
        	 System.out.println(prn);  
//        	 System.out.println(rs.getString(1)+" >> "+rs.getString(2)+" >> "+rs.getString(3)+" >>" +rs.getString(4));  
         }  
         return prn;
	}
	
	public static void main(String[] args) throws SQLException {
		establishDatabaseConnection();
		getPRNofLeadAddedThroughAppForm();
	}

}
