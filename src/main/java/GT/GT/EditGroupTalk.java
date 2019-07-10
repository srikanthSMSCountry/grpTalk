package GT.GT;
import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import utility.*;

public class EditGroupTalk extends BrowserFunctions{
  
	private static final TimeUnit SECONDS = null;

	By editGroupCallButton													=By.id("editGroupCall");
 	By onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk 		= By.xpath("//*[@for='savedialinswitch']");
 	By onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk 	= By.xpath("//*[@for='saveallownonswitch']");
 	By onOffSwitchLabelForMuteDialOnAdvancedSettingsInEditGrpTalk 			= By.xpath("//*[@for='savemutedialswitch']");
 	By onOffSwitchLabelForAssignCallManagerOnAdvancedSettingsInEditGrpTalk 	= By.xpath("//*[@for='assignManagerEdit']");
 	By onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk = By.xpath("//*[@for='openlineswitch']");
 	By saveButtonOnAdvancedSettingInEditGrpTalk 			= By.id("okBtn");
	By saveGroupCallButtonOnEditGrpTalk						= By.xpath("//*[@class='form-inline']//*[@id='saveGrpCall']");
	By scheduleDateAndTimeFieldOnEditGroupTalkPage 			= By.xpath("//*[@id='conf_datetime']");
	By repeatDaysFiledOnEditGrpTalk 						= By.id("repeat");
	By setButtonONOverlayOnEditGrpTalk 						= By.id("setRepeat");
 	By repeatDaysOnAdvancedSettingsOverlyInEditGrpTalk 		= By.xpath("//*[@class='modal-content']//*[@class='btn weekDay']");
 	By incrementDatePickerForMinutes 						= By.xpath("//*[@class='dtpicker-comp minutes']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
 	By dateAndTimeTextOnOverlay 							= By.className("dtpicker-value");
 	By datePickerSetButtonOnOverlay 						= By.xpath("//*[@class='dtpicker-button dtpicker-buttonSet']");
	By incrementDatePickerForDay 							= By.xpath("//*[@class='dtpicker-comp day']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
	By incrementDatePickerForMonth 							= By.xpath("//*[@class='dtpicker-comp month']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
	By incrementDatePickerForYear 							= By.xpath("//*[@class='dtpicker-comp year']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
	By decrementDatePickerForDay 							= By.xpath("//*[@class='dtpicker-comp day']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By decrementDatePickerForMonth 							= By.xpath("//*[@class='dtpicker-comp month']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By decrementDatePickerForYear 							= By.xpath("//*[@class='dtpicker-comp year']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By decrementDatePickerForHour 							= By.xpath("//*[@class='dtpicker-comp hour']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
 	By decrementDatePickerForMinutes 						= By.xpath("//*[@class='dtpicker-comp minutes']//*[@class='dtpicker-compButton decrement dtpicker-compButtonEnable']");
	By incrementDatePickerForHour 							= By.xpath("//*[@class='dtpicker-comp hour']//*[@class='dtpicker-compButton increment dtpicker-compButtonEnable']");
	By repeatDaysOnAdvancedSettings 						= By.xpath("//*[@class='modal-content']//*[@class='btn weekDay']");
	By advacedSettingOnEditGrpTalk 							= By.xpath("//*[@id='content']//*[@class='form-inline']//*[@id='adSettings']");
	By selectedContactsTab 									= By.xpath("//*[@id='myTabList']/li[3]/a/span");
	By contactOfUser										= By.xpath("//*[@id='grpCallMobileContacts']//*[@id='profileDetails']");
	By searchBox											= By.id("search-input");
 	By agendOptionInEditGrpTalk								= By.id("openAgenda");
 	By textAgenda											= By.id("txtAgenda");
 	By addButtonOnAgendaOverlay								= By.id("setAgenda");
 	
	By chooseFileOptionForNormalClipOnUploadClipsOverlayInEditGroup 	= By.xpath("//*[@id='upload-pics-inputs-container']//fieldset[1]//input[2][@type='button']");
	By chooseFileOptionForMuteClipOnUploadClipsOverlayInEditGroup 		= By.xpath("//*[@id='upload-pics-inputs-container']//fieldset[2]//input[2][@type='button']");
	
	By deleteNormalClipOptionOnUploadClipsOverlayInEditGroup 			= By.xpath("//*[@id='upload-pics-inputs-container']//*[@id='btnDeleteNormalClip']");
	By deleteMuteClipOptionOnUploadClipsOverlayInEditGroup  			= By.xpath("//*[@id='upload-pics-inputs-container']//*[@id='btnDeleteMuteClip']");
	
	By normalClipDownloadOptionOnUploadClipsOverlayInEditGroup			= By.xpath("//*[@id='upload-pics-inputs-container']//fieldset[1]//*[@id='spNormalClip']");
	By muteClipDownloadOptionOnUploadClipsOverlayInEditGroup			= By.xpath("//*[@id='upload-pics-inputs-container']//fieldset[2]//*[@id='spNormalClip']");
	
	By saveButtonOnUploadClipsOverlay									= By.id("saveClips");
	By uploadClipFieldInEditGroup										= By.id("adClips");
	
	By normalAudioClipOnEditGroupOverlay    	= By.xpath("//*[@id='upload-pics-inputs-container']//fieldset[1]//*[@id='spMuteclip']");
	By muteAudioClipOnEditGroupOverlay    	= By.xpath("//*[@id='upload-pics-inputs-container']//fieldset[2]//*[@id='spMuteclip']");
	
	public boolean visibilityOfSavedNormalClipOnUploadClipsOverlayInEditGroup(){
		List<WebElement> normalClip = driver.findElements(normalAudioClipOnEditGroupOverlay);
		if(normalClip.size()==0){
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean visibilityOfSavedMuteClipOnUploadClipsOverlayInEditGroup(){
		List<WebElement> normalClip = driver.findElements(muteAudioClipOnEditGroupOverlay);
		if(normalClip.size()==0){
			return false;
		}
		else{
			return true;
		}
	}
	
	public void deleteMuteAndNormalClipsFromEditGroup() throws InterruptedException{
		driver.findElement(deleteNormalClipOptionOnUploadClipsOverlayInEditGroup).click();
		driver.findElement(deleteMuteClipOptionOnUploadClipsOverlayInEditGroup).click();
		Thread.sleep(1000);
	}
	
	public void clickuploadClipFieldInEditGroup() throws InterruptedException{
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(uploadClipFieldInEditGroup)).perform();
		driver.findElement(uploadClipFieldInEditGroup).click();
		Thread.sleep(1000);
	}
	
	public void submitSaveButtonOnUploadClipsOverlay() throws InterruptedException{
		driver.findElement(saveButtonOnUploadClipsOverlay).click();
		Thread.sleep(1000);
	}
	
	public void uploadNormalClipOnEditGroupOverlay() throws InterruptedException, AWTException {
		Thread.sleep(1000);
		driver.findElement(chooseFileOptionForNormalClipOnUploadClipsOverlayInEditGroup).click();
		CommonMethods.getUploadFile(userDirectory+"\\TestDataFiles\\ConfigureClip.mp3");
		logger_ss.log(Status.INFO, "Uploaded Normalclip");
	}
	
	public void uploadMuteClipOnEditGroupOverlay() throws InterruptedException, AWTException {
		Thread.sleep(1000);
		driver.findElement(chooseFileOptionForMuteClipOnUploadClipsOverlayInEditGroup).click();
		CommonMethods.getUploadFile(userDirectory+"\\TestDataFiles\\ConfigureClip.mp3");
		logger_ss.log(Status.INFO, "Uploaded Normalclip");
	}
	
	
	
 	public void enterAgendaInEditGrpTalk() throws InterruptedException{
 		Thread.sleep(1000);
 		driver.findElement(agendOptionInEditGrpTalk).click();
 		Thread.sleep(1000);
 		driver.findElement(textAgenda).sendKeys(CommonMethods.passingData("schdeduleConferenceAgenda"));
 		driver.findElement(addButtonOnAgendaOverlay).click();
 		Thread.sleep(1000);
 	}
 	
 	public void clickAdvacedSettingOnEditGrpTalk() throws InterruptedException{
 		Thread.sleep(2000);
 		Actions action = new Actions(driver);
 		action.moveToElement(driver.findElement(advacedSettingOnEditGrpTalk)).perform();
  		CommonMethods.explicitWaitForElementVisibility(advacedSettingOnEditGrpTalk);
  		Thread.sleep(1000);
 		driver.findElement(advacedSettingOnEditGrpTalk).click();
 	}
 	
 	public int removeContactFromSavedGroup(String name) throws InterruptedException{
 		CreatingGroup crtGrp = new CreatingGroup();
 		GrpTalks grpTalks = new GrpTalks();
 		driver.findElement(editGroupCallButton).click();
 		CommonMethods.explicitWaitForAlert(driver);
 		driver.switchTo().alert().accept();
 		Thread.sleep(2000);
 		crtGrp.selectedContactsTab();
 		Thread.sleep(1000);
 		List<WebElement> contacts = driver.findElements(crtGrp.usersListFromSelectedContacts);
 		String contactName = contacts.get(0).getText();
       	contacts.get(0).click();
 		int contactsCount= crtGrp.numberOfUsersFromSelectedContactsTab();
 		driver.findElement(saveGroupCallButtonOnEditGrpTalk).click();
 		grpTalks.selectRecentlySavedGrpTalkGroup(name);
 		return contactsCount;
 	}
	
	public void datePickerSetButtonOnOverlay() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(datePickerSetButtonOnOverlay);
 		driver.findElement(datePickerSetButtonOnOverlay).click();
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
	
	public void decrementDateAndTimeOnOverlay(int value) throws InterruptedException{
 		decrementDatePickerForYear(value);
 		decrementDatePickerForMonth(value);
 		decrementDatePickerForDay(value);
 		decrementDatePickerForMinutes(value);
 		decrementDatePickerForHour(value);
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
 	
	public void incrementDatePickerForMinutes(int minutes) throws InterruptedException{
 		for(int i=0;i<minutes;i++){
 			driver.findElement(incrementDatePickerForMinutes).click();
 		}
 	}
	
	public String dateAndTimeTextOnOverlay() throws InterruptedException{
 		String s=driver.findElement(dateAndTimeTextOnOverlay).getText();
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
	
	public void setButtonONOverlayOnEditGrpTalk() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(setButtonONOverlayOnEditGrpTalk);
 		driver.findElement(setButtonONOverlayOnEditGrpTalk).click();
 		Thread.sleep(1000);
 	}
 	
 	public void clickRepeatDaysFiledOnEditGrpTalk() throws InterruptedException{
 		Thread.sleep(2000);
 		driver.findElement(repeatDaysFiledOnEditGrpTalk).click();
 	}
 	
	public void incrementDateAndTimeOnOverlay(int value) throws InterruptedException{
 		incrementDatePickerForDay(value);
 		incrementDatePickerForMonth(value);
 		incrementDatePickerForYear(value);
 		incrementDatePickerForHour(value);
 		incrementDatePickerForMinutes(value);
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
 	
 	public void clickScheduleDateAndTimeFieldOnEditGroupTalkPage() throws InterruptedException{
 		Thread.sleep(2000);
 		driver.findElement(scheduleDateAndTimeFieldOnEditGroupTalkPage).click();
 	}
 	
	public boolean visibilityOfOnOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettings() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk);
  		return driver.findElement(onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk).isDisplayed();
  	}
	
  	public void clickSaveGrpCallOnEditGrpTalk() throws InterruptedException{
  		Thread.sleep(2000);
  		Actions actions=new Actions(driver);
  		actions.moveToElement(driver.findElement(saveGroupCallButtonOnEditGrpTalk));
		actions.perform();
  		driver.findElement(saveGroupCallButtonOnEditGrpTalk).click();
  		Thread.sleep(2000);
  	}
  	
  	public void saveButtonOnAdvancedSettingInEditGrpTalk() throws InterruptedException{
  		CommonMethods.explicitWaitForElementVisibility(saveButtonOnAdvancedSettingInEditGrpTalk);
  		driver.findElement(saveButtonOnAdvancedSettingInEditGrpTalk).click();
  	}
 	
  	public void onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk() throws InterruptedException{
  		CommonMethods.explicitWaitForElementVisibility(onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk);
  		WebElement ele = driver.findElement(onOffSwitchLabelForDialInOnlyOnAdvancedSettingsInEditGrpTalk);
  		String s = ele.getAttribute("content");
  		ele.click();
  	}
  	
  	public void onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk() throws InterruptedException{
  		CommonMethods.explicitWaitForElementVisibility(onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk);
  		driver.findElement(onOffSwitchLabelForAllowNonMembersOnAdvancedSettingsInEditGrpTalk).click();
  	}
  	
  	public void onOffSwitchLabelForMuteDialOnAdvancedSettingsInEditGrpTalk() throws InterruptedException{
  		CommonMethods.explicitWaitForElementVisibility(onOffSwitchLabelForMuteDialOnAdvancedSettingsInEditGrpTalk);
  		driver.findElement(onOffSwitchLabelForMuteDialOnAdvancedSettingsInEditGrpTalk).click();
  	}
  	
  	public void onOffSwitchLabelForAssignCallManagerOnAdvancedSettingsInEditGrpTalk() throws InterruptedException{
  		CommonMethods.explicitWaitForElementVisibility(onOffSwitchLabelForAssignCallManagerOnAdvancedSettingsInEditGrpTalk);
  		driver.findElement(onOffSwitchLabelForAssignCallManagerOnAdvancedSettingsInEditGrpTalk).click();
  	}
  	
  	public void onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk() throws InterruptedException{
  		Thread.sleep(2000);
  		driver.findElement(onOffSwitchLabelForOpenLineBeforeThirtyMinutesOnAdvancedSettingsInEditGrpTalk).click();
  	}
  	public List<WebElement> listOfUsers() throws InterruptedException{
    	CommonMethods.explicitWaitForElementVisibility(contactOfUser);
    	List<WebElement> listofUsers = driver.findElements(contactOfUser);
    	return listofUsers;
    }
  	
    public void selectSecondUserFromContactList() throws InterruptedException{
    	CommonMethods.explicitWaitForElementVisibility(searchBox);
    	driver.findElement(searchBox).sendKeys(CommonMethods.passingData("enterTestContact2InSearchBox"));
    	List<WebElement> ele=listOfUsers();
		ele.get(0).click();
    	Thread.sleep(1000);
    }
	
	public int editSavedGroupCall(String name) throws InterruptedException{
		CreatingGroup crtGrp = new CreatingGroup();
 		GrpTalks grpTalks = new GrpTalks();
 		driver.findElement(editGroupCallButton).click();
 		CommonMethods.explicitWaitForAlert(driver);
 		driver.switchTo().alert().accept();
 		Thread.sleep(2000);
 		crtGrp.clickPhoneContactsTab();
 		selectSecondUserFromContactList();
 		int selectedUsersCount=crtGrp.selectedUserCount();
 		crtGrp.selectedContactsTab();
 		int x= crtGrp.numberOfUsersFromSelectedContactsTab();
 		driver.findElement(saveGroupCallButtonOnEditGrpTalk).click();
 		grpTalks.selectRecentlySavedGrpTalkGroup(name);
 		return x;
 	}
}

