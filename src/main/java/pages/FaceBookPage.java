package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FaceBookPage extends StartupPage {
	//please write all the locators for facebook page only 

	By loginButton = By.xpath(""); 
	By emailAddsPhoneNumberTextbox = By.xpath(""); 
	By passwordTextbox = By.xpath(""); 
	By profileIconImage = By.xpath(""); 
	By logoutButton = By.xpath(""); 
	By forgettenPasswordLink = By.xpath(""); 
	By createNewAccountLink = By.xpath(""); 
	By emailTextField = By.id(""); 
	By errorMessageWithoutCredential = By.xpath(""); 
	By errorMessageWithoutCredentialForgetPassword = By.xpath(""); 
	By withoutPasswordErrorMessage = By.xpath("");

	By createNewAccount = By.xpath(""); 
	By signUpButton = By.xpath(""); 
	By nameFieldErorMessage = By.xpath(""); 
	By firstNameTextField = By.xpath(""); 
	By surNameTextField = By.xpath(""); 
	By mobileNumberAndPassword = By.xpath(""); 
	By newPassword = By.xpath(""); 
	By selectDateFromDateDropdown = By.xpath(""); 
	By selectBirthdayMonth = By.xpath("");
	By selectBirthDayYear = By.xpath("");
	By customRadioButton = By.xpath("");
	By selectYourPronounDropdown = By.xpath("");
	By genderOptionalTextBox = By.xpath("");
	By selectFemaleRadioButton = By.xpath("");
	By selectMaleRadioButton = By.xpath("");
	By closeSignupPageImage = By.xpath("");
	By profile = By.xpath(""); 
	By profileName = By.xpath(""); 
	By updateProfilePicture = By.xpath(""); 
	By uploadPhoto = By.xpath(""); 
	By saveButton = By.xpath(""); 
	By editProfileButton=By.xpath("");
	By addButtonInsideBioSection=By.xpath("");
	By describeWhoAreYouTextField=By.xpath("");
	By saveButtonPresentInsideTheBioSection=By.xpath("");
	By xButton=By.xpath("");
	By addBioButton=By.xpath("");
	By aboutSection=By.xpath("");
	By workAndEducationSection=By.xpath("");
	By addUniversityIcon=By.xpath("");
	By schoolTextField=By.xpath("");
	By upperArrowButtonToHideTheYouMayKnowSection=By.xpath("");
	By addWorkplaceButton=By.xpath("");
	By companyTextField=By.xpath("");	
	By addCurrentCityButton=By.xpath("");
	By currentCityTextField=By.xpath("");
	By addHomeTownButton=By.xpath("");
	By homeTownTextField=By.xpath("");
	By cancelButton=By.xpath("");
	By addSecondarySchoolButton=By.xpath("");
	By schoolTextFieldPresentInsideSecondarySchoolTextField=By.xpath("");
	By addRelationshipStatusButton=By.xpath("");
	By stausDropdown=By.xpath("");
	By selectSingle=By.xpath("");
	By accountIcon=By.xpath("");
	By leavePageButton=By.xpath("");
	By LogoutButton=By.xpath("");
	By updateProfilePictureCameraIcon = By.xpath(""); 
	By uploadPhotoButton = By.xpath(""); 
	By notificationLink=By.xpath("");


	
	By errorMessageWithoutCredential1 = By.xpath(""); 
	
	By withoutPasswordErrorMessage1 = By.xpath("");


	


	public FaceBookPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this); // Initialize Page Factory
		// TODO Auto-generated constructor stub
	}


	/** @test1
	 * about this method validateFacebookTitleOfLoginPage() 
	 * @param : null
	 * @description : it is getting the page title and return the same,
	 * @return : title of string type
	 * @author : Yaksha
	 */
	public String validateFacebookTitleOfLoginPage() throws Exception {
		return null;

	}

	/**@test2
	 * about this method verifyPresenceOfALlFields() 
	 * @param : null
	 * @description : it is verify all fields is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifyPresenceOfALlFields() throws Exception {
		return null;
	}

	/**@test3
	 * about this method validateErrorMessageWithoutProvideAnyCredentials() 
	 * @param : null
	 * @description : it is getting the error message if login button clicked without passing email and password
	 * @return : errorMessage as string type
	 * @author : Yaksha
	 */
	public String validateErrorMessageWithoutProvideAnyCredentials() throws Exception {
		return null;
	}

	/**
	 * about this method enterEmailIdOrPhoneNumberInLoginPage() 
	 * @param : Map<String, String> expectedData
	 * @description : enter EmailIdOrPhoneNumber in the EmailIdOrPhoneNumber text field of the login page as per json expected data ,
	 * @return : null
	 * @author : Yaksha
	 */
	public boolean enterEmailIdOrPhoneNumberInLoginPage(Map<String, String> expectedData) throws Exception {
		return false;
	}

	/**@test4
	 * about this method validateErrorMessageWithoutProvidePassword() 
	 * @param : null
	 * @description : it is getting the error message and validate the error message ,
	 * @return : errorMessage as string type
	 * @author : Yaksha
	 */
	public String validateErrorMessageWithoutProvidePassword(Map<String, String> expectedData) throws Exception {
		return null;
	}

	/**
	 * about this method enterPassword() 
	 * @param : Map<String, String> expectedData
	 * @description : enter password in the password text field of the login page as per json expected data ,
	 * @return : null
	 * @author : Yaksha
	 */
	public boolean enterPasswordInLoginPage(Map<String, String> expectedData) throws Exception {
		return false;
	}

	/**@test5
	 * about this method validateErrorMessageWithoutProvideEmailOrPhoneNumber() 
	 * @param : null
	 * @description : it is getting the error message and validate the error message ,
	 * @return : errorMessage as string type
	 * @author : Yaksha
	 */
	public String validateErrorMessageWithoutProvideEmailOrPhoneNumber() throws Exception {
		return null;
	}

	/**@test6
	 * about this method goBackToLogInPageAndValidateCreateNewAccountButtonIsPresentOrNot() 
	 * @param : null
	 * @description : here go back to the login page and verify whether the NewAccountButton element is present or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean goBackToLogInPageAndValidateCreateNewAccountButtonIsPresentOrNot() throws Exception {
		return null;
	}

	/**@test7
	 * about this method validateNavigateToTheSignUpPage() 
	 * @param : null
	 * @description : click on the createnew account and validate the sign up page title ,
	 * @return : title of string type
	 * @author : Yaksha
	 */
	public String validateNavigateToTheSignUpPage() throws Exception {
		return null;

	}

	/**@test8
	 * about this method verifyPresenceOfAllFieldsPresentInTheSignUpPage() 
	 * @param : null
	 * @description : verify all fields are present in the signup page or not ,
	 * @return : boolean
	 * @author : Yaksha
	 */
	public Boolean verifyPresenceOfAllFieldsPresentInTheSignUpPage() throws Exception {
		return null;
	}

	/**@test9
	 * about this method enterDataInFirstNameFieldSignupPage() 
	 * @param : Map<String, String>
	 * @description : Enter data in the first name text field of the Signup page,
	 * @return : String
	 * @author : Yaksha
	 */
	public  String enterDataInFirstNameFieldSignupPage( Map<String, String> expectedData) throws Exception {
		return null;
	}

	/**@test10
	 * about this method enterDataInSignUpPage() 
	 * @param : Map<String, String>
	 * @description : enter data in the  SignUpPage page,
	 * @return : null
	 * @author : Yaksha
	 *
	 */
	public  boolean enterDataInSignUpPage( Map<String, String> expectedData) throws Exception {
		return false;
	}

	/**@test11
	 * about this method selectDateFromDateDropdownAndVerifyDateDropdownIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select any date from date dropdown and verify Date Dropdown is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectDateFromDateDropdownAndVerifyDateDropdownIsPrsentOrNot() throws Exception {
		return null;
	}

	/**@test12
	 * about this method selectAnyMonthFromMonthDropdownAndVerifyMonthDropdownIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select any month from month dropdown and verify month Dropdown is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectAnyMonthFromMonthDropdownAndVerifyMonthDropdownIsPrsentOrNot() throws Exception {
		return null;
	}

	/**@test13
	 * about this method selectAnyYearFromYearDropdownAndVerifyYearDropdownIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select any Year from Year dropdown and verify Year Dropdown is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectAnyYearFromYearDropdownAndVerifyYearDropdownIsPrsentOrNot() throws Exception {
		return null;
	}

	/**@test14
	 * about this method selectCustomRadioButtonAndVerifyCustomRadioButtonIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select "custom" radio button and verify "custom" radio button is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectCustomRadioButtonAndVerifyCustomRadioButtonIsPrsentOrNot() throws Exception {
		return null;
	}

	/**@test15
	 * about this method selectAnyOptionFromYourPronouDropdownAndVerifyYourPronouDropdownIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select any option from "SelectYourPronoun" dropdown and verify "SelectYourPronoun" is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectAnyOptionFromYourPronouDropdownAndVerifyYourPronouDropdownIsPrsentOrNot() throws Exception {
		return null;
	}

	/**@test16
	 * about this method enterValueInGenderOptionalTextFieldAndValidateGenderOptionalTextFieldIsPresentOrNot() 
	 * @param : null
	 * @description : send the value in In Gender Optional TextField and verify Gender Optional TextField is present or not
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean enterValueInGenderOptionalTextFieldAndValidateGenderOptionalTextFieldIsPresentOrNot(Map<String, String> expectedData) throws Exception {
		return null;
	}

	/**@test17
	 * about this method selectFemaleRadioButtonAndVerifyFemaleRadioButtonIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select "Female" radio button and verify "Female" radio button is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectFemaleRadioButtonAndVerifyFemaleRadioButtonIsPrsentOrNot() throws Exception {
		return null;
	}

	/**@test18
	 * about this method selectMaleRadioButtonAndVerifyMaleRadioButtonIsPrsentOrNot() 
	 * @param : null
	 * @description : it is select "Male" radio button and verify "male" radio button is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean selectMaleRadioButtonAndVerifyMaleRadioButtonIsPrsentOrNot() throws Exception {
		return null;
	}

	/**@test19
	 * about this method verifyAllprsenceOfFieldAfterCloseTheSignupPage() 
	 * @param : null
	 * @description : close the sign up page and verify all fields is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifyAllprsenceOfFieldAfterCloseTheSignupPage() throws Exception {
		return null;
	}

	/**@test20
	 * about this method enterValidEmail_PasswordInTextFieldAndVerifyLoginButtonIsPresentOrNot() 
	 * @param : Map<String, String> expectedData (getting the data from the expected Json file
	 * @description : enter the username and password in the corresponding Text filed and verify login button is present or not
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean enterValidEmail_PasswordInTextFieldAndVerifyLoginButtonIsPresentOrNot(Map<String, String> expectedData) throws Exception {
		return null;
	}

/**@Test21
	 * about this method loginToFacebookByGivenValidCredetial() 
	 * @param : Map<String, String>
	 * @description : fill emailAddsPhoneNumberTextbox then enter data in passwordTextbox and click on login button
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public boolean loginToFacebookByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		return false;
	}

	/**@Test22
	 * about this method afterLoggedinValidateTheTitleOfFacebookHomePage() 
	 * @param : null
	 * @description : print the title of the home page after logged in and verify the title of the home page
	 * @return : String
	 * @author : Yaksha
	 */
	public String afterLoggedinValidateTheTitleOfFacebookHomePage() throws Exception {
		return null;

	}

	/**@Test23
	 * about this method clickonProfileIconAndValidateTheProfileName() 
	 * @param : null
	 * @description :click on the profile and validate the profile name
	 * @return : String
	 * @author : Yaksha
	 */
	public String clickonProfileAndValidateTheProfileName() throws Exception {
		return null;

	}

	/**@Test24
	 * about this method clickOnUpdateProfilePicture_and_UploadProfilePicture() 
	 * @param : String
	 * @description :click on update profile picture and click on upload photo and upload photo then click on save button.
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnUpdateProfilePictureAndUploadProfilePicture(String filePath) throws Exception {
		return false;
	}

	/**@Test25
	 * about this method clickOnEditProfileAndFillTheDetailInBioSection() 
	 * @param : Map<String, String> 
	 * @description :Click on edit profile then click on the add button inside the bio section and enter data in bio section then click on "X" button.
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnEditProfileAndFillTheDetaFilInBioSection(Map<String, String> expectedData) throws Exception {
		return false;
	}

	/**@Test26
	 * about this method clickOnPostsandGoToIntroSectionAndAddDetailsInAddBio() 
	 * @param : String
	 * @description :Click on edit profile then click on the add button inside the bio section and enter data in bio section then click on "X" button.
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnPostsandGoToIntroSectionAndAddDetailsInAddBio(Map<String, String> expectedData) throws Exception {
		return false;

	}

	/**@Test27
	 * about this method clickOnAboutAndGoIntoOverviewAndAddUniversity() 
	 * @param : Map<String, String>
	 * @description :Click on about section then go to overview section then click on addUniversityIcon then enter data in the school text field.
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnAboutAndGoIntoOverviewAndAddUniversity(Map<String, String> expectedData) throws Exception {
		return false;

	}


	/**@Test28
	 * about this method clickonAddWorkplaceAndAddCompanyName() 
	 * @param : Map<String, String>
	 * @description :Click on about section then go to overview section then click on addUniversityIcon then enter data in the school text field.
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickonAddWorkplaceAndAddCompanyName(Map<String, String> expectedData) throws Exception {
		return false;

	}
	/**@Test29
	 * about this method clickOnAddHomeTownandAddHomeTown() 
	 * @param : Map<String, String>
	 * @description :Refresh the page and click on upper arrow button to hide the you may know section 
	 * 				then click on addHomeTownButton and fill data in the homeTownTextField. 
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnAddHomeTownandAddHomeTown(Map<String, String> expectedData) throws Exception {
		return false;

	}

	/**@Test30
	 * about this method clickOnAddCurrentCityandAddCurrentCity() 
	 * @param : Map<String, String>
	 * @description :Refresh the page and click on upper arrow button to hide the you may know section 
	 * 				then click on add current city and fill data in the current city text field. 
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnAddCurrentCityandAddCurrentCity(Map<String, String> expectedData) throws Exception {
		return false;

	}

	/**@Test31
	 * about this method clickOnAddSecondarySchoolandAddSchool() 
	 * @param : Map<String, String>
	 * @description :Refresh the page and click on upper arrow button to hide the you may know section 
	 * 				then click on addSecondarySchoolButton and fill data in the schoolTextFieldPresentInsideSecondarySchoolTextField. 
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnAddSecondarySchoolandAddSchool(Map<String, String> expectedData) throws Exception {
		return false;

	}

	/**@Test32
	 * about this method clickOnAddRelationshipStatusandAddRelationshipStatusAsSingle() 
	 * @param : Map<String, String>
	 * @description :Refresh the page and click on upper arrow button to hide the you may know section 
	 * 				then click on addRelationshipStatusButton and Set the relationship status as single.
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickOnAddRelationshipStatusandAddRelationshipStatusAsSingle(Map<String, String> expectedData) throws Exception {
		return false;

	}

	/**@Test33
	 * about this method gotoThePreviousPageAndClickOnAccount() 
	 * @param : null
	 * @description : going to the previous page then click on leave page button and click on Account icon which is present at the top right corner
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean gotoThePreviousPageAndClickOnAccount() throws Exception {
		return false;
	}
	/**@Test34
	 * about this method clickOnTheLogoutButton() 
	 * @param : null
	 * @description : Click on the logout button 
	 * @return : boolean
	 * @author : Yaksha
	 */
	public boolean clickonTheLogoutButton() throws Exception {
		return false;
	}


	

}
