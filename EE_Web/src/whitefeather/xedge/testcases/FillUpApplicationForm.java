package whitefeather.xedge.testcases;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
	providedReligion, providedCaste, providedDomicile,providedCommunnity, providedPresentAddressStep1,
	providedPresentAddrCountry,	providedPresentAddrState,providedPresentAddrCity, 
	providedPresentAddrPincode, providedPresentAddrContactNumber, providedPermanentAddressStep1, providedPermanentAddrCountry, 
	providedPermanentAddrState, providedPermanentAddrCity, providedPermanentAddrPincode,providedPermanentAddrContactNumber
	,providedFathersNm, proviedFatherQualfcn,providedFathersOccpn, providedFathersIncome, providedFathersEmail,
	providedFathersMobile, providedMothersNm, proviedMotherQualfcn, providedMothersOccpn, providedMothersEmail,
	providedMothersMobile, providedLGuardianNm, providedAddress1Step2, providedAddress2Step2, providedAddress3Step2,
	providedLGCountry, providedLGState, providedLGCity, providedLGPincode, providedLGRelation, providedLGContactNumber,
	providedCourseStep3, providedSSCSchoolName, providedSSCBoard, providedSSCYoP, providedSSCRegNumber, providedSSCModeOfStudy,
	providedSSCGrade, providedHSCSchoolName, providedHSCBoard, providedHSCYoP, providedHSCRegNumber, providedHSCModeOfStudy,
	providedHSCPerGrade,providedDegDiplomaName, providedDiplomaAOS, providedDiplomaCollegeName, providedUniversityNm, 
	providedDiplomaExamType, providedDiplomaYoC, providedDiplomaModeOfStudy,providedCourseStep4;
	
	
	/********************* STEP 1 *************************/
	@Test
	public static void openDetailedApplicationFormPage() throws SQLException, InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("\n"+"*********************** Filling up Step 1 Information ***************************"+"\n");
		String leadPrn = extractDataFromDatabase("userPRN");
		String leadEmail = extractDataFromDatabase("userEmail");
		System.out.println(leadPrn);
		
		try 
		{
			String detailedFormURL = OpenApplicationFormLandingPage.appFormURL+"&ref_no="+leadPrn+"&email="+leadEmail;
			driver.get(detailedFormURL);
			Thread.sleep(500);
			Assert.assertEquals(detailedFormURL, driver.getCurrentUrl());
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
			Page_DetailedApplicationForm.displayPlaceOfBirthInputField().clear();
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
			Page_DetailedApplicationForm.displayBloodGroupInputField().clear();
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
			Page_DetailedApplicationForm.displayNationalityInputField().clear();
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
			Page_DetailedApplicationForm.displayAadhaarNumberInputField().clear();
			Page_DetailedApplicationForm.displayAadhaarNumberInputField().sendKeys(providedUID);
			Reporter.log("User has entered Aadhaar Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Aadhaar Number value.",true);
			throw(e);
		}
		
	}
	
	@Test
	@Parameters({"pNumber"})	
	public static void providePassportNumber(String pNumber) throws Exception
	{
		providedPassportN = pNumber;
		try 
		{
			Page_DetailedApplicationForm.displayPassportNumberInputField().clear();
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
			Page_DetailedApplicationForm.displayPlaceOfIssueInputField().clear();
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
			//Do separate logic for Expiry date later
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
			Page_DetailedApplicationForm.displayReligionInputField().clear();
			Page_DetailedApplicationForm.displayReligionInputField().sendKeys(providedReligion);
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
			Page_DetailedApplicationForm.displayCitizenshipInputField().clear();
			Page_DetailedApplicationForm.displayCitizenshipInputField().sendKeys(providedCitizenship);
			Reporter.log("User has entered Citizenship value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Citizenship value.",true);
		}
	}
	
	@Test
	@Parameters({"otherCasteValue"})
	public static void provideCaste(String otherCasteValue) throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayCasteDropDown().selectByIndex(1);
			providedCaste = Page_DetailedApplicationForm.displayCasteDropDown().getFirstSelectedOption().getText();
			if(providedCaste.equalsIgnoreCase("Other"))
			{
				Page_DetailedApplicationForm.displayOtherCasteInputField().sendKeys(otherCasteValue);
				providedCaste = otherCasteValue;
			}
			
			Reporter.log("User has entered Caste value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Caste value.",true);
		}
	}
	
	@Test
	@Parameters({"otherDomicileValue"})
	public static void provideDomicile(String otherDomicileValue) throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayDomicileDropDown().selectByIndex(1);
			providedDomicile = Page_DetailedApplicationForm.displayDomicileDropDown().getFirstSelectedOption().getText();
			if(providedDomicile.equalsIgnoreCase("Other"))
			{
				Page_DetailedApplicationForm.displayOtherDomicileInputField().sendKeys(otherDomicileValue);
				providedDomicile = otherDomicileValue;
			}
			Reporter.log("User has entered Domicile value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Domicile value.",true);
		}
	}
	
	@Test
	@Parameters({"otherCommunityValue"})
	public static void provideCommunity(String otherCommunityValue) throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayCommunityDropDown().selectByIndex(1);
			providedCommunnity = Page_DetailedApplicationForm.displayCommunityDropDown().getFirstSelectedOption().getText();
			if(providedCommunnity.equalsIgnoreCase("Other"))
			{
				Page_DetailedApplicationForm.displayOtherCommunityInputField().sendKeys(otherCommunityValue);
				providedCommunnity = otherCommunityValue;
			}
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
			Page_DetailedApplicationForm.displayPresentAddressInputFieldStep1().clear();
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
			Page_DetailedApplicationForm.displayPresentAddrCountryDropDown().selectByIndex(1);
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
			Page_DetailedApplicationForm.displayPresentAddrStateDropDown().selectByIndex(1);
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
			Page_DetailedApplicationForm.displayPresentAddrPincodeInputField().clear();
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
			Page_DetailedApplicationForm.displayPresentAddrContactNumberInputField().clear();
			Page_DetailedApplicationForm.displayPresentAddrContactNumberInputField().sendKeys(getAppFormData().get("personMobileNumber"));
			providedPresentAddrContactNumber = Page_DetailedApplicationForm.displayPresentAddrContactNumberInputField().getAttribute("value");
			Reporter.log("User has entered Emergency Contact Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Emergency Contact Number value.",true);
		}
	}
	
	@Test
	public static void clickSameAddressCheckbox() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySameAddressCheckboxStep().click();;
			Reporter.log("User has clicked Same Address checkbox successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to click Same Address Checkbox.",true);
		}
	}
	
	@Test
	@Parameters({"permanentAddress"})	
	public static void providePermanentAddressAddress(String permanentAddress) throws Exception
	{
		providedPermanentAddressStep1 = permanentAddress;
		try 
		{
			Page_DetailedApplicationForm.displayPermanentAddressInputFieldStep1().clear();
			Page_DetailedApplicationForm.displayPermanentAddressInputFieldStep1().sendKeys(providedPermanentAddressStep1);
			Reporter.log("User has entered Permanent Address value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Permanent Address value.",true);
		}
	}
	
	@Test
	public static void providePermanentAddrCountry() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayPermanentAddrCountryDropDown().selectByIndex(1);
			providedPermanentAddrCountry =  Page_DetailedApplicationForm.displayPermanentAddrCountryDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered Country value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Country value.",true);
		}
	}
	
	@Test
	public static void providePermanentAddrState() throws Exception
	{
		try 
		{
			//Do later random selection logic once correct data is added to db
			Page_DetailedApplicationForm.displayPermanentAddrStateDropDown().selectByIndex(2);
			providedPermanentAddrState =  Page_DetailedApplicationForm.displayPermanentAddrStateDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered State value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to State Gender value.",true);
		}
	}
	
	@Test
	public static void providePermanentAddrCity() throws Exception
	{
		try 
		{
			//Do later random selection logic once correct data is added to db
			Page_DetailedApplicationForm.displayPermanentAddrCityDropDown().selectByIndex(1);
			providedPermanentAddrCity =  Page_DetailedApplicationForm.displayPermanentAddrCityDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered City value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide City value.",true);
		}
	}
	
	@Test
	@Parameters({"Perm_pincode"})	
	public static void providePermanentAddrPincode(String Perm_pincode) throws Exception
	{
		providedPermanentAddrPincode = Perm_pincode;
		try 
		{
			Page_DetailedApplicationForm.displayPermanentAddrPincodeInputField().clear();
			Page_DetailedApplicationForm.displayPermanentAddrPincodeInputField().sendKeys(providedPermanentAddrPincode);
			Reporter.log("User has successfully entered Pincode value in Permanent Address section.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Pincode value in Permanent Address section.",true);
		}
	}
	
	@Test
	public static void providePermanentAddrContactNumber() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayPermanentAddrContactNumberInputField().clear();
			Page_DetailedApplicationForm.displayPermanentAddrContactNumberInputField().sendKeys(getAppFormData().get("personMobileNumber"));
			providedPermanentAddrContactNumber = Page_DetailedApplicationForm.displayPermanentAddrContactNumberInputField().getAttribute("value");
			Reporter.log("User has entered Emergency Contact Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Emergency Contact Number value.",true);
		}
	}
	
	
	@Test
	public static void clickNextButtonStep1() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayNextButtonStep1().click();
			
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
			Thread.sleep(1000);
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
		Thread.sleep(4000);
		System.out.println("\n"+"*********************** Filling up Step 2 Information ***************************"+"\n");

		try 
		{
			providedFathersNm = fathersName+" in Step2";
			Page_DetailedApplicationForm.displayFathersNameInputField().clear();
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
			Page_DetailedApplicationForm.displayFathersQualificationInputField().clear();
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
			Page_DetailedApplicationForm.displayFathersOccupationInputField().clear();
			Page_DetailedApplicationForm.displayFathersOccupationInputField().sendKeys(providedFathersOccpn);
			Reporter.log("User has entered Fathers Occupation value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Fathers Occupation value.",true);
		}
	}
	
	@Test
	@Parameters({"annualIncome"})
	public static void provideAnnualIncome(String annualIncome) throws Exception
	{
		try 
		{
			providedFathersIncome = annualIncome;
			Page_DetailedApplicationForm.displayAnnualIncomeInputField().clear();
			Page_DetailedApplicationForm.displayAnnualIncomeInputField().sendKeys(providedFathersIncome);
			Reporter.log("User has entered Fathers Annual Income value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Fathers Annual Income value.",true);
		}
	}
	
	@Test
	public static void provideFathersEmail() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayFathersEmailInputField().clear();
			Page_DetailedApplicationForm.displayFathersEmailInputField().sendKeys(getAppFormData().get("personEmailAddress"));
			providedFathersEmail = Page_DetailedApplicationForm.displayFathersEmailInputField().getAttribute("value");
			Reporter.log("User has entered Fathers Email value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Fathers Email value.",true);
		}
	}
	
	@Test
	public static void provideFathersMobile() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayFathersMobileInputField().clear();
			Page_DetailedApplicationForm.displayFathersMobileInputField().sendKeys(getAppFormData().get("personMobileNumber"));
			providedFathersMobile = Page_DetailedApplicationForm.displayFathersMobileInputField().getAttribute("value");
			Reporter.log("User has entered Fathers Mobile value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Fathers Mobile value.",true);
		}
	}
	
	@Test
	@Parameters({"MothersName"})
	public static void provideMothersName(String MothersName) throws Exception
	{
		try 
		{
			providedMothersNm = MothersName+" in Step2";
			Page_DetailedApplicationForm.displayMothersNameInputField().clear();
			Page_DetailedApplicationForm.displayMothersNameInputField().sendKeys(providedMothersNm);
			Reporter.log("User has entered Mothers Name value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Mothers Name value.",true);
		}
	}
	
	@Test
	@Parameters({"MothersQual"})
	public static void provideMothersQualification(String MothersQual) throws Exception
	{
		try 
		{
			proviedMotherQualfcn = MothersQual;
			Page_DetailedApplicationForm.displayMothersQualificationInputField().clear();
			Page_DetailedApplicationForm.displayMothersQualificationInputField().sendKeys(proviedMotherQualfcn);
			Reporter.log("User has entered Mothers Qualification value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Mothers Qualification value.",true);
		}
	}
	
	@Test
	@Parameters({"MothersOccpn"})
	public static void provideMothersOccupation(String MothersOccpn) throws Exception
	{
		try 
		{
			providedMothersOccpn = MothersOccpn+" Dean";
			Page_DetailedApplicationForm.displayMothersOccupationInputField().clear();
			Page_DetailedApplicationForm.displayMothersOccupationInputField().sendKeys(providedMothersOccpn);
			Reporter.log("User has entered Mothers Occupation value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Mothers Occupation value.",true);
		}
	}
	
	@Test
	public static void provideMothersEmail() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayMothersEmailInputField().clear();
			Page_DetailedApplicationForm.displayMothersEmailInputField().sendKeys(getAppFormData().get("personEmailAddress"));
			providedMothersEmail = Page_DetailedApplicationForm.displayMothersEmailInputField().getAttribute("value");
			Reporter.log("User has entered Mothers Email value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Mothers Email value.",true);
		}
	}
	
	@Test
	public static void provideMothersMobile() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayMothersMobileInputField().clear();
			Page_DetailedApplicationForm.displayMothersMobileInputField().sendKeys(getAppFormData().get("personMobileNumber"));
			providedMothersMobile = Page_DetailedApplicationForm.displayMothersMobileInputField().getAttribute("value");
			Reporter.log("User has entered Mothers Mobile value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Mothers Mobile value.",true);
		}
	}
	
	@Test
	@Parameters({"LocalGuardianName"})
	public static void provideGuardiansName(String LocalGuardianName) throws Exception
	{
		try 
		{
			providedLGuardianNm = LocalGuardianName+" in Step2";
			Page_DetailedApplicationForm.displayGuardiansNameInputField().clear();
			Page_DetailedApplicationForm.displayGuardiansNameInputField().sendKeys(providedLGuardianNm);
			Reporter.log("User has entered Guardians Name value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Guardians Name value.",true);
		}
	}
	
	@Test
	@Parameters({"address1"})
	public static void provideGuardiansAddress1(String address1) throws Exception
	{
		try 
		{
			providedAddress1Step2 = address1+" in Step2";
			Page_DetailedApplicationForm.displayGuardiansAddress1InputField().clear();
			Page_DetailedApplicationForm.displayGuardiansAddress1InputField().sendKeys(providedAddress1Step2);
			Reporter.log("User has entered Guardians Address 1 value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Guardians Address 1 value.",true);
		}
	}
	
	@Test
	@Parameters({"address2"})
	public static void provideGuardiansAddress2(String address2) throws Exception
	{
		try 
		{
			providedAddress2Step2 = address2+" in Step2";
			Page_DetailedApplicationForm.displayGuardiansAddress2InputField().clear();
			Page_DetailedApplicationForm.displayGuardiansAddress2InputField().sendKeys(providedAddress2Step2);
			Reporter.log("User has entered Guardians Address 2 value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Guardians Address 2 value.",true);
		}
	}
	
	@Test
	@Parameters({"address3"})
	public static void provideGuardiansAddress3(String address3) throws Exception
	{
		try 
		{
			providedAddress3Step2 = address3+" in Step2";
			Page_DetailedApplicationForm.displayGuardiansAddress3InputField().clear();
			Page_DetailedApplicationForm.displayGuardiansAddress3InputField().sendKeys(providedAddress3Step2);
			Reporter.log("User has entered Guardians Address 3 value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Guardians Address 3 value.",true);
		}
	}
	
	@Test
	@Parameters({"lgpincode"})
	public static void provideGuardiansAddrPincode(String lgpincode) throws Exception
	{
		try 
		{
			providedLGPincode = lgpincode;
			Page_DetailedApplicationForm.displayGuardianAddrPincodeInputField().clear();
			Page_DetailedApplicationForm.displayGuardianAddrPincodeInputField().sendKeys(providedLGPincode);
			Reporter.log("User has entered Guardians Relation value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Guardians Relation value.",true);
		}
	}
	
	@Test
	@Parameters({"lgrelation"})
	public static void provideGuardiansRelation(String lgrelation) throws Exception
	{
		try 
		{
			providedLGRelation = lgrelation;
			Page_DetailedApplicationForm.displayGuardianRelationInputField().clear();
			Page_DetailedApplicationForm.displayGuardianRelationInputField().sendKeys(providedLGRelation);
			Reporter.log("User has entered Guardians Relation value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Guardians Relation value.",true);
		}
	}
	
	@Test
	public static void provideGuardiansContactNumber() throws Exception
	{
		try 
		{
			providedLGContactNumber = Long.toString(DataGenerator.randomMobileNumberGenerator());
			Page_DetailedApplicationForm.displayGuardiansContactNumberInputField().clear();
			Page_DetailedApplicationForm.displayGuardiansContactNumberInputField().sendKeys(providedLGContactNumber);
			Reporter.log("User has entered Guardians Contact Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Guardians Contact Number value.",true);
		}
	}
	
	@Test
	public static void clickNextButtonStep2() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayNextButtonStep2().click();
			Thread.sleep(3000);
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
			Thread.sleep(1000);
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
			Thread.sleep(1000);
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
			Thread.sleep(1000);
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
	
	@Test
	public static void validateFathersAnnualIncomeStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Fathers Annual Income--------------");
			System.out.println("Provided Fathers Annual Income: "+providedFathersIncome);
			//Intentional Pause
			Thread.sleep(1000);
			String storedFatherIncome = extractDataFromDatabase("appFormFatherIncome");
			System.out.println("Fathers Annual Income value from DB: "+storedFatherIncome);
			Assert.assertEquals(providedFathersIncome, storedFatherIncome);
			Reporter.log("Provided Fathers Annual Income matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Fathers Annual Income doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateFathersEmailStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Fathers Email--------------");
			System.out.println("Provided Email: "+providedFathersEmail);
			//Intentional Pause
			Thread.sleep(1000);
			String storedFatherEmail = extractDataFromDatabase("userFthrEmail");
			System.out.println("Fathers Email value from DB: "+storedFatherEmail);
			Assert.assertEquals(providedFathersEmail, storedFatherEmail);
			Reporter.log("Provided Fathers Email matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Fathers Email doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateFathersMobileStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Fathers Mobile--------------");
			System.out.println("Provided Mobile: "+providedFathersMobile);
			//Intentional Pause
			Thread.sleep(1000);
			String storedFatherMob = extractDataFromDatabase("userFthrMob");
			System.out.println("Fathers Mobile value from DB: "+storedFatherMob);
			Assert.assertEquals(providedFathersMobile, storedFatherMob);
			Reporter.log("Provided Fathers Mobile matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Fathers Mobile doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateMothersNameStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Mothers Name--------------");
			System.out.println("Provided Mothers Name: "+providedMothersNm);
			//Intentional Pause
			Thread.sleep(1000);
			String storedMotherNM = extractDataFromDatabase("userMothersName");
			System.out.println("Mothers Name value from DB: "+storedMotherNM);
			Assert.assertEquals(providedMothersNm, storedMotherNM);
			Reporter.log("Provided Mothers Name matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Mothers Name doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateMothersQualificationStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Mothers Qualification--------------");
			System.out.println("Provided Mothers Qualification: "+proviedMotherQualfcn);
			//Intentional Pause
			Thread.sleep(1000);
			String storedMotherQualfcn = extractDataFromDatabase("appFormMotherQualfcn");
			System.out.println("Mothers Qualification value from DB: "+storedMotherQualfcn);
			Assert.assertEquals(proviedMotherQualfcn, storedMotherQualfcn);
			Reporter.log("Provided Mothers Qualification matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Mothers Qualification doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateMothersOccupationStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Mothers Occupation--------------");
			System.out.println("Provided Mothers Occupation: "+providedMothersOccpn);
			//Intentional Pause
			Thread.sleep(1000);
			String storedMotherOccpn = extractDataFromDatabase("appFormMotherOccpn");
			System.out.println("Mothers Occupation value from DB: "+storedMotherOccpn);
			Assert.assertEquals(providedMothersOccpn, storedMotherOccpn);
			Reporter.log("Provided Mothers Occupation matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Mothers Occupation doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateMothersEmailStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Mothers Email--------------");
			System.out.println("Provided Email: "+providedMothersEmail);
			//Intentional Pause
			Thread.sleep(1000);
			String storedMotherEmail = extractDataFromDatabase("userMthrEmail");
			System.out.println("Mothers Email value from DB: "+storedMotherEmail);
			Assert.assertEquals(providedMothersEmail, storedMotherEmail);
			Reporter.log("Provided Mothers Email matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Mothers Email doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateMothersMobileStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Mothers Mobile--------------");
			System.out.println("Provided Mobile: "+providedMothersMobile);
			//Intentional Pause
			Thread.sleep(1000);
			String storedMotherMob = extractDataFromDatabase("userMthrMob");
			System.out.println("Mothers Mobile value from DB: "+storedMotherMob);
			Assert.assertEquals(providedMothersMobile, storedMotherMob);
			Reporter.log("Provided Mothers Mobile matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Mothers Mobile doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateLocalGuardianNameStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Guardians Name--------------");
			System.out.println("Provided Guardians Name: "+providedLGuardianNm);
			//Intentional Pause
			Thread.sleep(1000);
			String storedGrdnName = extractDataFromDatabase("userLocalGrdnName");
			System.out.println("Guardians Name value from DB: "+ storedGrdnName);
			Assert.assertEquals(providedLGuardianNm, storedGrdnName);
			Reporter.log("Provided Guardians Name matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Guardians Name doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateLocalGuardianAddr1Step2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Guardians Address 1--------------");
			System.out.println("Provided Guardians Address 1: "+providedAddress1Step2);
			//Intentional Pause
			Thread.sleep(1000);
			String storedGrdnAddr1 = extractDataFromDatabase("usercommLAddr1");
			System.out.println("Guardians Address 1 value from DB: "+storedGrdnAddr1);
			Assert.assertEquals(providedAddress1Step2, storedGrdnAddr1);
			Reporter.log("Provided Guardians Address 1 matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Guardians Address 1 doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateLocalGuardianAddr2Step2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Guardians Address 2--------------");
			System.out.println("Provided Guardians Address 2: "+providedAddress2Step2);
			//Intentional Pause
			Thread.sleep(1000);
			String storedGrdnAddr2 = extractDataFromDatabase("usercommLAddr2");
			System.out.println("Guardians Address 2 value from DB: "+storedGrdnAddr2);
			Assert.assertEquals(providedAddress2Step2, storedGrdnAddr2);
			Reporter.log("Provided Guardians Address 2 matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Guardians Address 2 doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateLocalGuardianAddr3Step2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Guardians Address 3--------------");
			System.out.println("Provided Guardians Address 3: "+providedAddress3Step2);
			//Intentional Pause
			Thread.sleep(1000);
			String storedGrdnAddr3 = extractDataFromDatabase("usercommLAddr3");
			System.out.println("Guardians Address 3 value from DB: "+storedGrdnAddr3);
			Assert.assertEquals(providedAddress3Step2, storedGrdnAddr3);
			Reporter.log("Provided Guardians Address 3 matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Guardians Address 3 doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateGrdnAddrPincodeStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Guardians Pincode--------------");
			System.out.println("Provided Guardians Pincode: "+providedLGPincode);
			//Intentional Pause
			Thread.sleep(1000);
			String storedGrdnPincode = extractDataFromDatabase("usercommPincode");
			System.out.println("Guardians provided Pincode value from DB: "+storedGrdnPincode);
			Assert.assertEquals(providedLGPincode, storedGrdnPincode);
			Reporter.log("Provided Guardians Pincode matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Guardians Pincode doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateGuardianRelationStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Guardians Relation--------------");
			System.out.println("Provided Guardians Relation: "+providedLGRelation);
			//Intentional Pause
			Thread.sleep(1000);
			String storedGrdnRelation = extractDataFromDatabase("userEmrgncyRelatn");
			System.out.println("Guardians provided Relation value from DB: "+storedGrdnRelation);
			Assert.assertEquals(providedLGRelation, storedGrdnRelation);
			Reporter.log("Provided Guardians Relation matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Guardians Relation doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateGuardianContactNumberStep2() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating Guardians ContactNumber--------------");
			System.out.println("Provided Guardians ContactNumber: "+providedLGContactNumber);
			//Intentional Pause
			Thread.sleep(1000);
			String storedContactNumber = extractDataFromDatabase("userGrdnContactNum");
			System.out.println("Guardians provided ContactNumber value from DB: "+storedContactNumber);
			Assert.assertEquals(providedLGContactNumber, storedContactNumber);
			Reporter.log("Provided Guardians ContactNumber matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Guardians ContactNumber doesn't match the value stored in database.",true);
		}
	}
	
	/********************* STEP 3 *************************/
	
	@Test
	public static void provideCourse() throws Exception
	{
		Thread.sleep(4000);
		System.out.println("\n"+"*********************** Filling up Step 3 Information ***************************"+"\n");
		try 
		{
			Actions builder = new Actions(driver);
			Action seriesOfActions = builder
		              .moveToElement(driver.findElement(By.cssSelector("#showCourse > span > span.selection > span")))
		              .click()
		              .sendKeys(Keys.RETURN)
		              .build();
			seriesOfActions.perform();
//			Page_DetailedApplicationForm.displaySelectCourseDropDown().selectByVisibleText(GenerateLeadForApplicationForm.providedEntityValue);
//			providedCourseStep3 =  Page_DetailedApplicationForm.displaySelectCourseDropDown().getFirstSelectedOption().getText();
			providedCourseStep3 =  Page_DetailedApplicationForm.displaySelectCourseDropDown1().getText();
			System.out.println("providedCourseStep3: "+providedCourseStep3);

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
			providedSSCSchoolName = "School Name in Step 3";
			Page_DetailedApplicationForm.displaySSCSchoolNameInputField().clear();
			Page_DetailedApplicationForm.displaySSCSchoolNameInputField().sendKeys(providedSSCSchoolName);
			Reporter.log("User has entered SSC School Name value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide SSC School Name value.",true);
		}
	}
	
	@Test
	public static void provideSSCBoard() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySelectSSCBoardDropDown().selectByIndex(1);
			providedSSCBoard =  Page_DetailedApplicationForm.displaySelectSSCBoardDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered SSCBoard value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide SSCBoard value.",true);
		}
	}
	
	@Test
	public static void provideSSCYearOfPassing() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySelectSSCYoPDropDown().selectByIndex(2);
			providedSSCYoP =  Page_DetailedApplicationForm.displaySelectSSCYoPDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered SSC Year of Passing value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide SSC Year of Passing value.",true);
		}
	}
	
	@Test
	@Parameters({"sscRegNumber"})	
	public static void provideSSCRegNumber(String sscRegNumber) throws Exception
	{
		try 
		{
			providedSSCRegNumber = sscRegNumber;
			Page_DetailedApplicationForm.displaySSCRegNumberInputField().clear();
			Page_DetailedApplicationForm.displaySSCRegNumberInputField().sendKeys(providedSSCRegNumber);
			Reporter.log("User has entered SSC Registration Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide SSC Registration Number value.",true);
		}
	}
	
	@Test
	@Parameters({"otherSSCMode"})	
	public static void provideSSCModeOfStudy(String otherSSCMode) throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySSCModeOfStudyDropDown().selectByIndex(1);
			providedSSCModeOfStudy = Page_DetailedApplicationForm.displaySSCModeOfStudyDropDown().getFirstSelectedOption().getText();
			if(providedSSCModeOfStudy.equalsIgnoreCase("Other"))
			{
				Page_DetailedApplicationForm.displayOtherSSCModeOfStudyInputField().sendKeys(otherSSCMode);
				providedSSCModeOfStudy = otherSSCMode;
			}
			Reporter.log("User has entered SSC Mode of Study value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide SSC Mode of Study value.",true);
		}
	}
	
	@Test
	@Parameters({"sscGradePercent"})	
	public static void provideSSCPercentageValue(String sscGradePercent) throws Exception
	{
		try 
		{
			providedSSCGrade = sscGradePercent;
			Page_DetailedApplicationForm.displaySSCPercentageInputField().clear();
			Page_DetailedApplicationForm.displaySSCPercentageInputField().sendKeys(providedSSCGrade);
			Reporter.log("User has entered SSC Grade/Percentage value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide SSC Grade/Percentage value.",true);
		}
	}
	
	@Test
	public static void showHideHSCDetailsSection() throws Exception
	{
			try
			{
				//Do validation of provided value later
				Page_DetailedApplicationForm.displayHSCDetailsSection();
				Reporter.log("User has clicked HSC Results Out Radio button successfully.",true);
			}
			catch (org.openqa.selenium.NoSuchElementException e) 
			{
				e.printStackTrace();
				Reporter.log("User has failed to click HSC Results Out Radio button.",true);
			}
	}
	
	@Test
	@Parameters({"hscSchoolName"})	
	public static void provideHSCSchoolName(String hscSchoolName) throws Exception
	{
		try 
		{
			providedHSCSchoolName = hscSchoolName+" in step 3";
			Page_DetailedApplicationForm.displayHSCSchoolNameInputField().clear();
			Page_DetailedApplicationForm.displayHSCSchoolNameInputField().sendKeys(providedHSCSchoolName);
			Reporter.log("User has entered HSC School Name value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide HSC School Name value.",true);
		}
	}
	
	@Test
	public static void provideHSCBoard() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displaySelectHSCBoardDropDown().selectByIndex(1);
			providedHSCBoard =  Page_DetailedApplicationForm.displaySelectHSCBoardDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered HSCBoard value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide HSCBoard value.",true);
		}
	}
	
	@Test
	@Parameters({"otherHSCMode"})	
	public static void provideModeOfStudyHSC(String otherHSCMode) throws Exception
	{
		try 
			{
				Page_DetailedApplicationForm.displayModeOfStudyHSCDropDown().selectByIndex(1);
				providedHSCModeOfStudy =  Page_DetailedApplicationForm.displayModeOfStudyHSCDropDown().getFirstSelectedOption().getText();
				if(providedHSCModeOfStudy.equalsIgnoreCase("Other"))
				{
					Page_DetailedApplicationForm.displayOtherHSCModeOfStudyInputField().sendKeys(otherHSCMode);
					providedHSCModeOfStudy = otherHSCMode;
				}
				Reporter.log("User has entered HSC Mode Of Study value successfully.",true);
			}
			catch (org.openqa.selenium.NoSuchElementException e) 
			{
				e.printStackTrace();
				Reporter.log("User has failed to enter HSC Mode Of Study value.",true);
			}
	}
	
	@Test
	public static void provideHSCYearOfPassing() throws Exception
	{
			try
			{
				Page_DetailedApplicationForm.displayHSCYearOfPassingDropDown().selectByIndex(1);
				providedHSCYoP =  Page_DetailedApplicationForm.displayHSCYearOfPassingDropDown().getFirstSelectedOption().getText();
				Reporter.log("User has entered HSC Year Of Passing value successfully.",true);
			}
			catch (org.openqa.selenium.NoSuchElementException e) 
			{
				e.printStackTrace();
				Reporter.log("User has failed to enter HSC Mode Of Study value.",true);
			}
		
	}
	
	@Test
	@Parameters({"hscGradePercent"})
	public static void provideHSCPercentageGradeType(String hscGradePercent) throws Exception
	{
		try
			{
				providedHSCPerGrade = hscGradePercent;
				Page_DetailedApplicationForm.displayHSCPercentageGradeRadioButton().click();
				Page_DetailedApplicationForm.displayHSCPercentageInputField().clear();
				Page_DetailedApplicationForm.displayHSCPercentageInputField().sendKeys(providedHSCPerGrade);
				Reporter.log("User has entered HSC Percentage/Grade value successfully.",true);
			}
			catch (org.openqa.selenium.NoSuchElementException e) 
			{
				e.printStackTrace();
				Reporter.log("User has failed to enter HSC Percentage/Grade value.",true);
			}
		
	}
	
	@Test
	@Parameters({"hscRegNumber"})
	public static void provideHSCRegNumber(String hscRegNumber) throws Exception
	{
		try
			{
				providedHSCRegNumber = hscRegNumber;
				Page_DetailedApplicationForm.displayHSCRegNumberInputField().clear();
				Page_DetailedApplicationForm.displayHSCRegNumberInputField().sendKeys(providedHSCRegNumber);
				Reporter.log("User has entered HSC Registration Number value successfully.",true);
			}
			catch (org.openqa.selenium.NoSuchElementException e) 
			{
				e.printStackTrace();
				Reporter.log("User has failed to enter HSC Registration Number value.",true);
			}
	}
	
	@Test
	@Parameters({"numberOfSubjects"})
	public static void provideHSCSubjectScoreDetails(int numberOfSubjects) throws Exception
	{
		String [] scoreDetails = new String [numberOfSubjects*4];
		int counter=0;
		for (int i = 0; i <numberOfSubjects; i++) 
		{
			scoreDetails[counter]="Subject "+(i+1);	//Subject
			counter++;
			scoreDetails[counter]="100";			//Max Marks
			counter++;
			scoreDetails[counter]="88";				//Obtained Marks
			counter++;
			scoreDetails[counter]="88.00";			//Percentage
			counter++;
		}
		
			Page_DetailedApplicationForm.displaySubMarkPercentageInputFields(numberOfSubjects);
//			System.out.println("Just for check: "+ Arrays.toString(webElements.toArray()));
			for (int i = 0; i < hscSubjects.size(); i++) 
			{
				hscSubjects.get(i).sendKeys(scoreDetails[i]);
				Thread.sleep(500);
			}
			hscSubjects.clear();
			Reporter.log("User has successfully added HSC examination details.",true);
	}
	
	@Test
	@Parameters({"numberOfExams"})
	public static void provideEntranceExamDetails(int numberOfExams) throws Exception
	{
		String [] examDetails = new String [numberOfExams*2];
		int counter=0;
		for (int i = 0; i <numberOfExams; i++) 
		{
			examDetails[counter]="Examination Name "+(i+1);	//Subject
			counter++;
			examDetails[counter]="87";						//Marks
			counter++;
		}
		if(Page_DetailedApplicationForm.displayEntranceExamSection().isDisplayed())
		{
			Page_DetailedApplicationForm.displayEntranceExamDetailsInputFields(numberOfExams);
			for (int i = 0; i < hscSubjects.size(); i++) 
			{
				hscSubjects.get(i).sendKeys(examDetails[i]);
				Thread.sleep(500);
			}
			hscSubjects.clear();
			Reporter.log("User has successfully added Entrance examination details.",true);
		}
		else
		{
			Reporter.log("User has failed to add Entrance examination details.",true);
		}
	}
	
	@Test
	public static void provideDegreeOrDiplomaType() throws Exception
	{
			try
			{
				//Do validation of provided value later
				Page_DetailedApplicationForm.showHideDiplomaDetailsSection().click();
				Page_DetailedApplicationForm.selectGradDiplomaType().click();
				Reporter.log("User has clicked Grad/Diploma Radio button successfully.",true);
			}
			catch (org.openqa.selenium.NoSuchElementException e) 
			{
				e.printStackTrace();
				Reporter.log("User has failed to click Grad/Diploma Radio button.",true);
			}
	}
	
	@Test
	@Parameters({"degreeName"})
	public static void provideDegreeOrDiplomaName(String degreeName) throws Exception
	{
			try
			{
				providedDegDiplomaName = "Degree in "+degreeName;
				Page_DetailedApplicationForm.displayDegreeDiplomaNameInputField().clear();
				Page_DetailedApplicationForm.displayDegreeDiplomaNameInputField().sendKeys(providedDegDiplomaName);
				Reporter.log("User has entered Degree Name value successfully.",true);
			}
			catch (org.openqa.selenium.NoSuchElementException e) 
			{
				e.printStackTrace();
				Reporter.log("User has failed to enter Degree Name value.",true);
			}
	}
	
	@Test
	@Parameters({"degreeAOS"})
	public static void provideDegreeOrDiplomaAreaOfSpecialization(String degreeAOS) throws Exception
	{
			try
			{
				providedDiplomaAOS = "Area of Specialization in "+degreeAOS;
				Page_DetailedApplicationForm.displayDegreeDiplomaAoSInputField().clear();
				Page_DetailedApplicationForm.displayDegreeDiplomaAoSInputField().sendKeys(providedDiplomaAOS);
				Reporter.log("User has entered Degree AoS value successfully.",true);
			}
			catch (org.openqa.selenium.NoSuchElementException e) 
			{
				e.printStackTrace();
				Reporter.log("User has failed to enter Degree AoS value.",true);
			}
	}
	
	@Test
	@Parameters({"degreeCollege"})
	public static void provideDegreeOrDiplomaCollegeName(String degreeCollege) throws Exception
	{
			try
			{
				providedDiplomaCollegeName = "Walchand College of Engineering, "+degreeCollege;
				Page_DetailedApplicationForm.displayDegreeDiplomaCollegeNameInputField().clear();
				Page_DetailedApplicationForm.displayDegreeDiplomaCollegeNameInputField().sendKeys(providedDiplomaCollegeName);
				Reporter.log("User has entered Degree College Name value successfully.",true);
			}
			catch (org.openqa.selenium.NoSuchElementException e) 
			{
				e.printStackTrace();
				Reporter.log("User has failed to enter Degree College Name value.",true);
			}
	}
	
	@Test
	@Parameters({"degreeUnivName"})
	public static void provideDegreeOrDiplomaUniversityName(String degreeUnivName) throws Exception
	{
			try
			{
				providedUniversityNm = "Shivaji University, "+degreeUnivName;
				Page_DetailedApplicationForm.displayDegreeDiplomaUniversityNameInputField().clear();
				Page_DetailedApplicationForm.displayDegreeDiplomaUniversityNameInputField().sendKeys(providedUniversityNm);
				Reporter.log("User has entered Degree University Name value successfully.",true);
			}
			catch (org.openqa.selenium.NoSuchElementException e) 
			{
				e.printStackTrace();
				Reporter.log("User has failed to enter Degree University Name value.",true);
			}
	}
	
	
	@Test
	public static void provideDegDiplomaExamType() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayDegreeDiplomaExamTypeDropDown().selectByIndex(2);
			providedDiplomaExamType =  Page_DetailedApplicationForm.displayDegreeDiplomaExamTypeDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered Degree/Diploma Exam Type value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Degree/Diploma Exam Type value.",true);
		}
	}
	
	@Test
	public static void provideDegDiplomaYearOfCompletion() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayDegreeDiplomaYoCDropDown().selectByIndex(1);
			providedDiplomaYoC =  Page_DetailedApplicationForm.displayDegreeDiplomaYoCDropDown().getFirstSelectedOption().getText();
			Reporter.log("User has entered Degree/Diploma YoC value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Degree/Diploma YoC value.",true);
		}
	}
	
	@Test
	@Parameters({"otherDiplomaMode"})	
	public static void provideDegDiplomaModeOfStudy(String otherDiplomaMode) throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayDegreeDiplomaModeOfStudyDropDown().selectByIndex(2);
			providedDiplomaModeOfStudy =  Page_DetailedApplicationForm.displayDegreeDiplomaModeOfStudyDropDown().getFirstSelectedOption().getText();
			if(providedDiplomaModeOfStudy.equalsIgnoreCase("Other"))
			{
				Page_DetailedApplicationForm.displayOtherDegreeDiplomaModeOfStudyInputField().sendKeys(otherDiplomaMode);
				providedDiplomaModeOfStudy = otherDiplomaMode;
			}
			Reporter.log("User has entered Degree/Diploma Mode Of Study value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Degree/Diploma Mode Of Study value.",true);
		}
	}
	
	@Test
	@Parameters({"gradYears"})
	public static void provideGraduationYearwiseMarksDetails(int gradYears) throws Exception
	{
		String [] gradMarksDetails = new String [gradYears*4];	//4 = graduation years
		int counter=0;
		for (int i = 0; i <gradYears; i++) 
		{
			gradMarksDetails[counter]="Year "+(i+1) +"Subject";		//Subject	**These values to be generated randomly later**
			counter++;
			gradMarksDetails[counter]="7"+(i*2);							//Max Marks
			counter++;
			gradMarksDetails[counter]="8"+(i*3);							//Obtained Marks / Grade
			counter++;
			gradMarksDetails[counter]="6"+(i*4);							//Percentage
			counter++;
		}
		
			Page_DetailedApplicationForm.displayGraduationYearwiseMarksInputFields(gradYears);
			for (int i = 0; i < hscSubjects.size(); i++) 
			{
				hscSubjects.get(i).sendKeys(gradMarksDetails[i]);
				Thread.sleep(500);
			}
			hscSubjects.clear();
			Reporter.log("User has successfully added Graduation Marks year wise details.",true);
	}
	
	@Test
	public static void provideAttachment1() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment1Button().sendKeys(Constants.APPFORM_ATTACHMENT1);
			Reporter.log("User has provided Attachement1 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Attachement1.",true);
		}
	}
	
	@Test
	public static void provideAttachment2() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment2Button().sendKeys(Constants.APPFORM_ATTACHMENT2);
			Reporter.log("User has provided Attachement2 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Attachement2.",true);
		}
	}
	
	@Test
	public static void provideAttachment3() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment3Button().sendKeys(Constants.APPFORM_ATTACHMENT3);
			Reporter.log("User has provided Attachement3 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Attachement3.",true);
		}
	}
	
	@Test
	public static void provideAttachment4() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment4Button().sendKeys(Constants.APPFORM_ATTACHMENT4);
			Reporter.log("User has provided Attachement4 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Attachement4.",true);
		}
	}
	
	@Test
	public static void provideAttachment5() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment5Button().sendKeys(Constants.APPFORM_ATTACHMENT5);
			Reporter.log("User has provided Attachement5 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Attachement5.",true);
		}
	}
	
	@Test
	public static void provideAttachment6() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment6Button().sendKeys(Constants.APPFORM_ATTACHMENT6);
			Reporter.log("User has provided Attachement5 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Attachement6.",true);
		}
	}

	@Test
	public static void provideAttachment7() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment7Button().sendKeys(Constants.APPFORM_ATTACHMENT7);
			Reporter.log("User has provided Attachement7 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Attachement7.",true);
		}
	}
	
	@Test
	public static void provideAttachment8() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment8Button().sendKeys(Constants.APPFORM_ATTACHMENT8);
			Reporter.log("User has provided Attachement8 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Attachement8.",true);
		}
	}
	
	@Test
	public static void provideAttachment9() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment9Button().sendKeys(Constants.APPFORM_ATTACHMENT9);
			Reporter.log("User has provided Attachement9 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Attachement9.",true);
		}
	}
	
	@Test
	public static void provideAttachment10() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayAttachment10Button().sendKeys(Constants.APPFORM_ATTACHMENT10);
			Reporter.log("User has provided Attachement10 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to attach Attachement10.",true);
		}
	}
	
	
	@Test
	public static void clickNextButtonStep3() throws Exception
	{
		try 
		{
			Thread.sleep(4000);
			Page_DetailedApplicationForm.displayNextButtonStep3().click();
			Thread.sleep(6000);
			Reporter.log("User has clicked Next button on Step 3 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Next button on Step 3.",true);
		}
	}
	
	@Test
	public static void validateCourseStep3() throws InterruptedException, SQLException
	{
		System.out.println("\n"+"*********************** Validating information filled up in Step 3 ***************************"+"\n");

		try {
			System.out.println("--------------Validating Course Value--------------");
			System.out.println("Provided Course: "+providedCourseStep3);
			//Intentional Pause
			Thread.sleep(1000);
			String storedCourse = extractDataFromDatabase("userFathersName");
			System.out.println("Course value from DB: "+storedCourse);
			Assert.assertEquals(providedCourseStep3, storedCourse);
			Reporter.log("Provided Course matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Course doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateSSCSchoolNameStep3() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating SSC School Name Value--------------");
			System.out.println("Provided SSC School Name: "+providedSSCSchoolName);
			//Intentional Pause
			Thread.sleep(1000);
			String storedSSCSchool = extractDataFromDatabase("userFathersName");
			System.out.println("SSC School Name value from DB: "+storedSSCSchool);
			Assert.assertEquals(providedSSCSchoolName, storedSSCSchool);
			Reporter.log("Provided SSC School Name matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided SSC School Name doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateSSCBoardStep3() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating SSC Board Value--------------");
			System.out.println("Provided SSC Board Name: "+providedSSCBoard);
			//Intentional Pause
			Thread.sleep(1000);
			String storedSSCBoard = extractDataFromDatabase("userFathersName");
			System.out.println("SSC Board Name value from DB: "+storedSSCBoard);
			Assert.assertEquals(providedSSCBoard, storedSSCBoard);
			Reporter.log("Provided SSC Board Name matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided SSC Board Name doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateSSCYoPStep3() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating SSC YoP Value--------------");	
			System.out.println("Provided SSC YoP Name: "+providedSSCYoP);
			//Intentional Pause
			Thread.sleep(1000);
			String storedSSCYoP = extractDataFromDatabase("userFathersName");
			System.out.println("SSC Board Name value from DB: "+storedSSCYoP);
			Assert.assertEquals(providedSSCYoP, storedSSCYoP);
			Reporter.log("Provided SSC YoP matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided SSC YoP doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateSSCRegNumberStep3() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating SSC RegNumber Value--------------");
			System.out.println("Provided SSC RegNumber: "+providedSSCRegNumber);
			//Intentional Pause
			Thread.sleep(1000);
			String storedSSCRegNumber = extractDataFromDatabase("userFathersName");
			System.out.println("SSC RegNumber value from DB: "+storedSSCRegNumber);
			Assert.assertEquals(providedSSCRegNumber, storedSSCRegNumber);
			Reporter.log("Provided SSC RegNumber matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided SSC RegNumber doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateSSCModeOfStudyStep3() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating SSC Mode Of Study Value--------------");
			System.out.println("Provided SSC Mode Of Study: "+providedHSCModeOfStudy);
			//Intentional Pause
			Thread.sleep(1000);
			String storedSSCMoS = extractDataFromDatabase("userFathersName");
			System.out.println("SSC RegNumber value from DB: "+storedSSCMoS);
			Assert.assertEquals(providedHSCModeOfStudy, storedSSCMoS);
			Reporter.log("Provided SSC Mode Of Study matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided SSC Mode Of Study doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateSSCPercentageStep3() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating SSC Percentage Value--------------");
			System.out.println("Provided SSC Percentage: "+providedSSCGrade);
			//Intentional Pause
			Thread.sleep(1000);
			String storedSSCPercentage = extractDataFromDatabase("userFathersName");
			System.out.println("SSC Percentage value from DB: "+storedSSCPercentage);
			Assert.assertEquals(providedSSCGrade, storedSSCPercentage);
			Reporter.log("Provided SSC Percentage matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided SSC Percentage doesn't match the value stored in database.",true);
		}
	}

	@Test
	public static void validateHSCSchoolNameStep3() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating HSC School Name Value--------------");
			System.out.println("Provided HSC School Name: "+providedHSCSchoolName);
			//Intentional Pause
			Thread.sleep(1000);
			String storedHSCSchool = extractDataFromDatabase("userFathersName");
			System.out.println("HSC School Name value from DB: "+storedHSCSchool);
			Assert.assertEquals(providedHSCSchoolName, storedHSCSchool);
			Reporter.log("Provided HSC School Name matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided HSC School Name doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateHSCBoardStep3() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating HSC Board Value--------------");
			System.out.println("Provided HSC Board Name: "+providedHSCBoard);
			//Intentional Pause
			Thread.sleep(1000);
			String storedHSCBoard = extractDataFromDatabase("userFathersName");
			System.out.println("HSC Board Name value from DB: "+storedHSCBoard);
			Assert.assertEquals(providedHSCBoard, storedHSCBoard);
			Reporter.log("Provided HSC Board Name matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided HSC Board Name doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateHSCYoPStep3() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating HSC YoP Value--------------");
			System.out.println("Provided HSC YoP Name: "+providedHSCYoP);
			//Intentional Pause
			Thread.sleep(1000);
			String storedHSCYoP = extractDataFromDatabase("userFathersName");
			System.out.println("HSC Board Name value from DB: "+storedHSCYoP);
			Assert.assertEquals(providedHSCYoP, storedHSCYoP);
			Reporter.log("Provided HSC YoP matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided HSC YoP doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateHSCRegNumberStep3() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating HSC RegNumber Value--------------");
			System.out.println("Provided HSC RegNumber: "+providedHSCRegNumber);
			//Intentional Pause
			Thread.sleep(1000);
			String storedHSCRegNumber = extractDataFromDatabase("userFathersName");
			System.out.println("HSC RegNumber value from DB: "+storedHSCRegNumber);
			Assert.assertEquals(providedHSCRegNumber, storedHSCRegNumber);
			Reporter.log("Provided HSC RegNumber matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided HSC RegNumber doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateHSCModeOfStudyStep3() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating HSC Mode Of Study Value--------------");
			System.out.println("Provided HSC Mode Of Study: "+providedHSCModeOfStudy);
			//Intentional Pause
			Thread.sleep(1000);
			String storedHSCMoS = extractDataFromDatabase("userFathersName");
			System.out.println("HSC RegNumber value from DB: "+storedHSCMoS);
			Assert.assertEquals(providedHSCModeOfStudy, storedHSCMoS);
			Reporter.log("Provided HSC Mode Of Study matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided HSC Mode Of Study doesn't match the value stored in database.",true);
		}
	}
	
	@Test
	public static void validateHSCPercentageStep3() throws InterruptedException, SQLException
	{
		try {
			System.out.println("--------------Validating HSC Percentage Value--------------");
			System.out.println("Provided HSC Percentage: "+providedHSCPerGrade);
			//Intentional Pause
			Thread.sleep(1000);
			String storedHSCPercentage = extractDataFromDatabase("userFathersName");
			System.out.println("HSC Percentage value from DB: "+storedHSCPercentage);
			Assert.assertEquals(providedHSCPerGrade, storedHSCPercentage);
			Reporter.log("Provided HSC Percentage matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided HSC Percentage doesn't match the value stored in database.",true);
		}
	}

		/********************* STEP 4 *************************/
	
	@Test
	public static void providePaymentCourse() throws Exception
	{
		Thread.sleep(10000);

		System.out.println("\n"+"*********************** Filling up Step 4 Information ***************************"+"\n");
		try 
		{
			Actions builder = new Actions(driver);
			Action seriesOfActions = builder
		              .moveToElement(driver.findElement(By.cssSelector("#showPaymentCourse > div > span > span.selection > span")))
		              .click()
		              .sendKeys(Keys.RETURN)
		              .build();
			seriesOfActions.perform();
			
//			Page_DetailedApplicationForm.displayEntityDropdown().selectByVisibleText(GenerateLeadForApplicationForm.providedEntityValue);
			
			providedCourseStep4 =  Page_DetailedApplicationForm.displayEntityDropdown1().getText();

			System.out.println("providedCourseStep4: "+providedCourseStep4);
			Reporter.log("User has entered Payment Course value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Payment Course value.",true);
		}
	}
	
	@Test
	public static void providePaymentType() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayPaymentTypeDropdown().selectByIndex(1);
			Reporter.log("User has entered Payment Type value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Payment Type value.",true);
		}
	}
	
	@Test
	public static void clickSubmitButtonStep4() throws Exception
	{
		try 
		{
			Thread.sleep(2000);
			Page_DetailedApplicationForm.displaySubmitButtonStep4().click();
			Reporter.log("User has clicked Submit button on Step 4 successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to click Submit button.",true);
		}
	}
}
