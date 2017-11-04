package whitefeather.xedge.testcases;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.core.DataGenerator;
import whitefeather.xedge.core.Page_DetailedApplicationForm;
import whitefeather.xedge.facilitator.HelperHand;

public class FillUpApplicationForm  extends HelperHand
{	
	public static String providedDOB, providedBlGroup, providedGenderValue,providedCitizenship, providedNationality, 
	providedUID, providedPlaceOfBirth, providedPassportN, providedPlOfIssue, providedDateOfIssue, providedExpiryDate,
	providedReligion, providedCaste, providedDomicile,providedCommunnity, providedPresentAddressStep1, providedPresentAddrCountry,
	providedPresentAddrState,providedPresentAddrCity, providedPresentAddrPincode, providedPresentAddrContactNumber,
	providedFathersNm, proviedFatherQualfcn, providedFathersOccpn, providedFathersIncome, providedFathersEmail,
	providedFathersMobile, providedMothersNm, proviedMotherQualfcn, providedMothersOccpn, providedMothersEmail,
	providedMothersMobile, providedLocalGuardianNm, providedAddress1Step2, providedAddress2Step2, providedAddress3Step2,
	providedLGCountry, providedLGState, providedLGCity, providedLGPincode, providedLGRelation, providedLGContactNumber,
	providedLGEmail;
	/********************* STEP 1 *************************/
	@Test
	public static void openDetailedApplicationFormPage() throws SQLException, InterruptedException
	{
		System.out.println("\n"+"*********************** Filling up Step 1 Information ***************************"+"\n");
		String leadPrn = extractDataFromDatabase("userPRN");
		System.out.println(leadPrn);
		System.out.println(Constants.APPLICATIONFORM+"?ref_no="+leadPrn);
		try 
		{
			driver.get(Constants.APPLICATIONFORM+"?ref_no="+leadPrn);
			Thread.sleep(500);
			Assert.assertEquals(Constants.APPLICATIONFORM+"?ref_no="+leadPrn, driver.getCurrentUrl());
			System.out.println("Assertion Successful");
			Reporter.log("User has opened Application Form successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to open Application Form.",true);
		}
	}
	
	@Test
	public static void clickDateOfBirthInputField() throws Exception
	{
		try 
		{
			driver.navigate().refresh();
			Assert.assertTrue(Page_DetailedApplicationForm.displayDateOfBirthInputField().isDisplayed());
			Page_DetailedApplicationForm.displayDateOfBirthInputField().click();
			Reporter.log("User has opened calender successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to open Caledar.",true);
		}
	}
	
	@Test
	public static void provideDateOfBirth() throws Exception
	{
		try 
		{		
			Page_DetailedApplicationForm.displayDOBMonthDropDown().selectByIndex(DataGenerator.getRandomMonth());
			String DOB_month = Page_DetailedApplicationForm.getBirthMonthFromProvidedDOB(Page_DetailedApplicationForm.displayDOBMonthDropDown().getFirstSelectedOption().getText());
			Page_DetailedApplicationForm.displayDOBYearDropDown().selectByIndex(DataGenerator.getRandomYear());
			String DOB_year = Page_DetailedApplicationForm.displayDOBYearDropDown().getFirstSelectedOption().getText();
			Page_DetailedApplicationForm.displayDaysOfMonthInDoB().click();
			String DOB_day = Page_DetailedApplicationForm.displayDaysOfMonthInDoB().getText();
			
			
			if(Integer.parseInt(DOB_month)<10)
			{
				DOB_month = String.format("%02d", Integer.parseInt(DOB_month));
			}
			if(Integer.parseInt(DOB_day)<10)
			{
				DOB_day = String.format("%02d", Integer.parseInt(DOB_day));
			}
			
			providedDOB = DOB_year+"-"+DOB_month+"-"+DOB_day;
				
			System.out.println("providedDOB: "+providedDOB);
			
			Reporter.log("User has provided Date of Birth successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to enter Date of Birth.",true);
		}
	}
	
	@Test
	@Parameters({"placeOfBirth"})	
	public static void providePlaceOfBirth(String placeOfBirth) throws Exception
	{
		providedPlaceOfBirth = placeOfBirth;
		try 
		{
			Page_DetailedApplicationForm.displayPlaceOfBirthInputField().sendKeys(providedPlaceOfBirth);
			Reporter.log("User has entered PlaceOfBirth value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide PlaceOfBirth value.",true);
		}
	}
	
	@Test
	public static void provideGender() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayGenderDropDown().selectByIndex(1);
			providedGenderValue = String.valueOf(Page_DetailedApplicationForm.displayGenderDropDown().getFirstSelectedOption().getText().charAt(0));
			Reporter.log("User has entered Gender value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Gender value.",true);
		}
	}
	
	@Test
	@Parameters({"bloodGroup"})	
	public static void provideBloodGroup(String bloodGroup) throws Exception
	{
		providedBlGroup = bloodGroup;
		try 
		{
			Page_DetailedApplicationForm.displayBloodGroupInputField().sendKeys(providedBlGroup);
			Reporter.log("User has entered blood group value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide blood group value.",true);
		}
	}
	

	@Test
	@Parameters({"nationality"})
	public static void provideNationality(String nationality) throws Exception
	{
		providedNationality = nationality;
		try 
		{
			Page_DetailedApplicationForm.displayNationalityInputField().sendKeys(providedNationality);
			Reporter.log("User has entered Nationality value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Nationality value.",true);
		}
	}
	
	@Test
	@Parameters({"uid"})	
	public static void provideAadharNumber(String uid) throws Exception
	{
		providedUID = uid;
		try 
		{
			Page_DetailedApplicationForm.displayAadhaarNumberInputField().sendKeys(providedUID);
			Reporter.log("User has entered Aadhaar Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Aadhaar Number value.",true);
		}
	}
	
	@Test
	@Parameters({"pNumber"})	
	public static void providePassportNumber(String pNumber) throws Exception
	{
		providedPassportN = pNumber;
		try 
		{
			Page_DetailedApplicationForm.displayPassportNumberInputField().sendKeys(providedPassportN);
			Reporter.log("User has entered Passport Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Passport Number value.",true);
		}
	}
	
	@Test
	@Parameters({"plOfIssue"})	
	public static void providePlaceOfIssue(String plOfIssue) throws Exception
	{
		providedPlOfIssue = plOfIssue;
		try 
		{
			Page_DetailedApplicationForm.displayPlaceOfIssueInputField().sendKeys(providedPlOfIssue);
			Reporter.log("User has entered Place Of Issue value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Place Of Issue value.",true);
		}
	}
	
	@Test
	public static void clickDateOfIssueInputField() throws Exception
	{
		try 
		{
			Assert.assertTrue(Page_DetailedApplicationForm.displayDateOfIssueInputField().isDisplayed());
			Page_DetailedApplicationForm.displayDateOfIssueInputField().click();
			Reporter.log("User has opened date of issue calender successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to open date of issue Caledar.",true);
		}
	}
	
	@Test
	public static void provideDateOfIssue() throws Exception
	{
		try 
		{		
			Page_DetailedApplicationForm.displayDateOfIssueMonthDropDown().selectByIndex(DataGenerator.getRandomMonth());
			String DateOfIssue_month = Page_DetailedApplicationForm.getMonthFromProvidedDateOfIssue(Page_DetailedApplicationForm.displayDateOfIssueMonthDropDown().getFirstSelectedOption().getText());
			Page_DetailedApplicationForm.displayDOBYearDropDown().selectByIndex(DataGenerator.getRandomYear()+10);
			String DateOfIssue_year = Page_DetailedApplicationForm.displayDateOfIssueYearDropDown().getFirstSelectedOption().getText();
			Page_DetailedApplicationForm.displayDaysOfMonthInDateOfIssue().click();
			String DateOfIssue_day = Page_DetailedApplicationForm.displayDaysOfMonthInDateOfIssue().getText();
			
			if(Integer.parseInt(DateOfIssue_month)<10)
			{
				DateOfIssue_month = String.format("%02d", Integer.parseInt(DateOfIssue_month));
			}
			if(Integer.parseInt(DateOfIssue_day)<10)
			{
				DateOfIssue_day = String.format("%02d", Integer.parseInt(DateOfIssue_day));
			}
			
			providedDateOfIssue = DateOfIssue_year+"-"+DateOfIssue_month+"-"+DateOfIssue_day;
			
			System.out.println("providedDateOfIssue: "+providedDateOfIssue);
			
			Reporter.log("User has provided Date of Issue successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to enter Date of Issue.",true);
		}
	}
	
	@Test
	public static void clickExpiryDateInputField() throws Exception
	{
		try 
		{
			Assert.assertTrue(Page_DetailedApplicationForm.displayExpiryDateInputField().isDisplayed());
			Page_DetailedApplicationForm.displayExpiryDateInputField().click();
			Reporter.log("User has opened Expiry Date calender successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to open Expiry Date Caledar.",true);
		}
	}
	
	@Test
	public static void provideExpiryDate() throws Exception
	{
		try 
		{		
			Page_DetailedApplicationForm.displayExpiryDateMonthDropDown().selectByIndex(DataGenerator.getRandomMonth());
			String ExpiryDate_month = Page_DetailedApplicationForm.getMonthFromProvidedExpiryDate(Page_DetailedApplicationForm.displayExpiryDateMonthDropDown().getFirstSelectedOption().getText());
			Page_DetailedApplicationForm.displayExpiryDateYearDropDown().selectByIndex(DataGenerator.getRandomYear()+20);
			String ExpiryDate_year = Page_DetailedApplicationForm.displayExpiryDateYearDropDown().getFirstSelectedOption().getText();
			Page_DetailedApplicationForm.displayDaysOfMonthInExpiryDate().click();
			String ExpiryDate_day = Page_DetailedApplicationForm.displayDaysOfMonthInExpiryDate().getText();
			
			if(Integer.parseInt(ExpiryDate_month)<10)
			{
				ExpiryDate_month = String.format("%02d", Integer.parseInt(ExpiryDate_month));
			}
			if(Integer.parseInt(ExpiryDate_day)<10)
			{
				ExpiryDate_day = String.format("%02d", Integer.parseInt(ExpiryDate_day));
			}
			
			providedExpiryDate = ExpiryDate_year+"-"+ExpiryDate_month+"-"+ExpiryDate_day;
			
			System.out.println("providedExpiryDate: "+providedExpiryDate);
			
			Reporter.log("User has provided Expiry Date successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to enter Expiry Date.",true);
		}
	}
	

	@Test
	@Parameters({"religion"})	
	public static void provideReligion(String religion) throws Exception
	{
		providedReligion = religion;
		try 
		{
			Page_DetailedApplicationForm.displayReligionDropDown().sendKeys(providedReligion);
			Reporter.log("User has entered Religion value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Religion value.",true);
		}
	}
	
	@Test
	@Parameters({"citizen"})	
	public static void provideCitizenship(String citizen) throws Exception
	{
		providedCitizenship = citizen;
		try 
		{
			Page_DetailedApplicationForm.displayCitizenshipInputField().sendKeys(providedCitizenship);
			Reporter.log("User has entered Citizenship value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Citizenship value.",true);
		}
	}
	
	@Test
	public static void provideCaste() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayCasteDropDown().selectByIndex(1);
			providedCaste = Page_DetailedApplicationForm.displayCasteDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered Caste value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Caste value.",true);
		}
	}
	
	@Test
	public static void provideDomicile() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayDomicileDropDown().selectByIndex(1);
			providedDomicile = Page_DetailedApplicationForm.displayDomicileDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered Domicile value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Domicile value.",true);
		}
	}
	
	@Test
	public static void provideCommunity() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayCommunityDropDown().selectByIndex(1);
			providedCommunnity = Page_DetailedApplicationForm.displayCommunityDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered Community value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Community value.",true);
		}
	}
	
	
	@Test
	@Parameters({"presentAddress"})	
	public static void providePresentAddress(String presentAddress) throws Exception
	{
		providedPresentAddressStep1 = presentAddress;
		try 
		{
			Page_DetailedApplicationForm.displayPresentAddressInputFieldStep1().sendKeys(providedPresentAddressStep1);
			Reporter.log("User has entered Present Address value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Present Address value.",true);
		}
	}
	
	
	@Test
	public static void providePresentAddrCountry() throws Exception
	{
		try 
		{
			//Do later random selection logic once correct data is added to db
			Page_DetailedApplicationForm.displayPresentAddrCountryDropDown().selectByIndex(3);
			providedPresentAddrCountry =  Page_DetailedApplicationForm.displayPresentAddrCountryDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered Country value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Country value.",true);
		}
	}
	
	@Test
	public static void providePresentAddrState() throws Exception
	{
		try 
		{
			//Do later random selection logic once correct data is added to db
			Page_DetailedApplicationForm.displayPresentAddrStateDropDown().selectByIndex(2);
			providedPresentAddrState =  Page_DetailedApplicationForm.displayPresentAddrStateDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered State value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to State Gender value.",true);
		}
	}
	
	@Test
	public static void providePresentAddrCity() throws Exception
	{
		try 
		{
			//Do later random selection logic once correct data is added to db
			Page_DetailedApplicationForm.displayPresentAddrCityDropDown().selectByIndex(1);
			providedPresentAddrCity =  Page_DetailedApplicationForm.displayPresentAddrCityDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered City value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide City value.",true);
		}
	}
	
	@Test
	@Parameters({"pincode"})	
	public static void providePresentAddrPincode(String pincode) throws Exception
	{
		providedPresentAddrPincode = pincode;
		try 
		{
			Page_DetailedApplicationForm.displayPresentAddrPincodeInputField().sendKeys(providedPresentAddrPincode);
			Reporter.log("User has successfully entered Pincode value in Present Address section.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Pincode value in Present Address section.",true);
		}
	}
	
	@Test
	public static void providePresentAddrContactNumber() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayPresentAddrContactNumberInputField().sendKeys(step1PresentAddrContactNumber);
			providedPresentAddrContactNumber = Page_DetailedApplicationForm.displayPresentAddrContactNumberInputField().getText();
			Reporter.log("User has entered Emergency Contact Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Emergency Contact Number value.",true);
		}
	}
	
	@Test
	public static void clickSameAddressCheckbox() throws Exception
	{
		//Implement logic for permanent address later. As of now just validate check box
		try 
		{
			Assert.assertTrue(Page_DetailedApplicationForm.displaySameAddressCheckboxStep1().isDisplayed());
			Page_DetailedApplicationForm.displaySameAddressCheckboxStep1().click();
			Reporter.log("User has clicked Same Address checkbox successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to click Same Address Checkbox.",true);
		}
	}
	
	/*
	@Test
	public static void provideAlternateAddress1() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAlternateAddress1InputField().sendKeys("Alternate Address 1 - Step 1");
			Reporter.log("User has entered Alternate Address 1 value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Alternate Address 1 value.",true);
		}
	}
	
	@Test
	public static void provideAlternateAddress2() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAlternateAddress2InputField().sendKeys("Alternate Address 2 - Step 1");
			Reporter.log("User has entered Alternate Address 2 value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Alternate Address 2 value.",true);
		}
	}
	
	@Test
	public static void provideAlternateContactNumber() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAlternateContactNumberInputField().sendKeys(thirdPartyAlternateContact);
			Reporter.log("User has entered Alternate Contact Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Alternate Contact Number value.",true);
		}
	}*/
	
	@Test
	public static void clickNextButtonStep1() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayNextButtonStep1().click();
			Thread.sleep(10000);
			Reporter.log("User has clicked Next button  on Step 1 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Next button on Step 1.",true);
		}
	}
	

	@Test
	public static void validateDoBStep1() throws InterruptedException, SQLException
	{
		System.out.println("\n"+"*********************** Validating information filled up in Step 1 ***************************"+"\n");

		try {
			System.out.println("--------------Validating Date of Birth--------------");
			System.out.println("Provided DoB: "+providedDOB);
			//Intentional Pause
			Thread.sleep(2000);
			String actualDOB = extractDataFromDatabase("userDOB");
			System.out.println("DoB value from DB: "+actualDOB);
			Assert.assertEquals(providedDOB, actualDOB.substring(0, 10));
			Reporter.log("Provided DOB matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided DOB doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validatePlaceOfBirthStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Place Of Birth--------------");
			System.out.println("Provided Place Of Birth: "+providedPlaceOfBirth);
			//Intentional Pause
			Thread.sleep(1000);
			String storedPlaceOfBirth = extractDataFromDatabase("userPlaceOfBirth");
			System.out.println("Place Of Birth value from DB: "+storedPlaceOfBirth);
			Assert.assertEquals(providedPlaceOfBirth, storedPlaceOfBirth);
			Reporter.log("Provided Place Of Birth matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Place Of Birth doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateGenderValueInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Gender Value--------------");
			System.out.println("Provided Gender: "+providedGenderValue);
			//Intentional Pause
			Thread.sleep(1000);
			String storedGender = extractDataFromDatabase("userGender");
			System.out.println("Gender value from DB: "+storedGender);
			Assert.assertEquals(providedGenderValue, storedGender); //Do later trimming in Gender Value. Assertion should fail as of now.
			Reporter.log("Provided Gender matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Gender doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateBloodGroupInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Blood Group--------------");
			System.out.println("Provided Blood Group: "+providedBlGroup);
			//Intentional Pause
			Thread.sleep(1000);
			String storedBLGrp = extractDataFromDatabase("userBloodGrp");
			System.out.println("Blood Group value from DB: "+storedBLGrp);
			Assert.assertEquals(providedBlGroup, storedBLGrp);
			Reporter.log("Provided Blood Group matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Blood Group doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateNationalityInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Nationality--------------");
			System.out.println("Provided Nationality: "+providedNationality);
			//Intentional Pause
			Thread.sleep(1000);
			String storedNation = extractDataFromDatabase("userNationality");
			System.out.println("Nationality from DB: "+storedNation);
			Assert.assertEquals(providedNationality, storedNation);
			Reporter.log("Provided Nationality matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Nationality doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateAadhaarNumberInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Aadhaar Number--------------");
			System.out.println("Provided Aadhaar Number: "+providedUID);
			//Intentional Pause
			Thread.sleep(1000);
			String storedUID = extractDataFromDatabase("appFormUID");
			System.out.println("Aadhaar Number from DB: "+storedUID);
			Assert.assertEquals(providedUID, storedUID);
			Reporter.log("Provided Aadhaar Number matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Aadhaar Number doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validatePassportNumberInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Passport Number--------------");
			System.out.println("Provided Passport Number: "+providedPassportN);
			//Intentional Pause
			Thread.sleep(1000);
			String storedPassportNumber = extractDataFromDatabase("appFormPassportNum");
			System.out.println("Passport Number from DB: "+storedPassportNumber);
			Assert.assertEquals(providedPassportN, storedPassportNumber);
			Reporter.log("Provided Passport Number matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Passport Number doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validatePlaceOfIssueInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Place Of Issue--------------");
			System.out.println("Provided Place Of Issue: "+providedPlOfIssue);
			//Intentional Pause
			Thread.sleep(1000);
			String storedPlaceOfIssue = extractDataFromDatabase("appFormPlaceOfIssue");
			System.out.println("Place Of Issue from DB: "+storedPlaceOfIssue);
			Assert.assertEquals(providedPlOfIssue, storedPlaceOfIssue);
			Reporter.log("Provided Place Of Issue matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Place Of Issue doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateDateOfIssueInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Date Of Issue--------------");
			System.out.println("Provided Date Of Issue: "+providedDateOfIssue);
			//Intentional Pause
			Thread.sleep(1000);
			String storedDateOfIssue = extractDataFromDatabase("appFormDateOfIssue");
			System.out.println("Date Of Issue from DB: "+storedDateOfIssue);
			Assert.assertEquals(providedDateOfIssue, storedDateOfIssue.substring(0, 10));
			Reporter.log("Provided Date Of Issue matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Date Of Issue doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateExpiryDateInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Expiry Date--------------");
			System.out.println("Provided Expiry Date: "+providedExpiryDate);
			//Intentional Pause
			Thread.sleep(1000);
			String storedExpiryDate = extractDataFromDatabase("appFormExpiryDate");
			System.out.println("Expiry Date from DB: "+storedExpiryDate);
			Assert.assertEquals(providedExpiryDate, storedExpiryDate.substring(0, 10));
			Reporter.log("Provided Expiry Date matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Expiry Date doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateReligionInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Religion--------------");
			System.out.println("Provided Religion: "+providedReligion);
			//Intentional Pause
			Thread.sleep(1000);
			String storedReligion = extractDataFromDatabase("appFormReligion");
			System.out.println("Religion from DB: "+storedReligion);
			Assert.assertEquals(providedReligion, storedReligion);
			Reporter.log("Provided Religion matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Religion doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateCitizenShipInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Citizenship--------------");
			System.out.println("Provided CitizenShip: "+providedCitizenship);
			//Intentional Pause
			Thread.sleep(1000);
			String storedCityZensp = extractDataFromDatabase("appFormCitizenship");
			System.out.println("CitizenShip from DB: "+storedCityZensp);
			Assert.assertEquals(providedCitizenship, storedCityZensp);
			Reporter.log("Provided CitizenShip matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided CitizenShip doesn't match the value stored in database.",true);
		}
	}
	

	@Test
	public static void validateCasteInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Caste--------------");
			System.out.println("Provided Caste: "+providedCaste);
			//Intentional Pause
			Thread.sleep(1000);
			String storedCaste = extractDataFromDatabase("appFormCaste");
			System.out.println("Caste from DB: "+storedCaste);
			Assert.assertEquals(providedCaste, storedCaste);
			Reporter.log("Provided Caste matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Caste doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateDomicileInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Domicile--------------");
			System.out.println("Provided Domicile: "+providedDomicile);
			//Intentional Pause
			Thread.sleep(1000);
			String storedDomicile = extractDataFromDatabase("appFormDomicile");
			System.out.println("Domicile from DB: "+storedDomicile);
			Assert.assertEquals(providedDomicile, storedDomicile);
			Reporter.log("Provided Domicile matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Domicile doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateCommunityInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Community--------------");
			System.out.println("Provided Community: "+providedCommunnity);
			//Intentional Pause
			Thread.sleep(1000);
			String storedCommunity = extractDataFromDatabase("appFormCommunity");
			System.out.println("Community from DB: "+storedCommunity);
			Assert.assertEquals(providedCommunnity, storedCommunity);
			Reporter.log("Provided Community matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Community doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validatePresentAddressInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Present Address--------------");
			System.out.println("Provided Present Address: "+providedPresentAddressStep1);
			//Intentional Pause
			Thread.sleep(1000);
			String storedPresentAddress = extractDataFromDatabase("userPresentAddress");
			System.out.println("Present Address from DB: "+storedPresentAddress);
			Assert.assertEquals(providedPresentAddressStep1, storedPresentAddress);
			Reporter.log("Provided Present Address matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Present Address doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validatePresentAddressCountryInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Present Address Country--------------");
			System.out.println("Provided Present Address Country: "+providedPresentAddrCountry);
			//Intentional Pause
			Thread.sleep(1000);
			String storedPresentAddrCountry = extractDataFromDatabase("userPresentAddrCountry");
			System.out.println("Country from DB: "+storedPresentAddrCountry);
			Assert.assertEquals(providedPresentAddrCountry, storedPresentAddrCountry);
			Reporter.log("Provided Present Address Country matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Present Address Country doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validatePresentAddressStateInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Present Address State--------------");
			System.out.println("Provided Present Address State: "+providedPresentAddrState);
			//Intentional Pause
			Thread.sleep(1000);
			String storedPresentAddrState = extractDataFromDatabase("userPresentAddrState");
			System.out.println("State from DB: "+storedPresentAddrState);
			Assert.assertEquals(providedPresentAddrState, storedPresentAddrState);
			Reporter.log("Provided Present Address State matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Present Address State doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validatePresentAddressCityInStep1() throws InterruptedException, SQLException
	{	
		try {
			System.out.println("--------------Validating Present Address City--------------");
			System.out.println("Provided Present Address City: "+providedPresentAddrCity);
			//Intentional Pause
			Thread.sleep(1000);
			String storedPresentAddrCity = extractDataFromDatabase("userPresentAddrCity");
			System.out.println("City from DB: "+storedPresentAddrCity);
			Assert.assertEquals(providedPresentAddrCity, storedPresentAddrCity);
			Reporter.log("Provided Present Address City matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Present Address City doesn't match the value stored in database.",true);
		}
	}
	
	/********************* STEP 2 *************************/
	
	
	@Test
	@Parameters({"fathersName"})
	public static void provideFathersName(String fathersName) throws Exception
	{
		Thread.sleep(1000);
		System.out.println("\n"+"*********************** Filling up Step 2 Information ***************************"+"\n");

		try 
		{
			providedFathersNm = fathersName;
			Page_DetailedApplicationForm.displayFathersNameInputField().sendKeys(providedFathersNm);
			Reporter.log("User has entered Fathers Name value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Fathers Name value.",true);
		}
	}
	
	@Test
	@Parameters({"fathersQual"})
	public static void provideFathersQualification(String fathersQual) throws Exception
	{
		try 
		{
			proviedFatherQualfcn = fathersQual;
			Page_DetailedApplicationForm.displayFathersQualificationInputField().sendKeys(proviedFatherQualfcn);
			Reporter.log("User has entered Fathers Qualification value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Fathers Qualification value.",true);
		}
	}
	
	@Test
	@Parameters({"fathersOccpn"})
	public static void provideFathersOccupation(String fathersOccpn) throws Exception
	{
		try 
		{
			providedFathersOccpn = fathersOccpn;
			Page_DetailedApplicationForm.displayFathersOccupationInputField().sendKeys(providedFathersOccpn);
			Reporter.log("User has entered Fathers Occupation value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Fathers Occupation value.",true);
		}
	}
	
	@Test
	public static void provideMothersName() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayMothersNameInputField().sendKeys("Mothers Name Input Field");
			Reporter.log("User has entered Mothers Name value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Mothers Name value.",true);
		}
	}
	
	@Test
	public static void provideGuardiansName() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayGuardiansNameInputField().sendKeys("Guardians Name Input Field");
			Reporter.log("User has entered Guardians Name value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Guardians Name value.",true);
		}
	}
	
	@Test
	public static void provideGuardiansAddress1() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayGuardiansAddress1InputField().sendKeys("Guardians Address 1 - Step 2");
			Reporter.log("User has entered Guardians Address 1 value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Guardians Address 1 value.",true);
		}
	}
	
	@Test
	public static void provideGuardiansAddress2() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayGuardiansAddress2InputField().sendKeys("Guardians Address 2 - Step 2");
			Reporter.log("User has entered Guardians Address 2 value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Guardians Address 2 value.",true);
		}
	}
	
	@Test
	public static void provideGuardiansContactNumber() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayGuardiansContactNumberInputField().sendKeys(thirdPartyGuardiansContact);
			Reporter.log("User has entered Guardians Contact Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Guardians Contact Number value.",true);
		}
	}
	
	@Test
	public static void provideGuardiansRelation() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayGuardianRelationInputField().sendKeys("Foster Parent");
			Reporter.log("User has entered Guardians Relation value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Guardians Relation value.",true);
		}
	}
	
	@Test
	public static void clickNextButtonStep2() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayNextButtonStep2().click();
			Reporter.log("User has clicked Next button on Step 2successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Next button on Step 2.",true);
		}
	}

	
	@Test
	public static void validateFathersNameStep2() throws InterruptedException, SQLException
	{
		System.out.println("\n"+"*********************** Validating information filled up in Step 2 ***************************"+"\n");

		try {
			System.out.println("--------------Validating Fathers Name--------------");
			System.out.println("Provided Fathers Name: "+providedFathersNm);
			//Intentional Pause
			Thread.sleep(2000);
			String storedFatherNM = extractDataFromDatabase("userFathersName");
			System.out.println("Fathers Name value from DB: "+storedFatherNM);
			Assert.assertEquals(providedFathersNm, storedFatherNM);
			Reporter.log("Provided Fathers Name matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Fathers Name doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateFathersQualificationStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Fathers Qualification--------------");
			System.out.println("Provided Fathers Qualification: "+proviedFatherQualfcn);
			//Intentional Pause
			Thread.sleep(2000);
			String storedFatherQualfcn = extractDataFromDatabase("appFormFatherQualfcn");
			System.out.println("Fathers Qualification value from DB: "+storedFatherQualfcn);
			Assert.assertEquals(proviedFatherQualfcn, storedFatherQualfcn);
			Reporter.log("Provided Fathers Qualification matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Fathers Qualification doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateFathersOccupationStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Fathers Occupation--------------");
			System.out.println("Provided Fathers Occupation: "+providedFathersOccpn);
			//Intentional Pause
			Thread.sleep(2000);
			String storedFatherOccpn = extractDataFromDatabase("appFormFatherOccpn");
			System.out.println("Fathers Occupation value from DB: "+storedFatherOccpn);
			Assert.assertEquals(providedFathersOccpn, storedFatherOccpn);
			Reporter.log("Provided Fathers Occupation matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Fathers Occupation doesn't match the value stored in database.",true);
		}
	}
	
	
	
	/********************* STEP 3 *************************/
	
	@Test
	public static void provideCourse() throws Exception
	{
		System.out.println("\n"+"*********************** Filling up Step 3 Information ***************************"+"\n");
		try 
		{
			Page_DetailedApplicationForm.displaySelectCourseDropDown().selectByIndex(1);
			Reporter.log("User has entered Course value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Course value.",true);
		}
	}
	
	@Test
	public static void provideSSCSchoolName() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySSCSchoolNameInputField().sendKeys("SSC School Name Text");
			Reporter.log("User has entered SSC School Name value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide SSC School Name value.",true);
		}
	}
	
	@Test
	public static void provideSSCRegNumber() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySSCRegNumberInputField().sendKeys("007420");
			Reporter.log("User has entered SSC Registration Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide SSC Registration Number value.",true);
		}
	}
	
	@Test
	public static void provideSSCYearOfPassing() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySSCYearOfPassingDropDown().selectByIndex(1);
			Reporter.log("User has entered Year of Passing successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Year of Passing value.",true);
		}
	}
	
	@Test
	public static void provideSSCPercentageValue() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySSCPercentageInputField().sendKeys("86.85");
			Reporter.log("User has entered SSC Registration Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide SSC Registration Number value.",true);
		}
	}
	
	@Test
	public static void provideSSCModeOfStudy() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySSCModeOfStudyDropDown().selectByIndex(1);
			Reporter.log("User has entered SSC Mode of Study value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide SSC Mode of Study value.",true);
		}
	}
	
	@Test
	public static void provideHSCSchoolName() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayHSCSchoolNameInputField().sendKeys("HSC School Name Text");
			Reporter.log("User has entered HSC School Name value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide HSC School Name value.",true);
		}
	}
	
	@Test
	public static void provideHSCRegNumber() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayHSCRegNumberInputField().sendKeys("420007");
			Reporter.log("User has entered HSC Registration Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide HSC Registration Number value.",true);
		}
	}
	
	@Test
	public static void provideHSCYearOfPassing() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayHSCYearOfPassingDropDown().selectByIndex(1);
			Reporter.log("User has entered HSC Year of Passing successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide HSC Year of Passing value.",true);
		}
	}
	
	@Test
	public static void provideHSCPercentageValue() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayHSCPercentageInputField().sendKeys("96.85");
			Reporter.log("User has entered HSC Registration Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide HSC Registration Number value.",true);
		}
	}
	
	@Test
	public static void provideHSCModeOfStudy() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayHSCModeOfStudyDropDown().selectByIndex(1);
			Reporter.log("User has entered HSC Mode of Study value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide HSC Mode of Study value.",true);
		}
	}
	
	@Test
	public static void provideEntranceExamValue() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayEntranceExamInputField().sendKeys("Join ExtraaEdge");
			Reporter.log("User has entered Entrance Exam value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Entrance Exam value.",true);
		}
	}
	
	@Test
	public static void provideSubject1NameValue() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySubject1InputField().sendKeys("Subject 1 Name");
			Reporter.log("User has entered Subject 1 Name value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Subject 1 Name value.",true);
		}
	}
	
	@Test
	public static void provideSubject1Marks1Value() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayMarks1InputField().sendKeys("77");
			Reporter.log("User has entered Subject1 Marks1 value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Subject1 Marks1 value.",true);
		}
	}
	
	@Test
	public static void provideSubject1Percetage1Value() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayPercentage1InputField().sendKeys("88.23");
			Reporter.log("User has entered Subject1 Percetage1 Value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Subject1 Percetage1 Value.",true);
		}
	}
	
	@Test
	public static void provideSubject2NameValue() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySubject2InputField().sendKeys("Subject 2 Name");
			Reporter.log("User has entered Subject2 Name value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Subject2 Name value.",true);
		}
	}
	
	@Test
	public static void provideSubject2Marks1Value() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayMarks2InputField().sendKeys("97");
			Reporter.log("User has entered Subject2 Marks2 value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Subject2 Marks2 value.",true);
		}
	}
	
	@Test
	public static void provideSubject2Percetage2Value() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayPercentage2InputField().sendKeys("78.23");
			Reporter.log("User has entered Subject2 Percetage2 Value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Subject2 Percetage2 Value.",true);
		}
	}
	
	@Test
	public static void provideSubject3NameValue() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySubject3InputField().sendKeys("Subject 3 Name");
			Reporter.log("User has entered Subject3 Name value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Subject3 Name value.",true);
		}
	}
	
	@Test
	public static void provideSubject3Marks3Value() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayMarks3InputField().sendKeys("77.27");
			Reporter.log("User has entered Subject3 Marks3 value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Subject2 Marks2 value.",true);
		}
	}
	
	@Test
	public static void provideSubject3Percetage3Value() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayPercentage3InputField().sendKeys("68.23");
			Reporter.log("User has entered Subject3 Percetage3 Value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Subject3 Percetage3 Value.",true);
		}
	}
	
	@Test
	public static void attachAttachment1() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment1Button().sendKeys(Constants.APPFORM_ATTACHMENT1);
			Reporter.log("User has attached Certificate1 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Certificate1.",true);
		}
	}
	
	@Test
	public static void attachAttachment2() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment2Button().sendKeys(Constants.APPFORM_ATTACHMENT2);
			Reporter.log("User has attached Certificate2 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Certificate2.",true);
		}
	}
	
	@Test
	public static void attachAttachment3() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment3Button().sendKeys(Constants.APPFORM_ATTACHMENT3);
			Reporter.log("User has attached Certificate3 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Certificate3.",true);
		}
	}
	
	@Test
	public static void attachAttachment4() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment4Button().sendKeys(Constants.APPFORM_ATTACHMENT4);
			Reporter.log("User has attached Certificate4 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Certificate4.",true);
		}
	}
	
	@Test
	public static void attachAttachment5() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment5Button().sendKeys(Constants.APPFORM_ATTACHMENT5);
			Reporter.log("User has attached Certificate5 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Certificate5.",true);
		}
	}
	
	@Test
	public static void clickNextButtonStep3() throws Exception
	{
		try 
		{
			Thread.sleep(5000);
			Page_DetailedApplicationForm.displayNextButtonStep3().click();
			Reporter.log("User has clicked Next button on Step 3 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Next button on Step 3.",true);
		}
	}
	
		/********************* STEP 4 *************************/
	
	@Test
	public static void providePaymentType() throws Exception
	{
		System.out.println("\n"+"*********************** Filling up Step 4 Information ***************************"+"\n");
		try 
		{
			Page_DetailedApplicationForm.displayPaymentTypeDropdownDropDown().selectByIndex(1);
			Reporter.log("User has entered Payment Type value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Payment Type value.",true);
		}
	}
	
	@Test
	public static void providePaymentAmount() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayPaymentAmountField().sendKeys("100");
			Reporter.log("User has entered Payment Amount value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Payment Amount value.",true);
		}
	}
	
	@Test
	public static void clickSubmitButtonStep4() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySubmitButtonStep4().click();
			Reporter.log("User has clicked Submit button on Step 3 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Submit button.",true);
		}
	}
}
