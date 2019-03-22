
package GT.GT;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//import TestGrpTalk.GrpTalkTest.Compare_Files;

public class ContactsPage {
	
	WebDriver driver;

 	By contactsTab = By.xpath("//*[@id='contacts-li']/a");
 	By createNewGrpListButton = By.id("createGrpList"); 
 	By listNameField = By.id("addLisItem");
 	By groupOfWebLists = By.xpath("//*[@id='list-group']//*[@class='contactList']/span[1]");
 	By dropDownToggleOfWebList = By.xpath("//*[@id='list-group']//*[@class='list highlight']//*[@class=' dropdown dropdown-toggle']");
 	//*[@id='list-group']//*[@class='list highlight']//*[@class='dropdown-menu dropdown-menu-right']//*[@class='deleteListName']
 	By deleteListName = By.xpath("//*[@class='list highlight']//*[@class='deleteListName']");
 	By editListName = By.xpath("//*[@class='list highlight']//*[@class='editListName']");
 	By addNewContactToList = By.xpath("//*[@class='list highlight']//*[@class='addNewContact']");
 	By reNameListName = By.xpath("//*[@class='list highlight']//*[contains(@id,'editLisItemInput')]");
 	By addContactsTabOnOverlay = By.xpath("//*[@id='listContactsModal']/li[1]");
 	By webListTabOnOverlay = By.xpath("//*[@id='listContactsModal']/li[2]");
 	By mobileContactsTabOnOverlay = By.xpath("//*[@id='listContactsModal']/li[3]");
 	By excelUploadTabOnOverlay = By.xpath("//*[@id='listContactsModal']/li[4]");
 	By addToListButtonOnOverlay = By.id("saveListContact");
 	By addcontactButtonOnOverlay = By.id("addCntctList");
 	By closeListButtonOnOverlay =By.id("closeList");
 	By nameFieldInAddContactsTabOnOverlay = By.id("name");
 	By mobileNumberFieldInAddContactsTabOnOverlay = By.id("mobileNumber");
 	By imageUploadButtonInAddContactsTabOnOverlay = By.xpath("//*[@id='addListContactsModal']/div[4]/div/input[1]");
 	By webListAllContactsOnContactsPage = By.xpath("//*[@id='webLists']//div[@id='profileDetails']");
 	By addedContactNameOnContactsPage = By.xpath("//*[@id='webLists']//div[@id='profileDetails']/p[1]");
 	By addedContactNumberOnContactsPage = By.xpath("//*[@id='webLists']//div[@id='profileDetails']/p[2]");
 	By listGroupsInWebListOnOverlay =By.xpath("//*[@id='list-groupmodal']//span");
 	By listOfUsersInWebListGroupOnOverlay = By.xpath("//*[contains(@class, 'contacts margin-bottom-5 margin-right-5 membersList')]//*[@id='profileDetails']/p[1]");
 	By successMsgForContactAddedToList =By.className("toast-message");
 	By contactsInMobileContactsTabOnOverlay = By.xpath("//*[@id='mobileContacts']//*[contains(@class,'contacts margin-right-5 margin-bottom-5')]//*[@id='profileDetails']/p[1]");
 	By addToListButtonInMobileContactsOnOverlay = By.id("saveListContact");
 	By deleteContactNameFromList = By.xpath("//*[@id='webLists']//div[@class='contact_actions']//*[@class='delete']");
 	By liveCallButton =By.xpath("//*[@id='date']//label");
 	By hangUpAllButtonInGrpCall = By.xpath("//*[@id='hangup']/a/img");
 	By plusButtonToCreateNewWebList = By.xpath("//*[@class='page-content']//*[@id='plusSymbol']");
 	By createWebListFiledOnOverlay = By.id("newWebList");
 	By successMsgForCreatedWebList= By.className("toast-message");
 	By chooseFileButtonOnOverlay = By.xpath("//*[@class='table no-border']//*[@class='btn btn-danger']");
 	By buttonForExcelSheetHasHeaderOnOverlay = By.id("header_2");
 	By createWebListNameFieldOnOverlayByExcelUpload = By.id("xlNewWebList");
 	By uploadButtonForExcelUploadContactsOnOverlay = By.id("saveExcelContacts");
 	
 	public void givenExcelSheetDetailsOnOverlay() throws InterruptedException{
 		Thread.sleep(1000);
 		driver.findElement(buttonForExcelSheetHasHeaderOnOverlay).click();
 		Select name=new Select(driver.findElement(By.id("ddlname_Sheet1")));
 		name.selectByVisibleText("Column A");
 		Select number=new Select(driver.findElement(By.id("ddlmobile_Sheet1")));
 		number.selectByVisibleText("Column B");
 		driver.findElement(createWebListNameFieldOnOverlayByExcelUpload).sendKeys(listName);
 		driver.findElement(uploadButtonForExcelUploadContactsOnOverlay).click();
 	}
 	
 	public  int listOfContactsInWebList(){
 		List<WebElement> listOfContactsInWebList=driver.findElements(webListAllContactsOnContactsPage);
 		return listOfContactsInWebList.size();
 	}
 	
//	public void getUploadFile(String filepath) throws InterruptedException, AWTException {
//		String s= filepath;
//				setClipboardData(s);
//				Robot robot = new Robot();
//				robot.keyPress(KeyEvent.VK_CONTROL);
//				robot.keyPress(KeyEvent.VK_V);
//				robot.keyRelease(KeyEvent.VK_V);
//				robot.keyRelease(KeyEvent.VK_CONTROL);
//				robot.keyPress(KeyEvent.VK_ENTER);
//				robot.keyRelease(KeyEvent.VK_ENTER);
//	}

	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste
		// operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
	
 	public ContactsPage(WebDriver driver2){
        this.driver = driver2;
    }
 	
 	public void clickExcelUploadTabOnOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,excelUploadTabOnOverlay);
 		driver.findElement(excelUploadTabOnOverlay).click();
 	}
 	
 	public void clickChooseFileButtonOnOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,chooseFileButtonOnOverlay);
 		driver.findElement(chooseFileButtonOnOverlay).click();
 	}
 	
 	public void enterListDetailsInAddContactTabOnOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,nameFieldInAddContactsTabOnOverlay);
 		driver.findElement(nameFieldInAddContactsTabOnOverlay).sendKeys(contactName);
 		driver.findElement(mobileNumberFieldInAddContactsTabOnOverlay).sendKeys(contactNumber);
 		Utility.explicitWaitForElementVisibility(driver,createWebListFiledOnOverlay);
 		driver.findElement(createWebListFiledOnOverlay).sendKeys(listName);
 		driver.findElement(addcontactButtonOnOverlay).click();
 	}
 	public String successMsgForCreatedWebList() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,successMsgForCreatedWebList);
 		return driver.findElement(successMsgForCreatedWebList).getText();
 	}
 	
 	By successMsgForCreatedWebListFromExcelUpload = By.className("toast-message");
 	
	public String successMsgForCreatedWebListFromExcelUpload() throws InterruptedException{
		Utility.explicitWaitForElementVisibility(driver,successMsgForCreatedWebListFromExcelUpload);
 		return driver.findElement(successMsgForCreatedWebListFromExcelUpload).getText();
 	}
 	
 	
 	public void clickPlusButtonToCreateNewWebList() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,plusButtonToCreateNewWebList);
 		driver.findElement(plusButtonToCreateNewWebList).click();
 	}
 	
 	//click mobile Contacts Tab On Overlay
 	public void clickMobileContactsTabOnOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,mobileContactsTabOnOverlay);
 		driver.findElement(mobileContactsTabOnOverlay).click();
 	}
 	
	public void closeLiveGroupCallOfRecentlySavedGrpTalkGroup() throws InterruptedException{
		String liveOption= driver.findElement(liveCallButton).getText();
		if(liveOption.contains("Live")){
			Utility.explicitWaitForElementVisibility(driver,liveCallButton);
			driver.findElement(liveCallButton).click();
 			hangUpCurrentGrpTalkcall();
 			System.out.println("successfully closed LiveGroupCallOfRecentlySavedGrpTalkGroup");
		}
   	}
	
	//HangUp the current group call
 	public void hangUpCurrentGrpTalkcall() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,hangUpAllButtonInGrpCall);
 		driver.findElement(hangUpAllButtonInGrpCall).click();
 		Thread.sleep(2000);
 	}
	
 	//add Contacts In MobileContacts Tab On Overlay
 	public String addContactsInMobileContactsTabOnOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,contactsInMobileContactsTabOnOverlay);
 		List<WebElement> ele=driver.findElements(contactsInMobileContactsTabOnOverlay);
// 		System.out.println(ele.size());
// 		System.out.println(ele.get(0).getText());
 		ele.get(0).click();
 		String s= ele.get(0).getText();
 		Utility.explicitWaitForElementVisibility(driver,addToListButtonInMobileContactsOnOverlay);
 		driver.findElement(addToListButtonInMobileContactsOnOverlay).click();
 		return s;
 	}
 	
 	//click on list Group In WebList On Overlay
 	public void clicklistGroupInWebListOnOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,listGroupsInWebListOnOverlay);
 		List<WebElement> ele=driver.findElements(listGroupsInWebListOnOverlay);
 		for (WebElement webList : ele ) 
		  {
 			//System.out.println(webList.getText());
 			if(webList.getText().contains("TestList")){
    			webList.click();
    			break;
    		}
		  }
 	}
 	
 	//Add member from WEb list group and save  on overlay
 	public String addcontactFromWebListGroupOnOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,listOfUsersInWebListGroupOnOverlay);
 		List<WebElement> ele=driver.findElements(listOfUsersInWebListGroupOnOverlay);
 		ele.get(0).click();
 		driver.findElement(addToListButtonOnOverlay).click();
 		String s=ele.get(0).getText();
 		return s;
 	}
 	
 	//success Msg For Contact Added To List
 	public String successMsgForContactAddedToList() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,successMsgForContactAddedToList);
 		String s= driver.findElement(successMsgForContactAddedToList).getText();
 		return s;
 	}
 	
 	//click on web list Tab On Overlay
 	public void clickWebListTabOnOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,webListTabOnOverlay);
 	 	driver.findElement(webListTabOnOverlay).click();
 	 }
 	

 	//click Add contacts on dropDown toggle
 	public void clickAddContactsOnToggleDropDown() throws InterruptedException{
 	 	Actions actions=new Actions(driver);
 	 	Thread.sleep(2000);
 	 	//Utility.explicitWaitForElementVisibility(driver,addNewContactToList);
 		WebElement element=driver.findElement(addNewContactToList);
 		actions.moveToElement(element);
 		actions.perform();
 		element.click();
 		Thread.sleep(2000);
 	}
 	
 	//click on add Contacts Tab On Overlay
 	public void clickAddContactsTabOnOverlay() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,addContactsTabOnOverlay);
 		driver.findElement(addContactsTabOnOverlay).click();
 	}
 	
 	//verify added contacts name and number in list on contacts page
 	public boolean addedContactNameInListOnContactPage(String newlyAddedContactName,String newlyAddedContactNumber1) throws InterruptedException{
 		String contactName1=newlyAddedContactName;
 		String contactNumber1= newlyAddedContactNumber1;
    	int i=0;
    	int j=0;
 		List<WebElement> contactNameList = driver.findElements(addedContactNameOnContactsPage);
 		for (WebElement addedContactName : contactNameList ) {
    		if(addedContactName.getText().contains(contactName1)){
    			i++;
    		}
    	}
 		//System.out.println("----------");
 		List<WebElement> contactNumberList = driver.findElements(addedContactNumberOnContactsPage);
 		for (WebElement addedContactNumber : contactNumberList ) {
    		if(addedContactNumber.getText().contains(contactNumber1)){
    			i++;
    		}
 		}
    	if(i>0)
    		return true;
    	else
    		return false;
 	}
 	
 	public Boolean addedContactNameInListOnContactPage(String newlyAddedContactName) throws InterruptedException{
 		String contactName=newlyAddedContactName;
    	int i=0;
 		List<WebElement> contactNameList = driver.findElements(addedContactNameOnContactsPage);
 		for (WebElement addedContactName : contactNameList ) {
    		if(addedContactName.getText().contains(contactName)){
    			i++;
    		}
    	}
 		if(i>0)
    		return true;
    	else
    		return false;
 	}
 	
 	public void deleteContactNameFromList(){
 		
 	}
 	
 	String contactName= "Srikanth@smsc";	
 	long x = 8000000000L;
 	long y = 9999999999L;
 	Random r = new Random();
 	long number = x+((long)(r.nextDouble()*(y-x)));
 	String contactNumber= String.valueOf(number);
 	
	//return newly added contact name to list
	public String returnContactName(){
		return contactName;
	}
 	
	//return newly added contact number to list
	public String returnContactNumber(){
		return contactNumber;
	}
	
 	//Enter details and add contact from addContacts tab on overlay
 	public void enterDetailsInAddContactTabOnOverlay() throws InterruptedException{
 		
 		driver.findElement(nameFieldInAddContactsTabOnOverlay).sendKeys(contactName);
 		driver.findElement(mobileNumberFieldInAddContactsTabOnOverlay).sendKeys(contactNumber);
 		Utility.explicitWaitForElementVisibility(driver,addcontactButtonOnOverlay);
 		driver.findElement(addcontactButtonOnOverlay).click();
 		Utility.explicitWaitForAlert(driver);
 		driver.switchTo().alert().accept();
 		//return contactName+contactNumber;
 	}
 	
 	//Click drop down toggle on selected list
 	public void clickDropDownToggle() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,dropDownToggleOfWebList);
 		driver.findElement(dropDownToggleOfWebList).click();
 	}
 	
 	//Delete recently created list
 	public void deleteRecentlyCreatedList() throws InterruptedException{
 		Actions actions=new Actions(driver);
 		WebElement element=driver.findElement(deleteListName);
 		actions.moveToElement(element);
 		actions.perform();
 		element.click();
 		Utility.explicitWaitForAlert(driver);
 		driver.switchTo().alert().accept();
 		Thread.sleep(2000);
 	}
 	public void deleteCreatedList() throws InterruptedException{
 		Actions actions=new Actions(driver);
 		WebElement element=driver.findElement(deleteListName);
 		actions.moveToElement(element);
 		actions.perform();
 		element.click();
 		Utility.explicitWaitForAlert(driver);
 		driver.switchTo().alert().accept();
 		System.out.println("kk");
 		Thread.sleep(2000);
 	}
 	
 	
 	//Edit wed list
 	public void clickEditWebList() throws InterruptedException{
 		Actions actions=new Actions(driver);
 		WebElement element=driver.findElement(editListName);
 		actions.moveToElement(element);
 		actions.perform();
 		element.click();
 	}
 	
 	//rename web list
 	public String reNameWebList() throws InterruptedException{
 		String reNameOfList = "List"+System.currentTimeMillis();
 		driver.findElement(reNameListName).clear();
 		driver.findElement(reNameListName).sendKeys(reNameOfList);
 		driver.findElement(reNameListName).sendKeys(Keys.ENTER);
 		return reNameOfList;
 	}

 	
 	//select recently created list
 	public boolean selectRecentlyCreatedList() throws InterruptedException{
 		String nameOfList= listName;
 		int i=0;
 	 	Actions actions=new Actions(driver);
 		List<WebElement> groupOfAllWebLists=driver.findElements(groupOfWebLists);
 		for (WebElement webList : groupOfAllWebLists ) 
		  {
 			actions.moveToElement(webList);
 			actions.perform();
 			if(webList.getText().contains(nameOfList)){
    			webList.click();
    			i++;
    			break;
    		}
		  }	
 		if(i>0){
 			return true;
 		}
 		else{
 			return false;
 		}
 			
 	}
 	
 	public void removeCreatedWebList() throws InterruptedException{
 	   	List<WebElement> listofWebLists = driver.findElements(By.xpath("//*[contains(@lname,'List1')]"));
 	   	System.out.println(driver.findElements(By.xpath("//*[contains(@lname,'List1')]")).size());
 	    for(int i=0;i<10;i++)
 	    {
 	    	WebElement ele=driver.findElement(By.xpath("//*[contains(@lname,'List1')]"));
 	    	Actions actions=new Actions(driver);
	 		actions.moveToElement(ele);
	 		actions.perform();
	 		ele.click();
	 		Thread.sleep(1000);
   			System.out.println(ele.getText());
   			driver.findElement(dropDownToggleOfWebList).click();
   			Thread.sleep(1000);
       		driver.findElement(deleteListName).click();
       		Thread.sleep(1000);
       		driver.switchTo().alert().accept();
       		Thread.sleep(2000);
 	    }
 	}
 	
    //Verify the presence of given list
    public boolean presenceOfListByGivenName(String listName) throws InterruptedException{
    	String ss=listName;
    	int i=0;
    	List<WebElement> groupOfAllWebLists=driver.findElements(groupOfWebLists);
    	for (WebElement webList : groupOfAllWebLists ) {
    		if(webList.getText().equalsIgnoreCase(ss)){
    			i++;
    		}
    	}
    	if(i>0)
    		return true;
    	else
    		return false;
    }
 	
 	String listName = "List"+System.currentTimeMillis();
 	
 	//Enter list name and save
 	public String givenListNameInEnterlistNamefield() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,listNameField);
 		driver.findElement(listNameField).sendKeys(listName);
 		driver.findElement(listNameField).sendKeys(Keys.ENTER);
 		return listName;
 	}
 	
 	//click on contacts tab
 	public void clickOnContactsTab() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,contactsTab);
 		driver.findElement(contactsTab).click();
 	}
 	
 	//Click on create New Grp List Button
 	public void clickOnCreateNewGrpListButton() throws InterruptedException{
 		Utility.explicitWaitForElementVisibility(driver,createNewGrpListButton);
 		driver.findElement(createNewGrpListButton).click();
 	}
	
}
