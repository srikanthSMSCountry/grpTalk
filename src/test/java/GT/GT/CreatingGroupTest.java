package GT.GT;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CreatingGroupTest extends BrowserFunctions {
	public static Logger logger = Logger.getLogger(CreatingGroupTest.class);
	
	By userName = By.id("txt_Username");
	By password = By.id("txt_Password");
	By login = By.id("button1");
	By selectFiless = By.xpath("//*[@class='qq-uploader']//*[contains(@class,'qq-upload-button')]");
	By uploadFile = By.id("btn_uploder");
	By mobileNumbers = By.id("mobilenumber");
	By sendSMSButton = By.id("sendsms_btn");
	By textMessageField = By.id("txtmessage");
	By successMsg = By.id("ContentPlaceHolder1_lbl_msg");
	
	
	By acceptButton = By.xpath("//*[@class='btn btn-success btn-sm']");
	By bookNowButton = By.id("btnBookNow");
	By customerName = By.id("txtCustomerName");
	By mobileNumber = By.id("txtTicketMobile");
	By email = By.id("txtTicketEmail");
	By eVoucherChecbox = By.xpath("//*[@class='margin-top-20']//*[@class='sp-check']");
	By eVoucherTextCoupon = By.id("txtCoupon");
	By couponApplyButton = By.id("btnCouponApply");
	By termsAndConditionsCheckBox = By.xpath("//*[@class='input-entry color-3 margin-bottom-20']//*[@class='sp-check']");
	By proceedButton = By.id("btnProceed");
	
//	@Test
//	public void verifyBookTicketInWanasaTime() throws InterruptedException {
//		logger_ss = extent.createTest("verify Book Ticket In WanasaTime","verify Book Ticket In WanasaTime");
//		CreatingGroup crtgrp = new CreatingGroup(driver);
//		driver.navigate().to("https://www.wanasatime.com/");
//		driver.findElement(acceptButton).click();
//		Thread.sleep(1000);
//		Actions actions=new Actions(driver);
// 		actions.moveToElement(driver.findElement(bookNowButton));
// 		actions.perform();
//		driver.findElement(bookNowButton).click();
//		Thread.sleep(1000);
//		driver.findElement(customerName).sendKeys(arg0);
//		driver.findElement(mobileNumber).sendKeys(arg0);
//		driver.findElement(email).sendKeys(arg0);
//		driver.findElement(eVoucherChecbox).click();
//		driver.findElement(eVoucherTextCoupon).sendKeys(arg0);
//		driver.findElement(couponApplyButton).click();
//		driver.findElement(proceedButton).click();
//	}
	
	
//	@Test
//	public void smsCountry() throws InterruptedException, AWTException{
//		CreatingGroup crtgrp = new CreatingGroup(driver);
//		driver.navigate().to("https://www.smscountry.com/");
//		driver.findElement(userName).sendKeys("sivaswarup");
//		driver.findElement(password).sendKeys("@a12345678");
//		driver.findElement(login).click();
//		driver.findElement(textMessageField).sendKeys("Hello SMSCountry");
//		WebElement ele = driver.findElement(selectFiless);
//		Actions actions=new Actions(driver);
// 		actions.moveToElement(ele);
// 		actions.perform();
//		driver.findElement(selectFiless).click();
//		String path=System.getProperty("user.dir")+"/TestDataFiles/"+"smsCountry";
//		Utility.getUploadFile(path);
//		driver.findElement(uploadFile).click();
//		Utility.explicitWaitForElementVisibility(driver,sendSMSButton);
//		driver.findElement(sendSMSButton).click();
//		driver.switchTo().alert().accept();
//		String successMessage= driver.findElement(successMsg).getText();
//		System.out.println(successMessage);
//	}
	
	/* Test Case::Verify the error message is displayed or not when user provide junk data in search box field
	 * Steps:
	 * Click on Create Group button 
	 * Click on Phone Contacts 
	 * Search with contact name which is not available in contact list 
	 * Verify error message for unavailable contact list should be "No Contacts Found"
	 */
	@Test
	public void verifyErrorMessageWhenJunkDataGivenInSearchBox() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMessageWhenJunkDataGivenInSearchBox","verify the Error Message When Junk Data Given In SearchBox on CreateGroupTalk page");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		logger.info("Clicked on Creating Group button");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.enterNameInSearchBox("qwertyuiop");
		logger_ss.log(Status.INFO, "Clicked in search box field and given contact name 'zzz' which is not available in contact list");
		logger_ss.log(Status.INFO, "Expected message is: No Contacts Found ");
		logger_ss.log(Status.INFO, "Actual message is:");
		String noContactsMessage = crtgrp.errorMessageWhenUserEntersNameWHichisNotExistinContactList();
		logger_ss.log(Status.INFO, noContactsMessage);
		Assert.assertTrue(
				noContactsMessage.contains("No Contacts Found"));
		logger_ss.log(Status.INFO, "verfied noContactsMessage");
		logger_ss.log(Status.INFO, "Successfully verfied the Message When User Enters Name Which is Not Exist in Contact List");
	}
	
	@Test
	public void verifyFooterTextDisplayedOnMyGrpTalksPage(){
		logger_ss = extent.createTest("verifyFooterTextDisplayedOnHomePage","verifyFooterTextDisplayedOnHomePage");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		Assert.assertEquals(crtgrp.footerText(), "Copy rights © all rights are reserved 2018.");
		logger_ss.log(Status.INFO, "Get and verified footer text");
		logger_ss.log(Status.INFO, "Successfully verfied the Footer Text Displayed On Home Page");
	}
	
	@Test
	public void verifyHeaderTabsAndLogosDisplayedOnMyGrpTalksPage(){
		logger_ss = extent.createTest("verifyHeaderTabsAndLogosDisplayedOnHomePage","verifyHeaderTabsAndLogosDisplayedOnHomePage");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		Assert.assertTrue(crtgrp.grpTalkLogo());
		logger_ss.log(Status.INFO, "verified grpTalkLogo is displayed");
		Assert.assertTrue(crtgrp.groupsTabOnHomePage());
		logger_ss.log(Status.INFO, "verified groupsTabOnHomePage is displayed");
		Assert.assertTrue(crtgrp.contactsTabOnHomePage());
		logger_ss.log(Status.INFO, "verified contactsTabOnHomePage is displayed");
		Assert.assertTrue(crtgrp.accountsTabOnHomePage());
		logger_ss.log(Status.INFO, "verified accountsTabOnHomePage is displayed");
		Assert.assertTrue(crtgrp.profileLogo());
		logger_ss.log(Status.INFO, "verified profileLogo is displayed");
		logger_ss.log(Status.INFO, "Successfully verfied the Header Tabs And Logos Displayed On Home Page");
	}

	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * Retrieve number of users from contact list
	 */
	@Test
	public void verifyContactListInPhoneContacts() throws InterruptedException {
		logger_ss = extent.createTest("verifyContactListInPhoneContacts","Verify Contacts List In PhoneContacts Tab in CreateGroupTalk page");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		int numberOfContacts = crtgrp.numberOfContactsInPhoneContactsTab();
		logger_ss.log(Status.INFO, "Get the Number of contacts present in contact list");
		logger_ss.log(Status.INFO, "Expected total number of contacts are: 200 ");
		logger_ss.log(Status.INFO, "Actual total number of contacts are:");
		logger_ss.log(Status.INFO, String.valueOf(numberOfContacts));
		Assert.assertEquals(numberOfContacts, 100);
		logger_ss.log(Status.INFO, "Successfully verified the number of contacts present in PhoneContacts tab in CreateGroupTalk page");
	}

	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * Search with valid user name 
	 * Retrieve number of users displayed when we search with valid partial user name
	 */
	@Test
	public void verifySearchOptionWithPartialValidUserName() throws InterruptedException {
		logger_ss = extent.createTest("verifySearchOptionWithPartialValidUserName","verify Search Option With Partial Valid User Name");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.enterNameInSearchBox("sanju");
		logger_ss.log(Status.INFO, "Clicked in search box field and given partial contact name 'sanju'");
		int numberOfContacts= crtgrp.numberOfContactsInPhoneContactsTab();
		logger_ss.log(Status.INFO, "Expected total number ofcontacts are: 3");
		logger_ss.log(Status.INFO, "Actual total number of contacts are:");
		logger_ss.log(Status.INFO,  String.valueOf(numberOfContacts));
		Assert.assertEquals(numberOfContacts, 1);
		logger_ss.log(Status.INFO, "Successfully verified the number of contacts present in PhoneContacts tab With Partial Valid User Name in CreateGroupTalk page");
	}

	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * Search with valid user name 
	 * Retrieve number of users displayed when we search with valid full user name
	 */
	@Test
	public void verifySearchOptionWithfullValidUserName() throws InterruptedException {
		logger_ss = extent.createTest("verifySearchOptionWithfullValidUserName","verify Search Option With Valid User Name");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.enterNameInSearchBox("Anji@Room");
		logger_ss.log(Status.INFO, "Clicked in search box field and given valid contact name 'Anji@Room'");
		int numberOfContacts = crtgrp.numberOfContactsInPhoneContactsTab();
		logger_ss.log(Status.INFO, "Expected total number ofcontacts are: 1");
		logger_ss.log(Status.INFO, "Actual total number of contacts are:");
		logger_ss.log(Status.INFO,  String.valueOf(numberOfContacts));
		Assert.assertEquals(numberOfContacts, 1);
		logger_ss.log(Status.INFO, "Successfully verified the number of contacts present in PhoneContacts tab with Valid User Name in CreateGroupTalk page");
	}

	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * Select first User From Contact List
	 */
	@Test
	public void verifySelectContactFromContactList() throws InterruptedException {
		logger_ss = extent.createTest("verifySelectContactFromContactList","verify Select Contact From Contact List");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		logger_ss.log(Status.INFO, "Expected total number of selected contacts are: 1");
		logger_ss.log(Status.INFO, "Actual total number of selected contacts are:");
		int count=crtgrp.selectedContactFromContactList();
		logger_ss.log(Status.INFO,  String.valueOf(count));
		Assert.assertEquals(count, 1);
		logger_ss.log(Status.INFO,  "Successfully verified the selected contacts from contact list");
	}

	@Test
	public void verifySelectSpecificCharacterOfContactsInPhoneContacts() throws InterruptedException{
		logger_ss = extent.createTest("verifySelectSpecificCharacterOfContactsInPhoneContacts","verify Select Specific Character Of Contacts In Phone Contacts");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		Thread.sleep(2000);
		crtgrp.clickPhoneContactsTab();
		Thread.sleep(1000);
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		int size =crtgrp.selectSpecificCharacterOfContacts();
		logger_ss.log(Status.INFO, "selected specific character from contacts list");
		logger_ss.log(Status.INFO, "Expected total number ofcontacts are: 5");
		logger_ss.log(Status.INFO, "Actual total number of contacts are:");
		logger_ss.log(Status.INFO,  String.valueOf(size));
		Assert.assertEquals(size, 4);
		Assert.assertTrue(crtgrp.verifyContactsStartsWithSpecialCharacters());
		logger_ss.log(Status.INFO, "Successfully verified the ContactsStartsWithSpecialCharacters");
		logger_ss.log(Status.INFO, "Successfully verified the number of contacts present in PhoneContacts when we select specific character from phone contacts");
	}
	
	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * Select first User From Contact List 
	 * Click on Selected contacts tab
	 *  Verify Number of users selected in phone contacts and displayed in selected contacts tab
	 */
	@Test
	public void verifyNumberOfUsersFromSelectedContactsTab() throws InterruptedException {
		logger_ss = extent.createTest("verifyNumberOfUsersFromSelectedContactsTab","verify Number Of Users From Selected Contacts Tab");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		crtgrp.selectedContactsTab();
		logger_ss.log(Status.INFO, "Switched to selectedContacts tab");
		int numberOfContacts = crtgrp.numberOfUsersFromSelectedContactsTab();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		logger_ss.log(Status.INFO, "Expected total number of contacts are: 1");
		logger_ss.log(Status.INFO, "Actual total number of contacts are:");
		logger_ss.log(Status.INFO,  String.valueOf(numberOfContacts));
		Assert.assertEquals(numberOfContacts, 1);
		logger_ss.log(Status.INFO, "Successfully verified the number of contacts in selected contacts tab which are selected from phoneContacts tab");
	}

	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * Select More than nine users From Contact List 
	 * Verify Error message
	 */
	@Test
	public void verifyAddMoreNumberOfUsersthanMaximunLimitFromContactList() throws InterruptedException {
		logger_ss = extent.createTest("verifyAddMoreNumberOfUsersthanMaximunLimitFromContactList","verify Add More Number Of Users than Maximun Limit From Contact List");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.addMorethanNineUserFromContactList();
		logger_ss.log(Status.INFO, "Tried to add more than nine contacts from contact list");
		logger_ss.log(Status.INFO, "Expected error message is: You can't select more than 9 members");
		logger_ss.log(Status.INFO, "Actual error message is:");
		logger_ss.log(Status.INFO,  crtgrp.errorMsgonAddingMoreNumberOfContacts());
		Assert.assertEquals(crtgrp.errorMsgonAddingMoreNumberOfContacts(), "You can't select more than 9 members");
		logger_ss.log(Status.INFO, "Successfully verified the error msg by adding morethan nine contacts from phone contacts tab");
	}
	
	@Test
	public void verifyCallFunctionalityOfTestContactsFromCreateGroupTalkPage() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityOfTestContactsFromCreateGroupTalkPage","verifyCallFunctionalityOfTestContactsFromCreateGroupTalkPage");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectTestContactsFromContactList();
		logger_ss.log(Status.INFO, "selected TestContactsFromContactList");
		String grpTalkName=crtgrp.setGrpTalkName();
		crtgrp.submitStartNowButton();
		logger_ss.log(Status.INFO, "Submitted StartNow button");
		crtgrp.dialGroupCallButtonOnOverlayInCreateGrpTalkForTestContacts();
		logger_ss.log(Status.INFO, "clicked on dialGroupCallButtonOnOverlayInCreateGrpTalkForTestContacts");
		crtgrp.visibleInprogressString();
		logger_ss.log(Status.INFO, "Verified the visiblity of Inprogress String");
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "hanged Up CurrentGrpTalkcall");
		crtgrp.submitRateCallByClickingGoodOption();
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "selected Recently SavedGrpTalkGroup");
		crtgrp.historyButtonOnMyGrpTalks();
		logger_ss.log(Status.INFO, "Clicked on historyButtonOnMyGrpTalks");
		crtgrp.downloadRecordingCallHistory();
		logger_ss.log(Status.INFO, "Clicked on downloadRecordingCallHistory");
		crtgrp.deleteSavedGroupCall();
		logger_ss.log(Status.INFO, "deleted SavedGroupCall");
		String dateValue=crtgrp.currentDateValue();
		String fileName=grpTalkName+dateValue;
		System.out.println(fileName);
		String totalDownloadFilepath = downloadFilepath+"/"+fileName;
		System.out.println(totalDownloadFilepath);
		logger_ss.log(Status.INFO, "downloaded Recorded CallHistory");
		logger_ss.log(Status.INFO, "Successfully verified the CallFunctionalityOfTestContactsFromCreateGroupTalkPage");
	}
	
//	@Ignore
//	@Test
//	public void verifyCallEndedFunctionalityOfTestContactsFromCreateGroupTalkPage() throws InterruptedException {
//		logger_ss = extent.createTest("verifyCallEndedFunctionalityOfTestContactsFromCreateGroupTalkPage","verifyCallEndedFunctionalityOfTestContactsFromCreateGroupTalkPage");
//		CreatingGroup crtgrp = new CreatingGroup(driver);
//		crtgrp.clickCreateGrpButton();
//		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
//		crtgrp.clickPhoneContactsTab();
//		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
//		crtgrp.selectTestContactsFromContactList();
//		logger_ss.log(Status.INFO, "selected TestContactsFromContactList");
//		String grpTalkName=crtgrp.setGrpTalkName();
//		crtgrp.submitStartNowButton();
//		logger_ss.log(Status.INFO, "Submitted StartNow button");
//		crtgrp.dialGroupCallButtonOnOverlayInCreateGrpTalkForTest();
//		logger_ss.log(Status.INFO, "clicked on dialGroupCallButtonOnOverlayInCreateGrpTalkForTest");
//		crtgrp.visibleInprogressString();
//		logger_ss.log(Status.INFO, "Verified the visiblity of Inprogress String");
//		crtgrp.visibilityOfHistoryButton();
//		logger_ss.log(Status.INFO, "Verified the visiblity of history button");
//		crtgrp.selectRecentlySavedGrpTalkGroup();
//		logger_ss.log(Status.INFO, "selected Recently SavedGrpTalkGroup");
//		crtgrp.historyButtonOnMyGrpTalks();
//		logger_ss.log(Status.INFO, "Clicked on historyButtonOnMyGrpTalks");
//		crtgrp.downloadRecordingCallHistory();
//		logger_ss.log(Status.INFO, "Clicked on downloadRecordingCallHistory");
//		crtgrp.deleteSavedGroupCall();
//		logger_ss.log(Status.INFO, "deleted SavedGroupCall");
//		String dateValue=crtgrp.currentDateValue();
//		String fileName=grpTalkName+dateValue;
//		System.out.println(fileName);
//		String totalDownloadFilepath = downloadFilepath+"/"+fileName;
//		System.out.println(totalDownloadFilepath);
//		logger_ss.log(Status.INFO, "downloaded Recorded CallHistory");
//		logger_ss.log(Status.INFO, "Successfully verified CallEndedFunctionalityOfTestContactsFromCreateGroupTalkPage");
//	}
	
	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * Submit start now button with out selecting any phone contacts 
	 * Verify Error message
	 */
	@Test
	public void verifyErrorMsgWhenWeSubmitStartNowButtonWithOutSelectingAnyPhoneContacts() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMsgWhenWeSubmitStartNowButtonWithOutSelectingAnyPhoneContacts","verify Error Msg When We Submit StartNow Button With Out Selecting Any Phone Contacts");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.submitStartNowButton();
		logger_ss.log(Status.INFO, "Submitted StartNow button without selecting any phone contacts");
		logger_ss.log(Status.INFO, "Expected error message is: Please Choose Participants To Make A Call");
		logger_ss.log(Status.INFO, "Actual error message is:");
		logger_ss.log(Status.INFO,  crtgrp.errorMsgWhenWeSubmitStartNowButtonWithOutSelectingAnyPhoneContacts());
		Assert.assertEquals(crtgrp.errorMsgWhenWeSubmitStartNowButtonWithOutSelectingAnyPhoneContacts(),
				"Please Choose Participants To Make A Call");
		logger_ss.log(Status.INFO, "Successfully verified the error msg when we submit StartNow button without selecting any phone contacts");
	}

	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * Submit save button with out selecting any phone contacts 
	 * Verify Error message
	 */
	@Test
	public void verifyErrorMsgWhenWeSubmitSaveButtonWithOutSelectingAnyPhoneContacts() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMsgWhenWeSubmitSaveButtonWithOutSelectingAnyPhoneContacts","verify Error Msg When We Submit Save Button WithOut Selecting Any Phone Contacts");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		logger_ss.log(Status.INFO, "Expected error message is: Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Actual error message is:");
		logger_ss.log(Status.INFO,  crtgrp.errorMsgWhenWeSubmitSaveButtonWithOutSelectingAnyPhoneContacts());
		Assert.assertEquals(crtgrp.errorMsgWhenWeSubmitSaveButtonWithOutSelectingAnyPhoneContacts(),
				"Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Successfully verified the error msg when we submit save button without selecting any phone contacts");
	}

	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * Submit schedule
	 * button with out selecting any phone contacts 
	 * Verify Error message
	 */
	@Test
	public void verifyErrorMsgWhenWeSubmitScheduleButtonWithOutSelectingAnyPhoneContacts() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMsgWhenWeSubmitScheduleButtonWithOutSelectingAnyPhoneContacts","verify Error Msg When We Submit Schedule Button WithOut Selecting Any Phone Contacts");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.submitScheduleButton();
		logger_ss.log(Status.INFO, "Submitted schedule button");
		logger_ss.log(Status.INFO, "Expected error message is: Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Actual error message is:");
		logger_ss.log(Status.INFO,  crtgrp.errorMsgWhenWeSubmitScheduleButtonWithOutSelectingAnyPhoneContacts());
		Assert.assertEquals(crtgrp.errorMsgWhenWeSubmitScheduleButtonWithOutSelectingAnyPhoneContacts(),
				"Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Successfully verified the error msg when we submit schedule button without selecting any phone contacts");
	}
	
	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * select User From Contact List
	 * Clear grp talk name
	 * Submit start now button
	 * Verify Error message
	 */
	@Test
	public void verifyErrorMsgWhenWeSubmitStartNowButtonWithOutEnterGrpTalkName() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMsgWhenWeSubmitStartNowButtonWithOutEnterGrpTalkName","verify Error Msg When We Submit StartNow button with out enter GrpTalk name");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.clearGrpTalkName();
		logger_ss.log(Status.INFO, "Cleared default grpTalk name in text field");
		crtgrp.submitStartNowButton();
		logger_ss.log(Status.INFO, "Submitted start now button");
		logger_ss.log(Status.INFO, "Expected error message is: Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Actual error message is:");
		logger_ss.log(Status.INFO,  crtgrp.errorMsgWhenWeSubmitStartNowButtonWithOutGivingAnyGrpName());
		Assert.assertEquals(crtgrp.errorMsgWhenWeSubmitStartNowButtonWithOutGivingAnyGrpName(),
				"Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Successfully verified the error msg when we submit StartNow button without giving any grpTalk name");
	}
	
	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * select User From Contact List
	 * Clear grp talk name
	 * Submit save button
	 * Verify Error message
	 */
	@Test
	public void verifyErrorMsgWhenWeSubmitSaveButtonWithOutEnterGrpTalkName() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMsgWhenWeSubmitSaveButtonWithOutEnterGrpTalkName","verify Error Msg When We Submit save button with out enter GrpTalk name");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.clearGrpTalkName();
		logger_ss.log(Status.INFO, "Cleared default grpTalk name in text field");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		logger_ss.log(Status.INFO, "Expected error message is: Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Actual error message is:");
		logger_ss.log(Status.INFO,  crtgrp.errorMsgWhenWeSubmitSaveButtonWithOutGivingAnyGrpName());
		Assert.assertEquals(crtgrp.errorMsgWhenWeSubmitSaveButtonWithOutGivingAnyGrpName(),
				"Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Successfully verified the error msg when we submit save button without giving any grpTalk name");
	}
	
	@Test
	public void verifyQuickDialButtonFunctionalityofGroupsInMyGrpTalk() throws InterruptedException {
		logger_ss = extent.createTest("verifyQuickDialButtonFunctionalityofGroupsInMyGrpTalk","Verify quickDialButtonFunctionalityofGroupsInMyGrpTalk");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		Thread.sleep(2000);
		crtgrp.clickQuickDailButtonofGroupsInMyGrpTalk();
		logger_ss.log(Status.INFO, "clicked on QuickDailButtonofGroupsInMyGrpTalk");
		Assert.assertTrue(crtgrp.cancleButtonDisplayedOnCallOverlay());
		logger_ss.log(Status.INFO, "verified cancleButtonDisplayedOnCallOverlay");
		Assert.assertTrue(crtgrp.muteDialButtonDisplayedOnCallOverlay());
		logger_ss.log(Status.INFO, "verified muteDialButtonDisplayedOnCallOverlay");
		Assert.assertTrue(crtgrp.dialGroupButtonDisplayedOnCallOverlay());
		logger_ss.log(Status.INFO, "verified dialGroupButtonDisplayedOnCallOverlay");
		logger_ss.log(Status.INFO, "Successfully verified Quick Dial Button Functionality of Groups In MyGrpTalk");
	}
	
	@Test
	public void verifyCallFunctionalityFromQuickDialButtonInMyGrpTalk() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromQuickDialButtonInMyGrpTalk","verifyCallFunctionalityFromQuickDialButtonInMyGrpTalk");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		crtgrp.quickDialButtonOfActiveGroup();
		logger_ss.log(Status.INFO, "clicked on quickDialButtonOfActiveGroup");
		Assert.assertTrue(crtgrp.cancleButtonDisplayedOnCallOverlay());
		logger_ss.log(Status.INFO, "verified cancleButtonDisplayedOnCallOverlay");
		Assert.assertTrue(crtgrp.muteDialButtonDisplayedOnCallOverlay());
		logger_ss.log(Status.INFO, "verified muteDialButtonDisplayedOnCallOverlay");
		Assert.assertTrue(crtgrp.dialGroupButtonDisplayedOnCallOverlay());
		logger_ss.log(Status.INFO, "verified dialGroupButtonDisplayedOnCallOverlay");
		crtgrp.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Dialed to grpTalk group");
		crtgrp.visibleInprogressString();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		int allMembersCountInGrpCall=crtgrp.allMembersCountInGrpCall();
		Assert.assertEquals(allMembersCountInGrpCall,1);
		logger_ss.log(Status.INFO, "Successfully verified allMembersCountInGrpCall ");
		int onCallCountInGrpCall=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall,1);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int unMutedCountInGrpCall=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall,1);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		int callEndedCountInGrpCall=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "hangUp the Current GrpTalk call");
		crtgrp.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verified CallFunctionalityFromQuickDialButtonInMyGrpTalk");
	}
	
	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * select User From Contact List
	 * Clear grp talk name
	 * Submit schedule button
	 * Verify Error message
	 */
	@Test
	public void verifyErrorMsgWhenWeSubmitScheduleButtonWithOutEnterGrpTalkName() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMsgWhenWeSubmitScheduleButtonWithOutEnterGrpTalkName","verify Error Msg When We Submit schedule button with out enter GrpTalk name");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in Create Group Talk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.clearGrpTalkName();
		logger_ss.log(Status.INFO, "Cleared default grpTalk name in text field");
		crtgrp.submitScheduleButton();
		logger_ss.log(Status.INFO, "Submitted schedule button");
		logger_ss.log(Status.INFO, "Expected error message is: Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Actual error message is:");
		logger_ss.log(Status.INFO,  crtgrp.errorMsgWhenWeSubmitScheduleButtonWithOutGivingAnyGrpName());
		Assert.assertEquals(crtgrp.errorMsgWhenWeSubmitScheduleButtonWithOutGivingAnyGrpName(),
				"Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Succesfully verified the error msg when we submit schedule button without giving any grpTalk name");
	}
	
	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * select User From Contact List
	 * Set Grp talk name
	 * Submit save button
	 * Submit save group button on overlay
	 * Verify success message for saved group call
	 * Verify saved group talk group is selected or not
	 * Verify name of created group talk and name on My grp talk Main grid
	 */
	@Test
	public void verifyGrpTalkNameFieldOnCreateGroupTalk() throws InterruptedException {
		logger_ss = extent.createTest("verifyGrpTalkNameField","verify GrpTalk name field in CreateGroupTalk page");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "Submitted saveGroup button on overlay");
		
		logger_ss.log(Status.INFO, "Expected success message is: Group call saved successfully");
		logger_ss.log(Status.INFO, "Actual success message is:");
		logger_ss.log(Status.INFO,  crtgrp.successMsgWhenWeSubmitSaveGroupButtonOnOverlay());
		
		Assert.assertEquals(crtgrp.successMsgWhenWeSubmitSaveGroupButtonOnOverlay(),
				"Group call saved successfully");
		logger_ss.log(Status.INFO, "Successfully verified success msg when we submit save group button on overlay");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		logger_ss.log(Status.INFO, "Expected name of created group is : ");
		logger_ss.log(Status.INFO,  crtgrp.retrievingNameOfCreatedGrpTalk());
		logger_ss.log(Status.INFO, "Actual actual name of created group is :");
		logger_ss.log(Status.INFO,  crtgrp.nameOnMyGrpTalkMainGrid());		
		Assert.assertEquals(crtgrp.nameOnMyGrpTalkMainGrid(), crtgrp.retrievingNameOfCreatedGrpTalk());
		logger_ss.log(Status.INFO, "Successfully verifed the name on MyGrpTalk page with given grp talk name on CreateGroupTalk page");
	}
	
	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * select User From Contact List
	 * Click on Selected Contacts tab
	 * Get the List Of Group USers From Selected Contacts
	 * Click on Phone Contacts 
	 * Set Grp talk name
	 * Submit save button
	 * Submit save group button on overlay
	 * Verify success message for saved group call
	 * Verify saved group talk group is selected or not
	 * Verify name of created group talk and name on My grp talk Main grid
	 * Get the list Of Group Users On My Grp Talk Page
	 * Verify  list Of Group Users On My Grp Talk Page with List Of Group USers From Selected Contacts
	 */
	@Test
	public void verify_list_Of_Group_Users_On_MyGrpTalk_Page() throws InterruptedException {
		logger_ss = extent.createTest("verify_list_Of_Group_Users_On_MyGrpTalk_Page","verify the list Of Group Users On MyGrpTalk Page");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.selectedContactsTab();
		logger_ss.log(Status.INFO, "switched to selected contacts tab");
		List<String> list1=crtgrp.ListOfGroupContactsFromSelectedContacts();
		logger_ss.log(Status.INFO, "Taken the list of grp contacts from selected contacts tab ");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "Submitted saveGroup button on overlay");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		List<String> list2=crtgrp.listOfGroupContactsOnMyGrpTalkPage();
		logger_ss.log(Status.INFO, "Taken the list of group contacts on my grp talk page");
		
		logger_ss.log(Status.INFO, "Expected list of grp contacts from selected contacts tab is :");
		for(String s:list1){
			logger_ss.log(Status.INFO, s );
		}
		logger_ss.log(Status.INFO, "Actual list of group users from contacts on my grp talk page is :");
		for(String s:list2){
			logger_ss.log(Status.INFO, s );
		}
		Assert.assertTrue(list1.containsAll(list2));
		logger_ss.log(Status.INFO, "Successfully verifed the list of group contacts on my grp talk page with list of grp contacts from selected contacts tab");
	}
	
	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * select User From Contact List
	 * Set Grp talk name
	 * Submit save button
	 * Submit save group button on overlay
	 * Verify success message for saved group call
	 * Verify saved group talk group is selected or not
	 * Verify name of created group talk and name on My grp talk Main grid
	 * Delete saved group call
	 * Verify success msg for deleting group
	 */
	
	@Test
	public void verifyRemoveFunctionalityOfSavedGroupsOnMyGrpTalkPage() throws InterruptedException {
		logger_ss = extent.createTest("verifyRemoveFunctionalityOfSavedGroupsOnMyGrpTalkPage","verify Remove Functionality Of Saved Groups On MyGrpTalk Page");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		String s=crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "Submitted saveGroup button on overlay");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		crtgrp.deleteSavedGroupCall();
		logger_ss.log(Status.INFO, "Deleted saved group call");
		logger_ss.log(Status.INFO, "Expected success msg is : Deleted Successfully");
		logger_ss.log(Status.INFO, "Expected success msg is :");
		logger_ss.log(Status.INFO,  crtgrp.successMsgForDeletingSavedGroup());
		
		Assert.assertEquals(crtgrp.successMsgForDeletingSavedGroup(), "Deleted Successfully");
		logger_ss.log(Status.INFO, "Succesfully verified success Msg For Deleted Saved Group");
		
		Assert.assertFalse(crtgrp.presenceOfGroupByGivenName(s));
		logger_ss.log(Status.INFO, "Successfully verified the presence of Deleted Saved Group by name");
	}
	
	/*
	 * Click on CreateGroup button 
	 * Create new Web List by adding contact
	 */
	@Test
	public void verifyCreateWebLIst() throws InterruptedException {
		logger_ss = extent.createTest("verifyCreateWebLIst","verify create web list");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		String newWebList= crtgrp.createWebLIst();
		logger_ss.log(Status.INFO, "Created new web list");
		Assert.assertTrue(crtgrp.listNameInWebLists(newWebList));
		logger_ss.log(Status.INFO, "Successfully verfied new web list name in list of web lists");
	}
	
	/*
	 * Click on CreateGroup button 
	 * Click on Phone Contacts 
	 * select User From Contact List
	 * Set Grp talk name
	 * Submit save button
	 * Submit save group button on overlay
	 * Verify success message for saved group call
	 * Verify saved group talk group is selected or not
	 * Verify name of created group talk and name on My grp talk Main grid
	 * Edit saved group call
	 * Select recently saved group talk group
	 */
	
	@Test
	public void verifyAddContactsFromContactsListByEditngSavedGroupOnMyGrpTalkPage() throws InterruptedException {
		logger_ss = extent.createTest("verifyAddContactsFromContactsListByEditngSavedGroupOnMyGrpTalkPage","verifyAddContactsFromContactsListByEditngSavedGroupOnMyGrpTalkPage");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "Submitted saveGroup button on overlay");
		Assert.assertEquals(crtgrp.successMsgWhenWeSubmitSaveGroupButtonOnOverlay(),
				"Group call saved successfully");
		logger_ss.log(Status.INFO, "Verified success Msg When We Submit SaveGroup button on overlay");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		int count=crtgrp.editSavedGroupCall();
		Assert.assertEquals(count, 2);
		crtgrp.selectRecentlySavedGrpTalkGroup();
		Assert.assertEquals(crtgrp.contactsListOfGroupOnMyGrpTalkPage(), 3);
		logger_ss.log(Status.INFO, "Successfully Added new contact in saved group by editing existing saved group ");
	}
	
	@Test
	public void verifyRemoveContactFromSavedGroupOnMyGrpTalkPage() throws InterruptedException {
		logger_ss = extent.createTest("verifyRemoveContactFromSavedGroupOnMyGrpTalkPage","verify Remove Contact From Saved Group On MyGrpTalk Page");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactsFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contacts from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "Submitted saveGroup button on overlay");
		Assert.assertEquals(crtgrp.successMsgWhenWeSubmitSaveGroupButtonOnOverlay(),
				"Group call saved successfully");
		logger_ss.log(Status.INFO, "Verified success Msg When We Submit SaveGroup button on overlay");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		int count=crtgrp.removeContactFromSavedGroup();
		Assert.assertEquals(count, 1);
		Assert.assertEquals(crtgrp.contactsListOfGroupOnMyGrpTalkPage(), 2);
		logger_ss.log(Status.INFO, "Successfully removed one contact from saved group by editing existing saved group ");
	}
	
	/*
	 * Click on Grp talk group called grpTalk
	 * Dial grp call 
	 * Verify members count in Grp call
	 * HangUp the current grp call
	 */
	
	@Test
	public void verifyCallFunctionalityOfSavedGrpTalkGroupOnMyGrpTalkPage() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityOfSavedGrpTalkGroupOnMyGrpTalkPage","verifyCallFunctionalityOfSavedGrpTalkGroupOnMyGrpTalkPage");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		int[] count= crtgrp.dialGroupCall();
		logger_ss.log(Status.INFO, "Dialed to grpTalk group");
		crtgrp.visibleInprogressString();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		logger_ss.log(Status.INFO, "Expected value of all members count is : 1");
		Assert.assertEquals(count[0],1);
		logger_ss.log(Status.INFO, "Expected value of OnCall Count is : 1");
		Assert.assertEquals(count[1],1);
		logger_ss.log(Status.INFO, "Expected value Of UnMutedCount is : 1");
		Assert.assertEquals(count[2],1);
		logger_ss.log(Status.INFO, "Expected value Of callEndedCount is : 0");
		Assert.assertEquals(count[3],0);
		logger_ss.log(Status.INFO, "Actual values are:");
		for(int s:count){
			logger_ss.log(Status.INFO, String.valueOf(s) );
		}
		logger_ss.log(Status.INFO, "Successfully verified allMembersCount, onCallCount, unMutedCount and callEndedCount ");
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "hangUp the Current GrpTalk call");
		crtgrp.submitRateCallByClickingGoodOption();
	}
	
	@Test
	public void verifyCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup","verifyCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitStartNowButton();
		logger_ss.log(Status.INFO, "Submitted StartNow button");
		crtgrp.dialGroupCallButtonOnOverlayInCreateGrpTalk();
		logger_ss.log(Status.INFO, "Submitted dial GroupCall Button On Overlay In CreateGrpTalk page");
		
		crtgrp.visibleInprogressString();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		int allMembersCountInGrpCall=crtgrp.allMembersCountInGrpCall();
		Assert.assertEquals(allMembersCountInGrpCall,1);
		logger_ss.log(Status.INFO, "Successfully verified allMembersCountInGrpCall ");
		int onCallCountInGrpCall=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall,1);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int unMutedCountInGrpCall=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall,1);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		int callEndedCountInGrpCall=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "hangUp the Current GrpTalk call");
		crtgrp.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verified CallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup");
	}
	
	@Test
	public void verifyMuteCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup() throws InterruptedException {
		logger_ss = extent.createTest("verifyMuteCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup","verifyMuteCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitStartNowButton();
		logger_ss.log(Status.INFO, "Submitted StartNow button");
		crtgrp.clickMuteDialButtonOnOverlayInCreateGrpTalk();
		logger_ss.log(Status.INFO, "Submitted dial GroupCall Button On Overlay In CreateGrpTalk page");
		crtgrp.visibleInprogressString();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		int allMembersCountInGrpCall=crtgrp.allMembersCountInGrpCall();
		Assert.assertEquals(allMembersCountInGrpCall,1);
		logger_ss.log(Status.INFO, "Successfully verified allMembersCountInGrpCall ");
		int onCallCountInGrpCall=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall,1);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int unMutedCountInGrpCall=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		int callEndedCountInGrpCall=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");

		crtgrp.onCallCountInGrpCall();
		logger_ss.log(Status.INFO, "Clicked on onCallCount tab In GrpCall");
		Assert.assertTrue(crtgrp.visibilityOfMuteBuutonInGrpCall());
		logger_ss.log(Status.INFO, "Successfully verifed the visibility of mute button in grp call");
		
		crtgrp.visibilityOfIndividualUserMuteButtomInGrpCall();
		Assert.assertTrue(
				crtgrp.visibilityOfIndividualUserMuteButtomInGrpCall().contains("SingleUnMute"));
		logger_ss.log(Status.INFO, "Successfully verifed the visibility of individual user mute button in grp call");

		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		crtgrp.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verifed MuteCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup");
	}
	
	
	/*
	 * select Grp Talk Group By Name
	 * Click on dial Group Call Button
	 * Click on dial Group Call Butt on OnOverlay
	 * add Member In OnGoing Grp Call
	 * Verify all Members Count In Grp Call
	 * Verify unMuted Count In Grp Call
	 * Verify call Ended Count In Grp Call
	 * Verify on call count in ongoing grp call
	 * HangUp the current grp call
	 * remove Added Contact From Group In OnGoing Call
	 * 
	 */
	
	@Test
	public void verifyAddMemberInOnGoingGrpCallFromCreateGroupTalkPageByCreatingNewGroup() throws InterruptedException {
		logger_ss = extent.createTest("verifyAddMemberInOnGoingGrpCall","verify Add members in ongoing grp call");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactFromContactList();
		crtgrp.setGrpTalkName();
		crtgrp.submitSaveButton();
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");		
		crtgrp.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		crtgrp.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on dial grpCall button on overlay");
		crtgrp.visibleInprogressString();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		crtgrp.addMemberInOnGoingGrpCall();
		logger_ss.log(Status.INFO, "Added new member contact in on going call");
		logger_ss.log(Status.INFO, "Expected all Members Count In GrpCall : 2");
		logger_ss.log(Status.INFO, "Actual all members count in grpCall is :");
		int allMembersCountInGrpCall = crtgrp.allMembersCountInGrpCall();
		logger_ss.log(Status.INFO,  String.valueOf(allMembersCountInGrpCall));

		Assert.assertEquals(crtgrp.allMembersCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");
		
		logger_ss.log(Status.INFO, "Expected onCall Count In GrpCall : 2");
		logger_ss.log(Status.INFO, "Actual onCall Count In GrpCall :");
		int onCallCount = crtgrp.onCallCountInGrpCall();
		logger_ss.log(Status.INFO,  String.valueOf(onCallCount));

		Assert.assertEquals(crtgrp.onCallCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		logger_ss.log(Status.INFO, "Expected unMuted Count In GrpCall : 2");
		logger_ss.log(Status.INFO, "Actual unMuted Count In GrpCall :");
		int unMutedCountInGrpCall = crtgrp.unMutedCountInGrpCall();
		logger_ss.log(Status.INFO,   String.valueOf(unMutedCountInGrpCall));
	
		Assert.assertEquals(crtgrp.unMutedCountInGrpCall(), 2);	
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		
		logger_ss.log(Status.INFO, "Expected call Ended Count In GrpCall : 0");
		logger_ss.log(Status.INFO, "Actual call ended Count In GrpCall :");
		int callEndedCountInGrpCall = crtgrp.callEndedCountInGrpCall();
		logger_ss.log(Status.INFO,   String.valueOf(callEndedCountInGrpCall));

		Assert.assertEquals(crtgrp.callEndedCountInGrpCall(), 0);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "Successfully hangUp current grpCall");
		crtgrp.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verifed AddMemberInOnGoingGrpCallFromCreateGroupTalkPageByCreatingNewGroup");
	}
	
	/*
	 * Click on group name called grpTalk In my grp talk
	 * Click on dial group call button
	 * click on cancel button on overlay to cancel the group 
	 * Verify visibility Of Dial Group Call Button
	 */
	@Test
	public void verifyCanclefunctionalityOnOverlayInGrpCall() throws InterruptedException {
		logger_ss = extent.createTest("verifyCanclefunctionalityOnOverlayInGrpCall","verify Cancle functionality On Overlay In GrpCall");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		crtgrp.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		crtgrp.cancelGroupCallOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on Cancle groupCall button on overlay");
		Assert.assertTrue(crtgrp.visibilityOfDialGroupCallButton());
		logger_ss.log(Status.INFO, "Successfully cancled the grpTalk group call  ");
	}
	
	@Test
	public void verifyAllButtonsDisplayedOnCallOverlay() throws InterruptedException {
		logger_ss = extent.createTest("verifyAllButtonsAreDisplayedOnDialCallOverlay","verify All Buttons Are Displayed On Dial Call Overlay");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		crtgrp.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		Assert.assertTrue(crtgrp.cancleButtonDisplayedOnCallOverlay());
		logger_ss.log(Status.INFO, "verified cancleButtonDisplayedOnCallOverlay");
		Assert.assertTrue(crtgrp.muteDialButtonDisplayedOnCallOverlay());
		logger_ss.log(Status.INFO, "verified muteDialButtonDisplayedOnCallOverlay");
		Assert.assertTrue(crtgrp.dialGroupButtonDisplayedOnCallOverlay());
		logger_ss.log(Status.INFO, "verified dialGroupButtonDisplayedOnCallOverlay");
		logger_ss.log(Status.INFO, "Successfully verified all Buttons Displayed On Dial Call Overlay");
	}
	
	/*
	 * Click on group name called grpTalk In my grp talk
	 * Click on dial group call button
	 * click on mute Dial Group Call On Overlay
	 * Verify unMuted Count In Grp Call
	 * Verify all Members Count In Grp Call
	 * Verify on Call Count In Grp Call
	 * Verify call Ended Count In Grp Call
	 * Verify visibility Of Mute Buuton In Grp Call
	 * Verify visibility Of Individual User MuteButtom In Grp Call
	 */
	@Test
	public void verifyMuteDialfunctionalityOnOverlayInGrpCall() throws InterruptedException {
		logger_ss = extent.createTest("verifyMuteDialfunctionalityOnOverlayInGrpCall","verify Mute Dial functionality On Overlay In GrpCall");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		crtgrp.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		crtgrp.muteDialGroupCallOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on mute dial button on overlay");
		crtgrp.visibleInprogressString();
		logger_ss.log(Status.INFO, "Expected unMuted Count In GrpCall : 0");
		logger_ss.log(Status.INFO, "Actual unMuted count in grpCall is :");
		int unMutedCountInGrpCall =  crtgrp.unMutedCountInGrpCall();
		logger_ss.log(Status.INFO,  String.valueOf(unMutedCountInGrpCall));

		Assert.assertEquals(crtgrp.unMutedCountInGrpCall(), 0);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		
		logger_ss.log(Status.INFO, "Expected all Members Count In GrpCall : 1");
		logger_ss.log(Status.INFO, "Actual all members count in grpCall is :");
		int allMembersCount = crtgrp.allMembersCountInGrpCall();
		logger_ss.log(Status.INFO,  String.valueOf(allMembersCount));
		
		Assert.assertEquals(crtgrp.allMembersCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");
		
		logger_ss.log(Status.INFO, "Expected onCall Count In GrpCall : 1");
		logger_ss.log(Status.INFO, "Actual onCall Count In GrpCall :");
		int onCallCount =  crtgrp.onCallCountInGrpCall();
		logger_ss.log(Status.INFO,  String.valueOf(onCallCount));
	
		Assert.assertEquals(crtgrp.onCallCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
			
		logger_ss.log(Status.INFO, "Expected call Ended Count In GrpCall : 0");
		logger_ss.log(Status.INFO, "Actual call ended Count In GrpCall :");
		int callEndedCount =  crtgrp.callEndedCountInGrpCall();
		logger_ss.log(Status.INFO,  String.valueOf(callEndedCount));
			
		Assert.assertEquals(crtgrp.callEndedCountInGrpCall(), 0);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		Assert.assertTrue(crtgrp.visibilityOfMuteBuutonInGrpCall());
		logger_ss.log(Status.INFO, "Successfully verifed the visibility of mute button in grp call");
		crtgrp.onCallCountInGrpCall();
		logger_ss.log(Status.INFO, "Clicked on onCallCount tab In GrpCall");
		crtgrp.visibilityOfIndividualUserMuteButtomInGrpCall();
		Assert.assertTrue(
				crtgrp.visibilityOfIndividualUserMuteButtomInGrpCall().contains("SingleUnMute"));
		logger_ss.log(Status.INFO, "Successfully verifed the visibility of individual user mute button in grp call");

		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		crtgrp.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verifed MuteDialfunctionalityOnOverlayInGrpCall");
		
	}
	/*
	 * select GrpTalk Group By Name
	 * Click on dial Group Call Button
	 * Click on mute Dial Group Call On Overlay
	 * Verify unMuted Count In GrpCall
	 * Verify visibility Of Mute Button In Grp Call
	 * Verify visibility Of Individual User Mute Button In GrpCall
	 * click On Mute Button To UnMute All Users In Grp Call
	 * Verify visibility Of UnMute Button From Mute In GrpCall
	 * Verify visibility Of Individual User Mute Button In GrpCall
	 * hang Up Current Grp Talk call
	 */
	
	@Test
	public void verifyUnMuteFromMuteDialfunctionalityInGrpCall() throws InterruptedException {
		logger_ss = extent.createTest("verifyUnMuteFromMuteDialfunctionalityInGrpCall","verify Un Mute From Mute Dial functionality In GrpCall");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		crtgrp.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		crtgrp.muteDialGroupCallOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on mute dial button on overlay");
		crtgrp.visibleInprogressString();
		
		logger_ss.log(Status.INFO, "Expected unMuted Count In GrpCall : 0");
		logger_ss.log(Status.INFO, "Actual unMuted count in grpCall is :");
		int unMutedCountInGrpCall = crtgrp.unMutedCountInGrpCall();
		logger_ss.log(Status.INFO,  String.valueOf(unMutedCountInGrpCall));
	
		Assert.assertEquals(crtgrp.unMutedCountInGrpCall(), 0);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		
		logger_ss.log(Status.INFO, "Expected all Members Count In GrpCall : 1");
		logger_ss.log(Status.INFO, "Actual all members count in grpCall is :");
		int allMembersCountInGrpCall = crtgrp.allMembersCountInGrpCall();
		logger_ss.log(Status.INFO,  String.valueOf(allMembersCountInGrpCall));
		
		Assert.assertEquals(crtgrp.allMembersCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");
		
		logger_ss.log(Status.INFO, "Expected onCall Count In GrpCall : 1");
		logger_ss.log(Status.INFO, "Actual onCall Count In GrpCall :");
		int onCallCountInGrpCall = crtgrp.onCallCountInGrpCall();
		logger_ss.log(Status.INFO, String.valueOf(onCallCountInGrpCall) );
	
		Assert.assertEquals(crtgrp.onCallCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		logger_ss.log(Status.INFO, "Expected call Ended Count In GrpCall : 0");
		logger_ss.log(Status.INFO, "Actual call ended Count In GrpCall :");
		int callEndedCountInGrpCall = crtgrp.callEndedCountInGrpCall();
		logger_ss.log(Status.INFO, String.valueOf(callEndedCountInGrpCall) );

		Assert.assertEquals(crtgrp.callEndedCountInGrpCall(), 0);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		Assert.assertTrue(crtgrp.visibilityOfMuteBuutonInGrpCall());
		logger_ss.log(Status.INFO, "Verified visibility Of Mute Buuton In GrpCall");
		crtgrp.onCallCountInGrpCall();
		Assert.assertTrue(
				crtgrp.visibilityOfIndividualUserMuteButtomInGrpCall().contains("SingleUnMute"));
		logger_ss.log(Status.INFO, "Verified visibility Of individual user Mute Buuton In GrpCall");
		crtgrp.clickOnMuteButtonToUnMuteAllUsersInGrpCall();
		logger_ss.log(Status.INFO, "clicked On Mute Button To UnMute All Users In Grp Call");
		
		Assert.assertTrue(crtgrp.visibilityOfUnMuteBuutonFromMuteInGrpCall());
				logger_ss.log(Status.INFO, "Verified visibility Of unMute Buuton In GrpCall");
		Assert.assertTrue(
				crtgrp.visibilityOfIndividualUserMuteButtomInGrpCall().contains("SingleMute"));
		logger_ss.log(Status.INFO, "Verified visibility Of individual user Mute Buuton In GrpCall");		
		
		logger_ss.log(Status.INFO, "Expected unMuted Count In GrpCall : 1");
		logger_ss.log(Status.INFO, "Actual unMuted count in grpCall is :");
		int unMutedCount = crtgrp.unMutedCountInGrpCall();
		logger_ss.log(Status.INFO,  String.valueOf(unMutedCount));
	
		Assert.assertEquals(crtgrp.unMutedCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
	
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		crtgrp.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verifed UnMuteFromMuteDialfunctionalityInGrpCall");
	}
	
	/*
	 * select GrpTalk Group By Name
	 * Click on dial Group Call Button
	 * Click on dial Group Call Button On Overlay
	 * click On UnMute Button To Mute All Users In GrpCall
	 * Verify visibility Of Mute Buuton In GrpCall
	 * Verify visibility Of Individual User Mute Buttom In GrpCall
	 * hang Up Current Grp Talk call
	 */
	
	@Test
	public void verifyMuteFunctionalityInOnGoingGrpCallThroughNormalDial() throws InterruptedException{
		logger_ss = extent.createTest("verifyMuteFunctionalityInOnGoingGrpCallThroughNormalDial","verify Mute Functionality In OnGoing Grp Call Through Normal Dial");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");		
		crtgrp.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		crtgrp.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on dial grpCall button on overlay");
		crtgrp.visibleInprogressString();
		crtgrp.clickOnUnMuteButtonToMuteAllUsersInGrpCall();
		logger_ss.log(Status.INFO, "clicked On Un Mute Button To Mute All Users In GrpCall");
		Assert.assertTrue(crtgrp.visibilityOfMuteBuutonInGrpCall());
		logger_ss.log(Status.INFO, "Successfully verified the visibility Of Mute Button In GrpCall");
		crtgrp.onCallCountInGrpCall();
		Assert.assertTrue(
				crtgrp.visibilityOfIndividualUserMuteButtomInGrpCall().contains("SingleUnMute"));
		logger_ss.log(Status.INFO, "Successfully verified the visibility Of Individual User Mute Button In GrpCall");
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		crtgrp.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verifed MuteFunctionalityInOnGoingGrpCallThroughNormalDial");
	}
	
	/*
	 * select Grp Talk Group By Name 
	 * Click on dial Group Call Button
	 * Click on dial Group Call Button On Overlay
	 * add Member In OnGoing Grp Call
	 * click On Individual User HangUp Buttom In Grp Call
	 * Verify on Call Count In Grp Call
	 * Verify call Ended Count In Grp Call
	 * Verify unMuted Count In Grp Call
	 * hangUp Current Grp Talk call
	 * remove Added Contact From Group In OnGoing Call
	 */
	@Test
	public void verifyHangUpInOnGoingCallOfindividualUser() throws InterruptedException{
		logger_ss = extent.createTest("verifyHangUpInOnGoingCallOfindividualUser","verify Hang Up In OnGoing Call Of individual User");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactFromContactList();
		crtgrp.setGrpTalkName();
		crtgrp.submitSaveButton();
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		crtgrp.selectRecentlySavedGrpTalkGroup();
				logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		
		crtgrp.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		crtgrp.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on dial grpCall button on overlay");
		crtgrp.visibleInprogressString();
		crtgrp.addMemberInOnGoingGrpCall();
		
		logger_ss.log(Status.INFO, "Expected onCall Count In GrpCall : 2");
		logger_ss.log(Status.INFO, "Actual onCall Count In GrpCall :");
		int onCallCountInGrpCall = crtgrp.onCallCountInGrpCall();
		logger_ss.log(Status.INFO,  String.valueOf(onCallCountInGrpCall));
	
		Assert.assertEquals(crtgrp.onCallCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");

		crtgrp.clickOnIndividualUserHangUpButtomInGrpCall();
		logger_ss.log(Status.INFO, "Clicked on individual user hangUp button in grp call");
		
		logger_ss.log(Status.INFO, "Expected all Members Count In GrpCall : 2");
		logger_ss.log(Status.INFO, "Actual all members count in grpCall is :");
		int allMembersCountInGrpCall = crtgrp.allMembersCountInGrpCall();
		logger_ss.log(Status.INFO,  String.valueOf(allMembersCountInGrpCall));
		
		Assert.assertEquals(crtgrp.allMembersCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");

		logger_ss.log(Status.INFO, "Expected unMuted Count In GrpCall : 1");
		logger_ss.log(Status.INFO, "Actual unMuted count in grpCall is :");
		int unMutedCountInGrpCall = crtgrp.unMutedCountInGrpCall();
		logger_ss.log(Status.INFO,  String.valueOf(unMutedCountInGrpCall));
	
		Assert.assertEquals(crtgrp.unMutedCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");

		logger_ss.log(Status.INFO, "Expected onCall Count In GrpCall : 1");
		logger_ss.log(Status.INFO, "Actual onCall Count In GrpCall :");
		int onCallCount = crtgrp.onCallCountInGrpCall();
		logger_ss.log(Status.INFO, String.valueOf(onCallCount) );
	
		Assert.assertEquals(crtgrp.onCallCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		logger_ss.log(Status.INFO, "Expected call Ended Count In GrpCall : 1");
		logger_ss.log(Status.INFO, "Actual call ended Count In GrpCall :");
		int callEndedCountInGrpCall = crtgrp.callEndedCountInGrpCall();
		logger_ss.log(Status.INFO,  String.valueOf(callEndedCountInGrpCall));

		Assert.assertEquals(crtgrp.callEndedCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");

		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		crtgrp.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verifed HangUpInOnGoingCallOfindividualUser");
	}
	
	/*
	 * select Grp Talk Group By Name
	 * Click on dial Group Call Button
	 * Click on dial Group Call Button On Overlay
	 * add Member In OnGoing Call Through Contacts
	 * Verify on Call Count In Grp Call
	 * Verify call Ended Count In Grp Call
	 * Verify unMuted Count In Grp Call
	 * hangUp Current Grp Talk call
	 * remove Added Contact From Group In OnGoing Call
	 * 
	 */
	@Test(priority=5)
	public void verifyAddMemberInOnGoingGrpCallThroughContacts() throws InterruptedException {
		logger_ss = extent.createTest("verifyAddMemberInOnGoingGrpCallThroughContacts","verify Add Member In OnGoing GrpCall Through Contacts");
		CreatingGroup crtgrp = new CreatingGroup(driver);

		crtgrp.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactFromContactList();
		crtgrp.setGrpTalkName();
		crtgrp.submitSaveButton();
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		
		crtgrp.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		crtgrp.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on dial grpCall button on overlay");
		crtgrp.visibleInprogressString();
		crtgrp.addMemberInOnGoingCallThroughContacts();
		logger_ss.log(Status.INFO, "Added Member In OnGoing Call Through Contacts");
		logger_ss.log(Status.INFO, "Expected all Members Count In GrpCall : 2");
		logger_ss.log(Status.INFO, "Actual all members count in grpCall is :");
		int allMembersCountInGrpCall= crtgrp.allMembersCountInGrpCall();
		logger_ss.log(Status.INFO, String.valueOf(allMembersCountInGrpCall) );
		
		Assert.assertEquals(crtgrp.allMembersCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");

		logger_ss.log(Status.INFO, "Expected unMuted Count In GrpCall : 2");
		logger_ss.log(Status.INFO, "Actual unMuted count in grpCall is :");
		int unMutedCountInGrpCall= crtgrp.unMutedCountInGrpCall();
		logger_ss.log(Status.INFO, String.valueOf(unMutedCountInGrpCall) );
	
		Assert.assertEquals(crtgrp.unMutedCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");

		logger_ss.log(Status.INFO, "Expected onCall Count In GrpCall : 2");
		logger_ss.log(Status.INFO, "Actual onCall Count In GrpCall :");
		int onCallCountInGrpCall= crtgrp.onCallCountInGrpCall();
		logger_ss.log(Status.INFO, String.valueOf(onCallCountInGrpCall) );
	
		Assert.assertEquals(crtgrp.onCallCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		logger_ss.log(Status.INFO, "Expected call Ended Count In GrpCall : 0");
		logger_ss.log(Status.INFO, "Actual call ended Count In GrpCall :");
		int callEndedCountInGrpCall= crtgrp.callEndedCountInGrpCall();
		logger_ss.log(Status.INFO, String.valueOf(callEndedCountInGrpCall) );

		Assert.assertEquals(crtgrp.callEndedCountInGrpCall(), 0);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		crtgrp.hangUpCurrentGrpTalkcall();
		crtgrp.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "hangUp Current GrpTalk call");
		logger_ss.log(Status.INFO, "Successfully verifed AddMemberInOnGoingGrpCallThroughContacts");
	}
	
	@Test
	public void verifyAddMemberInOnGoingGrpCallThroughWebList() throws InterruptedException {
		logger_ss = extent.createTest("verifyAddMemberInOnGoingGrpCallThroughWebList","verify Add Member In OnGoing GrpCall Through WebList");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactFromContactList();
		crtgrp.setGrpTalkName();
		crtgrp.submitSaveButton();
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		
		crtgrp.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		crtgrp.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on dial grpCall button on overlay");
		crtgrp.visibleInprogressString();
		crtgrp.addMemberInOnGoingCallThroughWebList();
		logger_ss.log(Status.INFO, "Added Member In OnGoing Call Through weblist");
		logger_ss.log(Status.INFO, "Expected all Members Count In GrpCall : 2");
		logger_ss.log(Status.INFO, "Actual all members count in grpCall is :");
		int allMembersCountInGrpCall= crtgrp.allMembersCountInGrpCall();
		logger_ss.log(Status.INFO, String.valueOf(allMembersCountInGrpCall) );
		
		Assert.assertEquals(crtgrp.allMembersCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");
		logger_ss.log(Status.INFO, "Expected unMuted Count In GrpCall : 2");
		logger_ss.log(Status.INFO, "Actual unMuted count in grpCall is :");
		int unMutedCountInGrpCall= crtgrp.unMutedCountInGrpCall();
		logger_ss.log(Status.INFO, String.valueOf(unMutedCountInGrpCall) );
	
		Assert.assertEquals(crtgrp.unMutedCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");

		logger_ss.log(Status.INFO, "Expected onCall Count In GrpCall : 2");
		logger_ss.log(Status.INFO, "Actual onCall Count In GrpCall :");
		int onCallCountInGrpCall= crtgrp.onCallCountInGrpCall();
		logger_ss.log(Status.INFO, String.valueOf(onCallCountInGrpCall) );
	
		Assert.assertEquals(crtgrp.onCallCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		logger_ss.log(Status.INFO, "Expected call Ended Count In GrpCall : 0");
		logger_ss.log(Status.INFO, "Actual call ended Count In GrpCall :");
		int callEndedCountInGrpCall= crtgrp.callEndedCountInGrpCall();
		logger_ss.log(Status.INFO, String.valueOf(callEndedCountInGrpCall) );

		Assert.assertEquals(crtgrp.callEndedCountInGrpCall(), 0);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "hangUp Current GrpTalk call");
		crtgrp.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verifed AddMemberInOnGoingGrpCallThroughWebList");
	}
	
	/*
	 * select GrpTalk Group By Name
	 * select history Button On MyGrpTalks
	 * Verify grpCall Duration In History Tab
	 * Verify total Minutes Consumed In GrpCall
	 * Verify total Amount Charged For Grpcall
	 * Verify group Total DialOut Mins On History
	 */
	
	@Test
	public void verifyHistoryOfGroup() throws InterruptedException {
		logger_ss = extent.createTest("verifyHistoryOfGroup","verify History Of Group");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		crtgrp.historyButtonOnMyGrpTalks();
		logger_ss.log(Status.INFO, "Clicked on history Button On MyGrpTalks");
		crtgrp.grpCallDurationInHistoryTab();
		logger_ss.log(Status.INFO, "Getting grp Call Duration In History Tab");
		crtgrp.totalMinutesConsumedInGrpCall();
		logger_ss.log(Status.INFO, "Getting total Minutes Consumed In GrpCall");
		crtgrp.totalAmountChargedForGrpcall();
		logger_ss.log(Status.INFO, "Getting total amount charged for GrpCall");
		crtgrp.groupTotalDialOutMinsOnHistory();
		logger_ss.log(Status.INFO, "Getting group Total DialOut Mins On History");
		
		logger_ss.log(Status.INFO, "Expected groupTotalDialOutMinsOnHistory is:");
		int groupTotalDialOutMinsOnHistory = crtgrp.groupTotalDialOutMinsOnHistory();
		logger_ss.log(Status.INFO, String.valueOf(groupTotalDialOutMinsOnHistory));
		
		logger_ss.log(Status.INFO, "Actual  totalMinutesConsumedInGrpCall is:");
		int totalMinutesConsumedInGrpCall= crtgrp.totalMinutesConsumedInGrpCall();
		logger_ss.log(Status.INFO, String.valueOf(totalMinutesConsumedInGrpCall));
		Assert.assertEquals(crtgrp.totalMinutesConsumedInGrpCall(), crtgrp.groupTotalDialOutMinsOnHistory());
		logger_ss.log(Status.INFO, "Successfully verified the total Minutes Consumed In GrpCall with group Total DialOut Mins On History");
		
		logger_ss.log(Status.INFO, "Expected totalAmountChargedForGroupOnHistory is:");
		double totalAmountChargedForGroupOnHistory = crtgrp.totalAmountChargedForGroupOnHistory();
		logger_ss.log(Status.INFO, String.valueOf(totalAmountChargedForGroupOnHistory));
		logger_ss.log(Status.INFO, "Actual  totalAmountChargedForGrpcall is:");
		double totalAmountChargedForGrpcall = crtgrp.totalAmountChargedForGrpcall();
		logger_ss.log(Status.INFO, String.valueOf(totalAmountChargedForGrpcall));
		Assert.assertEquals(crtgrp.totalAmountChargedForGrpcall(), crtgrp.totalAmountChargedForGroupOnHistory());
		logger_ss.log(Status.INFO, "Successfully verified the total Amount Charged For Grpcall with total Amount Charged For Group On History");
		logger_ss.log(Status.INFO, "Successfully verifed HistoryOfGroup");
	}
	
	/*
	 * click Create Grp button
	 * click Phone Contacts button
	 * select First User From Contact List
	 * set GrpTalk Name
	 * submit Schedule Button
	 * click on schedule Date And Time Field On Advanced Settings Overlay For Schedule
	 * increment DatePicker For Minutes
	 * click date Picker Set Button On Overlay
	 * click Schedule Button On Advanced Settings Overlay For Schedule
	 */
	
	@Test
	public void verifyScheduleGrpTalk() throws InterruptedException {
		logger_ss = extent.createTest("verifyScheduleGrpTalk","verify Schedule GrpTalk");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on createGroup button in myGrpTalk page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone Contacts tab in createGrpTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitScheduleButton();
		logger_ss.log(Status.INFO, "Submitted schedule button");
		crtgrp.scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "Click on schedule Date And Time Field On Advanced Settings Overlay For Schedule");
		crtgrp.incrementDatePickerForMinutes(1);
		logger_ss.log(Status.INFO, "incremented Minute in date picker overlay");
		crtgrp.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on set button on overlay");
		crtgrp.clickScheduleButtonOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "clicked on Schedule Button On Advanced Settings Overlay For Schedule grpTalk");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "selected Recently Saved GrpTalk Group");
		Assert.assertTrue(crtgrp.scheduleCancleButton());
		logger_ss.log(Status.INFO, "Successfully verified the scheduled grp Talk group");
	}
	
	/*
	 * click Create Grp button
	 * click Phone Contacts button
	 * select First User From Contact List
	 * set GrpTalk Name
	 * submit save button
	 * submit Save Group On Window/overlay
	 * select Recently Saved GrpTalk Group
	 * click Edit Button On MyGrpTalks Page
	 * click Schedule Date And Time Field On Edit Group Talk Page
	 * increment Date Picker For Minutes
	 * click date Picker Set Button On Overlay
	 * click Save Grp Call On Edit Grp Talk
	 */
	
	@Test
	public void verifyDatePickerFunctionalityForScheduleOnEditGrpTalks() throws InterruptedException {
		logger_ss = extent.createTest("verifyDatePickerFunctionalityForScheduleOnEditGrpTalks","verify DatePicker Functionality For Schedule On Edit GrpTalks");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "Submitted saveGroup button on overlay");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		crtgrp.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
		crtgrp.clickScheduleDateAndTimeFieldOnEditGroupTalkPage();
		logger_ss.log(Status.INFO, "clicked on Schedule Date And Time Field On Edit GroupTalk Page");
		crtgrp.incrementDatePickerForMinutes(1);
		logger_ss.log(Status.INFO, "incremented one minute on DatePicker overlay");
		String dateAndTime = crtgrp.dateAndTimeTextOnOverlay();
		crtgrp.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "clicked on date Picker Set Button On Overlay");
		crtgrp.clickRepeatDaysFiledOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Repeat Days Filed On Edit GrpTalk");
		String s= crtgrp.repeatDaysOnAdvancedSettingsOverlayForScheduleInEditGrpTalk();
		logger_ss.log(Status.INFO, "Selected repeatDays On Advanced Settings Overlay For Schedule");
		crtgrp.setButtonONOverlayOnEditGrpTalk();
		logger_ss.log(Status.INFO, "Clicked on set Button ON Overlay On Edit GrpTalk");
		crtgrp.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "Clicked on save grp call button on edit grpTalk ");
		//Assert.assertEquals(crtgrp.scheduleTimeAndRepeateDaysTextOfGroupOnMyGrpTalk(), dateAndTime);
		logger_ss.log(Status.INFO, "successfully verified DatePickerFunctionalityForScheduleOnEditGrpTalks");
	}
	@Test
	public void verifyDatePickerFunctionalityOnEditGrpTalks() throws InterruptedException {
		logger_ss = extent.createTest("verifyDatePickerFunctionalityOnEditGrpTalks","verify Date Picker Functionality On Edit GrpTalks");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "Submitted saveGroup button on overlay");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		crtgrp.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
		crtgrp.clickScheduleDateAndTimeFieldOnEditGroupTalkPage();
		logger_ss.log(Status.INFO, "clicked on Schedule Date And Time Field On Edit GroupTalk Page");
		crtgrp.incrementDatePickerForMinutes(11);
		logger_ss.log(Status.INFO, "incremented minutes on DatePicker overlay");
		crtgrp.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "clicked on date Picker Set Button On Overlay");
		crtgrp.clickScheduleDateAndTimeFieldOnEditGroupTalkPage();
		logger_ss.log(Status.INFO, "clicked on Schedule Date And Time Field On Edit GroupTalk Page");
		String initialDateAndTime = crtgrp.dateAndTimeTextOnOverlay();
		logger_ss.log(Status.INFO, "Getting initial Date And Time on overlay is:: ");
		logger_ss.log(Status.INFO, initialDateAndTime);
		crtgrp.incrementDateAndTimeOnOverlay(3);
		logger_ss.log(Status.INFO, "incremented Date And Time On Overlay ");
		String incrementDateAndTime = crtgrp.dateAndTimeTextOnOverlay();
		logger_ss.log(Status.INFO, "Getting increment Date And Time on overlay is:: ");
		logger_ss.log(Status.INFO, incrementDateAndTime);
		crtgrp.decrementDateAndTimeOnOverlay(3);
		logger_ss.log(Status.INFO, "Decremented Date And Time On Overlay ");
		
		String decrementDateAndTime = crtgrp.dateAndTimeTextOnOverlay();
		logger_ss.log(Status.INFO, "Getting decrement Date And Time on overlay is:: ");
		logger_ss.log(Status.INFO, decrementDateAndTime);
		Assert.assertEquals(initialDateAndTime, decrementDateAndTime);
		logger_ss.log(Status.INFO, "Successfully verified the initial Date and Time with decrement date and time");
		
		crtgrp.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on date Picker Set Button On Overlay");
		crtgrp.clickRepeatDaysFiledOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Repeat Days Filed On Edit GrpTalk");
		String s= crtgrp.repeatDaysOnAdvancedSettingsOverlayForScheduleInEditGrpTalk();
		logger_ss.log(Status.INFO, "Selected repeatDays On Advanced Settings Overlay For Schedule");
		crtgrp.setButtonONOverlayOnEditGrpTalk();
		logger_ss.log(Status.INFO, "Clicked on set Button ON Overlay On Edit GrpTalk");
		crtgrp.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "Clicked on save grp call button on edit grpTalk ");
		logger_ss.log(Status.INFO, "Successfully verified the DatePickerFunctionalityOnEditGrpTalks");
	}
	
	/*
	 * click Create Grp button
	 * click Phone Contacts button
	 * select User From Contact List
	 * set GrpTalk Name
	 * submit save button
	 * submit Save Group On Window/overlay
	 * select Recently Saved GrpTalk Group
	 * click Edit Button On MyGrpTalks Page
	 * click Repeat Days Filed On Edit GrpTalk
	 * select repeat Days On Advanced Settings Overlay For Schedule
	 * submit set Button ON Overlay On Edit GrpTalk
	 * click Save GrpCall On Edit GrpTalk
	 * select Recently Saved GrpTalk Group
	 * Verify Repeat Days Text Of Group On My GrpTalk
	 */
	@Test
	public void verifyRepeatDaysFunctionalityOnEditGrpTalks() throws InterruptedException {
		logger_ss = extent.createTest("verifyRepeatDaysFunctionalityOnEditGrpTalks","verify Repeat Days Functionality On Edit GrpTalks");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "Submitted saveGroup button on overlay");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		crtgrp.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
		crtgrp.clickRepeatDaysFiledOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Repeat Days Filed On Edit GrpTalk");
		String s= crtgrp.repeatDaysOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "Selected repeatDays On Advanced Settings Overlay For Schedule");
		crtgrp.setButtonONOverlayOnEditGrpTalk();
		logger_ss.log(Status.INFO, "Clicked on set Button ON Overlay On Edit GrpTalk");
		crtgrp.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "Clicked on save grp call button on edit grpTalk ");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		logger_ss.log(Status.INFO, "Expected days: ");
		logger_ss.log(Status.INFO, s);
		String actualResult = crtgrp.scheduleRepeateDaysTextOfGroupOnMyGrpTalk();
		logger_ss.log(Status.INFO, "Actual days: ");
		logger_ss.log(Status.INFO, actualResult);
		Assert.assertEquals(actualResult, s);
		logger_ss.log(Status.INFO, "Successfully verified the Repeat Days Functionality On Edit GrpTalks ");
	}
	
	/* select Grp Talk Group By Name
	 * click Edit Button On My Grp Talks Page
	 * click Advaced Setting On Edit Grp Talk page
	 * click on Off Switch Label For DialIn Only On Advanced Settings In Edit GrpTalk
	 * click save Button On Advanced Setting In Edit GrpTalk
	 * click Save Grp Call On Edit GrpTalk
	 * select Grp Talk Group By Name
	 * verify dialIn Msg For Grp On My Grp Talks
	 */
	@Test
	public void VerifyDialInOptionInAdvancedSettingsOnOverlayForSchedule() throws InterruptedException {
		logger_ss = extent.createTest("VerifyDialInOptionInAdvancedSettingsOnOverlayForSchedule","VerifyDialInOptionInAdvancedSettingsOnOverlayForSchedule");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitScheduleButton();
		logger_ss.log(Status.INFO, "submited ScheduleButton");
		crtgrp.onOffSwitchLabelForDialInOnlyOptionOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "clicked on onOffSwitchLabelForDialInOnlyOptionOnAdvancedSettingsOverlayForSchedule");
		Assert.assertTrue(crtgrp.visibilityOfOnOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettings());
		logger_ss.log(Status.INFO, "verified visibilityOfOnOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettings");
		crtgrp.scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "Click on schedule Date And Time Field On Advanced Settings Overlay For Schedule");
		crtgrp.incrementDatePickerForMinutes(30);
		logger_ss.log(Status.INFO, "incremented DatePickerForMinutes");
		crtgrp.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on datePicker set button on overlay");
		crtgrp.onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk");
		crtgrp.clickScheduleButtonOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "clicked on Schedule Button On Advanced Settings Overlay For Schedule grpTalk");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		crtgrp.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
		crtgrp.clickAdvacedSettingOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on AdvacedSettingOnEditGrpTalk");
		Assert.assertTrue(crtgrp.visibilityOfOnOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettings());
		logger_ss.log(Status.INFO, "verified visibilityOfOnOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettings");
		crtgrp.saveButtonOnAdvancedSettingInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on saveButtonOnAdvancedSettingInEditGrpTalk");
		crtgrp.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on SaveGrpCallOnEditGrpTalk");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		logger_ss.log(Status.INFO, "Successfully verified DialInOptionInAdvancedSettingsOnOverlayForSchedule");
	}
	@Test
	public void VerifyAssignCallManagerOptionInAdvancedSettingsOnOverlayForSchedule() throws InterruptedException {
		logger_ss = extent.createTest("VerifyAssignCallManagerOptionInAdvancedSettingsOnOverlayForSchedule","VerifyAssignCallManagerOptionInAdvancedSettingsOnOverlayForSchedule");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitScheduleButton();
		logger_ss.log(Status.INFO, "submited ScheduleButton");
		crtgrp.onOffSwitchLabelForAssignCallManagerOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "Clicked on onOffSwitchLabelForAssignCallManagerOnAdvancedSettingsOverlayForSchedule");
		Assert.assertTrue(crtgrp.visibilityOfselectMemberFieldToManageCallOnOverlay());
		logger_ss.log(Status.INFO, "verified visibilityOfselectMemberFieldToManageCallOnOverlay");
		crtgrp.enterContactDetailsInSelectMemberFieldToManageCallOnOverlay();
		logger_ss.log(Status.INFO, "entered ContactDetailsInSelectMemberFieldToManageCallOnOverlay");
		crtgrp.scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "Click on schedule Date And Time Field On Advanced Settings Overlay For Schedule");
		crtgrp.incrementDatePickerForMinutes(3);
		logger_ss.log(Status.INFO, "incremented DatePickerForMinutes");
		crtgrp.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on datePicker set button on overlay");
		crtgrp.clickScheduleButtonOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "clicked on Schedule Button On Advanced Settings Overlay For Schedule grpTalk");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		Assert.assertTrue(crtgrp.visibilityOfCallManagerOptionForContacts());
		logger_ss.log(Status.INFO, "Successfully verified visibilityOfCallManagerOptionForContacts");
		logger_ss.log(Status.INFO, "Successfully verified AssignCallManagerOptionInAdvancedSettingsOnOverlayForSchedule");
	}
	@Test
	public void VerifyDialInOptionInAdvancedSettingsOnOverlayInEditGrpTalk() throws InterruptedException {
		logger_ss = extent.createTest("VerifyDialInOptionInAdvancedSettingsOnOverlayInEditGrpTalk","Verify DialIn Option In Advanced Settings On Overlay In Edit GrpTalk");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactFromContactList();
		crtgrp.setGrpTalkName();
		crtgrp.submitSaveButton();
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		crtgrp.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button in MyGrpTalks Page");
		crtgrp.clickAdvacedSettingOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Advaced Settings in Edit GrpTalk");
		crtgrp.onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on onOff Switch Label For DialIn Only On Advanced Settings In Edit GrpTalk");
		crtgrp.saveButtonOnAdvancedSettingInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on save Button On Advanced Setting In Edit GrpTalk");
		crtgrp.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Save GrpCall On Edit GrpTalk");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		logger_ss.log(Status.INFO, "Expected dailIn msg is: Dial in Only");
		logger_ss.log(Status.INFO, "Actual dailIn msg is:");
		logger_ss.log(Status.INFO, crtgrp.dialInMsgForGrpOnMyGrpTalks());
		Assert.assertEquals(crtgrp.dialInMsgForGrpOnMyGrpTalks(), "Dial in Only");
		logger_ss.log(Status.INFO, "Successfully verified dialIn Msg For Grp On MyGrpTalks");
		crtgrp.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button in MyGrpTalks Page");
		crtgrp.clickAdvacedSettingOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Advaced Settings in Edit GrpTalk");
		crtgrp.onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on onOff Switch Label For DialIn Only On Advanced Settings In Edit GrpTalk");
		crtgrp.saveButtonOnAdvancedSettingInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on save Button On Advanced Setting In Edit GrpTalk");
		crtgrp.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Save GrpCall On Edit GrpTalk");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		logger_ss.log(Status.INFO, "Successfully verified DialInOptionInAdvancedSettingsOnOverlayInEditGrpTalk");
	}
	
	/* select GrpTalk Group By Name
	 * click Edit Button On My GrpTalks Page
	 * click Advanced Setting On Edit GrpTalk page
	 * click on Off Switch Label For Allow NonMembers On Advanced Settings In Edit GrpTalk
	 * click save Button On Advanced Setting In Edit GrpTalk
	 * click Save Grp Call On Edit GrpTalk
	 * select Grp Talk Group By Name
	 * verify dialIn Msg For Grp On My Grp Talks
	 */
	
	@Test
	public void VerifyAllowNonMembersOptionInAdvancedSettingsOnOverlayInEditGrpTalk() throws InterruptedException {
		logger_ss = extent.createTest("VerifyAllowNonMembersOptionInAdvancedSettingsOnOverlayInEditGrpTalk","Verify Allow Non Members Option In Advanced Settings On Overlay In Edit GrpTalk");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		crtgrp.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button in MyGrpTalks Page");
		crtgrp.clickAdvacedSettingOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Advaced Settings in Edit GrpTalk");
		crtgrp.onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on onOff Switch Label For AllowNonMembers On Advanced Settings In Edit GrpTalk");
		crtgrp.saveButtonOnAdvancedSettingInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on save Button On Advanced Setting In Edit GrpTalk");
		crtgrp.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Save GrpCall On Edit GrpTalk");
		crtgrp.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		logger_ss.log(Status.INFO, "Expected dailIn msg is: Non Members can Dial in Using Conference PIN 446557");
		logger_ss.log(Status.INFO, "Actual dailIn msg is:");
		logger_ss.log(Status.INFO, crtgrp.dialInMsgForGrpOnMyGrpTalks());
		Assert.assertEquals(crtgrp.dialInMsgForGrpOnMyGrpTalks(), "Non Members can Dial in Using Conference PIN 446557");
		logger_ss.log(Status.INFO, "Successfully verified 'Non Members can Dial in Using Conference PIN 530187' Msg For Grp On MyGrpTalks");
		crtgrp.clickEditButtonOnMyGrpTalksPage();
		crtgrp.clickAdvacedSettingOnEditGrpTalk();
		crtgrp.onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk();
		crtgrp.saveButtonOnAdvancedSettingInEditGrpTalk();
		crtgrp.clickSaveGrpCallOnEditGrpTalk();
	}
	
	/* select Grp Talk Group By Name
	 * click Edit Button On My Grp Talks Page
	 * click Advaced Setting On Edit Grp Talk page
	 * click on Off Switch Label For DialIn Only On Advanced Settings In Edit GrpTalk
	 * click on Off Switch Label For Allow NonMembers On Advanced Settings In Edit GrpTalk
	 * click save Button On Advanced Setting In Edit GrpTalk
	 * click Save Grp Call On Edit GrpTalk
	 * select Grp Talk Group By Name
	 * verify dialIn Msg For Grp On My Grp Talks
	 * 
	 */
	@Test
	public void VerifyDialInOptionAndAllowNonMembersOptionInAdvancedSettingsOnOverlayInEditGrpTalk() throws InterruptedException {
		logger_ss = extent.createTest("VerifyDialInOptionAndAllowNonMembersOptionInAdvancedSettingsOnOverlayInEditGrpTalk","Verify DialIn Option And AllowNonMembers Option In Advanced Settings On Overlay In EditGrpTalk");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		crtgrp.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button in MyGrpTalks Page");
		crtgrp.clickAdvacedSettingOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Advaced Settings in Edit GrpTalk");
		crtgrp.onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on onOff Switch Label For DialInOnly On Advanced Settings In Edit GrpTalk");
		crtgrp.onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on onOff Switch Label For AllowNonMembers On Advanced Settings In Edit GrpTalk");
		crtgrp.saveButtonOnAdvancedSettingInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on save Button On Advanced Setting In Edit GrpTalk");
		crtgrp.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Save GrpCall On Edit GrpTalk");
		crtgrp.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		logger_ss.log(Status.INFO, "Expected dailIn msg is: Dial In Only & Non Members allowed using Conference PIN 446557");
		logger_ss.log(Status.INFO, "Actual dailIn msg is:");
		logger_ss.log(Status.INFO, crtgrp.dialInMsgForGrpOnMyGrpTalks());
		Assert.assertEquals(crtgrp.dialInMsgForGrpOnMyGrpTalks(), "Dial In Only & Non Members allowed using Conference PIN 446557");
		logger_ss.log(Status.INFO, "Successfully verified dialIn Msg For Grp On MyGrpTalks");
		crtgrp.clickEditButtonOnMyGrpTalksPage();
		crtgrp.clickAdvacedSettingOnEditGrpTalk();
		crtgrp.onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk();
		crtgrp.onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk();
		crtgrp.saveButtonOnAdvancedSettingInEditGrpTalk();
		crtgrp.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "Successfully verified DialInOptionAndAllowNonMembersOptionInAdvancedSettingsOnOverlayInEditGrpTalk");
	}
	
	@Test
	public void verifyCallFunctionalityOfDialAllButtonInCallEndedTab() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityOfDialAllButtonInCallEndedTab","verifyCallFunctionalityOfDialAllButtonInCallEndedTab");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactsFromContactList();
		crtgrp.setGrpTalkName();
		crtgrp.submitStartNowButton();
		crtgrp.dialGroupCallButtonOnOverlayInCreateGrpTalk();
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by StartNowButton");
		crtgrp.visibleInprogressString();
		int allMembersCountInGrpCall=crtgrp.allMembersCountInGrpCall();
		Assert.assertEquals(allMembersCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified allMembersCountInGrpCall ");
		int onCallCountInGrpCall=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int unMutedCountInGrpCall=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		int callEndedCountInGrpCall=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		
		crtgrp.allMembersCountInGrpCall();
		
		crtgrp.clickOnIndividualUserHangUpButtomInGrpCall();
		
		Assert.assertEquals(crtgrp.allMembersCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");

		Assert.assertEquals(crtgrp.unMutedCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");

		Assert.assertEquals(crtgrp.onCallCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		Assert.assertEquals(crtgrp.callEndedCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");

		crtgrp.clickDialAllButtonInCallEndedTab();
		crtgrp.allMembersCountInGrpCall();
		Assert.assertEquals(crtgrp.unMutedCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");

		Assert.assertEquals(crtgrp.onCallCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		Assert.assertEquals(crtgrp.callEndedCountInGrpCall(), 0);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		crtgrp.submitRateCallByClickingBadOption();
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Successfully verifed CallFunctionalityOfDialAllButtonInCallEndedTab");
	}
	
	@Test
	public void verifyCallFunctionalityOfIndividualDialInCallEndedTab() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityOfIndividualDialInCallEndedTab","verifyCallFunctionalityOfIndividualDialInCallEndedTab");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactsFromContactList();
		crtgrp.setGrpTalkName();
		crtgrp.submitStartNowButton();
		crtgrp.dialGroupCallButtonOnOverlayInCreateGrpTalk();
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		crtgrp.visibleInprogressString();
		int allMembersCountInGrpCall=crtgrp.allMembersCountInGrpCall();
		Assert.assertEquals(allMembersCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");
		int onCallCountInGrpCall=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		int unMutedCountInGrpCall=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		int callEndedCountInGrpCall=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		crtgrp.allMembersCountInGrpCall();
		crtgrp.clickOnIndividualUserHangUpButtomInGrpCall();
		logger_ss.log(Status.INFO, "clicked On IndividualUserHangUpButtomInGrpCall");
		Assert.assertEquals(crtgrp.allMembersCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");
		Assert.assertEquals(crtgrp.unMutedCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		Assert.assertEquals(crtgrp.onCallCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		Assert.assertEquals(crtgrp.callEndedCountInGrpCall(), 1);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		crtgrp.clickreDialButtonOfIndividualContactInLiveCall();
		logger_ss.log(Status.INFO, "clicked on reDial ButtonOfIndividualContactInLiveCall");
		Assert.assertEquals(crtgrp.unMutedCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		Assert.assertEquals(crtgrp.onCallCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		Assert.assertEquals(crtgrp.callEndedCountInGrpCall(), 0);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		crtgrp.submitRateCallByClickingGoodOption();
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Successfully verifed CallFunctionalityOfIndividualDialInCallEndedTab");
	}
	
	@Test
	public void verifyCallFunctionalityWhenMuteAllButtonIsClickedInUnMutedTab() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityWhenMuteAllButtonIsClickedInUnMutedTab","verifyCallFunctionalityWhenMuteAllButtonIsClickedInUnMutedTab");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactsFromContactList();
		crtgrp.setGrpTalkName();
		crtgrp.submitStartNowButton();
		crtgrp.dialGroupCallButtonOnOverlayInCreateGrpTalk();
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		crtgrp.visibleInprogressString();
		int allMembersCountInGrpCall=crtgrp.allMembersCountInGrpCall();
		Assert.assertEquals(allMembersCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified allMembersCountInGrpCall ");
		int onCallCountInGrpCall=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int callEndedCountInGrpCall=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		int unMutedCountInGrpCall=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		crtgrp.clickMuteAllButtonInUnMutedTab();
		logger_ss.log(Status.INFO, "clicked on MuteAllButtonInUnMutedTab");
		Assert.assertEquals(crtgrp.allMembersCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");

		Assert.assertEquals(crtgrp.unMutedCountInGrpCall(), 0);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");

		Assert.assertEquals(crtgrp.onCallCountInGrpCall(), 2);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		Assert.assertEquals(crtgrp.callEndedCountInGrpCall(), 0);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");

		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		crtgrp.submitRateCallByClickingGoodOption();
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Successfully verifed CallFunctionalityWhenMuteAllButtonIsClickedInUnMutedTab");
	}
	
	
	@Test
	public void verifyCallFunctionalityForPrivateRoomTab() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityForPrivateRoomTab","verifyCallFunctionalityForPrivateRoomTab");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactsFromContactList();
		crtgrp.setGrpTalkName();
		crtgrp.submitStartNowButton();
		crtgrp.dialGroupCallButtonOnOverlayInCreateGrpTalk();
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		crtgrp.visibleInprogressString();
		int allMembersCountInGrpCall=crtgrp.allMembersCountInGrpCall();
		Assert.assertEquals(allMembersCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified allMembersCountInGrpCall ");
		int onCallCountInGrpCall=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int callEndedCountInGrpCall=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		int unMutedCountInGrpCall=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		int privateRoomMembersCountInGrpCall = crtgrp.privateRoomMembersCountInGrpCall();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		crtgrp.allMembersCountInGrpCall();
		crtgrp.clickPublicRoomButtonOfContact();
		logger_ss.log(Status.INFO, "clicked on PublicRoomButtonOfContact");
		int onCallCountInGrpCall2=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall2=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall2 = crtgrp.privateRoomMembersCountInGrpCall();
		Assert.assertTrue(crtgrp.visibilityOfClosePrivateRoomButtonInPrivateRoomTab());
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");

		crtgrp.clickClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "clicked on ClosePrivateRoomButtonInPrivateRoomTab");
		int privateRoomMembersCountInGrpCall3 = crtgrp.privateRoomMembersCountInGrpCall();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		logger_ss.log(Status.INFO, "Successfully verified private RoomMembersCountInGrpCall");
		int onCallCountInGrpCall3=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall3,2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int unMutedCountInGrpCall3=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall3,2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		crtgrp.allMembersCountInGrpCall();
		crtgrp.clickPublicRoomButtonOfContact();
		logger_ss.log(Status.INFO, "clicked on PublicRoomButtonOfContact");
		int privateRoomMembersCountInGrpCall4 = crtgrp.privateRoomMembersCountInGrpCall();
		Assert.assertEquals(privateRoomMembersCountInGrpCall4,1);
		logger_ss.log(Status.INFO, "Successfully verified private RoomMembersCountInGrpCall");
		crtgrp.clickPrivateRoomButton();
		logger_ss.log(Status.INFO, "clicked on PrivateRoomButton");
		int privateRoomMembersCountInGrpCall5 = crtgrp.privateRoomMembersCountInGrpCall();
		Assert.assertEquals(privateRoomMembersCountInGrpCall5,0);
		logger_ss.log(Status.INFO, "Successfully verified private RoomMembersCountInGrpCall");
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		crtgrp.submitRateCallByClickingGoodOption();
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Successfully verifed CallFunctionalityForPrivateRoomTab");
	}
	
	@Test
	public void verifyCallFunctionalityFromAllMembersTab() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromAllMembersTab","verifyCallFunctionalityFromAllMembersTab");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactsFromContactList();
		crtgrp.setGrpTalkName();
		crtgrp.submitStartNowButton();
		crtgrp.dialGroupCallButtonOnOverlayInCreateGrpTalk();
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		crtgrp.visibleInprogressString();
		int allMembersCountInGrpCall=crtgrp.allMembersCountInGrpCall();
		Assert.assertEquals(allMembersCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified allMembersCountInGrpCall ");
		int onCallCountInGrpCall=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int callEndedCountInGrpCall=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCountInGrpCall ");
		int unMutedCountInGrpCall=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		int privateRoomMembersCountInGrpCall = crtgrp.privateRoomMembersCountInGrpCall();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);		
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		crtgrp.allMembersCountInGrpCall();
		crtgrp.clickUnMuteButtonOfIndividualContactInLiveCall();
		logger_ss.log(Status.INFO, "clicked on UnMuteButtonOfIndividualContactInLiveCall");
		Assert.assertTrue(crtgrp.visibilityOFMuteButtonOfIndividualContactInLiveCall());
		
		int unMutedCountInGrpCall2=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		crtgrp.allMembersCountInGrpCall();
		crtgrp.clickMuteButtonOfIndividualContactInLiveCall();
		logger_ss.log(Status.INFO, "clicked on MuteButtonOfIndividualContactInLiveCall");
		Assert.assertTrue(crtgrp.visibilityOFUnMuteButtonOfIndividualContactInLiveCall());
		
		int unMutedCountInGrpCall3=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall3,2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		crtgrp.allMembersCountInGrpCall();
		crtgrp.clickPublicRoomButtonOfContact();
		logger_ss.log(Status.INFO, "clicked on PublicRoomButtonOfContact");
		Assert.assertTrue(crtgrp.visibilityOFPrivateRoomButtonInLiveCall());
		
		int onCallCountInGrpCall2=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int privateRoomMembersCountInGrpCall2 = crtgrp.privateRoomMembersCountInGrpCall();
		crtgrp.visibilityOfClosePrivateRoomButtonInPrivateRoomTab();
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		crtgrp.allMembersCountInGrpCall();
		crtgrp.clickPrivateRoomButton();
		logger_ss.log(Status.INFO, "clicked on PrivateRoomButton");
		Assert.assertTrue(crtgrp.visibilityOFPublicRoomButtonInLiveCall());
		
		int privateRoomMembersCountInGrpCall3 = crtgrp.privateRoomMembersCountInGrpCall();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		crtgrp.allMembersCountInGrpCall();
		crtgrp.clickhangUpButtonOfIndividualContactInLiveCall();
		logger_ss.log(Status.INFO, "clicked on hangUpButtonOfIndividualContactInLiveCall");
		Assert.assertTrue(crtgrp.visibilityOFReDialButtonOfIndividualContactInLiveCall());
		
		int callEndedCountInGrpCall2=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCountInGrpCall ");
		crtgrp.allMembersCountInGrpCall();
		crtgrp.clickreDialButtonOfIndividualContactInLiveCall();
		logger_ss.log(Status.INFO, "clicked on reDial ButtonOfIndividualContactInLiveCall");
		Assert.assertTrue(crtgrp.visibilityOFHangUpButtonOfIndividualContactInLiveCall());
		
		int callEndedCountInGrpCall3=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall3,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCountInGrpCall ");
		int onCallCountInGrpCall3=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall3,2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		crtgrp.submitRateCallByClickingGoodOption();
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Successfully verified CallFunctionalityFromAllMembersTab ");
	}
	
	@Test
	public void verifyCallFunctionalityFromOnCallTab() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromOnCallTab","verifyCallFunctionalityFromOnCallTab");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactsFromContactList();
		crtgrp.setGrpTalkName();
		crtgrp.submitStartNowButton();
		crtgrp.dialGroupCallButtonOnOverlayInCreateGrpTalk();
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		crtgrp.visibleInprogressString();
		int allMembersCountInGrpCall=crtgrp.allMembersCountInGrpCall();
		Assert.assertEquals(allMembersCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified allMembersCountInGrpCall ");
		int onCallCountInGrpCall=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int callEndedCountInGrpCall=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCountInGrpCall ");
		int unMutedCountInGrpCall=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		int privateRoomMembersCountInGrpCall = crtgrp.privateRoomMembersCountInGrpCall();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);		
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");		
		crtgrp.onCallCountInGrpCall();
		crtgrp.clickUnMuteButtonOfIndividualContactInLiveCall();
		logger_ss.log(Status.INFO, "clicked on UnMuteButtonOfIndividualContactInLiveCall");
		Assert.assertTrue(crtgrp.visibilityOFMuteButtonOfIndividualContactInLiveCall());
		
		int unMutedCountInGrpCall2=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		crtgrp.onCallCountInGrpCall();
		crtgrp.clickMuteButtonOfIndividualContactInLiveCall();
		logger_ss.log(Status.INFO, "clicked on MuteButtonOfIndividualContactInLiveCall");
		Assert.assertTrue(crtgrp.visibilityOFUnMuteButtonOfIndividualContactInLiveCall());
		
		int unMutedCountInGrpCall3=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall3,2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		crtgrp.onCallCountInGrpCall();
		crtgrp.clickPublicRoomButtonOfContact();
		//Assert.assertTrue(crtgrp.visibilityOFPrivateRoomButtonInLiveCall());
		logger_ss.log(Status.INFO, "clicked on PublicRoomButtonOfContact ");
		int onCallCountInGrpCall2=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int privateRoomMembersCountInGrpCall2 = crtgrp.privateRoomMembersCountInGrpCall();
		crtgrp.visibilityOfClosePrivateRoomButtonInPrivateRoomTab();
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");	
		crtgrp.clickClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "clicked on ClosePrivateRoomButtonInPrivateRoomTab ");
		int privateRoomMembersCountInGrpCall3 = crtgrp.privateRoomMembersCountInGrpCall();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");	
		int onCallCountInGrpCall3=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall3,2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		Assert.assertTrue(crtgrp.visibilityOFPublicRoomButtonInLiveCall());
		
		crtgrp.onCallCountInGrpCall();
		crtgrp.clickhangUpButtonOfIndividualContactInLiveCall();
		logger_ss.log(Status.INFO, "clicked on hangUpButtonOfIndividualContactInLiveCall ");
		//Assert.assertTrue(crtgrp.visibilityOFReDialButtonOfIndividualContactInLiveCall());
		
		int callEndedCountInGrpCall2=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCountInGrpCall ");
		crtgrp.allMembersCountInGrpCall();
		crtgrp.clickreDialButtonOfIndividualContactInLiveCall();
		logger_ss.log(Status.INFO, "clicked on reDialButtonOfIndividualContactInLiveCall ");
		Assert.assertTrue(crtgrp.visibilityOFHangUpButtonOfIndividualContactInLiveCall());
		
		int callEndedCountInGrpCall3=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall3,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCountInGrpCall ");
		int onCallCountInGrpCall4=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall4,2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		crtgrp.submitRateCallByClickingExcelentOption();
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Successfully verified CallFunctionalityFromOnCallTab ");
	}
	
	@Test
	public void verifyCallFunctionalityFromUnMutedCount() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromUnMutedCount","verifyCallFunctionalityFromUnMutedCount");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactsFromContactList();
		crtgrp.setGrpTalkName();
		crtgrp.submitStartNowButton();
		crtgrp.dialGroupCallButtonOnOverlayInCreateGrpTalk();
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		crtgrp.visibleInprogressString();
		int allMembersCountInGrpCall=crtgrp.allMembersCountInGrpCall();
		Assert.assertEquals(allMembersCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified allMembersCountInGrpCall ");
		int onCallCountInGrpCall=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int callEndedCountInGrpCall=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCountInGrpCall ");
		int unMutedCountInGrpCall=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall,2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		int privateRoomMembersCountInGrpCall = crtgrp.privateRoomMembersCountInGrpCall();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);		
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");	
		crtgrp.unMutedCountInGrpCall();
		crtgrp.clickUnMuteButtonOfIndividualContactInLiveCall();
		logger_ss.log(Status.INFO, "clicked on UnMuteButtonOfIndividualContactInLiveCall");	
		crtgrp.allMembersCountInGrpCall();
		Assert.assertTrue(crtgrp.visibilityOFMuteButtonOfIndividualContactInLiveCall());
		int unMutedCountInGrpCall2=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		crtgrp.onCallCountInGrpCall();
		crtgrp.clickMuteButtonOfIndividualContactInLiveCall();
		logger_ss.log(Status.INFO, "clicked on MuteButtonOfIndividualContactInLiveCall");	
		Assert.assertTrue(crtgrp.visibilityOFUnMuteButtonOfIndividualContactInLiveCall());
		
		int unMutedCountInGrpCall3=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall3,2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		crtgrp.unMutedCountInGrpCall();
		crtgrp.clickPublicRoomButtonOfContact();
		logger_ss.log(Status.INFO, "clicked on PublicRoomButtonOfContact");	
		int onCallCountInGrpCall2=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		int privateRoomMembersCountInGrpCall2 = crtgrp.privateRoomMembersCountInGrpCall();
		crtgrp.visibilityOfClosePrivateRoomButtonInPrivateRoomTab();
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		crtgrp.clickClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "clicked on ClosePrivateRoomButtonInPrivateRoomTab");	
		int privateRoomMembersCountInGrpCall3 = crtgrp.privateRoomMembersCountInGrpCall();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		int onCallCountInGrpCall3=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall3,2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		Assert.assertTrue(crtgrp.visibilityOFPublicRoomButtonInLiveCall());
		
		int unMutedCountInGrpCall4=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall4,2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		crtgrp.unMutedCountInGrpCall();
		crtgrp.clickhangUpButtonOfIndividualContactInLiveCall();
		logger_ss.log(Status.INFO, "clicked on hangUpButtonOfIndividualContactInLiveCall");	
	//	Assert.assertTrue(crtgrp.visibilityOFReDialButtonOfIndividualContactInLiveCall());
		
		int callEndedCountInGrpCall2=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall2,1);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCountInGrpCall ");
		int unMutedCountInGrpCall5=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall5,1);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		crtgrp.allMembersCountInGrpCall();
		crtgrp.clickreDialButtonOfIndividualContactInLiveCall();
		logger_ss.log(Status.INFO, "clicked on reDialButtonOfIndividualContactInLiveCall ");
		Assert.assertTrue(crtgrp.visibilityOFHangUpButtonOfIndividualContactInLiveCall());
		
		int callEndedCountInGrpCall3=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall3,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCountInGrpCall ");
		int onCallCountInGrpCall4=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall4,2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int unMutedCountInGrpCall6=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall6,2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		crtgrp.submitRateCallByClickingBadOption();
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Successfully verified CallFunctionalityFromUnMutedCount ");
	}
	
	
	@Test
	public void verifyMuteDialFunctionalityFromScheduleOverlay() throws InterruptedException {
		logger_ss = extent.createTest("verifyMuteDialFunctionalityFromScheduleOverlay","verifyMuteDialFunctionalityFromScheduleOverlay");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on createGroup button in myGrpTalk page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone Contacts tab in createGrpTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitScheduleButton();
		logger_ss.log(Status.INFO, "Submitted schedule button");
		
		crtgrp.onOffSwitchLabelForMuteDialOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "Clicked on onOffSwitchLabelForMuteDialOnAdvancedSettingsOverlayForSchedule");
		crtgrp.scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "Click on schedule Date And Time Field On Advanced Settings Overlay For Schedule");
		crtgrp.decrementDatePickerForMinutes(8);
		logger_ss.log(Status.INFO, "decremented Minute in date picker overlay");
		crtgrp.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on set button on overlay");
		
		crtgrp.selectAllRepeatDaysOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "selected AllRepeatDaysOnAdvancedSettingsOverlayForSchedule");
		crtgrp.clickScheduleButtonOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "clicked on Schedule Button On Advanced Settings Overlay For Schedule grpTalk");
		
		Thread.sleep(121000);
		driver.navigate().to("https://web.grptalk.com/MyGrpTalks.aspx");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "selected Recently Saved GrpTalk Group");
		
		crtgrp.visibleInprogressString();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		
		Assert.assertTrue(crtgrp.visibilityOfMuteBuutonInGrpCall());

		int allMembersCountInGrpCall=crtgrp.allMembersCountInGrpCall();
		Assert.assertEquals(allMembersCountInGrpCall,1);
		logger_ss.log(Status.INFO, "Successfully verified allMembersCountInGrpCall ");
		
		int onCallCountInGrpCall=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall,1);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int unMutedCountInGrpCall=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		int callEndedCountInGrpCall=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		crtgrp.allMembersCountInGrpCall();
		crtgrp.visibilityOfIndividualUserMuteButtomInGrpCall();
		Assert.assertTrue(
				crtgrp.visibilityOfIndividualUserMuteButtomInGrpCall().contains("SingleUnMute"));
		logger_ss.log(Status.INFO, "Successfully verified visibilityOfIndividualUserMuteButtomInGrpCall ");
		crtgrp.hangUpCurrentGrpTalkcall();
		crtgrp.submitRateCallByClickingGoodOption();
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "Successfully verified MuteDialFunctionalityFromScheduleOverlay ");
	}
	
	
	@Test
	public void verifyfunctionalityOfExcelReportDownloadOptionOnHistory() throws InterruptedException {
		logger_ss = extent.createTest("verifyfunctionalityOfExcelReportDownloadOptionOnHistory","verifyfunctionalityOfExcelReportDownloadOptionOnHistory");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		crtgrp.historyButtonOnMyGrpTalks();
		logger_ss.log(Status.INFO, "Clicked on history Button On MyGrpTalks");
		crtgrp.clickExcelReportDownloadButtonOnHistory();
		logger_ss.log(Status.INFO, "Downloaded ExcelReport from History");
		logger_ss.log(Status.INFO, "Successfully verified functionalityOfExcelReportDownloadOptionOnHistory ");
	}
	
	
	@Test
	public void verifyDialFunctionalityOfScheduleGroup() throws InterruptedException {
		logger_ss = extent.createTest("verifyDialFunctionalityOfScheduleGroup","verifyDialFunctionalityOfScheduleGroup");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on createGroup button in myGrpTalk page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone Contacts tab in createGrpTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitScheduleButton();
		logger_ss.log(Status.INFO, "Submitted schedule button");
		crtgrp.scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "Click on schedule Date And Time Field On Advanced Settings Overlay For Schedule");
		crtgrp.decrementDatePickerForMinutes(8);
		logger_ss.log(Status.INFO, "incremented Minute in date picker overlay");
		crtgrp.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on set button on overlay");
		
		crtgrp.selectAllRepeatDaysOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "selected AllRepeatDaysOnAdvancedSettingsOverlayForSchedule");
		crtgrp.clickScheduleButtonOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "clicked on Schedule Button On Advanced Settings Overlay For Schedule grpTalk");
		
		Thread.sleep(121000);
		driver.navigate().to("https://web.grptalk.com/MyGrpTalks.aspx");
		crtgrp.selectRecentlySavedGrpTalkGroup();
		logger_ss.log(Status.INFO, "selected Recently Saved GrpTalk Group");
		
		crtgrp.visibleInprogressString();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		
		Assert.assertTrue(crtgrp.visibilityOfUnMuteBuutonInGrpCall());
		
		int allMembersCountInGrpCall=crtgrp.allMembersCountInGrpCall();
		Assert.assertEquals(allMembersCountInGrpCall,1);
		logger_ss.log(Status.INFO, "Successfully verified allMembersCountInGrpCall ");
		
		int onCallCountInGrpCall=crtgrp.onCallCountInGrpCall();
		Assert.assertEquals(onCallCountInGrpCall,1);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall=crtgrp.unMutedCountInGrpCall();
		Assert.assertEquals(unMutedCountInGrpCall,1);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int callEndedCountInGrpCall=crtgrp.callEndedCountInGrpCall();
		Assert.assertEquals(callEndedCountInGrpCall,0);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		
		crtgrp.allMembersCountInGrpCall();
		crtgrp.visibilityOfIndividualUserMuteButtomInGrpCall();
		Assert.assertTrue(
				crtgrp.visibilityOfIndividualUserMuteButtomInGrpCall().contains("SingleMute"));
		logger_ss.log(Status.INFO, "Successfully verifed the visibility of individual user mute button in grp call");
		crtgrp.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "Successfully verifed DialFunctionalityOfScheduleGroup");
		crtgrp.submitRateCallByClickingGoodOption();
	}
	
	@Test
	public void verifyNonRepeatedGroupCallFunctionalityThroughHistory() throws InterruptedException {
		logger_ss = extent.createTest("verifyNonRepeatedGroupFunctionalityThroughHistory","verifyNonRepeatedGroupFunctionalityThroughHistory");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.selectSavedGroupByName("OneDial");
		logger_ss.log(Status.INFO, "Selected 'OneDial' group In MyGrpTalk page");
		crtgrp.historyButtonOnMyGrpTalks();
		logger_ss.log(Status.INFO, "clicked on historyButtonOnMyGrpTalks");
		int count = crtgrp.countOfCallsByGroupInHistory();
		Assert.assertEquals(count, 1);
		logger_ss.log(Status.INFO, " get and verified countOfCallsByGroupInHistory");
		logger_ss.log(Status.INFO, "Successfully verified NonRepeatedGroupFunctionalityThroughHistory");
	}
	
	
	@Test
	public void verifyRepeatGrpCalEveryDayFunctionalityThroughHistory() throws InterruptedException {
		logger_ss = extent.createTest("verifyRepeatGrpCalEveryDayFunctionalityThroughHistory","verifyRepeatGrpCalEveryDayFunctionalityThroughHistory");
		CreatingGroup crtgrp = new CreatingGroup(driver);
		crtgrp.selectSavedGroupByName("RepeatGrpCalEveryDay");
		logger_ss.log(Status.INFO, "Selected 'RepeatGrpCalEveryDay' group In MyGrpTalk page");
		crtgrp.historyButtonOnMyGrpTalks();
		logger_ss.log(Status.INFO, "clicked on historyButtonOnMyGrpTalks");
		boolean callDate = crtgrp.callDatesInHistory();
		logger_ss.log(Status.INFO, "Verified call history dates");
		Assert.assertTrue(callDate);
		logger_ss.log(Status.INFO, "Successfully verifyRepeatGrpCalEveryDayFunctionalityThroughHistory");
	}
	
	public void sleep(long millis) throws InterruptedException{
		Thread.sleep(millis);
	}
	
//	@Test
//	public void tabiibFunctionality() throws InterruptedException{
//		CreatingGroup crtgrp = new CreatingGroup(driver);
//		driver.navigate().to("https://okadoc.com/en-ae");
//		crtgrp.met1();
//	}
	
//	@BeforeMethod
//	public void beforeMethod(ITestResult result) throws IOException, InterruptedException {
//		logger_ss = extent.createTest("beforeMethod","beforeMethod");
//		CreatingGroup crtgrp = new CreatingGroup(driver);
//		driver.navigate().to("https://web.grptalk.com/MyGrpTalks.aspx");
//		try{
//			if(driver.findElements(By.xpath("//*[@id='date']//label")).size()!=0){
//				crtgrp.closeLiveGroupCallOfRecentlySavedGrpTalkGroup1();
//				System.out.println("successfully hangUp live GrpCall");
//			}
//			driver.navigate().refresh();
//		}
//		catch(Exception e){
//			System.out.println("Unable to hangUp live GrpCall");
//		}
//		driver.navigate().to("https://web.grptalk.com/MyGrpTalks.aspx");
//		Thread.sleep(2000);
//	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InterruptedException {
		System.out.println("This is after method");
		if (result.getStatus() == ITestResult.FAILURE) {
			String temp = Utility.getScreenshot(driver);
			logger_ss.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		extent.flush();
		Utility.handleAlert(driver);
		CreatingGroup crtgrp = new CreatingGroup(driver);
		driver.navigate().to("https://web.grptalk.com/MyGrpTalks.aspx");
		Utility.handleAlert(driver);
		
		try{
			if(driver.findElements(By.xpath("//*[@id='date']//label")).size()!=0){
				crtgrp.closeLiveGroupCallOfRecentlySavedGrpTalkGroup1();
			}
		}
		catch(Exception e){
			System.out.println("Unable to hangUp live GrpCall");
		}
	
		driver.navigate().to("https://web.grptalk.com/MyGrpTalks.aspx");
		try{
			if(driver.findElements(By.xpath("//*[@id='date']//label")).size()!=0){
				crtgrp.closeLiveGroupCallOfRecentlySavedGrpTalkGroup1();
			}
			//System.out.println(driver.findElements(By.xpath("//*[contains(@grpcallname,'Test_')]")).size());
			if(driver.findElements(By.xpath("//*[contains(@grpcallname,'Test_')]")).size()!=0){
				crtgrp.deleteSavedGrp();
			}
			driver.navigate().refresh();
		}
		catch(Exception e){
			System.out.println("Unable to hangUp live GrpCall or unable to delete saved Grps");
		}
		
		driver.navigate().to("https://web.grptalk.com/MyGrpTalks.aspx");
		Thread.sleep(1000);
	}
}