package GT.GT;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.*;

public class ContactsPageTest extends BrowserFunctions {
	
	@BeforeClass
	public void beforeCalss(){
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("GrpTalk_Report_Of_ContactsPage.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger_ss = extent.createTest("ContactsPageTest");
		logger_ss.log(Status.INFO, "ContactsPageTest");
	}

	@Test
	public void verifyCreateListFromContactsPage() throws InterruptedException{
		logger_ss = extent.createTest("verifyCreateListFromContactsPage","verify Create List From Contacts Page");
		ContactsPage contactsPage = new ContactsPage();
		contactsPage.clickOnContactsTab();
		logger_ss.log(Status.INFO, "Clicked on contacts tab in myGrpTalks page");
		contactsPage.clickOnCreateNewGrpListButton();
		logger_ss.log(Status.INFO, "Clicked On Create New Grp List Button in contacts page");
		String list = contactsPage.givenListNameInEnterlistNamefield();
		logger_ss.log(Status.INFO, "given List Name In EnterlistName field");
		boolean result=contactsPage.selectRecentlyCreatedList(list);
		logger_ss.log(Status.INFO, "Successfully selected Recently Created List");
		Assert.assertTrue(result);
		logger_ss.log(Status.INFO, "Successfully verified the Recently Created List in list of webList");
	}
	
	@Test
	public void verifyCreateListFromContactsPageUsingPlusSymbol() throws InterruptedException{
		logger_ss = extent.createTest("verifyCreateListFromContactsPageUsingPlusSymbol","verify Create List From Contacts Page UsingPlusSymbol");
		ContactsPage contactsPage = new ContactsPage();
		contactsPage.clickOnContactsTab();
		logger_ss.log(Status.INFO, "Clicked on contacts tab in myGrpTalks page");
		contactsPage.clickPlusButtonToCreateNewWebList();
		logger_ss.log(Status.INFO, "Clicked on PlusButtonToCreateNewWebList");
		contactsPage.clickAddContactsTabOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on AddContactsTabOnOverlay");
		String list =contactsPage.enterListDetailsInAddContactTabOnOverlay();
		logger_ss.log(Status.INFO, "entered ListDetailsInAddContactTabOnOverlay");
		Assert.assertEquals(contactsPage.successMsgForCreatedWebList(), "WebList Added");
		logger_ss.log(Status.INFO, "verified successMsgForCreatedWebList");
		boolean result=contactsPage.selectRecentlyCreatedList(list);
		logger_ss.log(Status.INFO, "selected Recently Created List");
		Assert.assertTrue(result);
		logger_ss.log(Status.INFO, "Successfully verified the Recently Created List in list of webList");
	}
	
	@Test
	public void verifyCreateListFromExcelUpload() throws InterruptedException, AWTException{
		logger_ss = extent.createTest("verifyCreateListFromExcelUpload","verifyCreateListFromExcelUpload");
		ContactsPage contactsPage = new ContactsPage();
		contactsPage.clickOnContactsTab();
		logger_ss.log(Status.INFO, "Clicked on contacts tab in myGrpTalks page");
		contactsPage.clickPlusButtonToCreateNewWebList();
		logger_ss.log(Status.INFO, "Clicked on PlusButtonToCreateNewWebList");
		contactsPage.clickExcelUploadTabOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on ExcelUploadTabOnOverlay");
		contactsPage.clickChooseFileButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on ChooseFileButtonOnOverlay");
		String path="D:\\grpTalk\\TestDataFiles\\contacts.xlsx";
		CommonMethods.getUploadFile("D:\\grpTalk\\TestDataFiles\\contacts.xlsx");
		logger_ss.log(Status.INFO, "Uploaded file");
		Thread.sleep(2000);
		String listName = contactsPage.givenExcelSheetDetailsOnOverlay();
		System.out.println("lsit--"+listName);
		logger_ss.log(Status.INFO, "given excel sheet details on overlay");
		Thread.sleep(3000);
		//Assert.assertEquals(contactsPage.successMsgForCreatedWebListFromExcelUpload(), "New List Created Successfully");
		//Assert.assertEquals(contactsPage.successMsgForCreatedWebListFromExcelUpload(), "Contact(s) Inserted Successfully");
		logger_ss.log(Status.INFO, "verified successMsgForCreatedWebListFromExcelUpload");
		boolean result=contactsPage.selectRecentlyCreatedList(listName);
		logger_ss.log(Status.INFO, "Successfully selected Recently Created List");
		Assert.assertTrue(result);
		Assert.assertEquals(contactsPage.listOfContactsInWebList(), 2);
		logger_ss.log(Status.INFO, "Successfully verified the listOfContactsInWebList");
		logger_ss.log(Status.INFO, "Successfully verified the functionality of CreateListFromExcelUpload");
	}

	@Test
	public void verifyDeleteListFromContactsPage() throws InterruptedException{
		logger_ss = extent.createTest("verifyDeleteListFromContactsPage","verify Delete List From Contacts Page");
		ContactsPage contactsPage = new ContactsPage();
		contactsPage.clickOnContactsTab();
		logger_ss.log(Status.INFO, "Clicked on contacts tab in myGrpTalks page");
		contactsPage.clickOnCreateNewGrpListButton();
		logger_ss.log(Status.INFO, "Clicked On Create New Grp List Button in contacts page");
		String listName= contactsPage.givenListNameInEnterlistNamefield();
		logger_ss.log(Status.INFO, "given List Name In EnterlistName field");
		contactsPage.selectRecentlyCreatedList(listName);
		logger_ss.log(Status.INFO, "Selected Recently Created List");
		contactsPage.clickDropDownToggle();
		logger_ss.log(Status.INFO, "clicked on DropDown Toggle of selected created list");
		contactsPage.deleteRecentlyCreatedList();
		logger_ss.log(Status.INFO, "Deleted Recently Created List");
		Assert.assertFalse(contactsPage.presenceOfListByGivenName(listName));
		logger_ss.log(Status.INFO, "Successfully verified the presence of Deleted Recently Created List");
	}
	
	@Test
	public void verifyReNameListFromContactsPage() throws InterruptedException{
		logger_ss = extent.createTest("verifyReNameListFromContactsPage","verify ReName List From Contacts Page");
		ContactsPage contactsPage = new ContactsPage();
		contactsPage.clickOnContactsTab();
		logger_ss.log(Status.INFO, "Clicked on contacts tab in myGrpTalks page");
		contactsPage.clickOnCreateNewGrpListButton();
		logger_ss.log(Status.INFO, "Clicked On Create New Grp List Button in contacts page");
		String list=contactsPage.givenListNameInEnterlistNamefield();
		logger_ss.log(Status.INFO, "given List Name In EnterlistName field");
		contactsPage.selectRecentlyCreatedList(list);
		logger_ss.log(Status.INFO, "Selected Recently Created List");
		contactsPage.clickDropDownToggle();
		logger_ss.log(Status.INFO, "clicked on DropDown Toggle of selected created list");
		contactsPage.clickEditWebList();
		logger_ss.log(Status.INFO, "clicked on Edit WebList option");
		String reNameList= contactsPage.reNameWebList();
		logger_ss.log(Status.INFO, "given new name to web list");
		Assert.assertTrue(contactsPage.presenceOfListByGivenName(reNameList));
		logger_ss.log(Status.INFO, "Successfully verified the presence Of List By Given Name");
		logger_ss.log(Status.INFO, "Successfully verified ReNameListFromContactsPage functionality");
	}
	
	@Test
	public void verifyAddContactsFromAddContactsTabOnOverlay() throws InterruptedException{
		logger_ss = extent.createTest("verifyAddContactsFromAddContactsTabOnOverlay","verify Add Contacts From Add Contacts Tab On Overlay");
		ContactsPage contactsPage = new ContactsPage();
		contactsPage.clickOnContactsTab();
		logger_ss.log(Status.INFO, "Clicked on contacts tab in myGrpTalks page");
		contactsPage.clickOnCreateNewGrpListButton();
		logger_ss.log(Status.INFO, "Clicked On Create New Grp List Button in contacts page");
		String list = contactsPage.givenListNameInEnterlistNamefield();
		logger_ss.log(Status.INFO, "given List Name In EnterlistName field");
		contactsPage.selectRecentlyCreatedList(list);
		logger_ss.log(Status.INFO, "Selected Recently Created List");
		contactsPage.clickDropDownToggle();
		logger_ss.log(Status.INFO, "clicked on DropDown Toggle of selected created list");
		contactsPage.clickAddContactsOnToggleDropDown();
		logger_ss.log(Status.INFO, "clicked on addContacts On Toggle DropDown");
		contactsPage.clickAddContactsTabOnOverlay();
		logger_ss.log(Status.INFO, "clicked on addContacts tab on overlay ");
		contactsPage.enterDetailsInAddContactTabOnOverlay();
		logger_ss.log(Status.INFO, "entered Details In Add Contact Tab On Overlay");
		String contactName=contactsPage.returnContactName();
		String contactNumber=contactsPage.returnContactNumber();
		Assert.assertTrue(contactsPage.addedContactNameInListOnContactPage(contactName,contactNumber));
		logger_ss.log(Status.INFO, "verified the added Contact Name In List On Contact Page");
		logger_ss.log(Status.INFO, "Successfully verified functionality of AddContactsFromAddContactsTabOnOverlay");
	}
	
	@Test
	public void verifyAddContactsFromWebListsTabOnOverlay() throws InterruptedException{
		logger_ss = extent.createTest("verifyAddContactsFromWebListsTabOnOverlay","verify Add Contacts From WebLists Tab On Overlay");
		ContactsPage contactsPage = new ContactsPage();
		contactsPage.clickOnContactsTab();
		logger_ss.log(Status.INFO, "Clicked on contacts tab in myGrpTalks page");
		contactsPage.clickOnCreateNewGrpListButton();
		logger_ss.log(Status.INFO, "Clicked On Create New Grp List Button in contacts page");
		String list = contactsPage.givenListNameInEnterlistNamefield();
		logger_ss.log(Status.INFO, "given List Name In EnterlistName field");
		contactsPage.selectRecentlyCreatedList(list);
		logger_ss.log(Status.INFO, "Selected Recently Created List");
		contactsPage.clickDropDownToggle();
		logger_ss.log(Status.INFO, "clicked on DropDown Toggle of selected created list");
		contactsPage.clickAddContactsOnToggleDropDown();
		logger_ss.log(Status.INFO, "clicked on addContacts On Toggle DropDown");
		contactsPage.clickWebListTabOnOverlay();
		logger_ss.log(Status.INFO, "clicked on webList tab on overlay ");
		contactsPage.clicklistGroupInWebListOnOverlay();
		logger_ss.log(Status.INFO, "clicked on 'SMS1111' list Group In WebList On Overlay ");
		String contactName= contactsPage.addcontactFromWebListGroupOnOverlay();
		logger_ss.log(Status.INFO, "added contact From WebList Group On Overlay ");
		String ss=contactsPage.successMsgForContactAddedToList();
		logger_ss.log(Status.INFO, "Expected success msg is :  Contact added to list successfully");
		logger_ss.log(Status.INFO, "Actual success msg is : ");
		logger_ss.log(Status.INFO, ss);
		Assert.assertEquals(ss, "Contact added to list successfully");
		logger_ss.log(Status.INFO, "Successfully verified the success msg for Adding Contacts From WebLists");
		Assert.assertTrue(contactsPage.addedContactNameInListOnContactPage(contactName));
		logger_ss.log(Status.INFO, "Successfully verified the added Contacts From WebLists");
	}
	
	@Test
	public void verifyAddContactsFromMobileContactsTabOnOverlay() throws InterruptedException{
		logger_ss = extent.createTest("verifyAddContactsFromMobileContactsTabOnOverlay","verify Add Contacts From Mobile Contacts Tab On Overlay");
		ContactsPage contactsPage = new ContactsPage();
		contactsPage.clickOnContactsTab();
		logger_ss.log(Status.INFO, "Clicked on contacts tab in myGrpTalks page");
		contactsPage.clickOnCreateNewGrpListButton();
		logger_ss.log(Status.INFO, "Clicked On Create New Grp List Button in contacts page");
		String list =contactsPage.givenListNameInEnterlistNamefield();
		System.out.println("listname----"+list);
		logger_ss.log(Status.INFO, "given List Name In EnterlistName field");
		contactsPage.selectRecentlyCreatedList(list);
		logger_ss.log(Status.INFO, "Selected Recently Created List");
		contactsPage.clickDropDownToggle();
		logger_ss.log(Status.INFO, "clicked on DropDown Toggle of selected created list");
		contactsPage.clickAddContactsOnToggleDropDown();
		logger_ss.log(Status.INFO, "clicked on addContacts On Toggle DropDown");
		contactsPage.clickMobileContactsTabOnOverlay();
		logger_ss.log(Status.INFO, "clicked on mobileContacts tab On overlay");
		String contactName=contactsPage.addContactsInMobileContactsTabOnOverlay();
		logger_ss.log(Status.INFO, "added Contacts from MobileContacts Tab On Overlay");
		String ss=contactsPage.successMsgForContactAddedToList();
		logger_ss.log(Status.INFO, "Expected success msg is :  Contact added to list successfully");
		logger_ss.log(Status.INFO, "Actual success msg is : ");
		logger_ss.log(Status.INFO, ss);
		Assert.assertEquals(ss, "Contact added to list successfully");
		Assert.assertTrue(contactsPage.addedContactNameInListOnContactPage(contactName));
		logger_ss.log(Status.INFO, "Successfully verified the added Contacts From MobileContacts Tab");
	}
	
	@Ignore
	@Test
	public void verifyDeleteAddedContactsFromAddContactsTabOnOverlay() throws InterruptedException{
		ContactsPage contactsPage = new ContactsPage();
		contactsPage.clickOnContactsTab();
		logger_ss.log(Status.INFO, "Clicked on contacts tab in myGrpTalks page");
		contactsPage.clickOnCreateNewGrpListButton();
		logger_ss.log(Status.INFO, "Clicked On Create New Grp List Button in contacts page");
		String list=contactsPage.givenListNameInEnterlistNamefield();
		logger_ss.log(Status.INFO, "given List Name In EnterlistName field");
		contactsPage.selectRecentlyCreatedList(list);
		logger_ss.log(Status.INFO, "Selected Recently Created List");
		contactsPage.clickDropDownToggle();
		logger_ss.log(Status.INFO, "clicked on DropDown Toggle of selected created list");
		contactsPage.clickAddContactsOnToggleDropDown();
		logger_ss.log(Status.INFO, "clicked on addContacts On Toggle DropDown");
		contactsPage.clickAddContactsTabOnOverlay();
		logger_ss.log(Status.INFO, "clicked on addContactsTab OnOverlay");
		contactsPage.enterDetailsInAddContactTabOnOverlay();
		logger_ss.log(Status.INFO, "entered DetailsInAddContactTabOnOverlay");
		String contactName=contactsPage.returnContactName();
		String contactNumber=contactsPage.returnContactNumber();
		Assert.assertTrue(contactsPage.addedContactNameInListOnContactPage(contactName,contactNumber));
		logger_ss.log(Status.INFO, "Successfully verified addedContactNameInListOnContactPage");
		logger_ss.log(Status.INFO, "Successfully verified the functionality of DeleteAddedContactsFromAddContactsTabOnOverlay");
	}
	
//	@AfterMethod
//	public void tearDown(ITestResult result) throws IOException, InterruptedException {
//		//driver.navigate().refresh();
//		if (result.getStatus() == ITestResult.FAILURE) {
//			String temp = Utility.getScreenshot();
//
//			logger_ss.fail(result.getThrowable().getMessage(),
//					MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
//		}
//		extent.flush();
//		driver.navigate().to(contactsPageUrl);
//		Thread.sleep(2000);
//		ContactsPage contactsPage = new ContactsPage();
//		try{
//			if(driver.findElements(By.xpath("//*[contains(@lname,'List1')]")).size()!=0){
//				contactsPage.removeCreatedWebList();
//				System.out.println("successfully deleted saved list");
//			}
//		}
//		catch(Exception e){
//			//System.out.println(e);
//		}
//		driver.navigate().to(homePageUrl);
//		Thread.sleep(2000);
//	}

}
