package GT.GT;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import utility.*;

public class AccountPage extends BrowserFunctions{
	
	private static final TimeUnit SECONDS = null;
	
	By chooseImageButton 						= By.xpath("//*[@value='Choose image']");
	By userNameFieldOnEditProfileOverlay 		= By.id("userName");
 	By saveButtonOnEditProfileOverlay 			= By.id("saveData");
 	By emailIDfieldOnEditProfileOverlay 		= By.id("emailID");
 	By profileName 								= By.id("nickname");
	By account 									= By.xpath("//*[@id='account-li']/a");
 	By changeProfileButton 						= By.id("changeProfileDetails");
 	By allTabInMyAccount 						= By.xpath("//*[@id='accountTabs']/li[3]/a");
 	By rechargeTabInMyAccount 					= By.id("recharge");
 	By usedAmontInWeb 							= By.id("web_inr");
 	By grpTalkLogo 								= By.id("imgLogo");
 	By liveCallButton 							= By.xpath("//*[@id='date']//label");
 	By hangUpAllButtonInGrpCall 				= By.xpath("//*[@id='hangup']/a/img");
 	By totalAvailableLines 						= By.id("tot_channels");
 	By profileTab 								= By.id("showProfile");
 	By currrentBalance 							= By.id("hdnBalance");
 	By subAccountsTab 							= By.id("subAccountLi");
 	By accountManagersTab 						= By.id("AccountManagerLi");
 	By addSubAccountTab 						= By.id("ModalAddSubAccount");
 	By nickNameFieldOnAddSubAccountOverlay 		= By.id("createProfileName");
 	By mobileNumberFieldOnAddSubAccountOverlay 	= By.id("createMobNo");
 	By quotaSubAccountOnAddSubAccountOverlay 	= By.id("rdShare");
 	By poolSubAccountOnAddSubAccountOverlay 	= By.id("rdPool");
 	By maxMemberLimitFieldOnAddSubAccountOverlay= By.id("createMemberLimit");
 	By transferAmountFieldOnAddSubAccountOverlay= By.id("createAmount");
 	By addButtonOnAddSubAccountOverlay 			= By.id("createAdd");
 	By closeButtonOnAddSubAccountOverlay 		= By.id("createClose");
 	By closeMarkOnAddSubAccountOverlay 			= By.id("closeAddSubAcc");
 	By sendInvitationButtonOnAddSubAccountOverlay= By.id("createInvitation");
 	By errorMsgForInvalidRegisteredMobileNumberOnSubAccountOverlay = By.id("nonRegisteredMsg");
 	By availableLinesText 						= By.id("SubAccountDiv");
 	By addAccountManagerTab 					= By.id("ModalAddAccountManager");
 	By nickNameFieldOnAddAccountManagerOverlay 	= By.id("createManagerProfileName");
 	By mobileNumberFieldOnAddAccountManagerOverlay = By.id("createManagerMobNo");
 	By closeButtonOnAddAccountManagerOverlay 	= By.id("createManagerClose");
 	By addButtonOnAddAccountManagerOverlay 		=By.id("createManagerAdd");
 	By sendInvitationButtonOnAddAccountManagerOverlay = By.id("createManagerInvitation");
 	By closeMarkOnAddAccountManagerOverlay 		=By.id("closeAddAccMgr");
	By successMsgForValidRegistredMobileNumber 	= By.id("actualManagerName");
	By successMsgWithNameForValidRegistredMobileNumber = By.id("registeredManagerMsg");
	By errorMsgForInvalidRegisteredMobileNumber = By.id("nonRegisteredMgrMsg");
	By unAvailabilityMsgOfAccountManagers 		= By.id("divGetAccountManager");
	By successMsgForCreationOfAccountManager	= By.xpath("//*[@class='toast toast-success']");
	By accountManagerNameAndNumber 				= By.xpath("//*[@id='divGetAccountManager']//*[@class='subAcc-Item']"); 
	By activeStateOfAccountManager 				= By.xpath("//*[@id='divGetAccountManager']//*[@class='fa fa-check text-green']");
	By editDetailsButtonOfAccountManager 		= By.xpath("//*[@id='divGetAccountManager']//*[@class='subAcc-Item']//*[@class='glyphicon glyphicon-pencil']");
	By accountManagerNameOnEditAccountManagerOverlay = By.id("h4EditAccountManager");
	By accountStatus 							= By.id("ddlAccountManagerStatus");
	By saveButtonOnEditAccountManagerOverlay 	= By.id("btnEditAccountManager");
	By successMsgOfBlockedAccountManager		= By.xpath("//*[@class='toast toast-success']");
	By blockedStateOfAccountManager 			= By.xpath("//*[@id='divGetAccountManager']//*[@class='fa fa-remove text-red']");
	By deleteOptionForAccountManager 			= By.xpath("//*[@class='tab-content']//*[@id='divGetAccountManager']//*[@class='DeleteManagerDetails']");
	By successMsgForDeletedAccountManager 		= By.xpath("//*[@class='toast toast-success']");
	By numberOfAccountManagers 					= By.xpath("//*[@id='divGetAccountManager']//*[@class='subAcc-Item']");
	By successMsgOfActivatedAccountManager		= By.xpath("//*[@class='toast toast-success']");
	By errorMessage								= By.id("nonRegisteredMsg");
	By successMsg 								= By.id("registeredMsg");
	By maxMemberLimitErrorMsg 					= By.id("memberLimitMsg");
	By transferAmountLimitErrorMsg 				= By.id("amountMsg");
	By configureClips 							= By.xpath("//*[@class='btn btn-primary btn-pink btnConfiguration']");
	By chooseFileForMuteClip 					= By.xpath("//*[@id='divClips']/fieldset[2]/input[2][@value='Choose File']");
	By chooseFileForNormalclip 					= By.xpath("//*[@id='divClips']/fieldset[1]/input[2][@value='Choose File']");
	By saveNormalClip 							= By.xpath("//*[@id='divClips']//*[@id='btnSaveWelcomeClip']");
	By saveMuteClip 							= By.xpath("//*[@id='divClips']//*[@id='btnSaveMuteClip']");
	By downloadLinkForNormalClipAudio			= By.xpath("//*[@id='NormalClipAudio']//*[@id='spNormalClip']");
	By downloadLinkForMuteClipAudio 			= By.xpath("//*[@id='MuteClipAudio']//*[@id='spMuteclip']");
	By closeButtonOnConfigureClipsOverlay 		= By.xpath("//*[@class= 'btn btn-default btnCloseConfig']");
	By deleteButtonForNormalClip 				= By.xpath("//*[@id='btnDeleteNormalClip']");
	By deleteButtonForMuteClip 					= By.xpath("//*[@id='btnDeleteMuteClip']");
	By successMsgForUploadedNormalAudioClip 	= By.xpath("//*[@class='toast-message']");
	By successMsgForUploadedMuteAudioClip 		= By.xpath("//*[@class='toast-message']");
	By msgOnConfigureClipsOverlay 				= By.xpath("//*[@class='toast-message']");
 	By availableLines 							= By.id("AvailableLines");
 	By subAccountsCount 						= By.xpath("//*[@id='SubAccountDiv']//*[@class='subAcc-Item']");
 	By activeOptionForSubAccounts 				= By.xpath("//*[@mobileno='919550866282']//*[@class='fa fa-check text-green']");
 	By blockedOptionForSubAccounts 				= By.xpath("//*[@mobileno='919550866282']//*[@class='fa fa-remove text-red']");
 	By editOptionOfSubAccount 					= By.xpath("//*[@mobileno='919550866282']//*[@class='CEditSubAccount']");
 	By viewOptionOfSubAccount 					= By.xpath("//*[@mobileno='919550866282']//*[@class='CViewSubAccount']");
 	By addBalanceOptionOfSubAccount 			= By.xpath("//*[@mobileno='919550866282']//*[@class='CAddBalance']");
 	By subAccountsNames 						= By.xpath("//*[@id='SubAccountDiv']//*[@class='subAcc-Item']//*[@class='font-18 subAccountName']");
 	By subAccounts 								= By.xpath("//*[@id='SubAccountDiv']//*[@class='subAcc-Item']");
 	By activeSubAccount 						= By.xpath("//*[@mobileno='919550866282']");
 	By transferAmountFieldOnAddBalanceOverlay 	= By.id("txtAddBalance");
 	By addButtonOnAddBalanceOverlay 			= By.id("btnAddBalance");
 	By currentBalanceOfSubAccount 				= By.xpath("//*[@class='margin-top-10 font-20 subAccountBalance']");
 	By successMessageForBalanceTransfer 		= By.xpath("//*[@class='toast-message']");
 	By subAccountNameInSubAccountDetails 		= By.xpath("//*[@id='displayName']");
 	By subAccountMobileNumbersInSubAccountDetails = By.xpath("//*[@id='displayMobNo']");
 	By maxMemberLimitInEditSubAccountOverlay 	= By.id("MaxConCurrency");
 	By accountStatusInEditSubAccountOverlay 	= By.id("ddlAccountStatus");
 	By saveButtonOnEditsubAccountOverlay 		= By.xpath("//*[@id='btnEditSubAccount']");
 	By successMsgOfEditSubAccount 				= By.xpath("//*[@class='toast-message']");
 	By rechargeNowWithPaytmButton				= By.id("paytmBtn");
 	By enterRechageAmount 						= By.id("amount");
 	By walletTransactionId						= By.id("trnxid");
 	By proceedButtonOnRechargeOverlay			= By.id("btn_rechargeReq");
 	By successMsgForRechageWithPaytm			= By.xpath("//*[@class='modal-content']//p[2]");
 	
 	public void clickRechargeNowWithPaytmButton(){
 		driver.findElement(rechargeNowWithPaytmButton).click();
 	}
 	
 	public String successMsgForPaytmRecharge(){
 		return driver.findElement(successMsgForRechageWithPaytm).getText();
 	}
 	
 	public void enterDetailsOnRechargeOverlayAndProceed() throws InterruptedException{
 		String transactionId= "1234562"+System.currentTimeMillis();
 		driver.findElement(enterRechageAmount).sendKeys(CommonMethods.passingData("rechargeAmountThroghPaytm"));
 		driver.findElement(walletTransactionId).sendKeys(transactionId);
 		driver.findElement(proceedButtonOnRechargeOverlay).click();
 		Thread.sleep(2000);
 	}
 	
 	public void navigateToGrpTalkHomePage() throws InterruptedException, AWTException{
 		Thread.sleep(2000);
 		driver.findElement(grpTalkLogo).click();
 	}
 	
 	public void uploadImage() throws InterruptedException, AWTException{
 		driver.findElement(chooseImageButton).click();
 		Thread.sleep(1000);
 		CommonMethods.getUploadFile("D:\\GrpTalk\\TestDataFiles\\Images\\host image.jpg");
 		Thread.sleep(13000);
 	}
 	
 	public String usedAmontInWeb() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(usedAmontInWeb);
 		String s = driver.findElement(usedAmontInWeb).getText();
 		String value = s.replaceAll("INR ", "");
 		return value;
 	}
 	
 	public boolean clickRechargesTabOnMyAccountPage() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(rechargeTabInMyAccount);
 		driver.findElement(rechargeTabInMyAccount).click();
 		return driver.findElement(rechargeTabInMyAccount).isDisplayed();
 	}
 	
 	public boolean clickAllTabOnMyAccountPage() throws InterruptedException{
 	 	CommonMethods.explicitWaitForElementVisibility(allTabInMyAccount);
 	 	driver.findElement(allTabInMyAccount).click();
 	 	return driver.findElement(allTabInMyAccount).isDisplayed();
 	}
 	
 	public String editUserProfile() throws InterruptedException, AWTException{
 		CommonMethods.explicitWaitForElementVisibility(userNameFieldOnEditProfileOverlay);
 		driver.findElement(userNameFieldOnEditProfileOverlay).clear();
 		driver.findElement(userNameFieldOnEditProfileOverlay).sendKeys(CommonMethods.passingData("userNameOnEditProfileOverlay"));
 		driver.findElement(emailIDfieldOnEditProfileOverlay).clear();
 		driver.findElement(emailIDfieldOnEditProfileOverlay).sendKeys(CommonMethods.passingData("emailOnEditProfileOverlay"));
 		uploadImage();
 		driver.findElement(saveButtonOnEditProfileOverlay).click();
 		
 		return driver.findElement(profileName).getText();
 	}
 	
 	public void clickOnAccountTab() throws InterruptedException{
 		Thread.sleep(2000);
 		driver.findElement(account).click();
 	}
 	
 	public void ChangeProfileButton() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(changeProfileButton);
 		driver.findElement(changeProfileButton).click();
 	}
 	
	public void closeLiveGroupCallOfRecentlySavedGrpTalkGroup() throws InterruptedException{
		String liveOption= driver.findElement(liveCallButton).getText();
		if(liveOption.contains("Live")){
			driver.findElement(liveCallButton).click();
 			hangUpCurrentGrpTalkcall();
 			System.out.println("successfully closed LiveGroupCallOfRecentlySavedGrpTalkGroup");
		}
   	}
	
 	public void hangUpCurrentGrpTalkcall() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(hangUpAllButtonInGrpCall);
 		driver.findElement(hangUpAllButtonInGrpCall).click();
 	}
 	
	public String addBalanceToActiveSubAccount(String addBalance) throws InterruptedException{
 		driver.findElement(addBalanceOptionOfSubAccount).click();
 		Thread.sleep(2000);
 		driver.findElement(transferAmountFieldOnAddBalanceOverlay).sendKeys(addBalance);
 		driver.findElement(addButtonOnAddBalanceOverlay).click();
 		Thread.sleep(1000);
 		return driver.findElement(successMessageForBalanceTransfer).getText();
	}
	
	public boolean activeOptionForSubAccounts(){
		return driver.findElement(activeOptionForSubAccounts).isDisplayed();
	}
	
	public boolean blockedOptionForSubAccounts(){
		return driver.findElement(blockedOptionForSubAccounts).isDisplayed();
	}
	
	public void clickViewDetailsOfSubAccount(){
		driver.findElement(viewOptionOfSubAccount).click();
	}
	
	public void clickEditOptionOfSubAccount() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(editOptionOfSubAccount).click();
	}
	
	public void enterMaxMemberLimitInEditSubAccountOverlay(){
		driver.findElement(maxMemberLimitInEditSubAccountOverlay).clear();
		driver.findElement(maxMemberLimitInEditSubAccountOverlay).sendKeys(CommonMethods.passingData("enterMaxMemberLimitInEditSubAccount"));
	}
	
	public void chanageAccountStatusToBlockedInEditSubAccountOverlay(){
		Select listbox=new Select(driver.findElement(accountStatusInEditSubAccountOverlay));
		listbox.selectByVisibleText("Blocked");
	}
	
	public void chanageAccountStatusToActiveInEditSubAccountOverlay() throws InterruptedException{
		Select listbox=new Select(driver.findElement(accountStatusInEditSubAccountOverlay));
		listbox.selectByVisibleText("Active");
		Thread.sleep(2000);
	}
	
	public void clickSaveButtonOnEditsubAccountOverlay() throws InterruptedException{
		driver.findElement(saveButtonOnEditsubAccountOverlay).click();
		Thread.sleep(2000);
	}
	
	public String successMsgOfEditSubAccount(){
		return driver.findElement(successMsgOfEditSubAccount).getText();
	}
	
	public String subAccountNameInSubAccountDetails(){
		return driver.findElement(subAccountNameInSubAccountDetails).getText();
	}
	
	public String subAccountMobileNumbersInSubAccountDetails(){
		return driver.findElement(subAccountMobileNumbersInSubAccountDetails).getText();
	}
 	
 	public void addBalanceToActiveSubAccount1(String addBAlance){
 		List<WebElement> accountNames = driver.findElements(subAccounts);
 		WebElement activeAccount = driver.findElement(activeSubAccount);
 		String addBalanceToSubAccount= addBAlance;
 		String currentSubAccBalance,UpdatedSubAccountBalance;
 		System.out.println("ssss");
 		currentSubAccBalance= driver.findElement(By.xpath("//*[@id='divGetSubAccount']/*[@mobileno='919550866282']//*[@class='blocks'][1]")).getText();
 			System.out.println(currentSubAccBalance);	
 			System.out.println( driver.findElement(By.xpath("//*[@mobileno='919550866282']//*[@class='blocks'][1]")).getAttribute("innerhtml"));
 	}
 
	public String successMsgForUploadedNormalAudioClip() throws InterruptedException{
		Thread.sleep(1000);
		return driver.findElement(successMsgForUploadedNormalAudioClip).getText();
	}
	
	public String msgOnConfigureClipsOverlay() throws InterruptedException{
		Thread.sleep(1000);
		return driver.findElement(msgOnConfigureClipsOverlay).getText();
	}
	
	public String successMsgForUploadedMuteAudioClip() throws InterruptedException{
		Thread.sleep(1000);
		return driver.findElement(successMsgForUploadedMuteAudioClip).getText();
	}
	
	public boolean visibliltyOfDownloadOptionForNormalClip(){
		return driver.findElement(downloadLinkForNormalClipAudio).isDisplayed();
	}
	
	public boolean visibliltyOfDownloadOptionForMuteClip(){
		return driver.findElement(downloadLinkForMuteClipAudio).isDisplayed();
	}
	public boolean visibliltyOfdeleteButtonForNormalClip(){
		return driver.findElement(deleteButtonForNormalClip).isDisplayed();
	}
	
	public void clickDeleteButtonForNormalClip() throws InterruptedException{
		driver.findElement(deleteButtonForNormalClip).click();
		Thread.sleep(1000);
	}
	
	public void clickDeleteButtonForMuteClip() throws InterruptedException{
		driver.findElement(deleteButtonForMuteClip).click();
		Thread.sleep(1000);
	}
	
	public boolean visibliltyOfdeleteButtonForMuteClip(){
		return driver.findElement(deleteButtonForMuteClip).isDisplayed();
	}
	
	public void clickConfigureClipsButton() throws InterruptedException{
		driver.findElement(configureClips).click();
		Thread.sleep(2000);
	}
	
	public int subAccountsCount(){
		return driver.findElements(subAccountsCount).size();
	}
	
	public void clickChooseFileForMuteClip(){
		driver.findElement(chooseFileForMuteClip).click();
	}
	public void saveNormalClip(){
		driver.findElement(saveNormalClip).click();
	}
	
	public void clickChooseFileForNormalclip() throws InterruptedException{
		driver.findElement(chooseFileForNormalclip).click();
		Thread.sleep(2000);
	}
	
	public void saveMuteClip(){
		driver.findElement(saveMuteClip).click();
	}
	
	public void clickCloseButtonOnConfigureClipsOverlay() throws InterruptedException{
		driver.findElement(closeButtonOnConfigureClipsOverlay).click();
		Thread.sleep(2000);
	}
	
	public String errorMessageOnOverlay(){
		return driver.findElement(errorMessage).getText();
	}
	
	public String successMessageOnOverlay() throws InterruptedException{
		Thread.sleep(2000);
		return driver.findElement(successMsg).getText();
	}
	
	public void deleteExistingSubAccountManager() throws InterruptedException{
		List<WebElement> listOfSubAccountManagers = driver.findElements(numberOfAccountManagers);
		for(WebElement subAccountManager: listOfSubAccountManagers){
			if(subAccountManager.getAttribute("mobileno").contains("918919590168") ){
				subAccountManager.findElement(By.xpath("//*[@class='glyphicon glyphicon-pencil']")).click();
				changeAccountStatus();
				clickSaveButtonOnEditAccountManagerOverlay();
				deleteAccountManager();
				break;
			}
		}
	}
	
	public int totalNumberOfAccountManagers(){
		return driver.findElements(numberOfAccountManagers).size();
	}
	
	public boolean verifyAvailabilityOfRemovedSubAccountMAnager(){
		int count = driver.findElements(numberOfAccountManagers).size();
		int size=0,countOfAccountManagers=0;
		if(count==0){
			countOfAccountManagers=size;
		}else if(count>0){
			List<WebElement> totalAccountManagers= driver.findElements(numberOfAccountManagers);
			for(WebElement accountManager: totalAccountManagers){
				String s= accountManager.getAttribute("mobileno");
				if(s.contains("8919590168")){
					countOfAccountManagers++;
				}
			}
		}
		else{
			countOfAccountManagers=size;
		}
		if(countOfAccountManagers==0){
			return true;
		}else{
			return false;
		}
	}
	
	public String successMsgForDeletedAccountManager(){
		return driver.findElement(successMsgForDeletedAccountManager).getText();
	}
	
	public void deleteAccountManager() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(deleteOptionForAccountManager);
		Thread.sleep(1000);
		driver.findElement(deleteOptionForAccountManager).click();
	}
	
	public boolean blockedStateOfAccountManager() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(blockedStateOfAccountManager);
		return driver.findElement(blockedStateOfAccountManager).isDisplayed();
	}
	
	public boolean activeStateOfAccountManager(){
		return driver.findElement(activeStateOfAccountManager).isDisplayed();
	}
	
	public String successMsgOfBlockedAccountManager(){
		return driver.findElement(successMsgOfBlockedAccountManager).getText();
	}
	public String successMsgOfActivatedAccountManager(){
		return driver.findElement(successMsgOfActivatedAccountManager).getText();
	}
	
	public String accountManagerNameOnEditAccountManagerOverlay() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(accountManagerNameOnEditAccountManagerOverlay);
		return driver.findElement(accountManagerNameOnEditAccountManagerOverlay).getText();
	}
	
	public void clickSaveButtonOnEditAccountManagerOverlay(){
		driver.findElement(saveButtonOnEditAccountManagerOverlay).click();
	}
	
	public void clickEditDetailsButtonOfAccountManager() throws InterruptedException{
	    Thread.sleep(2000);
		CommonMethods.explicitWaitForElementVisibility(editDetailsButtonOfAccountManager);
		driver.findElement(editDetailsButtonOfAccountManager).click();
	}
	
	public void changeAccountStatus() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(accountStatus);
		Select listbox=new Select(driver.findElement(accountStatus));
		listbox.selectByVisibleText("Blocked");
	}
	
	public void changeAccountStatusToActive() throws InterruptedException{
		Thread.sleep(1000);
		CommonMethods.explicitWaitForElementVisibility(accountStatus);
		Select listbox=new Select(driver.findElement(accountStatus));
		listbox.selectByVisibleText("Active");
	}
	
 	public int getCurrentBalance(){
 		String balance=driver.findElement(currrentBalance).getAttribute("value");
 		int currentBalance = Integer.parseInt(balance.replaceAll("[^0-9]", ""));
 		return currentBalance;
 	}
 	
	public Boolean visibilityOfProfileTabOnMyAccountPage() throws InterruptedException{
 		return driver.findElement(profileTab).isDisplayed();
 	}
	
	public Boolean visibilityOfSubAccountsTabOnMyAccountPage() throws InterruptedException{
 		return driver.findElement(subAccountsTab).isDisplayed();
 	}
	
	public Boolean visibilityOfManagersTabOnMyAccountPage() throws InterruptedException{
 		return driver.findElement(accountManagersTab).isDisplayed();
 	}
 	
 	public void clickSubAccountsTab() throws InterruptedException{
 		driver.findElement(subAccountsTab).click();
 	}
 	
	public void clickAccountManagersTab() throws InterruptedException{
 		driver.findElement(accountManagersTab).click();
 	}
	
	public int totalAvailableLines() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(totalAvailableLines);
 		String lines= driver.findElement(totalAvailableLines).getText();
 		int avaliableLines = Integer.parseInt(lines.replaceAll("[^0-9]", ""));
 		return avaliableLines;
 	}
	public int getAvailableLines() throws InterruptedException{
 		String lines= driver.findElement(availableLines).getText();
 		int avaliableLines = Integer.parseInt(lines.replaceAll("[^0-9]", ""));
 		return avaliableLines;
 	}
	
	public Boolean availableLinesText(){
		System.out.println("Hiii    "+driver.findElement(availableLinesText).getText());
		String text= driver.findElement(availableLinesText).getText();
		if(text.contains("Available Lines")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void clickAddSubAccountTab() throws InterruptedException{
 		driver.findElement(addSubAccountTab).click();
 	}
	
	public void enterNickNameOnAddSubAccountOverlay(String name) throws InterruptedException{
		String nickName = name;
 		driver.findElement(nickNameFieldOnAddSubAccountOverlay).sendKeys(nickName);
 	}
	
	public void enterMobileOnAddSubAccountOverlay(String number) throws InterruptedException{
		String mobileNumber=number;
 		driver.findElement(mobileNumberFieldOnAddSubAccountOverlay).sendKeys(mobileNumber);
 	}
	
	public void clickQuotaSubAccountOnAddSubAccountOverlay() throws InterruptedException{
 		driver.findElement(quotaSubAccountOnAddSubAccountOverlay).click();
 	}
 	
	public void clickPoolSubAccountOnAddSubAccountOverlay() throws InterruptedException{
 		driver.findElement(poolSubAccountOnAddSubAccountOverlay).click();
 	}
 	
	public Boolean enterMaxMemberLimitValueOnAddSubAccountOverlay(int limit,int totalLines) throws InterruptedException{
		int memberLimit = limit;
		int totalAvailableLines =totalLines;
		String members = Integer.toString(memberLimit);
 		driver.findElement(maxMemberLimitFieldOnAddSubAccountOverlay).sendKeys(members);
		if(memberLimit<=totalAvailableLines){
			return true;
		}
		else{
			return false;
		}
 	}
	
	public Boolean enterTransferAmountValueOnAddSubAccountOverlay(int amount,int balance) throws InterruptedException{
		int tranferAmount = amount;
		int currentBalance =balance;
		String transAmount = Integer.toString(tranferAmount);
 		driver.findElement(transferAmountFieldOnAddSubAccountOverlay).sendKeys(transAmount);
		if(tranferAmount<=currentBalance){
			return true;
		}
		else{
			return false;
		}
 	}
	
	public String maxMemberLimitErrorMsgOnAddSubAccountOverlay() throws InterruptedException{
		return driver.findElement(maxMemberLimitErrorMsg).getText();
 	}
	
	public String transferAmountLimitErrorMsgOnAddSubAccountOverlay() throws InterruptedException{
		return driver.findElement(transferAmountLimitErrorMsg).getText();
 	}
	
	public boolean visibilityOfMaxMemberLimitFieldOnAddSubAccountOverlay() throws InterruptedException{
 		return driver.findElement(maxMemberLimitFieldOnAddSubAccountOverlay).isDisplayed();
 	}
	
	public boolean visibilityOfTransferAmountFieldOnAddSubAccountOverlay() throws InterruptedException{
 		return driver.findElement(transferAmountFieldOnAddSubAccountOverlay).isDisplayed();
 	}
	
	public void clickAddButtonOnAddSubAccountOverlay() throws InterruptedException{
 		driver.findElement(addButtonOnAddSubAccountOverlay).click();
 	}
	
	public void clickCloseButtonOnAddSubAccountOverlay() throws InterruptedException{
 		driver.findElement(closeButtonOnAddSubAccountOverlay).click();
 	}
	
	public void clickCloseMarkOnAddSubAccountOverlay() throws InterruptedException{
 		driver.findElement(closeMarkOnAddSubAccountOverlay).click();
 	}
 	
	public void clickSendInvitationButtonOnAddSubAccountOverlay() throws InterruptedException{
 		driver.findElement(sendInvitationButtonOnAddSubAccountOverlay).click();
 	}
	
	public boolean visibilityOfSendInvitationButtonOnAddSubAccountOverlay() throws InterruptedException{
 		return driver.findElement(sendInvitationButtonOnAddSubAccountOverlay).isDisplayed();
 	}

	public void clickAddAccountManagerTab() throws InterruptedException{
		WebDriverWait wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated((addAccountManagerTab)));
 		driver.findElement(addAccountManagerTab).click();
 	}
 	
	public void enterNickNameOnOverlay(String name) throws InterruptedException{
		String nickName = name;
 		driver.findElement(nickNameFieldOnAddAccountManagerOverlay).sendKeys(nickName);
 	}
	
	public void enterMobileNumberOnOverlay(String number) throws InterruptedException{
		String mobileNumber=number;
 		driver.findElement(mobileNumberFieldOnAddAccountManagerOverlay).sendKeys(mobileNumber);
 	}
 	
	public void clickAddButtonOnAddAccountManagerOverlay() throws InterruptedException{
 		driver.findElement(addButtonOnAddAccountManagerOverlay).click();
 	}
	
	public String accountManagerNameAndNumber() throws InterruptedException{
		Thread.sleep(2000);
		return driver.findElement(accountManagerNameAndNumber).getText();
	}
	
	public void clickSendInvitationButtonOnAddAccountManagerOverlay() throws InterruptedException{
 		driver.findElement(sendInvitationButtonOnAddAccountManagerOverlay).click();
 	}
	
	public boolean visibilityOfSendInvitationButtonOnAddAccountManagerOverlay() throws InterruptedException{
 		return driver.findElement(sendInvitationButtonOnAddAccountManagerOverlay).isDisplayed();
 	}
	
	public boolean visibilityOfAddButtonOnAddAccountManagerOverlay() throws InterruptedException{
 		return driver.findElement(addButtonOnAddAccountManagerOverlay).isDisplayed();
 	}
	
	public void clickCloseButtonOnAddAccountManagerOverlay() throws InterruptedException{
 		driver.findElement(closeButtonOnAddAccountManagerOverlay).click();
 	}
	
	public void clickCloseMarkOnAddAccountManagerOverlay() throws InterruptedException{
 		driver.findElement(closeMarkOnAddAccountManagerOverlay).click();
 	}
	
	public String successMsgWithNameForValidRegistredMobileNumber() throws InterruptedException{
 		return driver.findElement(successMsgWithNameForValidRegistredMobileNumber).getText();
 		//Registered with Uma
 	}
	
	public String successMsgForCreationOfAccountManager() throws InterruptedException{
		Thread.sleep(2000);
 		return driver.findElement(successMsgForCreationOfAccountManager).getText();
 		//Registered with Uma
 	}
	
	public String errorMsgForNonRegisteredMobileNumber() throws InterruptedException{
		WebDriverWait wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated((errorMsgForInvalidRegisteredMobileNumber)));
 		return driver.findElement(errorMsgForInvalidRegisteredMobileNumber).getText();
	}
	
	public void errorMsgForInvalidRegisteredMobileNumberOnSubAccountOverlay() throws InterruptedException{
 		driver.findElement(errorMsgForInvalidRegisteredMobileNumberOnSubAccountOverlay).getText();
	}
	
	public void errorMsgForAlreadyExistSubAccountOnSubAccountOverlay() throws InterruptedException{
 		driver.findElement(errorMsgForInvalidRegisteredMobileNumberOnSubAccountOverlay).getText();
	}
	
	public String unAvailabilityMsgOfAccountManagers() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(unAvailabilityMsgOfAccountManagers);
		return driver.findElement(unAvailabilityMsgOfAccountManagers).getText();
	}
	
	
}
