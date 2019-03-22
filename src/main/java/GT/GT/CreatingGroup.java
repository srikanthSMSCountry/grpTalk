package GT.GT;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CreatingGroup {
  
	private static final TimeUnit SECONDS = null;

	WebDriver driver;
	 
 	By createGrp = By.xpath("//*[@id='createGrpTalk']");
 	By search_box = By.xpath("//*[@placeholder='Search']");
 	By errorMessage = By.xpath("//*[@id='grpCallMobileContacts']");
 	By nameOfUser = By.xpath("//*[@id='profileDetails']/p[1]");
 	By namesOfUsers = By.xpath("//div[@id='grpCallMobileContacts']//div[@class='contacts margin-right-5 margin-bottom-5 ']");
 	By phoneContacts = By.xpath("//*[@id='myTabList']//*[contains(@class,'mobileContacts')]");
 	By selectedUserList = By.xpath("//*[@class='contacts margin-right-5 margin-bottom-5  selected']");
 	By selectedContacts = By.className("selectedContacts");
 	By selectedContactsTab = By.xpath("//*[@id='myTabList']/li[3]/a/span");
 	By errorMsgForMoreNumberOfUsersAdded = By.className("toast-message");
 	By errorMsgWhenWeSubmitStartNowButton = By.className("toast-message");
 	By errorMsgWhenWeSubmitSaveButton = By.xpath("//*[@id='toast-container']");
 	By errorMsgWhenWeSubmitSsheduleButton = By.className("toast-message");
 	By startNowButton = By.id("startNow");
 	By saveButton = By.id("saveGroupCall");
 	By scheduleButton = By.id("schedule");
 	By grpTalkName = By.id("grpTalkName");
 	By overlaySaveGroup = By.id("saveDate");
 	By successMsgWhenWeSubmitoverlaySaveGroup = By.className("toast-message");
 	By createdGrplist = By.xpath("//*[@id='grpDetails']/p[1]");
 	By nameOnMyGrpTalkMainGrid = By.className("CallLogName");
 	By grpUsersDetailsOnMyGrpTalks = By.xpath("//div[@class='row margin-bottom-20']/div/div/div//div/div[2]/p[1]");
 	By usersListFromSelectedContacts=By.xpath("//div[@id='selectedContacts']//div/div[2]/p[1]");
 	By addButtonToCreateWebList = By.className("addNewContact");
 	By NameOfUserOnWebListOverlay = By.id("name");
 	By moblileNumberOfUserOnWebListOverlay = By.id("mobileNumber");
 	By newWebListNameOnWebListOverlay = By.id("newWebList");
 	By saveContactbuttonOnWebListOverlay = By.id("saveContact");
 	By deleteGroupCallbutton = By.id("deleteGroupCall");
 	By successMsgForDeletingSavedGroup = By.className("toast-message");
 	By editGroupCallButton=By.id("editGroupCall");
 	By saveGroupCallButtonOnEditGrpTalk= By.xpath("//*[@class='form-inline']//*[@id='saveGrpCall']");
 	By dialGroupCallButton = By.id("dialGroupCall");
 	By dialGroupCallButtonOnOverlay = By.xpath("//*[@id='dial1']");
 	By dialGroupCallButtonOnOverlayInCreateGrpTalk = By.xpath("//*[@id='dial']");
 	By allMembersTabInGroupCall = By.className("allMembers active");
 	By allMembersCountInGrpCall = By.id("allMembersCount");
 	By onCallTabInGrpCall = By.className("onCall");
 	By onCallCountInGrpCall = By.id("onCallCount");
 	By unMutedTabInGrpCall = By.className("muted");
 	By unMutedCountInGrpCall =By.id("mutedCount");
 	By callEndedTabInGrpCall = By.className("callEnded");
 	By callEndedCountInGrpCall =By.id("callEndedCount");
 	By hangUpAllButtonInGrpCall = By.xpath("//*[@id='hangup']/a/img");
 	By singleHangUpInGrpCall = By.className("singleHangUp");
 	By memberSearchInGrpCall = By.id("memberSearch");
 	By addMemberInGrpCall = By.xpath("//*[@id='addMember']/a/img");
 	By grpTalkGroupInMyGrpTalk=By.xpath("//*[@grpcallname='grpTalk']");
 	By inprgressToBeVisible = By.xpath("//*[@id='liveCallDetails']/table/tbody/tr/td[3]");
 	By inprgressToBeVisibleForSecondUser = By.xpath("//*[@id='liveCallDetails']/table/tbody/tr[2]/td[3]");
 	By dialPadClickToAddNumber =By.id("dialPadClick");
 	By contactsButtonClickToAddMemberInOnGoingCall = By.id("contactsClickPopup");
 	By enterNewNumberForAddingToGroupCall = By.xpath(("//*[@id='number']"));
 	By callButtonAfterEnterNumber =By.xpath("//*[@id='wrapper']/div/div[2]/div[2]/ol/li[15]/p/strong/i");
 	By contactsButtonOnGrpTalk = By.id("contacts-li");
 	By muteDialGroupCallButtonOnOverlay = By.id("muteDialdiv1");
 	By muteDialButtonOnOverlayInCreateGrpTalk = By.id("muteDial");
 	By cancelGroupCallButtonOnOverlay = By.id("cancel");
 	By muteBuutonInGrpCall = By.xpath("//*[@title='UnMute All']");
 	By unMuteBuutonInGrpCall = By.xpath("//*[@title='Mute All']");
 	By userNumber=By.id("phoneNumber+917674965078");
 	By searchBox=By.id("search-input");
 	By contactOfUser=By.id("phoneNumber+914067297232");
 	By selectSpecificCharacterOfContacts = By.xpath("//*[@id='grpCallMobileContacts']/ul/li[4]");
 	By searchInputOnOverlay =By.id("search-input");
 	By addCallButtonOnOverlay =By.id("addCall");
 	By memberToAddInOnGoingCallOnOverlay= By.xpath("//*[@id='grpCallMobileContacts']//*[@id='profileDetails']");
 	By userLogoutButton = By.id("logout");
 	By historyButtonOnMyGrpTalks = By.xpath("//*[@id='reportsTab']/li[3]/a");
 	By historyOfGroupCall = By.xpath("//*[contains(@class,'ui-accordion-header ui-state-default ui-corner-all ui-accordion-icons')]");
 	By loadMoreButtonOnHistory = By.id("more");
 	By grpCallDurationInHistoryTab = By.xpath("//*[@class='ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content-active']/div/div[1]/ul/li[1]");
 	By totalMinuesConsumedByGrpCall = By.xpath("//*[@class='ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content-active']/div/div[1]/ul/li[2]/span");
 	By totalAmountChargedForGrpcall = By.xpath("//*[@class='ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content-active']/div/div[1]/ul/li[3]/span"); 	
 	
 	By onOffSwitchLabelForDialInOnlyOnAdvancedSettings = By.xpath("//*[@for='dialinswitch']");
 	By onOffSwitchLabelForAllowNonMembersOnAdvancedSettings = By.xpath("//*[@for='allownonswitch']");
 	By onOffSwitchLabelForMuteDialOnAdvancedSettings = By.xpath("//*[@for='mutedialswitch']");
 	By onOffSwitchLabelForAssignCallManagerOnAdvancedSettings = By.xpath("//*[@for='assignManagerSchedule']");
 	By searchAndSelectMemberFieldOnOnAdvancedSettings = By.id("txtAssignMangerSchedule");
 	By repeatDaysOnAdvancedSettings = By.xpath("//*[@class='modal-content']//*[@class='btn weekDay']");
 	By repeatDaysOnAdvancedSettingsOverlyInEditGrpTalk = By.xpath("//*[@class='modal-content']//*[@class='btn weekDay']");
 	By repeatDaysOnAdvancedSettingsForSchedule=By.xpath("//*[@class='modal-content']//*[@class='row pull-left']//*[@class='btn weekDay']");
 	By advacedSettingOnEditGrpTalk = By.id("adSettings");
 	By onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk = By.xpath("//*[@for='savedialinswitch']");
 	By onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk = By.xpath("//*[@for='saveallownonswitch']");
 	By onOffSwitchLabelForMuteDialOnAdvancedSettingsInEditGrpTalk = By.xpath("//*[@for='savemutedialswitch']");
 	By onOffSwitchLabelForAssignCallManagerOnAdvancedSettingsInEditGrpTalk = By.xpath("//*[@for='assignManagerEdit']");
 	By onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk = By.xpath("//*[@for='openlineswitch']");
 	By saveButtonOnAdvancedSettingInEditGrpTalk =By.id("okBtn");
 	By dialInMsgForGrpOnMyGrpTalks = By.xpath("//*[@class='pinStrip row']");
 	By scheduleBottonOnAdvancedSettingsOverlayForSchedule = By.id("scheduleDate");
 	By scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule = By.xpath("//*[@id='datefield']");
 	
 	By incrementDatePickerForDay = By.xpath("//*[@class='dtpicker-comp day']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
 	By decrementDatePickerForDay = By.xpath("//*[@class='dtpicker-comp day']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By displayValueOfDayInDatePicker = By.xpath("//*[@class='dtpicker-comp day']//*[@class='dtpicker-compValue']");

 	By incrementDatePickerForMonth = By.xpath("//*[@class='dtpicker-comp month']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
 	By decrementDatePickerForMonth = By.xpath("//*[@class='dtpicker-comp month']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By displayValueOfMonthInDatePicker = By.xpath("//*[@class='dtpicker-comp month']//*[@class='dtpicker-compValue']");

	By incrementDatePickerForYear = By.xpath("//*[@class='dtpicker-comp year']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
 	By decrementDatePickerForYear = By.xpath("//*[@class='dtpicker-comp year']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By displayValueOfYearInDatePicker = By.xpath("//*[@class='dtpicker-comp year']//*[@class='dtpicker-compValue']");

	By incrementDatePickerForHour = By.xpath("//*[@class='dtpicker-comp hour']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
 	By decrementDatePickerForHour = By.xpath("//*[@class='dtpicker-comp hour']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By displayValueOfHourInDatePicker = By.xpath("//*[@class='dtpicker-comp hour']//*[@class='dtpicker-compValue']");

	By incrementDatePickerForMinutes = By.xpath("//*[@class='dtpicker-comp minutes']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
 	By decrementDatePickerForMinutes = By.xpath("//*[@class='dtpicker-comp minutes']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By displayValueOfHourInDateMinutes = By.xpath("//*[@class='dtpicker-comp minutes']//*[@class='dtpicker-compValue']");

	By datePickerSetButtonOnOverlay = By.xpath("//*[@class='dtpicker-button dtpicker-buttonSet']");
	By datePickerClearButtonOnOverlay = By.xpath("//*[@class='dtpicker-button dtpicker-buttonClear']");
	
	By scheduleDateAndTimeFieldOnEditGroupTalkPage = By.xpath("//*[@id='conf_datetime']");
	By dateAndTimeInDatePicker = By.className("dtpicker-value");
	By repeatDaysFiledOnEditGrpTalk = By.id("repeat");
	By setButtonONOverlayOnEditGrpTalk = By.id("setRepeat");
	By scheduleTimeAndRepeateDaysTextOfGroupOnMyGrpTalk = By.xpath("//*[@id='listTitle']/div/div[2]/span");
	By dateAndTimeTextOnOverlay = By.className("dtpicker-value");
	By listOfWebLists = By.xpath("//*[@id='list-group1']//*[@class='list1']//a");
	By specificCharaterContacts = By.xpath("//*[@id='grpCallMobileContacts']//*[@class='contacts margin-right-5 margin-bottom-5 ']//*[@id='profileDetails']/p[1]");
	By scheduleCancleButton = By.id("cancelGroupCall");
	By liveCallButton =By.xpath("//*[@id='date']//label");
	By downloadRecordingButton = By.xpath("//*[@class='margin-bottom-20']//*[@title='Download Recording']");
	By selectedContactFromContactList = By.xpath("//*[@class='contacts margin-right-5 margin-bottom-5  selected']");
	By contactsListOfGroupOnMyGrpTalkPage = By.xpath("//*[@id='membersLists']//*[@id='members']//*[@id='profileDetails']");
	By quickDailButtonofGroupsInMyGrpTalk = By.xpath("//*[@src='images/call-green-border.png']");
	By quickDialButtonOfActiveGroup = By.xpath("//*[@class='list active']//*[@src='images/call-green-border.png']");
	By grpTalkQuickDialButton = By.xpath("//*[@id='grpTalkCallsList']//*[@groupname='grpTalk']//*[@src='images/call-green-border.png']");
	By publicRoomButton = By.xpath("//*[@id='liveCallDetails']//*[@action='private']");
	By privateRoomButton = By.xpath("//*[@id='liveCallDetails']//*[@action='public']");
	By muteAllButtonInUnMutedTab = By.xpath("//*[@id='btnUnmuteAll']");
	By wantsToTalkTab = By.id("handRaiseCount");
	By privateRoomTab = By.id("privateroom");
	By dialAllButtonInCallEndedTab = By.xpath("//*[@id='btnDialAll']");
	By closePrivateRoomButtonInPrivateRoomTab = By.xpath("//*[@id='btnClosePrivate']");
	By unMuteButtonOfIndividualContactInLiveCall = By.xpath("//*[@id='liveCallDetails']//*[@title='Mute']");
	By muteButtonOfIndividualContactInLiveCall = By.xpath("//*[@id='liveCallDetails']//*[@title='UnMute']");
	By hangUpButtonOfIndividualContactInLiveCall = By.xpath("//*[@id='liveCallDetails']//*[@class='singleHangUp']");
	By reDialButtonOfIndividualContactInLiveCall = By.xpath("//*[@id='liveCallDetails']//*[@class='singleRedial']");
	By excelReportDownloadButtonOnHistory = By.id("btnDownlodHistory");
	By footerText = By.className("footer");
	By grpTalkLogo = By.id("logo");
	By groupsTabOnHomePage = By.id("grptalks-li");
	By contactsTabOnHomePage = By.id("contacts-li");
	By accountsTabOnHomePage = By.id("account-li");
	By profileLogo = By.id("imgPath");
	By badButtonOnRateCall = By.xpath("//*[@value='1']");
	By goodButtonOnRateCall = By.xpath("//*[@value='2']");
	By excelentButtonOnRateCall = By.xpath("//*[@value='3']");
	By submitButtonOnRateCall = By.xpath("//*[@id='RateCallSubmit']");
	
	public CreatingGroup(WebDriver driver2){
        this.driver = driver2;
    }
	
	public void submitRateCallByClickingGoodOption() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(goodButtonOnRateCall).click();
		driver.findElement(submitButtonOnRateCall).click();
		Thread.sleep(1000);
	}
	
	public void submitRateCallByClickingBadOption() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(badButtonOnRateCall).click();
		driver.findElement(submitButtonOnRateCall).click();
		Thread.sleep(1000);
	}
	
	public void submitRateCallByClickingExcelentOption() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(excelentButtonOnRateCall).click();
		driver.findElement(submitButtonOnRateCall).click();
		Thread.sleep(1000);
	}
	
	public Boolean grpTalkLogo(){
		return driver.findElement(grpTalkLogo).isDisplayed();
	}
	public Boolean groupsTabOnHomePage(){
		return driver.findElement(groupsTabOnHomePage).isDisplayed();
	}
	public Boolean contactsTabOnHomePage(){
		return driver.findElement(contactsTabOnHomePage).isDisplayed();
	}
	public Boolean accountsTabOnHomePage(){
		return driver.findElement(accountsTabOnHomePage).isDisplayed();
	}
	public Boolean profileLogo(){
		return driver.findElement(profileLogo).isDisplayed();
	}
	
	public String footerText(){
		return driver.findElement(footerText).getText();
	}
	
	public void clickExcelReportDownloadButtonOnHistory() throws InterruptedException{
		driver.findElement(excelReportDownloadButtonOnHistory).click();
		Thread.sleep(5000);
	}
	
	public void clickUnMuteButtonOfIndividualContactInLiveCall() throws InterruptedException{
		List<WebElement> unMuteButtonOfIndividualContactInLiveCal = driver.findElements(unMuteButtonOfIndividualContactInLiveCall) ;
		unMuteButtonOfIndividualContactInLiveCal.get(0).click();
	}
	
	public void clickMuteButtonOfIndividualContactInLiveCall() throws InterruptedException{
		List<WebElement> muteButtonOfIndividualContactInLiveCal = driver.findElements(muteButtonOfIndividualContactInLiveCall) ;
		muteButtonOfIndividualContactInLiveCal.get(0).click();
	}
	
	public boolean visibilityOFHangUpButtonOfIndividualContactInLiveCall() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,hangUpButtonOfIndividualContactInLiveCall);
		return driver.findElement(hangUpButtonOfIndividualContactInLiveCall).isDisplayed() ;
	}
	
	public boolean visibilityOFReDialButtonOfIndividualContactInLiveCall() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,reDialButtonOfIndividualContactInLiveCall);
		return driver.findElement(reDialButtonOfIndividualContactInLiveCall).isDisplayed() ;
	}
	
	
	public boolean visibilityOFPublicRoomButtonInLiveCall() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,publicRoomButton);
		return driver.findElement(publicRoomButton).isDisplayed() ;
	}
	
	public boolean visibilityOFPrivateRoomButtonInLiveCall() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,privateRoomButton);
		return driver.findElement(privateRoomButton).isDisplayed() ;
	}
	
	public boolean visibilityOFMuteButtonOfIndividualContactInLiveCall() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,muteButtonOfIndividualContactInLiveCall);
		return driver.findElement(muteButtonOfIndividualContactInLiveCall).isDisplayed() ;
	}
	
	public boolean visibilityOFUnMuteButtonOfIndividualContactInLiveCall() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,unMuteButtonOfIndividualContactInLiveCall);
		return driver.findElement(unMuteButtonOfIndividualContactInLiveCall).isDisplayed() ;
	}
	
	public void clickhangUpButtonOfIndividualContactInLiveCall() throws InterruptedException{
		List<WebElement> hangUpButtonOfIndividualContactInLiveCal = driver.findElements(hangUpButtonOfIndividualContactInLiveCall) ;
		hangUpButtonOfIndividualContactInLiveCal.get(0).click();
	}
	
	public void clickreDialButtonOfIndividualContactInLiveCall() throws InterruptedException{
		List<WebElement> reDialButtonOfIndividualContactInLiveCal = driver.findElements(reDialButtonOfIndividualContactInLiveCall) ;
		reDialButtonOfIndividualContactInLiveCal.get(0).click();
		Thread.sleep(10000);
	}
	
	public boolean visibilityOfClosePrivateRoomButtonInPrivateRoomTab() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,closePrivateRoomButtonInPrivateRoomTab);
		return driver.findElement(closePrivateRoomButtonInPrivateRoomTab).isDisplayed();
	}
	
	public void clickPrivateRoomButton() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,privateRoomButton);
		List<WebElement> listOfPrivateRoomButtonsContacts = driver.findElements(privateRoomButton) ;
		listOfPrivateRoomButtonsContacts.get(0).click();
	}
	
	public void clickPublicRoomButtonOfContact() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,publicRoomButton);
		List<WebElement> listOfPublicRoomButtonsContacts = driver.findElements(publicRoomButton) ;
		listOfPublicRoomButtonsContacts.get(0).click();
	}
	
	public void clickClosePrivateRoomButtonInPrivateRoomTab() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,closePrivateRoomButtonInPrivateRoomTab);
		driver.findElement(closePrivateRoomButtonInPrivateRoomTab).click();
	}
	
 	public int privateRoomMembersCountInGrpCall() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,privateRoomTab);
 		driver.findElement(privateRoomTab).click();
 		String count_all_members = driver.findElement(privateRoomTab).getText();
 		int i = Integer.parseInt(count_all_members.replaceAll("[^0-9]", ""));
 		return i;
 		
 	}
	
	public void clickMuteAllButtonInUnMutedTab() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,muteAllButtonInUnMutedTab);
		driver.findElement(muteAllButtonInUnMutedTab).isDisplayed();
		driver.findElement(muteAllButtonInUnMutedTab).click();
	}
	
	public void clickDialAllButtonInCallEndedTab() throws InterruptedException{
		driver.findElement(dialAllButtonInCallEndedTab).isDisplayed();
		driver.findElement(dialAllButtonInCallEndedTab).click();
		Thread.sleep(15000);
	}
	
	public void quickDialButtonOfActiveGroup() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,quickDialButtonOfActiveGroup);
		driver.findElement(quickDialButtonOfActiveGroup).click();
	}
	
	public void clickQuickDailButtonofGroupsInMyGrpTalk() throws InterruptedException{
//	    	int i=0;
//	    	Utility.explicitWaitForElementVisibility(driver,quickDailButtonofGroupsInMyGrpTalk);
//	    	List<WebElement> listofQuickDailButtons = driver.findElements(quickDailButtonofGroupsInMyGrpTalk);
//	    	for(WebElement dial: listofQuickDailButtons){
//	    		Actions actions=new Actions(driver);
//		 		actions.moveToElement(dial);
//		 		actions.perform();
//	    		if(i==2){
//	    			dial.click();
//	    			break;
//	    		}
//	    		i++;
//	    	}
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(grpTalkQuickDialButton));
 		actions.perform();
		driver.findElement(grpTalkQuickDialButton).click();
		Thread.sleep(2000);
	    }
	
	
	public int contactsListOfGroupOnMyGrpTalkPage() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,contactsListOfGroupOnMyGrpTalkPage);
    	List<WebElement> listofUsersInGroup = driver.findElements(contactsListOfGroupOnMyGrpTalkPage);
    	return listofUsersInGroup.size(); 
	}
	
	public void closeLiveGroupCallOfRecentlySavedGrpTalkGroup() throws InterruptedException{
		String liveOption= driver.findElement(liveCallButton).getText();
		if(liveOption.contains("Live")){
			driver.findElement(liveCallButton).click();
 			hangUpCurrentGrpTalkcall();
 			System.out.println("successfully closed LiveGroupCallOfRecentlySavedGrpTalkGroup");
		}
   	}
    
	public boolean scheduleCancleButton() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,scheduleCancleButton);
		return driver.findElement(scheduleCancleButton).isDisplayed();
	}
	
	public boolean listNameInWebLists(String newWebList) throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,listOfWebLists);
	    	String ss=newWebList;
	    	int i=0;
	    	List<WebElement> listofUsersInGroup = driver.findElements(listOfWebLists);
	    	for(WebElement list: listofUsersInGroup){
	    		Actions actions=new Actions(driver);
		 		actions.moveToElement(list);
		 		actions.perform();
	    		if(list.getText().contains(ss)){
	    			i++;
	    			break;
	    		}
	    	}
	    	if(i>0)
	    		return true;
	    	else
	    	{
	    		return false;
	    	}
    }
	
	//select Recently Created WebList
    public void selectRecentlyCreatedWebList() throws InterruptedException{
    	List<WebElement> listofWebLists = driver.findElements(listOfWebLists);
    	for(WebElement list: listofWebLists){
      		Actions actions=new Actions(driver);
    	 		actions.moveToElement(list);
    	 		actions.perform();
    	 		if(list.getText().contains(listName)){
    			list.click();
    			break;
    		}
    	}
    }
    
 	public void decrementDateAndTimeOnOverlay(int value) throws InterruptedException{
 		decrementDatePickerForYear(value);
 		decrementDatePickerForMonth(value);
 		decrementDatePickerForDay(value);
 		decrementDatePickerForMinutes(value);
 		decrementDatePickerForHour(value);
 	}
 	
	public void incrementDateAndTimeOnOverlay(int value) throws InterruptedException{
 		incrementDatePickerForDay(value);
 		incrementDatePickerForMonth(value);
 		incrementDatePickerForYear(value);
 		incrementDatePickerForHour(value);
 		incrementDatePickerForMinutes(value);
 	}
 	public void decrementDatePickerForDay(int days) throws InterruptedException{
 		for(int i=0;i<days;i++){
 			driver.findElement(decrementDatePickerForDay).click();
 		}
 	}
 	
 	public void decrementDatePickerForMonth(int month) throws InterruptedException{
 		for(int i=0;i<month;i++){
 			driver.findElement(decrementDatePickerForMonth).click();
 		}
 	}
 	
 	public void decrementDatePickerForYear(int year) throws InterruptedException{
 		for(int i=0;i<year;i++){
 			driver.findElement(decrementDatePickerForYear).click();
 		}
 	}
 	
 	public void decrementDatePickerForHour(int hours) throws InterruptedException{
 		for(int i=0;i<hours;i++){
 			driver.findElement(decrementDatePickerForHour).click();
 		}
 	}
 	public void decrementDatePickerForMinutes(int minutes) throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,decrementDatePickerForMinutes);
 		for(int i=0;i<minutes;i++){
 			driver.findElement(decrementDatePickerForMinutes).click();
 		}
 	}
 	
 	public void incrementDatePickerForDay(int days) throws InterruptedException{
 		for(int i=0;i<days;i++){
 			driver.findElement(incrementDatePickerForDay).click();
 		}
 	}
 	
 	public void incrementDatePickerForMonth(int month) throws InterruptedException{
 		for(int i=0;i<month;i++){
 			driver.findElement(incrementDatePickerForMonth).click();
 		}
 	}
 	
 	public void incrementDatePickerForYear(int year) throws InterruptedException{
 		for(int i=0;i<year;i++){
 			driver.findElement(incrementDatePickerForYear).click();
 		}
 	}
 	
 	public void incrementDatePickerForHour(int hours) throws InterruptedException{
 		for(int i=0;i<hours;i++){
 			driver.findElement(incrementDatePickerForHour).click();
 		}
 	}
 	public void incrementDatePickerForMinutes(int minutes) throws InterruptedException{
 		for(int i=0;i<minutes;i++){
 			driver.findElement(incrementDatePickerForMinutes).click();
 		}
 	}
 	
 	public String dateAndTimeTextOnOverlay() throws InterruptedException{
 		String s=driver.findElement(dateAndTimeTextOnOverlay).getText();
 		return s;
 	}
 	
 	public String scheduleRepeateDaysTextOfGroupOnMyGrpTalk() throws InterruptedException{
 		String dateTimeAndRepeateDays=driver.findElement(scheduleTimeAndRepeateDaysTextOfGroupOnMyGrpTalk).getText();
 		dateTimeAndRepeateDays.replaceAll(" ", "");
 		String repeatDays = dateTimeAndRepeateDays.substring(dateTimeAndRepeateDays.indexOf("-")+1);
 		repeatDays.trim();
 		return repeatDays;
 	}
 	public String scheduleTimeAndRepeateDaysTextOfGroupOnMyGrpTalk() throws InterruptedException{
 		String dateTimeAndRepeateDays=driver.findElement(scheduleTimeAndRepeateDaysTextOfGroupOnMyGrpTalk).getText();
 		System.out.println(dateTimeAndRepeateDays);
 		return dateTimeAndRepeateDays;
 	}
 	
 	public void setButtonONOverlayOnEditGrpTalk() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,setButtonONOverlayOnEditGrpTalk);
 		driver.findElement(setButtonONOverlayOnEditGrpTalk).click();
 	}
 	
 	public void clickRepeatDaysFiledOnEditGrpTalk() throws InterruptedException{
 		Thread.sleep(2000);
 		driver.findElement(repeatDaysFiledOnEditGrpTalk).click();
 	}
 	
 	public void clickScheduleDateAndTimeFieldOnEditGroupTalkPage() throws InterruptedException{
 		Thread.sleep(2000);
 		driver.findElement(scheduleDateAndTimeFieldOnEditGroupTalkPage).click();
 	}
 	
 	public void datePickerSetButtonOnOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,datePickerSetButtonOnOverlay);
 		driver.findElement(datePickerSetButtonOnOverlay).click();
 	}
 	
 	public void scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule);
 		driver.findElement(scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule).click();
 	}
 	
 	public String repeatDaysOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		Actions actions=new Actions(driver);
 		Utility.explicitWaitForElementVisibility(driver,repeatDaysOnAdvancedSettings);
 		List<WebElement> element=driver.findElements(repeatDaysOnAdvancedSettings);
 		actions.moveToElement(element.get(2));
 		element.get(2).click();
 		String s=" "+element.get(2).getText();
 		return s;
 		
 	}
 	
 	public String repeatDaysOnAdvancedSettingsOverlayForScheduleInEditGrpTalk() throws InterruptedException{
 		Actions actions=new Actions(driver);
 		List<WebElement> element=driver.findElements(repeatDaysOnAdvancedSettingsOverlyInEditGrpTalk);
 		actions.moveToElement(element.get(2));
 		element.get(2).click();
 		String s=" "+element.get(2).getText();
 		return s;
 		
 	}
 	
 	public void selectAllRepeatDaysOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		Actions actions=new Actions(driver);
 		List<WebElement> allDays=driver.findElements(repeatDaysOnAdvancedSettingsForSchedule);
 		for (int i=0;i<allDays.size();i++){
 			Thread.sleep(1000);
 			actions.moveToElement(allDays.get(i));
 			actions.perform();
 			allDays.get(i).click();
 		}
 	}
 	
 	public void clickScheduleButtonOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		Thread.sleep(2000);
 		//Utility.explicitWaitForElementVisibility(driver,scheduleBottonOnAdvancedSettingsOverlayForSchedule);
 		driver.findElement(scheduleBottonOnAdvancedSettingsOverlayForSchedule).click();
 	}
 	
 	public void onOffSwitchLabelForDialInOnlyOptionOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,onOffSwitchLabelForDialInOnlyOnAdvancedSettings);
 		driver.findElement(onOffSwitchLabelForDialInOnlyOnAdvancedSettings).click();
 	}
 	
 	public void onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,onOffSwitchLabelForAllowNonMembersOnAdvancedSettings);
 		driver.findElement(onOffSwitchLabelForAllowNonMembersOnAdvancedSettings).click();
 	}
 	
 	public void onOffSwitchLabelForMuteDialOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,onOffSwitchLabelForAllowNonMembersOnAdvancedSettings);
 		driver.findElement(onOffSwitchLabelForMuteDialOnAdvancedSettings).click();
 	}
 	
 	public void onOffSwitchLabelForAssignCallManagerOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		Thread.sleep(2000);
 		//Utility.explicitWaitForElementVisibility(driver,onOffSwitchLabelForAssignCallManagerOnAdvancedSettings);
		driver.findElement(onOffSwitchLabelForAssignCallManagerOnAdvancedSettings).click();
 	}
 	
 	//group Total DialOut Mins On History
 	public int groupTotalDialOutMinsOnHistory() throws InterruptedException{
 		 List<WebElement> column = driver.findElements(By.xpath("//*[contains(@class,'ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content-activ')]//table/tbody/tr/td[3]"));
 		  int count=0;
 		  int row_num=1;
 		  for (WebElement tdElement : column ) 
 		  {
 		        String s=tdElement.getText();
 		        Integer i= Integer.parseInt(s);
 		        count = count+i;
 		  }
 		 return count  ;
 	}
 	
	//Total amount charged for group On History
 	public double totalAmountChargedForGroupOnHistory() throws InterruptedException{
 		 List<WebElement> column = driver.findElements(By.xpath("//*[contains(@class,'ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content-activ')]//table/tbody/tr/td[4]"));
 		  double count=0;
 		  int row_num=1;
 		  for (WebElement tdElement : column ) 
 		  {
 		        String s=tdElement.getText();
 		        Double i= Double.parseDouble(s);
 		        count = count+i;
 		  }
 		 return count  ;
 	}
 	// total amount charged for grp call
 	public double totalAmountChargedForGrpcall() throws InterruptedException{
 		Thread.sleep(2000);
 		String s= driver.findElement(totalAmountChargedForGrpcall).getText();
 		String intValue = s.replaceAll("[^0-9]", "");
 	 	Double i = Double.parseDouble(intValue);
    	return i/1000;
 	}
 	public String totalAmountChargedForGrpcall1() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,totalAmountChargedForGrpcall);
 		String s = driver.findElement(totalAmountChargedForGrpcall).getText();
 		String value = s.replaceAll("INR ", "");
 		return value;
 	}
 	
 	// total Minues Consumed In GrpCall displayed on history tab
 	public int totalMinutesConsumedInGrpCall() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,totalMinuesConsumedByGrpCall);
 		String s=driver.findElement(totalMinuesConsumedByGrpCall).getText();
 		Integer i=Integer.parseInt(s);
 		return i;
 	}
 	
 	//grpCall Duration displayed In History Tab
 	public void grpCallDurationInHistoryTab() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,grpCallDurationInHistoryTab);
 		System.out.println(driver.findElement(grpCallDurationInHistoryTab).getText());
 	}
 	
 	//history Button On MyGrpTalks
 	public void historyButtonOnMyGrpTalks() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,historyButtonOnMyGrpTalks);
 		driver.findElement(historyButtonOnMyGrpTalks).click();
 	}
 	
 	By countOfCallsInHistory=By.xpath("//*[@id='membersLists']//*[@id='accordion']//*[contains(@class, 'ui-accordion-header ui-state-default ui')]");
 	By callDatesInHistory = By.xpath("//*[@id='membersLists']//*[@class='col-md-4 text-left']");
 	
 	public int countOfCallsByGroupInHistory(){
 		Utility.explicitWaitForElementVisibility(driver,countOfCallsInHistory);
 		return driver.findElements(countOfCallsInHistory).size();
 	}
 	
 	public boolean callDatesInHistory() throws InterruptedException{
 		Thread.sleep(2000);
 		List<WebElement> callDatesInHistoryPage=driver.findElements(callDatesInHistory);
 		int i=0;
    	for(WebElement callDate: callDatesInHistoryPage){
    		Actions actions=new Actions(driver);
	 		actions.moveToElement(callDate);
	 		actions.perform();
    		if(callDate.getText().contains("Today")){
    			i++;
    		}
    	}
    	if(i==1){
    		return true;
    	}
    	else{
    		return false;
    	}
 	}
 	
 	public void visibilityOfHistoryButton(){
 		try{
 			WebDriverWait wait=new WebDriverWait(driver, 360);
 	 		wait.until(ExpectedConditions.visibilityOfElementLocated(historyButtonOnMyGrpTalks));
 		}
 		catch (ElementNotVisibleException e) {
			System.out.println(e);
		}
 	}
 	
 	public static String currentDateValue(){
 		Calendar cal = Calendar.getInstance();
 		int year = cal.get(Calendar.YEAR);
 		String month = new SimpleDateFormat("MMM").format(cal.getTime());
 		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
 	    Date date = calendar.getTime();
 	    int day = calendar.get(Calendar.DATE); 	
 	    return month+day+year;
 	}
 	
 	public void downloadRecordingCallHistory() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,downloadRecordingButton);
 		driver.findElement(downloadRecordingButton).click();
 		Thread.sleep(10000);
 		}
 	
 	//Verify history of Group call
 	public void historyOfGroupCall() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,historyOfGroupCall);
 		driver.findElement(historyOfGroupCall).click();
 	}
 	
 	//Click user logout button
 	public void userLogOutButton() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,userLogoutButton);
 		driver.findElement(userLogoutButton).click();
 	}
 	
 	//Click on create group button
    public void clickCreateGrpButton() throws InterruptedException{
    	Thread.sleep(2000);
       	driver.findElement(createGrp).click();
    }
    
    //Click on search box to search contacts
    public void enterNameInSearchBox(String str) throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,search_box);
    	String name = str;
    	driver.findElement(search_box).clear();
       	driver.findElement(search_box).sendKeys(name);
       	Thread.sleep(2000);
    }
    
    //Click on phone contacts tab
    public void clickPhoneContactsTab() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,phoneContacts);
    	driver.findElement(phoneContacts).click();
    	Thread.sleep(1000);
    }
    
    //select Specific Character Of Contacts
    public int selectSpecificCharacterOfContacts() throws InterruptedException{
    	Thread.sleep(2000);
    	driver.findElement(selectSpecificCharacterOfContacts).click();
    	Thread.sleep(1000);
    	List<WebElement> ele= driver.findElements(specificCharaterContacts);
    	int s=ele.size();
    	return s;
    }
    
    public boolean verifyContactsStartsWithSpecialCharacters() throws InterruptedException{
    	List<WebElement> ele= driver.findElements(specificCharaterContacts);
    	int x=0;
    	for (WebElement s: ele){
    		String string=s.getText();
    		char c = string.charAt(0);
        	if (c != 'C'){
        		x++;
        	}
    	}
    	if(x==0){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    //Verify error message when user enters name which is not exist in contact list
    public String errorMessageWhenUserEntersNameWHichisNotExistinContactList() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,errorMessage);
    	return driver.findElement(errorMessage).getText();
    }
    
    //Retrieving Name of the user from contact list
    public String nameofUser() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,nameOfUser);
    	return driver.findElement(nameOfUser).getText();
    }
    
    //Retrieving number of users from contact list
    public int numberOfContactsInPhoneContactsTab() throws InterruptedException{
    	Thread.sleep(2000);
    	List<WebElement> listofUsers = driver.findElements(namesOfUsers);
    	return listofUsers.size();
    	
    }
    
    //Return list of users from contact list
    public List<WebElement> listOfUsers() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,namesOfUsers);
    	List<WebElement> listofUsers = driver.findElements(namesOfUsers);
    	return listofUsers;
    }

    public int selectedContactFromContactList() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,selectedContactFromContactList);
    	List<WebElement> listofUsers= driver.findElements(selectedContactFromContactList);
    	return listofUsers.size();
    }
    
    //select contact user in contact list
    public void selectContactFromContactList() throws InterruptedException{
    	driver.findElement(search_box).clear();
       	driver.findElement(search_box).sendKeys("TestContact1");
       	List<WebElement> ele=listOfUsers();
       	ele.get(0).click();
    }
    
    //select contact user in contact list
    public void selectContactsFromContactList() throws InterruptedException{
    	driver.findElement(search_box).clear();
       	driver.findElement(search_box).sendKeys("TestContact2");
       	List<WebElement> ele=listOfUsers();
       	ele.get(0).click();
    	driver.findElement(search_box).clear();
       	driver.findElement(search_box).sendKeys("TestContact1");
       	List<WebElement> contact2=listOfUsers();
       	contact2.get(0).click();
    }
    
    //select Test contacts from contact list
    public void selectTestContactsFromContactList() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,search_box);
    	Thread.sleep(1000);
    	driver.findElement(search_box).clear();
       	driver.findElement(search_box).sendKeys("TestContact");
       	Thread.sleep(3000);
       	List<WebElement> ele=listOfUsers();
       	for(int i=0;i<ele.size();i++){
       		Thread.sleep(1000);
       		ele.get(i).click();
       	}
    }
    
    //select 2nd user in contact list
    public void selectSecondUserFromContactList() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,searchBox);
    	driver.findElement(searchBox).sendKeys("TestContact2");
    	Utility.explicitWaitForElementVisibility(driver,contactOfUser);
    	Thread.sleep(1000);
    	driver.findElement(contactOfUser).click();
    }
    
    //Click on selected contacts tab
    public void selectedContactsTab() throws InterruptedException
    {
    	Utility.explicitWaitForElementVisibility(driver,selectedContacts);
    	driver.findElement(selectedContacts).click();
    }
    
    //Verify count of selected users in phone contacts 
    public int selectedUserCount() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,selectedUserList);
    	List<WebElement> listofUsers = driver.findElements(selectedUserList);
    	return listofUsers.size();
    }
    
    //Verify number of users selected from contacts
    public int numberOfUsersFromSelectedContactsTab() throws InterruptedException
    {
    	String str = driver.findElement(selectedContactsTab).getText();
    	String intValue = str.replaceAll("[^0-9]", "");
    	Integer i = Integer.parseInt(intValue);
    	return i;
    	
    }
    
    //Add more number of users than maximum(9) number of user in contact list
    public String addMorethanNineUserFromContactList() throws InterruptedException{
    	List<WebElement> ele=listOfUsers();
    	int i;
    	Actions actions= new Actions(driver);
       	for(i=0;i<9;i++)
    	{
       		actions.moveToElement(ele.get(i));
     		actions.perform();
    		ele.get(i).click();
    	}
    System.out.println(numberOfUsersFromSelectedContactsTab());	
    clickPhoneContactsTab();
    	actions.moveToElement(ele.get(i++));
 		actions.perform();
    	ele.get(i++).click();
     	return ele.get(0).getAttribute("name");
    }
    
    // Error massage for adding more number of contacts 
    public String errorMsgonAddingMoreNumberOfContacts() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,errorMsgForMoreNumberOfUsersAdded);
    	return driver.findElement(errorMsgForMoreNumberOfUsersAdded).getText();
    }
    
    // Error massage when we submit start now button without selecting any phone contacts 
    public String errorMsgWhenWeSubmitStartNowButtonWithOutSelectingAnyPhoneContacts() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,errorMsgWhenWeSubmitStartNowButton);
    	return driver.findElement(errorMsgWhenWeSubmitStartNowButton).getText();
    }
    
    // Error massage when we submit save button without selecting any phone contacts 
    public String errorMsgWhenWeSubmitSaveButtonWithOutSelectingAnyPhoneContacts() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,errorMsgWhenWeSubmitSaveButton);
    	return driver.findElement(errorMsgWhenWeSubmitSaveButton).getText();
    }
    
    // Error massage when we submit Schedule button without selecting any phone contacts 
    public String errorMsgWhenWeSubmitScheduleButtonWithOutSelectingAnyPhoneContacts() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,errorMsgWhenWeSubmitSsheduleButton);
    	return driver.findElement(errorMsgWhenWeSubmitSsheduleButton).getText();
    }
    
    //Submit start Now Button 
    public void submitStartNowButton() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,startNowButton);
    	driver.findElement(startNowButton).click();
    	Thread.sleep(2000);
    }
    
    //Submit save Button 
    public void submitSaveButton() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,saveButton);
    	driver.findElement(saveButton).click();
    }
    
    //Submit schedule Button 
    public void submitScheduleButton() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,scheduleButton);
    	driver.findElement(scheduleButton).click();
    }
    
    // Clear Grp talk name in field
    public void clearGrpTalkName() throws InterruptedException{
    	driver.findElement(grpTalkName).clear();
    }
    
    // Error massage when we submit start now button without Giving Any Grp Name 
    public String errorMsgWhenWeSubmitStartNowButtonWithOutGivingAnyGrpName() throws InterruptedException{
    	return driver.findElement(errorMsgWhenWeSubmitStartNowButton).getText();
    }
    // Error massage when we submit save button without Giving Any Grp Name 
    public String errorMsgWhenWeSubmitSaveButtonWithOutGivingAnyGrpName() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,errorMsgWhenWeSubmitSaveButton);
    	return driver.findElement(errorMsgWhenWeSubmitSaveButton).getText();
    }
    
    // Error massage when we submit Schedule button without Giving Any Grp Name 
    public String errorMsgWhenWeSubmitScheduleButtonWithOutGivingAnyGrpName() throws InterruptedException{
    	Utility.explicitWaitForElementVisibility(driver,errorMsgWhenWeSubmitSsheduleButton);
    	return driver.findElement(errorMsgWhenWeSubmitSsheduleButton).getText();
    }
    
    String name = "Test_"+System.currentTimeMillis();
    
    // Set Grp talk name in field
    public String setGrpTalkName() throws InterruptedException{
    	driver.findElement(grpTalkName).clear(); 
    	driver.findElement(grpTalkName).sendKeys(name);
    	return name;
    }
    
    //Retrieving Grp talk name
    public String retrievingNameOfCreatedGrpTalk() throws InterruptedException{
    	return name;
    }

    //Click on Save group button on new window/overlay
    public void submitSaveGroupOnOverlay() throws InterruptedException{
    	Utility.explicitWaitForClickableElement(driver,driver.findElement(overlaySaveGroup));
    	driver.findElement(overlaySaveGroup).click();
    }
    
    // Success massage when we submit Save group button on overlay
    public String successMsgWhenWeSubmitSaveGroupButtonOnOverlay() throws InterruptedException{
    	return driver.findElement(successMsgWhenWeSubmitoverlaySaveGroup).getText();
    }
    
    //Verify and Select recently saved group
    public void selectRecentlySavedGrpTalkGroup() throws InterruptedException{
    	String ss=name;
    	Thread.sleep(1000);
    	List<WebElement> listofGrpnames = driver.findElements(createdGrplist);
    	for(WebElement names: listofGrpnames){
    		Actions actions=new Actions(driver);
	 		actions.moveToElement(names);
	 		actions.perform();
    		if(names.getText().contains(ss)){
    			Thread.sleep(1000);
    			names.click();
    			Thread.sleep(1000);
    			break;
    		}
    	}
    }
    
    //Verify the presence of given group
    public boolean presenceOfGroupByGivenName(String groupName) throws InterruptedException{
    	String ss=groupName;
    	int i=0;
    	List<WebElement> listofUsersInGroup = driver.findElements(createdGrplist);
    	for(WebElement user: listofUsersInGroup){
    		if(user.getText().equalsIgnoreCase(ss)){
    			i++;
    		}
    	}
    	if(i>0)
    		return true;
    	else
    		return false;
    }
    
    // Select saved group by using group name
    public void selectSavedGroupByName(String grpName) throws InterruptedException{
    	String savedGrpName=grpName;
    	Utility.explicitWaitForElementVisibility(driver,createdGrplist);
    	List<WebElement> listofUsersInGroup = driver.findElements(createdGrplist);
    	for(WebElement user: listofUsersInGroup){
    		Actions actions=new Actions(driver);
	 		actions.moveToElement(user);
	 		actions.perform();
    		if(user.getText().equalsIgnoreCase(savedGrpName)){
    			Thread.sleep(1000);
    			user.click();
    			break;
    		}
    	}
    }
    
    //Get name on MyGrp Talk main grid
    public String nameOnMyGrpTalkMainGrid() throws InterruptedException{
        return driver.findElement(nameOnMyGrpTalkMainGrid).getText();
    }
    
    //List of selected group users on My grp talk page
    public List<String> listOfGroupContactsOnMyGrpTalkPage() throws InterruptedException{
       	List<String> expectedResult = new ArrayList<String>();
    	List<WebElement> expectedAllUsers = driver.findElements(grpUsersDetailsOnMyGrpTalks);
    	for (int i=0; i<expectedAllUsers.size(); i++){
    		expectedResult.add(expectedAllUsers.get(i).getText());
    	}
    	expectedResult.remove(0);
     	return expectedResult;
    }
    
    //List of selected group users from selected Contacts
    public List<String> ListOfGroupContactsFromSelectedContacts() throws InterruptedException{
    	List<String> actualResult = new ArrayList<String>();
    	List<WebElement> allUsers = driver.findElements(usersListFromSelectedContacts);
    	for (int j=0; j<allUsers.size(); j++){
    	  actualResult.add(allUsers.get(j).getText());
    	}    
    	return actualResult;
    }
    
    String listName = "List "+System.currentTimeMillis();
    
	//Create New Web List
 	public String createWebLIst() throws InterruptedException{
 		String listName = "List "+System.currentTimeMillis();
 		driver.findElement(addButtonToCreateWebList).click();
 		driver.findElement(NameOfUserOnWebListOverlay).sendKeys("grpTalk");
 		driver.findElement(moblileNumberOfUserOnWebListOverlay).sendKeys("9550866282");
 		driver.findElement(newWebListNameOnWebListOverlay).sendKeys(listName);
 		driver.findElement(saveContactbuttonOnWebListOverlay).click();
 		driver.navigate().refresh();
 		return listName;
 	}
    
 	public void deleteSavedGroupCall() throws InterruptedException{
 		driver.findElement(deleteGroupCallbutton).click();
 		driver.switchTo().alert().accept();
 	}
 	
 	public void deleteSavedGrp() throws InterruptedException{
    	List<WebElement> listofGrpnames = driver.findElements(By.xpath("//*[contains(@grpcallname,'Test_')]"));
    	Actions actions=new Actions(driver);
    	for(WebElement names: listofGrpnames){
    	 		actions.moveToElement(names);
    	 		actions.perform();
       			names.click();
   				driver.findElement(deleteGroupCallbutton).click();
   		 		driver.switchTo().alert().accept();
    	}
    	System.out.println("successfully deleted saved Grp");
    }

 	
	public void closeLiveGroupCallOfRecentlySavedGrpTalkGroup1() throws InterruptedException{
		List<WebElement> listofGrpnames = driver.findElements(liveCallButton);
		for(WebElement names: listofGrpnames){
    		Actions actions=new Actions(driver);
	 		actions.moveToElement(names);
	 		actions.perform();
	 		String liveOption= names.getText();
	 		if(liveOption.contains("Live")){
	 			names.click();
	 			hangUpCurrentGrpTalkcall();
	 		}
		}
		System.out.println("successfully hangUp live GrpCall");
   	}
 	
 	public String successMsgForDeletingSavedGroup() throws InterruptedException{
 		return driver.findElement(successMsgForDeletingSavedGroup).getText(); 
 	}
 	
 	public int editSavedGroupCall() throws InterruptedException{
 		driver.findElement(editGroupCallButton).click();
 		Utility.explicitWaitForAlert(driver);
 		driver.switchTo().alert().accept();
 		clickPhoneContactsTab();
 		selectSecondUserFromContactList();
 		int selectedUsersCount=selectedUserCount();
 		selectedContactsTab();
 		int x= numberOfUsersFromSelectedContactsTab();
 		driver.findElement(saveGroupCallButtonOnEditGrpTalk).click();
 		selectRecentlySavedGrpTalkGroup();
 		return x;
 	}
 	
 	public int removeContactFromSavedGroup() throws InterruptedException{
 		driver.findElement(editGroupCallButton).click();
 		Utility.explicitWaitForAlert(driver);
 		driver.switchTo().alert().accept();
 		selectedContactsTab();
 		List<WebElement> contacts = driver.findElements(usersListFromSelectedContacts);
       	contacts.get(0).click();
 		int x= numberOfUsersFromSelectedContactsTab();
 		driver.findElement(saveGroupCallButtonOnEditGrpTalk).click();
 		selectRecentlySavedGrpTalkGroup();
 		return x;
 	}
 	
 	//click edit button on my grpp talks
 	public void clickEditButtonOnMyGrpTalksPage() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,editGroupCallButton);
 		driver.findElement(editGroupCallButton).click();
 		driver.switchTo().alert().accept();
 	}
 	
  	public void clickAdvacedSettingOnEditGrpTalk() throws InterruptedException{
  		Utility.explicitWaitForElementVisibility(driver,advacedSettingOnEditGrpTalk);
 		driver.findElement(advacedSettingOnEditGrpTalk).click();
 	}
  	
  	public void onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk() throws InterruptedException{
  		Utility.explicitWaitForElementVisibility(driver,onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk);
  		WebElement ele = driver.findElement(onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk);
  		String s = ele.getAttribute("content");
  		ele.click();
  	}
  	
  	public void onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk() throws InterruptedException{
  		Utility.explicitWaitForElementVisibility(driver,onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk);
  		driver.findElement(onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk).click();
  	}
  	
  	public void onOffSwitchLabelForMuteDialOnAdvancedSettingsInEditGrpTalk() throws InterruptedException{
  		Utility.explicitWaitForElementVisibility(driver,onOffSwitchLabelForMuteDialOnAdvancedSettingsInEditGrpTalk);
  		driver.findElement(onOffSwitchLabelForMuteDialOnAdvancedSettingsInEditGrpTalk).click();
  	}
  	
  	public void onOffSwitchLabelForAssignCallManagerOnAdvancedSettingsInEditGrpTalk() throws InterruptedException{
  		Utility.explicitWaitForElementVisibility(driver,onOffSwitchLabelForAssignCallManagerOnAdvancedSettingsInEditGrpTalk);
  		driver.findElement(onOffSwitchLabelForAssignCallManagerOnAdvancedSettingsInEditGrpTalk).click();
  	}
  	
  	public void onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk() throws InterruptedException{
  		Thread.sleep(2000);
  		//Utility.explicitWaitForClickableElement(driver,driver.findElement(onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk));
  		driver.findElement(onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk).click();
  	}
  	
	public boolean visibilityOfselectMemberFieldToManageCallOnOverlay() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,searchAndSelectMemberFieldOnOnAdvancedSettings);
  		return driver.findElement(searchAndSelectMemberFieldOnOnAdvancedSettings).isDisplayed();
  	}
	
	By callManagerOptionForContacts = By.xpath("//*[@class='row margin-bottom-20']//*[@alt='call-manager']");
	
	public boolean visibilityOfCallManagerOptionForContacts() throws InterruptedException{
		Thread.sleep(2000);
		//Utility.explicitWaitForElementVisibility(driver,callManagerOptionForContacts);
  		return driver.findElement(callManagerOptionForContacts).isDisplayed();
	}
	
	public void enterContactDetailsInSelectMemberFieldToManageCallOnOverlay() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,searchAndSelectMemberFieldOnOnAdvancedSettings);
		driver.findElement(searchAndSelectMemberFieldOnOnAdvancedSettings).sendKeys("test");
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='ui-menu-item']"));
		list.get(0).click();
	}
	
 	public boolean visibilityOfOnOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettings() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk);
  		return driver.findElement(onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk).isDisplayed();
  		
  	}
  	
  	public void saveButtonOnAdvancedSettingInEditGrpTalk() throws InterruptedException{
  		Utility.explicitWaitForElementVisibility(driver,saveButtonOnAdvancedSettingInEditGrpTalk);
  		driver.findElement(saveButtonOnAdvancedSettingInEditGrpTalk).click();
  	}
  	
  	public void clickSaveGrpCallOnEditGrpTalk() throws InterruptedException{
  		Thread.sleep(2000);
  		Actions actions=new Actions(driver);
  		actions.moveToElement(driver.findElement(saveGroupCallButtonOnEditGrpTalk));
		actions.perform();
  		driver.findElement(saveGroupCallButtonOnEditGrpTalk).click();
  		Thread.sleep(2000);
  	}
  	
  	public String dialInMsgForGrpOnMyGrpTalks() throws InterruptedException{
  		return driver.findElement(dialInMsgForGrpOnMyGrpTalks).getText();
  	}
 	
 	//This method will click on Call button for group
 	public void dialGroupCallButton() throws InterruptedException{
 		driver.findElement(dialGroupCallButton).click();
 	}
 	//This method will click on call button on dialGroupCallButtonOnOverlay
 	public void dialGroupCallButtonOnOverlay() throws InterruptedException{
 		Thread.sleep(2000);
 		driver.findElement(dialGroupCallButtonOnOverlay).click(); 
 		Thread.sleep(25000);
 	}
 	
 	public void dialGroupCallButtonOnOverlayInCreateGrpTalk() throws InterruptedException{
 		driver.findElement(dialGroupCallButtonOnOverlayInCreateGrpTalk).click(); 
 		Thread.sleep(15000);
 	}
 	
 	public void dialGroupCallButtonOnOverlayInCreateGrpTalkForTestContacts() throws InterruptedException{
 		driver.findElement(dialGroupCallButtonOnOverlayInCreateGrpTalk).click(); 
 		Thread.sleep(90000);
 		Thread.sleep(50000);
 		
 	}
 	
 	public void dialGroupCallButtonOnOverlayInCreateGrpTalkForTest() throws InterruptedException{
 		driver.findElement(dialGroupCallButtonOnOverlayInCreateGrpTalk).click(); 
 		Thread.sleep(22000);
 		
 	}
 	
 	public int[] dialGroupCall() throws InterruptedException{
 		Thread.sleep(1000);
 		driver.findElement(dialGroupCallButton).click();
 		Thread.sleep(1000);
 		driver.findElement(dialGroupCallButtonOnOverlay).click();
 		Thread.sleep(25000);
 		
 		String stringOfAllMemberCount = driver.findElement(allMembersCountInGrpCall).getText();
    	String allMemebersCount = stringOfAllMemberCount.replaceAll("[^0-9]", "");
    	Integer  valueOfAllMemebersCount= Integer.parseInt(allMemebersCount);
    	
    	String stringOfOnCallCount = driver.findElement(onCallCountInGrpCall).getText();
    	String onCallCount = stringOfOnCallCount.replaceAll("[^0-9]", "");
    	Integer valueOfOnCallCount = Integer.parseInt(onCallCount);
    	
    	String stringOfUnMutedCount = driver.findElement(unMutedCountInGrpCall).getText();
    	String unMutedCount = stringOfUnMutedCount.replaceAll("[^0-9]", "");
    	Integer valueOfOnUnMutedCount = Integer.parseInt(unMutedCount);
    	
    	String stringOfcallEndedCount = driver.findElement(callEndedCountInGrpCall).getText();
    	String callEndedCount = stringOfcallEndedCount.replaceAll("[^0-9]", "");
    	Integer valueOfcallEndedCount = Integer.parseInt(callEndedCount);
    	
    	int[] count = new int[4];
    	count[0] = valueOfAllMemebersCount;
    	count[1] = valueOfOnCallCount;
    	count[2] = valueOfOnUnMutedCount;
    	count[3] = valueOfcallEndedCount;	
    	return count;
 	}
 	
    //"Inprogress" string to be visible
    public void visibleInprogressString(){
    	WebDriverWait wait = new WebDriverWait(driver, 80);
    	wait.until(ExpectedConditions.visibilityOfElementLocated((inprgressToBeVisible)));
    	
    }
    //"Inprogress" string to be visible
    public void visibleInprogressStringForSecondUser(){
    	WebDriverWait wait = new WebDriverWait(driver, 60);
    	wait.until(ExpectedConditions.visibilityOfElementLocated((inprgressToBeVisibleForSecondUser)));
    }
    
    
 	//This method will return count of all members in group call
 	public int allMembersCountInGrpCall() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,allMembersCountInGrpCall);
 		driver.findElement(allMembersCountInGrpCall).click();
 		String count_all_members = driver.findElement(allMembersCountInGrpCall).getText();
 		int i = Integer.parseInt(count_all_members.replaceAll("[^0-9]", ""));
 		return i;
 		
 	}
 	//This method will return count of On Call in group
 	public int onCallCountInGrpCall() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,onCallCountInGrpCall);
 		driver.findElement(onCallCountInGrpCall).click();
 		Utility.explicitWaitForElementVisibility(driver,onCallCountInGrpCall);
 		return Integer.parseInt((driver.findElement(onCallCountInGrpCall).getText()).replaceAll("[^0-9]", ""));
 	
 	}
 	
 	//This method will return unMutedCountInGrpCall
 	public int unMutedCountInGrpCall() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,unMutedCountInGrpCall);
 		driver.findElement(unMutedCountInGrpCall).click();
 		Utility.explicitWaitForElementVisibility(driver,unMutedCountInGrpCall);
 		Thread.sleep(1000);
 		return Integer.parseInt((driver.findElement(unMutedCountInGrpCall).getText()).replaceAll("[^0-9]", ""));
 		
 	}
 	
 	//This method will return callEndedCountInGrpCall
 	public int callEndedCountInGrpCall() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,callEndedCountInGrpCall);
 		driver.findElement(callEndedCountInGrpCall).click();
 		Utility.explicitWaitForElementVisibility(driver,callEndedCountInGrpCall);
 		return Integer.parseInt((driver.findElement(callEndedCountInGrpCall).getText()).replaceAll("[^0-9]", ""));
 	}
 	
 	//Click on grpTalk group to call
 	public void grpTalkGroupInMyGrpTalk() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,grpTalkGroupInMyGrpTalk);
 		driver.findElement(grpTalkGroupInMyGrpTalk).click();
 	}
 	
 	//HangUp the current group call
 	public void hangUpCurrentGrpTalkcall() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,hangUpAllButtonInGrpCall);
 		driver.findElement(hangUpAllButtonInGrpCall).click();
 	}
 	
 	//Add a member in ongoing group call
 	public void addMemberInOnGoingGrpCall() throws InterruptedException{
 		driver.findElement(addMemberInGrpCall).click();
 		Utility.explicitWaitForElementVisibility(driver,dialPadClickToAddNumber);
 		driver.findElement(dialPadClickToAddNumber).click();
 		driver.findElement(enterNewNumberForAddingToGroupCall).sendKeys("4038119607");
 		Thread.sleep(1000);
 		driver.findElement(callButtonAfterEnterNumber).click();
 		Thread.sleep(1000);
 		driver.findElement(onCallTabInGrpCall).click();
 		Thread.sleep(22000);
 		
 	}
 	
 	//Add a member in ongoing group call through contacts
 	public void addMemberInOnGoingCallThroughContacts() throws InterruptedException{
 	 		driver.findElement(addMemberInGrpCall).click();
 	 		Utility.explicitWaitForElementVisibility(driver,contactsButtonClickToAddMemberInOnGoingCall);
 	 		driver.findElement(contactsButtonClickToAddMemberInOnGoingCall).click();
 	 		driver.findElement(searchInputOnOverlay).sendKeys("TestContact2");
 	 		driver.findElement(memberToAddInOnGoingCallOnOverlay).click();
 	 		driver.findElement(addCallButtonOnOverlay).click();
 	 		Thread.sleep(25000);
 	}
 	
 	By WebListTabOnOverlay = By.xpath("//*[@class='contactTab']");
 	
 	public void addMemberInOnGoingCallThroughWebList() throws InterruptedException{
	 		driver.findElement(addMemberInGrpCall).click();
	 		driver.findElement(contactsButtonClickToAddMemberInOnGoingCall).click();
	 		Thread.sleep(2000);
	 		driver.findElement(WebListTabOnOverlay).click();
	 		Thread.sleep(1000);
	 		clicklistGroupInWebListOnOverlay();
	 		addcontactFromWebListGroupOnOverlay();
	 		driver.findElement(addCallButtonOnOverlay).click();
	 		Thread.sleep(25000);
	}
 	
 	By WebListsOnOverlay = By.xpath("//*[@class='contactList1']");
 	public void clicklistGroupInWebListOnOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,WebListsOnOverlay);
		Actions actions=new Actions(driver);
 		List<WebElement> ele=driver.findElements(WebListsOnOverlay);
 		for (WebElement webList : ele ) 
		  {
 			actions.moveToElement(webList);
 			actions.perform();
 			if(webList.getText().contains("TestList")){
    			webList.click();
    			break;
    		}
		  }
 	}
 	
 	By contactsInWeblistOnOverlay = By.xpath("//*[@id='grpCallWebContacts']//*[@id='profileDetails']");
 	
 	public void addcontactFromWebListGroupOnOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,contactsInWeblistOnOverlay);
 		List<WebElement> ele=driver.findElements(contactsInWeblistOnOverlay);
 		ele.get(0).click();
 	}
 	
 	//Click on mute Dial Group Call Button On Overlay
 	public void muteDialGroupCallOnOverlay() throws InterruptedException{
 		driver.findElement(muteDialGroupCallButtonOnOverlay).click();
 		Thread.sleep(20000);
 	}
 	
 	public void clickMuteDialButtonOnOverlayInCreateGrpTalk() throws InterruptedException{
 		driver.findElement(muteDialButtonOnOverlayInCreateGrpTalk).click();
 		Thread.sleep(25000);
 	}
 	
 	//Click on cancel Group Call Button On Overlay
 	public void cancelGroupCallOnOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,cancelGroupCallButtonOnOverlay);
 		driver.findElement(cancelGroupCallButtonOnOverlay).click();
 	}
 	
 	public boolean cancleButtonDisplayedOnCallOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,cancelGroupCallButtonOnOverlay);
 		return driver.findElement(cancelGroupCallButtonOnOverlay).isDisplayed();
 		
 	}
 	
	public boolean muteDialButtonDisplayedOnCallOverlay() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,muteDialGroupCallButtonOnOverlay);
 		return driver.findElement(muteDialGroupCallButtonOnOverlay).isDisplayed();
 		
 	}
	
	public boolean dialGroupButtonDisplayedOnCallOverlay() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,dialGroupCallButtonOnOverlay);
 		return driver.findElement(dialGroupCallButtonOnOverlay).isDisplayed();
 		
 	}
	
 	
 	//visibility Of Dial Group Call Button 
 	public boolean visibilityOfDialGroupCallButton() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,dialGroupCallButton);
 			WebElement ele = driver.findElement(dialGroupCallButton);
 			return ele.isDisplayed();
 	}
 	
 	//Visibility of mute button In grp call
 	public boolean visibilityOfMuteBuutonInGrpCall() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,muteBuutonInGrpCall);
 		WebElement elementVisibilityOfMuteBuutonInGrpCall=driver.findElement(muteBuutonInGrpCall);
 		return elementVisibilityOfMuteBuutonInGrpCall.isDisplayed();
 	}
 	
 	//Click on mute button to un mute all users in grp call
 	public void clickOnMuteButtonToUnMuteAllUsersInGrpCall() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,muteBuutonInGrpCall);
 		driver.findElement(muteBuutonInGrpCall).click();
 	}
 	
 	//Visibility of un mute button In grp call
 	public boolean visibilityOfUnMuteBuutonFromMuteInGrpCall() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,unMuteBuutonInGrpCall);
 		WebElement elementVisibilityOfUnMuteBuutonInGrpCall=driver.findElement(unMuteBuutonInGrpCall);
 		return elementVisibilityOfUnMuteBuutonInGrpCall.isDisplayed();
 	}
 	
 	public boolean visibilityOfUnMuteBuutonInGrpCall() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,unMuteBuutonInGrpCall);
 		WebElement elementVisibilityOfUnMuteBuutonInGrpCall=driver.findElement(unMuteBuutonInGrpCall);
 		return elementVisibilityOfUnMuteBuutonInGrpCall.isDisplayed();
 	}
 	
 	//Visibility of Individual user mute button in grp call
 	public String visibilityOfIndividualUserMuteButtomInGrpCall() throws InterruptedException{
 		return driver.findElement(By.xpath("//*[@id='liveCallDetails']/table/tbody/tr/td[4]/ul/li[1]/a/img")).getAttribute("src"); 
 	}
 	
 	//Click on Un mute button to mute all users in grp call
 	public void clickOnUnMuteButtonToMuteAllUsersInGrpCall() throws InterruptedException{
 		Thread.sleep(1000);
 		Utility.explicitWaitForElementVisibility(driver,unMuteBuutonInGrpCall);
 		driver.findElement(unMuteBuutonInGrpCall).click();
 	}
 	
 	//method to remove added contact from group in Ongoing call 
 	public void removeAddedContactFromGroupInOnGoingCall() throws InterruptedException{
 		selectSavedGroupByName("grpTalk");
 		Utility.explicitWaitForElementVisibility(driver,editGroupCallButton);
 		driver.findElement(editGroupCallButton).click();
 		driver.switchTo().alert().accept();
 		selectedContactsTab();
 		List<WebElement> selectedUsers=driver.findElements(By.xpath("//div[@id='selectedContacts']//div/div[2]/p[1]"));
 		for(WebElement user: selectedUsers){
    		if(user.getText().equalsIgnoreCase("7396206647") || user.getText().contains("Ivy Ajay")){
    			user.click();
    			break;
    		}
 		
 		}
 		driver.findElement(saveGroupCallButtonOnEditGrpTalk).click();
 	}
 	
 	public void clickOnIndividualUserHangUpButtomInGrpCall() throws InterruptedException{
 	 		//driver.findElement(By.xpath("//*[@id='liveCallDetails']/table/tbody/tr/td[4]/ul/li[2]/a/img")).click(); 
 		Utility.explicitWaitForElementVisibility(driver,hangUpButtonOfIndividualContactInLiveCall);
 	 		driver.findElement(hangUpButtonOfIndividualContactInLiveCall).click(); 
 	 	}
 	 	
 	public void met() throws InterruptedException{
 		driver.findElement(By.xpath("//*[@id='liveCallDetails']/table/tbody/tr[2]/td[4]/ul/li/a/img")).click();
 	}
 	
 	By insurancePlan = By.xpath("//*[@class='form form-home']//div[4]//*[@class='form-control-static']");
 	By insuranceName = By.xpath("//*[@class='modal fade modal-page in']//*[@class='media-body media-middle ']");
 	//*[@class="modal fade modal-page in"]//*[@class="list-group noborder list-language-select"]
 	By insuranceType = By.xpath("//*[@class='modal fade modal-page in']//*[@class='wrapper']//*[@class='list-group-item']");
 	By backButton = By.xpath("//*[@class='icon ion-android-arrow-back']");
 	
 	public void met1() throws InterruptedException{
 		driver.findElement(insurancePlan).click();
    	List<WebElement> insurance = driver.findElements(insuranceName);
    	Set<String> insurenceNames = new HashSet<>();
    	for(WebElement name: insurance){
    		Actions actions=new Actions(driver);
	 		actions.moveToElement(name);
	 		actions.perform();
	 		insurenceNames.add(name.getText());
	 		name.click();
	 			List<WebElement> insurenceTypes = driver.findElements(insuranceType);
	 			Set<String> insuranceType = new HashSet<>();
	 			for(WebElement names: insurenceTypes){
	 				actions.moveToElement(names);
	 				actions.perform();
	 				insuranceType.add(names.getText());
	 			}
	 			System.out.println(insuranceType.size());
	 			for(String s:insuranceType){
	    		System.out.println(s);
	    	}
	 		driver.findElement(backButton).click();
	 		
    	}
    	System.out.println(insurenceNames.size());
    	for(String s:insurenceNames){
    		System.out.println(s);
    	}
    	driver.close();
    	
    }
}

