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
		 
		 stmt = con.createStatement();  
         rs = stmt.executeQuery(SQL);  

         // Iterate through the data in the result set and display it.  
         while (rs.next()) 
         {
        	 prn = rs.getString(14);
        	 System.out.println(prn);  
         }  
         return prn;
	}
	
	/*public static void main(String[] args) throws SQLException {
		establishDatabaseConnection();
		getPRNofLeadAddedThroughAppForm();
	}*/

}
