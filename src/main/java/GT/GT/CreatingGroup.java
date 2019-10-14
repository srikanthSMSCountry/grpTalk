package GT.GT;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;
import java.awt.AWTException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import utility.*;
public class CreatingGroup extends BrowserFunctions{
  
	private static final TimeUnit SECONDS = null;

	By errorMsg								= By.className("toast-message");
	By successMsg							= By.className("toast-message");
	By selectedContacts			 			= By.className("selectedContacts"); 
 	By errorMsgWhenWeSubmitSaveButton 		= By.xpath("//*[@id='toast-container']");
 	By startNowButton 						= By.id("startNow");
 	By saveButton 							= By.id("saveGroupCall");
 	By scheduleButton 						= By.id("schedule");
 	By grpTalkName 							= By.id("grpTalkName");
 	By selectedContactsTab 					= By.xpath("//*[@id='myTabList']/li[3]/a/span");
	By namesOfUsers 						= By.xpath("//div[@id='grpCallMobileContacts']//div[@class='contacts margin-right-5 margin-bottom-5 ']");
	By namesOfUsers1 						= By.xpath("//div[@id='grpCallMobileContacts']//div[@class='contacts margin-right-5 margin-bottom-5  selected ']");
	By search_box 							= By.xpath("//*[@placeholder='Search']");
 	By onOffSwitchLabelForDialInOnlyOnAdvancedSettings 			= By.xpath("//*[@for='dialinswitch']");
 	By onOffSwitchLabelForAllowNonMembersOnAdvancedSettings 	= By.xpath("//*[@for='allownonswitch']");
 	By onOffSwitchLabelForMuteDialOnAdvancedSettings 			= By.xpath("//*[@for='mutedialswitch']");
 	By onOffSwitchLabelForAssignCallManagerOnAdvancedSettings = By.xpath("//*[@for='assignManagerSchedule']");
 	By incrementDatePickerForDay 			= By.xpath("//*[@class='dtpicker-comp day']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
 	By decrementDatePickerForDay 			= By.xpath("//*[@class='dtpicker-comp day']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By displayValueOfDayInDatePicker 		= By.xpath("//*[@class='dtpicker-comp day']//*[@class='dtpicker-compValue']");
 	By incrementDatePickerForMonth 			= By.xpath("//*[@class='dtpicker-comp month']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
 	By decrementDatePickerForMonth 			= By.xpath("//*[@class='dtpicker-comp month']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By displayValueOfMonthInDatePicker 		= By.xpath("//*[@class='dtpicker-comp month']//*[@class='dtpicker-compValue']");
	By incrementDatePickerForYear 			= By.xpath("//*[@class='dtpicker-comp year']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
 	By decrementDatePickerForYear 			= By.xpath("//*[@class='dtpicker-comp year']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By displayValueOfYearInDatePicker 		= By.xpath("//*[@class='dtpicker-comp year']//*[@class='dtpicker-compValue']");
	By incrementDatePickerForHour 			= By.xpath("//*[@class='dtpicker-comp hour']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
 	By decrementDatePickerForHour 			= By.xpath("//*[@class='dtpicker-comp hour']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By displayValueOfHourInDatePicker 		= By.xpath("//*[@class='dtpicker-comp hour']//*[@class='dtpicker-compValue']");
	By decrementDatePickerForMinutes 		= By.xpath("//*[@class='dtpicker-comp minutes']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By displayValueOfHourInDateMinutes 		= By.xpath("//*[@class='dtpicker-comp minutes']//*[@class='dtpicker-compValue']");
	By datePickerSetButtonOnOverlay 		= By.xpath("//*[@class='dtpicker-button dtpicker-buttonSet']");
	By datePickerClearButtonOnOverlay 		= By.xpath("//*[@class='dtpicker-button dtpicker-buttonClear']");
	By repeatDaysOnAdvancedSettings 		= By.xpath("//*[@class='modal-content']//*[@class='btn weekDay']");
 	By addButtonToCreateWebList 			= By.className("addNewContact");
 	By NameOfUserOnWebListOverlay			= By.id("name");
 	By moblileNumberOfUserOnWebListOverlay 	= By.id("mobileNumber");
 	By newWebListNameOnWebListOverlay 		= By.id("newWebList");
 	By saveContactbuttonOnWebListOverlay 	= By.id("saveContact");
	By errorMessage 						= By.xpath("//*[@id='grpCallMobileContacts']");
	By nameOfUser 							= By.xpath("//*[@id='profileDetails']/p[1]");
 	static By phoneContacts 						= By.xpath("//*[@id='myTabList']//*[contains(@class,'mobileContacts')]");
 	By selectedUserList 					= By.xpath("//*[@class='contacts margin-right-5 margin-bottom-5  selected']");
 	static By overlaySaveGroup 					= By.id("saveDate");
 	By selectedContactFromContactList 		= By.xpath("//*[@class='contacts margin-right-5 margin-bottom-5  selected']");
 	By selectSpecificCharacterOfContacts 	= By.xpath("//*[@id='grpCallMobileContacts']/ul/li[4]");
 	By specificCharaterContacts 			= By.xpath("//*[@id='grpCallMobileContacts']//*[@class='contacts margin-right-5 margin-bottom-5 ']//*[@id='profileDetails']/p[1]");
 	By dialGroupCallButtonOnOverlayInCreateGrpTalk 					= By.xpath("//*[@id='dial']");
 	By usersListFromSelectedContacts								=By.xpath("//div[@id='selectedContacts']//div/div[2]/p[1]");
 	By muteDialButtonOnOverlayInCreateGrpTalk 						= By.id("muteDial");
 	By scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule = By.xpath("//*[@id='datefield']");
 	By scheduleBottonOnAdvancedSettingsOverlayForSchedule 			= By.id("scheduleDate");
 	By incrementDatePickerForMinutes 								= By.xpath("//*[@class='dtpicker-comp minutes']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
 	By onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk = By.xpath("//*[@for='openlineswitch']");
 	By searchAndSelectMemberFieldOnOnAdvancedSettings 				= By.id("txtAssignMangerSchedule");
	By repeatDaysOnAdvancedSettingsForSchedule						= By.xpath("//*[@class='modal-content']//*[@class='row pull-left']//*[@class='btn weekDay']");
	By contactBySearchingInCreatingGrp								= By.xpath("//*[@id='grpCallMobileContacts']//*[@id='profileDetails']/p[1]");
	By contactFromSelectedContactTab 								= By.xpath("//*[@id='selectedContacts']//*[@id='profileDetails']/p[1]");
	By onOffLabelForAssignCallManagerOnSaveGrpOverlay 				= By.xpath("//*[@for='assignManager']");
	By searchAndSelectMemberOnSaveGrpOverlay  						= By.xpath("//*[@id='txtAssignManger']");
	By listContactsONCreateGroupPage 								= By.xpath("//div[@id='grpCallWebContacts']//div[@class='contacts margin-right-5 margin-bottom-5 ']");
	By agendaOfConference											= By.id("txtAgenda");
	By clickweblist													=By.xpath("//*[@class='webContacts']");
	By clickweblist1												=By.xpath("//*[@class='webContacts active']");
	By clickselectedcontacts										=By.xpath("//*[@class='selectedContacts']");
	By clickselectedcontacts1										=By.xpath("//*[@class='selectedContacts active']//*[@class='count']");
	By groups									=By.xpath("//*[@id='grptalks-li']");
	By clipsTabInScheduleGroupOverlay					= By.xpath("//*[@id='datepickerModal']//*[@class='CustomClips']");
	By clipsTabInSaveGroupOverlay						= By.xpath("//*[@id='saveModal']//*[@class='CustomClips']");
	
	By chooseFileForNormalClipOnSaveGroupOverlay 		= By.xpath("//*[@id='clipsTab']//fieldset[1]//input[2][@type='button']");
	By chooseFileForMuteClipOnSaveGroupOverlay 			= By.xpath("//*[@id='clipsTab']//fieldset[2]//input[2][@type='button']");
	By chooseFileForNormalClipOnScheduleOverlay 		= By.xpath("//*[@id='scheduleClipsTab']//fieldSet[1]//input[2][@value='Choose File']");
	By chooseFileForMuteClipOnScheduleOverlay 			= By.xpath("//*[@id='scheduleClipsTab']//fieldSet[2]//input[2][@value='Choose File']");
	
	By deleteNormalClipOptionOnScheduleOverlay 			= By.xpath("//*[@id='scheduleClipsTab']//*[@id='btnDeleteNormalClip']");
	By deleteMuteClipOptionOnScheduleOverlay 			= By.xpath("//*[@id='scheduleClipsTab']//*[@id='btnDeleteMuteClip']");
	By deleteNormalClipOptionOnSaveGroupOverlay 		= By.xpath("//*[@id='clipsTab']//*[@id='btnDeleteNormalClip']");
	By deleteMuteClipOptionOnSaveGroupOverlay  			= By.xpath("//*[@id='clipsTab']//*[@id='btnDeleteMuteClip']");
	
	By normalClipDownloadOptionOnSaveGroupOverlay		= By.xpath("//*[@id='clipsTab']//fieldset[1]//*[@id='spNormalClip']");
	By muteClipDownloadOptionOnSaveGroupOverlay			= By.xpath("//*[@id='clipsTab']//fieldset[2]//*[@id='spNormalClip']");
	By normalClipDownloadOptionOnScheduleOverlay		= By.xpath("//*[@id='scheduleClipsTab']//fieldset[1]//*[@id='spNormalClip']");
	By muteClipDownloadOptionOnScheduleOverlay			= By.xpath("//*[@id='scheduleClipsTab']//fieldset[2]//*[@id='spNormalClip']");
	By normalAudioClipOnSaveGroupOverlay				= By.xpath("//*[@id='clipsTab']//*[@id='TempNormalClip']");
	By muteAudioClipOnSaveGroupOverlay					= By.xpath("//*[@id='clipsTab']//*[@class='MuteClipAudio']//*[@class='pull-left AudioPlay']");
	By normalAudioClipOnScheduleGroupOverlay			= By.xpath("//*[@id='scheduleClipsTab']//*[@id='TempNormalClip']");
	By muteAudioClipOnScheduleGroupOverlay				= By.xpath("//*[@id='scheduleClipsTab']//fieldset[2]//*[@class='pull-left AudioPlay']");
	
	By saveButtonForDuplicateContactsInDiffList = By.id("saveExcelContacts");
 	By createWebListNameFieldOnOverlayByExcelUpload = By.id("xlNewWebList");
 	By uploadButtonForExcelUploadContactsOnOverlay 	= By.id("saveExcelContacts");
 	By buttonForExcelSheetHasHeaderOnOverlay= By.id("header_2");
	By chooseFileButtonOnOverlay 			= By.xpath("//*[@id='excelFormBody']//*[@value='Choose File']");
	By successMsgForCreatedWebListFromExcelUpload = By.className("toast-message");
 	
	
	
	public void uploadNormalClipOnSaveGroupOverlay() throws InterruptedException, AWTException {
		Thread.sleep(1000);
		driver.findElement(clipsTabInSaveGroupOverlay).click();
		Thread.sleep(1000);
		driver.findElement(chooseFileForNormalClipOnSaveGroupOverlay).click();
		CommonMethods.getUploadFile(userDirectory+"\\TestDataFiles\\ConfigureClip.mp3");
		logger_ss.log(Status.INFO, "Uploaded Normalclip");
	}
	
	public void uploadMuteClipOnSaveGroupOverlay() throws InterruptedException, AWTException {
		Thread.sleep(1000);
		driver.findElement(chooseFileForMuteClipOnSaveGroupOverlay).click();
		CommonMethods.getUploadFile(userDirectory+"\\TestDataFiles\\ConfigureClip.mp3");
		logger_ss.log(Status.INFO, "Uploaded mute clip");
	}
	
	public void uploadNormalClipOnScheduleOverlay() throws InterruptedException, AWTException {
		Thread.sleep(1000);
		driver.findElement(clipsTabInScheduleGroupOverlay).click();
		Thread.sleep(1000);
		driver.findElement(chooseFileForNormalClipOnScheduleOverlay).click();
		CommonMethods.getUploadFile(userDirectory+"\\TestDataFiles\\ConfigureClip.mp3");
		logger_ss.log(Status.INFO, "Uploaded Normalclip");
	}
	
	public void uploadMuteClipOnScheduleOverlay() throws InterruptedException, AWTException {
		Thread.sleep(1000);
		driver.findElement(chooseFileForMuteClipOnScheduleOverlay).click();
		CommonMethods.getUploadFile(userDirectory+"\\TestDataFiles\\ConfigureClip.mp3");
		logger_ss.log(Status.INFO, "Uploaded mute clip");
	}
	
	
	public  void giveConferenceAgenda() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(agendaOfConference).sendKeys(CommonMethods.passingData("schdeduleConferenceAgenda"));
	}
	public void selectListContacts(){
		List<WebElement> listContacts = driver.findElements(listContactsONCreateGroupPage);
		for(WebElement ele : listContacts){
			ele.click();
		}
	}
	public int participantsInListContacts(){
		List<WebElement> listContacts = driver.findElements(listContactsONCreateGroupPage);
		return listContacts.size();
	}
	
	public void clickOnGroupsTab() throws InterruptedException{
 		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
 		driver.findElement(groups).click();
 	}
	
	public String createAndCallTheGrp() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(GrpTalks.createGrp).click();
		Thread.sleep(1000);
		CommonMethods.clickMethod(phoneContacts);
		Thread.sleep(1000);
		driver.findElement(search_box).clear();
		//driver.findElement(search_box).sendKeys(JsonData.passingData("enterTestContactInSearchBox"));
		CommonMethods.sendKeysMethod(search_box, "enterTestContactInSearchBox");
		Thread.sleep(1000);
		List<WebElement> ele=listOfUsers();
		int i=0;
		for(WebElement selectContact: ele){
			selectContact.click();
			Thread.sleep(1000);
			if(i==2){
				break;
			}
			i++;
			
		}
		driver.findElement(grpTalkName).clear(); 
		driver.findElement(grpTalkName).sendKeys(name);
		driver.findElement(startNowButton).click();
		Thread.sleep(1000);
		driver.findElement(dialGroupCallButtonOnOverlayInCreateGrpTalk).click(); 
		Thread.sleep(10000);
		return name;
	}
	
	public String createAndCallTheGrpWithRetryContact() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(GrpTalks.createGrp).click();
		Thread.sleep(2000);
		CommonMethods.clickMethod(phoneContacts);
		Thread.sleep(1000);
		driver.findElement(search_box).clear();
		//driver.findElement(search_box).sendKeys(JsonData.passingData("enterTestContactInSearchBox"));
		CommonMethods.sendKeysMethod(search_box, "enterTestContactInSearchBox");
		Thread.sleep(1000);
		List<WebElement> ele=listOfUsers();
		int i=0;
		for(WebElement selectContact: ele){
			selectContact.click();
			Thread.sleep(1000);
			if(i==2){
				break;
			}
			i++;
		}
		driver.findElement(search_box).clear(); 
		CommonMethods.sendKeysMethod(search_box, "retryContactNumber");
		List<WebElement> ele1=listOfUsers();
		for(WebElement selectContact: ele1){
			selectContact.click();
			Thread.sleep(1000);
		}
		driver.findElement(grpTalkName).clear(); 
		driver.findElement(grpTalkName).sendKeys(name);
		driver.findElement(startNowButton).click();
		Thread.sleep(2000);
		driver.findElement(dialGroupCallButtonOnOverlayInCreateGrpTalk).click(); 
		Thread.sleep(15000);
		return name;
	}
	
	public String createAndSaveTheGrpByLeaveGroupName() throws InterruptedException{
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		Thread.sleep(2000);
		driver.findElement(GrpTalks.createGrp).click();
		Thread.sleep(2000);
//		grpTalks.listNameInWebLists(CommonMethods.passingData("newTestList"));
//		crtgrp.selectListContacts();
//		Thread.sleep(1000);
		CommonMethods.clickMethod(phoneContacts);
		Thread.sleep(1000);
		driver.findElement(search_box).clear();
		//driver.findElement(search_box).sendKeys(JsonData.passingData("enterTestContactInSearchBox"));
		CommonMethods.sendKeysMethod(search_box, "enterTestContactInSearchBox");
		Thread.sleep(1000);
		List<WebElement> ele=listOfUsers();
		int i=0;
		for(WebElement selectContact: ele){
			selectContact.click();
			Thread.sleep(1000);
			if(i==2){
				break;
			}
			i++;
		}
		driver.findElement(grpTalkName).clear(); 
		driver.findElement(grpTalkName).sendKeys(CommonMethods.passingData("LeaveGroupGroup"));
		driver.findElement(saveButton).click();
		Thread.sleep(1000);
		driver.findElement(overlaySaveGroup).click();
		Thread.sleep(1000);
		return CommonMethods.passingData("LeaveGroupGroup");
	}
	
	
	public String createAndSaveTheGrp() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(GrpTalks.createGrp).click();
		Thread.sleep(2000);
		CommonMethods.clickMethod(phoneContacts);
		Thread.sleep(1000);
		driver.findElement(search_box).clear();
		//driver.findElement(search_box).sendKeys(JsonData.passingData("enterTestContactInSearchBox"));
		CommonMethods.sendKeysMethod(search_box, "enterTestContactInSearchBox");
		Thread.sleep(1000);
		List<WebElement> ele=listOfUsers();
		int i=0;
		for(WebElement selectContact: ele){
			selectContact.click();
			Thread.sleep(1000);
			if(i==2){
				break;
			}
			i++;
		}
		driver.findElement(grpTalkName).clear(); 
		driver.findElement(grpTalkName).sendKeys(name);
		driver.findElement(saveButton).click();
		Thread.sleep(1000);
		driver.findElement(overlaySaveGroup).click();
		Thread.sleep(1000);
		return name;
	}
	
	String grpName = "Sec"+System.currentTimeMillis();
	public String createAndSaveTheGrpWithSecondaryModerator() throws InterruptedException{
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		Thread.sleep(2000);
		driver.findElement(GrpTalks.createGrp).click();
		Thread.sleep(2000);
//		grpTalks.listNameInWebLists(CommonMethods.passingData("newTestList"));
//		crtgrp.selectListContacts();
//		Thread.sleep(1000);
		CommonMethods.clickMethod(phoneContacts);
		Thread.sleep(1000);
		driver.findElement(search_box).clear();
		//driver.findElement(search_box).sendKeys(JsonData.passingData("enterTestContactInSearchBox"));
		CommonMethods.sendKeysMethod(search_box, "enterTestContactInSearchBox");
		Thread.sleep(1000);
		List<WebElement> ele=listOfUsers();
		int i=0;
		for(WebElement selectContact: ele){
			selectContact.click();
			Thread.sleep(1000);
			if(i==2){
				break;
			}
			i++;
		}
		driver.findElement(grpTalkName).clear(); 
		driver.findElement(grpTalkName).sendKeys(grpName);
		System.out.println("ggg----"+grpName);
		driver.findElement(saveButton).click();
		Thread.sleep(1000);
		driver.findElement(onOffLabelForAssignCallManagerOnSaveGrpOverlay).click();
		driver.findElement(searchAndSelectMemberOnSaveGrpOverlay).sendKeys(CommonMethods.passingData("SecondayModeratorContact"));
		driver.findElement(overlaySaveGroup).click();
		Thread.sleep(1000);
		return grpName;
	}
	
	public String createAndSaveTheGrpWithOneParticipant() throws InterruptedException{
			Assert.assertTrue(CommonMethods.elementExistsOrNot(GrpTalks.createGrp));
			driver.findElement(GrpTalks.createGrp).click();
			Assert.assertTrue(CommonMethods.elementExistsOrNot(CreatingGroup.phoneContacts));
			CommonMethods.clickMethod(phoneContacts);
			//Thread.sleep(1000);
			driver.findElement(search_box).clear();
			driver.findElement(search_box).sendKeys(CommonMethods.passingData("enterTestContact1InSearchBox"));
			List<WebElement> ele=listOfUsers();
			ele.get(0).click();
			driver.findElement(grpTalkName).clear(); 
			driver.findElement(grpTalkName).sendKeys(name);
			driver.findElement(saveButton).click();
			//Thread.sleep(1000);
			boolean check=CommonMethods.elementExistsOrNot(CreatingGroup.overlaySaveGroup);
			Assert.assertTrue(check);
			System.out.println("after overlay assertion:"+check);
			driver.findElement(overlaySaveGroup).click();
			//Thread.sleep(1000);
			return name;
	}
 	
	public boolean visibilityOfselectMemberFieldToManageCallOnOverlay() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(searchAndSelectMemberFieldOnOnAdvancedSettings);
  		return driver.findElement(searchAndSelectMemberFieldOnOnAdvancedSettings).isDisplayed();
  	}
	
	public void enterContactDetailsInSelectMemberFieldToManageCallOnOverlay() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(searchAndSelectMemberFieldOnOnAdvancedSettings);
		driver.findElement(searchAndSelectMemberFieldOnOnAdvancedSettings).sendKeys(CommonMethods.passingData("EnterTestInsearchAndSelectMemberField"));
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='ui-menu-item']"));
		list.get(0).click();
	}
 	
 	public void onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk() throws InterruptedException{
  		Thread.sleep(2000);
  		driver.findElement(onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk).click();
  	}
 	
	public boolean visibilityOfOnOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettings() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk);
  		return driver.findElement(onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk).isDisplayed();
  	}
	
	public void clickScheduleButtonOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		Thread.sleep(2000);
 		//ReusableMethods.explicitWaitForElementVisibility(driver,scheduleBottonOnAdvancedSettingsOverlayForSchedule);
 		driver.findElement(scheduleBottonOnAdvancedSettingsOverlayForSchedule).click();
 	}
 	
	public void scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule);
 		driver.findElement(scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule).click();
 	}
 	
	public void clickMuteDialButtonOnOverlayInCreateGrpTalk() throws InterruptedException{
 		driver.findElement(muteDialButtonOnOverlayInCreateGrpTalk).click();
 		Thread.sleep(25000);
 	}
 	
    public List<String> ListOfGroupContactsFromSelectedContacts() throws InterruptedException{
    	List<String> actualResult = new ArrayList<String>();
    	List<WebElement> allUsers = driver.findElements(usersListFromSelectedContacts);
    	for (int j=0; j<allUsers.size(); j++){
    	  actualResult.add(allUsers.get(j).getText());
    	}    
    	return actualResult;
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

    public int selectSpecificCharacterOfContacts() throws InterruptedException{
    	Thread.sleep(4000);
    	driver.findElement(selectSpecificCharacterOfContacts).click();
    	Thread.sleep(1000);
    	List<WebElement> ele= driver.findElements(specificCharaterContacts);
    	int s=ele.size();
    	return s;
    }
 	
 	public int selectedContactFromContactList() throws InterruptedException{
 	    	CommonMethods.explicitWaitForElementVisibility(selectedContactFromContactList);
 	    	List<WebElement> listofUsers= driver.findElements(selectedContactFromContactList);
 	    	return listofUsers.size();
 	}
 	
    public void enterNameInSearchBox(String str) throws InterruptedException{
    	CommonMethods.explicitWaitForElementVisibility(search_box);
    	String name = str;
    	driver.findElement(search_box).clear();
       	driver.findElement(search_box).sendKeys(name);
       	Thread.sleep(1000);
    }
    
    public void submitSaveGroupOnOverlay() throws InterruptedException{
    	CommonMethods.explicitWaitForClickableElement(driver,driver.findElement(overlaySaveGroup));
    	driver.findElement(overlaySaveGroup).click();
    }
 	
    public int selectedUserCount() throws InterruptedException{
    	CommonMethods.explicitWaitForElementVisibility(selectedUserList);
    	List<WebElement> listofUsers = driver.findElements(selectedUserList);
    	return listofUsers.size();
    }
 	
    public String nameofUser() throws InterruptedException{
    	CommonMethods.explicitWaitForElementVisibility(nameOfUser);
    	return driver.findElement(nameOfUser).getText();
    }
 	
    public void clickPhoneContactsTab() throws InterruptedException{
    	Thread.sleep(1000);
    	driver.findElement(phoneContacts).click();
    	Thread.sleep(1000);
    }
	
    String listName = "List "+System.currentTimeMillis();
    
    By excelUploadTab = By.id("excelUpload");
    
 	public String createWebLIst() throws InterruptedException{
 		String listName = "List "+System.currentTimeMillis();
 		driver.findElement(addButtonToCreateWebList).click();
 		driver.findElement(NameOfUserOnWebListOverlay).sendKeys(CommonMethods.passingData("NameOfUserOnWebListOverlay"));
 		driver.findElement(moblileNumberOfUserOnWebListOverlay).sendKeys(CommonMethods.passingData("moblileNumberOfUserOnWebListOverlay"));
 		driver.findElement(newWebListNameOnWebListOverlay).sendKeys(listName);
 		driver.findElement(saveContactbuttonOnWebListOverlay).click();
 		driver.navigate().refresh();
 		return listName;
 	}
 	
	public void clickPlusButtonToCreateNewWebList() throws InterruptedException{
 		driver.findElement(addButtonToCreateWebList).click();
 		driver.findElement(excelUploadTab).click();
	}
	
	public void clickExcelUploadTabOnOverlay() {
		driver.findElement(excelUploadTab).click();
	}
	public  int listOfContactsInWebList(){
 		List<WebElement> listOfContactsInWebList=driver.findElements(webListAllContactsOnContactsPage);
 		return listOfContactsInWebList.size();
 	}
	
	public  int listOfContactsInWebListOnCrtGrpPage(){
 		List<WebElement> listOfContactsInWebList=driver.findElements(webListAllContactsOnContactsPage);
 		return listOfContactsInWebList.size();
 	}
 	
	By webListAllContactsOnContactsPage 	= By.xpath("//*[@id='webLists']//div[@id='profileDetails']");
	
 	public String givenExcelSheetDetailsOnOverlay() throws InterruptedException{
 		Thread.sleep(1000);
 		driver.findElement(buttonForExcelSheetHasHeaderOnOverlay).click();
 		Select name=new Select(driver.findElement(By.id("ddlname_Sheet1")));
 		name.selectByVisibleText("Column A");
 		Select number=new Select(driver.findElement(By.id("ddlmobile_Sheet1")));
 		number.selectByVisibleText("Column B");
 		driver.findElement(createWebListNameFieldOnOverlayByExcelUpload).sendKeys(listName);
 		driver.findElement(uploadButtonForExcelUploadContactsOnOverlay).click();
 		Thread.sleep(2000);
 		//driver.findElement(saveButtonForDuplicateContactsInDiffList).click();
 		//Thread.sleep(2000);
 		System.out.println("listName="+listName);
 		return listName;
 	}
 	
	public String successMsgForCreatedWebListFromExcelUpload() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(successMsgForCreatedWebListFromExcelUpload);
 		return driver.findElement(successMsgForCreatedWebListFromExcelUpload).getText();
 	}
	public void clickChooseFileButtonOnOverlay() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(chooseFileButtonOnOverlay);
 		driver.findElement(chooseFileButtonOnOverlay).click();
 	}
 	
	public String repeatDaysOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		Actions actions=new Actions(driver);
 		CommonMethods.explicitWaitForElementVisibility(repeatDaysOnAdvancedSettings);
 		List<WebElement> element=driver.findElements(repeatDaysOnAdvancedSettings);
 		actions.moveToElement(element.get(2));
 		element.get(2).click();
 		String s=" "+element.get(2).getText();
 		return s;
 		
 	}
	
	public void datePickerSetButtonOnOverlay() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(datePickerSetButtonOnOverlay);
 		driver.findElement(datePickerSetButtonOnOverlay).click();
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
	
	public void incrementDatePickerForMinutes(int minutes) throws InterruptedException{
 		for(int i=0;i<minutes;i++){
 			driver.findElement(incrementDatePickerForMinutes).click();
 		}
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
 		CommonMethods.explicitWaitForElementVisibility(decrementDatePickerForMinutes);
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
 
 	public void onOffSwitchLabelForDialInOnlyOptionOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(onOffSwitchLabelForDialInOnlyOnAdvancedSettings);
 		driver.findElement(onOffSwitchLabelForDialInOnlyOnAdvancedSettings).click();
 	}
 	
 	public void onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(onOffSwitchLabelForAllowNonMembersOnAdvancedSettings);
 		driver.findElement(onOffSwitchLabelForAllowNonMembersOnAdvancedSettings).click();
 	}
 	
 	public void onOffSwitchLabelForMuteDialOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(onOffSwitchLabelForAllowNonMembersOnAdvancedSettings);
 		driver.findElement(onOffSwitchLabelForMuteDialOnAdvancedSettings).click();
 	}
 	
 	public void onOffSwitchLabelForAssignCallManagerOnAdvancedSettingsOverlayForSchedule() throws InterruptedException{
 		Thread.sleep(2000);
		driver.findElement(onOffSwitchLabelForAssignCallManagerOnAdvancedSettings).click();
 	}
	
    public void selectedContactsTab() throws InterruptedException
    {
    	Thread.sleep(2000);
    	CommonMethods.explicitWaitForElementVisibility(selectedContacts);
    	driver.findElement(selectedContacts).click();
    }
    
    public int numberOfUsersFromSelectedContactsTab() throws InterruptedException
    {
    	String str = driver.findElement(selectedContactsTab).getText();
    	String intValue = str.replaceAll("[^0-9]", "");
    	Integer i = Integer.parseInt(intValue);
    	return i;
    }
    
    public void selectTestContactsFromContactList() throws InterruptedException{
//    	CommonMethods.explicitWaitForElementVisibility(search_box);
//    	Thread.sleep(1000);
    	driver.findElement(search_box).clear();
       	driver.findElement(search_box).sendKeys(CommonMethods.passingData("enterTestContactInSearchBox"));
       	Thread.sleep(2000);
       	List<WebElement> ele=listOfUsers();
       	int j=0;
       	for(int i=0;i<ele.size();i++){
       		Thread.sleep(1000);
       		ele.get(i).click();
       		if(j==2){
       			break;
       		}
       		j++;
       	}
    }
    
    public void deselectTestContactsFromContactList() throws InterruptedException{
//    	CommonMethods.explicitWaitForElementVisibility(search_box);
//    	Thread.sleep(1000);
    	driver.findElement(search_box).clear();
       	driver.findElement(search_box).sendKeys(CommonMethods.passingData("enterTestContactInSearchBox"));
       	Thread.sleep(2000);
       	List<WebElement> ele=listOfUsers1();
       	int j=0;
       	for(int i=0;i<ele.size();i++){
       		Thread.sleep(1000);
       		ele.get(i).click();
       		if(j==2){
       			break;
       		}
       		j++;
       	}
    }
    
    public String selectContactFromContactList() throws InterruptedException{
    	driver.findElement(search_box).clear();
       	driver.findElement(search_box).sendKeys(CommonMethods.passingData("enterTestContact1InSearchBox"));
       	String contactName = CommonMethods.passingData("enterTestContact1InSearchBox");
       	List<WebElement> ele=listOfUsers();
       	ele.get(0).click();
       	return contactName;
       	
    }
    
    public void selectContactsFromContactList() throws InterruptedException{
    	driver.findElement(search_box).clear();
       	driver.findElement(search_box).sendKeys(CommonMethods.passingData("enterTestContactInSearchBox"));
       	List<WebElement> ele=listOfUsers();
       	int i=0;
       	for(WebElement selectContact: ele){
       		selectContact.click();
       		Thread.sleep(1000);
       		if(i==2){
       			break;
       		}
       		i++;
       	}
    }
    
    public void selectFewContactsFromContactList() throws InterruptedException{
    	driver.findElement(search_box).clear();
      // 	driver.findElement(search_box).sendKeys(JsonData.passingData("enterTestContactInSearchBox"));
    	driver.findElement(search_box).sendKeys("8331996838");
       	List<WebElement> ele=listOfUsers();
       	for(WebElement selectContact: ele){
       		selectContact.click();
       		Thread.sleep(1000);
       	}
       	driver.findElement(search_box).clear();
        // 	driver.findElement(search_box).sendKeys(JsonData.passingData("enterTestContactInSearchBox"));
      	driver.findElement(search_box).sendKeys("8019606646");
         	List<WebElement> ele1=listOfUsers();
         	for(WebElement selectContact: ele1){
         		selectContact.click();
         		Thread.sleep(1000);
         	}
    }
    
    public int numberOfContactsInPhoneContactsTab() throws InterruptedException{
    	Thread.sleep(2000);
    	List<WebElement> listofUsers = driver.findElements(namesOfUsers);
    	return listofUsers.size();
    }
    
    public List<WebElement> listOfUsers() throws InterruptedException{
    	//CommonMethods.explicitWaitForElementVisibility(namesOfUsers);
    	CommonMethods.elementExistsOrNot(namesOfUsers);
    	Thread.sleep(1000);
    	List<WebElement> listofUsers = driver.findElements(namesOfUsers);
    	return listofUsers;
    }
    
    public List<WebElement> listOfUsers1() throws InterruptedException{
    	//CommonMethods.explicitWaitForElementVisibility(namesOfUsers);
    	CommonMethods.elementExistsOrNot(namesOfUsers1);
    	Thread.sleep(1000);
    	List<WebElement> listofUsers = driver.findElements(namesOfUsers1);
    	return listofUsers;
    }

    public String addMorethanNineUserFromContactList() throws InterruptedException{
//    	CommonMethods.explicitWaitForElementVisibility(search_box);
//    	Thread.sleep(1000);
//    	driver.findElement(search_box).clear();
//       	driver.findElement(search_box).sendKeys(CommonMethods.passingData("searchContactsWithNameAuto"));
//       	Thread.sleep(2000);
    	List<WebElement> ele=listOfUsers();
    	int i;
    	Actions actions= new Actions(driver);
       	for(i=0;i<27;i=i+3)
    	{
       		actions.moveToElement(ele.get(i));
     		actions.perform();
    		ele.get(i).click();
    	}
       	clickPhoneContactsTab();
    	actions.moveToElement(ele.get(i++));
 		actions.perform();
    	ele.get(i++).click();
     	return ele.get(0).getAttribute("name");
    }

    public void clearGrpTalkName() throws InterruptedException{
    	driver.findElement(grpTalkName).clear();
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
    
    String name = "Test_"+System.currentTimeMillis();
    
    public String setGrpTalkName() throws InterruptedException{
    	driver.findElement(grpTalkName).clear(); 
    	driver.findElement(grpTalkName).sendKeys(name);
    	return name;
    }
 	
    public void submitStartNowButton() throws InterruptedException{
    	CommonMethods.explicitWaitForElementVisibility(startNowButton);
    	driver.findElement(startNowButton).click();
    	Thread.sleep(2000);
    }
    
    public void submitSaveButton() throws InterruptedException{
    	CommonMethods.explicitWaitForElementVisibility(saveButton);
    	driver.findElement(saveButton).click();
    }
    
    public void submitScheduleButton() throws InterruptedException{
    	CommonMethods.explicitWaitForElementVisibility(scheduleButton);
    	driver.findElement(scheduleButton).click();
    }
    
    
    public void clickweblisttab() throws InterruptedException{
    	//CommonMethods.explicitWaitForElementVisibility(clickweblist);
    	//CommonMethods.elementExistsOrNot(clickweblist);
    	Thread.sleep(1000);
    	driver.findElement(clickweblist).click();
    }
    
    public void clickweblisttab1() throws InterruptedException{
    	//CommonMethods.explicitWaitForElementVisibility(clickweblist);
    	//CommonMethods.elementExistsOrNot(clickweblist);
    	Thread.sleep(1000);
    	driver.findElement(clickweblist1).click();
    }
    
    
    
    public int clickselectedcontactstab() throws InterruptedException{
    	//CommonMethods.explicitWaitForElementVisibility(clickweblist);
    	//CommonMethods.elementExistsOrNot(clickweblist);
    	Thread.sleep(1000);
    	driver.findElement(clickselectedcontacts).click();
    	Thread.sleep(1000);
    	int count = Integer.parseInt((driver.findElement(clickselectedcontacts1).getText()).replaceAll("[^0-9]", ""));
    	//int count = driver.findElements(clickselectedcontacts1).size();
    	return count;
    	
    }
}

