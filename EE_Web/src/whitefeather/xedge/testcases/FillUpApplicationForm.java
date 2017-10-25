package whitefeather.xedge.testcases;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.core.Page_DetailedApplicationForm;
import whitefeather.xedge.facilitator.HelperHand;

public class FillUpApplicationForm  extends HelperHand
{
	
	public static String providedDOB="", blGroup=null;
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
			Assert.assertTrue(Page_DetailedApplicationForm.displayDateOfBirthInputFieldStep1().isDisplayed());
			Page_DetailedApplicationForm.displayDateOfBirthInputFieldStep1().click();
			Reporter.log("User has opened calender successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to open Caledar Form.",true);
		}
	}
	
	@Test
	public static void provideDateOfBirth() throws Exception
	{
		try 
		{		
			Page_DetailedApplicationForm.displayDOBMonthDropDown().selectByIndex(6);
			String month = Page_DetailedApplicationForm.getBirthMonthFromProvidedDOB(Page_DetailedApplicationForm.displayDOBMonthDropDown().getFirstSelectedOption().getText());
			Page_DetailedApplicationForm.displayDOBYearDropDown().selectByIndex(80);
			String year = Page_DetailedApplicationForm.displayDOBYearDropDown().getFirstSelectedOption().getText();
			Page_DetailedApplicationForm.displayDaysOfMonth().click();
			String day = Page_DetailedApplicationForm.displayDaysOfMonth().getText();
			
			providedDOB = year+"-0"+month+"-"+day;
			
			Reporter.log("User has provided Date of Birth successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("User has failed to enter Date of Birth.",true);
		}
	}
	
	@Test
	@Parameters({"bloodGroup"})	
	public static void provideBloodGroup(String bloodGroup) throws Exception
	{
		blGroup = bloodGroup;
		try 
		{
			Page_DetailedApplicationForm.displayBloodGroupInputField().sendKeys(blGroup);
			Reporter.log("User has entered blood group value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide blood group value.",true);
		}
	}
	
	@Test
	public static void provideGender() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayGenderDropDown().selectByIndex(1);
			Reporter.log("User has entered Gender value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Gender value.",true);
		}
	}
	
	@Test
	public static void provideCitizenship() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayCitizenshipInputField().sendKeys("Kolhapur");
			Reporter.log("User has entered Citizenship value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Citizenship value.",true);
		}
	}
	
	@Test
	public static void provideNationality() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayNationalityInputField().sendKeys("Bharat");
			Reporter.log("User has entered Nationality value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Nationality value.",true);
		}
	}
	
	@Test
	public static void provideDomicile() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayDomicileDropDown().selectByIndex(1);
			Reporter.log("User has entered Domicile value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Domicile value.",true);
		}
	}
	
	@Test
	public static void provideReligion() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayReligionDropDown().sendKeys("National");
			Reporter.log("User has entered Religion value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Religion value.",true);
		}
	}
	
	@Test
	public static void provideCommunity() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayCommunityDropDown().selectByIndex(1);
			Reporter.log("User has entered Community value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Community value.",true);
		}
	}
	
	@Test
	public static void provideCaste() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayCasteDropDown().selectByIndex(1);
			Reporter.log("User has entered Caste value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Caster value.",true);
		}
	}
	
	@Test
	public static void provideMainAddress() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayMainAddressInputField().sendKeys("Ichalkaranji");
			Reporter.log("User has entered Address value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Address value.",true);
		}
	}
	
	@Test
	public static void provideCountry() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayCasteDropDown().selectByIndex(1);
			Reporter.log("User has entered Country value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Country value.",true);
		}
	}
	
	@Test
	public static void provideState() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayCasteDropDown().selectByIndex(1);
			Reporter.log("User has entered State value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to State Gender value.",true);
		}
	}
	
	@Test
	public static void provideCity() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayCasteDropDown().selectByIndex(1);
			Reporter.log("User has entered City value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide City value.",true);
		}
	}
	
	@Test
	public static void provideEmergencyContactNumber() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayEmergencyContactNumberInputField().sendKeys(thirdPartyEmergencyLeadMobile);
			Reporter.log("User has entered Emergency Contact Number value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Emergency Contact Number value.",true);
		}
	}
	
	@Test
	public static void provideEmergencyEmail() throws Exception
	{
		try 
		{
			Page_DetailedApplicationForm.displayEmergencyEmailInputField().sendKeys(thirdPartyEmergencyLeadEmail);
			Reporter.log("User has entered Emergency Email value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Emergency Email value.",true);
		}
	}
	
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
	public static void validateProvidedDataInStep1() throws InterruptedException, SQLException
	{
		System.out.println("\n"+"*********************** Validating information filled up in Step 1 ***************************"+"\n");

		try {
			System.out.println("--------------Validating Date of Birth--------------");
			System.out.println("Provided DoB: "+providedDOB);
			//Intentional Pause
			Thread.sleep(2000);
			String actualDOB = extractDataFromDatabase("userDOB");
			System.out.println("DoB value frm DB: "+actualDOB);
			Assert.assertEquals(providedDOB, actualDOB.substring(0, 10));
			Reporter.log("Provided DOB matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided DOB doesn't match the value stored in database.",true);
		}
		
		try {
			System.out.println("--------------Validating Blood Group--------------");
			System.out.println("Provided Blood Group: "+blGroup);
			//Intentional Pause
			Thread.sleep(1000);
			String actualBLGrp = extractDataFromDatabase("userBloodGrp");
			System.out.println("Blood Group value frm DB: "+actualBLGrp);
			Assert.assertEquals(blGroup, actualBLGrp);
			Reporter.log("Provided Blood Group matches the value stored in database.",true);
		} catch (org.openqa.selenium.NoSuchElementException | AssertionError e) {
			e.printStackTrace();
			Assert.fail();
			Reporter.log("Provided Blood Group doesn't match the value stored in database.",true);
		}
	}
	
	
	/********************* STEP 2 *************************/
	
	@Test
	public static void provideFathersName() throws Exception
	{
		System.out.println("\n"+"*********************** Filling up Step 2 Information ***************************"+"\n");

		try 
		{
			Page_DetailedApplicationForm.displayFathersNameInputField().sendKeys("Fathers Name Input Field");
			Reporter.log("User has entered Fathers Name value successfully.",true);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("User has failed to provide Fathers Name value.",true);
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
