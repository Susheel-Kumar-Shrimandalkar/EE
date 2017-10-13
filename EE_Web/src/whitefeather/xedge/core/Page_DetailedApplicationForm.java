package whitefeather.xedge.core;

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
	public static ObjectMapping properties = new ObjectMapping(Constants.LOCATORS);
	
	/********************* STEP 1 *************************/
	
	public static WebElement displayDateOfBirthInputFieldStep1() throws Exception
	{
		try {
			element =driver.findElement(properties.selectLocator("Step1_DateOfBirth"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
		
	}
	
	public static WebElement displayDateOfBirthStep1() throws Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(properties.selectLocator("Step1_DayOfDateOfBirth")));
			//To be done later - past month logic
			dropdown  = new Select(driver.findElement((properties.selectLocator("Step1_SelectBirthMonth"))));
			dropdown.selectByIndex(1);
			element = driver.findElement(properties.selectLocator("Step1_DayOfDateOfBirth"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;
		
	}
		
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
			element = driver.findElement(properties.selectLocator("Step1_Natinality"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
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
	
	public static WebElement displayMainAddressInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_MainAddress"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static Select displayCountryDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_PresentCountry"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static Select displayStateDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_PresentState"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static Select displayCityDropDown() throws Exception
	{
		try {
			dropdown = new Select(driver.findElement((properties.selectLocator("Step1_PresentCity"))));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return dropdown;	
	}
	
	public static WebElement displayContactNumberInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_MainAddress"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayEmergencyContactNumberInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_EmergencyContactNumber"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}
		return element;	
	}
	
	public static WebElement displayEmergencyEmailInputField() throws Exception
	{
		try {
			element = driver.findElement(properties.selectLocator("Step1_EmergencyEmail"));
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
	
}
