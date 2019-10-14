package GT.GT;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.BrowserFunctions;
import utility.CommonMethods;

public class MemberAndCallManagerTest extends BrowserFunctions{

	public static Logger logger = Logger.getLogger(CreateAndCallGroupTest.class);
	CommonMethods CommonMethods=new CommonMethods();
	//public String homeUrl="http://192.168.75.33:8081/index.aspx?automationKey=84081";
	
	@BeforeClass
	public void beforeCalss(){
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("GrpTalk_Report_Of_MemberAndCallManagerTest.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger_ss = extent.createTest("MemberAndCallManagerTest");
		logger_ss.log(Status.INFO, "MemberAndCallManagerTest");
	}
	
	@Test
	public void verifyMemberRemoveFromGrp() throws InterruptedException, AWTException{
		//driver.get(homeUrl);
		logger_ss = extent.createTest("verifyMemberRemoveFromGrp","verifyMemberRemoveFromGrp");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.selectSavedGroupByName(CommonMethods.passingData("LeaveGroupGroup"));
		grpTalks.leaveFromGroup();
		Assert.assertTrue(grpTalks.serachForGroupWhereMemberRemoved(CommonMethods.passingData("LeaveGroupGroup")));
	}
	
	@Test
	public void verifyCallFunctionalityFromSecondaryModerator() throws InterruptedException{
		//driver.get(homeUrl);
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.selectSecModeratorGroup("Sec15");
		grpTalks.quickDialButtonOfActiveGroup();
		logger_ss.log(Status.INFO, "clicked on quickDialButtonOfActiveGroup");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalks.cancelGroupCallButtonOnOverlay));
		logger_ss.log(Status.INFO, "verified cancleButtonDisplayedOnCallOverlay");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalks.muteDialGroupCallButtonOnOverlay));
		logger_ss.log(Status.INFO, "verified muteDialButtonDisplayedOnCallOverlay");
		Assert.assertTrue(CommonMethods.isDisplayedMethod(grpTalks.dialGroupCallButtonOnOverlay));
		logger_ss.log(Status.INFO, "verified dialGroupButtonDisplayedOnCallOverlay");
		grpTalks.dialGroupCallButtonOnOverlay();
		logger_ss.log(Status.INFO, "Dialed to Sec15 group");
		grpTalks.verifyLiveCallState();
		logger_ss.log(Status.INFO, "Verified the visiblity of inProgress element");
	
//		int selectAllParticipantsTabAndCountTheParticipants=grpTalks.selectAllParticipantsTabAndCountTheParticipants();
//		Assert.assertEquals(selectAllParticipantsTabAndCountTheParticipants,4);
//		Assert.assertEquals(grpTalks.totalParticipants(),selectAllParticipantsTabAndCountTheParticipants);
//		logger_ss.log(Status.INFO, "Successfully verified selectAllParticipantsTabAndCountTheParticipants ");
//	
//		int onCallCountInGrpCall=grpTalks.selectOnCallTabAndCountTheParticipants();
//		Assert.assertEquals(onCallCountInGrpCall,4);
//		Assert.assertEquals(grpTalks.totalParticipants(),onCallCountInGrpCall);
//		logger_ss.log(Status.INFO, "Successfully verified onCallCountInGrpCall ");
//	
//		int unMutedCountInGrpCall=grpTalks.selectUnMutedTabAndCountTheParticipants();
//		Assert.assertEquals(unMutedCountInGrpCall,3);
//		Assert.assertEquals(grpTalks.totalParticipants(),unMutedCountInGrpCall);
//		logger_ss.log(Status.INFO, "Successfully verified unMutedCountInGrpCall ");
//	
//		int selectDisconnectedTabAndCountTheParticipants=grpTalks.selectDisconnectedTabAndCountTheParticipants();
//		Assert.assertEquals(selectDisconnectedTabAndCountTheParticipants,0);
//		Assert.assertEquals(grpTalks.totalParticipants(),selectDisconnectedTabAndCountTheParticipants);
//		logger_ss.log(Status.INFO, "Successfully verified callEndedCount ");
	
		grpTalks.hangUpCurrentGrpTalkcall();
		logger_ss.log(Status.INFO, "hangUp the Current GrpTalk call");
		grpTalks.submitRateCallByClickingGoodOption();
		logger_ss.log(Status.INFO, "Successfully verified CallFunctionalityFromQuickDialButtonInMyGrpTalk");
	}

	
}