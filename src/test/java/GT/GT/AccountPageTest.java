package GT.GT;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.*;

public class AccountPageTest extends BrowserFunctions{
	
	@BeforeClass
	public void beforeCalss(){
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("GrpTalk_Report_Of_AccountsPage.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger_ss = extent.createTest("AccountsPageTest");
		logger_ss.log(Status.INFO, "AccountsPageTest");
	}
	
	@Test
	public void verifyEditUserProfile() throws InterruptedException, AWTException{
		logger_ss = extent.createTest("verifyEditUserProfile","verify Edit User Profile");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		accountpage.ChangeProfileButton();
		logger_ss.log(Status.INFO, "Clicked on Change Profile Button");
		String profileName = accountpage.editUserProfile();
		logger_ss.log(Status.INFO, "Edit and updated the user prfoile");
		logger_ss.log(Status.INFO, "Expected username is:Srikanth ");
		logger_ss.log(Status.INFO, "Actual username is: ");
		logger_ss.log(Status.INFO, profileName);
		Assert.assertEquals(profileName, "Srikanth");
		logger_ss.log(Status.INFO, "Successfully verified the updated user profile");
	}
	
	@Test
	public void verifyRechargeWithPaytm() throws InterruptedException, AWTException{
		logger_ss = extent.createTest("verifyRechargeWithPaytm","verifyRechargeWithPaytm");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		accountpage.clickRechargeNowWithPaytmButton();
		logger_ss.log(Status.INFO, "Clicked on RechargeNowWithPaytmButton");
		accountpage.enterDetailsOnRechargeOverlayAndProceed();
		Assert.assertEquals(accountpage.successMsgForPaytmRecharge(),CommonMethods.passingData("successMsgForPaytmRecharge"));
	}
	
	@Test
	public void verifyAllAndRechargesTabsOnMyAccountPage() throws InterruptedException{
		logger_ss = extent.createTest("verifyAllAndRechargesTabsOnMyAccountPage","verify All And Recharges Tabs On MyAccount Page");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		Assert.assertTrue(accountpage.clickRechargesTabOnMyAccountPage());
		logger_ss.log(Status.INFO, "Successfully Clicked on Recharges Tab On MyAccount Page");
		Assert.assertTrue(accountpage.clickAllTabOnMyAccountPage());
		logger_ss.log(Status.INFO, "Successfully Clicked on All Tab On MyAccount Page");
		logger_ss.log(Status.INFO, "Successfully Clicked verified All And Recharges Tabs On MyAccount Page");
	}
	
	@Test(priority=0)
	public void verifyConfigureClipsFunctionalityOnProfilePage() throws InterruptedException, AWTException{
		logger_ss = extent.createTest("verifyConfigureClipsFunctionalityOnProfilePage","verifyConfigureClipsFunctionalityOnProfilePage");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		accountpage.clickConfigureClipsButton();
		logger_ss.log(Status.INFO, "Clicked on ConfigureClipsButton");
		accountpage.clickChooseFileForNormalclip();
		logger_ss.log(Status.INFO, "Clicked on Choose File option For Normalclip");
		//String path="D:\\grpTalk\\TestDataFiles\\ConfigureClip.mp3";
		CommonMethods.getUploadFile(userDirectory+"\\TestDataFiles\\ConfigureClip.mp3");
		logger_ss.log(Status.INFO, "Uploaded Normalclip");
		accountpage.saveNormalClip();
		logger_ss.log(Status.INFO, "Saved Normalclip");
		Assert.assertEquals(accountpage.successMsgForUploadedNormalAudioClip(), "Normal Audio Clip uploaded Successfully");
		logger_ss.log(Status.INFO, "Success Msg is displayed For UploadedNormalAudioClip");
		accountpage.clickChooseFileForMuteClip();
		logger_ss.log(Status.INFO, "Clicked on Choose File option For mute clip");
		CommonMethods.getUploadFile(userDirectory+"\\TestDataFiles\\ConfigureClip.mp3");
		logger_ss.log(Status.INFO, "Uploaded mute clip");
		accountpage.saveMuteClip();
		logger_ss.log(Status.INFO, "Saved mute clip");
		Assert.assertEquals(accountpage.successMsgForUploadedMuteAudioClip(), "Mute Audio Clip uploaded Successfully");
		logger_ss.log(Status.INFO, "Success Msg is displayed For Uploaded mute AudioClip");
		accountpage.clickCloseButtonOnConfigureClipsOverlay();
		logger_ss.log(Status.INFO, "clicked on Close Button On Configure Clips Overlay");
		accountpage.clickConfigureClipsButton();
		logger_ss.log(Status.INFO, "Clicked on ConfigureClipsButton");
		Assert.assertTrue(accountpage.visibliltyOfDownloadOptionForNormalClip());
		logger_ss.log(Status.INFO, "verified visibliltyOfDownloadOptionForNormalClip");
		Assert.assertTrue(accountpage.visibliltyOfDownloadOptionForMuteClip());
		logger_ss.log(Status.INFO, "verified visibliltyOfDownloadOptionForMuteClip");
		Assert.assertTrue(accountpage.visibliltyOfdeleteButtonForMuteClip());
		logger_ss.log(Status.INFO, "verified visibliltyOfdeleteButtonForMuteClip");
		Assert.assertTrue(accountpage.visibliltyOfdeleteButtonForNormalClip());
		logger_ss.log(Status.INFO, "verified visibliltyOfdeleteButtonForNormalClip");
		accountpage.clickDeleteButtonForNormalClip();
		logger_ss.log(Status.INFO, "clicked DeleteButtonForNormalClip");
		Assert.assertEquals(accountpage.msgOnConfigureClipsOverlay(), "Normal Clip Deleted Successfully");
		logger_ss.log(Status.INFO, "Normal Clip Deleted Successfully");
		accountpage.clickDeleteButtonForMuteClip();
		logger_ss.log(Status.INFO, "clicked clickDeleteButtonForMuteClip");
		Assert.assertEquals(accountpage.msgOnConfigureClipsOverlay(), "Mute Clip Deleted Successfully");
		logger_ss.log(Status.INFO, "Mute Clip Deleted Successfully");
		accountpage.clickCloseButtonOnConfigureClipsOverlay();
		logger_ss.log(Status.INFO, "Successfully verified ConfigureClipsFunctionalityOnProfilePage");
	}
	
	@Test(priority=0)
	public void verifyTotalAmountUsedByUser() throws Exception{
		logger_ss = extent.createTest("verifyTotalAmountUsedByUser","verify Total Amount Used By User");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		String usedAmount= accountpage.usedAmontInWeb();
		System.out.println("usedAmount"+usedAmount);
		logger_ss.log(Status.INFO, "Getting the used amount in web");
		double usedAmountBeforeCall= Double.parseDouble(usedAmount);
		System.out.println("usedAmountBeforeCall"+usedAmountBeforeCall);
		accountpage.navigateToGrpTalkHomePage();
		logger_ss.log(Status.INFO, "navigated To GrpTalk Home Page");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalk = new GrpTalks();
		grpTalk.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		grpTalk.dialGroupCallButton();
		logger_ss.log(Status.INFO, "Clicked on dial button");
		grpTalk.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on dial grpCall button on overlay");
		grpTalk.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
		grpTalk.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "hangUp the Current GrpTalk call");
		grpTalk.submitRateCallByClickingGoodOption();
		accountpage.navigateToGrpTalkHomePage();
		logger_ss.log(Status.INFO, "navigated To GrpTalk Home Page");
		grpTalk.selectSavedGroupByName("grpTalk");
		logger_ss.log(Status.INFO, "Selected 'grpTalk' group In MyGrpTalk page");
		grpTalk.historyButtonOnMyGrpTalks();
		logger_ss.log(Status.INFO, "Clicked on history Button On MyGrpTalks");
		double amountChargedForCall =grpTalk.totalAmountChargedForGrpcall();
		System.out.println("amountChargedForCall"+amountChargedForCall);
		logger_ss.log(Status.INFO, "Getting the total amount charged for grpCall");
		double totalAmount = usedAmountBeforeCall+amountChargedForCall;
		System.out.println("totalAmount"+totalAmount);
		logger_ss.log(Status.INFO, "Added usedAmountBeforeCall with amountChargedForCall:");
		logger_ss.log(Status.INFO, String.valueOf(totalAmount));
		accountpage.navigateToGrpTalkHomePage();
		logger_ss.log(Status.INFO, "navigated To GrpTalk Home Page");
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		String usedAmountAfterCall= accountpage.usedAmontInWeb();
		System.out.println("usedAmountAfterCall"+usedAmountAfterCall);
		logger_ss.log(Status.INFO, "Getting used amount in Web After call");
		double totalUsedAmountAfterCall =  Double.parseDouble(usedAmountAfterCall);
		System.out.println("totalUsedAmountAfterCall"+totalUsedAmountAfterCall);
		logger_ss.log(Status.INFO, String.valueOf(totalUsedAmountAfterCall));
		Assert.assertEquals(totalAmount, totalUsedAmountAfterCall);
		logger_ss.log(Status.INFO, "Successfully verified the total amount used for before and after calls by the user");
	}
	
//	@Test
//	public void verifyAvailableLinesInSubAccountsTab() throws InterruptedException{
//		logger_ss = extent.createTest("verifyAvailableLinesInSubAccountsTab","verifyAvailableLinesInSubAccountsTab");
//		AccountPage accountpage = new AccountPage(driver);
//		accountpage.clickOnAccountTab();
//		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
//		int totalLines =accountpage.totalAvailableLines();
//		logger_ss.log(Status.INFO, "Taken totalAvailableLines");
//		accountpage.clickSubAccountsTab();
//		logger_ss.log(Status.INFO, "Clicked on sub account tab");
//		//Assert.assertTrue(accountpage.availableLinesText());
//		int subAccounts = accountpage.subAccountsCount();
//		int allLines = accountpage.getAvailableLines()+subAccounts;
//		logger_ss.log(Status.INFO, "Taken subAccountsCount and getAvailableLines");
//		Assert.assertEquals(allLines, totalLines);
//		logger_ss.log(Status.INFO, "Successfully verified available lines in sub accounts tab");
//	}
	
	@Test
	public void verifyAllTabsAreDisplayedOnMyAccountPage() throws InterruptedException{
		logger_ss = extent.createTest("verifyAllTabsAreDisplayedOnMyAccountPage","verifyAllTabsAreDisplayedOnMyAccountPage");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		Assert.assertTrue(accountpage.visibilityOfProfileTabOnMyAccountPage());
		logger_ss.log(Status.INFO, "verified visibilityOfProfileTabOnMyAccountPage");
		Assert.assertTrue(accountpage.visibilityOfSubAccountsTabOnMyAccountPage());
		logger_ss.log(Status.INFO, "verified visibilityOfSubAccountsTabOnMyAccountPage");
		Assert.assertTrue(accountpage.visibilityOfManagersTabOnMyAccountPage());
		logger_ss.log(Status.INFO, "verified visibilityOfManagersTabOnMyAccountPage");
		logger_ss.log(Status.INFO, "Successfully verified AllTabsAreDisplayedOnMyAccountPage");
	}
	
	@Test
	public void verifyTheCountOfAccountManagersInAccountManagersTab() throws InterruptedException{
		logger_ss = extent.createTest("verifyTheCountOfAccountManagersInAccountManagersTab","verifyTheCountOfAccountManagersInAccountManagersTab");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		accountpage.clickAccountManagersTab();
		logger_ss.log(Status.INFO, "Clicked on account managers tab");
		int numberOfAccountManagers = accountpage.totalNumberOfAccountManagers();
		if(numberOfAccountManagers!=0){
			System.out.println("Number Of Account managers are:: "+numberOfAccountManagers);
			logger_ss.log(Status.INFO, "Successfully verified Number Of Account managers");
		}
		else{
			Assert.assertEquals(accountpage.unAvailabilityMsgOfAccountManagers(), "No Account Managers.");
			logger_ss.log(Status.INFO, "Successfully verified 'No Account Managers.' text msg");
		}
		logger_ss.log(Status.INFO, "Successfully verified TheCountOfAccountManagersInAccountManagersTab");
	}
	
	@Test
	public void verifyAddAccountManagerFunctionalityByGivingNonRegisteredNumberInAccountManagersTab() throws InterruptedException{
		logger_ss = extent.createTest("verifyAddAccountManagerFunctionalityByGivingNonRegisteredNumberInAccountManagersTab","verifyAddAccountManagerFunctionalityByGivingNonRegisteredNumberInAccountManagersTab");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		accountpage.clickAccountManagersTab();
		logger_ss.log(Status.INFO, "Clicked on account managers tab");
		accountpage.clickAddAccountManagerTab();
		logger_ss.log(Status.INFO, "Clicked on AddAccountManagerTab");
		accountpage.enterNickNameOnOverlay("srikanth");
		logger_ss.log(Status.INFO, "enterNickNameOnOverlay");
		accountpage.enterMobileNumberOnOverlay("2342342345");
		logger_ss.log(Status.INFO, "enterMobileNumberOnOverlay");
		Assert.assertEquals(accountpage.errorMsgForNonRegisteredMobileNumber(), "This number is not registered with grptalk. Send invitation to download grpTalk");
		logger_ss.log(Status.INFO, "Successfully verified errorMsgForNonRegisteredMobileNumber");
		Assert.assertTrue(accountpage.visibilityOfSendInvitationButtonOnAddAccountManagerOverlay());
		logger_ss.log(Status.INFO, "Successfully verified visibilityOfSendInvitationButtonOnAddAccountManagerOverlay");
		logger_ss.log(Status.INFO, "Successfully verified AddAccountManagerFunctionalityByGivingNonRegisteredNumberInAccountManagersTab");
	}
	
	@Test(priority=0)
	public void verifyaaAccountManagerFunctionalityInAccountManagersTab() throws InterruptedException{
		logger_ss = extent.createTest("verifyAccountManagerFunctionalityInAccountManagersTab","verifyAccountManagerFunctionalityInAccountManagersTab");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		accountpage.clickAccountManagersTab();
		logger_ss.log(Status.INFO, "Clicked on account managers tab");
		accountpage.clickAddAccountManagerTab();
		logger_ss.log(Status.INFO, "Clicked on AddAccountManagerTab");
		accountpage.enterNickNameOnOverlay("smsc");
		logger_ss.log(Status.INFO, "enterNickNameOnOverlay");
		accountpage.enterMobileNumberOnOverlay("8919590168");
		logger_ss.log(Status.INFO, "enterMobileNumberOnOverlay");
		Assert.assertEquals(accountpage.successMsgWithNameForValidRegistredMobileNumber(), "Registered with Uma");
		logger_ss.log(Status.INFO, "verified successMsgWithNameForValidRegistredMobileNumber");
		Assert.assertTrue(accountpage.visibilityOfAddButtonOnAddAccountManagerOverlay());
		logger_ss.log(Status.INFO, "verified visibilityOfAddButtonOnAddAccountManagerOverlay");
		accountpage.clickAddButtonOnAddAccountManagerOverlay();
		logger_ss.log(Status.INFO, "clicked on AddButtonOnAddAccountManagerOverlay");
		Assert.assertEquals(accountpage.successMsgForCreationOfAccountManager(), "Account Manager Created Successfully");
		logger_ss.log(Status.INFO, "Successfully created Account manager");
		Assert.assertEquals(accountpage.accountManagerNameAndNumber(), "Uma 918919590168");
		logger_ss.log(Status.INFO, "verified accountManagerNameAndNumber");
		Assert.assertTrue(accountpage.activeStateOfAccountManager());
		logger_ss.log(Status.INFO, "Successfully verified Active state of account manager");
		accountpage.clickEditDetailsButtonOfAccountManager();
		logger_ss.log(Status.INFO, "clicked on EditDetailsButtonOfAccountManager");
		Assert.assertEquals(accountpage.accountManagerNameOnEditAccountManagerOverlay(), "Edit Call Manager for Uma");
		logger_ss.log(Status.INFO, "Successfully verified accountManagerNameOnEditAccountManagerOverlay");
		accountpage.changeAccountStatus();
		logger_ss.log(Status.INFO, "changed AccountStatus to block");
		accountpage.clickSaveButtonOnEditAccountManagerOverlay();
		logger_ss.log(Status.INFO, "clicked SaveButtonOnEditAccountManagerOverlay");
		Assert.assertEquals(accountpage.successMsgOfBlockedAccountManager(), "Call Manager Blocked Successfully");
		logger_ss.log(Status.INFO, "verified successMsgOfBlockedAccountManager");
		Assert.assertTrue(accountpage.blockedStateOfAccountManager());
		logger_ss.log(Status.INFO, "Successfully blocked AccountManager");
		
		accountpage.clickEditDetailsButtonOfAccountManager();
		logger_ss.log(Status.INFO, "clicked on EditDetailsButtonOfAccountManager");
		accountpage.changeAccountStatusToActive();
		logger_ss.log(Status.INFO, "changed AccountStatusToActive");
		accountpage.clickSaveButtonOnEditAccountManagerOverlay();
		logger_ss.log(Status.INFO, "clicked SaveButtonOnEditAccountManagerOverlay");
		Assert.assertEquals(accountpage.successMsgOfActivatedAccountManager(), "Call Manager Activated successfully");
		logger_ss.log(Status.INFO, "verified successMsgOfActivatedAccountManager");
		Assert.assertTrue(accountpage.activeStateOfAccountManager());
		logger_ss.log(Status.INFO, "Successfully Activated AccountManager");
		
		accountpage.clickEditDetailsButtonOfAccountManager();
		logger_ss.log(Status.INFO, "clicked on EditDetailsButtonOfAccountManager");
		Assert.assertEquals(accountpage.accountManagerNameOnEditAccountManagerOverlay(), "Edit Account Manager for Uma");
		logger_ss.log(Status.INFO, "Successfully verified accountManagerNameOnEditAccountManagerOverlay");
		accountpage.changeAccountStatus();
		logger_ss.log(Status.INFO, "changed AccountStatus to block");
		accountpage.clickSaveButtonOnEditAccountManagerOverlay();
		logger_ss.log(Status.INFO, "clicked SaveButtonOnEditAccountManagerOverlay");
		Assert.assertEquals(accountpage.successMsgOfBlockedAccountManager(), "Call Manager Blocked Successfully");
		logger_ss.log(Status.INFO, "verified successMsgOfBlockedAccountManager");
		accountpage.deleteAccountManager();
		Assert.assertEquals(accountpage.successMsgForDeletedAccountManager(), "Account Manager deleted Successfully");
		logger_ss.log(Status.INFO, "verified successMsgForDeletedAccountManager");
		Assert.assertTrue(accountpage.verifyAvailabilityOfRemovedSubAccountMAnager());
		logger_ss.log(Status.INFO, "Successfully verified AvailabilityOfRemovedSubAccountMAnager");
		logger_ss.log(Status.INFO, "Successfully verified verifyAccountManagerFunctionalityInAccountManagersTab");
		
	}
	
	@Test
	public void verifyAddSubAccountFunctionalityWithAlreadyExistedSubAccount() throws InterruptedException{
		logger_ss = extent.createTest("verifyAddSubAccountFunctionalityWithAlreadyExistedSubAccount","verifyAddSubAccountFunctionalityWithAlreadyExistedSubAccount");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		accountpage.clickSubAccountsTab();
		logger_ss.log(Status.INFO, "Clicked on sub accounts tab");
		accountpage.clickAddSubAccountTab();
		logger_ss.log(Status.INFO, "Clicked on AddSubAccountTab");
		accountpage.enterNickNameOnAddSubAccountOverlay("smsc");
		logger_ss.log(Status.INFO, "entered NickNameOnAddSubAccountOverlay");
		accountpage.enterMobileOnAddSubAccountOverlay("8686588362");
		logger_ss.log(Status.INFO, "entered MobileOnAddSubAccountOverlay");
		Assert.assertEquals(accountpage.errorMessageOnOverlay(), "This Account is Already Sub Account, you can't make this account again as sub Account");
		logger_ss.log(Status.INFO, "Successfully verified errorMessageOnOverlay");
		logger_ss.log(Status.INFO, "Successfully verified AddSubAccountFunctionalityWithAlreadyExistedSubAccount");
	}	
	
	@Test
	public void verifyAddSubAccountFunctionalityWithAlreadyExistedMainAccount() throws InterruptedException{
		logger_ss = extent.createTest("verifyAddSubAccountFunctionalityWithAlreadyExistedMainAccount","verifyAddSubAccountFunctionalityWithAlreadyExistedMainAccount");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		accountpage.clickSubAccountsTab();
		logger_ss.log(Status.INFO, "Clicked on sub accounts tab");
		accountpage.clickAddSubAccountTab();
		logger_ss.log(Status.INFO, "Clicked on AddSubAccountTab");
		accountpage.enterNickNameOnAddSubAccountOverlay("smsc");
		logger_ss.log(Status.INFO, "entered NickNameOnAddSubAccountOverlay");
		accountpage.enterMobileOnAddSubAccountOverlay("7396206647");
		logger_ss.log(Status.INFO, "entered MobileOnAddSubAccountOverlay");
		Assert.assertEquals(accountpage.errorMessageOnOverlay(), "You cannot make this main account as Sub account");
		logger_ss.log(Status.INFO, "Successfully verified errorMessageOnOverlay");
		logger_ss.log(Status.INFO, "Successfully verified AddSubAccountFunctionalityWithAlreadyExistedMainAccount");
	}	
	
	@Test
	public void verifyAddSubAccountFunctionalityWhenSelectPoolAsSubAccountType() throws InterruptedException{
		logger_ss = extent.createTest("verifyAddSubAccountFunctionality","verifyAddSubAccountFunctionality");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		accountpage.clickSubAccountsTab();
		logger_ss.log(Status.INFO, "Clicked on sub accounts tab");
		accountpage.clickAddSubAccountTab();
		logger_ss.log(Status.INFO, "Clicked on AddSubAccountTab");
		accountpage.enterNickNameOnAddSubAccountOverlay("smsc");
		logger_ss.log(Status.INFO, "entered NickNameOnAddSubAccountOverlay");
		accountpage.enterMobileOnAddSubAccountOverlay("9642850605");
		logger_ss.log(Status.INFO, "entered MobileOnAddSubAccountOverlay");
		Assert.assertEquals(accountpage.successMessageOnOverlay(), "Registered with Time Pasd");
		logger_ss.log(Status.INFO, "successfully verified successMessageOnOverlay");
		accountpage.clickPoolSubAccountOnAddSubAccountOverlay();
		logger_ss.log(Status.INFO, "Clicked on PoolSubAccountOnAddSubAccountOverlay");
		Assert.assertFalse(accountpage.visibilityOfMaxMemberLimitFieldOnAddSubAccountOverlay());
		logger_ss.log(Status.INFO, "Successfully verified visibilityOfMaxMemberLimitFieldOnAddSubAccountOverlay");
		Assert.assertFalse(accountpage.visibilityOfTransferAmountFieldOnAddSubAccountOverlay());
		logger_ss.log(Status.INFO, "Successfully verified visibilityOfTransferAmountFieldOnAddSubAccountOverlay");
		logger_ss.log(Status.INFO, "Successfully verified AddSubAccountFunctionalityWhenSelectPoolAsSubAccountType");
	}	
	
	@Test
	public void verifyAddSubAccountFunctionalityByGivingNonRegisteredNumberInSubAccountsTab() throws InterruptedException{
		logger_ss = extent.createTest("verifyAddSubAccountFunctionalityByGivingNonRegisteredNumberInSubAccountsTab","verifyAddSubAccountFunctionalityByGivingNonRegisteredNumberInSubAccountsTab");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		accountpage.clickSubAccountsTab();
		logger_ss.log(Status.INFO, "Clicked on sub accounts tab");
		accountpage.clickAddSubAccountTab();
		logger_ss.log(Status.INFO, "Clicked on AddSubAccountTab");
		accountpage.enterNickNameOnAddSubAccountOverlay("smsc");
		logger_ss.log(Status.INFO, "entered NickNameOnAddSubAccountOverlay");
		accountpage.enterMobileOnAddSubAccountOverlay("2342342345");
		logger_ss.log(Status.INFO, "entered MobileOnAddSubAccountOverlay");
		Assert.assertEquals(accountpage.errorMessageOnOverlay(), "This number is not registered with grptalk. Send invitation to download grpTalk");
		logger_ss.log(Status.INFO, "successfully verified error MessageOnOverlay");
		Assert.assertTrue(accountpage.visibilityOfSendInvitationButtonOnAddSubAccountOverlay());
		logger_ss.log(Status.INFO, "Successfully verified visibilityOfSendInvitationButtonOnAddSubAccountOverlay");
		logger_ss.log(Status.INFO, "Successfully verified AddSubAccountFunctionalityByGivingNonRegisteredNumberInSubAccountsTab");
	}
	
	@Test
	public void verifyErrorMsgOnAddSubAccountOverlayWhenMemeberLimitExceedsMainAccountMaxMemberLimit() throws InterruptedException{
		logger_ss = extent.createTest("verifyErrorMsgOnAddSubAccountOverlayWhenMemeberLimitExceedsMainAccountMaxMemberLimit","verifyErrorMsgOnAddSubAccountOverlayWhenMemeberLimitExceedsMainAccountMaxMemberLimit");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		int totalLines =accountpage.totalAvailableLines();
		accountpage.clickSubAccountsTab();
		logger_ss.log(Status.INFO, "Clicked on sub accounts tab");
		accountpage.clickAddSubAccountTab();
		logger_ss.log(Status.INFO, "Clicked on AddSubAccountTab");
		accountpage.enterNickNameOnAddSubAccountOverlay("smsc");
		logger_ss.log(Status.INFO, "entered NickNameOnAddSubAccountOverlay");
		accountpage.enterMobileOnAddSubAccountOverlay("9642850605");
		logger_ss.log(Status.INFO, "entered MobileOnAddSubAccountOverlay");
		Assert.assertEquals(accountpage.successMessageOnOverlay(), "Registered with Time Pasd");
		logger_ss.log(Status.INFO, "successfully verified successMessageOnOverlay");
		accountpage.clickQuotaSubAccountOnAddSubAccountOverlay();
		logger_ss.log(Status.INFO, "clicked on QuotaSubAccountOnAddSubAccountOverlay");
		boolean result= accountpage.enterMaxMemberLimitValueOnAddSubAccountOverlay(11, totalLines);
		logger_ss.log(Status.INFO, "Given MaxMemberLimitValueOnAddSubAccountOverlay");
		if(result==false){
			Assert.assertEquals(accountpage.maxMemberLimitErrorMsgOnAddSubAccountOverlay(), "Max Member limit for main account has been reached and your available limit is 7");
			logger_ss.log(Status.INFO, "Successfully verified maxMemberLimitErrorMsgOnAddSubAccountOverlay");
		}
		logger_ss.log(Status.INFO, "Successfully verified ErrorMsgOnAddSubAccountOverlayWhenMemeberLimitExceedsMainAccountMaxMemberLimit");
	}
	
	@Test
	public void verifyErrorMsgOnAddSubAccountOverlayWhenTransferAmountExceedsMainAccountAvailableAmountLimit() throws InterruptedException{
		logger_ss = extent.createTest("verifyErrorMsgOnAddSubAccountOverlayWhenTransferAmountExceedsMainAccountAvailableAmountLimit","verifyErrorMsgOnAddSubAccountOverlayWhenTransferAmountExceedsMainAccountAvailableAmountLimit");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		int currentBalance =accountpage.getCurrentBalance();
		System.out.println("current balance::"+currentBalance);
		logger_ss.log(Status.INFO, "Taken current balance");
		accountpage.clickSubAccountsTab();
		logger_ss.log(Status.INFO, "Clicked on sub accounts tab");
		accountpage.clickAddSubAccountTab();
		logger_ss.log(Status.INFO, "Clicked on AddSubAccountTab");
		accountpage.enterNickNameOnAddSubAccountOverlay("smsc");
		logger_ss.log(Status.INFO, "entered NickNameOnAddSubAccountOverlay");
		accountpage.enterMobileOnAddSubAccountOverlay("9642850605");
		logger_ss.log(Status.INFO, "entered MobileOnAddSubAccountOverlay");
		Assert.assertEquals(accountpage.successMessageOnOverlay(), "Registered with Time Pasd");
		logger_ss.log(Status.INFO, "successfully verified successMessageOnOverlay");
		accountpage.clickQuotaSubAccountOnAddSubAccountOverlay();
		logger_ss.log(Status.INFO, "clicked on QuotaSubAccountOnAddSubAccountOverlay");
		boolean result= accountpage.enterTransferAmountValueOnAddSubAccountOverlay(4566, currentBalance);
		logger_ss.log(Status.INFO, "Given TransferAmountValueOnAddSubAccountOverlay");
		if(result==false){
			Assert.assertEquals(accountpage.transferAmountLimitErrorMsgOnAddSubAccountOverlay(), "Should not more than Main Account");
			logger_ss.log(Status.INFO, "Successfully verified transferAmountLimitErrorMsgOnAddSubAccountOverlay");
		}
		logger_ss.log(Status.INFO, "Successfully verified ErrorMsgOnAddSubAccountOverlayWhenTransferAmountExceedsMainAccountAvailableAmountLimit");
	}
	
	@Ignore
	@Test
	public void verifyAddSubAccountFunctionalityInSubAccountsTab() throws InterruptedException{
		logger_ss = extent.createTest("verifyAddSubAccountFunctionalityInSubAccountsTab","verifyAddSubAccountFunctionalityInSubAccountsTab");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		int totalLines =accountpage.totalAvailableLines();
		int currentBalance =accountpage.getCurrentBalance();
		accountpage.clickSubAccountsTab();
		logger_ss.log(Status.INFO, "Clicked on sub accounts tab");
		accountpage.clickAddSubAccountTab();
		logger_ss.log(Status.INFO, "Clicked on AddSubAccountTab");
		accountpage.enterNickNameOnAddSubAccountOverlay("smsc");
		logger_ss.log(Status.INFO, "entered NickNameOnAddSubAccountOverlay");
		accountpage.enterMobileOnAddSubAccountOverlay("9642850605");
		logger_ss.log(Status.INFO, "entered MobileOnAddSubAccountOverlay");
		Assert.assertEquals(accountpage.successMessageOnOverlay(), "Registered with Rajashekar");
		logger_ss.log(Status.INFO, "successfully verified successMessageOnOverlay");
		accountpage.clickQuotaSubAccountOnAddSubAccountOverlay();
		logger_ss.log(Status.INFO, "clicked on QuotaSubAccountOnAddSubAccountOverlay");
		boolean maxMemberResult= accountpage.enterMaxMemberLimitValueOnAddSubAccountOverlay(2, totalLines);
		logger_ss.log(Status.INFO, "Given MaxMemberLimitValueOnAddSubAccountOverlay");
		if(maxMemberResult==false){
			Assert.assertEquals(accountpage.maxMemberLimitErrorMsgOnAddSubAccountOverlay(), "Max Member limit for main account has been reached and your available limit is 10");
			logger_ss.log(Status.INFO, "Successfully verified maxMemberLimitErrorMsgOnAddSubAccountOverlay");
		}
		boolean transferAmountResult= accountpage.enterTransferAmountValueOnAddSubAccountOverlay(50, currentBalance);
		logger_ss.log(Status.INFO, "Given TransferAmountValueOnAddSubAccountOverlay");
		if(transferAmountResult==false){
			Assert.assertEquals(accountpage.transferAmountLimitErrorMsgOnAddSubAccountOverlay(), "Should not more than Main Account");
			logger_ss.log(Status.INFO, "Successfully verified maxMemberLimitErrorMsgOnAddSubAccountOverlay");
		}
		//accountpage.clickAddButtonOnAddSubAccountOverlay();
		logger_ss.log(Status.INFO, "Successfully verified AddSubAccountFunctionalityInSubAccountsTab");
	}
	
	@Ignore
	@Test
	public void verifyExistingSubAccountFunctionalityInSubAccountsTab() throws InterruptedException{
		logger_ss = extent.createTest("verifyExistingSubAccountFunctionalityInSubAccountsTab","verifyExistingSubAccountFunctionalityInSubAccountsTab");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		int currentBalance =accountpage.getCurrentBalance();
		accountpage.clickSubAccountsTab();
		logger_ss.log(Status.INFO, "Clicked on sub accounts tab");
		String addBalanceToSubAccount = "10";
		accountpage.addBalanceToActiveSubAccount1(addBalanceToSubAccount);
	}
	
	
	@Test
	public void verifyAddBalanceFunctionalityToExistingSubAccountInSubAccountsTab() throws InterruptedException{
		logger_ss = extent.createTest("verifyAddBalanceFunctionalityToExistingSubAccountInSubAccountsTab","verifyAddBalanceFunctionalityToExistingSubAccountInSubAccountsTab");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		int currentBalance =accountpage.getCurrentBalance();
		accountpage.clickSubAccountsTab();
		logger_ss.log(Status.INFO, "Clicked on sub accounts tab");
		String addBalanceToSubAccount = "10";
		String successMsgForBalanceTransfer = accountpage.addBalanceToActiveSubAccount(addBalanceToSubAccount);
		logger_ss.log(Status.INFO, "added Balance To Active SubAccount");
		Assert.assertEquals(successMsgForBalanceTransfer, "Balance Transfered SuccessFully");
		logger_ss.log(Status.INFO, "verified successMsgForBalanceTransfer");
		logger_ss.log(Status.INFO, "Successfully verified AddBalanceFunctionalityToExistingSubAccountInSubAccountsTab");
	}
	
	@Test
	public void verifyViewSubAccountDetailsFunctionalityInSubAccountsTab() throws InterruptedException{
		logger_ss = extent.createTest("verifyViewSubAccountDetailsFunctionalityInSubAccountsTab","verifyViewSubAccountDetailsFunctionalityInSubAccountsTab");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		accountpage.clickSubAccountsTab();
		logger_ss.log(Status.INFO, "Clicked on sub accounts tab");
		accountpage.clickViewDetailsOfSubAccount();
		logger_ss.log(Status.INFO, "clicked on ViewDetailsOfSubAccount");
		Assert.assertEquals(accountpage.subAccountNameInSubAccountDetails(), "srikanth airtel");
		logger_ss.log(Status.INFO, "verified subAccountNameInSubAccountDetails");
		Assert.assertEquals(accountpage.subAccountMobileNumbersInSubAccountDetails(), "919550866282");
		logger_ss.log(Status.INFO, "verified subAccountMobileNumbersInSubAccountDetails");
		logger_ss.log(Status.INFO, "Successfully verified ViewSubAccountDetailsFunctionalityInSubAccountsTab");
	}
	
	@Test
	public void verifyEditSubAccountFunctionalityInSubAccountsTab() throws InterruptedException{
		logger_ss = extent.createTest("verifyEditSubAccountFunctionalityInSubAccountsTab","verifyEditSubAccountFunctionalityInSubAccountsTab");
		AccountPage accountpage = new AccountPage();
		accountpage.clickOnAccountTab();
		logger_ss.log(Status.INFO, "Clicked on account tab in MyGrpTalks page");
		accountpage.clickSubAccountsTab();
		logger_ss.log(Status.INFO, "Clicked on sub accounts tab");
		accountpage.clickEditOptionOfSubAccount();
		logger_ss.log(Status.INFO, "clicked on EditOptionOfSubAccount");
		accountpage.enterMaxMemberLimitInEditSubAccountOverlay();
		logger_ss.log(Status.INFO, "entered MaxMemberLimitInEditSubAccountOverlay");
		accountpage.chanageAccountStatusToBlockedInEditSubAccountOverlay();
		logger_ss.log(Status.INFO, "chanageed AccountStatusToBlockedInEditSubAccountOverlay");
		accountpage.clickSaveButtonOnEditsubAccountOverlay();
		logger_ss.log(Status.INFO, "clicked on SaveButtonOnEditsubAccountOverlay");
		Assert.assertEquals(accountpage.successMsgOfEditSubAccount(), "Sub Account Have Edited Successfully");
		logger_ss.log(Status.INFO, "verified successMsgOfEditSubAccount");
		Assert.assertTrue(accountpage.blockedOptionForSubAccounts());
		logger_ss.log(Status.INFO, "verified blocked text ForSubAccounts");
		accountpage.clickEditOptionOfSubAccount();
		logger_ss.log(Status.INFO, "clicked on EditOptionOfSubAccount");
		accountpage.enterMaxMemberLimitInEditSubAccountOverlay();
		logger_ss.log(Status.INFO, "entered MaxMemberLimitInEditSubAccountOverlay");
		accountpage.chanageAccountStatusToActiveInEditSubAccountOverlay();
		logger_ss.log(Status.INFO, "chanaged AccountStatusToActiveInEditSubAccountOverlay");
		accountpage.clickSaveButtonOnEditsubAccountOverlay();
		logger_ss.log(Status.INFO, "clicked on SaveButtonOnEditsubAccountOverlay");
		Assert.assertEquals(accountpage.successMsgOfEditSubAccount(), "Sub Account Have Edited Successfully");
		logger_ss.log(Status.INFO, "verified successMsgOfEditSubAccount");
		Assert.assertTrue(accountpage.activeOptionForSubAccounts());
		logger_ss.log(Status.INFO, "verified ACTIVE text ForSubAccounts");
		logger_ss.log(Status.INFO, "Successfully verified EditSubAccountFunctionalityInSubAccountsTab");
	}
	
}

