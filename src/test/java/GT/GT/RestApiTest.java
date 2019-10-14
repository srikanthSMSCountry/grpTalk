package GT.GT;
//import static com.jayway.restassured.RestAssured.get;

import org.testng.annotations.Ignore;

//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import com.jayway.restassured.response.Response;
//
//public class RestApiTest {
//
//	@Test
//	public void getRequestFindCapital() throws JSONException {
//		
//		//make get request to fetch capital of norway
//		Response resp = get("http://restcountries.eu/rest/v1/name/norway");
//		
//		//Fetching response in JSON
//		JSONArray jsonResponse = new JSONArray(resp.asString());
//		
//		//Fetching value of capital parameter
//		String capital = jsonResponse.getJSONObject(0).getString("capital");
//		
//		//Asserting that capital of Norway is Oslo
//		Assert.assertEquals(capital, "Oslo");
//	}
//	
//}

import org.testng.annotations.Test;
//import org.testng.AssertJUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.BrowserFunctions;
import utility.CommonMethods;
import java.util.Random;

public class RestApiTest extends BrowserFunctions {
	
	By hostNumber = By.xpath("//*[@id='foradmincheck']//*[@for='r1s']//*[@class='persn-phnm-det']");
	By allMembers = By.xpath("//*[@id='foradmincheck']//*[@class='persn-phnm-det']");
	By allMembersInLiveCall  = By.xpath("//*[contains(@class,'col-xs-4 col-sm-3 oncall-admin')]");
	
	public String getRandomElement(List<String> list) {
		Random rand = new Random();
		int randomIndex = rand.nextInt(list.size());
		String randomNumber =list.get(randomIndex);
		list.remove(randomIndex);
		return randomNumber;
	}

	public List<String> getRandomElements(List<String> copyList) {
		Random rand = new Random();
		int numberOfElements = 5;
		List<String> onCall = new ArrayList<String>();
		for (int i = 0; i < numberOfElements; i++) {
			int randomIndex = rand.nextInt(copyList.size());
			onCall.add(copyList.get(randomIndex));
			copyList.remove(randomIndex);
		}
		return onCall;
	}
	
	@Test
	public void verifyCallFunctionality() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionality","verifyCallFunctionality");
		driver.get("http://staging.grptalk.com/index.aspx?automationkey=narasimha");
		GrpTalks grpTalks = new GrpTalks();
		logger_ss.log(Status.INFO, "Select Saved group");
		grpTalks.selectSavedGroupByName("Srenivas_Demo_8");
		
		String hostContactNumber = driver.findElement(hostNumber).getText().replaceAll("[^a-zA-Z0-9]", "");
		logger_ss.log(Status.INFO, "Get all participants from group");
		List<WebElement> list = driver.findElements(allMembers);
		logger_ss.log(Status.INFO, "Add all participants to contactsList");
		List<String> contactsList = new ArrayList<String>();
		Actions action=new Actions(driver);
		for (WebElement ele : list) {
			action.moveToElement(ele).perform();
			contactsList.add(ele.getText().replaceAll("[^a-zA-Z0-9]", ""));
		}
		
		System.out.println("contact list::"+contactsList);
		logger_ss.log(Status.INFO, "Trigger mute call");
		grpTalks.dialGroupCallButton();
		grpTalks.muteDialGroupCallOnOverlay111();

		RestApiTest item = new RestApiTest();
		
		List<String> contactsListCopy = new ArrayList<String>(contactsList);
		
		System.out.println("contactsListCopy::"+contactsListCopy);
		
		logger_ss.log(Status.INFO, "Get participants for OnCall");
		List<String> onCallMembers = item.getRandomElements(contactsListCopy);
		
		System.out.println("oncall members::"+onCallMembers);
		
		List<String> onCallMembersExceptHost = new ArrayList<String>(onCallMembers);
		for (int i = 0; i < onCallMembersExceptHost.size(); i++) {
			if(onCallMembersExceptHost.get(i).contains(hostContactNumber)){
				onCallMembersExceptHost.remove(i);
				break;
			}
		}
		System.out.println("oncall members except host::"+onCallMembersExceptHost);
		logger_ss.log(Status.INFO, "Get participants for disconnect");
		List<String> disconnectedMembers = new ArrayList<String>(contactsListCopy);
		
		System.out.println("disconnectedMembers::"+disconnectedMembers);
		
		logger_ss.log(Status.INFO, "Make a post request for onCall and disconnect participants");
		RestAssured.baseURI = "http://192.168.72.27:8888/v0.1/Mock/";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		
		int onCallMembersCount = onCallMembers.size();
		String onCallString = "";
		for (int i = 0; i < onCallMembersCount; i++) {
			onCallString = onCallString.concat(onCallMembers.get(i));
			if(i<onCallMembersCount-1){
				onCallString = onCallString.concat(",");
			}
		}
		requestParams.put("onCall", onCallString);
		
		System.out.println("onCallString"+onCallString);
		
		String disConnnectedString = "";
		int disconnectedCount = disconnectedMembers.size();
		for (int i = 0; i < disconnectedCount; i++) {
			disConnnectedString = disConnnectedString.concat(disconnectedMembers.get(i));
			if(i<disconnectedCount-1){
				disConnnectedString = disConnnectedString.concat(",");
			}
		}
		requestParams.put("disconnect", disConnnectedString);
		
		System.out.println("disConnnectedString"+ disConnnectedString);

		request.body(requestParams.toString());
		Response response = request.post();
		
		logger_ss.log(Status.INFO, "Verify status code for onCall and disconnect participants request");
		int statusCode = response.getStatusCode();
		System.out.println("oncall status code::"+statusCode);
		Thread.sleep(40000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		logger_ss.log(Status.INFO, "Verify OnCall is displayed for onCall participants");
		List<WebElement> liveCallMembers = driver.findElements(allMembersInLiveCall);
		System.out.println("live call members size==="+liveCallMembers.size());
		Actions actionObject = new Actions(driver);
		for (WebElement ele1 : liveCallMembers) {
			if (onCallMembers.contains(ele1.getAttribute("id"))) {
				System.out.println(ele1.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele1).perform();
				String text = ele1.findElement(By.xpath(".//*[contains(@class,'oncall-bg')]//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "ON CALL");
				System.out.println("----");
			}
		}
		
		logger_ss.log(Status.INFO, "Get participants for handRaise");
		requestParams = new JSONObject();
		int handRaiseCount = 2;
		List<String> handRaisedMembers = new ArrayList<String>();
		List<String> handRaiseWithOutHost = new ArrayList<String>(onCallMembersExceptHost);
		String handRaiseString ="";
		for (int i = 0; i < handRaiseCount; i++) {
			String randomElement = item.getRandomElement(handRaiseWithOutHost);
			handRaiseString = handRaiseString.concat(randomElement);
			if(i<handRaiseCount-1){
				handRaiseString = handRaiseString.concat(",");
			}
			handRaisedMembers.add(randomElement);
		}
		logger_ss.log(Status.INFO, "Make a post request for handRaise participants");
		requestParams.put("handrise", handRaiseString);
		System.out.println(" handRaiseString :: "+handRaiseString);
		request.body(requestParams.toString());
		Response handRaiseResponse = request.post();
		int handRaiseStatusCode = handRaiseResponse.getStatusCode();
		System.out.println("handRaiseStatusCode::"+handRaiseStatusCode);
		Thread.sleep(20000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		logger_ss.log(Status.INFO, "Verify handRaise is displayed for selected participants");
		List<WebElement> liveCallMembers1 = driver.findElements(allMembersInLiveCall);
		for (WebElement ele : liveCallMembers1) {
			if (handRaisedMembers.contains(ele.getAttribute("id"))) {
				System.out.println(ele.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele).perform();
				Assert.assertTrue(ele.findElement(grpTalks.handRaiseEnableOption).isDisplayed());
				System.out.println("----");
			}
		}
		logger_ss.log(Status.INFO, "Get participants for hangUp");
		requestParams = new JSONObject();
		
		int hangUpParticipantCount = 2;
		List<String> hangedUpMembers = new ArrayList<String>();
		String hangUpString = "";
		for (int i = 0; i < hangUpParticipantCount; i++) {
			String randomElement = item.getRandomElement(onCallMembers);
			hangUpString = hangUpString.concat(randomElement);
			if(i<hangUpParticipantCount-1){
				hangUpString = hangUpString.concat(",");
			}
			hangedUpMembers.add(randomElement);
		}
		logger_ss.log(Status.INFO, "Make a post request for hangUp participants");
		requestParams.put("leaveConference", hangUpString);
		
		System.out.println(" hangUpString String:: "+hangUpString);
		
		request.body(requestParams.toString());
		Response hangUpResponse = request.post();
		System.out.println(requestParams.toString());

		int hangUpStatusCode = hangUpResponse.getStatusCode();
		System.out.println("hangUp status code==="+hangUpStatusCode);
		Thread.sleep(15000);
		driver.navigate().refresh();
		Thread.sleep(15000);
		logger_ss.log(Status.INFO, "Verify hangUp is displayed for selected participants");
		List<WebElement> liveCallMembers3 = driver.findElements(allMembersInLiveCall);
		for (WebElement ele : liveCallMembers3) {
			if (hangedUpMembers.contains(ele.getAttribute("id"))) {
				System.out.println(ele.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele).perform();
				Assert.assertTrue(ele.findElement(grpTalks.individualReDailButton).isDisplayed());
				String text = ele.findElement(By.xpath(".//*[contains(@class,'oncall-bg')]//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "Call Ended");
				System.out.println("----");
			}
		}
		logger_ss.log(Status.INFO, "Get participants for incoming call");
		requestParams = new JSONObject();
		int inComingParticipantCount = 2;
		List<String> incomingMembers = new ArrayList<String>();
		String incomingCallString = "";
		for (int i = 0; i < inComingParticipantCount; i++) {
			String randomElement = item.getRandomElement(hangedUpMembers);
			incomingCallString = incomingCallString.concat(randomElement);
			if(i<inComingParticipantCount-1){
				incomingCallString = incomingCallString.concat(",");
			}
			incomingMembers.add(randomElement);
		}
		System.out.println(" incomingCallString String:: "+incomingCallString);
		
		logger_ss.log(Status.INFO, "Make a post request for incoming Call participants");
		requestParams.put("incomingCalls", incomingCallString);
		
		request.body(requestParams.toString());
		Response incomingcallResponse = request.post();

		int incomingcallStatusCode = incomingcallResponse.getStatusCode();
		System.out.println("incomingcallStatusCode==="+incomingcallStatusCode);
		Thread.sleep(20000);
		driver.navigate().refresh();
		Thread.sleep(15000);
		logger_ss.log(Status.INFO, "Verify OnCall is displayed for incoming participants");
		List<WebElement> liveCallMembers4 = driver.findElements(allMembersInLiveCall);
		for (WebElement ele : liveCallMembers4) {
			if (incomingMembers.contains(ele.getAttribute("id"))) {
				System.out.println(ele.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele).perform();
				String text = ele.findElement(By.xpath(".//*[contains(@class,'oncall-bg')]//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "ON CALL");
				System.out.println("----");
			}
		}
		grpTalks.hangUpCurrentGrpTalkcall();
	}
	
	@Test
	public void verifyFunctionalityOfOnCallAndDisconnectedParticipants() throws InterruptedException {
		logger_ss = extent.createTest("verifyFunctionalityOfOnCallAndDisconnectedParticipants","verifyFunctionalityOfOnCallAndDisconnectedParticipants");
		driver.get("http://staging.grptalk.com/index.aspx?automationkey=narasimha");
		GrpTalks grpTalks = new GrpTalks();
		logger_ss.log(Status.INFO, "Select Saved group");
		grpTalks.selectSavedGroupByName("Demo_Sreenivas_50");
		
		String hostContactNumber = driver.findElement(hostNumber).getText().replaceAll("[^a-zA-Z0-9]", "");
		logger_ss.log(Status.INFO, "Get all participants from group");
		List<WebElement> list = driver.findElements(allMembers);
		logger_ss.log(Status.INFO, "Add all participants to contactsList");
		List<String> contactsList = new ArrayList<String>();
		Actions action=new Actions(driver);
		for (WebElement ele : list) {
			action.moveToElement(ele).perform();
			contactsList.add(ele.getText().replaceAll("[^a-zA-Z0-9]", ""));
		}
		
		System.out.println("contact list::"+contactsList);
		logger_ss.log(Status.INFO, "Trigger mute call");
		grpTalks.dialGroupCallButton();
		grpTalks.muteDialGroupCallOnOverlay111();

		RestApiTest item = new RestApiTest();
		
		List<String> contactsListCopy = new ArrayList<String>(contactsList);
		
		System.out.println("contactsListCopy::"+contactsListCopy);
		
		logger_ss.log(Status.INFO, "Get participants for OnCall");
		List<String> onCallMembers = item.getRandomElements(contactsListCopy);
		
		System.out.println("oncall members::"+onCallMembers);
		
		List<String> onCallMembersExceptHost = new ArrayList<String>(onCallMembers);
		for (int i = 0; i < onCallMembersExceptHost.size(); i++) {
			if(onCallMembersExceptHost.get(i).contains(hostContactNumber)){
				onCallMembersExceptHost.remove(i);
				break;
			}
		}
		System.out.println("oncall members except host::"+onCallMembersExceptHost);
		logger_ss.log(Status.INFO, "Get participants for disconnect");
		List<String> disconnectedMembers = new ArrayList<String>(contactsListCopy);
		
		System.out.println("disconnectedMembers::"+disconnectedMembers);
		
		logger_ss.log(Status.INFO, "Make a post request for onCall and disconnect participants");
		RestAssured.baseURI = "http://192.168.72.27:8888/v0.1/Mock/";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		
		int onCallMembersCount = onCallMembers.size();
		String onCallString = "";
		for (int i = 0; i < onCallMembersCount; i++) {
			onCallString = onCallString.concat(onCallMembers.get(i));
			if(i<onCallMembersCount-1){
				onCallString = onCallString.concat(",");
			}
		}
		requestParams.put("onCall", onCallString);
		
		System.out.println("onCallString"+onCallString);
		
		String disConnnectedString = "";
		int disconnectedCount = disconnectedMembers.size();
		for (int i = 0; i < disconnectedCount; i++) {
			disConnnectedString = disConnnectedString.concat(disconnectedMembers.get(i));
			if(i<disconnectedCount-1){
				disConnnectedString = disConnnectedString.concat(",");
			}
		}
		requestParams.put("disconnect", disConnnectedString);
		
		System.out.println("disConnnectedString"+ disConnnectedString);

		request.body(requestParams.toString());
		Response response = request.post();
		
		logger_ss.log(Status.INFO, "Verify status code for onCall and disconnect participants request");
		int statusCode = response.getStatusCode();
		System.out.println("oncall status code::"+statusCode);
		Thread.sleep(25000);
		
		logger_ss.log(Status.INFO, "Verify OnCall is displayed for onCall participants");
		List<WebElement> liveCallMembers = driver.findElements(allMembersInLiveCall);
		System.out.println("live call members size==="+liveCallMembers.size());
		Actions actionObject = new Actions(driver);
		for (WebElement ele1 : liveCallMembers) {
			if (onCallMembers.contains(ele1.getAttribute("id"))) {
				System.out.println(ele1.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele1).perform();
				String text = ele1.findElement(By.xpath(".//*[contains(@class,'oncall-bg')]//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "ON CALL");
				System.out.println("----");
			}
		}
		grpTalks.hangUpCurrentGrpTalkcall();
	}
	
	
	@Test
	public void verifyFunctionalityOfAcceptAndDisconnectRedialParticipants() throws InterruptedException {
		logger_ss = extent.createTest("verifyFunctionalityOfAcceptAndDisconnectRedialParticipants","verifyFunctionalityOfAcceptAndDisconnectRedialParticipants");
		driver.get("http://staging.grptalk.com/index.aspx?automationkey=narasimha");
		GrpTalks grpTalks = new GrpTalks();
		logger_ss.log(Status.INFO, "Select Saved group");
		grpTalks.selectSavedGroupByName("Demo_Sreenivas_50");
		
		String hostContactNumber = driver.findElement(hostNumber).getText().replaceAll("[^a-zA-Z0-9]", "");
		logger_ss.log(Status.INFO, "Get all participants from group");
		List<WebElement> list = driver.findElements(allMembers);
		logger_ss.log(Status.INFO, "Add all participants to contactsList");
		List<String> contactsList = new ArrayList<String>();
		Actions action=new Actions(driver);
		for (WebElement ele : list) {
			action.moveToElement(ele).perform();
			contactsList.add(ele.getText().replaceAll("[^a-zA-Z0-9]", ""));
		}
		
		System.out.println("contact list::"+contactsList);
		logger_ss.log(Status.INFO, "Trigger mute call");
		grpTalks.dialGroupCallButton();
		grpTalks.muteDialGroupCallOnOverlay111();

		RestApiTest item = new RestApiTest();
		
		List<String> contactsListCopy = new ArrayList<String>(contactsList);
		
		System.out.println("contactsListCopy::"+contactsListCopy);
		
		logger_ss.log(Status.INFO, "Get participants for OnCall");
		List<String> onCallMembers = item.getRandomElements(contactsListCopy);
		
		System.out.println("oncall members::"+onCallMembers);
		
		List<String> onCallMembersExceptHost = new ArrayList<String>(onCallMembers);
		for (int i = 0; i < onCallMembersExceptHost.size(); i++) {
			if(onCallMembersExceptHost.get(i).contains(hostContactNumber)){
				onCallMembersExceptHost.remove(i);
				break;
			}
		}
		System.out.println("oncall members except host::"+onCallMembersExceptHost);
		logger_ss.log(Status.INFO, "Get participants for disconnect");
		List<String> disconnectedMembers = new ArrayList<String>(contactsListCopy);
		
		System.out.println("disconnectedMembers::"+disconnectedMembers);
		
		logger_ss.log(Status.INFO, "Make a post request for onCall and disconnect participants");
		RestAssured.baseURI = "http://192.168.72.27:8888/v0.1/Mock/";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		
		int onCallMembersCount = onCallMembers.size();
		String onCallString = "";
		for (int i = 0; i < onCallMembersCount; i++) {
			onCallString = onCallString.concat(onCallMembers.get(i));
			if(i<onCallMembersCount-1){
				onCallString = onCallString.concat(",");
			}
		}
		requestParams.put("onCall", onCallString);
		
		System.out.println("onCallString"+onCallString);
		
		String disConnnectedString = "";
		int disconnectedCount = disconnectedMembers.size();
		for (int i = 0; i < disconnectedCount; i++) {
			disConnnectedString = disConnnectedString.concat(disconnectedMembers.get(i));
			if(i<disconnectedCount-1){
				disConnnectedString = disConnnectedString.concat(",");
			}
		}
		requestParams.put("disconnect", disConnnectedString);
		
		System.out.println("disConnnectedString"+ disConnnectedString);

		request.body(requestParams.toString());
		Response response = request.post();
		
		logger_ss.log(Status.INFO, "Verify status code for onCall and disconnect participants request");
		int statusCode = response.getStatusCode();
		System.out.println("oncall status code::"+statusCode);
		Thread.sleep(25000);
		
		logger_ss.log(Status.INFO, "Verify OnCall is displayed for onCall participants");
		List<WebElement> liveCallMembers = driver.findElements(allMembersInLiveCall);
		System.out.println("live call members size==="+liveCallMembers.size());
		Actions actionObject = new Actions(driver);
		for (WebElement ele1 : liveCallMembers) {
			if (onCallMembers.contains(ele1.getAttribute("id"))) {
				System.out.println(ele1.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele1).perform();
				String text = ele1.findElement(By.xpath(".//*[contains(@class,'oncall-bg')]//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "ON CALL");
				System.out.println("----");
			}
		}
		
		logger_ss.log(Status.INFO, "Get participants for oncall from redial");
		requestParams = new JSONObject();
		int onCallFromRedial = 2;
		String onCallFromRedialString ="";
		List<String> onCallFromRedialMembers = new ArrayList<String>();
		for (int i = 0; i < onCallFromRedial; i++) {
			String randomElement = item.getRandomElement(disconnectedMembers);
			onCallFromRedialString = onCallFromRedialString.concat(randomElement);
			if(i<onCallFromRedial-1){
				onCallFromRedialString = onCallFromRedialString.concat(",");
			}
			onCallFromRedialMembers.add(randomElement);
		}
		requestParams.put("onCall", onCallFromRedialString);
		
		System.out.println("onCallString"+onCallFromRedialString);
		
		logger_ss.log(Status.INFO, "Get participants for Disconnect from redial");
		String disconnectFromRedialString ="";
		int disconnectedCountFromRedial = disconnectedMembers.size();
		for (int i = 0; i < disconnectedCountFromRedial; i++) {
			disconnectFromRedialString = disconnectFromRedialString.concat(disconnectedMembers.get(i));
			if(i<disconnectedCountFromRedial-1){
				disconnectFromRedialString = disconnectFromRedialString.concat(",");
			}
		}
		requestParams.put("disconnect", disconnectFromRedialString);
		
		System.out.println("disConnnectedString"+ disconnectFromRedialString);
		logger_ss.log(Status.INFO, "Make a post request for handRaise participants");
		request.body(requestParams.toString());
		Response OnCallAndHangUpresponseFromReDail = request.post();
		
		logger_ss.log(Status.INFO, "Verify status code for onCall and disconnect participants request from Redial");
		int OnCallAndHangUpFromReDailstatusCode = OnCallAndHangUpresponseFromReDail.getStatusCode();
		System.out.println("OnCallAndHangUpFromReDailstatusCode::"+OnCallAndHangUpFromReDailstatusCode);
		Thread.sleep(25000);
		
		logger_ss.log(Status.INFO, "Verify OnCall is displayed for onCall participants");
		List<WebElement> liveCallMembers1 = driver.findElements(allMembersInLiveCall);
		System.out.println("live call members size==="+liveCallMembers1.size());
		Actions actionObject1 = new Actions(driver);
		for (WebElement ele1 : liveCallMembers1) {
			if (onCallFromRedialMembers.contains(ele1.getAttribute("id"))) {
				System.out.println(ele1.getAttribute("id"));
				Thread.sleep(1000);
				actionObject1.moveToElement(ele1).perform();
				String text = ele1.findElement(By.xpath(".//*[contains(@class,'oncall-bg')]//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "ON CALL");
				System.out.println("----");
			}
		}
		grpTalks.hangUpCurrentGrpTalkcall();
	}
	
	@Test
	public void verifyFunctionalityOfDialInParticipants() throws InterruptedException {
		logger_ss = extent.createTest("verifyFunctionalityOfDailInParticipants","verifyFunctionalityOfDailInParticipants");
		driver.get("http://staging.grptalk.com/index.aspx?automationkey=narasimha");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		logger_ss.log(Status.INFO, "Clicked on createGroup button in myGrpTalk page");
		crtgrp.clickPhoneContactsTab();
		logger_ss.log(Status.INFO, "Clicked on phone Contacts tab in createGrpTalk page");
		crtgrp.selectContactsFromContactList();
		logger_ss.log(Status.INFO, "Selected phone contact from contact list");
		crtgrp.selectedContactsTab();

		List<WebElement> list = driver.findElements(By.xpath("//*[@id='selectedContacts']//p[2]"));
		List<String> contactsList = new ArrayList<String>();
		for (WebElement ele : list) {
			System.out.println(ele.getText().replaceAll("[^a-zA-Z0-9]", ""));
			contactsList.add(ele.getText().replaceAll("[^a-zA-Z0-9]", ""));
		}
		
		String grpName=crtgrp.setGrpTalkName();
		logger_ss.log(Status.INFO, "Given new grpTalk name in text field");
		crtgrp.submitScheduleButton();
		logger_ss.log(Status.INFO, "Submitted schedule button");
		crtgrp.onOffSwitchLabelForDialInOnlyOptionOnAdvancedSettingsOverlayForSchedule();
		crtgrp.scheduleDateAndTimeFieldOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "Click on schedule Date And Time Field On Advanced Settings Overlay For Schedule");
		crtgrp.decrementDatePickerForMinutes(8);
		logger_ss.log(Status.INFO, "incremented Minute in date picker overlay");
		crtgrp.datePickerSetButtonOnOverlay();
		logger_ss.log(Status.INFO, "Clicked on set button on overlay");
		crtgrp.selectAllRepeatDaysOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "selected AllRepeatDaysOnAdvancedSettingsOverlayForSchedule");
		crtgrp.clickScheduleButtonOnAdvancedSettingsOverlayForSchedule();
		logger_ss.log(Status.INFO, "clicked on Schedule Button On Advanced Settings Overlay For Schedule grpTalk");
		Thread.sleep(124000);
		driver.navigate().to(CommonMethods.passingData("homePageUrl"));
		grpTalks.selectRecentlySavedGrpTalkGroup(grpName);
		logger_ss.log(Status.INFO, "selected Recently Saved GrpTalk Group");
		
		logger_ss.log(Status.INFO, "Make a post request for onCall and disconnect participants");
		RestAssured.baseURI = "http://192.168.72.27:8888/v0.1/Mock/";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		RestApiTest item = new RestApiTest();
		logger_ss.log(Status.INFO, "Get participants for incoming call");
		requestParams = new JSONObject();
		int inComingParticipantCount = 2;
		List<String> incomingMembers = new ArrayList<String>();
		String incomingCallString = "";
		for (int i = 0; i < inComingParticipantCount; i++) {
			String randomElement = item.getRandomElement(contactsList);
			incomingCallString = incomingCallString.concat(randomElement);
			if(i<inComingParticipantCount-1){
				incomingCallString = incomingCallString.concat(",");
			}
			incomingMembers.add(randomElement);
		}
		System.out.println(" incomingCallString String:: "+incomingCallString);
		
		logger_ss.log(Status.INFO, "Make a post request for incoming Call participants");
		requestParams.put("incomingCalls", incomingCallString);
		
		request.body(requestParams.toString());
		Response incomingcallResponse = request.post();

		int incomingcallStatusCode = incomingcallResponse.getStatusCode();
		System.out.println("incomingcallStatusCode::"+incomingcallStatusCode);
		Thread.sleep(20000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		logger_ss.log(Status.INFO, "Verify OnCall is displayed for incoming participants");
		List<WebElement> liveCallMembers4 = driver.findElements(allMembersInLiveCall);
		Actions actionObject= new Actions(driver);
		for (WebElement ele : liveCallMembers4) {
			if (incomingMembers.contains(ele.getAttribute("id"))) {
				System.out.println(ele.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele).perform();
				String text = ele.findElement(By.xpath(".//*[contains(@class,'oncall-bg')]//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "ON CALL");
				System.out.println("----");
			}
		}
		grpTalks.hangUpCurrentGrpTalkcall();
		
	}
	
	
	@Test
	public void verifyFunctionalityOfHandRaiseParticipants() throws InterruptedException {
		logger_ss = extent.createTest("verifyCallFunctionality","verifyCallFunctionality");
		driver.get("http://staging.grptalk.com/index.aspx?automationkey=narasimha");
		GrpTalks grpTalks = new GrpTalks();
		logger_ss.log(Status.INFO, "Select Saved group");
		grpTalks.selectSavedGroupByName("Demo_Sreenivas_50");
		
		String hostContactNumber = driver.findElement(hostNumber).getText().replaceAll("[^a-zA-Z0-9]", "");
		logger_ss.log(Status.INFO, "Get all participants from group");
		List<WebElement> list = driver.findElements(allMembers);
		logger_ss.log(Status.INFO, "Add all participants to contactsList");
		List<String> contactsList = new ArrayList<String>();
		Actions action=new Actions(driver);
		for (WebElement ele : list) {
			action.moveToElement(ele).perform();
			contactsList.add(ele.getText().replaceAll("[^a-zA-Z0-9]", ""));
		}
		
		System.out.println("contact list::"+contactsList);
		logger_ss.log(Status.INFO, "Trigger mute call");
		grpTalks.dialGroupCallButton();
		grpTalks.muteDialGroupCallOnOverlay111();

		RestApiTest item = new RestApiTest();
		
		List<String> contactsListCopy = new ArrayList<String>(contactsList);
		
		System.out.println("contactsListCopy::"+contactsListCopy);
		
		logger_ss.log(Status.INFO, "Get participants for OnCall");
		List<String> onCallMembers = item.getRandomElements(contactsListCopy);
		
		System.out.println("oncall members::"+onCallMembers);
		
		List<String> onCallMembersExceptHost = new ArrayList<String>(onCallMembers);
		for (int i = 0; i < onCallMembersExceptHost.size(); i++) {
			if(onCallMembersExceptHost.get(i).contains(hostContactNumber)){
				onCallMembersExceptHost.remove(i);
				break;
			}
		}
		System.out.println("oncall members except host::"+onCallMembersExceptHost);
		logger_ss.log(Status.INFO, "Get participants for disconnect");
		List<String> disconnectedMembers = new ArrayList<String>(contactsListCopy);
		
		System.out.println("disconnectedMembers::"+disconnectedMembers);
		
		logger_ss.log(Status.INFO, "Make a post request for onCall and disconnect participants");
		RestAssured.baseURI = "http://192.168.72.27:8888/v0.1/Mock/";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		
		int onCallMembersCount = onCallMembers.size();
		String onCallString = "";
		for (int i = 0; i < onCallMembersCount; i++) {
			onCallString = onCallString.concat(onCallMembers.get(i));
			if(i<onCallMembersCount-1){
				onCallString = onCallString.concat(",");
			}
		}
		requestParams.put("onCall", onCallString);
		
		System.out.println("onCallString"+onCallString);
		
		String disConnnectedString = "";
		int disconnectedCount = disconnectedMembers.size();
		for (int i = 0; i < disconnectedCount; i++) {
			disConnnectedString = disConnnectedString.concat(disconnectedMembers.get(i));
			if(i<disconnectedCount-1){
				disConnnectedString = disConnnectedString.concat(",");
			}
		}
		requestParams.put("disconnect", disConnnectedString);
		
		System.out.println("disConnnectedString"+ disConnnectedString);

		request.body(requestParams.toString());
		Response response = request.post();
		
		logger_ss.log(Status.INFO, "Verify status code for onCall and disconnect participants request");
		int statusCode = response.getStatusCode();
		System.out.println("oncall status code::"+statusCode);
		Thread.sleep(25000);
		
		logger_ss.log(Status.INFO, "Verify OnCall is displayed for onCall participants");
		List<WebElement> liveCallMembers = driver.findElements(allMembersInLiveCall);
		System.out.println("live call members size==="+liveCallMembers.size());
		Actions actionObject = new Actions(driver);
		for (WebElement ele1 : liveCallMembers) {
			if (onCallMembers.contains(ele1.getAttribute("id"))) {
				System.out.println(ele1.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele1).perform();
				String text = ele1.findElement(By.xpath(".//*[contains(@class,'oncall-bg')]//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "ON CALL");
				System.out.println("----");
			}
		}
		
		logger_ss.log(Status.INFO, "Get participants for handRaise");
		requestParams = new JSONObject();
		int handRaiseCount = 2;
		List<String> handRaisedMembers = new ArrayList<String>();
		List<String> handRaiseWithOutHost = new ArrayList<String>(onCallMembersExceptHost);
		String handRaiseString ="";
		for (int i = 0; i < handRaiseCount; i++) {
			String randomElement = item.getRandomElement(handRaiseWithOutHost);
			handRaiseString = handRaiseString.concat(randomElement);
			if(i<handRaiseCount-1){
				handRaiseString = handRaiseString.concat(",");
			}
			handRaisedMembers.add(randomElement);
		}
		logger_ss.log(Status.INFO, "Make a post request for handRaise participants");
		requestParams.put("handrise", handRaiseString);
		System.out.println(" handRaiseString :: "+handRaiseString);
		request.body(requestParams.toString());
		Response handRaiseResponse = request.post();
		int handRaiseStatusCode = handRaiseResponse.getStatusCode();
		System.out.println("handRaiseStatusCode::"+handRaiseStatusCode);
		Thread.sleep(15000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		logger_ss.log(Status.INFO, "Verify handRaise is displayed for selected participants");
		List<WebElement> liveCallMembers1 = driver.findElements(allMembersInLiveCall);
		for (WebElement ele : liveCallMembers1) {
			if (handRaisedMembers.contains(ele.getAttribute("id"))) {
				System.out.println(ele.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele).perform();
				Assert.assertTrue(ele.findElement(grpTalks.handRaiseEnableOption).isDisplayed());
				System.out.println("----");
			}
		}
		grpTalks.hangUpCurrentGrpTalkcall();
	}
	
	@Test
	public void verifyFunctionalityOfAutoDisconnectedParticipants() throws InterruptedException {
		logger_ss = extent.createTest("verifyFunctionalityOfAutoDisconnectedParticipants","verifyFunctionalityOfAutoDisconnectedParticipants");
		driver.get("http://staging.grptalk.com/index.aspx?automationkey=narasimha");
		GrpTalks grpTalks = new GrpTalks();
		logger_ss.log(Status.INFO, "Select Saved group");
		grpTalks.selectSavedGroupByName("Demo_Sreenivas_50");
		
		String hostContactNumber = driver.findElement(hostNumber).getText().replaceAll("[^a-zA-Z0-9]", "");
		logger_ss.log(Status.INFO, "Get all participants from group");
		List<WebElement> list = driver.findElements(allMembers);
		logger_ss.log(Status.INFO, "Add all participants to contactsList");
		List<String> contactsList = new ArrayList<String>();
		Actions action=new Actions(driver);
		for (WebElement ele : list) {
			action.moveToElement(ele).perform();
			contactsList.add(ele.getText().replaceAll("[^a-zA-Z0-9]", ""));
		}
		
		System.out.println("contact list::"+contactsList);
		logger_ss.log(Status.INFO, "Trigger mute call");
		grpTalks.dialGroupCallButton();
		grpTalks.muteDialGroupCallOnOverlay111();

		RestApiTest item = new RestApiTest();
		
		List<String> contactsListCopy = new ArrayList<String>(contactsList);
		
		System.out.println("contactsListCopy::"+contactsListCopy);
		
		logger_ss.log(Status.INFO, "Get participants for OnCall");
		List<String> onCallMembers = item.getRandomElements(contactsListCopy);
		
		System.out.println("oncall members::"+onCallMembers);
		
		List<String> onCallMembersExceptHost = new ArrayList<String>(onCallMembers);
		for (int i = 0; i < onCallMembersExceptHost.size(); i++) {
			if(onCallMembersExceptHost.get(i).contains(hostContactNumber)){
				onCallMembersExceptHost.remove(i);
				break;
			}
		}
		System.out.println("oncall members except host::"+onCallMembersExceptHost);
		logger_ss.log(Status.INFO, "Get participants for disconnect");
		List<String> disconnectedMembers = new ArrayList<String>(contactsListCopy);
		
		System.out.println("disconnectedMembers::"+disconnectedMembers);
		
		logger_ss.log(Status.INFO, "Make a post request for onCall and disconnect participants");
		RestAssured.baseURI = "http://192.168.72.27:8888/v0.1/Mock/";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		
		int onCallMembersCount = onCallMembers.size();
		String onCallString = "";
		for (int i = 0; i < onCallMembersCount; i++) {
			onCallString = onCallString.concat(onCallMembers.get(i));
			if(i<onCallMembersCount-1){
				onCallString = onCallString.concat(",");
			}
		}
		requestParams.put("onCall", onCallString);
		
		System.out.println("onCallString"+onCallString);
		
		String disConnnectedString = "";
		int disconnectedCount = disconnectedMembers.size();
		for (int i = 0; i < disconnectedCount; i++) {
			disConnnectedString = disConnnectedString.concat(disconnectedMembers.get(i));
			if(i<disconnectedCount-1){
				disConnnectedString = disConnnectedString.concat(",");
			}
		}
		requestParams.put("disconnect", disConnnectedString);
		
		System.out.println("disConnnectedString"+ disConnnectedString);

		request.body(requestParams.toString());
		Response response = request.post();
		
		logger_ss.log(Status.INFO, "Verify status code for onCall and disconnect participants request");
		int statusCode = response.getStatusCode();
		System.out.println("oncall status code::"+statusCode);
		Thread.sleep(25000);
		
		logger_ss.log(Status.INFO, "Verify OnCall is displayed for onCall participants");
		List<WebElement> liveCallMembers = driver.findElements(allMembersInLiveCall);
		System.out.println("live call members size==="+liveCallMembers.size());
		Actions actionObject = new Actions(driver);
		for (WebElement ele1 : liveCallMembers) {
			if (onCallMembers.contains(ele1.getAttribute("id"))) {
				System.out.println(ele1.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele1).perform();
				String text = ele1.findElement(By.xpath(".//*[contains(@class,'oncall-bg')]//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "ON CALL");
				System.out.println("----");
			}
		}
		
		logger_ss.log(Status.INFO, "Get participants for hangUp");
		requestParams = new JSONObject();
		int hangUpParticipantCount = 2;
		List<String> hangedUpMembers = new ArrayList<String>();
		String hangUpString = "";
		for (int i = 0; i < hangUpParticipantCount; i++) {
			String randomElement = item.getRandomElement(onCallMembers);
			hangUpString = hangUpString.concat(randomElement);
			if(i<hangUpParticipantCount-1){
				hangUpString = hangUpString.concat(",");
			}
			hangedUpMembers.add(randomElement);
		}
		logger_ss.log(Status.INFO, "Make a post request for hangUp participants");
		requestParams.put("leaveConference", hangUpString);
		
		System.out.println(" hangUpString String:: "+hangUpString);
		
		request.body(requestParams.toString());
		Response hangUpResponse = request.post();
		System.out.println(requestParams.toString());

		int hangUpStatusCode = hangUpResponse.getStatusCode();
		System.out.println("hangUp status code==="+hangUpStatusCode);
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		logger_ss.log(Status.INFO, "Verify hangUp is displayed for selected participants");
		List<WebElement> liveCallMembers3 = driver.findElements(allMembersInLiveCall);
		for (WebElement ele : liveCallMembers3) {
			if (hangedUpMembers.contains(ele.getAttribute("id"))) {
				System.out.println(ele.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele).perform();
				Assert.assertTrue(ele.findElement(grpTalks.individualReDailButton).isDisplayed());
				String text = ele.findElement(By.xpath(".//*[contains(@class,'oncall-bg')]//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "Call Ended");
				System.out.println("----");
			}
		}
		grpTalks.hangUpCurrentGrpTalkcall();
	}
	
	@Test
	public void verifyFunctionalityOfIncomingCallFromParticipants() throws InterruptedException {
		logger_ss = extent.createTest("verifyFunctionalityOfIncomingCallFromParticipants","verifyFunctionalityOfIncomingCallFromParticipants");
		driver.get("http://staging.grptalk.com/index.aspx?automationkey=narasimha");
		GrpTalks grpTalks = new GrpTalks();
		logger_ss.log(Status.INFO, "Select Saved group");
		grpTalks.selectSavedGroupByName("Demo_Sreenivas_50");
		
		String hostContactNumber = driver.findElement(hostNumber).getText().replaceAll("[^a-zA-Z0-9]", "");
		logger_ss.log(Status.INFO, "Get all participants from group");
		List<WebElement> list = driver.findElements(allMembers);
		logger_ss.log(Status.INFO, "Add all participants to contactsList");
		List<String> contactsList = new ArrayList<String>();
		Actions action=new Actions(driver);
		for (WebElement ele : list) {
			action.moveToElement(ele).perform();
			contactsList.add(ele.getText().replaceAll("[^a-zA-Z0-9]", ""));
		}
		
		System.out.println("contact list::"+contactsList);
		logger_ss.log(Status.INFO, "Trigger mute call");
		grpTalks.dialGroupCallButton();
		grpTalks.muteDialGroupCallOnOverlay111();

		RestApiTest item = new RestApiTest();
		
		List<String> contactsListCopy = new ArrayList<String>(contactsList);
		
		System.out.println("contactsListCopy::"+contactsListCopy);
		
		logger_ss.log(Status.INFO, "Get participants for OnCall");
		List<String> onCallMembers = item.getRandomElements(contactsListCopy);
		
		System.out.println("oncall members::"+onCallMembers);
		
		List<String> onCallMembersExceptHost = new ArrayList<String>(onCallMembers);
		for (int i = 0; i < onCallMembersExceptHost.size(); i++) {
			if(onCallMembersExceptHost.get(i).contains(hostContactNumber)){
				onCallMembersExceptHost.remove(i);
				break;
			}
		}
		System.out.println("oncall members except host::"+onCallMembersExceptHost);
		logger_ss.log(Status.INFO, "Get participants for disconnect");
		List<String> disconnectedMembers = new ArrayList<String>(contactsListCopy);
		
		System.out.println("disconnectedMembers::"+disconnectedMembers);
		
		logger_ss.log(Status.INFO, "Make a post request for onCall and disconnect participants");
		RestAssured.baseURI = "http://192.168.72.27:8888/v0.1/Mock/";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		
		int onCallMembersCount = onCallMembers.size();
		String onCallString = "";
		for (int i = 0; i < onCallMembersCount; i++) {
			onCallString = onCallString.concat(onCallMembers.get(i));
			if(i<onCallMembersCount-1){
				onCallString = onCallString.concat(",");
			}
		}
		requestParams.put("onCall", onCallString);
		
		System.out.println("onCallString"+onCallString);
		
		String disConnnectedString = "";
		int disconnectedCount = disconnectedMembers.size();
		for (int i = 0; i < disconnectedCount; i++) {
			disConnnectedString = disConnnectedString.concat(disconnectedMembers.get(i));
			if(i<disconnectedCount-1){
				disConnnectedString = disConnnectedString.concat(",");
			}
		}
		requestParams.put("disconnect", disConnnectedString);
		
		System.out.println("disConnnectedString"+ disConnnectedString);

		request.body(requestParams.toString());
		Response response = request.post();
		
		logger_ss.log(Status.INFO, "Verify status code for onCall and disconnect participants request");
		int statusCode = response.getStatusCode();
		System.out.println("oncall status code::"+statusCode);
		Thread.sleep(25000);
		
		logger_ss.log(Status.INFO, "Verify OnCall is displayed for onCall participants");
		List<WebElement> liveCallMembers = driver.findElements(allMembersInLiveCall);
		System.out.println("live call members size==="+liveCallMembers.size());
		Actions actionObject = new Actions(driver);
		for (WebElement ele1 : liveCallMembers) {
			if (onCallMembers.contains(ele1.getAttribute("id"))) {
				System.out.println(ele1.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele1).perform();
				String text = ele1.findElement(By.xpath(".//*[contains(@class,'oncall-bg')]//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "ON CALL");
				System.out.println("----");
			}
		}
		
		logger_ss.log(Status.INFO, "Get participants for hangUp");
		requestParams = new JSONObject();
		int hangUpParticipantCount = 2;
		List<String> hangedUpMembers = new ArrayList<String>();
		String hangUpString = "";
		for (int i = 0; i < hangUpParticipantCount; i++) {
			String randomElement = item.getRandomElement(onCallMembers);
			hangUpString = hangUpString.concat(randomElement);
			if(i<hangUpParticipantCount-1){
				hangUpString = hangUpString.concat(",");
			}
			hangedUpMembers.add(randomElement);
		}
		logger_ss.log(Status.INFO, "Make a post request for hangUp participants");
		requestParams.put("leaveConference", hangUpString);
		
		System.out.println(" hangUpString String:: "+hangUpString);
		
		request.body(requestParams.toString());
		Response hangUpResponse = request.post();
		System.out.println(requestParams.toString());

		int hangUpStatusCode = hangUpResponse.getStatusCode();
		System.out.println("hangUp status code==="+hangUpStatusCode);
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		logger_ss.log(Status.INFO, "Verify hangUp is displayed for selected participants");
		List<WebElement> liveCallMembers3 = driver.findElements(allMembersInLiveCall);
		for (WebElement ele : liveCallMembers3) {
			if (hangedUpMembers.contains(ele.getAttribute("id"))) {
				System.out.println(ele.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele).perform();
				Assert.assertTrue(ele.findElement(grpTalks.individualReDailButton).isDisplayed());
				String text = ele.findElement(By.xpath(".//*[contains(@class,'oncall-bg')]//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "Call Ended");
				System.out.println("----");
			}
		}
		logger_ss.log(Status.INFO, "Get participants for incoming call");
		requestParams = new JSONObject();
		int inComingParticipantCount = 2;
		List<String> incomingMembers = new ArrayList<String>();
		String incomingCallString = "";
		for (int i = 0; i < inComingParticipantCount; i++) {
			String randomElement = item.getRandomElement(hangedUpMembers);
			incomingCallString = incomingCallString.concat(randomElement);
			if(i<inComingParticipantCount-1){
				incomingCallString = incomingCallString.concat(",");
			}
			incomingMembers.add(randomElement);
		}
		System.out.println(" incomingCallString String:: "+incomingCallString);
		
		logger_ss.log(Status.INFO, "Make a post request for incoming Call participants");
		requestParams.put("incomingCalls", incomingCallString);
		
		request.body(requestParams.toString());
		Response incomingcallResponse = request.post();

		int incomingcallStatusCode = incomingcallResponse.getStatusCode();
		System.out.println("handRaise status code==="+incomingcallStatusCode);
		Thread.sleep(20000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		logger_ss.log(Status.INFO, "Verify OnCall is displayed for incoming participants");
		List<WebElement> liveCallMembers4 = driver.findElements(allMembersInLiveCall);
		for (WebElement ele : liveCallMembers4) {
			if (incomingMembers.contains(ele.getAttribute("id"))) {
				System.out.println(ele.getAttribute("id"));
				Thread.sleep(1000);
				actionObject.moveToElement(ele).perform();
				String text = ele.findElement(By.xpath(".//*[contains(@class,'oncall-bg')]//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "ON CALL");
				System.out.println("----");
			}
		}
		grpTalks.hangUpCurrentGrpTalkcall();
	}
	
	
	
	
	
	
	
	
	


	@Ignore
	@Test
	public void verifyCallFunctionalityFromCreateGroupTalkPageByCreatingNewGroup() throws InterruptedException {
		driver.get("http://staging.grptalk.com/index.aspx?automationkey=narasimha");
		CreatingGroup crtgrp = new CreatingGroup();
		GrpTalks grpTalks = new GrpTalks();
		grpTalks.clickCreateGrpButton();
		crtgrp.clickPhoneContactsTab();
		crtgrp.selectFewContactsFromContactList();
		crtgrp.selectedContactsTab();

		List<WebElement> list = driver.findElements(By.xpath("//*[@id='selectedContacts']//p[2]"));
		List<String> contactsList = new ArrayList<String>();
		for (WebElement ele : list) {
			System.out.println(ele.getText().replaceAll("[^a-zA-Z0-9]", ""));
			contactsList.add(ele.getText().replaceAll("[^a-zA-Z0-9]", ""));
		}
		crtgrp.setGrpTalkName();
		crtgrp.submitStartNowButton();
		crtgrp.clickMuteDialButtonOnOverlayInCreateGrpTalk();
		RestAssured.baseURI = "http://192.168.75.75:8888/v0.1/Mock";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest
				.get("/?Api=bulk&resp=true&onCall=" + list.get(0) + "&disconnect=" + list.get(1));
		int statusCode = response.getStatusCode();
		System.out.println("Status code is::" + statusCode);
		Assert.assertEquals(statusCode /* actual value */,
				200 /* expected value */, "Correct status code returned");
		Thread.sleep(10000);
		grpTalks.hangUpCurrentGrpTalkcall();
		//
		//// grpTalks.verifyLiveCallState();
		//// logger_ss.log(Status.INFO, "Verified the visiblity of inProgress
		// element");
	}


	
	@Test
	public void verifyCallFunctionalityCopy() throws InterruptedException {
		driver.get("http://staging.grptalk.com/index.aspx?automationkey=narasimha");
		GrpTalks grpTalks = new GrpTalks();
		
		grpTalks.selectSavedGroupByName("Srenivas_Demo_8");
		String hostContactNumber = driver.findElement(hostNumber).getText().replaceAll("[^a-zA-Z0-9]", "");
		List<WebElement> list = driver.findElements(allMembers);
		
		List<String> contactsList = new ArrayList<String>();
		Actions action=new Actions(driver);
		for (WebElement ele : list) {
			action.moveToElement(ele).perform();
			contactsList.add(ele.getText().replaceAll("[^a-zA-Z0-9]", ""));
		}
		grpTalks.dialGroupCallButton();
		grpTalks.muteDialGroupCallOnOverlay111();

		RestApiTest item = new RestApiTest();
		
		List<String> copyList = new ArrayList<String>(contactsList);
		
		List<String> onCallMembers = item.getRandomElements(copyList);
		
		List<String> onCallMembersExceptHost = new ArrayList<String>(onCallMembers);
		for (int i = 0; i < onCallMembersExceptHost.size(); i++) {
			if(onCallMembersExceptHost.get(i).contains(hostContactNumber)){
				onCallMembersExceptHost.remove(i);
				break;
			}
		}
		
		RestAssured.baseURI = "http://192.168.72.27:8888/v0.1/Mock/";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		
		int onCallMembersCount = onCallMembers.size();
		String onCallString = "";
		for (int i = 0; i < onCallMembersCount; i++) {
			onCallString = onCallString.concat(onCallMembers.get(i));
			if(i<onCallMembersCount-1){
				onCallString = onCallString.concat(",");
			}
		}
		requestParams.put("onCall", onCallString);
		
		String disConnnectedString = "";
		int disconnectedCount = copyList.size();
		for (int i = 0; i < disconnectedCount; i++) {
			disConnnectedString = disConnnectedString.concat(copyList.get(i));
			if(i<disconnectedCount-1){
				disConnnectedString = disConnnectedString.concat(",");
			}
		}
		requestParams.put("disconnect", disConnnectedString);

		request.body(requestParams.toString());
		Response response = request.post();

		int statusCode = response.getStatusCode();
		System.out.println("oncall status code::"+statusCode);
		Thread.sleep(20000);
				
//		By cursor = By.xpath("");
//		new Actions(driver).dragAndDropBy(dragElementFrom, 100, 0).build() .perform();
		List<WebElement> llll = driver.findElements(By.xpath("//*[contains(@class,'col-xs-4 col-sm-3 oncall-admin')]//*[@class='persn-phnm-det']"));
		Actions actionn =new Actions(driver);
		for(WebElement ele : llll){
			actionn.moveToElement(ele).perform();
		}
		List<WebElement> liveCallMembers = driver.findElements(By.xpath("//*[contains(@class,'col-xs-4 col-sm-3 oncall-admin')]"));
		System.out.println("live call members size==="+liveCallMembers.size());
		By scrollbar= By.xpath("//*[@class='slimScrollBar']");
		for (WebElement ele1 : liveCallMembers) {
			System.out.println(ele1.getAttribute("id"));
			if (onCallMembers.contains(ele1.getAttribute("id"))) {
				System.out.println(ele1.getAttribute("id"));
				String text = ele1.findElement(By.xpath("//*[@class='oncall-bg bgGreen pull-right mr-2']//*[@class='oncall-text text-left']")).getText();
				Assert.assertEquals(text, "ON CALL");
			}
		}
		
		requestParams = new JSONObject();
		int handRaiseCount = 2;
		List<String> randomIems = new ArrayList<String>();
		List<String> handRaiseWithOutHost = new ArrayList<String>(onCallMembersExceptHost);
		String handRaiseString ="";
		for (int i = 0; i < handRaiseCount; i++) {
			String randomElement = item.getRandomElement(handRaiseWithOutHost);
			handRaiseString = handRaiseString.concat(randomElement);
			if(i<handRaiseCount-1){
				handRaiseString = handRaiseString.concat(",");
			}
			randomIems.add(randomElement);
		}
		
		requestParams.put("handrise", handRaiseString);
		
		System.out.println(" handRaiseString :: "+handRaiseString);
		request.body(requestParams.toString());
		Response handRaiseResponse = request.post();
		int handRaiseStatusCode = handRaiseResponse.getStatusCode();
		System.out.println("handRaise status code==="+handRaiseStatusCode);
		Thread.sleep(20000);
		
		requestParams = new JSONObject();
		int hangUpParticipantCount = 2;
		List<String> randomHangUp = new ArrayList<String>();
		String hangUpString = "";
		for (int i = 0; i < hangUpParticipantCount; i++) {
			String randomElement = item.getRandomElement(onCallMembers);
			hangUpString = hangUpString.concat(randomElement);
			if(i<hangUpParticipantCount-1){
				hangUpString = hangUpString.concat(",");
			}
			randomHangUp.add(randomElement);
		}
		
		requestParams.put("leaveConference", hangUpString);
		
		System.out.println(" hangUpString String:: "+hangUpString);
		
		request.body(requestParams.toString());
		Response hangUpResponse = request.post();
		System.out.println(requestParams.toString());

		int hangUpStatusCode = hangUpResponse.getStatusCode();
		System.out.println("handRaise status code==="+hangUpStatusCode);
		Thread.sleep(20000);
		
		
		//Assert.assertEquals(statusCode,200);
	//	Actions action3 = new Actions(driver);
//		for (WebElement ele : liveCallMembers) {
//			action3.moveToElement(ele).perform();
//			Thread.sleep(1000);
//			if (randomHangUp.contains(ele.getAttribute("id"))) {
//				//action.moveToElement(ele).perform();
//				Assert.assertTrue(ele.findElement(grpTalks.individualHangUpButton).isDisplayed());
//			}
//		}
		
		requestParams = new JSONObject();
		int inComingParticipantCount = 2;
		List<String> incomingMember = new ArrayList<String>();
	//	String incomingCallString = "/?Api=bulk&resp=true&incomingCalls=";
		String incomingCallString = "";
		for (int i = 0; i < inComingParticipantCount; i++) {
			String randomElement = item.getRandomElement(randomHangUp);
			incomingCallString = incomingCallString.concat(randomElement);
			if(i<inComingParticipantCount-1){
				incomingCallString = incomingCallString.concat(",");
			}
			incomingMember.add(randomElement);
		}
		System.out.println(" incomingCallString String:: "+incomingCallString);
		
		requestParams.put("incomingCalls", incomingCallString);
		
		request.body(requestParams.toString());
		Response incomingcallResponse = request.post();

		int incomingcallStatusCode = incomingcallResponse.getStatusCode();
		System.out.println("handRaise status code==="+incomingcallStatusCode);
		Thread.sleep(20000);
		
//		Actions action4 = new Actions(driver);
//		for (WebElement ele : liveCallMembers) {
//			action4.moveToElement(ele).perform();
//			Thread.sleep(1000);
//			if (incomingMember.contains(ele.getAttribute("id"))) {
//				//action.moveToElement(ele).perform();
//				Assert.assertTrue(ele.findElement(grpTalks.individualHangUpButton).isDisplayed());
//			}
//		}
//		
		grpTalks.hangUpCurrentGrpTalkcall();
	}
	
}
