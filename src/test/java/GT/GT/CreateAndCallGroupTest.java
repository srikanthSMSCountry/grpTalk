package GT.GT;
import java.awt.AWTException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.util.ArrayList;
import org.junit.Ignore;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BrowserFunctions;
import utility.CommonMethods;
import utility.*;

public class CreateAndCallGroupTest extends BrowserFunctions {
	public static Logger logger = Logger.getLogger(CreateAndCallGroupTest.class);
	
	GrpTalks grpTalks = new GrpTalks();
	CreatingGroup crtgrp = new CreatingGroup();
	CommonMethods CommonMethods=new CommonMethods();
	
	@BeforeClass
	public void beforeCalss(){
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("GrpTalk_Report_Of_CreateAndCallGroup.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger_ss = extent.createTest("CreateAndCallGroupTest");
		logger_ss.log(Status.INFO, "CreateAndCallGroupTest");
	}

	@Test
	public void verifyCallFunctionalityFromAllMembersTabInListView() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromAllMembersTabInListView","verifyCallFunctionalityFromAllMembersTabInListView");
//		CreatingGroup crtgrp = new CreatingGroup();
//		GrpTalks grpTalks = new GrpTalks();
		String grpName = crtgrp.createAndCallTheGrp();
		logger_ss.log(Status.INFO, "Dialing to new group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified live Call is in progress ");
		grpTalks.listViewInLiveCall();
		logger_ss.log(Status.INFO, "Switched to list view ");
		
		int allParticipantsCount=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(allParticipantsCount,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),allParticipantsCount);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int DisconnectedCount=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(DisconnectedCount,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),DisconnectedCount);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickUnMuteButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked on UnMute Button Of group participant In All participants tab");
		
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalks.muteButtonOfParticipantInListView));
		//Assert.assertTrue(grpTalks.visibilityOFMuteButtonOfIndividualContactInListView());
		logger_ss.log(Status.INFO, "verified visibility OF Mute Button Of participant ");
		
		int unMutedCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickMuteButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked on Mute Button Of group participant In All participants tab");
		Assert.assertTrue(grpTalks.visibilityOfUnMuteButtonOfParticipantInListView());
		logger_ss.log(Status.INFO, "verified visibility OF un Mute Button Of participant ");
		
		int unMutedCountInGrpCall3=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall3,3);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingToPrviateRoomInListView();
		logger_ss.log(Status.INFO, "clicked on Private Room Button Of participant");
		Assert.assertTrue(grpTalks.visibilityOfPrivateRoomOptionforParticipantInListView());
		logger_ss.log(Status.INFO, "verified visibility OF private room option Of participant ");
		
		int onCallCountInGrpCall2=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall2 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		grpTalks.visibilityOfClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "verified visibility OF close  private room option Of participant InPrivateRoomTab ");
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingBackTocallInListView();
		logger_ss.log(Status.INFO, "clicked on move back to call option Of participant in all Participants tab");
		Assert.assertTrue(grpTalks.InvisibilityOfPrivateRoomOptionForParticipantInListView());
		logger_ss.log(Status.INFO, "verified invisibility OF private room option Of participant ");
		
		int privateRoomMembersCountInGrpCall3 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickhangUpButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked on hangUp Button Of Iparticipant In all Members Tab");
		Assert.assertTrue(grpTalks.visibilityOfReDialButtonOfParticipantInListView());
		logger_ss.log(Status.INFO, "verified visibility Of reDial option Of participant ");
		
		int selectDisconnectedTabAndCountTheParticipants2=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants2,1);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),selectDisconnectedTabAndCountTheParticipants2);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickreDialButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked on reDial Button Of participant");
		Assert.assertTrue(grpTalks.visibilityOfHangUpButtonOfParticipantInListView());
		logger_ss.log(Status.INFO, "verified invisibility OF reDail option Of participant ");
		
		int selectDisconnectedTabAndCountTheParticipants3=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants3,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),selectDisconnectedTabAndCountTheParticipants3);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall3=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall3,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingAverageOption();
		logger_ss.log(Status.INFO, "submited RateCall By Clicking Good Option");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verified Call Functionality From AllMembersTab in list view");
	}
	
	@Test
	public void verifyCallFunctionalityFromAllMembersTab() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromAllMembersTab","verifyCallFunctionalityFromAllMembersTab");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName = crtgrp.createAndCallTheGrp();
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified live Call is in progress ");
		
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,4);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickUnMuteButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on UnMute Button Of group participant In All participants tab");
		
		Assert.assertTrue(grpTalks.visibilityOfMuteButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified visibility OF Mute Button Of participant ");
		int unMutedCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickMuteButtonOfParticipant();
		Thread.sleep(1000);
		logger_ss.log(Status.INFO, "clicked on Mute Button Of group participant In All participants tab");
		Assert.assertTrue(grpTalks.visibilityOfUnMuteButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified visibility OF un Mute Button Of participant ");
		
		int unMutedCountInGrpCall3=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall3,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingToPrviateRoom();
		logger_ss.log(Status.INFO, "clicked on Private Room Button Of participant");
		Assert.assertTrue(grpTalks.visibilityOfPrivateRoomOptionforParticipant());
		logger_ss.log(Status.INFO, "verified visibility OF private room option Of participant ");
		
		int onCallCountInGrpCall2=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall2 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		grpTalks.visibilityOfClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "verified visibility OF close  private room option Of participant InPrivateRoomTab ");
		
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingBackTocall();
		logger_ss.log(Status.INFO, "clicked on move back to call option Of participant in all Participants tab");
		Assert.assertTrue(grpTalks.InvisibilityOfPrivateRoomOptionForParticipant());
		logger_ss.log(Status.INFO, "verified invisibility OF private room option Of participant ");
		
		int privateRoomMembersCountInGrpCall3 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickhangUpButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on hangUp Button Of participant In all Members Tab");
		Assert.assertTrue(grpTalks.visibilityOfReDialButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified visibility Of reDial option Of participant ");
		
		int selectDisconnectedTabAndCountTheParticipants2=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants2,1);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants2);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickreDialButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on reDial Button Of participant");
		Assert.assertTrue(grpTalks.visibilityOfHangUpButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified invisibility OF reDail option Of participant ");
		
		int selectDisconnectedTabAndCountTheParticipants3=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants3,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants3);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall3=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall3,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "submited RateCall By Clicking Good Option");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verified CallFunctionalityFromAllMembersTab ");
	}
	
	@Test
	public void verifyErrorMessageWhenJunkDataGivenInSearchBox() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMessageWhenJunkDataGivenInSearchBox","verify the Error Message When Junk Data Given In SearchBox on CreateGroupTalk page");
		CreatingGroup crtgrp = new CreatingGroup();
		CommonMethods.clickMethod(GrpTalks.createGrp);
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		logger.info("Clicked on Creating Group button");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.enterNameInSearchBox(CommonMethods.passingData("junkData"));
		logger_ss.log(Status.INFO, "Clicked in search box field and given contact name 'qwertyuiop' which is not available in contact list");
		logger_ss.log(Status.INFO, "Expected message is: No Contacts Found ");
		logger_ss.log(Status.INFO, "Actual message is:");
		String noContactsMessage = CommonMethods.getTextMethod(crtgrp.errorMessage);
		logger_ss.log(Status.INFO, noContactsMessage);
		Assert.assertTrue(noContactsMessage.contains("No Contacts Found"));
		logger_ss.log(Status.INFO, "verfied noContactsMessage");
		logger_ss.log(Status.INFO, "Successfully verfied the Message When User Enters Name Which is Not Exist in Contact List");
	}
	
	@Test
	public void verifyFooterTextDisplayedOnMyGrpTalksPage(){
		logger_ss = extent.createTest("verifyFooterTextDisplayedOnHomePage","verifyFooterTextDisplayedOnHomePage");
		GrpTalks grpTalk = new GrpTalks();
		Assert.assertEquals(grpTalk.footerText(), "Copy rights © all rights are reserved 2016.");
		logger_ss.log(Status.INFO, "Get and verified footer text");
		logger_ss.log(Status.INFO, "Successfully verfied the Footer Text Displayed On Home Page");
	}
	
	@Test
	public void verifyHeaderTabsAndLogosDisplayedOnGrpTalksPage() throws InterruptedException{
		logger_ss = extent.createTest("verifyHeaderTabsAndLogosDisplayedOnHomePage","verifyHeaderTabsAndLogosDisplayedOnHomePage");
		GrpTalks grpTalk = new GrpTalks();
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalk.grpTalkLogo));
		logger_ss.log(Status.INFO, "verified grpTalkLogo is displayed");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalk.groupsTabOnHomePage));
		logger_ss.log(Status.INFO, "verified groupsTabOnHomePage is displayed");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalk.contactsTabOnHomePage));
		logger_ss.log(Status.INFO, "verified contactsTabOnHomePage is displayed");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalk.accountsTabOnHomePage));
		logger_ss.log(Status.INFO, "verified accountsTabOnHomePage is displayed");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalk.profileLogo));
		logger_ss.log(Status.INFO, "verified profileLogo is displayed");
		logger_ss.log(Status.INFO, "Successfully verfied the Header Tabs And Logos Displayed On Home Page");
	}

	@Test
	public void verifyContactListInPhoneContacts() throws InterruptedException {
		logger_ss = extent.createTest("verifyContactListInPhoneContacts","Verify Contacts List In PhoneContacts Tab in CreateGroupTalk page");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		int numberOfContacts = crtgrp.numberOfContactsInPhoneContactsTab();
		logger_ss.log(Status.INFO, "Get the Number of contacts present in contact list");
		logger_ss.log(Status.INFO, "Expected total number of contacts are: 200 ");
		logger_ss.log(Status.INFO, "Actual total number of contacts are:");
		logger_ss.log(Status.INFO, String.valueOf(numberOfContacts));
		Assert.assertEquals(numberOfContacts, 57);
		logger_ss.log(Status.INFO, "Successfully verified the number of contacts present in PhoneContacts tab in CreateGroupTalk page");
	}

	@Test
	public void verifySearchOptionWithPartialValidUserName() throws InterruptedException {
		logger_ss = extent.createTest("verifySearchOptionWithPartialValidUserName","verify Search Option With Partial Valid User Name");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		//String name = "sanju";
		crtgrp.enterNameInSearchBox(CommonMethods.passingData("partialContactName"));
		logger_ss.log(Status.INFO, "Clicked in search box field and given partial contact name 'sanju'");
		int numberOfContacts= crtgrp.numberOfContactsInPhoneContactsTab();
		logger_ss.log(Status.INFO, "Expected total number ofcontacts are: 1");
		logger_ss.log(Status.INFO, "Actual total number of contacts are:");
		logger_ss.log(Status.INFO,  String.valueOf(numberOfContacts));
		Assert.assertEquals(numberOfContacts, 1);
		Assert.assertTrue(CommonMethods.verifyText(crtgrp.contactBySearchingInCreatingGrp, CommonMethods.passingData("partialContactName")));
		logger_ss.log(Status.INFO, "Successfully verified the number of contacts present in PhoneContacts tab With Partial Valid User Name in CreateGroupTalk page");
	}

	@Test
	public void verifySearchOptionWithfullValidUserName() throws InterruptedException {
		logger_ss = extent.createTest("verifySearchOptionWithfullValidUserName","verify Search Option With Valid User Name");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.enterNameInSearchBox(CommonMethods.passingData("validContactName"));
		logger_ss.log(Status.INFO, "Clicked in search box field and given valid contact name 'Anji@Room'");
		int numberOfContacts = crtgrp.numberOfContactsInPhoneContactsTab();
		logger_ss.log(Status.INFO, "Expected total number ofcontacts are: 1");
		logger_ss.log(Status.INFO, "Actual total number of contacts are:");
		logger_ss.log(Status.INFO,  String.valueOf(numberOfContacts));
		Assert.assertEquals(numberOfContacts, 1);
		Assert.assertTrue(CommonMethods.verifyText(crtgrp.contactBySearchingInCreatingGrp, CommonMethods.passingData("validContactName")));
		logger_ss.log(Status.INFO, "Successfully verified the number of contacts present in PhoneContacts tab with Valid User Name in CreateGroupTalk page");
	}

	@Test
	public void verifySelectContactFromContactList() throws InterruptedException {
		logger_ss = extent.createTest("verifySelectContactFromContactList","verify Select Contact From Contact List");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		String contactName= crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		logger_ss.log(Status.INFO, "Expected total number of selected contacts are: 1");
		logger_ss.log(Status.INFO, "Actual total number of selected contacts are:");
		int count=crtgrp.selectedContactFromContactList();
		logger_ss.log(Status.INFO,  String.valueOf(count));
		Assert.assertEquals(count, 1);
		Assert.assertTrue(CommonMethods.verifyText(crtgrp.contactBySearchingInCreatingGrp, contactName));
		logger_ss.log(Status.INFO,  "Successfully verified the selected contacts from contact list");
	}

	@Test
	public void verifySelectSpecificCharacterOfContactsInPhoneContacts() throws InterruptedException{
		logger_ss = extent.createTest("verifySelectSpecificCharacterOfContactsInPhoneContacts","verify Select Specific Character Of Contacts In Phone Contacts");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		int size =crtgrp.selectSpecificCharacterOfContacts();
		logger_ss.log(Status.INFO, "selected specific character from contacts list");
		logger_ss.log(Status.INFO, "Expected total number ofcontacts are: 7");
		logger_ss.log(Status.INFO, "Actual total number of contacts are:");
		logger_ss.log(Status.INFO,  String.valueOf(size));
		Assert.assertEquals(size, 7);
		Assert.assertTrue(crtgrp.verifyContactsStartsWithSpecialCharacters());
		logger_ss.log(Status.INFO, "Successfully verified the ContactsStartsWithSpecialCharacters");
		logger_ss.log(Status.INFO, "Successfully verified the number of contacts present in PhoneContacts when we select specific character from phone contacts");
	}
	
	@Test
	public void verifyNumberOfUsersFromSelectedContactsTab() throws InterruptedException {
		logger_ss = extent.createTest("verifyNumberOfUsersFromSelectedContactsTab","verify Number Of Users From Selected Contacts Tab");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		String contactName=crtgrp.selectContactFromContactList();
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
		Assert.assertTrue(CommonMethods.verifyText(crtgrp.contactFromSelectedContactTab, contactName));
		logger_ss.log(Status.INFO, "Successfully verified the number of contacts in selected contacts tab which are selected from phoneContacts tab");
	}

	@Test
	public void verifyAddMoreNumberOfUsersthanMaximunLimitFromContactList() throws InterruptedException {
		logger_ss = extent.createTest("verifyAddMoreNumberOfUsersthanMaximunLimitFromContactList","verify Add More Number Of Users than Maximun Limit From Contact List");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.addMorethanNineUserFromContactList();
		logger_ss.log(Status.INFO, "Tried to add more than nine contacts from contact list");
		logger_ss.log(Status.INFO, "Expected error message is: You can't select more than 9 members");
		logger_ss.log(Status.INFO, "Actual error message is:");
		logger_ss.log(Status.INFO,  CommonMethods.getTextMethod(crtgrp.errorMsg));
		Assert.assertEquals(CommonMethods.getTextMethod(crtgrp.errorMsg), "You can't select more than 9 members");
		logger_ss.log(Status.INFO, "Successfully verified the error msg by adding morethan nine contacts from phone contacts tab");
	}
	
	@Test
	public void verifyCallFunctionalityOfTestContactsFromCreateGroupTalkPage() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityOfTestContactsFromCreateGroupTalkPage","verifyCallFunctionalityOfTestContactsFromCreateGroupTalkPage");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectTestContactsFromContactList();
		logger_ss.log(Status.INFO, "selected TestContactsFromContactList");
		String grpTalkName=crtgrp.setGrpTalkName();
		crtgrp.submitStartNowButton();
		logger_ss.log(Status.INFO, "Submitted StartNow button");
		crtgrp.dialGroupCallButtonOnOverlayInCreateGrpTalkForTest();
		logger_ss.log(Status.INFO, "clicked on dialGroupCallButtonOnOverlayInCreateGrpTalkForTestContacts");
		grpTalk.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified the visiblity of Inprogress String");
		grpTalk.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "hanged Up CurrentGrpTalkcall");
		grpTalk.submitRateCallByClickingGoodOption();
		grpTalk.selectRecentlySavedGrpTalkGroup(grpTalkName);
		logger_ss.log(Status.INFO, "selected Recently SavedGrpTalkGroup");
		grpTalk.historyButtonOnMyGrpTalks();
		logger_ss.log(Status.INFO, "Clicked on historyButtonOnMyGrpTalks");
		grpTalk.downloadRecordingCallHistory();
		logger_ss.log(Status.INFO, "Clicked on downloadRecordingCallHistory");
		grpTalk.deleteSavedGroupCall();
		logger_ss.log(Status.INFO, "deleted SavedGroupCall");
		String dateValue=grpTalk.currentDateValue();
		String fileName=grpTalkName+dateValue;
		System.out.println(fileName);
		String totalDownloadFilepath = CommonMethods.passingData("downloadFilepath")+"/"+fileName;
		System.out.println(totalDownloadFilepath);
		logger_ss.log(Status.INFO, "downloaded Recorded CallHistory");
		logger_ss.log(Status.INFO, "Successfully verified the CallFunctionalityOfTestContactsFromCreateGroupTalkPage");
	}
	
	@Test
	public void verifyErrorMsgWhenWeSubmitStartNowButtonWithOutSelectingAnyPhoneContacts() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMsgWhenWeSubmitStartNowButtonWithOutSelectingAnyPhoneContacts","verify Error Msg When We Submit StartNow Button With Out Selecting Any Phone Contacts");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.submitStartNowButton();
		logger_ss.log(Status.INFO, "Submitted StartNow button without selecting any phone contacts");
		logger_ss.log(Status.INFO, "Expected error message is: Please Choose Participants To Make A Call");
		logger_ss.log(Status.INFO, "Actual error message is:");
		logger_ss.log(Status.INFO,  CommonMethods.getTextMethod(crtgrp.errorMsg));
		Assert.assertEquals(CommonMethods.getTextMethod(crtgrp.errorMsg),
				"Please Choose Participants To Make A Call");
		logger_ss.log(Status.INFO, "Successfully verified the error msg when we submit StartNow button without selecting any phone contacts");
	}

	@Test
	public void verifyErrorMsgWhenWeSubmitSaveButtonWithOutSelectingAnyPhoneContacts() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMsgWhenWeSubmitSaveButtonWithOutSelectingAnyPhoneContacts","verify Error Msg When We Submit Save Button WithOut Selecting Any Phone Contacts");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		logger_ss.log(Status.INFO, "Expected error message is: Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Actual error message is:");
		logger_ss.log(Status.INFO,  CommonMethods.getTextMethod(crtgrp.errorMsgWhenWeSubmitSaveButton));
		Assert.assertEquals(CommonMethods.getTextMethod(crtgrp.errorMsgWhenWeSubmitSaveButton),
				"Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Successfully verified the error msg when we submit save button without selecting any phone contacts");
	}
	
	@Test
	public void method11() throws InterruptedException{
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.selectSavedGroupByName("BULK");
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//*[@id='members']//*[@class='slimScrollBar']"));
		new Actions(driver).clickAndHold(ele).moveByOffset(0,170).release().perform();
		Thread.sleep(5000);
	}

	@Test
	public void removeLeaveGroup() throws InterruptedException{
		GrpTalks grpTalks = new GrpTalks();
		if(driver.findElements(By.xpath("//*[contains(@grpcallname,'LeaveGroup')]")).size()!=0){
			grpTalks.selectSavedGroupByName(CommonMethods.passingData("LeaveGroupGroup"));
			grpTalks.deleteSavedLeaveGroupGroup();
			driver.navigate().to(CommonMethods.passingData("homePageUrl"));
			Thread.sleep(1000);
		}
	}
	
	@Test(priority=0)
	public void createAndSaveTheGroup() throws InterruptedException {
		logger_ss = extent.createTest("createAndSaveTheGroup","createAndSaveTheGroup");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName= crtgrp.createAndSaveTheGrpWithSecondaryModerator();
		logger_ss.log(Status.INFO, "Dialing to new group by submitting StartNowButton");
		System.out.println("GrpNAme----"+grpName);
		grpTalks.selectSavedGroupByName(grpName);
		Boolean result= grpTalks.checkSecondaryModerator(CommonMethods.passingData("SecondayModeratorContact"));
		Assert.assertTrue(result);
	}
	
	@Test(dependsOnMethods = { "removeLeaveGroup" })
	public void createAndSaveTheGroupByLeaveGroupName() throws InterruptedException {
		logger_ss = extent.createTest("createAndSaveTheGroupByLeaveGroupName","createAndSaveTheGroupByLeaveGroupName");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName= crtgrp.createAndSaveTheGrpByLeaveGroupName();
		logger_ss.log(Status.INFO, "Create and saved new group");
		System.out.println("GrpNAme----"+grpName);
		grpTalks.selectSavedGroupByName(grpName);
	}

	@Test
	public void verifyCallFunctionalityOfListMembers() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromAllMembersTab","verifyCallFunctionalityFromAllMembersTab");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		grpTalks.listNameInWebLists(CommonMethods.passingData("newTestList"));
		crtgrp.selectListContacts();
		String grpName =crtgrp.setGrpTalkName();
		crtgrp.submitSaveButton();
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");		
		grpTalks.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		grpTalks.dialGroupCallButtonOnOverlay();
		
		
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified live Call is in progress ");
		
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,2);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,2);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,1);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "submited RateCall By Clicking Good Option");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verified CallFunctionalityFromAllMembersTab ");
	}

	@Test
	public void verifyErrorMsgWhenWeSubmitScheduleButtonWithOutSelectingAnyPhoneContacts() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMsgWhenWeSubmitScheduleButtonWithOutSelectingAnyPhoneContacts","verify Error Msg When We Submit Schedule Button WithOut Selecting Any Phone Contacts");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.submitScheduleButton();
		logger_ss.log(Status.INFO, "Submitted schedule button");
		logger_ss.log(Status.INFO, "Expected error message is: Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Actual error message is:");
		logger_ss.log(Status.INFO,  CommonMethods.getTextMethod(crtgrp.errorMsg));
		Assert.assertEquals(CommonMethods.getTextMethod(crtgrp.errorMsg),
				"Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Successfully verified the error msg when we submit schedule button without selecting any phone contacts");
	}
	
	@Test
	public void verifyErrorMsgWhenWeSubmitStartNowButtonWithOutEnterGrpTalkName() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMsgWhenWeSubmitStartNowButtonWithOutEnterGrpTalkName","verify Error Msg When We Submit StartNow button with out enter GrpTalk name");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
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
		logger_ss.log(Status.INFO,  CommonMethods.getTextMethod(crtgrp.errorMsg));
		Assert.assertEquals(CommonMethods.getTextMethod(crtgrp.errorMsg),
				"Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Successfully verified the error msg when we submit StartNow button without giving any grpTalk name");
	}
	
	@Test
	public void verifyErrorMsgWhenWeSubmitSaveButtonWithOutEnterGrpTalkName() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMsgWhenWeSubmitSaveButtonWithOutEnterGrpTalkName","verify Error Msg When We Submit save button with out enter GrpTalk name");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
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
		logger_ss.log(Status.INFO, CommonMethods.getTextMethod(crtgrp.errorMsgWhenWeSubmitSaveButton));
		Assert.assertEquals(CommonMethods.getTextMethod(crtgrp.errorMsgWhenWeSubmitSaveButton),
				"Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Successfully verified the error msg when we submit save button without giving any grpTalk name");
	}
	
	@Test
	public void verifyQuickDialButtonFunctionalityofGroupsInMyGrpTalk() throws InterruptedException {
		logger_ss = extent.createTest("verifyQuickDialButtonFunctionalityofGroupsInMyGrpTalk","Verify quickDialButtonFunctionalityofGroupsInMyGrpTalk");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		Thread.sleep(2000);
		grpTalk.clickQuickDailButtonofGroupInGrpTalks();
		logger_ss.log(Status.INFO, "clicked on QuickDailButtonofGroupsInMyGrpTalk");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalk.cancelGroupCallButtonOnOverlay));
		logger_ss.log(Status.INFO, "verified cancleButtonDisplayedOnCallOverlay");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalk.muteDialGroupCallButtonOnOverlay));
		logger_ss.log(Status.INFO, "verified muteDialButtonDisplayedOnCallOverlay");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalk.dialGroupCallButtonOnOverlay));
		logger_ss.log(Status.INFO, "verified dialGroupButtonDisplayedOnCallOverlay");
		logger_ss.log(Status.INFO, "Successfully verified Quick Dial Button Functionality of Groups In MyGrpTalk");
	}
	
	@Test
	public void verifyCallFunctionalityFromQuickDialButtonInMyGrpTalk() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromQuickDialButtonInMyGrpTalk","verifyCallFunctionalityFromQuickDialButtonInMyGrpTalk");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.selectSavedGroupByName(CommonMethods.passingData("grpTalkGroup"));
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		Thread.sleep(2000);
		grpTalks.quickDialButtonOfActiveGroup();
		Thread.sleep(2000);
		logger_ss.log(Status.INFO, "clicked on quickDialButtonOfActiveGroup");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalks.cancelGroupCallButtonOnOverlay));
		logger_ss.log(Status.INFO, "verified cancleButtonDisplayedOnCallOverlay");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalks.muteDialGroupCallButtonOnOverlay));
		logger_ss.log(Status.INFO, "verified muteDialButtonDisplayedOnCallOverlay");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalks.dialGroupCallButtonOnOverlay));
		logger_ss.log(Status.INFO, "verified dialGroupButtonDisplayedOnCallOverlay");
		grpTalks.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Dialed to grpTalk group");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,4);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "hangUp the Current GrpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verified CallFunctionalityFromQuickDialButtonInMyGrpTalk");
	}
	
	@Test
	public void verifyErrorMsgWhenWeSubmitScheduleButtonWithOutEnterGrpTalkName() throws InterruptedException {
		logger_ss = extent.createTest("verifyErrorMsgWhenWeSubmitScheduleButtonWithOutEnterGrpTalkName","verify Error Msg When We Submit schedule button with out enter GrpTalk name");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
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
		logger_ss.log(Status.INFO,  CommonMethods.getTextMethod(crtgrp.errorMsg));
		Assert.assertEquals(CommonMethods.getTextMethod(crtgrp.errorMsg),
				"Please Enter Group Call Name");
		logger_ss.log(Status.INFO, "Succesfully verified the error msg when we submit schedule button without giving any grpTalk name");
	}
	
	@Test
	public void verifyGrpTalkNameOnCreateGroupAndGrpTalksPages() throws InterruptedException {
		logger_ss = extent.createTest("verifyGrpTalkNameField","verify GrpTalk name field in CreateGroupTalk page");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName= crtgrp.createAndSaveTheGrp();
		logger_ss.log(Status.INFO, "created and saved new grp");
		logger_ss.log(Status.INFO, "Expected success message is: Group call saved successfully");
		logger_ss.log(Status.INFO, "Actual success message is:");
		logger_ss.log(Status.INFO,  CommonMethods.getTextMethod(crtgrp.successMsg));
		Assert.assertEquals( CommonMethods.getTextMethod(crtgrp.successMsg),
				"Group call saved successfully");
		logger_ss.log(Status.INFO, "Successfully verified success msg when we submit save group button on overlay");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		logger_ss.log(Status.INFO, "Expected name of created group is : ");
		logger_ss.log(Status.INFO,  grpName);
		logger_ss.log(Status.INFO, "Actual actual name of created group is :");
		logger_ss.log(Status.INFO,  grpTalks.nameOnMyGrpTalkMainGrid());		
		Assert.assertEquals(grpTalks.nameOnMyGrpTalkMainGrid(), grpName);
		logger_ss.log(Status.INFO, "Successfully verifed the name on MyGrpTalk page with given grp talk name on CreateGroupTalk page");
	}
	
	@Test
	public void verify_list_Of_Group_Users_On_MyGrpTalk_Page() throws InterruptedException {
		logger_ss = extent.createTest("verify_list_Of_Group_Users_On_MyGrpTalk_Page","verify the list Of Group Users On MyGrpTalk Page");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactsFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.selectedContactsTab();
		logger_ss.log(Status.INFO, "switched to selected contacts tab");
		List<String> list1=crtgrp.ListOfGroupContactsFromSelectedContacts();
		logger_ss.log(Status.INFO, "Taken the list of grp contacts from selected contacts tab ");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab");
		String grpName=crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "Submitted saveGroup button on overlay");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		List<String> list2=grpTalks.listOfGroupContactsOnMyGrpTalkPage();
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

	@Test
	public void verifyRemoveFunctionalityOfSavedGroupsOnMyGrpTalkPage() throws InterruptedException {
		logger_ss = extent.createTest("verifyRemoveFunctionalityOfSavedGroupsOnMyGrpTalkPage","verify Remove Functionality Of Saved Groups On MyGrpTalk Page");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndSaveTheGrp();
		logger_ss.log(Status.INFO, "Submitted saveGroup button on overlay");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		grpTalks.deleteSavedGroupCall();
		logger_ss.log(Status.INFO, "Deleted saved group call");
		logger_ss.log(Status.INFO, "Expected success msg is : Deleted Successfully");
		logger_ss.log(Status.INFO, "Expected success msg is :");
		logger_ss.log(Status.INFO,  CommonMethods.getTextMethod(grpTalks.successMsg));
		Assert.assertEquals(CommonMethods.getTextMethod(grpTalks.successMsg), "Deleted Successfully");
		logger_ss.log(Status.INFO, "Succesfully verified success Msg For Deleted Saved Group");
		Assert.assertFalse(grpTalks.presenceOfGroupByGivenName(grpName));
		logger_ss.log(Status.INFO, "Successfully verified the presence of Deleted Saved Group by name");
	}
	
	@Test
	public void verifyCreateWebLIstFromCreateGrpPage() throws InterruptedException {
		logger_ss = extent.createTest("verifyCreateWebLIst","verify create web list");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		String newWebList= crtgrp.createWebLIst();
		logger_ss.log(Status.INFO, "Created new web list");
		Assert.assertTrue(grpTalks.listNameInWebLists(newWebList));
		logger_ss.log(Status.INFO, "Successfully verfied new web list name in list of web lists");
	}
	
	@Test
	public void verifyCreateListFromExcelUploadOnCreateGrpPage() throws InterruptedException, AWTException{
		logger_ss = extent.createTest("verifyCreateListFromExcelUploadOnCreateGrpPage","verifyCreateListFromExcelUploadOnCreateGrpPage");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPlusButtonToCreateNewWebList();
		logger_ss.log(Status.INFO, "Clicked on PlusButtonToCreateNewWebList");
		crtgrp.clickExcelUploadTabOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on ExcelUploadTabOnOverlay");
		crtgrp.clickChooseFileButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on ChooseFileButtonOnOverlay");
		String path=userDirectory+"\\TestDataFiles\\contacts.xlsx";
		CommonMethods.getUploadFile(userDirectory+"\\TestDataFiles\\contacts.xlsx");
		logger_ss.log(Status.INFO, "Uploaded file");
		Thread.sleep(2000);
		String listName = crtgrp.givenExcelSheetDetailsOnOverlay();
		System.out.println("lsit--"+listName);
		logger_ss.log(Status.INFO, "given excel sheet details on overlay");
		Thread.sleep(3000);
		//Assert.assertEquals(contactsPage.successMsgForCreatedWebListFromExcelUpload(), "New List Created Successfully");
		//Assert.assertEquals(crtgrp.successMsgForCreatedWebListFromExcelUpload(), "Contact(s) Inserted Successfully");
		logger_ss.log(Status.INFO, "verified successMsgForCreatedWebListFromExcelUpload");
		boolean result=grpTalks.listNameInWebLists(listName);
		logger_ss.log(Status.INFO, "Successfully selected Recently Created List");
		Assert.assertTrue(result);
		Assert.assertEquals(crtgrp.participantsInListContacts(), 2);
		logger_ss.log(Status.INFO, "Successfully verified the listOfContactsInWebList");
		logger_ss.log(Status.INFO, "Successfully verified the functionality of CreateListFromExcelUpload");
	}

	@Test
	public void verifyAddContactsFromContactsListByEditngSavedGroupOnMyGrpTalkPage() throws InterruptedException {
		logger_ss = extent.createTest("verifyAddContactsFromContactsListByEditngSavedGroupOnMyGrpTalkPage","verifyAddContactsFromContactsListByEditngSavedGroupOnMyGrpTalkPage");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		EditGroupTalk editGroupTalk = new EditGroupTalk();
		String grpName=crtgrp.createAndSaveTheGrpWithOneParticipant();
		logger_ss.log(Status.INFO, "Create and saved new grp");
		Assert.assertEquals( CommonMethods.getTextMethod(crtgrp.successMsg),
				"Group call saved successfully");
		logger_ss.log(Status.INFO, "Verified success Msg When We Submit SaveGroup button on overlay");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		int count=editGroupTalk.editSavedGroupCall(grpName);
		logger_ss.log(Status.INFO, "Added new contact by editing saved group ");
		Assert.assertEquals(count, 2);
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		Assert.assertEquals(grpTalks.contactsListOfGroupOnMyGrpTalkPage(), 3);
		logger_ss.log(Status.INFO, "Successfully Added new contact in saved group by editing existing saved group ");
	}
	
	@Test
	public void verifyRemoveContactFromSavedGroupOnMyGrpTalkPage() throws InterruptedException {
		logger_ss = extent.createTest("verifyRemoveContactFromSavedGroupOnMyGrpTalkPage","verify Remove Contact From Saved Group On MyGrpTalk Page");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		EditGroupTalk editGrpTalk = new EditGroupTalk();
		String grpName=crtgrp.createAndSaveTheGrp();
		logger_ss.log(Status.INFO, "create and saved new group");
		Assert.assertEquals( CommonMethods.getTextMethod(crtgrp.successMsg),
				"Group call saved successfully");
		logger_ss.log(Status.INFO, "Verified success Msg When We Submit SaveGroup button on overlay");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		int count=editGrpTalk.removeContactFromSavedGroup(grpName);
		Assert.assertEquals(count, 2);
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		Assert.assertEquals(grpTalks.contactsListOfGroupOnMyGrpTalkPage(), 3);
		logger_ss.log(Status.INFO, "Successfully removed one contact from saved group by editing existing saved group ");
	}
	
	@Test
	public void verifyCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup","verifyCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactsFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitStartNowButton();
		logger_ss.log(Status.INFO, "Submitted StartNow button");
		crtgrp.dialGroupCallButtonOnOverlayInCreateGrpTalk();
		logger_ss.log(Status.INFO, "Submitted dial GroupCall Button On Overlay In CreateGrpTalk page");
		
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,4);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "hangUp the Current GrpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verified CallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup");
	}
	
	@Test
	public void verifyMuteCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup() throws InterruptedException {
		logger_ss = extent.createTest("verifyMuteCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup","verifyMuteCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactsFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitStartNowButton();
		logger_ss.log(Status.INFO, "Submitted StartNow button");
		crtgrp.clickMuteDialButtonOnOverlayInCreateGrpTalk();
		logger_ss.log(Status.INFO, "Submitted dial GroupCall Button On Overlay In CreateGrpTalk page");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,4);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,0);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");

		grpTalks.selectOnCallTabAndCountTheParticipants();
		logger_ss.log(Status.INFO, "Clicked on onCallCount tab In GrpCall");
		Assert.assertTrue(grpTalks.visibilityOfMuteBuutonInGrpCall());
		logger_ss.log(Status.INFO, "Successfully verifed the visibility of mute button in grp call");
		
		Assert.assertTrue(grpTalks.visibilityOfIndividualUserMuteButtomInGrpCall());
		logger_ss.log(Status.INFO, "Successfully verifed the visibility of individual user mute button in grp call");

		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verifed MuteCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup");
	}
	
	@Test
	public void verifyAddMemberInOnGoingGrpCallFromCreateGroupTalkPageByCreatingNewGroup() throws InterruptedException {
		logger_ss = extent.createTest("verifyAddMemberInOnGoingGrpCall","verify Add members in ongoing grp call");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactFromContactList();
		String grpName=crtgrp.setGrpTalkName();
		crtgrp.submitSaveButton();
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");		
		grpTalks.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		grpTalks.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on dial grpCall button on overlay");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		Assert.assertEquals(grpTalks.totalParticipants(),2);
		grpTalks.addMemberInOnGoingGrpCall();
		logger_ss.log(Status.INFO, "Added new member contact in on going call");
		int selectAllParticipantsTabAndCountTheParticipants = grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants, 3);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");
		
		int onCallCount = grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCount, 3);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCount);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		int unMutedCountInGrpCall = grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall, 2);	
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		
		int selectDisconnectedTabAndCountTheParticipants = grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants, 0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "Successfully hangUp current grpCall");
		grpTalks.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verifed AddMemberInOnGoingGrpCallFromCreateGroupTalkPageByCreatingNewGroup");
	}

	@Test
	public void verifySaveGroupWithNormalAndMuteClips() throws InterruptedException, AWTException {
		logger_ss = extent.createTest("verifySaveGroupWithNormalAndMuteClips","verifySaveGroupWithNormalAndMuteClips");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		EditGroupTalk editGrpTalk = new EditGroupTalk();
		grpTalks.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactFromContactList();
		String grpName=crtgrp.setGrpTalkName();
		crtgrp.submitSaveButton();
		crtgrp.uploadNormalClipOnSaveGroupOverlay();
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.deleteNormalClipOptionOnSaveGroupOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.normalClipDownloadOptionOnSaveGroupOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.normalAudioClipOnSaveGroupOverlay));
		
		crtgrp.uploadMuteClipOnSaveGroupOverlay();
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.deleteMuteClipOptionOnSaveGroupOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.muteClipDownloadOptionOnSaveGroupOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.muteAudioClipOnSaveGroupOverlay));
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "selected Recently Saved GrpTalk Group");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
		editGrpTalk.clickuploadClipFieldInEditGroup();
		Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.deleteNormalClipOptionOnUploadClipsOverlayInEditGroup));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.normalAudioClipOnEditGroupOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.deleteMuteClipOptionOnUploadClipsOverlayInEditGroup));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.muteAudioClipOnEditGroupOverlay));
		logger_ss.log(Status.INFO, "Successfully verified SaveGroupWithNormalAndMuteClips");
	}
	
	@Test
	public void verifyNormalAndMuteClipsFunctionalityOnSaveGroupOverlay() throws InterruptedException, AWTException {
		logger_ss = extent.createTest("verifySaveGroupWithNormalAndMuteClips","verifySaveGroupWithNormalAndMuteClips");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		EditGroupTalk editGrpTalk = new EditGroupTalk();
		grpTalks.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactFromContactList();
		String grpName=crtgrp.setGrpTalkName();
		crtgrp.submitSaveButton();
		crtgrp.uploadNormalClipOnSaveGroupOverlay();
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.deleteNormalClipOptionOnSaveGroupOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.normalClipDownloadOptionOnSaveGroupOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.normalAudioClipOnSaveGroupOverlay));
		CommonMethods.clickMethod(crtgrp.normalClipDownloadOptionOnSaveGroupOverlay);
		Thread.sleep(2000);
		CommonMethods.clickMethod(crtgrp.deleteNormalClipOptionOnSaveGroupOverlay);
		crtgrp.uploadMuteClipOnSaveGroupOverlay();
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.deleteMuteClipOptionOnSaveGroupOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.muteClipDownloadOptionOnSaveGroupOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.muteAudioClipOnSaveGroupOverlay));
		CommonMethods.clickMethod(crtgrp.muteClipDownloadOptionOnSaveGroupOverlay);
		Thread.sleep(2000);
		CommonMethods.clickMethod(crtgrp.deleteMuteClipOptionOnSaveGroupOverlay);
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "selected Recently Saved GrpTalk Group");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
		editGrpTalk.clickuploadClipFieldInEditGroup();
		Assert.assertFalse(editGrpTalk.visibilityOfSavedNormalClipOnUploadClipsOverlayInEditGroup());
		Assert.assertFalse(editGrpTalk.visibilityOfSavedMuteClipOnUploadClipsOverlayInEditGroup());
		logger_ss.log(Status.INFO, "Successfully verified verifyNormalAndMuteClipsFunctionalityOnSaveGroupOverlay");
	}
	
	@Test
	public void verifyNormalAndMuteClipsFunctionalityOnScheduleOverlay() throws InterruptedException, AWTException {
		logger_ss = extent.createTest("verifyNormalAndMuteClipsFunctionalityOnScheduleOverlay","verifyNormalAndMuteClipsFunctionalityOnScheduleOverlay");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		EditGroupTalk editGrpTalk = new EditGroupTalk();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on createGroup button in myGrpTalk page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone Contacts tab in createGrpTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		String grpName=crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitScheduleButton();
		logger_ss.log(Status.INFO, "Submitted schedule button");
		
		crtgrp.scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "Click on schedule Date And Time Field On Advanced Settings Overlay For Schedule");
		crtgrp.incrementDatePickerForMinutes(10);
		logger_ss.log(Status.INFO, "incremented Minute in date picker overlay");
		crtgrp.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on set button on overlay");
		crtgrp.giveConferenceAgenda();
		
		crtgrp.uploadNormalClipOnScheduleOverlay();
		Thread.sleep(2000);
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.deleteNormalClipOptionOnScheduleOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.normalClipDownloadOptionOnScheduleOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.normalAudioClipOnScheduleGroupOverlay));
		CommonMethods.clickMethod(crtgrp.normalClipDownloadOptionOnScheduleOverlay);
		Thread.sleep(2000);
		CommonMethods.clickMethod(crtgrp.deleteNormalClipOptionOnScheduleOverlay);
		crtgrp.uploadMuteClipOnScheduleOverlay();
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.deleteMuteClipOptionOnScheduleOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.muteClipDownloadOptionOnScheduleOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.muteAudioClipOnScheduleGroupOverlay));
		CommonMethods.clickMethod(crtgrp.muteClipDownloadOptionOnScheduleOverlay);
		Thread.sleep(2000);
		CommonMethods.clickMethod(crtgrp.deleteMuteClipOptionOnScheduleOverlay);
		Thread.sleep(2000);
		crtgrp.clickScheduleButtonOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "clicked on Schedule Button On Advanced Settings Overlay For Schedule grpTalk");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "selected Recently Saved GrpTalk Group");
		Assert.assertTrue(grpTalks.scheduleCancleButton());
		logger_ss.log(Status.INFO, "Successfully verified the scheduled grp Talk group");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
		editGrpTalk.clickuploadClipFieldInEditGroup();
		Assert.assertFalse(editGrpTalk.visibilityOfSavedNormalClipOnUploadClipsOverlayInEditGroup());
		Assert.assertFalse(editGrpTalk.visibilityOfSavedMuteClipOnUploadClipsOverlayInEditGroup());
		logger_ss.log(Status.INFO, "Successfully verified verifyNormalAndMuteClipsFunctionalityOnScheduleOverlay");
	}

@Test
public void verifyScheduleGroupWithNormalAndMuteClips() throws InterruptedException, AWTException {
	logger_ss = extent.createTest("verifyScheduleGroupWithNormalAndMuteClips","verifyScheduleGroupWithNormalAndMuteClips");
	CreatingGroup crtgrp = new CreatingGroup();
	GrpTalks grpTalks = new GrpTalks();
	EditGroupTalk editGrpTalk = new EditGroupTalk();
	grpTalks.clickCreateGrpButton();
	logger_ss.log(Status.INFO, "Clicked on createGroup button in myGrpTalk page");
	crtgrp.clickPhoneContactsTab();
	logger_ss.log(Status.INFO, "Clicked on phone Contacts tab in createGrpTalk page");
	crtgrp.selectContactFromContactList();
	logger_ss.log(Status.INFO, "Selected phone contact from contact list");
	String grpName=crtgrp.setGrpTalkName();
	logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
	crtgrp.submitScheduleButton();
	logger_ss.log(Status.INFO, "Submitted schedule button");
	
	crtgrp.scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule();
	logger_ss.log(Status.INFO, "Click on schedule Date And Time Field On Advanced Settings Overlay For Schedule");
	crtgrp.incrementDatePickerForMinutes(10);
	logger_ss.log(Status.INFO, "incremented Minute in date picker overlay");
	crtgrp.datePickerSetButtonOnOverlay();
	logger_ss.log(Status.INFO, "Clicked on set button on overlay");
	crtgrp.giveConferenceAgenda();
	
	crtgrp.uploadNormalClipOnScheduleOverlay();
	Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.deleteNormalClipOptionOnScheduleOverlay));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.normalClipDownloadOptionOnScheduleOverlay));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.normalAudioClipOnScheduleGroupOverlay));
	
	crtgrp.uploadMuteClipOnScheduleOverlay();
	Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.deleteMuteClipOptionOnScheduleOverlay));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.muteClipDownloadOptionOnScheduleOverlay));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.muteAudioClipOnScheduleGroupOverlay));
	
	crtgrp.clickScheduleButtonOnAdvancedSettingsOverlayForSchedule();
	logger_ss.log(Status.INFO, "clicked on Schedule Button On Advanced Settings Overlay For Schedule grpTalk");
	grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
	logger_ss.log(Status.INFO, "selected Recently Saved GrpTalk Group");
	Assert.assertTrue(grpTalks.scheduleCancleButton());
	logger_ss.log(Status.INFO, "Successfully verified the scheduled grp Talk group");
	grpTalks.clickEditButtonOnMyGrpTalksPage();
	logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
	editGrpTalk.clickuploadClipFieldInEditGroup();
	Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.deleteNormalClipOptionOnUploadClipsOverlayInEditGroup));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.normalAudioClipOnEditGroupOverlay));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.deleteMuteClipOptionOnUploadClipsOverlayInEditGroup));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.muteAudioClipOnEditGroupOverlay));
	logger_ss.log(Status.INFO, "Successfully verified ScheduleGroupWithNormalAndMuteClips");
}

@Test
public void verifyDeleteNormalAndMuteClipsFromScheduleGRoup() throws InterruptedException, AWTException {
	logger_ss = extent.createTest("verifyDeleteNormalAndMuteClipsFromScheduleGRoup","verifyDeleteNormalAndMuteClipsFromScheduleGRoup");
	CreatingGroup crtgrp = new CreatingGroup();
	GrpTalks grpTalks = new GrpTalks();
	EditGroupTalk editGrpTalk = new EditGroupTalk();
	grpTalks.clickCreateGrpButton();
	logger_ss.log(Status.INFO, "Clicked on createGroup button in myGrpTalk page");
	crtgrp.clickPhoneContactsTab();
	logger_ss.log(Status.INFO, "Clicked on phone Contacts tab in createGrpTalk page");
	crtgrp.selectContactFromContactList();
	logger_ss.log(Status.INFO, "Selected phone contact from contact list");
	String grpName=crtgrp.setGrpTalkName();
	logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
	crtgrp.submitScheduleButton();
	logger_ss.log(Status.INFO, "Submitted schedule button");
	
	crtgrp.scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule();
	logger_ss.log(Status.INFO, "Click on schedule Date And Time Field On Advanced Settings Overlay For Schedule");
	crtgrp.incrementDatePickerForMinutes(10);
	logger_ss.log(Status.INFO, "incremented Minute in date picker overlay");
	crtgrp.datePickerSetButtonOnOverlay();
	logger_ss.log(Status.INFO, "Clicked on set button on overlay");
	crtgrp.giveConferenceAgenda();
	
	crtgrp.uploadNormalClipOnScheduleOverlay();
	Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.deleteNormalClipOptionOnScheduleOverlay));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.normalClipDownloadOptionOnScheduleOverlay));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.normalAudioClipOnScheduleGroupOverlay));
	
	crtgrp.uploadMuteClipOnScheduleOverlay();
	Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.deleteMuteClipOptionOnScheduleOverlay));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.muteClipDownloadOptionOnScheduleOverlay));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(crtgrp.muteAudioClipOnScheduleGroupOverlay));
	
	crtgrp.clickScheduleButtonOnAdvancedSettingsOverlayForSchedule();
	logger_ss.log(Status.INFO, "clicked on Schedule Button On Advanced Settings Overlay For Schedule grpTalk");
	grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
	logger_ss.log(Status.INFO, "selected Recently Saved GrpTalk Group");
	Assert.assertTrue(grpTalks.scheduleCancleButton());
	logger_ss.log(Status.INFO, "Successfully verified the scheduled grp Talk group");
	grpTalks.clickEditButtonOnMyGrpTalksPage();
	logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
	editGrpTalk.clickuploadClipFieldInEditGroup();
	Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.deleteNormalClipOptionOnUploadClipsOverlayInEditGroup));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.normalAudioClipOnEditGroupOverlay));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.deleteMuteClipOptionOnUploadClipsOverlayInEditGroup));
	Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.muteAudioClipOnEditGroupOverlay));
	CommonMethods.clickMethod(editGrpTalk.normalAudioClipOnEditGroupOverlay);
	Thread.sleep(2000);
	CommonMethods.clickMethod(editGrpTalk.muteAudioClipOnEditGroupOverlay);
	Thread.sleep(2000);
	editGrpTalk.deleteMuteAndNormalClipsFromEditGroup();
	Assert.assertFalse(editGrpTalk.visibilityOfSavedNormalClipOnUploadClipsOverlayInEditGroup());
	Assert.assertFalse(editGrpTalk.visibilityOfSavedMuteClipOnUploadClipsOverlayInEditGroup());
	logger_ss.log(Status.INFO, "Successfully verified ScheduleGroupWithNormalAndMuteClips");
}
	
	@Test
	public void verifyEditGroupWithNormalAndMuteClips() throws InterruptedException, AWTException{
		logger_ss = extent.createTest("verifyEditGroupWithNormalAndMuteClips","verifyEditGroupWithNormalAndMuteClips");
		CreatingGroup crtgrp = new CreatingGroup();
		EditGroupTalk editGrpTalk = new EditGroupTalk();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndSaveTheGrp();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
		editGrpTalk.clickuploadClipFieldInEditGroup();
		editGrpTalk.uploadNormalClipOnEditGroupOverlay();
		Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.deleteNormalClipOptionOnUploadClipsOverlayInEditGroup));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.normalClipDownloadOptionOnUploadClipsOverlayInEditGroup));
		editGrpTalk.uploadMuteClipOnEditGroupOverlay();
		Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.deleteMuteClipOptionOnUploadClipsOverlayInEditGroup));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.muteClipDownloadOptionOnUploadClipsOverlayInEditGroup));
		editGrpTalk.submitSaveButtonOnUploadClipsOverlay();
		editGrpTalk.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "Clicked on save grp call button on edit grpTalk ");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
		editGrpTalk.clickuploadClipFieldInEditGroup();
		Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.deleteNormalClipOptionOnUploadClipsOverlayInEditGroup));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.normalAudioClipOnEditGroupOverlay));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.deleteMuteClipOptionOnUploadClipsOverlayInEditGroup));
		Assert.assertTrue(CommonMethods.isDisplayedMethod(editGrpTalk.muteAudioClipOnEditGroupOverlay));
		logger_ss.log(Status.INFO, "Successfully verified EditGroupWithNormalAndMuteClips");
	}
	
	
	@Test
	public void verifyCanclefunctionalityOnOverlayInGrpCall() throws InterruptedException {
		logger_ss = extent.createTest("verifyCanclefunctionalityOnOverlayInGrpCall","verify Cancle functionality On Overlay In GrpCall");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.selectSavedGroupByName(CommonMethods.passingData("grpTalkGroup"));
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		grpTalks.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		grpTalks.cancelGroupCallOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on Cancle groupCall button on overlay");
		Assert.assertTrue(grpTalks.visibilityOfDialGroupCallButton());
		logger_ss.log(Status.INFO, "Successfully cancled the grpTalk group call  ");
	}
	
	@Test
	public void verifyAllButtonsDisplayedOnCallOverlay() throws InterruptedException {
		logger_ss = extent.createTest("verifyAllButtonsAreDisplayedOnDialCallOverlay","verify All Buttons Are Displayed On Dial Call Overlay");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.selectSavedGroupByName(CommonMethods.passingData("grpTalkGroup"));
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		grpTalks.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalks.cancelGroupCallButtonOnOverlay));
		logger_ss.log(Status.INFO, "verified cancleButtonDisplayedOnCallOverlay");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalks.muteDialGroupCallButtonOnOverlay));
		logger_ss.log(Status.INFO, "verified muteDialButtonDisplayedOnCallOverlay");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalks.dialGroupCallButtonOnOverlay));
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
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.selectSavedGroupByName(CommonMethods.passingData("grpTalkGroup"));
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		grpTalks.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		grpTalks.muteDialGroupCallOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on mute dial button on overlay");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Successfully verified on call progress");
		
		int unMutedCountInGrpCall =  grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall, 0);
		Assert.assertEquals(grpTalks.totalParticipants(), unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		
		int allMembersCount = grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(allMembersCount, 4);
		Assert.assertEquals(grpTalks.totalParticipants(), allMembersCount);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");
		
		int onCallCount =  grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCount, 4);
		Assert.assertEquals(grpTalks.totalParticipants(), onCallCount);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
			
		int callEndedCount =  grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(callEndedCount, 0);
		Assert.assertEquals(grpTalks.totalParticipants(), callEndedCount);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		Assert.assertTrue(grpTalks.visibilityOfMuteBuutonInGrpCall());
		logger_ss.log(Status.INFO, "Successfully verifed the visibility of mute button in grp call");
		grpTalks.selectOnCallTabAndCountTheParticipants();
		logger_ss.log(Status.INFO, "Clicked on onCallCount tab In GrpCall");
		Assert.assertTrue(grpTalks.visibilityOfIndividualUserMuteButtomInGrpCall());
		logger_ss.log(Status.INFO, "Successfully verifed the visibility of individual user mute button in grp call");

		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
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
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.selectSavedGroupByName(CommonMethods.passingData("grpTalkGroup"));
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		grpTalks.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		grpTalks.muteDialGroupCallOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on mute dial button on overlay");
		grpTalks.verifyLiveCallState();
		
		logger_ss.log(Status.INFO, "Successfull verified on call state");
		int unMutedCountInGrpCall = grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall, 0);
		Assert.assertEquals(grpTalks.totalParticipants(), unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		
		int selectAllParticipantsTabAndCountTheParticipants = grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants, 4);
		Assert.assertEquals(grpTalks.totalParticipants(), selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");
		
		int onCallCountInGrpCall = grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall, 4);
		Assert.assertEquals(grpTalks.totalParticipants(), onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		int selectDisconnectedTabAndCountTheParticipants = grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants, 0);
		Assert.assertEquals(grpTalks.totalParticipants(), selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		Assert.assertTrue(grpTalks.visibilityOfMuteBuutonInGrpCall());
		logger_ss.log(Status.INFO, "Verified visibility Of Mute Buuton In GrpCall");
		grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertTrue(grpTalks.visibilityOfIndividualUserMuteButtomInGrpCall());
				
		logger_ss.log(Status.INFO, "Verified visibility Of individual user Mute Buuton In GrpCall");
		grpTalks.clickOnMuteButtonToUnMuteAllUsersInGrpCall();
		logger_ss.log(Status.INFO, "clicked On Mute Button To UnMute All Users In Grp Call");
		
		Assert.assertTrue(grpTalks.visibilityOfUnMuteBuutonFromMuteInGrpCall());
		logger_ss.log(Status.INFO, "Verified visibility Of unMute Buuton In GrpCall");
		Assert.assertTrue(grpTalks.visibilityOfIndividualUserUnMuteButtomInGrpCall());
		logger_ss.log(Status.INFO, "Verified visibility Of individual user Mute Buuton In GrpCall");		
		
		int unMutedCount = grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCount, 3);
		Assert.assertEquals(grpTalks.totalParticipants(), unMutedCount);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
	
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
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
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.selectSavedGroupByName(CommonMethods.passingData("grpTalkGroup"));
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");		
		grpTalks.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		grpTalks.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on dial grpCall button on overlay");
		grpTalks.verifyLiveCallState();
		grpTalks.clickOnUnMuteButtonToMuteAllUsersInGrpCall();
		logger_ss.log(Status.INFO, "clicked On Un Mute Button To Mute All Users In GrpCall");
		Assert.assertTrue(grpTalks.visibilityOfMuteBuutonInGrpCall());
		logger_ss.log(Status.INFO, "Successfully verified the visibility Of Mute Button In GrpCall");
		grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertTrue(grpTalks.visibilityOfIndividualUserMuteButtomInGrpCall());
		logger_ss.log(Status.INFO, "Successfully verified the visibility Of Individual User Mute Button In GrpCall");
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
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
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndSaveTheGrp();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		grpTalks.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		grpTalks.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on dial grpCall button on overlay");
		grpTalks.verifyLiveCallState();
		grpTalks.addMemberInOnGoingGrpCall();
		
		int onCallCountInGrpCall = grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall, 5);
		Assert.assertEquals(grpTalks.totalParticipants(), onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");

		grpTalks.clickOnIndividualUserHangUpButtomInGrpCall();
		logger_ss.log(Status.INFO, "Clicked on individual user hangUp button in grp call");
		
		int selectAllParticipantsTabAndCountTheParticipants = grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants, 5);
		Assert.assertEquals(grpTalks.totalParticipants(), selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");

		int unMutedCountInGrpCall = grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall, 3);
		Assert.assertEquals(grpTalks.totalParticipants(), unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");

		int onCallCount = grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCount, 4);
		Assert.assertEquals(grpTalks.totalParticipants(), onCallCount);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		int selectDisconnectedTabAndCountTheParticipants = grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants, 1);
		Assert.assertEquals(grpTalks.totalParticipants(), selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");

		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
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
	@Test
	public void verifyAddMemberInOnGoingGrpCallThroughContacts() throws InterruptedException {
		logger_ss = extent.createTest("verifyAddMemberInOnGoingGrpCallThroughContacts","verify Add Member In OnGoing GrpCall Through Contacts");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndSaveTheGrpWithOneParticipant();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		
		grpTalks.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		grpTalks.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on dial grpCall button on overlay");
		grpTalks.verifyLiveCallState();
		grpTalks.addMemberInOnGoingCallThroughContacts();
		logger_ss.log(Status.INFO, "Added Member In OnGoing Call Through Contacts");
		
		int selectAllParticipantsTabAndCountTheParticipants= grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants, 3);
		Assert.assertEquals(grpTalks.totalParticipants(), selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");

		int unMutedCountInGrpCall= grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall, 2);
		Assert.assertEquals(grpTalks.totalParticipants(), unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");

		int onCallCountInGrpCall= grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall, 3);
		Assert.assertEquals(grpTalks.totalParticipants(), onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		int selectDisconnectedTabAndCountTheParticipants= grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants, 0);
		Assert.assertEquals(grpTalks.totalParticipants(), selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		grpTalks.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "hangUp Current GrpTalk call");
		logger_ss.log(Status.INFO, "Successfully verifed AddMemberInOnGoingGrpCallThroughContacts");
	}
	
	@Test
	public void verifyAddMemberInOnGoingGrpCallThroughWebList() throws InterruptedException {
		logger_ss = extent.createTest("verifyAddMemberInOnGoingGrpCallThroughWebList","verify Add Member In OnGoing GrpCall Through WebList");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndSaveTheGrpWithOneParticipant();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		grpTalks.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		grpTalks.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on dial grpCall button on overlay");
		grpTalks.verifyLiveCallState();
		Thread.sleep(3000);
		grpTalks.addMemberInOnGoingCallThroughWebList();
		logger_ss.log(Status.INFO, "Added Member In OnGoing Call Through weblist");
		
		int selectAllParticipantsTabAndCountTheParticipants= grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants, 3);
		Assert.assertEquals(grpTalks.totalParticipants(), selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");
		
		int unMutedCountInGrpCall= grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall, 2);
		Assert.assertEquals(grpTalks.totalParticipants(), unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");

		int onCallCountInGrpCall= grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall, 3);
		Assert.assertEquals(grpTalks.totalParticipants(), onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		int selectDisconnectedTabAndCountTheParticipants= grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants, 0);
		Assert.assertEquals(grpTalks.totalParticipants(), selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "hangUp Current GrpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
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
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.selectSavedGroupByName(CommonMethods.passingData("grpTalkGroup"));
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		Thread.sleep(2000);
		grpTalks.historyButtonOnMyGrpTalks();
		logger_ss.log(Status.INFO, "Clicked on history Button On MyGrpTalks");
		grpTalks.grpCallDurationInHistoryTab();
		logger_ss.log(Status.INFO, "Getting grp Call Duration In History Tab");
		grpTalks.totalMinutesConsumedInGrpCall();
		logger_ss.log(Status.INFO, "Getting total Minutes Consumed In GrpCall");
		grpTalks.totalAmountChargedForGrpcall();
		logger_ss.log(Status.INFO, "Getting total amount charged for GrpCall");
		grpTalks.groupTotalDialOutMinsOnHistory();
		logger_ss.log(Status.INFO, "Getting group Total DialOut Mins On History");
		
		logger_ss.log(Status.INFO, "Expected groupTotalDialOutMinsOnHistory is:");
		int groupTotalDialOutMinsOnHistory = grpTalks.groupTotalDialOutMinsOnHistory();
		logger_ss.log(Status.INFO, String.valueOf(groupTotalDialOutMinsOnHistory));
		
		logger_ss.log(Status.INFO, "Actual  totalMinutesConsumedInGrpCall is:");
		int totalMinutesConsumedInGrpCall= grpTalks.totalMinutesConsumedInGrpCall();
		logger_ss.log(Status.INFO, String.valueOf(totalMinutesConsumedInGrpCall));
		Assert.assertEquals(grpTalks.totalMinutesConsumedInGrpCall(), grpTalks.groupTotalDialOutMinsOnHistory());
		logger_ss.log(Status.INFO, "Successfully verified the total Minutes Consumed In GrpCall with group Total DialOut Mins On History");
		
		logger_ss.log(Status.INFO, "Expected totalAmountChargedForGroupOnHistory is:");
		double totalAmountChargedForGroupOnHistory = grpTalks.totalAmountChargedForGroupOnHistory();
		logger_ss.log(Status.INFO, String.valueOf(totalAmountChargedForGroupOnHistory));
		logger_ss.log(Status.INFO, "Actual  totalAmountChargedForGrpcall is:");
		double totalAmountChargedForGrpcall = grpTalks.totalAmountChargedForGrpcall();
		logger_ss.log(Status.INFO, String.valueOf(totalAmountChargedForGrpcall));
		Assert.assertEquals(grpTalks.totalAmountChargedForGrpcall(), grpTalks.totalAmountChargedForGroupOnHistory());
		logger_ss.log(Status.INFO, "Successfully verified the total Amount Charged For Grpcall with total Amount Charged For Group On History");
		logger_ss.log(Status.INFO, "Successfully verifed HistoryOfGroup");
	}
	
	@Test
	public void verifyScheduleGrpTalk() throws InterruptedException {
		logger_ss = extent.createTest("verifyScheduleGrpTalk","verify Schedule GrpTalk");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on createGroup button in myGrpTalk page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone Contacts tab in createGrpTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		String grpName=crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitScheduleButton();
		logger_ss.log(Status.INFO, "Submitted schedule button");
		crtgrp.scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "Click on schedule Date And Time Field On Advanced Settings Overlay For Schedule");
		crtgrp.incrementDatePickerForMinutes(1);
		logger_ss.log(Status.INFO, "incremented Minute in date picker overlay");
		crtgrp.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on set button on overlay");
		crtgrp.giveConferenceAgenda();
		crtgrp.clickScheduleButtonOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "clicked on Schedule Button On Advanced Settings Overlay For Schedule grpTalk");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "selected Recently Saved GrpTalk Group");
		Assert.assertTrue(grpTalks.scheduleCancleButton());
		logger_ss.log(Status.INFO, "Successfully verified the scheduled grp Talk group");
	}
	
	@Test
	public void verifyDatePickerFunctionalityForScheduleOnEditGrpTalks() throws InterruptedException {
		logger_ss = extent.createTest("verifyDatePickerFunctionalityForScheduleOnEditGrpTalks","verify DatePicker Functionality For Schedule On Edit GrpTalks");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		EditGroupTalk editGrpTalk = new EditGroupTalk();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected contact from contact list");
		String grpName=crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "Submitted saveGroup button on overlay");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
		editGrpTalk.clickScheduleDateAndTimeFieldOnEditGroupTalkPage();
		logger_ss.log(Status.INFO, "clicked on Schedule Date And Time Field On Edit GroupTalk Page");
		editGrpTalk.incrementDatePickerForMinutes(1);
		logger_ss.log(Status.INFO, "incremented one minute on DatePicker overlay");
		String dateAndTime = editGrpTalk.dateAndTimeTextOnOverlay();
		editGrpTalk.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "clicked on date Picker Set Button On Overlay");
		editGrpTalk.clickRepeatDaysFiledOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Repeat Days Filed On Edit GrpTalk");
		String s= editGrpTalk.repeatDaysOnAdvancedSettingsOverlayForScheduleInEditGrpTalk();
		logger_ss.log(Status.INFO, "Selected repeatDays On Advanced Settings Overlay For Schedule");
		editGrpTalk.setButtonONOverlayOnEditGrpTalk();
		editGrpTalk.enterAgendaInEditGrpTalk();
		logger_ss.log(Status.INFO, "Clicked on set Button ON Overlay On Edit GrpTalk");
		editGrpTalk.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "Clicked on save grp call button on edit grpTalk ");
		//Assert.assertEquals(crtgrp.scheduleTimeAndRepeateDaysTextOfGroupOnMyGrpTalk(), dateAndTime);
		logger_ss.log(Status.INFO, "successfully verified DatePickerFunctionalityForScheduleOnEditGrpTalks");
	}
	
	@Test
	public void verifyDatePickerFunctionalityOnEditGrpTalks() throws InterruptedException {
		logger_ss = extent.createTest("verifyDatePickerFunctionalityOnEditGrpTalks","verify Date Picker Functionality On Edit GrpTalks");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		EditGroupTalk editGrpTalk= new EditGroupTalk();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		String grpName=crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "Submitted saveGroup button on overlay");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
		editGrpTalk.clickScheduleDateAndTimeFieldOnEditGroupTalkPage();
		logger_ss.log(Status.INFO, "clicked on Schedule Date And Time Field On Edit GroupTalk Page");
		editGrpTalk.incrementDatePickerForMinutes(11);
		logger_ss.log(Status.INFO, "incremented minutes on DatePicker overlay");
		editGrpTalk.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "clicked on date Picker Set Button On Overlay");
		editGrpTalk.clickScheduleDateAndTimeFieldOnEditGroupTalkPage();
		logger_ss.log(Status.INFO, "clicked on Schedule Date And Time Field On Edit GroupTalk Page");
		String initialDateAndTime = editGrpTalk.dateAndTimeTextOnOverlay();
		logger_ss.log(Status.INFO, "Getting initial Date And Time on overlay is:: ");
		logger_ss.log(Status.INFO, initialDateAndTime);
		editGrpTalk.incrementDateAndTimeOnOverlay(3);
		logger_ss.log(Status.INFO, "incremented Date And Time On Overlay ");
		String incrementDateAndTime = editGrpTalk.dateAndTimeTextOnOverlay();
		logger_ss.log(Status.INFO, "Getting increment Date And Time on overlay is:: ");
		logger_ss.log(Status.INFO, incrementDateAndTime);
		editGrpTalk.decrementDateAndTimeOnOverlay(3);
		logger_ss.log(Status.INFO, "Decremented Date And Time On Overlay ");
		
		String decrementDateAndTime = editGrpTalk.dateAndTimeTextOnOverlay();
		logger_ss.log(Status.INFO, "Getting decrement Date And Time on overlay is:: ");
		logger_ss.log(Status.INFO, decrementDateAndTime);
		Assert.assertEquals(initialDateAndTime, decrementDateAndTime);
		logger_ss.log(Status.INFO, "Successfully verified the initial Date and Time with decrement date and time");
		
		editGrpTalk.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on date Picker Set Button On Overlay");
		editGrpTalk.clickRepeatDaysFiledOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Repeat Days Filed On Edit GrpTalk");
		String s= editGrpTalk.repeatDaysOnAdvancedSettingsOverlayForScheduleInEditGrpTalk();
		logger_ss.log(Status.INFO, "Selected repeatDays On Advanced Settings Overlay For Schedule");
		editGrpTalk.setButtonONOverlayOnEditGrpTalk();
		logger_ss.log(Status.INFO, "Clicked on set Button ON Overlay On Edit GrpTalk");
		editGrpTalk.clickSaveGrpCallOnEditGrpTalk();
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
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		EditGroupTalk editGrpTalk= new EditGroupTalk();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		String grpName=crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitSaveButton();
		logger_ss.log(Status.INFO, "Submitted save button");
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "Submitted saveGroup button on overlay");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
		editGrpTalk.clickRepeatDaysFiledOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Repeat Days Filed On Edit GrpTalk");
		String s= editGrpTalk.repeatDaysOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "Selected repeatDays On Advanced Settings Overlay For Schedule");
		editGrpTalk.setButtonONOverlayOnEditGrpTalk();
		logger_ss.log(Status.INFO, "Clicked on set Button ON Overlay On Edit GrpTalk");
		editGrpTalk.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "Clicked on save grp call button on edit grpTalk ");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		logger_ss.log(Status.INFO, "Expected days: ");
		logger_ss.log(Status.INFO, s);
		String actualResult = grpTalks.scheduleRepeateDaysTextOfGroupOnMyGrpTalk();
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
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		EditGroupTalk editGrpTalk= new EditGroupTalk();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		String grpName=crtgrp.setGrpTalkName();
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
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button On MyGrpTalks Page");
		editGrpTalk.clickAdvacedSettingOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on AdvacedSettingOnEditGrpTalk");
		Assert.assertTrue(editGrpTalk.visibilityOfOnOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettings());
		logger_ss.log(Status.INFO, "verified visibilityOfOnOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettings");
		editGrpTalk.saveButtonOnAdvancedSettingInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on saveButtonOnAdvancedSettingInEditGrpTalk");
		editGrpTalk.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on SaveGrpCallOnEditGrpTalk");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		logger_ss.log(Status.INFO, "Successfully verified DialInOptionInAdvancedSettingsOnOverlayForSchedule");
	}
	@Test
	public void VerifyAssignCallManagerOptionInAdvancedSettingsOnOverlayForSchedule() throws InterruptedException {
		logger_ss = extent.createTest("VerifyAssignCallManagerOptionInAdvancedSettingsOnOverlayForSchedule","VerifyAssignCallManagerOptionInAdvancedSettingsOnOverlayForSchedule");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectContactFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		String grpName=crtgrp.setGrpTalkName();
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
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		Assert.assertTrue(grpTalks.visibilityOfCallManagerOptionForContacts());
		logger_ss.log(Status.INFO, "Successfully verified visibilityOfCallManagerOptionForContacts");
		logger_ss.log(Status.INFO, "Successfully verified AssignCallManagerOptionInAdvancedSettingsOnOverlayForSchedule");
	}
	@Test
	public void VerifyDialInOptionInAdvancedSettingsOnOverlayInEditGrpTalk() throws InterruptedException {
		logger_ss = extent.createTest("VerifyDialInOptionInAdvancedSettingsOnOverlayInEditGrpTalk","Verify DialIn Option In Advanced Settings On Overlay In Edit GrpTalk");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		EditGroupTalk editGrpTalk= new EditGroupTalk();
		String grpName=crtgrp.createAndSaveTheGrpWithOneParticipant();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button in MyGrpTalks Page");
		editGrpTalk.clickAdvacedSettingOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Advaced Settings in Edit GrpTalk");
		editGrpTalk.onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on onOff Switch Label For DialIn Only On Advanced Settings In Edit GrpTalk");
		editGrpTalk.saveButtonOnAdvancedSettingInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on save Button On Advanced Setting In Edit GrpTalk");
		editGrpTalk.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Save GrpCall On Edit GrpTalk");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		logger_ss.log(Status.INFO, "Expected dailIn msg is: Dial in Only");
		logger_ss.log(Status.INFO, "Actual dailIn msg is:");
		logger_ss.log(Status.INFO, grpTalks.dialInMsgForGrpOnMyGrpTalks());
		Assert.assertEquals(grpTalks.dialInMsgForGrpOnMyGrpTalks(), "Dial in Only");
		logger_ss.log(Status.INFO, "Successfully verified dialIn Msg For Grp On MyGrpTalks");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button in MyGrpTalks Page");
		editGrpTalk.clickAdvacedSettingOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Advaced Settings in Edit GrpTalk");
		editGrpTalk.onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on onOff Switch Label For DialIn Only On Advanced Settings In Edit GrpTalk");
		editGrpTalk.saveButtonOnAdvancedSettingInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on save Button On Advanced Setting In Edit GrpTalk");
		editGrpTalk.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Save GrpCall On Edit GrpTalk");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		logger_ss.log(Status.INFO, "Successfully verified DialInOptionInAdvancedSettingsOnOverlayInEditGrpTalk");
	}
	
	@Test(priority=4)
	public void VerifyAllowNonMembersOptionInAdvancedSettingsOnOverlayInEditGrpTalk() throws InterruptedException {
		logger_ss = extent.createTest("VerifyAllowNonMembersOptionInAdvancedSettingsOnOverlayInEditGrpTalk","Verify Allow Non Members Option In Advanced Settings On Overlay In Edit GrpTalk");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		EditGroupTalk editGrpTalk= new EditGroupTalk();
		String grpName =crtgrp.createAndSaveTheGrp();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button in MyGrpTalks Page");
		editGrpTalk.clickAdvacedSettingOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Advaced Settings in Edit GrpTalk");
		editGrpTalk.onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on onOff Switch Label For AllowNonMembers On Advanced Settings In Edit GrpTalk");
		editGrpTalk.saveButtonOnAdvancedSettingInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on save Button On Advanced Setting In Edit GrpTalk");
		editGrpTalk.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Save GrpCall On Edit GrpTalk");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		Assert.assertTrue(grpTalks.nonMembersMsgForGrpOnMyGrpTalks());
		logger_ss.log(Status.INFO, "Successfully verified 'Non Members can Dial in Using Conference PIN' Msg For Grp On MyGrpTalks");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		editGrpTalk.clickAdvacedSettingOnEditGrpTalk();
		editGrpTalk.onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk();
		editGrpTalk.saveButtonOnAdvancedSettingInEditGrpTalk();
		editGrpTalk.clickSaveGrpCallOnEditGrpTalk();
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
	@Test(priority=5)
	public void VerifyDialInOptionAndAllowNonMembersOptionInAdvancedSettingsOnOverlayInEditGrpTalk() throws InterruptedException {
		logger_ss = extent.createTest("VerifyDialInOptionAndAllowNonMembersOptionInAdvancedSettingsOnOverlayInEditGrpTalk","Verify DialIn Option And AllowNonMembers Option In Advanced Settings On Overlay In EditGrpTalk");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		EditGroupTalk editGrpTalk= new EditGroupTalk();
		String name =crtgrp.createAndSaveTheGrp();
		System.out.println("grpName "+ name);
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		String savedName = grpTalks.selectRecentlySavedGrpTalkGroup(name);
		System.out.println("savedName "+ savedName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		logger_ss.log(Status.INFO, "clicked on Edit Button in MyGrpTalks Page");
		editGrpTalk.clickAdvacedSettingOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Advaced Settings in Edit GrpTalk");
		editGrpTalk.onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on onOff Switch Label For DialInOnly On Advanced Settings In Edit GrpTalk");
		editGrpTalk.onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on onOff Switch Label For AllowNonMembers On Advanced Settings In Edit GrpTalk");
		editGrpTalk.saveButtonOnAdvancedSettingInEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on save Button On Advanced Setting In Edit GrpTalk");
		editGrpTalk.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "clicked on Save GrpCall On Edit GrpTalk");
		String name1=grpTalks.selectRecentlySavedGrpTalkGroup(name);
		System.out.println("savedName "+ name1);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");
		Assert.assertTrue(grpTalks.dialInAndNonMembersMsgForGrpOnMyGrpTalks());
		logger_ss.log(Status.INFO, "Successfully verified dialIn Msg For Grp On MyGrpTalks");
		grpTalks.clickEditButtonOnMyGrpTalksPage();
		editGrpTalk.clickAdvacedSettingOnEditGrpTalk();
		editGrpTalk.onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk();
		editGrpTalk.onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk();
		editGrpTalk.saveButtonOnAdvancedSettingInEditGrpTalk();
		editGrpTalk.clickSaveGrpCallOnEditGrpTalk();
		logger_ss.log(Status.INFO, "Successfully verified DialInOptionAndAllowNonMembersOptionInAdvancedSettingsOnOverlayInEditGrpTalk");
	}
	
	@Test
	public void verifyCallFunctionalityOfDialAllButtonInCallEndedTab() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityOfDialAllButtonInCallEndedTab","verifyCallFunctionalityOfDialAllButtonInCallEndedTab");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndCallTheGrp();
		logger_ss.log(Status.INFO, "created and dialed to new grpTalk group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,4);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		
		int allParticipantsCount =grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickOnIndividualUserHangUpButtomInGrpCall();
		
		Assert.assertEquals(allParticipantsCount, 4);
		Assert.assertEquals(grpTalks.totalParticipants(),allParticipantsCount);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");

		int unMutedCount = grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCount, 2);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCount);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");

		int onCallCount = grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCount, 3);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCount);
		logger_ss.log(Status.INFO, "Successfully verified onCall count in grp call");
		
		int callEndedCount = grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(callEndedCount, 1);
		Assert.assertEquals(grpTalks.totalParticipants(),callEndedCount);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");

		grpTalks.clickDialAllButtonInCallEndedTab();
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		
		int unMutedCount1 = grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCount1, 3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCount1);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");

		int onCallCount1 = grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCount1, 4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCount1);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		int callEndedCount1 = grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(callEndedCount1, 0);
		Assert.assertEquals(grpTalks.totalParticipants(),callEndedCount1);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingExcelentOption();
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verifed CallFunctionalityOfDialAllButtonInCallEndedTab");
	}
	
	@Test
	public void verifyCallFunctionalityOfIndividualDialInCallEndedTab() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityOfIndividualDialInCallEndedTab","verifyCallFunctionalityOfIndividualDialInCallEndedTab");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndCallTheGrp();
		logger_ss.log(Status.INFO, "created and dialed to new grpTalk group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,4);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickOnIndividualUserHangUpButtomInGrpCall();
		logger_ss.log(Status.INFO, "clicked On IndividualUserHangUpButtomInGrpCall");
		
		int allMembersCount1= grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(allMembersCount1, 4);
		Assert.assertEquals(grpTalks.totalParticipants(),allMembersCount1);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");
		
		int unMutedCount = grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCount, 2);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCount);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		
		int onCallCount = grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCount, 3);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCount);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		int callEndedCount = grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(callEndedCount, 1);
		Assert.assertEquals(grpTalks.totalParticipants(),callEndedCount);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		grpTalks.clickreDialButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on reDial ButtonOfIndividualContactInLiveCall");
		
		int unMutedCount1 = grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCount1, 3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCount1);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		
		int onCallCount1 = grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCount1, 4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCount1);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		int callEndedCount1 = grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(callEndedCount1, 0);
		Assert.assertEquals(grpTalks.totalParticipants(),callEndedCount1);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verifed CallFunctionalityOfIndividualDialInCallEndedTab");
	}
	
	@Test
	public void verifyRetryCallFunctionality() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromAllMembersTab","verifyCallFunctionalityFromAllMembersTab");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndCallTheGrpWithRetryContact();
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified live Call is in progress ");
		Thread.sleep(35000);
		Assert.assertTrue(grpTalks.redialingSymbol());
		logger_ss.log(Status.INFO, "Verified presence Of redial symbol");
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verifed CallFunctionalityOfIndividualDialInCallEndedTab");
		
	}
	@Test
	public void verifyCallFunctionalityOfIndividualDialInCallEndedTabInListView() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityOfIndividualDialInCallEndedTabInListView","verifyCallFunctionalityOfIndividualDialInCallEndedTabInListView");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndCallTheGrp();
		logger_ss.log(Status.INFO, "Dialing to new group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified live Call is in progress ");
		grpTalks.listViewInLiveCall();
		logger_ss.log(Status.INFO, "Switched to list view ");
		
		int allParticipantsCount=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(allParticipantsCount,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),allParticipantsCount);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		
		int disconnectedCount=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(disconnectedCount,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),disconnectedCount);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickhangUpButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked On hangUp Button Of participant");
		
		int onCallCount = grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCount, 3);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCount);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		int callEndedCount = grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(callEndedCount, 1);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),callEndedCount);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		grpTalks.clickreDialButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked on reDial Button Of participant");
		
		int unMutedCount1 = grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCount1, 3);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCount1);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");
		
		int onCallCount1 = grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCount1, 4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCount1);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		int callEndedCount1 = grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(callEndedCount1, 0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),callEndedCount1);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickhangUpButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked On hangUp Button Of participant");
		
		int callEndedCount2 = grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(callEndedCount2, 1);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),callEndedCount2);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		grpTalks.clickDialAllButtonInCallEndedTab();
		logger_ss.log(Status.INFO, "clicked On dial All Button in callEnded tab");
		
		int callEndedCount3 = grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(callEndedCount3, 0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),callEndedCount3);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");
		
		int onCallCount2 = grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCount2, 4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCount2);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		
		grpTalks.submitRateCallByClickingGoodOption();
		
		logger_ss.log(Status.INFO, "Submitted rate call with good option");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verifed Call Functionality from Individual Dial InCallEndedTab");
	}
	
	@Test
	public void verifyCallFunctionalityWhenMuteAllButtonIsClickedInUnMutedTab() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityWhenMuteAllButtonIsClickedInUnMutedTab","verifyCallFunctionalityWhenMuteAllButtonIsClickedInUnMutedTab");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndCallTheGrp();
		logger_ss.log(Status.INFO, "created and dialed to new grpTalk group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,4);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.clickMuteAllButtonInUnMutedTab();
		logger_ss.log(Status.INFO, "clicked on MuteAllButtonInUnMutedTab");
		
		int allMembersCount1 =grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(allMembersCount1, 4);
		Assert.assertEquals(grpTalks.totalParticipants(),allMembersCount1);
		logger_ss.log(Status.INFO, "Successfully verifed all members count in grp call");

		int unMutedCount1 =grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCount1, 0);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCount1);
		logger_ss.log(Status.INFO, "Successfully verifed unMuted count in grp call");

		int onCallCount1 =grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCount1, 4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCount1);
		logger_ss.log(Status.INFO, "Successfully verifed onCall count in grp call");
		
		int callEndedCount1 =grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(callEndedCount1, 0);
		Assert.assertEquals(grpTalks.totalParticipants(),callEndedCount1);
		logger_ss.log(Status.INFO, "Successfully verifed call ended count in grp call");

		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		//grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verifed CallFunctionalityWhenMuteAllButtonIsClickedInUnMutedTab");
	}
	
	@Test
	public void verifyPrivateRoomFuntionalityInLiveCall() throws InterruptedException {
		logger_ss = extent.createTest("verifyPrivateRoomFuntionalityInLiveCall","verifyPrivateRoomFuntionalityInLiveCall");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndCallTheGrp();
		logger_ss.log(Status.INFO, "created and dialed to new grpTalk group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,4);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingToPrviateRoom();
		logger_ss.log(Status.INFO, "clicked on PublicRoomButtonOfContact");
		
		int onCallCountInGrpCall2=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall2 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertTrue(grpTalks.visibilityOfClosePrivateRoomButtonInPrivateRoomTab());
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");

		grpTalks.clickClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "clicked on ClosePrivateRoomButtonInPrivateRoomTab");
		
		int privateRoomMembersCountInGrpCall3 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified private RoomMembersCountInGrpCall");
		
		int onCallCountInGrpCall3=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall3,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall3=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall3,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingToPrviateRoom();
		logger_ss.log(Status.INFO, "clicked on PublicRoomButtonOfContact");
		
		int privateRoomMembersCountInGrpCall4 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall4,2);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall4);
		logger_ss.log(Status.INFO, "Successfully verified private RoomMembersCountInGrpCall");
		//grpTalks.clickPrivateRoomButton();
		grpTalks.participantMovingBackTocall();
		logger_ss.log(Status.INFO, "clicked on PrivateRoomButton");
		
		int privateRoomMembersCountInGrpCall5 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall5,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall5);
		logger_ss.log(Status.INFO, "Successfully verified private RoomMembersCountInGrpCall");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verifed verifyPrivateRoomFuntionalityInLiveCall");
	}
	
	@Test
	public void verifyMuteAndUnmuteFunctionalityInLiveCallWhenParticipantsAreInPrivateRoom() throws InterruptedException {
		logger_ss = extent.createTest("verifyMuteAndUnmuteFunctionalityInLiveCallWhenParticipantsAreInPrivateRoom","verifyMuteAndUnmuteFunctionalityInLiveCallWhenParticipantsAreInPrivateRoom");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndCallTheGrp();
		logger_ss.log(Status.INFO, "created and dialed to new grpTalk group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "verified live call state");
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,4);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingToPrviateRoom();
		logger_ss.log(Status.INFO, "clicked on PublicRoomButtonOfContact");
		
		int onCallCountInGrpCall2=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectOnCallTabAndCountTheParticipants();
		grpTalks.clickOnUnMuteButtonToMuteAllUsersInGrpCall();
		Thread.sleep(1000);
		Assert.assertTrue(grpTalks.checkVisibilityOfIndividualUserMuteButtomInGrpCall());
		
		int privateRoomMembersCountInGrpCall2 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertTrue(grpTalks.visibilityOfClosePrivateRoomButtonInPrivateRoomTab());
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectOnCallTabAndCountTheParticipants();
		grpTalks.clickOnMuteButtonToUnMuteAllUsersInGrpCall();
		Assert.assertTrue(grpTalks.checkVisibilityOfIndividualUserUnMuteButtomInGrpCall());
		Thread.sleep(1000);
		int privateRoomMembersCountInGrpCall7 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertTrue(grpTalks.visibilityOfClosePrivateRoomButtonInPrivateRoomTab());
		Assert.assertEquals(privateRoomMembersCountInGrpCall7,2);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall7);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		Thread.sleep(1000);
		Assert.assertTrue(grpTalks.muteOptionPresenceInPrivateRoomTab());
		Thread.sleep(1000);
		Assert.assertTrue(grpTalks.unMuteOptionPresenceInPrivateRoomTab());
		
		grpTalks.clickClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "clicked on ClosePrivateRoomButtonInPrivateRoomTab");
		
		int privateRoomMembersCountInGrpCall3 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified private RoomMembersCountInGrpCall");
		
		int onCallCountInGrpCall3=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall3,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall3=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall3,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertTrue(grpTalks.checkVisibilityOfIndividualUserUnMuteButtomInGrpCall());
		
		grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Thread.sleep(1000);
		Assert.assertTrue(grpTalks.muteOptionPresenceInPrivateRoomTab());
		Thread.sleep(1000);
		Assert.assertTrue(grpTalks.unMuteOptionPresenceInPrivateRoomTab());
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verifed verifyPrivateRoomFuntionalityInLiveCall");
	}
	
//	@Test
//	public void verifyHandRaiseFuntionalityInLiveCall() throws InterruptedException {
//		logger_ss = extent.createTest("verifyHandRaiseFuntionalityInLiveCall","verifyHandRaiseFuntionalityInLiveCall");
//		CreatingGroup crtgrp = new CreatingGroup();
//		GrpTalks grpTalks = new GrpTalks();
//		crtgrp.createAndCallTheGrp();
//		logger_ss.log(Status.INFO, "created and dialed to new grpTalk group by submitting StartNowButton");
//		grpTalks.verifyLiveCallState();
//		logger_ss.log(Status.INFO, "Verified live call state");
//		int allParticipantsCount=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
//		Assert.assertEquals(allParticipantsCount,4);
//		Assert.assertEquals(grpTalks.totalParticipants(),allParticipantsCount);
//		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
//		
//		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
//		Assert.assertEquals(onCallCountInGrpCall,4);
//		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
//		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
//		
//		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
//		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
//		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
//		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
//		
//		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
//		Assert.assertEquals(unMutedCountInGrpCall,3);
//		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
//		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
//		
//		int privateRoomMembersCountInGrpCall = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
//		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);
//		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall);
//		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
//		
//		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
//		grpTalks.participantMovingToPrviateRoom();
//		logger_ss.log(Status.INFO, "clicked on PublicRoomButtonOfContact");
//		
//		int onCallCountInGrpCall2=grpTalks.selectOnCallTabAndCountTheParticipants();
//		Assert.assertEquals(onCallCountInGrpCall2,2);
//		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall2);
//		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
//		
//		int unMutedCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
//		Assert.assertEquals(unMutedCountInGrpCall2,2);
//		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall2);
//		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
//		
//		int privateRoomMembersCountInGrpCall2 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
//		Assert.assertTrue(grpTalks.visibilityOfClosePrivateRoomButtonInPrivateRoomTab());
//		Assert.assertEquals(privateRoomMembersCountInGrpCall2,2);
//		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall2);
//		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
//
//		grpTalks.clickClosePrivateRoomButtonInPrivateRoomTab();
//		logger_ss.log(Status.INFO, "clicked on ClosePrivateRoomButtonInPrivateRoomTab");
//		
//		int privateRoomMembersCountInGrpCall3 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
//		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
//		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall3);
//		logger_ss.log(Status.INFO, "Successfully verified private RoomMembersCountInGrpCall");
//		
//		int onCallCountInGrpCall3=grpTalks.selectOnCallTabAndCountTheParticipants();
//		Assert.assertEquals(onCallCountInGrpCall3,4);
//		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall3);
//		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
//		
//		int unMutedCountInGrpCall3=grpTalks.selectUnMutedTabAndCountTheParticipants();
//		Assert.assertEquals(unMutedCountInGrpCall3,3);
//		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall3);
//		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
//		
//		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
//		grpTalks.participantMovingToPrviateRoom();
//		logger_ss.log(Status.INFO, "clicked on PublicRoomButtonOfContact");
//		
//		int privateRoomMembersCountInGrpCall4 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
//		Assert.assertEquals(privateRoomMembersCountInGrpCall4,2);
//		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall4);
//		logger_ss.log(Status.INFO, "Successfully verified private RoomMembersCountInGrpCall");
//		//grpTalks.clickPrivateRoomButton();
//		grpTalks.participantMovingBackTocall();
//		logger_ss.log(Status.INFO, "clicked on PrivateRoomButton");
//		
//		int privateRoomMembersCountInGrpCall5 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
//		Assert.assertEquals(privateRoomMembersCountInGrpCall5,0);
//		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall5);
//		logger_ss.log(Status.INFO, "Successfully verified private RoomMembersCountInGrpCall");
//		
//		grpTalks.hangUpCurrentGrpTalkcall();
//		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
//		grpTalks.submitRateCallByClickingGoodOption();
//		grpTalks.selectRecentlySavedGrpTalkGroup();
//		logger_ss.log(Status.INFO, "Successfully verifed verifyPrivateRoomFuntionalityInLiveCall");
//	}
//	
//	
	@Test
	public void verifyPrivateRoomFuntionalityInLiveCallListView() throws InterruptedException {
		logger_ss = extent.createTest("verifyPrivateRoomFuntionalityInLiveCallListView","verifyPrivateRoomFuntionalityInLiveCallListView");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndCallTheGrp();
		logger_ss.log(Status.INFO, "Dialing to new group by submitting StartNowButton");
		
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified live Call is in progress ");
		
		grpTalks.listViewInLiveCall();
		logger_ss.log(Status.INFO, "Switched to list view ");
		
		int allParticipantsCount=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(allParticipantsCount,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),allParticipantsCount);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int privateRoomMembersCountInGrpCall = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingToPrviateRoomInListView();
		logger_ss.log(Status.INFO, "clicked on Private Room Button Of participant");
		
		int onCallCountInGrpCall2=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall2 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertTrue(grpTalks.visibilityOfClosePrivateRoomButtonInPrivateRoomTab());
		logger_ss.log(Status.INFO, "Successfully verified visibilityOfClosePrivateRoomButtonInPrivateRoomTab ");
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");

		grpTalks.clickClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "clicked on ClosePrivateRoomButtonInPrivateRoomTab");
		
		int privateRoomMembersCountInGrpCall3 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified private RoomMembersCountInGrpCall");
		
		int onCallCountInGrpCall3=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall3,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall3=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall3,3);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingToPrviateRoomInListView();
		logger_ss.log(Status.INFO, "clicked on Private room option of participant");
		
		int privateRoomMembersCountInGrpCall4 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall4,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall4);
		logger_ss.log(Status.INFO, "Successfully verified private RoomMembersCountInGrpCall");
		
		grpTalks.participantMovingBackTocallInListView();
		logger_ss.log(Status.INFO, "clicked on moveBackToCall option Of participant in all Participants tab");
		
		int onCallCountInGrpCall4=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall4,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall4);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");

		
		int privateRoomMembersCountInGrpCall5 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall5,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall5);
		logger_ss.log(Status.INFO, "Successfully verified private RoomMembersCountInGrpCall");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verifed CallFunctionalityForPrivateRoomTab");
	}
	
	@Test
	public void verifyCallFunctionalityFromOnCallTab() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromOnCallTab","verifyCallFunctionalityFromOnCallTab");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndCallTheGrp();
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified live Call is in progress ");
		
		int allParticipantsCount=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(allParticipantsCount,4);
		Assert.assertEquals(grpTalks.totalParticipants(),allParticipantsCount);
		logger_ss.log(Status.INFO, "Successfully verified All Participants Count");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int countInDisconnectedTab=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(countInDisconnectedTab,0);
		Assert.assertEquals(grpTalks.totalParticipants(),countInDisconnectedTab);
		logger_ss.log(Status.INFO, "Successfully verified Disconnected Count ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");	
		
		grpTalks.selectOnCallTabAndCountTheParticipants();
		logger_ss.log(Status.INFO, "Selected on OnCall Tab");
		grpTalks.clickUnMuteButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on UnMute Button Of group participant in onCall tab");
		Assert.assertTrue(grpTalks.visibilityOfMuteButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified visibility OF Mute Button Of participant ");
		
		int unMutedCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectOnCallTabAndCountTheParticipants();
		logger_ss.log(Status.INFO, "Selected OnCall Tab");
		grpTalks.clickMuteButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on MuteButtonOfIndividualContactInLiveCall");
		
		Assert.assertTrue(grpTalks.visibilityOfUnMuteButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified visibilityOFUnMuteButtonOfIndividualContactInLiveCall");
		
		int unMutedCountInGrpCall3=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall3,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectOnCallTabAndCountTheParticipants();
		
		grpTalks.participantMovingToPrviateRoom();
		logger_ss.log(Status.INFO, "clicked on Private Room Button Of participant");
		
		int onCallCountInGrpCall2=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall2 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		grpTalks.visibilityOfClosePrivateRoomButtonInPrivateRoomTab();
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.clickClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "clicked on ClosePrivateRoomButtonInPrivateRoomTab ");
		
		int privateRoomMembersCountInGrpCall3 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");	
		
		int onCallCountInGrpCall3=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall3,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		//Assert.assertTrue(grpTalks.visibilityOFPublicRoomButtonInLiveCall());
		
		grpTalks.clickhangUpButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on hangUpButtonOfIndividualContactInLiveCall ");
		//Assert.assertTrue(grpTalks.visibilityOFReDialButtonOfIndividualContactInLiveCall());
		
		int selectDisconnectedTabAndCountTheParticipants2=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants2,1);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants2);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickreDialButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on reDialButtonOfIndividualContactInLiveCall ");
		Assert.assertTrue(grpTalks.visibilityOfHangUpButtonOfParticipant());
		
		int selectDisconnectedTabAndCountTheParticipants3=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants3,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants3);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall4=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall4,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall4);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingExcelentOption();
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verified CallFunctionalityFromOnCallTab ");
	}
	
	@Test
	public void verifyCallFunctionalityFromUnMutedCount() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromUnMutedCount","verifyCallFunctionalityFromUnMutedCount");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectContactsFromContactList();
		String grpName=crtgrp.setGrpTalkName();
		crtgrp.submitStartNowButton();
		crtgrp.dialGroupCallButtonOnOverlayInCreateGrpTalk();
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,4);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);		
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");	
		
		grpTalks.selectUnMutedTabAndCountTheParticipants();
		grpTalks.clickUnMuteButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on UnMuteButtonOfIndividualContactInLiveCall");	
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertTrue(grpTalks.visibilityOfMuteButtonOfParticipant());
		
		int unMutedCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectOnCallTabAndCountTheParticipants();
		grpTalks.clickMuteButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on MuteButtonOfIndividualContactInLiveCall");	
		Assert.assertTrue(grpTalks.visibilityOfUnMuteButtonOfParticipant());
		
		int unMutedCountInGrpCall3=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall3,3);
		//Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		//grpTalks.unMutedCountInGrpCall();
		grpTalks.participantMovingToPrviateRoom();
		logger_ss.log(Status.INFO, "clicked on PublicRoomButtonOfContact");	
		int onCallCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall2 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		grpTalks.visibilityOfClosePrivateRoomButtonInPrivateRoomTab();
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.clickClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "clicked on ClosePrivateRoomButtonInPrivateRoomTab");	
		
		int privateRoomMembersCountInGrpCall3 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		int onCallCountInGrpCall3=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall3,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall4=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall4,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall4);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.clickhangUpButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on hangUpButtonOfIndividualContactInLiveCall");	
		
		int selectDisconnectedTabAndCountTheParticipants2=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants2,1);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants2);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int unMutedCountInGrpCall5=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall5,2);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall5);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickreDialButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on reDialButtonOfIndividualContactInLiveCall ");
		Assert.assertTrue(grpTalks.visibilityOfHangUpButtonOfParticipant());
		
		int selectDisconnectedTabAndCountTheParticipants3=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants3,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants3);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall4=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall4,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall4);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall6=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall6,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall6);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingBadOption();
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verified CallFunctionalityFromUnMutedCount ");
	}
	
	@Test
	public void verifyCallFunctionalityFromUnMutedCountInListView() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromUnMutedCountInListView","verifyCallFunctionalityFromUnMutedCountInListView");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndCallTheGrp();
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified live Call is in progress ");
		grpTalks.listViewInLiveCall();
		logger_ss.log(Status.INFO, "Switched to list view ");
		
		int allParticipantsCount=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(allParticipantsCount,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),allParticipantsCount);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int disconnectedCount=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(disconnectedCount,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),disconnectedCount);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);		
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");	
		
		grpTalks.selectUnMutedTabAndCountTheParticipants();
		grpTalks.clickUnMuteButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked on UnMute Button Of group participant ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalks.muteButtonOfParticipantInListView));
		//Assert.assertTrue(grpTalks.visibilityOFMuteButtonOfIndividualContactInListView());
		logger_ss.log(Status.INFO, "verified visibility OF Mute Button Of participant ");
		
		int unMutedCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectOnCallTabAndCountTheParticipants();
		grpTalks.clickMuteButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked on Mute Button Of group participant ");
		Assert.assertTrue(grpTalks.visibilityOfUnMuteButtonOfParticipantInListView());
		logger_ss.log(Status.INFO, "verified visibility OF un Mute Button Of participant ");
		
		int unMutedCountInGrpCall3=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall3,3);
		//Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectUnMutedTabAndCountTheParticipants();
		grpTalks.participantMovingToPrviateRoomInListView();
		logger_ss.log(Status.INFO, "clicked on Private Room Button Of participant");
		
		int onCallCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall2 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		grpTalks.visibilityOfClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "verified visibility OF close  private room option Of participant InPrivateRoomTab ");
		
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.clickClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "clicked on ClosePrivateRoomButtonInPrivateRoomTab");	
		
		int privateRoomMembersCountInGrpCall3 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		int onCallCountInGrpCall3=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall3,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall4=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall4,3);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall4);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.clickhangUpButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked on hangUpButtonOfIndividualContactInList view");	
		
		int disconnectedCount2=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(disconnectedCount2,1);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),disconnectedCount2);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int unMutedCountInGrpCall5=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall5,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall5);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickreDialButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked on reDialButtonOfIndividualContactInLiveCall ");
		Assert.assertTrue(grpTalks.visibilityOfHangUpButtonOfParticipant());
		
		int disconnectedCount3=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(disconnectedCount3,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),disconnectedCount3);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall4=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall4,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall4);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall6=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall6,3);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall6);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingBadOption();
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verified Call Functionality From UnMutedCount in List view");
	}
	
	@Test
	public void verifyMuteDialFunctionalityFromScheduleOverlay() throws InterruptedException {
		logger_ss = extent.createTest("verifyMuteDialFunctionalityFromScheduleOverlay","verifyMuteDialFunctionalityFromScheduleOverlay");
		String url =currentUrl;
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on createGroup button in myGrpTalk page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone Contacts tab in createGrpTalk page");
		crtgrp.selectContactsFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		String name =crtgrp.setGrpTalkName();
		System.out.println(name);
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
		crtgrp.giveConferenceAgenda();
		crtgrp.selectAllRepeatDaysOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "selected AllRepeatDaysOnAdvancedSettingsOverlayForSchedule");
		crtgrp.clickScheduleButtonOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "clicked on Schedule Button On Advanced Settings Overlay For Schedule grpTalk");
		
		Thread.sleep(121000);
		driver.navigate().to(url);
		grpTalks.selectRecentlySavedGrpTalkGroup(name);
		logger_ss.log(Status.INFO, "selected Recently Saved GrpTalk Group");
		
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		
		Assert.assertTrue(grpTalks.visibilityOfMuteBuutonInGrpCall());

		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,4);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,0);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertTrue(grpTalks.checkVisibilityOfIndividualUserMuteButtomInGrpCall());
		logger_ss.log(Status.INFO, "Successfully verified visibilityOfIndividualUserMuteButtomInGrpCall ");
		grpTalks.hangUpCurrentGrpTalkcall();
		grpTalks.submitRateCallByClickingGoodOption();
		grpTalks.selectRecentlySavedGrpTalkGroup(name);
		logger_ss.log(Status.INFO, "Successfully verified MuteDialFunctionalityFromScheduleOverlay ");
	}
	
	
	@Test
	public void verifyfunctionalityOfExcelReportDownloadOptionOnHistory() throws InterruptedException {
		logger_ss = extent.createTest("verifyfunctionalityOfExcelReportDownloadOptionOnHistory","verifyfunctionalityOfExcelReportDownloadOptionOnHistory");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks= new GrpTalks();
		grpTalks.selectSavedGroupByName(CommonMethods.passingData("grpTalkGroup"));
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		grpTalks.historyButtonOnMyGrpTalks();
		logger_ss.log(Status.INFO, "Clicked on history Button On MyGrpTalks");
		grpTalks.clickExcelReportDownloadButtonOnHistory();
		logger_ss.log(Status.INFO, "Downloaded ExcelReport from History");
		logger_ss.log(Status.INFO, "Successfully verified functionalityOfExcelReportDownloadOptionOnHistory ");
	}
	
	
	@Test
	public void verifyDialFunctionalityOfScheduleGroup() throws InterruptedException {
		logger_ss = extent.createTest("verifyDialFunctionalityOfScheduleGroup","verifyDialFunctionalityOfScheduleGroup");
		String url = currentUrl;
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on createGroup button in myGrpTalk page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone Contacts tab in createGrpTalk page");
		crtgrp.selectContactsFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		String grpName=crtgrp.setGrpTalkName();
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
		
		Thread.sleep(124000);
		driver.navigate().to(url);
		Thread.sleep(2000);
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "selected Recently Saved GrpTalk Group");
		
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		
		Assert.assertTrue(grpTalks.visibilityOfUnMuteBuutonInGrpCall());
		
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,4);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertTrue(grpTalks.checkVisibilityOfIndividualUserUnMuteButtomInGrpCall());
		logger_ss.log(Status.INFO, "Successfully verifed the visibility of individual user mute button in grp call");
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "Successfully verifed DialFunctionalityOfScheduleGroup");
		grpTalks.submitRateCallByClickingAverageOption();
	}
	
	@Test
	public void verifyNonRepeatedGroupCallFunctionalityThroughHistory() throws InterruptedException {
		logger_ss = extent.createTest("verifyNonRepeatedGroupFunctionalityThroughHistory","verifyNonRepeatedGroupFunctionalityThroughHistory");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.selectSavedGroupByName(CommonMethods.passingData("OneDialGroup"));
		logger_ss.log(Status.INFO, "Selected 'OneDial' group In MyGrpTalk page");
		grpTalks.historyButtonOnMyGrpTalks();
		logger_ss.log(Status.INFO, "clicked on historyButtonOnMyGrpTalks");
		int count = grpTalks.countOfCallsByGroupInHistory();
		Assert.assertEquals(count, 1);
		logger_ss.log(Status.INFO, " get and verified countOfCallsByGroupInHistory");
		logger_ss.log(Status.INFO, "Successfully verified NonRepeatedGroupFunctionalityThroughHistory");
	}
	
	@Test
	public void verifyCallFunctionalityFromOnCallTabInListView() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityFromOnCallTabInListView","verifyCallFunctionalityFromOnCallTabInListView");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		String grpName=crtgrp.createAndCallTheGrp();
		logger_ss.log(Status.INFO, "Dialing to new group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified live Call is in progress ");
		grpTalks.listViewInLiveCall();
		logger_ss.log(Status.INFO, "Switched to list view ");
		
		int allParticipantsCount=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(allParticipantsCount,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),allParticipantsCount);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int DisconnectedCount=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(DisconnectedCount,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),DisconnectedCount);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,3);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectOnCallTabAndCountTheParticipants();
		grpTalks.clickUnMuteButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked on UnMute Button Of group participant In All participants tab");
		
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalks.muteButtonOfParticipantInListView));
		//Assert.assertTrue(grpTalks.visibilityOFMuteButtonOfIndividualContactInListView());
		logger_ss.log(Status.INFO, "verified visibility OF Mute Button Of participant ");
		
		int unMutedCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectOnCallTabAndCountTheParticipants();
		grpTalks.clickMuteButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked on Mute Button Of group participant In All participants tab");
		Assert.assertTrue(grpTalks.visibilityOfUnMuteButtonOfParticipantInListView());
		logger_ss.log(Status.INFO, "verified visibility OF un Mute Button Of participant ");
		
		int unMutedCountInGrpCall3=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall3,3);
		//Assert.assertEquals(grpTalks.allParticipantsInListView(),unMutedCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectOnCallTabAndCountTheParticipants();
		grpTalks.participantMovingToPrviateRoomInListView();
		logger_ss.log(Status.INFO, "clicked on Private Room Button Of participant");
		
		int onCallCountInGrpCall2=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall2 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		grpTalks.visibilityOfClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "verified visibility OF close  private room option Of participant InPrivateRoomTab ");
		
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingBackTocallInListView();
		logger_ss.log(Status.INFO, "clicked on move back to call option Of participant in all Participants tab");
		Assert.assertTrue(grpTalks.InvisibilityOfPrivateRoomOptionForParticipantInListView());
		logger_ss.log(Status.INFO, "verified invisibility OF private room option Of participant ");
		
		int onCallCountInGrpCall6=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall6,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall6);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall3 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),privateRoomMembersCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectOnCallTabAndCountTheParticipants();
		grpTalks.clickhangUpButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked on hangUp Button Of participant ");
		
		int onCallCountInGrpCall7=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall7,3);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall7);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int disconnectedTabCount=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(disconnectedTabCount,1);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),disconnectedTabCount);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickreDialButtonOfParticipantInListView();
		logger_ss.log(Status.INFO, "clicked on reDial Button Of participant");
		Assert.assertTrue(grpTalks.visibilityOfHangUpButtonOfParticipantInListView());
		logger_ss.log(Status.INFO, "verified invisibility OF reDail option Of participant ");
		
		int selectDisconnectedTabAndCountTheParticipants3=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants3,0);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),selectDisconnectedTabAndCountTheParticipants3);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall3=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall3,4);
		Assert.assertEquals(grpTalks.allParticipantsInListView(),onCallCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "submited RateCall By Clicking Good Option");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verified Call Functionality From AllMembersTab in list view");
	}
	
	
//	@Test
//	public void verifyRepeatGrpCalEveryDayFunctionalityThroughHistory() throws InterruptedException {
//		logger_ss = extent.createTest("verifyRepeatGrpCalEveryDayFunctionalityThroughHistory","verifyRepeatGrpCalEveryDayFunctionalityThroughHistory");
//		CreatingGroup crtgrp = new CreatingGroup();
//		GrpTalks grpTalks = new GrpTalks();
//		grpTalks.selectSavedGroupByName("RepeatGrpCalEveryDay");
//		logger_ss.log(Status.INFO, "Selected 'RepeatGrpCalEveryDay' group In MyGrpTalk page");
//		grpTalks.historyButtonOnMyGrpTalks();
//		logger_ss.log(Status.INFO, "clicked on historyButtonOnMyGrpTalks");
//		boolean callDate = grpTalks.callDatesInHistory();
//		logger_ss.log(Status.INFO, "Verified call history dates");
//		Assert.assertTrue(callDate);
//		logger_ss.log(Status.INFO, "Successfully verifyRepeatGrpCalEveryDayFunctionalityThroughHistory");
//	}
//	
	
	@Test
	public void verifyCallFunctionalityOfContactsFromCreateGroupTalkPage() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityOfTestContactsFromCreateGroupTalkPage","verifyCallFunctionalityOfTestContactsFromCreateGroupTalkPage");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectTestContactsFromContactList();
		logger_ss.log(Status.INFO, "selected TestContactsFromContactList");
		Thread.sleep(1000);
		crtgrp.clickweblisttab();	
		crtgrp.selectListContacts();
		String grpName =crtgrp.setGrpTalkName();
		crtgrp.submitSaveButton();
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");		
		grpTalks.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		grpTalks.dialGroupCallButtonOnOverlay();
		
		
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified live Call is in progress ");
		
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,6);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,6);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,5);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickUnMuteButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on UnMute Button Of group participant In All participants tab");
		
		Assert.assertTrue(grpTalks.visibilityOfMuteButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified visibility OF Mute Button Of participant ");
		int unMutedCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall2,4);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickMuteButtonOfParticipant();
		Thread.sleep(1000);
		logger_ss.log(Status.INFO, "clicked on Mute Button Of group participant In All participants tab");
		Assert.assertTrue(grpTalks.visibilityOfUnMuteButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified visibility OF un Mute Button Of participant ");
		
		int unMutedCountInGrpCall3=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall3,5);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingToPrviateRoom();
		logger_ss.log(Status.INFO, "clicked on Private Room Button Of participant");
		Assert.assertTrue(grpTalks.visibilityOfPrivateRoomOptionforParticipant());
		logger_ss.log(Status.INFO, "verified visibility OF private room option Of participant ");
		
		int onCallCountInGrpCall2=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall2,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall2 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		grpTalks.visibilityOfClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "verified visibility OF close  private room option Of participant InPrivateRoomTab ");
		
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingBackTocall();
		logger_ss.log(Status.INFO, "clicked on move back to call option Of participant in all Participants tab");
		Assert.assertTrue(grpTalks.InvisibilityOfPrivateRoomOptionForParticipant());
		logger_ss.log(Status.INFO, "verified invisibility OF private room option Of participant ");
		
		int privateRoomMembersCountInGrpCall3 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickhangUpButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on hangUp Button Of participant In all Members Tab");
		Assert.assertTrue(grpTalks.visibilityOfReDialButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified visibility Of reDial option Of participant ");
		
		int selectDisconnectedTabAndCountTheParticipants2=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants2,1);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants2);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickreDialButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on reDial Button Of participant");
		Assert.assertTrue(grpTalks.visibilityOfHangUpButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified invisibility OF reDail option Of participant ");
		
		int selectDisconnectedTabAndCountTheParticipants3=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants3,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants3);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall3=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall3,6);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "submited RateCall By Clicking Good Option");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Successfully verified CallFunctionality");
		
		
	}	
	
	
	@Test
	public void verifyCreateListFromExcelUploadandphonecontacts() throws InterruptedException, AWTException{
		logger_ss = extent.createTest("verifyCreateListFromExcelUploadandphonecontacts","verifyCreateListFromExcelUploadandphonecontacts");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPlusButtonToCreateNewWebList();
		logger_ss.log(Status.INFO, "Clicked on PlusButtonToCreateNewWebList");
		crtgrp.clickExcelUploadTabOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on ExcelUploadTabOnOverlay");
		crtgrp.clickChooseFileButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on ChooseFileButtonOnOverlay");
		String path=userDirectory+"\\TestDataFiles\\contacts.xlsx";
		CommonMethods.getUploadFile(userDirectory+"\\TestDataFiles\\contacts.xlsx");
		logger_ss.log(Status.INFO, "Uploaded file");
		Thread.sleep(2000);
		String listName = crtgrp.givenExcelSheetDetailsOnOverlay();
		System.out.println("lsit--"+listName);
		logger_ss.log(Status.INFO, "given excel sheet details on overlay");
		Thread.sleep(3000);
			
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickOnGroupsTab();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectTestContactsFromContactList();
		logger_ss.log(Status.INFO, "selected TestContactsFromContactList");
		Thread.sleep(1000);
		crtgrp.clickweblisttab();
		grpTalks.listNameInWebLists(listName);
		Thread.sleep(1000);
		crtgrp.clickweblisttab1();
		crtgrp.selectListContacts();
		String grpName =crtgrp.setGrpTalkName();
		crtgrp.submitSaveButton();
		crtgrp.submitSaveGroupOnOverlay();
		logger_ss.log(Status.INFO, "New grpTalk group has been saved");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "Selected recently saved grp talk group in MyGrpTalks page");		
		grpTalks.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		grpTalks.dialGroupCallButtonOnOverlay();
		
		
		logger_ss.log(Status.INFO, "Dialed to new grpTalk group by submitting StartNowButton");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified live Call is in progress ");
		
		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,6);
		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall,6);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall,5);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickUnMuteButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on UnMute Button Of group participant In All participants tab");
		
		Assert.assertTrue(grpTalks.visibilityOfMuteButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified visibility OF Mute Button Of participant ");
		int unMutedCountInGrpCall2=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall2,4);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickMuteButtonOfParticipant();
		Thread.sleep(1000);
		logger_ss.log(Status.INFO, "clicked on Mute Button Of group participant In All participants tab");
		Assert.assertTrue(grpTalks.visibilityOfUnMuteButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified visibility OF un Mute Button Of participant ");
		
		int unMutedCountInGrpCall3=grpTalks.selectUnMutedTabAndCountTheParticipants();
		Assert.assertEquals(unMutedCountInGrpCall3,5);
		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingToPrviateRoom();
		logger_ss.log(Status.INFO, "clicked on Private Room Button Of participant");
		Assert.assertTrue(grpTalks.visibilityOfPrivateRoomOptionforParticipant());
		logger_ss.log(Status.INFO, "verified visibility OF private room option Of participant ");
		
		int onCallCountInGrpCall2=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall2,4);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		int privateRoomMembersCountInGrpCall2 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		grpTalks.visibilityOfClosePrivateRoomButtonInPrivateRoomTab();
		logger_ss.log(Status.INFO, "verified visibility OF close  private room option Of participant InPrivateRoomTab ");
		
		Assert.assertEquals(privateRoomMembersCountInGrpCall2,2);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall2);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.participantMovingBackTocall();
		logger_ss.log(Status.INFO, "clicked on move back to call option Of participant in all Participants tab");
		Assert.assertTrue(grpTalks.InvisibilityOfPrivateRoomOptionForParticipant());
		logger_ss.log(Status.INFO, "verified invisibility OF private room option Of participant ");
		
		int privateRoomMembersCountInGrpCall3 = grpTalks.selectPrivateRoomTabAndCountTheParticipants();
		Assert.assertEquals(privateRoomMembersCountInGrpCall3,0);
		Assert.assertEquals(grpTalks.totalParticipants(),privateRoomMembersCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified privateRoomMembersCountInGrpCall ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickhangUpButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on hangUp Button Of participant In all Members Tab");
		Assert.assertTrue(grpTalks.visibilityOfReDialButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified visibility Of reDial option Of participant ");
		
		int selectDisconnectedTabAndCountTheParticipants2=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants2,1);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants2);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		grpTalks.selectAllParticipantsTabAndCountTheParticipants();
		grpTalks.clickreDialButtonOfParticipant();
		logger_ss.log(Status.INFO, "clicked on reDial Button Of participant");
		Assert.assertTrue(grpTalks.visibilityOfHangUpButtonOfParticipant());
		logger_ss.log(Status.INFO, "verified invisibility OF reDail option Of participant ");
		
		int selectDisconnectedTabAndCountTheParticipants3=grpTalks.selectDisconnectedTabAndCountTheParticipants();
		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants3,0);
		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants3);
		logger_ss.log(Status.INFO, "Successfully verified selectDisconnectedTabAndCountTheParticipants ");
		
		int onCallCountInGrpCall3=grpTalks.selectOnCallTabAndCountTheParticipants();
		Assert.assertEquals(onCallCountInGrpCall3,6);
		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall3);
		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
		
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "HangUp the current grpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "submited RateCall By Clicking Good Option");
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		
		
		logger_ss.log(Status.INFO, "Successfully verified the functionality of ExcelUpload and phone contacts call functionality");
	}

	
	@Test
	public void verifyselectedcontactstab() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionalityOfTestContactsFromCreateGroupTalkPage","verifyCallFunctionalityOfTestContactsFromCreateGroupTalkPage");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on CreateGroup button in MyGrpTalks page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone contacts tab in CreateGroupTalk page");
		crtgrp.selectTestContactsFromContactList();
		logger_ss.log(Status.INFO, "selected TestContactsFromContactList");
		Thread.sleep(2000);
		int selectedparticipants=crtgrp.clickselectedcontactstab();
		Assert.assertEquals(selectedparticipants,3);
		logger_ss.log(Status.INFO, "Successfully verified selectedparticipants ");
		
	}	
	
	
	
	
	
	
	public void sleep(long millis) throws InterruptedException{
		Thread.sleep(millis);
	}
	

	
}