

package testcases;

import java.util.Map;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;
import pages.FaceBookPage;

import pages.StartupPage;
import testBase.AppTestBase;
import testdata.LocatorsFactory;

public class Facebook_AutomationTest extends AppTestBase {
	
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath+"expected_data.json";
	StartupPage startupPage;
	FaceBookPage FaceBookPageInstance;
	LocatorsFactory LocatorsFactoryInstance = new LocatorsFactory(driver);
	
	
	@Parameters({"browser", "environment"})
	@BeforeClass(alwaysRun = true)
	public void initBrowser(String browser, String environment) throws Exception {
		configData = new FileOperations().readJson(config_filePath, environment);
		configData.put("url", configData.get("url").replaceAll("[\\\\]", ""));
		configData.put("browser", browser);
		
		boolean isValidUrl = new ApiHelper().isValidUrl(configData.get("url"));
		Assert.assertTrue(isValidUrl, configData.get("url")+" might be Server down at this moment. Please try after sometime.");
		initialize(configData);
		startupPage = new StartupPage(driver);
	}
	
	@Test(priority = 1, groups = {"sanity"}, description="Navigate to the URL and Validate the fa LogIn Page Title")
	public void validateFacebookTitleofLoginPage() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);	
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "LoginPage_Title");
		Assert.assertEquals(FaceBookPageInstance.validateFacebookTitleOfLoginPage(), expectedData.get("loginpageTitle"));
		Assert.assertTrue(LocatorsFactoryInstance.getLoginButton(driver).isDisplayed(), "login button is not present in the current page, Please check manually");
	}
	
	@Test(priority = 2, groups = {"sanity"}, description="verify Presence Of All Fields in The Login Page")
	public void verifyPresenceOfAllFieldsinTheLoginPage() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		Assert.assertTrue(FaceBookPageInstance.verifyPresenceOfALlFields(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.getLoginButton(driver).isDisplayed(), "login button is not present in the current page, Please check manually");
	}
	
	
	@Test(priority = 3, groups = {"sanity"}, description="validate the error message, when user does not provide any credentials")
	public void validateErrorMessageWithoutProvideAnyCredentials() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "errorMessage");
		Assert.assertEquals(FaceBookPageInstance.validateErrorMessageWithoutProvideAnyCredentials(), expectedData.get("errorMessageText2"), "error message is not matching, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.emailTextField(driver).isDisplayed(), "Email Text Field is not present in the current page, Please check manually");
	}
	
	@Test(priority = 4, groups = {"sanity"}, description="Enter Email or Phone No in Email or Phone No Text field and click on Login and validate Error Message")
	public void validateErrorMessageWithoutProvidePassword() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "EmailOrPhoneNumber");
		FaceBookPageInstance.enterEmailIdOrPhoneNumberInLoginPage(expectedData1);
		Map<String, String> expectedData2 = new FileOperations().readJson(expectedDataFilePath, "errorMessages");
		Assert.assertTrue(FaceBookPageInstance.validateErrorMessageWithoutProvidePassword(expectedData2).contains(expectedData2.get("errorMessageText")), "Error message is not matching, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.getPasswordTextfield(driver).isDisplayed(), "Password Text Field is not present in the current page, Please check manually");
	}
	
	@Test(priority = 5, groups = {"sanity"}, description="Enter Password in password Text field and click on Login and validate Error Message")
	public void validateErrorMessageWithoutProvideEmailOrPhoneNumber() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "password");
		FaceBookPageInstance.enterPasswordInLoginPage(expectedData1);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "errorMessage");
		Assert.assertEquals(FaceBookPageInstance.validateErrorMessageWithoutProvideEmailOrPhoneNumber(), expectedData.get("errorMessageText1"), "error message is not matching, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.emailTextField(driver).isDisplayed(), "Email Text Field is not present in the current page, Please check manually");
	}
	
	@Test(priority = 6, groups = {"sanity"}, description="Go Back To LogIn Page And Validate CreateNewAccount button Is Present or not")
	public void goBackToLogInPageAndValidateCreateNewAccountButtonIsPresentOrNot() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		Assert.assertTrue(FaceBookPageInstance.goBackToLogInPageAndValidateCreateNewAccountButtonIsPresentOrNot(), "Create New Account Button is not present, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.getCreateNewAccount(driver).isDisplayed(), "Email Text Field is not present in the current page, Please check manually");
	}
	
	@Test(priority = 7, groups = {"sanity"}, description="Click on Create Account Button and Verify nevigate to the signUp page.")
	public void click_on_forgetten_account_link_then_validate_Email_adddress_Or_phone_number_field() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Sign_up_page");
		Assert.assertEquals(FaceBookPageInstance.validateNavigateToTheSignUpPage(), expectedData.get("Sign_up_page_title"), "page title is not matching, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.signUpButton(driver).isDisplayed(), "SignUp Button is not present in the current page, Please check manually");	
	}
	
	
	@Test(priority = 8, groups = {"sanity"}, description="verify first name,surname,Mobile Number email address,New password field are present in the signup page.")
	public void verifyAllFieldsArePresentInTheSignUpPage() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		Assert.assertTrue(FaceBookPageInstance.verifyPresenceOfAllFieldsPresentInTheSignUpPage(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.signUpButton(driver).isDisplayed(), "signUp button is not present in the current page, Please check manually");
	}
	@Test(priority = 9, groups = {"sanity"}, description="Enter data in the first name field")
	public void enterFirstNameInFirstNameTextFieldOfTheSignupPage() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "createNewAccountDetails");
		FaceBookPageInstance.enterDataInFirstNameFieldSignupPage(expectedData1);
		Assert.assertTrue(LocatorsFactoryInstance.firstNameTextField(driver).isDisplayed(), "firstNameTextField is not present in the signU page, Please check manually");	
	}
	@Test(priority = 10, groups = {"sanity"}, description="Enter data (Read the data from Json File)in the surname,Mobile Number email address,New password field.")
	public void enterValueInSignupPage() throws Exception {	
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "createNewAccountDetails");
		FaceBookPageInstance.enterDataInSignUpPage(expectedData1);
		Assert.assertTrue(LocatorsFactoryInstance.newpasswordTextField(driver).isDisplayed(), "newpassword TextField is not present in the signUp page, Please check manually");	
	}
	
	@Test(priority = 11, groups = {"sanity"}, description="Select any date from date dropdown field and and verify the date dropdown is present or not")
	public void selectAnyDateFromDateDropdownAndVerifyDateDropdownIsPrsentOrNot() throws Exception {	
		FaceBookPageInstance = new FaceBookPage(driver);
		Assert.assertTrue(FaceBookPageInstance.selectDateFromDateDropdownAndVerifyDateDropdownIsPrsentOrNot(), "Date Dropdown element is not present, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.selectBirthDayMonth(driver).isDisplayed(), " BirthDay Month dropdown is not present in the signUp page, Please check manually");	
	}
	
	@Test(priority = 12, groups = {"sanity"}, description="Select any Month from month dropdown field and and verify the Month dropdown is present or not")
	public void selectAnyMonthFromMonthDropdownAndVerifyMonthDropdownIsPrsentOrNot() throws Exception {	
		FaceBookPageInstance = new FaceBookPage(driver);
		Assert.assertTrue(FaceBookPageInstance.selectAnyMonthFromMonthDropdownAndVerifyMonthDropdownIsPrsentOrNot(), "Month Dropdown element is not present, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.selectBirthDayYear(driver).isDisplayed(), " Birthday Year dropdown is not present in the signUp page, Please check manually");	
	}
	
	@Test(priority = 13, groups = {"sanity"}, description="Select any Year from the Year dropdown field and and verify the Year dropdown is present or not")
	public void selectAnyYearFromYearDropdownAndVerifyYearDropdownIsPrsentOrNot() throws Exception {	
		FaceBookPageInstance = new FaceBookPage(driver);
		Assert.assertTrue(FaceBookPageInstance.selectAnyYearFromYearDropdownAndVerifyYearDropdownIsPrsentOrNot(), "Year Dropdown element is not present, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.femaleRadioButton(driver).isDisplayed(), " Female Radio Button is not present in the signUp page, Please check manually");	
	}
	
	@Test(priority = 14, groups = {"sanity"}, description="select \"Custom\" radio button and validate \"Custom\" radio button is present or not")
	public void selectCustomRadioButtonAndVerifyCustomRadioButtonIsPrsentOrNot() throws Exception {	
		FaceBookPageInstance = new FaceBookPage(driver);
		Assert.assertTrue(FaceBookPageInstance.selectCustomRadioButtonAndVerifyCustomRadioButtonIsPrsentOrNot(), "Custom Radio button element is not present, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.selectYourPronounDropdown(driver).isDisplayed(), " selectYourPronoun Dropdown is not present in the signUp page, Please check manually");	
	}
	
	@Test(priority = 15, groups = {"sanity"}, description="select any option from the \"Select your pronoun\" dropdown and verify \"Select your pronoun\" dropdown\" is present or not")
	public void selectAnyOptionFromYourPronouDropdownAndVerifyYourPronouDropdownIsPrsentOrNot() throws Exception {	
		FaceBookPageInstance = new FaceBookPage(driver);
		Assert.assertTrue(FaceBookPageInstance.selectAnyOptionFromYourPronouDropdownAndVerifyYourPronouDropdownIsPrsentOrNot(), "Custom Radio button element is not present, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.genderOptionalTextBox(driver).isDisplayed(), " Gender Optional TextBox is not present in the signUp page, Please check manually");	
	}
	
	@Test(priority = 16, groups = {"sanity"}, description="Enter Value in \"Gender Optional\" Textfield and verify \"Gender Optional\" Textfield is present or not")
	public void enterValueInGenderOptionalTextFieldAndValidateGenderOptionalTextFieldIsPresentOrNot() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Gender_Optional_TextField_data");
		FaceBookPageInstance.enterValueInGenderOptionalTextFieldAndValidateGenderOptionalTextFieldIsPresentOrNot(expectedData);
		Assert.assertTrue(LocatorsFactoryInstance.femaleRadioButton(driver).isDisplayed(), "female Radio Button is not present in the current page, Please check manually");
	}
	
	@Test(priority = 17, groups = {"sanity"}, description="select \"Female\" radio button and validate \"Female\" radio button is present or not")
	public void selectFemaleRadioButtonAndVerifyFemaleRadioButtonIsPrsentOrNot() throws Exception {	
		FaceBookPageInstance = new FaceBookPage(driver);
		Assert.assertTrue(FaceBookPageInstance.selectFemaleRadioButtonAndVerifyFemaleRadioButtonIsPrsentOrNot(), "Female Radio button element is not present, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.maleRadioButton(driver).isDisplayed(), " male radio button is not present in the signUp page, Please check manually");	
	}
	
	@Test(priority = 18, groups = {"sanity"}, description="select \"Male\" radio button and validate \"Male\" radio button is present or not")
	public void selectMaleRadioButtonAndVerifyFemaleRadioButtonIsPrsentOrNot() throws Exception {	
		FaceBookPageInstance = new FaceBookPage(driver);
		Assert.assertTrue(FaceBookPageInstance.selectMaleRadioButtonAndVerifyMaleRadioButtonIsPrsentOrNot(), "Male Radio button element is not present, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.customRadioButton(driver).isDisplayed(), " male radio button is not present in the signUp page, Please check manually");	
	}
	
	@Test(priority = 19, groups = {"sanity"}, description="close the \"signup\" page and verify the All Fields present in The Login Page or not")
	public void verifyAllprsenceOfFieldAfterCloseTheSignupPage() throws Exception {	
		FaceBookPageInstance = new FaceBookPage(driver);
		Assert.assertTrue(FaceBookPageInstance.verifyAllprsenceOfFieldAfterCloseTheSignupPage(), "Any of the elememt is not present, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.getLoginButton(driver).isDisplayed(), " login button is not present in the signUp page, Please check manually");	
	}
	
	@Test(priority = 20, groups = {"sanity"}, description="Enter valid email or phone no in  email or phone no text field and enter password in password textfield and validate \"login\" button is present or not")
	public void enterValidEmail_PasswordInTextFieldAndVerifyLoginButtonIsPresentOrNot() throws Exception {	
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "credentials");
		Assert.assertTrue(FaceBookPageInstance.enterValidEmail_PasswordInTextFieldAndVerifyLoginButtonIsPresentOrNot(expectedData), "login button is not present, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.createNewAccountLink(driver).isDisplayed(), " login button is not present in the signUp page, Please check manually");
	}

	@Test(priority = 21, groups = {"sanity"}, description="login the facebook by given valid credetial")
	public void loginTheFacebookByGivenValidCredetial() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "logInCredential");
		Assert.assertTrue(FaceBookPageInstance.loginToFacebookByGivenValidCredetial(expectedData1),"Login failed, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.accountIconIsPresent(driver).isDisplayed(), "accountIcon is not present, Please check manually");	
	}
	@Test(priority = 22, groups = {"sanity"}, description="after Logged In, Validate the title of Facebook Home Page")
	public void afterLoggedInValidateTheTitleOfFacebookHomePage() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "logInCredential");
		Assert.assertEquals(FaceBookPageInstance.afterLoggedinValidateTheTitleOfFacebookHomePage(), expectedData.get("pageTitle_after_loggedin"));
		Assert.assertTrue(LocatorsFactoryInstance.accountIconIsPresent(driver).isDisplayed(), "accountIcon is not present, Please check manually");	
	}
	
	@Test(priority = 23, groups = {"sanity"}, description="ClickOn Profile Icon and Validate the Profile Name")
	public void clickOnProfileAndValidateTheProfileName() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "logInCredential");
		Assert.assertEquals(FaceBookPageInstance.clickonProfileAndValidateTheProfileName(), expectedData.get("ProfileName"));
		Assert.assertTrue(LocatorsFactoryInstance.editProfileButtonIsPresent(driver).isDisplayed(), "Edit profile button is not present, Please check manually");	
	}
	@Test(priority = 24, groups = {"sanity"}, description="Upload a profile Picture ")
	public void clickOnUpdateProfilePictureAndUploadProfilePicture() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "PathOfTheImage");
		Assert.assertTrue(FaceBookPageInstance.clickOnUpdateProfilePictureAndUploadProfilePicture(), "file upload failed, please check manually");	
		Assert.assertTrue(LocatorsFactoryInstance.editProfileButtonIsPresent(driver).isDisplayed(), "Edit profile button is not present, Please check manually");	
	}
	@Test(priority = 25, groups = {"sanity"}, description="click On Edit Profile And fill The Detail In Bio Section")
	public void clickOnEditProfileandillTheDetailInBioSection() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "logInCredential");
	    Assert.assertTrue(FaceBookPageInstance.clickOnEditProfileAndFillTheDetaFilInBioSection(expectedData1),"Not able to add the bio section, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.addToStoryButtonIsPresent(driver).isDisplayed(), "addToStory Button button is not present, Please check manually");	
	}
	@Test(priority = 26, groups = {"sanity"}, description="click On Posts and Go to Intro Section and Add Details In Add Bio")
	public void clickOnPostsAndGoToIntroSectionAndAddDetailsInAddBio() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "logInCredential");
	    Assert.assertTrue(FaceBookPageInstance.clickOnPostsandGoToIntroSectionAndAddDetailsInAddBio(expectedData1),"Not able to add the bio section, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.editDetailsFieldIsPresent(driver).isDisplayed(), "Edit details button is not present, Please check manually");	
	}
	
	@Test(priority = 27, groups = {"sanity"}, description="click On About and Go Into overview and Education and add university")
	public void clickOnAboutAndGoIntoOverviewAndAddUniversity() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "logInCredential");
	    Assert.assertTrue(FaceBookPageInstance.clickOnAboutAndGoIntoOverviewAndAddUniversity(expectedData1),"Not able to add the university, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.workAndEducationIconIsPresent(driver).isDisplayed(), "Work and Education button is not present, Please check manually");	
	}
	@Test(priority = 28, groups = {"sanity"}, description="Click on add a workplace and add company name")
	public void clickOnAddWorkplaceAndAddCompanyName() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "About_Section");
	    Assert.assertTrue(FaceBookPageInstance.clickonAddWorkplaceAndAddCompanyName(expectedData1),"Not able to add the company name, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.companyTextFieldIsPresent(driver).isDisplayed(), "company TextField button is not present, Please check manually");	
	}
	@Test(priority = 29, groups = {"sanity"}, description="Click on add home town and add home town")
	public void clickOnAddHomeTownAndAddHomeTown() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "About_Section");
	    Assert.assertTrue(FaceBookPageInstance.clickOnAddHomeTownandAddHomeTown(expectedData1),"Not able to add the Home town, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.homeTownTextFieldIsPresent(driver).isDisplayed(), "HomeTown TextField button is not present, Please check manually");	
	}
	@Test(priority = 30, groups = {"sanity"}, description="Click on add a current city and add current city")
	public void clickOnAddCurrentCityAndAddCurrentCity() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "About_Section");
	    Assert.assertTrue(FaceBookPageInstance.clickOnAddCurrentCityandAddCurrentCity(expectedData1),"Not able to add the Current City, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.currentCityTextFieldIsPresent(driver).isDisplayed(), "HomeTown TextField button is not present, Please check manually");	
	}
	@Test(priority = 31, groups = {"sanity"}, description="Click on Add secondary school and add school")
	public void clickOnAddSecondarySchoolAndAddSchool() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "About_Section");
	    Assert.assertTrue(FaceBookPageInstance.clickOnAddSecondarySchoolandAddSchool(expectedData1),"Not able to add the School, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.schoolTextFieldPresentInsideSecondarySchoolTextFieldIsPresent(driver).isDisplayed(), "School TextField button is not present, Please check manually");	
	}
	@Test(priority = 32, groups = {"sanity"}, description="Click on add relationship status and add relationship status as single")
	public void clickOnAddRelationshipStatusAndAddRelationshipStatusAsSingle() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
		String expectedDataFilePath = testDataFilePath+"expected_data.json";
		Map<String, String> expectedData1 = new FileOperations().readJson(expectedDataFilePath, "About_Section");
	    Assert.assertTrue(FaceBookPageInstance.clickOnAddRelationshipStatusandAddRelationshipStatusAsSingle(expectedData1),"Not able to update the relationship status, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.workAndEducationIconIsPresent(driver).isDisplayed(), "Work and Education button is not present, Please check manually");	
	}
	@Test(priority = 33, groups = {"sanity"}, description="Go to the previous page and click on Account at the right top corner")
	public void goToThePreviousPageAndClickOnAccount() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
	    Assert.assertTrue(FaceBookPageInstance.gotoThePreviousPageAndClickOnAccount(),"Not able to click the Accout icon, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.logOutButtonIsPresent(driver).isDisplayed(), "LogOut button is not present, Please check manually");	
	}
	@Test(priority = 34, groups = {"sanity"}, description="After that click on logout button")
	public void clickOnLogoutButton() throws Exception {
		FaceBookPageInstance = new FaceBookPage(driver);
	    Assert.assertTrue(FaceBookPageInstance.clickonTheLogoutButton(),"logout failed, please check manually");
		Assert.assertTrue(LocatorsFactoryInstance.getEmailAddsPhoneNumberTextfield(driver).isDisplayed(), "Login button is not present, Please check manually");	
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("before closing the browser");
		browserTearDown();
	}
	
	@AfterMethod
	public void retryIfTestFails() throws Exception {
		startupPage.navigateToUrl(configData.get("url"));
	}
}