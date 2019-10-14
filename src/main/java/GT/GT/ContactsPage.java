package GT.GT;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utility.BrowserFunctions;
import utility.CommonMethods;

public class ContactsPage extends BrowserFunctions{

	By saveButtonForDuplicateContactsInDiffList = By.id("btnSaveExcel");
	By contactsTab 							= By.xpath("//*[@id='contacts-li']/a");
 	By createNewGrpListButton 				= By.xpath("//*[@id='callLogs']//*[@id='createGrpList']");
 	By listNameField 						= By.id("addLisItem");
 	By groupOfWebLists 						= By.xpath("//*[@id='list-group']//*[@class='contactList']/span[1]");
 	By dropDownToggleOfWebList 				= By.xpath("//*[@id='list-group']//*[@class='list highlight']//*[@class=' dropdown dropdown-toggle']");
 	By deleteListName 						= By.xpath("//*[@class='list highlight']//*[@class='deleteListName']");
 	By editListName 						= By.xpath("//*[@class='list highlight']//*[@class='editListName']");
 	By addNewContactToList 					= By.xpath("//*[@class='list highlight']//*[@class='addNewContact']");
 	By reNameListName 						= By.xpath("//*[@class='list highlight']//*[contains(@id,'editLisItemInput')]");
 	By addContactsTabOnOverlay 				= By.xpath("//*[@id='listContactsModal']/li[1]");
 	By webListTabOnOverlay 					= By.xpath("//*[@id='listContactsModal']/li[2]");
 	By mobileContactsTabOnOverlay 			= By.xpath("//*[@id='listContactsModal']/li[3]");
 	By excelUploadTabOnOverlay 				= By.xpath("//*[@id='listContactsModal']/li[4]");
 	By addToListButtonOnOverlay 			= By.id("saveListContact");
 	By addcontactButtonOnOverlay 			= By.id("addCntctList");
 	By closeListButtonOnOverlay 			= By.id("closeList");
 	By nameFieldInAddContactsTabOnOverlay 	= By.id("name");
 	By mobileNumberFieldInAddContactsTabOnOverlay = By.id("mobileNumber");
 	By imageUploadButtonInAddContactsTabOnOverlay = By.xpath("//*[@id='addListContactsModal']/div[4]/div/input[1]");
 	By webListAllContactsOnContactsPage 	= By.xpath("//*[@id='webLists']//div[@id='profileDetails']");
 	By addedContactNameOnContactsPage 		= By.xpath("//*[@id='webLists']//div[@id='profileDetails']/p[1]");
 	By addedContactNumberOnContactsPage 	= By.xpath("//*[@id='webLists']//div[@id='profileDetails']/p[2]");
 	By listGroupsInWebListOnOverlay 		= By.xpath("//*[@id='list-groupmodal']//span");
 	By listOfUsersInWebListGroupOnOverlay 	= By.xpath("//*[contains(@class, 'contacts margin-bottom-5 margin-right-5 membersList')]//*[@id='profileDetails']/p[1]");
 	By successMsgForContactAddedToList 		= By.className("toast-message");
 	By contactsInMobileContactsTabOnOverlay = By.xpath("//*[@id='mobileContacts']//*[contains(@class,'contacts margin-right-5 margin-bottom-5')]//*[@id='profileDetails']/p[1]");
 	By addToListButtonInMobileContactsOnOverlay = By.id("saveListContact");
 	By deleteContactNameFromList 			= By.xpath("//*[@id='webLists']//div[@class='contact_actions']//*[@class='delete']");
 	By liveCallButton 						=By.xpath("//*[@id='date']//label");
 	By hangUpAllButtonInGrpCall 			= By.xpath("//*[@id='hangup']/a/img");
 	By plusButtonToCreateNewWebList 		= By.xpath("//*[@class='page-content']//*[@id='plusSymbol']");
 	By createWebListFiledOnOverlay 			= By.id("newWebList");
 	By successMsgForCreatedWebList			= By.className("toast-message");
 	By chooseFileButtonOnOverlay 			= By.xpath("//*[@class='table no-border']//*[@class='btn btn-danger']");
 	By buttonForExcelSheetHasHeaderOnOverlay= By.id("header_2");
 	By createWebListNameFieldOnOverlayByExcelUpload = By.id("xlNewWebList");
 	By uploadButtonForExcelUploadContactsOnOverlay 	= By.id("saveExcelContacts");
 	By Editlistincontacts						=By.xpath("//*[@class='fa fa-ellipsis-v']");
 	By Addcontactfromlist					=By.xpath("//*[@class='list highlight']//*[@class='addNewContact']");
 	By Exceluploadinweblist					=By.xpath("//*[@class='excelContacts active']");
 	By selectcontactlist 					=By.id("ddlxlWebList");
 	By uploadexel							=By.id("saveExcelContacts");
 	
 	By ErrorMsgFordupcontact	= By.xpath("//*[@class='toast toast-error']");
 	
 	
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
 		int size = driver.findElements(saveButtonForDuplicateContactsInDiffList).size();
 		if(size>0) {
 			driver.findElement(saveButtonForDuplicateContactsInDiffList).click();
 	 		Thread.sleep(2000);
 		}
 		return listName;
 	}
 	
 	public String givenExcelSheetDetails() throws InterruptedException{
 		Thread.sleep(1000);
 		driver.findElement(buttonForExcelSheetHasHeaderOnOverlay).click();
 		Select name=new Select(driver.findElement(By.id("ddlname_Sheet1")));
 		name.selectByVisibleText("Column A");
 		Select number=new Select(driver.findElement(By.id("ddlmobile_Sheet1")));
 		number.selectByVisibleText("Column B");
 		//driver.findElement(createWebListNameFieldOnOverlayByExcelUpload).sendKeys(listName);
 		//driver.findElement(selectcontactlist).click();
 		//driver.findElement(uploadButtonForExcelUploadContactsOnOverlay).click();
 		//Thread.sleep(2000);
 		//int size = driver.findElements(saveButtonForDuplicateContactsInDiffList).size();
 		///if(size>0) {
 			driver.findElement(uploadexel).click();
 	 		Thread.sleep(2000);
 		//}
 		return listName;
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
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
	
 	public void clickExcelUploadTabOnOverlay() throws InterruptedException{
 		Thread.sleep(2000);
 		//CommonMethods.explicitWaitForElementVisibility(excelUploadTabOnOverlay);
 		driver.findElement(excelUploadTabOnOverlay).click();
 	}
 	
 	public void clickChooseFileButtonOnOverlay() throws InterruptedException{
 		//CommonMethods.explicitWaitForElementVisibility(chooseFileButtonOnOverlay);
 		Thread.sleep(2000);
 		driver.findElement(chooseFileButtonOnOverlay).click();
 	}
 	
 	public String enterListDetailsInAddContactTabOnOverlay() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(nameFieldInAddContactsTabOnOverlay);
 		driver.findElement(nameFieldInAddContactsTabOnOverlay).sendKeys(contactName);
 		driver.findElement(mobileNumberFieldInAddContactsTabOnOverlay).sendKeys(contactNumber);
 		CommonMethods.explicitWaitForElementVisibility(createWebListFiledOnOverlay);
 		driver.findElement(createWebListFiledOnOverlay).sendKeys(listName);
 		driver.findElement(addcontactButtonOnOverlay).click();
 		return listName;
 	}
 	public String successMsgForCreatedWebList() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(successMsgForCreatedWebList);
 		return driver.findElement(successMsgForCreatedWebList).getText();
 	}
 	
 	By successMsgForCreatedWebListFromExcelUpload = By.className("toast-message");
 	
	public String successMsgForCreatedWebListFromExcelUpload() throws InterruptedException{
		CommonMethods.explicitWaitForElementVisibility(successMsgForCreatedWebListFromExcelUpload);
 		return driver.findElement(successMsgForCreatedWebListFromExcelUpload).getText();
 	}
 	
 	
 	public void clickPlusButtonToCreateNewWebList() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(plusButtonToCreateNewWebList);
 		Thread.sleep(1000);
 		driver.findElement(plusButtonToCreateNewWebList).click();
 	}
 	
 	public void clickEditlistincontacts() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(Editlistincontacts);
 		Thread.sleep(1000);
 		driver.findElement(Editlistincontacts).click();
 	}
 	
 	public void clickAddcontactfromlist() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(Addcontactfromlist);
 		Thread.sleep(1000);
 		driver.findElement(Addcontactfromlist).click();
 	}
 	
 	 	
 	public void clickExceluploadinweblist() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(Exceluploadinweblist);
 		Thread.sleep(1000);
 		driver.findElement(Exceluploadinweblist).click();
 	}
 	
 	//click mobile Contacts Tab On Overlay
 	public void clickMobileContactsTabOnOverlay() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(mobileContactsTabOnOverlay);
 		driver.findElement(mobileContactsTabOnOverlay).click();
 	}
 	
	public void closeLiveGroupCallOfRecentlySavedGrpTalkGroup() throws InterruptedException{
		String liveOption= driver.findElement(liveCallButton).getText();
		if(liveOption.contains("Live")){
			CommonMethods.explicitWaitForElementVisibility(liveCallButton);
			driver.findElement(liveCallButton).click();
 			hangUpCurrentGrpTalkcall();
 			System.out.println("successfully closed LiveGroupCallOfRecentlySavedGrpTalkGroup");
		}
   	}
	
 	public void hangUpCurrentGrpTalkcall() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(hangUpAllButtonInGrpCall);
 		driver.findElement(hangUpAllButtonInGrpCall).click();
 		Thread.sleep(2000);
 	}
	
 	public String addContactsInMobileContactsTabOnOverlay() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(contactsInMobileContactsTabOnOverlay);
 		List<WebElement> ele=driver.findElements(contactsInMobileContactsTabOnOverlay);
 		ele.get(0).click();
 		String s= ele.get(0).getText();
 		CommonMethods.explicitWaitForElementVisibility(addToListButtonInMobileContactsOnOverlay);
 		driver.findElement(addToListButtonInMobileContactsOnOverlay).click();
 		return s;
 	}
 	
 	public void clicklistGroupInWebListOnOverlay() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(listGroupsInWebListOnOverlay);
 		List<WebElement> ele=driver.findElements(listGroupsInWebListOnOverlay);
 		for (WebElement webList : ele ) 
		  {
 			if(webList.getText().contains("TestList")){
    			webList.click();
    			break;
    		}
		  }
 	}
 	
 	public String addcontactFromWebListGroupOnOverlay() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(listOfUsersInWebListGroupOnOverlay);
 		List<WebElement> ele=driver.findElements(listOfUsersInWebListGroupOnOverlay);
 		ele.get(1).click();
 		driver.findElement(addToListButtonOnOverlay).click();
 		String s=ele.get(1).getText();
 		return s;
 	}
 	
 	public String successMsgForContactAddedToList() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(successMsgForContactAddedToList);
 		String s= driver.findElement(successMsgForContactAddedToList).getText();
 		return s;
 	}
 	
 	public void clickWebListTabOnOverlay() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(webListTabOnOverlay);
 	 	driver.findElement(webListTabOnOverlay).click();
 	 }
 	

 	public void clickAddContactsOnToggleDropDown() throws InterruptedException{
 	 	Actions actions=new Actions(driver);
 	 	Thread.sleep(2000);
 		WebElement element=driver.findElement(addNewContactToList);
 		actions.moveToElement(element);
 		actions.perform();
 		element.click();
 		Thread.sleep(2000);
 	}
 	
 	public void clickAddContactsTabOnOverlay() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(addContactsTabOnOverlay);
 		driver.findElement(addContactsTabOnOverlay).click();
 	}
 	
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
 	
 	String contactName= "Srikanth";	
 	long x = 8000000000L;
 	long y = 9999999999L;
 	Random r = new Random();
 	long number = x+((long)(r.nextDouble()*(y-x)));
 	String contactNumber= String.valueOf(number);
 	
	public String returnContactName(){
		return contactName;
	}
 	
	public String returnContactNumber(){
		return contactNumber;
	}
	
 	public void enterDetailsInAddContactTabOnOverlay() throws InterruptedException{
 		driver.findElement(nameFieldInAddContactsTabOnOverlay).sendKeys(contactName);
 		driver.findElement(mobileNumberFieldInAddContactsTabOnOverlay).sendKeys(contactNumber);
 		CommonMethods.explicitWaitForElementVisibility(addcontactButtonOnOverlay);
 		driver.findElement(addcontactButtonOnOverlay).click();
 		CommonMethods.explicitWaitForAlert(driver);
 		driver.switchTo().alert().accept();
 	}
 	
 	public void enterDetailsInAddContactTabOnOverlay1() throws InterruptedException{
 		driver.findElement(nameFieldInAddContactsTabOnOverlay).sendKeys(contactName);
 		driver.findElement(mobileNumberFieldInAddContactsTabOnOverlay).sendKeys(contactNumber);
 		CommonMethods.explicitWaitForElementVisibility(addcontactButtonOnOverlay);
 		driver.findElement(addcontactButtonOnOverlay).click();
 		//CommonMethods.explicitWaitForAlert(driver);
 		//driver.switchTo().alert().accept();
 	}
 	
 	public void clickDropDownToggle() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(dropDownToggleOfWebList);
 		driver.findElement(dropDownToggleOfWebList).click();
 	}
 	
 	public void deleteRecentlyCreatedList() throws InterruptedException{
 		Actions actions=new Actions(driver);
 		WebElement element=driver.findElement(deleteListName);
 		actions.moveToElement(element);
 		actions.perform();
 		element.click();
 		CommonMethods.explicitWaitForAlert(driver);
 		driver.switchTo().alert().accept();
 		Thread.sleep(2000);
 	}
 	
 	public void deleteCreatedList() throws InterruptedException{
 		Actions actions=new Actions(driver);
 		WebElement element=driver.findElement(deleteListName);
 		actions.moveToElement(element);
 		actions.perform();
 		element.click();
 		CommonMethods.explicitWaitForAlert(driver);
 		driver.switchTo().alert().accept();
 		System.out.println("kk");
 		Thread.sleep(2000);
 	}
 	
 	public void clickEditWebList() throws InterruptedException{
 		Actions actions=new Actions(driver);
 		WebElement element=driver.findElement(editListName);
 		actions.moveToElement(element);
 		actions.perform();
 		element.click();
 	}
 	
 	public String reNameWebList() throws InterruptedException{
 		String reNameOfList = "List"+System.currentTimeMillis();
 		driver.findElement(reNameListName).clear();
 		driver.findElement(reNameListName).sendKeys(reNameOfList);
 		driver.findElement(reNameListName).sendKeys(Keys.ENTER);
 		return reNameOfList;
 	}

 	public boolean selectRecentlyCreatedList(String name) throws InterruptedException{
 		String nameOfList= name;
 		int i=0;
 	 	Actions actions=new Actions(driver);
 	 	driver.navigate().refresh();
 		List<WebElement> groupOfAllWebLists=driver.findElements(groupOfWebLists);
 		for (WebElement webList : groupOfAllWebLists ) 
		  {
 			actions.moveToElement(webList);
 			actions.perform();
 			if(webList.getText().contains(nameOfList)){
 				Thread.sleep(1000);
 				System.out.println(webList.getText());
    			webList.click();
    			i++;
    			break;
    		}
		  }
 		Thread.sleep(3000);
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
 	
 	public String givenListNameInEnterlistNamefield() throws InterruptedException{
 		CommonMethods.explicitWaitForElementVisibility(listNameField);
 		driver.findElement(listNameField).sendKeys(listName);
 		driver.findElement(listNameField).sendKeys(Keys.ENTER);
 		return listName;
 	}
 	
 	public void clickOnContactsTab() throws InterruptedException{
 		 JavascriptExecutor js = (JavascriptExecutor) driver;
 		 js.executeScript("window.scrollBy(0,1000)");
 		CommonMethods.explicitWaitForElementVisibility(contactsTab);
 		driver.findElement(contactsTab).click();
 	}
 	
 	public void clickOnCreateNewGrpListButton() throws InterruptedException{
 		Thread.sleep(1000);
 		CommonMethods.explicitWaitForElementVisibility(createNewGrpListButton);
 		driver.findElement(createNewGrpListButton).click();
 	}
	
 	public String Errormsgfordupcontact() throws InterruptedException{
		Thread.sleep(2000);
 		return driver.findElement(ErrorMsgFordupcontact).getText();
  	}
}
