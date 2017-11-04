package whitefeather.xedge.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;
import whitefeather.xedge.facilitator.HelperHand;

public class Page_DetailedApplicationForm extends HelperHand
{
	public static WebElement element;
	public static Select dropdown;
	public static int numericMonth = 0;
	public static String dob = "";
	public static final int dayInDob = DataGenerator.getRandomDayOfMonth();
	public static final int dayInDateOfIssue = DataGenerator.getRandomDayOfMonth();
	public static final int dayInExpiryDate = DataGenerator.getRandomDayOfMonth();
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);
	
	/********************* STEP 1 *************************/
	
	public static WebElement displayDateOfBirthInputField() throws Exception
	{
		//DB Format: 2017-02-22 00:00:00.000
		try {
			element =driver.findElement(properties.selectLocator("Step1_DateOfBirthCalendar"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
		
	}
	
	public static Select displayDOBMonthDropDown() throws Exception
	{
		try {
			dropdown  = new Select(driver.findElement((properties.selectLocator("Step1_SelectMonthDropdown"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static Select displayDOBYearDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_SelectYearDropdown"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static WebElement displayDaysOfMonthInDoB() throws Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("Step1_DayOfMonth")));
//			element = driver.findElement(properties.selectLocator("Step1_DayOfDateOfBirth"));
			element = driver.findElement(By.xpath(".//a[contains(text(),'"+dayInDob+"')]"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
		
	public static String getBirthMonthFromProvidedDOB(String mon) throws Exception
	{
		switch (mon) {
		case "Jan":
			numericMonth  = 1;
			break;
		case "Feb":
			numericMonth  = 2;
		case "Mar":
			numericMonth  = 3;
			break;
		case "Apr":
			numericMonth  = 4;
			break;
		case "May":
			numericMonth  = 5;
			break;
		case "Jun":
			numericMonth  = 6;
			break;
		case "Jul":
			numericMonth  = 7;
			break;
		case "Aug":
			numericMonth  = 8;
			break;
		case "Sep":
			numericMonth  = 9;
			break;
		case "Oct":
			numericMonth  = 10;
			break;
		case "Nov":
			numericMonth  = 11;
			break;
		case "Dec":
			numericMonth  = 12;
			break;
		default:
			break;
		}
		return Integer.toString(numericMonth);
	}
	
	/*
	public static String getProvideDateOfBirth() throws Exception
	{
		
		dob = displayDOBYearDropDown().getFirstSelectedOption().getText()+"-0"
				+getBirthMonthFromProvidedDOB(displayDOBMonthDropDown().getFirstSelectedOption().getText())
				+displayDaysOfMonth().getText();
		return dob;
	}*/
		/*			
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement ele:allDates)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase("28"))
			{
				ele.click();
				break;
			}
			
		}
		return element;
	*/

	public static WebElement displayPlaceOfBirthInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_PlaceOfBirth"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayAgeInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_Age"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayBloodGroupInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_BloodGroup"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static Select displayGenderDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_Gender"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;
	}
	
	public static WebElement displayAadhaarNumberInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_AadharNumber"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayCitizenshipInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_Citizenship"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayNationalityInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_Nationality"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayPassportNumberInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_PassportNum"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	

	public static WebElement displayPlaceOfIssueInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_PlaceOfIssue"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayDateOfIssueInputField() throws Exception
	{
		//DB Format: 2017-02-22 00:00:00.000
		try {
			element =driver.findElement(properties.selectLocator("Step1_DateOfIssueCalendar"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
		
	}
	
	public static Select displayDateOfIssueMonthDropDown() throws Exception
	{
		try {
			dropdown  = new Select(driver.findElement((properties.selectLocator("Step1_SelectMonthDropdown"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static Select displayDateOfIssueYearDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_SelectYearDropdown"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static WebElement displayDaysOfMonthInDateOfIssue() throws Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("Step1_DayOfMonth")));
			element = driver.findElement(By.xpath(".//a[contains(text(),'"+dayInDateOfIssue+"')]"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
		
	public static String getMonthFromProvidedDateOfIssue(String mon) throws Exception
	{
		switch (mon) {
		case "Jan":
			numericMonth  = 1;
			break;
		case "Feb":
			numericMonth  = 2;
		case "Mar":
			numericMonth  = 3;
			break;
		case "Apr":
			numericMonth  = 4;
			break;
		case "May":
			numericMonth  = 5;
			break;
		case "Jun":
			numericMonth  = 6;
			break;
		case "Jul":
			numericMonth  = 7;
			break;
		case "Aug":
			numericMonth  = 8;
			break;
		case "Sep":
			numericMonth  = 9;
			break;
		case "Oct":
			numericMonth  = 10;
			break;
		case "Nov":
			numericMonth  = 11;
			break;
		case "Dec":
			numericMonth  = 12;
			break;
		default:
			break;
		}
		return Integer.toString(numericMonth);
	}	
	
	
	public static WebElement displayExpiryDateInputField() throws Exception
	{
		//DB Format: 2017-02-22 00:00:00.000
		try {
			element =driver.findElement(properties.selectLocator("Step1_ExpiryDateCalendar"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
		
	}
	
	public static Select displayExpiryDateMonthDropDown() throws Exception
	{
		try {
			dropdown  = new Select(driver.findElement((properties.selectLocator("Step1_SelectMonthDropdown"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static Select displayExpiryDateYearDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_SelectYearDropdown"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static WebElement displayDaysOfMonthInExpiryDate() throws Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("Step1_DayOfMonth")));
			element = driver.findElement(By.xpath(".//a[contains(text(),'"+dayInExpiryDate+"')]"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
	}
		
	public static String getMonthFromProvidedExpiryDate(String mon) throws Exception
	{
		switch (mon) {
		case "Jan":
			numericMonth  = 1;
			break;
		case "Feb":
			numericMonth  = 2;
		case "Mar":
			numericMonth  = 3;
			break;
		case "Apr":
			numericMonth  = 4;
			break;
		case "May":
			numericMonth  = 5;
			break;
		case "Jun":
			numericMonth  = 6;
			break;
		case "Jul":
			numericMonth  = 7;
			break;
		case "Aug":
			numericMonth  = 8;
			break;
		case "Sep":
			numericMonth  = 9;
			break;
		case "Oct":
			numericMonth  = 10;
			break;
		case "Nov":
			numericMonth  = 11;
			break;
		case "Dec":
			numericMonth  = 12;
			break;
		default:
			break;
		}
		return Integer.toString(numericMonth);
	}	
	
	
	
	
	
	public static Select displayDomicileDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_Domicile"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static WebElement displayReligionDropDown() throws Exception
	{
		try {
			element = (driver.findElement((properties.selectLocator("Step1_Religion"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}

	public static Select displayCommunityDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_Community"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static Select displayCasteDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_Caste"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static WebElement displayPresentAddressInputFieldStep1() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_MainAddress"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static Select displayPresentAddrCountryDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_PresentCountry"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static Select displayPresentAddrStateDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_PresentState"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static Select displayPresentAddrCityDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_PresentCity"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static WebElement displayPresentAddrPincodeInputField() throws Exception
	{
		try {
			element = driver.findElement((properties.selectLocator("Step1_PresentPincode")));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayPresentAddrContactNumberInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_PresentAddrContactNumber"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displaySameAddressCheckboxStep1() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_SameAddressCheckbox"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayAlternateAddress1InputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_AlternateAddress1"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayAlternateAddress2InputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_AlternateAddress2"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayAlternateContactNumberInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_AlternateContact"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayNextButtonStep1() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_NextButton"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	/********************* STEP 2 *************************/
	
	public static WebElement displayFathersNameInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step2_FathersName"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayFathersQualificationInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step2_FathersQualification"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayFathersOccupationInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step2_FathersOccupation"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayMothersNameInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step2_MothersName"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayGuardiansNameInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step2_GuardianName"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayGuardiansAddress1InputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step2_GuardianAddress1"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayGuardiansAddress2InputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step2_GuardianAddress2"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayGuardiansContactNumberInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step2_GuardianContactNumber"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayGuardianRelationInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step2_GuardianRelation"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayNextButtonStep2() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step2_NextButton"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	/********************* STEP 3 *************************/
	
	public static Select displaySelectCourseDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step3_SelectCourse"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static WebElement displaySSCSchoolNameInputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_SSCSchoolName"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displaySSCRegNumberInputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_RegNumberSSC"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static Select displaySSCYearOfPassingDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step3_SSCYoP"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static WebElement displaySSCPercentageInputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_SSCPercentage"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static Select displaySSCModeOfStudyDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step3_ModeOfStudySSC"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static WebElement displayHSCSchoolNameInputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_HSCSchoolName"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayHSCRegNumberInputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_RegNumberHSC"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static Select displayHSCYearOfPassingDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step3_HSCYoP"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static WebElement displayHSCPercentageInputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_HSCPercentage"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static Select displayHSCModeOfStudyDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step3_ModeOfStudyHSC"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static WebElement displayEntranceExamInputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_EntranceExam"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displaySubject1InputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Subject1"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayMarks1InputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Marks1"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayPercentage1InputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Percentage1"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displaySubject2InputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Subject2"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayMarks2InputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Marks2"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayPercentage2InputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Percentage2"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displaySubject3InputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Subject3"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayMarks3InputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Marks3"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayPercentage3InputField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Percentage3"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayAttachment1Button() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Attachment1"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayAttachment2Button() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Attachment2"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayAttachment3Button() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Attachment3"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayAttachment4Button() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Attachment4"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayAttachment5Button() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step3_Attachment5"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayNextButtonStep3() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step3_NextButton"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
/********************* STEP 3 *************************/
	
	public static Select displayPaymentTypeDropdownDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step4_PaymentType"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static WebElement displayPaymentAmountField() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step4_PaymentAmount"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displaySubmitButtonStep4() throws Exception
	{	
		try {
			element = driver.findElement(properties.selectLocator("Step4_SubmitButton"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
}
