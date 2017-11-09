package whitefeather.xedge.appservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import whitefeather.xedge.facilitator.HelperHand;
import whitefeather.xedge.testcases.GenerateLeadForApplicationForm;

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

		//Find out lead based on provided Email or Mobile Number. Develop logic later.
		String SQL ="DECLARE \r\n" + 
				"	@USER_EMAIL NVARCHAR(80),\r\n" + 
				"	@USER_NAME NVARCHAR(100), \r\n" + 
				"	@USER_MOBILE INT,\r\n" + 
				"	@ENTITY2_ENTITY NVARCHAR(80),\r\n" + 
				"	@USER_ID INT,\r\n" + 
				"	@USER_NAMETIME NVARCHAR(80),\r\n" + 
				"	@USER_PRN NVARCHAR(80),\r\n" + 
				"	@USER_DOB DATETIME,\r\n" + 
				"	@USER_PLACEOFBIRTH NVARCHAR(40),\r\n" + 
				"	@USER_BLOODGRP NVARCHAR(10),\r\n" + 
				"	@USER_NATIONALITY NVARCHAR(60),\r\n" + 
				"	@USER_GENDER NVARCHAR(10),\r\n" + 
				"	@APPFORM_UID NVARCHAR(20),\r\n" + 
				"	@APPFORM_PASSPORTNUMBER NVARCHAR(20),\r\n" + 
				"	@APPFORM_PLACEOFISSUE NVARCHAR(40),\r\n" + 
				"	@APPFORM_DATEOFISSUE DATETIME,\r\n" + 
				"	@APPFORM_EXPIRYDATE DATETIME,\r\n" + 
				"	@USERCOMM_APPFORMID INT,\r\n" + 
				"	@APPFORM_RELIGION NVARCHAR(40),\r\n" + 
				"	@APPFORM_CITIZENSHIP NVARCHAR(60),\r\n" + 
				"	@APPFORM_CASTE NVARCHAR(40),\r\n" + 
				"	@APPFORM_DOMICILE NVARCHAR(40),\r\n" + 
				"	@APPFORM_COMMUNITY NVARCHAR(40),\r\n" + 
				"	@USER_ADDRESS NVARCHAR(100),\r\n" + 
				"	@USER_COUNTRY NVARCHAR(40),\r\n" + 
				"	@USER_STATE NVARCHAR(60),\r\n" + 
				"	@USER_CITY NVARCHAR(80),\r\n" + 
				"	@USER_FATHRNAME NVARCHAR(100), \r\n" + 
				"	@APPFORM_FATHERQUALFCN NVARCHAR(60),\r\n" + 
				"	@APPFORM_FATHEROCCUPN NVARCHAR(60),\r\n" + 
				"	@APPFORM_FATHERINCOME NVARCHAR(60),\r\n" + 
				"	@USER_FATHEREMAIL NVARCHAR(80),\r\n" + 
				"	@USER_FATHERMOBILE NVARCHAR(40),\r\n" + 
				"	@USER_MOTHERNAME NVARCHAR(100),\r\n" + 
				"	@APPFORM_MOTHERQUALFCN NVARCHAR(60),\r\n" + 
				"	@APPFORM_MOTHEROCCUPN NVARCHAR(60),\r\n" + 
				"	@USER_MOTHEREMAIL NVARCHAR(80),\r\n" + 
				"	@USER_MOTHERMOBILE NVARCHAR(40),\r\n" + 
				"	@USER_LOCALGRDNNAME NVARCHAR(100),\r\n" + 
				"	@USERCOMM_LCLADDRTYPE INT,\r\n" + 
				"	@USERCOMMN_LCLADDR1 NVARCHAR(100),\r\n" + 
				"	@USERCOMMN_LCLADDR2 NVARCHAR(100),\r\n" + 
				"	@USERCOMMN_LCLADDR3 NVARCHAR(100),\r\n" + 
				"	@USERCOMMN_PINCODE NVARCHAR(10),\r\n" + 
				"	@USERCOMMN_GRDNCOTACTNUMBER NVARCHAR(40),\r\n" + 
				"	@USER_EMERGNCYNAME NVARCHAR(100),\r\n" + 
				"	@USERCOMM_PRMADDRTYPE INT,\r\n" + 
				"	@USERCOMMN_PRMADDR1 NVARCHAR(100),\r\n" + 
				"	@USERCOMMN_PRMADDR2 NVARCHAR(100),\r\n" + 
				"	@USERCOMMN_PRMCONTACTNUM NVARCHAR(40),\r\n" + 
				"	@USER_EMERGNCYRELN NVARCHAR(50),\r\n" + 
				"	@USER_HIGHSCHOOLNM NVARCHAR(40),\r\n" + 
				"	@APPFORM_REGNUM1 NVARCHAR(20),\r\n" + 
				"	@APPFORM_SSLCYOP NVARCHAR(10),\r\n" + 
				"	@USER_HSPERCENT NVARCHAR(10),\r\n" + 
				"	@APPFORM_MODEOFSTUDYSSC NVARCHAR(30),\r\n" + 
				"	@USER_SECSCHOOLNM NVARCHAR(60),\r\n" + 
				"	@APPFORM_REGNUM2 NVARCHAR(20),\r\n" + 
				"	@APPFORM_HSLCYOP NVARCHAR(10),\r\n" + 
				"	@USER_UGPERCENT NVARCHAR(10),\r\n" + 
				"	@APPFORM_MODEOFSTUDYHSC NVARCHAR(30),\r\n" + 
				"	@APPFORM_ENTRNCEXAM NVARCHAR(80)\r\n" + 
				"\r\n" + 
				"	SET @USER_NAMETIME = (SELECT CONCAT ('AppFormLead_',(SELECT TOP 1 CONVERT(VARCHAR(10), GETDATE(), 105))))\r\n" + 
				"	SET @USER_EMAIL = (SELECT TOP 1 EMAIL FROM USERS WHERE FIRSTNAME LIKE '%'+@USER_NAMETIME+'%' ORDER BY ID DESC)\r\n" + 
				"	--SET @USER_EMAIL = '\"+thirdPartyLeadEmail+\"'\"+ \r\n" + 
				"	SET @USER_NAME = (SELECT TOP 1 FIRSTNAME FROM USERS WHERE FIRSTNAME LIKE '%'+@USER_NAMETIME+'%' AND EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USER_MOBILE = (SELECT TOP 1 MOBILENUMBER FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USER_ID = (SELECT TOP 1 ID FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @ENTITY2_ENTITY = (SELECT TOP 1 NAME FROM ENTITY2 WHERE ID = (SELECT TOP 1 ENTITY2ID FROM LEADENTITY2IDS WHERE LEADID = (SELECT TOP 1 ID FROM LEADS WHERE USERID=(SELECT TOP 1 ID FROM USERS ORDER BY ID DESC))))\r\n" + 
				"	SET @USER_PRN = (SELECT TOP 1 PRN FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USER_DOB = (SELECT TOP 1 DATEOFBIRTH FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USER_PLACEOFBIRTH = (SELECT TOP 1 PLACEOFBIRTH FROM USERS WHERE  ID=@USER_ID ORDER BY ID DESC)\r\n" + 
				"	SET @USER_GENDER = (SELECT TOP 1 GENDER FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USER_BLOODGRP = (SELECT TOP 1 BLOODGROUP FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USER_NATIONALITY = (SELECT TOP 1 NATIONALITY FROM USERS WHERE EMAIL = @USER_EMAIL)\r\n" + 
				"	SET @APPFORM_UID = (SELECT TOP 1 AADHAARNO FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_PASSPORTNUMBER = (SELECT TOP 1 PASSPORTNUMBER FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_PLACEOFISSUE = (SELECT TOP 1 PLACEOFISSUE FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_DATEOFISSUE = (SELECT TOP 1 DATEOFISSUE FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_EXPIRYDATE = (SELECT TOP 1 EXPIRYDATE FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_RELIGION = (SELECT TOP 1 RELIGION FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_CITIZENSHIP = (SELECT TOP 1 CITIZENSHIP FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_CASTE = (SELECT TOP 1 CASTE FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_DOMICILE = (SELECT TOP 1 DOMICILE FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_COMMUNITY = (SELECT TOP 1 CATEGORY FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @USER_ADDRESS = (SELECT TOP 1 ADDRESS FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	--SET @USER_COUNTRY = (SELECT TOP 1 COUNTRYID FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USER_COUNTRY =  (SELECT NAME FROM COUNTRIES WHERE ID = (SELECT COUNTRYID FROM USERS WHERE ID=@USER_ID))\r\n" + 
				"	--SET @USER_STATE = (SELECT TOP 1 STATEID FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USER_STATE =  (SELECT NAME FROM STATES WHERE ID = (SELECT STATEID FROM USERS WHERE ID=@USER_ID))\r\n" + 
				"	--SET @USER_CITY = (SELECT TOP 1 CITYID FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USER_CITY = (SELECT NAME FROM CITIES WHERE ID = (SELECT CITYID FROM USERS WHERE ID=@USER_ID))\r\n" + 
				"	SET @USERCOMM_LCLADDRTYPE = (SELECT TOP 1 ID FROM COMMUNICATIONADDRESSINFO WHERE USERID=@USER_ID AND ADDRESS ='LocalAddress') --Using string 'LocalAddress' and 'PermanentAddress' just because I am not sure for this requirement.\r\n" + 
				"	SET @USERCOMM_PRMADDRTYPE = (SELECT TOP 1 ID FROM COMMUNICATIONADDRESSINFO WHERE USERID=@USER_ID AND ADDRESS ='PermanentAddress') \r\n" + 
				"	SET @USER_FATHRNAME = (SELECT TOP 1 FATHERSNAME FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @APPFORM_FATHERQUALFCN = (SELECT TOP 1 FATHERQUALIFICATION FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_FATHEROCCUPN = (SELECT TOP 1 FATHEROCCUPATION FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_FATHERINCOME = (SELECT TOP 1 FATHERANNUALINCOME FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @USER_FATHEREMAIL = (SELECT TOP 1 FATHERSEMAIL FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USER_FATHERMOBILE = (SELECT TOP 1 FATHERSMOBILE FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USER_MOTHERNAME = (SELECT TOP 1 MOTHERSNAME FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @APPFORM_MOTHERQUALFCN = (SELECT TOP 1 MOTHERQUALIFICATION FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_MOTHEROCCUPN = (SELECT TOP 1 MOTHEROCCUPATION FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @USER_MOTHEREMAIL = (SELECT TOP 1 MOTHERSEMAIL FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USER_MOTHERMOBILE = (SELECT TOP 1 MOTHERSMOBILE FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USER_LOCALGRDNNAME = (SELECT TOP 1 EMERGENCYCONTACTNAME FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	--@USERCOMM_LCLADDRTYPE - Step1 = use in permanent address\r\n" + 
				"	SET @USERCOMMN_LCLADDR1 = (SELECT TOP 1 ADDRESS1 FROM USERCOMMUNICATION WHERE COMMUNICATIONADDRESSINFOID=@USERCOMM_PRMADDRTYPE ORDER BY ID DESC)\r\n" + 
				"	SET @USERCOMMN_LCLADDR2 = (SELECT TOP 1 ADDRESS2 FROM USERCOMMUNICATION WHERE COMMUNICATIONADDRESSINFOID=@USERCOMM_PRMADDRTYPE ORDER BY ID DESC)\r\n" + 
				"	SET @USERCOMMN_LCLADDR3 = (SELECT TOP 1 ADDRESS3 FROM USERCOMMUNICATION WHERE COMMUNICATIONADDRESSINFOID=@USERCOMM_PRMADDRTYPE ORDER BY ID DESC)\r\n" + 
				"	SET @USERCOMMN_PINCODE = (SELECT TOP 1 PINCODE FROM USERCOMMUNICATION WHERE USERID=@USER_ID ORDER BY ID DESC)\r\n" + 
				"	SET @USER_EMERGNCYRELN = (SELECT TOP 1 EMERGENCYRELATIONSHIP FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @USERCOMMN_GRDNCOTACTNUMBER = (SELECT TOP 1 EMERGENCYPHONENUMBER FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	--SET @USERCOMMN_PRMADDR1 = (SELECT TOP 1 ADDRESS1 FROM USERCOMMUNICATION WHERE COMMUNICATIONADDRESSINFOID=@USERCOMM_PRMADDRTYPE ORDER BY ID DESC)\r\n" + 
				"	--SET @USERCOMMN_PRMADDR2 = (SELECT TOP 1 ADDRESS2 FROM USERCOMMUNICATION WHERE COMMUNICATIONADDRESSINFOID=@USERCOMM_PRMADDRTYPE ORDER BY ID DESC)\r\n" + 
				"	--SET @USERCOMMN_PRMCONTACTNUM = (SELECT TOP 1 ALTERNATENUMBER FROM USERCOMMUNICATION WHERE COMMUNICATIONADDRESSINFOID=@USERCOMM_PRMADDRTYPE ORDER BY ID DESC)\r\n" + 
				"	--Skipping Entity1 validation as of now since its not implemented yet in Step 3.\r\n" + 
				"	SET @USER_HIGHSCHOOLNM = (SELECT TOP 1 HIGHSCHOOLEXAMINATIONNAME FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @APPFORM_REGNUM1 = (SELECT TOP 1 REGISTRATIONNUMBER1 FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_SSLCYOP = (SELECT TOP 1 SSLCYEAROFPASSING FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @USER_HSPERCENT = (SELECT TOP 1 HIGHSCHOOLEXAMINATIONNAME FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @APPFORM_MODEOFSTUDYSSC = (SELECT TOP 1 MODEOFSTUDYSSLC FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @USER_SECSCHOOLNM = (SELECT TOP 1 GRADUATIONINSTITUTENAME FROM APPLICATIONFORM WHERE USERID=@USER_ID ORDER BY ID DESC)\r\n" + 
				"	SET @APPFORM_REGNUM2 = (SELECT TOP 1 REGISTRATIONNUMBER2 FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_HSLCYOP = (SELECT TOP 1 XIIYEAROFPASSING FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @USER_UGPERCENT = (SELECT TOP 1 UNDERGRADUATEPERCENTAGE FROM USERS WHERE EMAIL = @USER_EMAIL ORDER BY ID DESC)\r\n" + 
				"	SET @APPFORM_MODEOFSTUDYHSC = (SELECT TOP 1 XIIMODEOFSTUDY FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"	SET @APPFORM_ENTRNCEXAM = (SELECT TOP 1 ENTRANCEEXAM FROM APPLICATIONFORM WHERE USERID=@USER_ID)\r\n" + 
				"\r\n" + 
				"	SELECT \r\n" + 
				"	@USER_ID AS USERS_ID,\r\n" + 
				"	@USER_EMAIL AS USERS_EMAIL, \r\n" + 
				"	@USER_NAME AS USERS_FIRSTNAME, \r\n" + 
				"	@USER_MOBILE AS USERS_MOBILENUMBER, \r\n" + 
				"	@ENTITY2_ENTITY AS ENTITY2_ENTITY,\r\n" + 
				"	@USER_PRN AS USRS_PRN,\r\n" + 
				"	@USER_DOB AS USERS_DOB,\r\n" + 
				"	@USER_PLACEOFBIRTH AS USERS_PLACEOFBIRTH,\r\n" + 
				"	@USER_GENDER AS USERS_GENDER,\r\n" + 
				"	@USER_BLOODGRP AS USERS_BLOODGROUP,\r\n" + 
				"	@USER_NATIONALITY AS USERS_NATIONALITY,\r\n" + 
				"	@APPFORM_UID AS APPLFORM_UID,\r\n" + 
				"	@APPFORM_PASSPORTNUMBER AS APPLFORM_PASSPORTNUMBER,\r\n" + 
				"	@APPFORM_PLACEOFISSUE AS APPLFORM_PLACEOFISSUE,\r\n" + 
				"	@APPFORM_DATEOFISSUE AS APPLFORM_DATEOFISSUE,\r\n" + 
				"	@APPFORM_EXPIRYDATE AS APPLFORM_EXPIRYDATE,\r\n" + 
				"	@APPFORM_RELIGION AS APPLFORM_RELIGION,\r\n" + 
				"	@APPFORM_CITIZENSHIP AS APPLFORM_CITIZENSHIP,\r\n" + 
				"	@APPFORM_CASTE AS APPLFORM_CASTE,\r\n" + 
				"	@APPFORM_DOMICILE AS APPLFORM_DOMICILE,\r\n" + 
				"	@APPFORM_COMMUNITY AS APPLFORM_COMMUNITY,\r\n" + 
				"	@USER_ADDRESS AS USERS_ADDRESS,\r\n" + 
				"	@USER_COUNTRY AS USERS_COUNTRY,\r\n" + 
				"	@USER_STATE AS USERS_STATE,\r\n" + 
				"	@USER_CITY AS USERS_CITY,\r\n" + 
				"	@USER_FATHRNAME AS USERS_FTHRNAME,\r\n" + 
				"	@APPFORM_FATHERQUALFCN AS APPLFORM_FATHERQUALFCN,\r\n" + 
				"	@APPFORM_FATHEROCCUPN AS APPLFORM_FATHEROCCUPN,\r\n" + 
				"	@APPFORM_FATHERINCOME AS APPLFORM_FATHERINCOME,\r\n" + 
				"	@USER_FATHEREMAIL AS USERS_FATHEREMAIL,\r\n" + 
				"	@USER_FATHERMOBILE AS USERS_FATHERMOBILE,\r\n" + 
				"	@USER_MOTHERNAME AS USERS_MOTHERSNAME,\r\n" + 
				"	@APPFORM_MOTHERQUALFCN AS APPLFORM_MOTHERQUALFCN,\r\n" + 
				"	@APPFORM_MOTHEROCCUPN AS APPLFORM_MOTHEROCCUPN,\r\n" + 
				"	@USER_MOTHEREMAIL AS USERS_MOTHEREMAIL,\r\n" + 
				"	@USER_MOTHERMOBILE AS USERS_MOTHERMOBILE,\r\n" + 
				"	@USER_LOCALGRDNNAME AS USERS_LOCALGRDNNAME,\r\n" + 
				"	@USERCOMMN_LCLADDR1 AS LOCAL_ADDRESS1,\r\n" + 
				"	@USERCOMMN_LCLADDR2 AS LOCAL_ADDRESS2,\r\n" + 
				"	@USERCOMMN_LCLADDR3 AS LOCAL_ADDRESS3,\r\n" + 
				"	@USERCOMMN_PINCODE AS USERCOMMN_PINCODE,\r\n" + 
				"	@USER_EMERGNCYRELN AS USERS_EMERGNCYRELATION,\r\n" + 
				"	@USERCOMMN_GRDNCOTACTNUMBER AS USERCOMM_GUARDIANCOTACTNUM,\r\n" + 
				"	@USERCOMMN_PRMADDR1 AS USERCOMMN_PERMANENTADDR1,\r\n" + 
				"	@USERCOMMN_PRMADDR2 AS USERCOMMN_PERMANENTADDR2,\r\n" + 
				"	@USERCOMMN_PRMCONTACTNUM AS USERCOMMN_PERMANENTCONTACTNUM,\r\n" + 
				"	@USER_HIGHSCHOOLNM AS USERS_HIGHSCHOOLNAME,\r\n" + 
				"	@APPFORM_REGNUM1 AS APPLFORM_REGNUMBER,\r\n" + 
				"	@APPFORM_SSLCYOP AS APPLFORM_SSLCYOP,\r\n" + 
				"	@USER_HSPERCENT AS USERS_HIGHSCHOOLPERCENTG,\r\n" + 
				"	@APPFORM_MODEOFSTUDYSSC AS APPLFORM_MODEOFSTUDYSSC,\r\n" + 
				"	@USER_SECSCHOOLNM AS USERS_SECSCHOOLNAME,\r\n" + 
				"	@APPFORM_REGNUM2 AS APPLFORM_SECREGNUMBER,\r\n" + 
				"	@APPFORM_HSLCYOP AS APPLFORM_HSLCYOP,\r\n" + 
				"	@USER_UGPERCENT AS USERS_UGPERCENTG,\r\n" + 
				"	@APPFORM_MODEOFSTUDYHSC AS APPLFORM_MODEOFSTUDYHSC,\r\n" + 
				"	@APPFORM_ENTRNCEXAM AS APPLFORM_ENTRANCEEXAM";
		
		 stmt = con.createStatement();  
         rs = stmt.executeQuery(SQL);  

         // Iterate through the data in the result set and display it.  
         while (rs.next()) 
         {
/*        	 dbValues.put("userDOB", rs.getString(6));	//Use this format when both date and time is needed.
        	 userDob = dobCustomFormat.format(rs.getDate("USERS_DOB"));
        	 dbValues.put("userDOB",userDob );	//Use this format when only date is needed is needed.
*/        	 
        	 dbValues.put("userId", rs.getString(1));
        	 dbValues.put("userEmail", rs.getString(2));
        	 dbValues.put("userName", rs.getString(3));
        	 dbValues.put("userMobile", rs.getString(4));
        	 dbValues.put("entityEntity", rs.getString(5));
        	 dbValues.put("userPRN", rs.getString(6));
        	 dbValues.put("userDOB", rs.getString(7));
        	 dbValues.put("userPlaceOfBirth", rs.getString(8));
        	 dbValues.put("userGender", rs.getString(9));
        	 dbValues.put("userBloodGrp", rs.getString(10));
        	 dbValues.put("userNationality", rs.getString(11));
        	 dbValues.put("appFormUID", rs.getString(12));
        	 dbValues.put("appFormPassportNum", rs.getString(13));
        	 dbValues.put("appFormPlaceOfIssue", rs.getString(14));
        	 dbValues.put("appFormDateOfIssue", rs.getString(15));
        	 dbValues.put("appFormExpiryDate", rs.getString(16));
        	 dbValues.put("appFormReligion", rs.getString(17));
        	 dbValues.put("appFormCitizenship", rs.getString(18));
        	 dbValues.put("appFormCaste", rs.getString(19));
        	 dbValues.put("appFormDomicile", rs.getString(20));
        	 dbValues.put("appFormCommunity", rs.getString(21));
        	 dbValues.put("userPresentAddress", rs.getString(22));
        	 dbValues.put("userPresentAddrCountry", rs.getString(23));
        	 dbValues.put("userPresentAddrState", rs.getString(24));
        	 dbValues.put("userPresentAddrCity", rs.getString(25));
        	 dbValues.put("userFathersName", rs.getString(26));
        	 dbValues.put("appFormFatherQualfcn", rs.getString(27));
        	 dbValues.put("appFormFatherOccpn", rs.getString(28));
        	 dbValues.put("appFormFatherIncome", rs.getString(29));
        	 dbValues.put("userFthrEmail", rs.getString(30));
        	 dbValues.put("userFthrMob", rs.getString(31));
        	 dbValues.put("userMothersName", rs.getString(32));
        	 dbValues.put("appFormMotherQualfcn", rs.getString(33));
        	 dbValues.put("appFormMotherOccpn", rs.getString(34));
        	 dbValues.put("userMthrEmail", rs.getString(35));
        	 dbValues.put("userMthrMob", rs.getString(36));
        	 dbValues.put("userLocalGrdnName", rs.getString(37));
        	 dbValues.put("usercommLAddr1", rs.getString(38));
        	 dbValues.put("usercommLAddr2", rs.getString(39));
        	 dbValues.put("usercommLAddr3", rs.getString(40));
        	 dbValues.put("usercommPincode", rs.getString(41));
        	 dbValues.put("userEmrgncyRelatn", rs.getString(42));
        	 dbValues.put("userGrdnContactNum", rs.getString(43));
        	 dbValues.put("userCommPrimaryAddr1", rs.getString(44));
        	 dbValues.put("userCommPrimaryAddr2", rs.getString(45));
        	 dbValues.put("userCommPrimaryContactNum", rs.getString(46));
        	 dbValues.put("userHighSchoolNm", rs.getString(47));
        	 dbValues.put("appFormRegNum1", rs.getString(48));
        	 dbValues.put("appFormSSLCYop", rs.getString(49));
        	 dbValues.put("appFormMoSSSC", rs.getString(50));
        	 dbValues.put("userSecSchoolNm", rs.getString(51));
        	 dbValues.put("appFormRegNum2", rs.getString(52));
        	 dbValues.put("appFormHSLCYop", rs.getString(53));
        	 dbValues.put("userUGPercent", rs.getString(54));
        	 dbValues.put("appFormMoSHSC", rs.getString(55));
        	 dbValues.put("appFormEntrncExm", rs.getString(56));







 	 
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
		System.out.println("Check---"+GenerateLeadForApplicationForm.emailAddress);
		establishDatabaseConnection();
		getLeadDataFromDatabase();
		tempMethodToPrintDBValues();
//		System.out.println(Arrays.asList(dbValues)); // method 1
//	    System.out.println(Collections.singletonList(dbValues)); // method 2
	}

}
