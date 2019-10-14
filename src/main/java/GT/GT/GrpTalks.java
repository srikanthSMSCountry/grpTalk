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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.*;

public class GrpTalks extends BrowserFunctions{
  
	private static final TimeUnit SECONDS = null;

	static By createGrp 						= By.xpath("//*[@id='createGrpTalkNew']");
 	static By createdGrplist 					= By.xpath("//*[@id='grpDetails']/p[1]");
 	By nameOnMyGrpTalkMainGrid 					= By.className("CallLogName");
 	By grpMembersDetailsOnMyGrpTalks			= By.xpath("//*[@class='col-xs-6 col-sm-4 col-md-3 col-mgbtm']//*[@for='r1']//*[@class='persn-name-det']");
 	By deleteGroupbutton 						= By.id("deleteGroupCall");
 	By successMsg					 			= By.className("toast-message");
 	By editGroupButton							= By.id("editGroupCall");
 	By dialButton 								= By.id("dialGroupCall");
 	By dialGroupCallButtonOnOverlay 			= By.xpath("//*[@id='dial1']");
 	By allMembersTabInGroupCall 				= By.xpath("//*[contains(@class,'allMembers')]");
 	By allMembersCountInGrpCall					= By.id("allMembersCount");
 	By onCallTabInGrpCall 						= By.className("onCall");
 	By onCallCountInGrpCall 					= By.id("onCallCount");
 	By unMutedTabInGrpCall 						= By.className("muted");
 	By unMutedCountInGrpCall 					= By.id("mutedCount");
 	//By callEndedTabInGrpCall 					= By.className("callEnded");
 	By callEndedCountInGrpCall 					= By.id("callEndedCount");
 	By grpTalkGroupInMyGrpTalk					= By.xpath("//*[@grpcallname='grpTalk']");
 	By dialPadClickToAddNumber 					= By.id("dialPadClick");
 	By contactsButtonClickToAddMemberInOnGoingCall = By.id("contactsClickPopup");
 	By enternameforaddingparticipanttoGroupcall	=By.xpath("//*[@id='addParticipantName']");
 	By enterNewNumberForAddingToGroupCall 		= By.xpath(("//*[@id='number']"));
 	By callButtonAfterEnterNumber 				= By.xpath("//*[@class='btn btn-danger no-bord']");
 	By muteDialGroupCallButtonOnOverlay 		= By.id("muteDialdiv1");
 	By cancelGroupCallButtonOnOverlay 			= By.id("cancel");
 	By searchInputOnOverlay 					= By.id("search-input");
 	By addCallButtonOnOverlay 					= By.xpath("//*[@id='contactsModalDiv']//*[@id='addCall']");
 	By memberToAddInOnGoingCallOnOverlay		= By.xpath("//*[@id='grpCallMobileContacts']//*[@id='profileDetails']");
 	By userLogoutButton 						= By.id("logout");
 	By historyButtonOnMyGrpTalks 				= By.xpath("//*[@id='reportsTab']/li[3]/a");
 	By historyOfGroupCall 						= By.xpath("//*[contains(@class,'ui-accordion-header ui-state-default ui-corner-all ui-accordion-icons')]");
 	By grpCallDurationInHistoryTab 				= By.xpath("//*[@class='ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content-active']/div/div[1]/ul/li[1]");
 	By totalMinuesConsumedByGrpCall 			= By.xpath("//*[@class='ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content-active']/div/div[1]/ul/li[2]/span");
 	By totalAmountChargedForGrpcall 			= By.xpath("//*[@class='ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content-active']/div/div[1]/ul/li[3]/span"); 	
 	By dialInMsgForGrpOnMyGrpTalks 				= By.xpath("//*[@class='pinStrip row']");
	By scheduleTimeAndRepeateDaysTextOfGroupOnMyGrpTalk = By.xpath("//*[@id='listTitle']/div/div[2]/span");
	By listOfWebLists 							= By.xpath("//*[@id='list-group1']//*[contains(@class,'list1')]//a");
	By scheduleCancleButton 					= By.id("cancelGroupCall");
	By liveCallButton 							= By.xpath("//*[@id='date']//label");
	By downloadRecordingButton 					= By.xpath("//*[@class='margin-bottom-20']//*[@title='Download Recording']");
	By contactsListOfGroupOnMyGrpTalkPage 		= By.xpath("//*[@id='members']//*[@class='col-xs-6 col-sm-4 col-md-3 col-mgbtm']");
	By quickDialButtonOfActiveGroup 			= By.xpath("//*[@id=\"522891\"]/table/tbody/tr/td[3]/span");
	By grpTalkQuickDialButton 					= By.xpath("//*[@id='quickDial']//*[@src='images/call-green-border.png']");
	By muteAllButtonInUnMutedTab 				= By.xpath("//*[@id='btnUnmuteAll']");
	By dialAllButtonInCallEndedTab 				= By.xpath("//*[@id='btnDialAll']");
	By closePrivateRoomButtonInPrivateRoomTab 	= By.xpath("//*[@id='btnClosePrivate']");
	By excelReportDownloadButtonOnHistory 		= By.id("btnDownlodHistory");
	By footerText 								= By.className("footer");
	By grpTalkLogo 								= By.id("logo");
	By groupsTabOnHomePage 						= By.id("grptalks-li");
	By contactsTabOnHomePage 					= By.id("contacts-li");
	By accountsTabOnHomePage 					= By.id("account-li");
	By profileLogo 								= By.id("imgPath");
	By closeButtonForRateCall					= By.className("close closeRateCallModal");
	By averageButtonOnRateCall 					= By.xpath("//*[@src='images/avg.png']");
	By badButtonOnRateCall 						= By.xpath("//*[@src='images/bad.png']");
	By goodButtonOnRateCall 					= By.xpath("//*[@src='images/good.png']");
	By excelentButtonOnRateCall 				= By.xpath("//*[@src='images/awesome.png']");
	By callClarityOptionInBadEmoji 				= By.xpath("//*[@reasonid='1']");
	By callDropsOptionInBadEmoji 				= By.xpath("//*[@reasonid='2']");
	By poorConnectivityOptionInBadEmoji 		= By.xpath("//*[@reasonid='3']");
	By callClarityOptionInAvgEmoji 				= By.xpath("//*[@reasonid='7']");
	By connectivityOptionInAvgEmoji 			= By.xpath("//*[@reasonid='8']");
	By usabilityOptionInAvgEmoji 				= By.xpath("//*[@reasonid='9']");
	By callClarityOptionInGoodEmoji 			= By.xpath("//*[@reasonid='4']");
	By connectivityOptionInGoodEmoji 			= By.xpath("//*[@reasonid='5']");
	By usabilityOptionInGoodEmoji 				= By.xpath("//*[@reasonid='6']");
	By callClarityOptionInAwesomeEmoji 			= By.xpath("//*[@reasonid='10']");
	By connectivityOptionInAwesomeEmoji 		= By.xpath("//*[@reasonid='11']");
	By easyToUseOptionInAwesomeEmoji 			= By.xpath("//*[@reasonid='12']");
	By feedBackFieldOnRateCall					= By.xpath("//*[@id='rateFeedback']//*[@class='rate_commnt mb-20  rateComments']");
	By submitButtonOnRateCall 					= By.xpath("//*[@class='btn_rate']");
	
	By groups									=By.xpath("//*[@id='grptalks-li']");
	By saveGroupCallButtonOnEditGrpTalk			= By.xpath("//*[@class='form-inline']//*[@id='saveGrpCall']");
	By selectedContacts 						= By.className("selectedContacts");
	By hangUpAllButton 							= By.id("hangupAll");	
	By globalMoveToPrivateRoomButton 			= By.xpath("//*[@id='inProgress']//*[@class='set-mute-button']//*[@class='fa fa-lock']");
	By globalUnMuteButton 						= By.id("muteHeader");
	By globalmuteButton 						= By.id("muteHeader");
	By addMembersButton 						= By.id("addMemberHeader");
	//	By groupName 							= By.className("grpinfoheadon-lfti-mainhdng CallLogName");
	//	By hostName 							= By.id("hostName");
	//	By timer 								= By.xpath("//*[@id='startTmier']//*[@class='535461timer']");
	//	By timerType 							= By.className("hh-mm-ss");
	//	By searchOption 						= By.id("memberSearchText");
	//	By selectSearchOption 					= By.className("fa fa-search");
	//	By gridView 							= By.id("chkGridView");
	//	By handRaiseTab 						= By.xpath("//*[@class='nav nav-tabss']//*[@class='wantsToTalk']");
	//	By handRaiseMembersCount 				= By.xpath("//*[@class='nav nav-tabss']//*[@id='handRaiseCount']");
	By privateRoomTab 							= By.xpath("//*[@class='nav nav-tabss']//*[contains(@class,'privateroom')]");
	By privateRoomMembersConut 					= By.xpath("//*[@class='nav nav-tabss']//*[@id='privateroom']");
	//	By host 								= By.xpath("//*[@id='liveCallMembers']//*[@class='col-xs-4 col-sm-3 oncall-admin']");
	//	By participnatsNames 					= By.xpath("//*[@class='persn-name-det-calling']");
	//	By participantsNumbers 					= By.xpath("//*[@id='liveCallMembers']//*[@class='persn-phnm-det']");
	// By hostSymbol 							= By.xpath("//*[@id='liveCallMembers']//*[@class='col-xs-4 col-sm-3 oncall-admin']//*[@class='admin-ico-bg pull-left']");
	// By hostHangUPButton = By.xpath("//*[@class='col-xs-4 col-sm-3 oncall-admin']//*[@class='singleHangUp']");
	By individualHangUpButton 					= By.className("singleHangUp");
	By individualHangUpButtonExceptHost 		= By.xpath("//*[@class='col-xs-4 col-sm-3 oncall-admin oncall-admin-inprogress']//*[@class='singleHangUp']");
	By individualUnMuteButton 					= By.xpath("//*[@class='singleMuteUnMute']//*[@src='images/MuteNew.png']");
	By individualMuteButton 					= By.xpath("//*[@class='singleMuteUnMute']//*[@src='images/UnMuteNew.png']");
	//By handRaiseDisabledSymbol 				= By.xpath("//*[@src='images/unHandRiseNew.png']");
	//By handRaiseEnabledSymbol 				= By.xpath("//*[@src='images/handRiseNew.png']");
	By individualReDailButton 					= By.xpath("//*[@class='singleRedial']");
	//By individualCallEndedParticipants 		= By.xpath("//*[@class='oncall-bg bgRed pull-right mr-2']//*[@class='oncall-text text-left']");
	By individualOnCallParticipants 			= By.xpath("//*[@class='oncall-bg bgGreen pull-right mr-2']//*[@class='oncall-text text-left']");
	//By individualPrivateRoomBadge 			= By.className("privateRoomBadgeTb");
	//By globalClosePrivateRoomButton 			= By.id("privateUnPrivate");
	//By individualDailingParticipants 			= By.className("oncall-bg bgYellow pull-right mr-2");
	//By callEndedParticipants 					= By.xpath("//*[@id='liveCallMembers']//*[@class='col-xs-4 col-sm-3 oncall-admin']");
	//By hostInAllParticipantsTab 				= By.xpath("//*[@id='liveCallMembers']//*[@class='col-xs-4 col-sm-3 oncall-admin']");
	//By membersInAllParticipantsTabWithHost 	= By.xpath("//*[@id='liveCallMembers']//*[contains(@class,'col-xs-4 col-sm-3 oncall-admin']");
	By totalParticipants 						= By.xpath("//*[@id='liveCallMembers']//*[contains(@class,'col-xs-4 col-sm-3 oncall-admin')]");
	By membersInAllParticipantsTab 				= By.xpath("//*[@id='liveCallMembers']//*[@class='col-xs-4 col-sm-3 oncall-admin oncall-admin-inprogress']");
	//By host 									= By.xpath("//*[@class='aftrgrpselctn-main']//*[@class='slimScrollDiv']//*[@class='fa fa-user']");
	By privateRoomOption 						= By.xpath("//*[@class='col-xs-4 col-sm-3 oncall-admin oncall-admin-inprogress']//*[@class='fa fa-lock']");
	By moveBackTocallButton 					= By.xpath("//*[@id='inprogressHeader']//*[@title='Move back to Call']//*[@class='fa fa-unlock']");
	By listView 								= By.id("chkTableView");
	By hostInListView 							= By.xpath("//*[@id='liveCallMembers']//tr//*[@class='fa fa-user text-pink']");
	By allParticipantsInListView 				= By.xpath("//*[@class='table tblList']//tr");
	By allParticipantsInListViewExceptHost 		= By.xpath("//*[@class='table tblList']//*[@class='oncall-admin-inprogress']");
	By disableHandRaiseOptionInListView 		= By.xpath("//*[@class='table tblList']//*[@class='handriseimageclass']");
	By unMuteOptionInListView 					= By.xpath("//*[@class='table tblList']//*[@src='images/MuteNew.png']");
	public By muteOptionInListView 				= By.xpath("//*[@class='table tblList']//*[@src='images/UnMuteNew.png']");
	By onCallParticipantsInListView 			= By.xpath("//*[@class='table tblList']//*[@class='bxCircular green']");
	By hangUpButtonInListView 					= By.xpath("//*[@class='table tblList']//*[@class='singleHangUp']");
	By hangUpParticipantsExceptHostInlistView 	= By.xpath("//*[@class='table tblList']//*[@class='oncall-admin-inprogress']//*[@class='singleHangUp']");
	By callEndedParticipantsInListView 			= By.xpath("//*[@class='table tblList']//*[@class='bxCircular red']");
	By reDialButtonInListView 					= By.xpath("//*[@class='table tblList']//*[@src='images/ReDialNew.png']");
	By privateRoomOptionInListView 				= By.xpath("//*[@id='liveCallMembers']//*[@class='fa fa-lock']");
	By countOfCallsInHistory					= By.xpath("//*[@id='membersLists']//*[@id='accordion']//*[contains(@class, 'ui-accordion-header ui-state-default ui')]");
 	By callDatesInHistory 						= By.xpath("//*[@id='membersLists']//*[@class='col-md-4 text-left']");
 	By WebListTabOnOverlay 						= By.xpath("//*[@class='contactTab']");
 	By contactsInWeblistOnOverlay 				= By.xpath("//*[@id='grpCallWebContacts']//*[@id='profileDetails']");
 	By insurancePlan 							= By.xpath("//*[@class='form form-home']//div[4]//*[@class='form-control-static']");
 	By insuranceName 							= By.xpath("//*[@class='modal fade modal-page in']//*[@class='media-body media-middle ']");
 	By insuranceType 							= By.xpath("//*[@class='modal fade modal-page in']//*[@class='wrapper']//*[@class='list-group-item']");
 	By backButton 								= By.xpath("//*[@class='icon ion-android-arrow-back']");
 	
 	By hangUpButtonOfParticipant		 		= By.xpath("//*[@id='918634502054']//*[@class='singleHangUp']");
	By unMuteButtonOfParticipant				= By.xpath("//*[@id='918634502054']//*[@src='images/MuteNew.png']");
	By muteButtonOfParticipant 					= By.xpath("//*[@id='918634502054']//*[@src='images/UnMuteNew.png']");
	By reDailButtonOfParticipant				= By.xpath("//*[@id='918634502054']//*[@class='singleRedial']");
	By callEndedTextOfParticipants 				= By.xpath("//*[@id='918634502054']//*[@class='oncall-bg bgRed pull-right mr-2']//*[@class='oncall-text text-left']");
	By privateRoomOptionOfPaticipant			= By.xpath("//*[@id='918634502054']//*[@class='fa fa-lock']");
	By participantInLiveCall 					= By.id("918634502054");
	
 	By hangUpButtonOfParticipantInListView		= By.xpath("//*[@id='918634502054']//*[@class='singleHangUp']");
	By unMuteButtonOfParticipantInListView		= By.xpath("//*[@id='918634502054']//*[@src='images/MuteNew.png']");
	By muteButtonOfParticipantInListView 		= By.xpath("//*[@id='918634502054']//*[@src='images/UnMuteNew.png']");
	By reDailButtonOfParticipantInListView		= By.xpath("//*[@id='918634502054']//*[@class='singleRedial']");
	By callEndedTextOfParticipantsInListView 	= By.xpath("//*[@id='918634502054']//*[@class='bxCircular red']//span[1]");
	By privateRoomOptionOfPaticipantInListView	= By.xpath("//*[@id='918634502054']//*[@class='fa fa-lock']");
	By participantInLiveCallListView 			= By.id("918634502054");
 	By handRaiseEnableOption					= By.xpath("//*[@src='images/handRiseNew.png']");
 	By handRaiseDisableOption					= By.xpath("//*[@src='images/unHandRiseNew.png']");
 	By secondaryModeratorSymbol					= By.xpath("//*[@title='Secondary Moderator']");
 	By allMembersInGrpTalksPage					= By.xpath("//*[@class='col-xs-6 col-sm-4 col-md-3 col-mgbtm']//*[@id='foradmincheck']");
	By leaveGroupButton 						= By.id("leaveGroupCall");
	By dialButtonOnGrpCall 						= By.id("dialGroupCall");
 	By reDialingSymbol							= By.xpath("//*[@id='919550866282']//*[@class='oncall-bg bgYellow pull-right mr-2']//*[@class='oncall-text text-left']");
	By mouseHoverLogout=By.id("imgPath");
	public void mouseHoverLogout() {
		WebElement ele=driver.findElement(mouseHoverLogout);
		Actions action= new Actions(driver);
		action.moveToElement(ele).build().perform();
		}
 	public boolean redialingSymbol(){
 		String reDial= driver.findElement(reDialingSymbol).getText();
 		if(reDial.equalsIgnoreCase("redial")){
 			return true;
 		}else{
 			return false;
 		}
 	}
 	
	 public void selectSecModeratorGroup(String grpName) throws InterruptedException{
	   	String savedGrpName=grpName;
	   	List<WebElement> listofUsersInGroup = driver.findElements(createdGrplist);
	   	for(WebElement user: listofUsersInGroup){
		   	Actions actions=new Actions(driver);
		   	actions.moveToElement(user);
		   	actions.perform();
		   	if(user.getText().contains(savedGrpName)){
		   	Thread.sleep(1000);
		   	user.click();
		   	break;
		   	}
	   	}
	 }
	 
 	public boolean checkSecondaryModerator(String name){
 		List<WebElement> membersList = driver.findElements(allMembersInGrpTalksPage);
 		int i=0;
 		for(int j=0;j<membersList.size();j++){
 			//WebElement kk= membersList.get(j).findElement(By.xpath("//*[@class='persn-name-det']"));
 			//System.out.println(kk);
 			System.out.println(membersList.get(j).findElement(By.xpath(".//*[@class='persn-name-det']")).getText());
 			if(membersList.get(j).findElement(By.xpath(".//*[@class='persn-name-det']")).getText().equalsIgnoreCase(name)){
 				membersList.get(j).findElement(secondaryModeratorSymbol).isDisplayed();
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
 	
 	
 	
	public void clickUnMuteButtonOfParticipantInListView() throws InterruptedException{
		driver.findElement(unMuteButtonOfParticipantInListView).click();
		Thread.sleep(1000);
	}
	public boolean visibilityOfMuteButtonOfParticipantInListView() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(muteButtonOfParticipantInListView);
		return driver.findElement(muteButtonOfParticipantInListView).isDisplayed() ;
	}
		public void clickMuteButtonOfParticipantInListView() throws InterruptedException{
		driver.findElement(muteButtonOfParticipantInListView).click() ;
		Thread.sleep(2000);
	}
		public boolean visibilityOfUnMuteButtonOfParticipantInListView() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(unMuteButtonOfParticipantInListView);
		return driver.findElement(unMuteButtonOfParticipantInListView).isDisplayed() ;
	}
	
	public void participantMovingToPrviateRoomInListView() throws InterruptedException
	{
		driver.findElement(participantInLiveCallListView).click();
		Thread.sleep(1000);
		WebElement element = driver.findElement(globalMoveToPrivateRoomButton);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
	}
	
	public boolean visibilityOfPrivateRoomOptionforParticipantInListView() throws InterruptedException{
		return driver.findElement(privateRoomOptionOfPaticipantInListView).isDisplayed() ;
	}
	
	public void participantMovingBackTocallInListView() throws InterruptedException
	{
		driver.findElement(privateRoomOptionOfPaticipantInListView).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(moveBackTocallButton);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
	}
	
	public boolean InvisibilityOfPrivateRoomOptionForParticipantInListView() throws InterruptedException{
		 int count= driver.findElements(privateRoomOptionOfPaticipantInListView).size();
		 if(count == 0){
			 return true;
		 }
		 else{
			 return false;
		 }
	}
	public void clickhangUpButtonOfParticipantInListView() throws InterruptedException{
		driver.findElement(hangUpButtonOfParticipantInListView).click();
	}
	
	public boolean visibilityOfReDialButtonOfParticipantInListView() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(reDailButtonOfParticipantInListView);
		return driver.findElement(reDailButtonOfParticipantInListView).isDisplayed() ;
	}
	
	public void clickreDialButtonOfParticipantInListView() throws InterruptedException{
		driver.findElement(reDailButtonOfParticipantInListView).click();
		Thread.sleep(15000);
	}
	
	public boolean visibilityOfHangUpButtonOfParticipantInListView() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(hangUpButtonOfParticipantInListView);
		return driver.findElement(hangUpButtonOfParticipantInListView).isDisplayed() ;
	}
	
	public void clickUnMuteButtonOfParticipant() throws InterruptedException{
		driver.findElement(unMuteButtonOfParticipant).click();
		Thread.sleep(1000);
	}
	public boolean visibilityOfMuteButtonOfParticipant() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(muteButtonOfParticipant);
		return driver.findElement(muteButtonOfParticipant).isDisplayed() ;
	}
		public void clickMuteButtonOfParticipant() throws InterruptedException{
		driver.findElement(muteButtonOfParticipant).click() ;
		Thread.sleep(1000);
	}
		public boolean visibilityOfUnMuteButtonOfParticipant() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(unMuteButtonOfParticipant);
		return driver.findElement(unMuteButtonOfParticipant).isDisplayed() ;
	}
		
	public void participantMovingToPrviateRoom() throws InterruptedException
	{
		driver.findElement(participantInLiveCall).click();
		Thread.sleep(1000);
		WebElement element = driver.findElement(globalMoveToPrivateRoomButton);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
	}
	
	public boolean visibilityOfPrivateRoomOptionforParticipant() throws InterruptedException{
		return driver.findElement(privateRoomOptionOfPaticipant).isDisplayed() ;
	}
	
	public void participantMovingBackTocall() throws InterruptedException
	{
		driver.findElement(privateRoomOptionOfPaticipant).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(moveBackTocallButton);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
	}
	
	public boolean InvisibilityOfPrivateRoomOptionForParticipant() throws InterruptedException{
		 int count= driver.findElements(privateRoomOption).size();
		 if(count == 0){
			 return true;
		 }
		 else{
			 return false;
		 }
	}
	public void clickhangUpButtonOfParticipant() throws InterruptedException{
		driver.findElement(hangUpButtonOfParticipant).click();
	}
	
	public boolean visibilityOfReDialButtonOfParticipant() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(reDailButtonOfParticipant);
		return driver.findElement(reDailButtonOfParticipant).isDisplayed() ;
	}
	
	public void clickreDialButtonOfParticipant() throws InterruptedException{
		driver.findElement(reDailButtonOfParticipant).click();
		Thread.sleep(15000);
	}
	
	public boolean visibilityOfHangUpButtonOfParticipant() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(hangUpButtonOfParticipant);
		return driver.findElement(hangUpButtonOfParticipant).isDisplayed() ;
	}
	

	public boolean visibilityOFMuteButtonOfIndividualContactInListView() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(muteOptionInListView);
		return driver.findElement(muteOptionInListView).isDisplayed() ;
	}
	

	
	public int allParticipantsInListView() throws InterruptedException{
		Thread.sleep(1000);
		return driver.findElements(allParticipantsInListView).size();
	}
	
	public void listViewInLiveCall(){
		driver.findElement(listView).click();
	}
	
    public void selectedContactsTab() throws InterruptedException
    {
    	CommonMethods.explicitWaitForElementVisibility(selectedContacts);
    	driver.findElement(selectedContacts).click();
    }

//    public void removeAddedContactFromGroupInOnGoingCall() throws InterruptedException{
// 		selectSavedGroupByName("grpTalk");
// 		CommonMethods.explicitWaitForElementVisibility(editGroupButton);
// 		driver.findElement(editGroupButton).click();
// 		driver.switchTo().alert().accept();
// 		selectedContactsTab();
// 		List<WebElement> selectedUsers=driver.findElements(By.xpath("//div[@id='selectedContacts']//div/div[2]/p[1]"));
// 		for(WebElement user: selectedUsers){
//    		if(user.getText().equalsIgnoreCase("7396206647") || user.getText().contains("Ivy Ajay")){
//    			user.click();
//    			break;
//    		}
// 		
// 		}
// 		driver.findElement(saveGroupCallButtonOnEditGrpTalk).click();
// 	}
	
	public void submitRateCallByClickingGoodOption() throws InterruptedException{
		Thread.sleep(3000);
		CommonMethods.explicitWaitForElementVisibility(goodButtonOnRateCall);
		driver.findElement(goodButtonOnRateCall).click();
		driver.findElement(callClarityOptionInGoodEmoji).click();
		driver.findElement(connectivityOptionInGoodEmoji).click();
		driver.findElement(usabilityOptionInGoodEmoji).click();
		driver.findElement(feedBackFieldOnRateCall).sendKeys("Good");
		driver.findElement(submitButtonOnRateCall).click();
		Thread.sleep(1000);
	}
	
	public void submitRateCallByClickingBadOption() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(badButtonOnRateCall).click();
		driver.findElement(callClarityOptionInBadEmoji).click();
		driver.findElement(callDropsOptionInBadEmoji).click();
		driver.findElement(poorConnectivityOptionInBadEmoji).click();
		driver.findElement(feedBackFieldOnRateCall).sendKeys("Bad");
		driver.findElement(submitButtonOnRateCall).click();
		Thread.sleep(1000);
	}
	
	public void submitRateCallByClickingAverageOption() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(averageButtonOnRateCall).click();
		driver.findElement(callClarityOptionInAvgEmoji).click();
		driver.findElement(connectivityOptionInAvgEmoji).click();
		driver.findElement(usabilityOptionInAvgEmoji).click();
		driver.findElement(feedBackFieldOnRateCall).sendKeys("Average");
		driver.findElement(submitButtonOnRateCall).click();
		Thread.sleep(1000);
	}
	
	public void submitRateCallByClickingExcelentOption() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(excelentButtonOnRateCall).click();
		driver.findElement(callClarityOptionInAwesomeEmoji).click();
		driver.findElement(connectivityOptionInAwesomeEmoji).click();
		driver.findElement(easyToUseOptionInAwesomeEmoji).click();
		driver.findElement(feedBackFieldOnRateCall).sendKeys("Awesome");
		driver.findElement(submitButtonOnRateCall).click();
		Thread.sleep(1000);
	}
	
	public String footerText(){
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(footerText)).perform();
		return driver.findElement(footerText).getText();
	}
	
	public void clickExcelReportDownloadButtonOnHistory() throws InterruptedException{
		driver.findElement(excelReportDownloadButtonOnHistory).click();
		Thread.sleep(5000);
	}
	

	public boolean visibilityOfClosePrivateRoomButtonInPrivateRoomTab() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(closePrivateRoomButtonInPrivateRoomTab);
		return driver.findElement(closePrivateRoomButtonInPrivateRoomTab).isDisplayed();
	}
	
	public void clickClosePrivateRoomButtonInPrivateRoomTab() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(closePrivateRoomButtonInPrivateRoomTab);
		driver.findElement(closePrivateRoomButtonInPrivateRoomTab).click();
		Thread.sleep(2000);
	}
	
 	public int selectPrivateRoomTabAndCountTheParticipants() throws InterruptedException{
 		Thread.sleep(1000);
 		CommonMethods.explicitWaitForElementVisibility(privateRoomTab);
 		driver.findElement(privateRoomTab).click();
 		Thread.sleep(1000);
 		String count_all_members = driver.findElement(privateRoomMembersConut).getText();
 		int i = Integer.parseInt(count_all_members.replaceAll("[^0-9]", ""));
 		return i;
 	}
	
 	public boolean muteOptionPresenceInPrivateRoomTab(){
 		int size=driver.findElements(individualMuteButton).size();
 		if(size!=0){
 			return false;
 		}
 		else{
 			return true;
 		}
 	}
 	
 	public boolean unMuteOptionPresenceInPrivateRoomTab(){
 		int size=driver.findElements(individualUnMuteButton).size();
 		if(size!=0){
 			return false;
 		}
 		else{
 			return true;
 		}
 	}
 	
	public void clickMuteAllButtonInUnMutedTab() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(muteAllButtonInUnMutedTab);
		driver.findElement(muteAllButtonInUnMutedTab).isDisplayed();
		driver.findElement(muteAllButtonInUnMutedTab).click();
	}
	
	public void clickDialAllButtonInCallEndedTab() throws InterruptedException{
		driver.findElement(dialAllButtonInCallEndedTab).isDisplayed();
		driver.findElement(dialAllButtonInCallEndedTab).click();
		Thread.sleep(15000);
	}
	
	public void quickDialButtonOfActiveGroup() throws InterruptedException{
		//CommonMethods.explicitWaitForElementVisibility(quickDialButtonOfActiveGroup);
		//CommonMethods.elementExistsOrNot(quickDialButtonOfActiveGroup);
		Thread.sleep(2000);
		driver.findElement(quickDialButtonOfActiveGroup).click();
	}
	
	public void clickQuickDailButtonofGroupInGrpTalks() throws InterruptedException{
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(grpTalkQuickDialButton));
 		actions.perform();
		driver.findElement(grpTalkQuickDialButton).click();
		Thread.sleep(2000);
	}
	
	public int contactsListOfGroupOnMyGrpTalkPage() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(contactsListOfGroupOnMyGrpTalkPage);
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
		CommonMethods.explicitWaitForElementVisibility(scheduleCancleButton);
		return driver.findElement(scheduleCancleButton).isDisplayed();
	}
	
	public boolean listNameInWebLists(String newWebList) throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(listOfWebLists);
	    	String ss=newWebList;
	    	int i=0;
	    	List<WebElement> listofUsersInGroup = driver.findElements(listOfWebLists);
	    	for(WebElement list: listofUsersInGroup){
	    		Actions actions=new Actions(driver);
		 		actions.moveToElement(list);
		 		actions.perform();
	    		if(list.getText().contains(ss)){
	    			Thread.sleep(1000);
	    			System.out.println(list.getText());
	    			list.click();
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
	
	 String listName = "List "+System.currentTimeMillis();
	 
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

 	public double totalAmountChargedForGrpcall() throws InterruptedException{
 		Thread.sleep(2000);
 		String s= driver.findElement(totalAmountChargedForGrpcall).getText();
 		String intValue = s.replaceAll("[^0-9]", "");
 	 	Double i = Double.parseDouble(intValue);
    	return i/1000;
 	}
 	public String totalAmountChargedForGrpcall1() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(totalAmountChargedForGrpcall);
 		String s = driver.findElement(totalAmountChargedForGrpcall).getText();
 		String value = s.replaceAll("INR ", "");
 		return value;
 	}
 	
 	public int totalMinutesConsumedInGrpCall() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(totalMinuesConsumedByGrpCall);
 		String s=driver.findElement(totalMinuesConsumedByGrpCall).getText();
 		Integer i=Integer.parseInt(s);
 		return i;
 	}
 	
 	public void grpCallDurationInHistoryTab() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(grpCallDurationInHistoryTab);
 		System.out.println(driver.findElement(grpCallDurationInHistoryTab).getText());
 	}
 	
 	public void historyButtonOnMyGrpTalks() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(historyButtonOnMyGrpTalks);
 		driver.findElement(historyButtonOnMyGrpTalks).click();
 	}
 	
 	public int countOfCallsByGroupInHistory(){
 		CommonMethods.explicitWaitForElementVisibility(countOfCallsInHistory);
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
 		CommonMethods.explicitWaitForElementVisibility(downloadRecordingButton);
 		Thread.sleep(2000);
 		driver.findElement(downloadRecordingButton).click();
 		Thread.sleep(10000);
 		}
 	
 	public void historyOfGroupCall() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(historyOfGroupCall);
 		driver.findElement(historyOfGroupCall).click();
 	}
 	
 	public void userLogOutButton() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(userLogoutButton);
 		driver.findElement(userLogoutButton).click();
 	}
 	
    public void clickCreateGrpButton() throws InterruptedException{
    	Thread.sleep(3000);
       	driver.findElement(createGrp).click();
    }
    
    String name = "Test_"+System.currentTimeMillis();
    
//    public String retrievingNameOfCreatedGrpTalk() throws InterruptedException{
//    	return name;
//    }

    public String selectRecentlySavedGrpTalkGroup(String grpName) throws InterruptedException{
    	//String ss=name;
    	Thread.sleep(1000);
    	//Assert.assertTrue(CommonMethods.elementExistsOrNot(CreatingGroup.createdGrplist));
    	List<WebElement> listofGrpnames = driver.findElements(createdGrplist);
    	for(WebElement names: listofGrpnames){
    		Actions actions=new Actions(driver);
	 		actions.moveToElement(names);
	 		actions.perform();
    		if(names.getText().contains(grpName)){
    		//	CommonMethods.elementExistsOrNot(names);
    			Thread.sleep(1000);
    			names.click();
    		//	Thread.sleep(1000);
    			break;
    		}
    	}
    	//Thread.sleep(3000);
    	return grpName;
    }
    
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
    
    public void selectSavedGroupByName(String grpName) throws InterruptedException{
    	Thread.sleep(3000);
    	String savedGrpName=grpName;
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
    
    public String nameOnMyGrpTalkMainGrid() throws InterruptedException{
        return driver.findElement(nameOnMyGrpTalkMainGrid).getText();
    }
    
    public List<String> listOfGroupContactsOnMyGrpTalkPage() throws InterruptedException{
       	List<String> expectedResult = new ArrayList<String>();
    	List<WebElement> expectedAllUsers = driver.findElements(grpMembersDetailsOnMyGrpTalks);
    	for (int i=0; i<expectedAllUsers.size(); i++){
    		expectedResult.add(expectedAllUsers.get(i).getText());
    	}
    	expectedResult.remove(0);
     	return expectedResult;
    }
    
 	public void deleteSavedGroupCall() throws InterruptedException{
 		driver.findElement(deleteGroupbutton).click();
 		driver.switchTo().alert().accept();
 	}
 	
 	public void deleteSavedLeaveGroupGroup() throws InterruptedException{
    	List<WebElement> listofGrpnames = driver.findElements(By.xpath("//*[contains(@grpcallname,'LeaveGroup')]"));
    	Actions actions=new Actions(driver);
    	for(WebElement names: listofGrpnames){
    	 		actions.moveToElement(names);
    	 		actions.perform();
       			names.click();
   				driver.findElement(deleteGroupbutton).click();
   		 		driver.switchTo().alert().accept();
    	}
    }
 	
 	public void deleteSavedGrp() throws InterruptedException{
    	List<WebElement> listofGrpnames = driver.findElements(By.xpath("//*[contains(@grpcallname,'Test_')]"));
    	Actions actions=new Actions(driver);
    	for(WebElement names: listofGrpnames){
    	 		actions.moveToElement(names);
    	 		actions.perform();
       			names.click();
   				driver.findElement(deleteGroupbutton).click();
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
 	
// 	public String successMsgForDeletingSavedGroup() throws InterruptedException{
// 		return driver.findElement(successMsgForDeletingSavedGroup).getText(); 
// 	}
 	
 	public void clickEditButtonOnMyGrpTalksPage() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(editGroupButton);
 		driver.findElement(editGroupButton).click();
 		driver.switchTo().alert().accept();
 		Thread.sleep(1000);
 	}
	By callManagerOptionForContacts = By.xpath("//*[@class='fa fa-star ']");
	
	public boolean visibilityOfCallManagerOptionForContacts() throws InterruptedException{
		Thread.sleep(2000);
  		return driver.findElement(callManagerOptionForContacts).isDisplayed();
	}
	
  	public String dialInMsgForGrpOnMyGrpTalks() throws InterruptedException{
  		Thread.sleep(1000);
  		Actions action = new Actions(driver);
  		action.moveToElement(driver.findElement(dialInMsgForGrpOnMyGrpTalks)).perform();
  		return driver.findElement(dialInMsgForGrpOnMyGrpTalks).getText();
  	}
  	
	public boolean dialInAndNonMembersMsgForGrpOnMyGrpTalks() throws InterruptedException{
  		Thread.sleep(1000);
  		Actions action = new Actions(driver);
  		action.moveToElement(driver.findElement(dialInMsgForGrpOnMyGrpTalks)).perform();
  		String msg= driver.findElement(dialInMsgForGrpOnMyGrpTalks).getText();
  		if(msg.contains("Dial In Only & Non Members allowed using Conference PIN")){
  			return true;
  		}
  		else{
  			return false;
  		}
  	}
	
	public boolean nonMembersMsgForGrpOnMyGrpTalks() throws InterruptedException{
  		Thread.sleep(1000);
  		Actions action = new Actions(driver);
  		action.moveToElement(driver.findElement(dialInMsgForGrpOnMyGrpTalks)).perform();
  		String msg= driver.findElement(dialInMsgForGrpOnMyGrpTalks).getText();
  		if(msg.contains("Non Members can Dial in Using Conference PIN")){
  			return true;
  		}
  		else{
  			return false;
  		}
  	}
 	
 	public void dialGroupCallButton() throws InterruptedException{
 		Thread.sleep(2000);
 		driver.findElement(dialButton).click();
 	}
 	
 	public void dialGroupCallButtonOnOverlay() throws InterruptedException{
 		Thread.sleep(2000);
 		driver.findElement(dialGroupCallButtonOnOverlay).click(); 
 		Thread.sleep(25000);
 	}
 	

    public void verifyLiveCallState(){
    	WebDriverWait wait = new WebDriverWait(driver, 15);
    	wait.until(ExpectedConditions.visibilityOfElementLocated((individualOnCallParticipants)));
    }
    
    public boolean onCallCheck() throws InterruptedException{
    	Thread.sleep(1000);
    	return driver.findElement(individualOnCallParticipants).isDisplayed();
    }

 	public int selectAllParticipantsTabAndCountTheParticipants() throws InterruptedException{
 		//Thread.sleep(1000);
 		driver.findElement(allMembersTabInGroupCall).click();
 		Thread.sleep(1000);
 		String count_all_members = driver.findElement(allMembersCountInGrpCall).getText();
 		int i = Integer.parseInt(count_all_members.replaceAll("[^0-9]", ""));
 		return i;
 	}
 	

 	
	public int totalParticipants() throws InterruptedException{
 		int count = driver.findElements(totalParticipants).size();
 		return count;
 	}
	
 	public int selectOnCallTabAndCountTheParticipants() throws InterruptedException{
 		Thread.sleep(1000);
 		CommonMethods.explicitWaitForElementVisibility(onCallCountInGrpCall);
 		driver.findElement(onCallCountInGrpCall).click();
 		Thread.sleep(1000);
 		CommonMethods.explicitWaitForElementVisibility(onCallCountInGrpCall);
 		return Integer.parseInt((driver.findElement(onCallCountInGrpCall).getText()).replaceAll("[^0-9]", ""));
 	
 	}
 	
 	public int selectUnMutedTabAndCountTheParticipants() throws InterruptedException{
 		Thread.sleep(1000);
 		CommonMethods.explicitWaitForElementVisibility(unMutedTabInGrpCall);
 		driver.findElement(unMutedTabInGrpCall).click();
 		Thread.sleep(1000);
 		return Integer.parseInt((driver.findElement(unMutedCountInGrpCall).getText()).replaceAll("[^0-9]", ""));
 	}
 	
 	public int selectDisconnectedTabAndCountTheParticipants() throws InterruptedException{
 		Thread.sleep(1000);
 		CommonMethods.explicitWaitForElementVisibility(callEndedCountInGrpCall);
 		driver.findElement(callEndedCountInGrpCall).click();
 		Thread.sleep(1000);
 		CommonMethods.explicitWaitForElementVisibility(callEndedCountInGrpCall);
 		return Integer.parseInt((driver.findElement(callEndedCountInGrpCall).getText()).replaceAll("[^0-9]", ""));
 	}
 	
 	public void grpTalkGroupInMyGrpTalk() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(grpTalkGroupInMyGrpTalk);
 		driver.findElement(grpTalkGroupInMyGrpTalk).click();
 	}
 	
 	public void hangUpCurrentGrpTalkcall() throws InterruptedException{
 		Thread.sleep(1000);
 		CommonMethods.explicitWaitForElementVisibility(hangUpAllButton);
 		driver.findElement(hangUpAllButton).click();
 		driver.switchTo().alert().accept();
// 		driver.findElement(By.xpath("//*[@src='images/awesome.png']")).click();
// 		
// 		driver.findElement(By.xpath("//*[@class=\"mt-10 mb-20 text-center\"]//*[@reasonid=\"12\"]")).click();
// 		driver.findElement(By.id("ratingSubmit")).click();
 		
 	}
 	
 	public void addMemberInOnGoingGrpCall() throws InterruptedException{
 		driver.findElement(addMembersButton).click();
 		CommonMethods.explicitWaitForElementVisibility(dialPadClickToAddNumber);
 		driver.findElement(dialPadClickToAddNumber).click();
 		driver.findElement(enternameforaddingparticipanttoGroupcall).sendKeys(CommonMethods.passingData("AddContactInOnGoingCall"));
 		driver.findElement(enterNewNumberForAddingToGroupCall).sendKeys(CommonMethods.passingData("AddContactInOnGoingCall"));
 		Thread.sleep(1000);
 		driver.findElement(callButtonAfterEnterNumber).click();
 		Thread.sleep(1000);
 		driver.findElement(onCallTabInGrpCall).click();
 		Thread.sleep(22000);
 	}
 	
 	public void addMemberInOnGoingCallThroughContacts() throws InterruptedException{
 	 		driver.findElement(addMembersButton).click();
 	 		CommonMethods.explicitWaitForElementVisibility(contactsButtonClickToAddMemberInOnGoingCall);
 	 		driver.findElement(contactsButtonClickToAddMemberInOnGoingCall).click();
 	 		driver.findElement(searchInputOnOverlay).sendKeys(CommonMethods.passingData("enterTestContact2InSearchBox"));
 	 		driver.findElement(memberToAddInOnGoingCallOnOverlay).click();
 	 		driver.findElement(addCallButtonOnOverlay).click();
 	 		Thread.sleep(20000);
 	}
 	
 	public void addMemberInOnGoingCallThroughWebList() throws InterruptedException{
	 		driver.findElement(addMembersButton).click();
	 		driver.findElement(contactsButtonClickToAddMemberInOnGoingCall).click();
	 		driver.findElement(WebListTabOnOverlay).click();
	 		Thread.sleep(1000);
	 		clicklistGroupInWebListOnOverlay();
	 		addcontactFromWebListGroupOnOverlay();
	 		Actions action = new Actions(driver);
	 		action.moveToElement(driver.findElement(addCallButtonOnOverlay)).perform();
	 		JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", driver.findElement(addCallButtonOnOverlay));
	 		Thread.sleep(15000);
	}
 	
 	public void leaveFromGroup(){
 		driver.findElement(leaveGroupButton).click();
 		driver.switchTo().alert().accept();
 	}
 	
	public boolean serachForGroupWhereMemberRemoved(String group) throws InterruptedException{
	   	String savedGrpName=group;
	    List<WebElement> listofUsersInGroup = driver.findElements(createdGrplist);
	    Actions actions=new Actions(driver);
	    int i=0;
	    for(WebElement user: listofUsersInGroup){
	    	actions.moveToElement(user);
	    	actions.perform();
	    	if(user.getText().contains(savedGrpName)){
	    		Thread.sleep(1000);
	    		user.click();
	    		i++;
	    		break;
	    	}
	    }
	    if(i==0){
	    	return true;
	    }
	    else{
	    	return false;
	    }
	}
 	
 	
 	By WebListsOnOverlay = By.xpath("//*[@class='contactList1']");
 	public void clicklistGroupInWebListOnOverlay() throws InterruptedException{
 		Thread.sleep(2000);
 		CommonMethods.explicitWaitForElementVisibility(WebListsOnOverlay);
		Actions actions=new Actions(driver);
 		List<WebElement> ele=driver.findElements(WebListsOnOverlay);
 		for (WebElement webList : ele ) 
		  {
 			actions.moveToElement(webList);
 			actions.perform();
 			if(webList.getText().contains(CommonMethods.passingData("newTestList"))){
    			webList.click();
    			break;
    		}
		  }
 	}
 	
 	public void addcontactFromWebListGroupOnOverlay() throws InterruptedException{
 		//CommonMethods.explicitWaitForElementVisibility(contactsInWeblistOnOverlay);
 		CommonMethods.elementExistsOrNot(contactsInWeblistOnOverlay);
 		List<WebElement> ele=driver.findElements(contactsInWeblistOnOverlay);
 		ele.get(0).click();
 	}
 	
 	public void muteDialGroupCallOnOverlay() throws InterruptedException{
 		Thread.sleep(2000);
 		driver.findElement(muteDialGroupCallButtonOnOverlay).click();
 		Thread.sleep(20000);
 	}
 	
 	public void muteDialGroupCallOnOverlay111() throws InterruptedException{
 		Thread.sleep(4000);
 		driver.findElement(muteDialGroupCallButtonOnOverlay).click();
 		Thread.sleep(4000);
 	}
 	public void cancelGroupCallOnOverlay() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(cancelGroupCallButtonOnOverlay);
 		driver.findElement(cancelGroupCallButtonOnOverlay).click();
 	}
 	
// 	public boolean cancleButtonDisplayedOnCallOverlay() throws InterruptedException{
// 		CommonMethods.explicitWaitForElementVisibility(cancelGroupCallButtonOnOverlay);
// 		return driver.findElement(cancelGroupCallButtonOnOverlay).isDisplayed();
// 	}
 	
//	public boolean muteDialButtonDisplayedOnCallOverlay() throws InterruptedException{
//		CommonMethods.explicitWaitForElementVisibility(muteDialGroupCallButtonOnOverlay);
// 		return driver.findElement(muteDialGroupCallButtonOnOverlay).isDisplayed();
// 	}
	
//	public boolean dialGroupButtonDisplayedOnCallOverlay() throws InterruptedException{
//		CommonMethods.explicitWaitForElementVisibility(dialGroupCallButtonOnOverlay);
// 		return driver.findElement(dialGroupCallButtonOnOverlay).isDisplayed();
// 	}
	
 	public boolean visibilityOfDialGroupCallButton() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(dialButton);
 			WebElement ele = driver.findElement(dialButton);
 			return ele.isDisplayed();
 	}
 	
 	public boolean visibilityOfMuteBuutonInGrpCall() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(globalmuteButton);
 		WebElement elementVisibilityOfMuteBuutonInGrpCall=driver.findElement(globalmuteButton);
 		return elementVisibilityOfMuteBuutonInGrpCall.isDisplayed();
 	}
 	
 	public void clickOnMuteButtonToUnMuteAllUsersInGrpCall() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(globalmuteButton);
 		driver.findElement(globalmuteButton).click();
 	}
 	
 	public boolean visibilityOfUnMuteBuutonFromMuteInGrpCall() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(globalUnMuteButton);
 		WebElement elementVisibilityOfUnMuteBuutonInGrpCall=driver.findElement(globalUnMuteButton);
 		return elementVisibilityOfUnMuteBuutonInGrpCall.isDisplayed();
 	}
 	
 	public boolean visibilityOfUnMuteBuutonInGrpCall() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(globalUnMuteButton);
 		WebElement elementVisibilityOfUnMuteBuutonInGrpCall=driver.findElement(globalUnMuteButton);
 		return elementVisibilityOfUnMuteBuutonInGrpCall.isDisplayed();
 	}
 	
 	public boolean visibilityOfIndividualUserMuteButtomInGrpCall() throws InterruptedException{
 		return driver.findElement(individualMuteButton).isDisplayed();
 	}
 	
 	public boolean checkVisibilityOfIndividualUserMuteButtomInGrpCall() throws InterruptedException{
 	int i=0;
		int muteParticipants= driver.findElements(individualMuteButton).size();
		int onCallMembersInAllParticipantsTab = driver.findElements(membersInAllParticipantsTab).size();
		if(muteParticipants == onCallMembersInAllParticipantsTab){
			return true;
		}
		else{
			return false;
		}
 	}
 	
 	public boolean checkVisibilityOfIndividualUserUnMuteButtomInGrpCall() throws InterruptedException{
 	int i=0;
		int muteParticipants= driver.findElements(individualUnMuteButton).size();
		int onCallMembersInAllParticipantsTab = driver.findElements(membersInAllParticipantsTab).size();
		if(muteParticipants == onCallMembersInAllParticipantsTab){
			return true;
		}
		else{
			return false;
		}
 	}
 	
 	public boolean visibilityOfIndividualUserUnMuteButtomInGrpCall() throws InterruptedException{
 	 		return driver.findElement(individualUnMuteButton).isDisplayed();
 	}
 	 	
 	public void clickOnUnMuteButtonToMuteAllUsersInGrpCall() throws InterruptedException{
 		Thread.sleep(1000);
 		CommonMethods.explicitWaitForElementVisibility(globalUnMuteButton);
 		driver.findElement(globalUnMuteButton).click();
 	}
 	
 	public void clickOnIndividualUserHangUpButtomInGrpCall() throws InterruptedException{
 	 		//driver.findElement(By.xpath("//*[@id='liveCallDetails']/table/tbody/tr/td[4]/ul/li[2]/a/img")).click(); 
 		CommonMethods.explicitWaitForElementVisibility(individualHangUpButtonExceptHost);
 	 		driver.findElement(individualHangUpButtonExceptHost).click(); 
 	}
 	 	
 	public void met() throws InterruptedException{
 		driver.findElement(By.xpath("//*[@id='liveCallDetails']/table/tbody/tr[2]/td[4]/ul/li/a/img")).click();
 	}
 	
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
	public void clickOnGroupsTab() throws InterruptedException {
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
 		driver.findElement(groups).click();
			
	}
}

