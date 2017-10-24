package whitefeather.xedge.appservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import whitefeather.xedge.facilitator.HelperHand;



public class DatabaseManager extends HelperHand
{
	//to be done later - successful connection
	public static String connectionUrl = "jdbc:sqlserver://extraaedgedb.database.windows.net:1433;" +  
	         "databaseName=ExtraaEdgeV2_Version1;user=theextradbuser;password=Dagies#g4D%7$3@f9723Sdgs"; 
	
	
	
	static Connection con = null;  
	static Statement stmt = null;  
	static ResultSet rs = null;  
	static String prn = null;
	static String bloodGroup = null;
	static String userId = null;
	static String userEmail = null;
	static String userName = null;
	static String userMobile = null;
	static String userPRN = null;
	static String userDateOfBirth = null;
	static String emailId = "";

	
	
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
//		ausk245659@domain.in
		
		emailId = generateAppFormLeadEmail();
		System.out.println("Value-"+emailId);
		String SQL ="DECLARE \r\n" +
				"@USER_EMAIL NVARCHAR(80),\r\n" + 
				"@USER_NAME NVARCHAR(60), \r\n" + 
				"@USER_MOBILE INT,\r\n" + 
				"@USER_ID INT,\r\n" + 
				"@CITIZENSHIP NVARCHAR(60),\r\n" + 
				"@USER_NAMETIME NVARCHAR(80),\r\n" + 
				"@USER_PRN NVARCHAR(80),\r\n" + 
				"@USER_DOB DATETIME\r\n"+ 
				"SET @USER_NAMETIME = (SELECT CONCAT ('AppFormLead_',(SELECT TOP 1 CONVERT(VARCHAR(10), GETDATE(), 105))))\r\n" +
				"SET @USER_EMAIL = (SELECT EMAIL FROM USERS WHERE EMAIL LIKE '%"+emailId+"%')\r\n" + 
				"SET @USER_NAME = (SELECT TOP 1 FIRSTNAME FROM USERS WHERE FIRSTNAME LIKE '%'+@USER_NAMETIME+'%' AND EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_MOBILE = (SELECT TOP 1 MOBILENUMBER FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_ID = (SELECT TOP 1 ID FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_PRN = (SELECT TOP 1 PRN FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @USER_DOB = (SELECT TOP 1 DATEOFBIRTH FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"SET @CITIZENSHIP = (SELECT TOP 1 CITIZENSHIP FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"\r\n" + 
				"SELECT \r\n" + 
				"@USER_ID AS USERS_ID,\r\n" + 
				"@USER_EMAIL AS USERS_EMAIL, \r\n" + 
				"@USER_NAME AS USERS_FIRSTNAME, \r\n" + 
				"@USER_MOBILE AS USER_MOBILENUMBER, \r\n" + 
				"@USER_PRN AS USRS_PRN,\r\n" + 
				"@USER_DOB AS USERS_DOB,\r\n" + 
				"@CITIZENSHIP AS USERS_CITIZENSHIP";
		
		 stmt = con.createStatement();  
         rs = stmt.executeQuery(SQL);  

         // Iterate through the data in the result set and display it.  
         while (rs.next()) 
         {
//        	 prn = rs.getString(14);
//        	 System.out.println(prn); 
        	 userId = rs.getString(1);
        	 userEmail = rs.getString(2);
        	 userName = rs.getString(3);
        	 userMobile = rs.getString(4);
        	 userPRN = rs.getString(5);
        	 userDateOfBirth = rs.getString(6);
//        	 System.out.println(rs.getString(1));
//        	 System.out.println(rs.getString(2));
//        	 System.out.println(rs.getString(3));
//        	 System.out.println(rs.getString(4));
//        	 System.out.println(rs.getString(1)+" >> "+rs.getString(2)+" >> "+rs.getString(3)+" >>" +rs.getString(4));  
         }  
         con.close();
//         return prn;
	}
	
	public static String getUserIdFromUsers() throws SQLException
	{
		return userId;
	}
	public static String getUserEmailFromUsers() throws SQLException
	{
		return userEmail;
	}
	public static String getLeadNameFromUsers() throws SQLException
	{
		return userName;
	}
	public static String getLeadMobileFromUsers() throws SQLException
	{
		return userMobile;
	}
	public static String getPRNFromUsers() throws SQLException
	{
		return userPRN;
	}
	public static String getUserDOBFromUsers() throws SQLException
	{
		return userDateOfBirth;
	}
	
	public static void main(String[] args) throws SQLException {
		establishDatabaseConnection();
		getLeadDataFromDatabase();
		System.out.println(getUserIdFromUsers());
		System.out.println(getUserEmailFromUsers());
		System.out.println(getLeadNameFromUsers());
		System.out.println(getLeadMobileFromUsers());
		System.out.println(getPRNFromUsers());
		System.out.println(getUserDOBFromUsers());
	}

}
