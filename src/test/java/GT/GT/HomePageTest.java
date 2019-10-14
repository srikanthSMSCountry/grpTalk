package GT.GT;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.*;

import org.testng.Assert;
import org.testng.ITestResult;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class HomePageTest extends BrowserFunctions{
	public static Logger logger = Logger.getLogger(CreateAndCallGroupTest.class);
	
	@BeforeClass
	public void beforeCalss(){
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("GrpTalk_Report_Of_HomePage.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger_ss = extent.createTest("GrpTalkHomePageTest");
		logger_ss.log(Status.INFO, "GrpTalkHomePageTest");
	}
	
	public String stagingContactUsNumber = "+91-40-47475544";
	public String produtionContactUsNumber = "+91-40-71044555";
	public String email =	"hello@grptalk.com";
	public String appStoreLink = "https://apps.apple.com/in/app/grptalk/id1074172134?gclid=&ls=1&referrer=utm_source%3D%26utm_medium%3Dcpc&source=";
	public String androidPlayStoreLink = "https://play.google.com/store/apps/details?id=com.mobile.android.grptalk&source=&gclid=&referrer=utm_source%3D%26utm_medium%3Dcpc&";
	public String facebookLink = "https://www.facebook.com/grptalkconferencing/";
	public String twitterLink = "https://twitter.com/grptalk";
	public String youtubeLink = "https://www.youtube.com/channel/UC1hgEdzMlNtp9P4cl_hR0zQ";
	
//	By inboxButton = By.className("fa fa-comments");
//	By email = By.id("email");
//	By password = By.id("pwd");
//	By loginButton = By.className("btn-Login");
//	By archive = By.className("fa fa-archive");
//	By agent = By.className("fa fa-user");
//	By chatWidget = By.xpath("//*[@id='widget_btn_container']//*[@src='assets/img/chat-icon.png']");
//	By welcomeMsgInChat = By.className("user_chat");
//	
//	 @Test
//	 public void chatFunctionality() throws InterruptedException {
//		// driver.navigate().to("www.staging.grptalk.com");
//		 driver.switchTo().frame("chat_frame");
//		 Actions action =new Actions(driver);
//		 action.moveToElement(driver.findElement(chatWidget)).perform();
//		 driver.findElement(chatWidget).click();
//		 Assert.assertEquals(driver.findElement(welcomeMsgInChat).getText(), " Hello!! how may I help you?");
//		  JavascriptExecutor jsExecutor = (JavascriptExecutor)this.driver;
//		  String jsOpenNewWindow = "window.open('https://pop.telebu.com/');";
//		  jsExecutor.executeScript(jsOpenNewWindow);
//		  Thread.sleep(1000);
//		  System.out.println("One opennd.");
//		  driver.findElement(email).sendKeys("sravani.singari@smscountry.com");;
//		  driver.findElement(password).sendKeys("Sravani@1");
//		  driver.findElement(loginButton).click();
//		  Thread.sleep(3000);
//		  
//		  Set<String> windowHandleSet = this.driver.getWindowHandles();
//		  String window1 = (String)windowHandleSet.toArray()[0];
//		  String window2 = (String)windowHandleSet.toArray()[1];
//		  System.out.println(window1);
//		  System.out.println(window2);
//
//	  }
	
	
	@Test
	public void verifyGrpTalkEmailAndContactDisplayedInHeaderScetion() throws InterruptedException{
		logger_ss = extent.createTest("verifyGrpTalkEmailAndContactDisplayedInHeaderScetion","verifyGrpTalkEmailAndContactDisplayedInHeaderScetion");
		HomePage homePage = new HomePage();
		homePage.visibilityOfGrpTalkEmail();
		logger_ss.log(Status.INFO, "verfied visibilityOfGrpTalkEmail");
		homePage.visibilityOfGrpTalkContactNumber();
		logger_ss.log(Status.INFO, "verfied visibilityOfGrpTalkContactNumber");
		Assert.assertEquals(homePage.grpTalkEmail(), email);
		logger_ss.log(Status.INFO, "Successfully verfied GrpTalkEmail");
		Assert.assertEquals(homePage.grpTalkContactNumber(), stagingContactUsNumber);
		logger_ss.log(Status.INFO, "Successfully verfied GrpTalkContact");
		logger_ss.log(Status.INFO, "Successfully verfied GrpTalkEmailAndContactDisplayedInHeaderScetion");
	}
	
	@Test
	public void verifyFeaturesTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyFeaturesTabFunctionality","verifyFeaturesTabFunctionality");
		HomePage homePage = new HomePage();
		String url=homePage.featuresTabFunctionality();
		logger_ss.log(Status.INFO, "clicked on featuresTab and get current url");
		Assert.assertEquals(url, currentUrl+"/Features");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied FeaturesTabFunctionality");
	}
	
	@Test
	public void verifyHowItWorksTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyHowItWorksTabFunctionality","verifyHowItWorksTabFunctionality");
		HomePage homePage = new HomePage();
		String url=homePage.howItWorksTabFunctionality();
		logger_ss.log(Status.INFO, "clicked on howItWorksTab and get current url");
		Assert.assertEquals(url, currentUrl+"/how-it-works");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied HowItWorksTabFunctionality");
	}
	
	@Test
	public void verifyPricingTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyPricingTabFunctionality","verifyPricingTabFunctionality");
		HomePage homePage = new HomePage();
		String textMessage=homePage.pricingTabFunctionality();
		Assert.assertTrue(textMessage.contains("Thank you for submitting your details."));
		logger_ss.log(Status.INFO, "clicked on pricing tab and verfied PricingTabFunctionality");
		String url= homePage.pricingTabURL();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, currentUrl+"/Pricing");
		logger_ss.log(Status.INFO, "verfied current url");
		logger_ss.log(Status.INFO, "Successfully verfied PricingTabFunctionality");
	}
	
	@Test
	public void verifyCustomerStoriesTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyCustomerStoriesTabFunctionality","verifyCustomerStoriesTabFunctionality");
		HomePage homePage = new HomePage();
		String url=homePage.customerStoriesTabFunctionality();
		logger_ss.log(Status.INFO, "clicked on ustomerStories tab and get current url");
		Assert.assertEquals(url, currentUrl+"/Customer-Stories");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied CustomerStoriesTabFunctionality");
	}
	
	@Test
	public void verifySolutionsTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifySolutionsTabFunctionality","verifySolutionsTabFunctionality");
		HomePage homePage = new HomePage();
		driver.navigate().refresh();
		String url=homePage.solutionsTabFunctionality();
		logger_ss.log(Status.INFO, "clicked on solutions tab and get current url");
		Assert.assertEquals(url, currentUrl+"/Solutions.aspx");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied solutions tab Functionality");
	}
	
	@Test
	public void verifyAppStoreTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyAppStoreTabFunctionality","verifyAppStoreTabFunctionality");
		HomePage homePage = new HomePage();
		homePage.clickAppStoreTab();
		logger_ss.log(Status.INFO, "clicked on AppStoreTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, appStoreLink);
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied AppStoreTabFunctionality");
	}
	
	@Test
	public void verifyPlayStoreTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyPlayStoreTabFunctionality","verifyPlayStoreTabFunctionality");
		HomePage homePage = new HomePage();
		homePage.clickPlayStoreTab();
		logger_ss.log(Status.INFO, "clicked on PlayStoreTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, androidPlayStoreLink);
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied PlayStoreTabFunctionality");
	}
	
	@Test
	public void verifyStartDemoFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyStartDemoFunctionality","verifyStartDemoFunctionality");
		HomePage homePage = new HomePage();
		homePage.clickStartDemoTab();
		logger_ss.log(Status.INFO, "clicked on StartDemoTab with out enter mobile number");
		Assert.assertEquals(homePage.getAlertText(), "Please Enter Your Mobile Number");
		logger_ss.log(Status.INFO, "verified AlertText ");
		homePage.acceptAlert();
		logger_ss.log(Status.INFO, "accepted AlertText ");
		homePage.enterMobileNumber();
		logger_ss.log(Status.INFO, "entered MobileNumber");
		homePage.clickStartDemoTab();
		logger_ss.log(Status.INFO, "clicked on StartDemoTab ");
		Assert.assertEquals(homePage.succesMsgOnAlert(), "Thanks for your interest in grptalk. The app download link will be shared with you shortly.");
		logger_ss.log(Status.INFO, "verified succesMsgOnAlert");
		homePage.clickOkButtonOnOverlay();
		logger_ss.log(Status.INFO, "clicked on OkButtonOnOverlay ");
		Assert.assertTrue(homePage.visibiltyOfStartDemoTab());
		logger_ss.log(Status.INFO, "verified visibiltyOfStartDemoTab ");
		logger_ss.log(Status.INFO, "Successfully verfied StartDemoFunctionality");
	}
	
	@Test
	public void verifyWebLoginFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyWebLoginFunctionality","verifyWebLoginFunctionality");
		HomePage homePage = new HomePage();
		homePage.clickWebLoginTab();
		logger_ss.log(Status.INFO, "clicked on web login tab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertTrue(homePage.visibilityOfImgQRCode());
		logger_ss.log(Status.INFO, "verified visibilityOfImgQRCode ");
		Assert.assertEquals(url, CommonMethods.passingData("productionWebHomePage")+"/");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied WebLoginFunctionality");
		//homePage.closeCurrentTab();
		//homePage.switchToDefaultTab();
		//Assert.assertEquals(homePage.getCurrentUrl(), "https://www.grptalk.com/");
	}
	
	
	@Test
	public void verifyYouTubeVideoFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyYouTubeVideoFunctionality","verifyYouTubeVideoFunctionality");
		HomePage homePage = new HomePage();
		//homePage.clickPlayButtonForYoutubeVideo();
		Assert.assertTrue(homePage.visibilityOfYoutubeVideo());
		logger_ss.log(Status.INFO, "Successfully verfied YouTubeVideoFunctionality");
	}
	
	@Test
	public void verifyContactSalesButtonFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyContactSalesButtonFunctionality","verifyContactSalesButtonFunctionality");
		HomePage homePage = new HomePage();
		homePage.clickContactSalesTab();
		driver.switchTo().alert().accept();
		logger_ss.log(Status.INFO, "clicked on ContactSalesTab without entered email");
		homePage.enterEmail();
		logger_ss.log(Status.INFO, "Entered email ");
		homePage.clickContactSalesTab();
		logger_ss.log(Status.INFO, "clicked on ContactSalesTab");
		Thread.sleep(1000);
		Assert.assertEquals(homePage.succesMsgOnAlert(), "Thanks for your interest in grptalk. Our team will get in touch with you shortly.");
		logger_ss.log(Status.INFO, "verified succesMsgOnAlert ");
		homePage.clickOkButtonOnOverlay();
		logger_ss.log(Status.INFO, "clicked on OkButtonOnOverlay");
		Assert.assertTrue(homePage.visibiltyOfcontactSalesTab());
		logger_ss.log(Status.INFO, "verified visibiltyOfcontactSalesTab");
		logger_ss.log(Status.INFO, "successfully verified ContactSalesButtonFunctionality");
	}
	
	@Test
	public void verifyScanQRCodeTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyScanQRCodeTabFunctionality","verifyScanQRCodeTabFunctionality");
		HomePage homePage = new HomePage();
		homePage.clickScanQRCodeTab();
		logger_ss.log(Status.INFO, "clicked on ScanQRCodeTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, CommonMethods.passingData("productionWebHomePage")+"/");
		logger_ss.log(Status.INFO, "verified current url");
		Assert.assertTrue(homePage.visibilityOfImgQRCode());
		logger_ss.log(Status.INFO, "verified visibilityOfImgQRCode");
		logger_ss.log(Status.INFO, "successfully verified ScanQRCodeTabFunctionality");
	}
	
	@Test
	public void verifyHomeLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyHomeLinkInFooterSection","verifyHomeLinkInFooterSection");
		HomePage homePage = new HomePage();
		homePage.clickHomeLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on HomeLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, currentUrl+"/");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified HomeLinkInFooterSection");
	}
	
	@Test
	public void verifyAboutLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyAboutLinkInFooterSection","verifyAboutLinkInFooterSection");
		HomePage homePage = new HomePage();
		homePage.clickAboutLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on AboutLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, currentUrl+"/About-us");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified AboutLinkInFooterSection");
	}
	
	@Test
	public void verifyHowItWorksLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyHowItWorksLinkInFooterSection","verifyHowItWorksLinkInFooterSection");
		HomePage homePage = new HomePage();
		homePage.clickHowItWorksLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on HowItWorksLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, currentUrl+"/how-it-works");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified HowItWorksLinkInFooterSection");
	}
	
	@Test
	public void verifyPricingLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyPricingLinkInFooterSection","verifyPricingLinkInFooterSection");
		HomePage homePage = new HomePage();
		homePage.clickPricingLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on PricingLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, currentUrl+"/Pricing");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified PricingLinkInFooterSection");
	}
	
	@Test
	public void verifyFeaturesLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyFeaturesLinkInFooterSection","verifyFeaturesLinkInFooterSection");
		HomePage homePage = new HomePage();
		homePage.clickFeaturesLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on FeaturesLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, currentUrl+"/Features");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified FeaturesLinkInFooterSection");
	}
	
	@Test
	public void verifyWebLoginLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyWebLoginLinkInFooterSection","verifyWebLoginLinkInFooterSection");
		HomePage homePage = new HomePage();
		homePage.clickWebLoginLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on WebLoginLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, CommonMethods.passingData("productionWebHomePage")+"/");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified WebLoginLinkInFooterSection");
	}
	
	@Test
	public void verifyCustomerStoriesLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyCustomerStoriesLinkInFooterSection","verifyCustomerStoriesLinkInFooterSection");
		HomePage homePage = new HomePage();
		homePage.clickCustomerStoriesLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on CustomerStoriesLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, currentUrl+"/Customer-Stories");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified CustomerStoriesLinkInFooterSection");
	}
	
	@Test
	public void verifyBlogLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyBlogLinkInFooterSection","verifyBlogLinkInFooterSection");
		HomePage homePage = new HomePage();
		System.out.println(driver.getWindowHandle());
		homePage.clickBlogLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on BlogLinkInFooterSection");
		homePage.switchToNewTab();
		logger_ss.log(Status.INFO, "switched ToNewTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, CommonMethods.passingData("productionHomePage")+"/blog/");
		logger_ss.log(Status.INFO, "verified current url");
		homePage.closeCurrentTab();
		logger_ss.log(Status.INFO, "closed current tab");
		homePage.switchToDefaultTab();
		logger_ss.log(Status.INFO, "switched ToDefaultTab");
		String grpTalkURL=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(grpTalkURL, currentUrl+"/");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified BlogLinkInFooterSection");
	}
	
	@Test
	public void verifyFunctionalityOfFacebookLogoInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyFunctionalityOfFacebookLogoInFooterSection","verifyFunctionalityOfFacebookLogoInFooterSection");
		HomePage homePage = new HomePage();
		System.out.println(driver.getWindowHandle());
		homePage.clickFacebookLogoInFooterSection();
		logger_ss.log(Status.INFO, "clicked on FacebookLogoInFooterSection");
		Thread.sleep(1000);
		homePage.switchToNewTab();
		Thread.sleep(3000);
		logger_ss.log(Status.INFO, "switched ToNewTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "getCurrentUrl");
		Assert.assertEquals(url, facebookLink);
		logger_ss.log(Status.INFO, "verified current url");
		homePage.closeCurrentTab();
		logger_ss.log(Status.INFO, "closed CurrentTab");
		homePage.switchToDefaultTab();
		logger_ss.log(Status.INFO, "switched ToDefaultTab");
		String grpTalkURL=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "getCurrentUrl");
		Assert.assertEquals(grpTalkURL,currentUrl+"/");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified FunctionalityOfFacebookLogoInFooterSection");
	}
	
//	@Test
//	public void verifyGrpTalkContactFunctionalityInHeaderScetion() throws InterruptedException{
//		logger_ss = extent.createTest("verifyGrpTalkContactFunctionalityInHeaderScetion","verifyGrpTalkContactFunctionalityInHeaderScetion");
//		HomePage homePage = new HomePage(driver);
//		homePage.visibilityOfGrpTalkContactNumber();
//		Assert.assertEquals(homePage.grpTalkContactNumber(), "+91-40-38119919");
//		homePage.clickGrpTalkContactNumber();
//		logger_ss.log(Status.INFO, "Successfully verfied GrpTalkContact functionality");
//		homePage.visibilityOfGrpTalkContactNumber();
//	}
	
	@Test
	public void verifyFunctionalityOfTwitterLogoInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyFunctionalityOfTwitterLogoInFooterSection","verifyFunctionalityOfTwitterLogoInFooterSection");
		HomePage homePage = new HomePage();
		homePage.clickTwitterLogoInFooterSection();
		logger_ss.log(Status.INFO, "clicked on TwitterLogoInFooterSection");
		homePage.switchToNewTab();
		logger_ss.log(Status.INFO, "switched ToNewTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "getCurrentUrl");
		Assert.assertEquals(url, twitterLink);
		logger_ss.log(Status.INFO, "verified current url");
		homePage.closeCurrentTab();
		logger_ss.log(Status.INFO, "closed CurrentTab");
		homePage.switchToDefaultTab();
		logger_ss.log(Status.INFO, "switched ToDefaultTab");
		String grpTalkURL=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(grpTalkURL, currentUrl+"/");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified FunctionalityOfTwitterLogoInFooterSection");
		
	}
	
//	@Test
//	public void verifyChatFunctionality() throws InterruptedException{
//		logger_ss = extent.createTest("verifyChatFunctionality","verifyChatFunctionality");
//		HomePage homePage = new HomePage(driver);
//		Thread.sleep(3000);
//		homePage.clickBeginChatOption();
//		logger_ss.log(Status.INFO, "Switched to frame and clicked on BeginChatOption");
//		Assert.assertEquals(homePage.textDisplayedOnChatBox(), "Hello there, How may I help you today?");
//		logger_ss.log(Status.INFO, "verified textDisplayedOnChatBox");
//		Assert.assertTrue(homePage.visibilityOfMessageFieldInChat());
//		logger_ss.log(Status.INFO, "verified visibilityOfMessageFieldInChat");
//		homePage.clickCloseChatOption();
//		logger_ss.log(Status.INFO, "clicked on CloseChatOption");
//		Assert.assertTrue(homePage.visibilityOfChatOption());
//		logger_ss.log(Status.INFO, "verified visibilityOfChatOption");
//		driver.switchTo().defaultContent();
//		logger_ss.log(Status.INFO, "switched back to window");
//		logger_ss.log(Status.INFO, "successfully verified ChatFunctionality");
//	}
	
	@Ignore
	@Test(priority=5)
	public void verifyChatFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyChatFunctionality","verifyChatFunctionality");
		HomePage homePage = new HomePage();
		Thread.sleep(3000);
		homePage.clickChatOption();
		logger_ss.log(Status.INFO, "Switched to Chat Option");
		Assert.assertEquals(homePage.textOnChatBox(), "Introduce Yourself and Chat!");
		logger_ss.log(Status.INFO, "verified textDisplayedOnChatBox");
		String textMessage = homePage.startChatByEnteringDetails();
		Thread.sleep(1000);
		Assert.assertEquals(textMessage, "Hi");
		logger_ss.log(Status.INFO, "Successfully sent text message");
		homePage.closingChatOption();
		logger_ss.log(Status.INFO, "successfully verified ChatFunctionality");
	}
	
	@Test
	public void verifyFunctionalityOfYoutubeLogoInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyFunctionalityOfYoutubeLogoInFooterSection","verifyFunctionalityOfYoutubeLogoInFooterSection");
		HomePage homePage = new HomePage();
		homePage.clickYoutubeLogoInFooterSection();
		logger_ss.log(Status.INFO, "clicked on YoutubeLogoInFooterSection");
		homePage.switchToNewTab();
		logger_ss.log(Status.INFO, "switched ToNewTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, youtubeLink);
		logger_ss.log(Status.INFO, "verified current url");
		homePage.closeCurrentTab();
		logger_ss.log(Status.INFO, "closed current tab");
		homePage.switchToDefaultTab();
		logger_ss.log(Status.INFO, "switched to DefaultTab");
		String grpTalkURL=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(grpTalkURL, currentUrl+"/");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "successfully verified FunctionalityOfYoutubeLogoInFooterSection");
	}
	
	
	@Test
	public void verifyContactLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyContactLinkInFooterSection","verifyContactLinkInFooterSection");
		HomePage homePage = new HomePage();
		homePage.clickContactLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on ContactLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, currentUrl+"/contact-us");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "successfully verified ContactLinkInFooterSection");
	}
	
		
	@Test
	public void verify_FAQ_LinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verify_FAQ_LinkInFooterSection","verify_FAQ_LinkInFooterSection");
		HomePage homePage = new HomePage();
		homePage.click_FAQ_LinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on FAQ_LinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, currentUrl+"/faqs");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "successfully verified ContactLinkInFooterSection");
	}	
	
	@Test
	public void verifyTermsAndConditionsLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyTermsAndConditionsLinkInFooterSection","verifyTermsAndConditionsLinkInFooterSection");
		HomePage homePage = new HomePage();
		homePage.clickTermsAndConditionsLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on TermsAndConditionsLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, currentUrl+"/terms-and-conditions");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "successfully verified TermsAndConditionsLinkInFooterSection");
	}	
	
	@Test
	public void verifyPrivacyAndDataUsageLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyPrivacyAndDataUsageLinkInFooterSection","verifyPrivacyAndDataUsageLinkInFooterSection");
		HomePage homePage = new HomePage();
		homePage.clickPrivacyAndDataUsageLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on PrivacyAndDataUsageLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, currentUrl+"/Privacy");
		logger_ss.log(Status.INFO, "verified Current Url");
		logger_ss.log(Status.INFO, "successfully verified PrivacyAndDataUsageLinkInFooterSection");
	}	
	
	@Test
	public void verifyRequest_A_PriceTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyRequest_A_PriceTabFunctionality","verifyRequest_A_PriceTabFunctionality");
		HomePage homePage = new HomePage();
		String textMessage=homePage.request_A_PriceTabFunctionality();
		Assert.assertTrue(textMessage.contains("Thank you for submitting your details."));
		logger_ss.log(Status.INFO, "clicked on pricing tab and verfied PricingTabFunctionality");
		String url= homePage.pricingTabURL();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, currentUrl+"/Pricing");
		logger_ss.log(Status.INFO, "verfied current url");
		logger_ss.log(Status.INFO, "Successfully verfied PricingTabFunctionality");
	}
	
	@Test
	public void verifyCopyRightTextInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyCopyRightTextInFooterSection","verifyCopyRightTextInFooterSection");
		HomePage homePage = new HomePage();
		Assert.assertEquals(homePage.copyRightTextInFooterSection(), "COPYRIGHT 2018 GRPTALK BY TELEBU. ALL RIGHTS RESERVED.");
		logger_ss.log(Status.INFO, "get copyRightTextInFooterSection and verified");
		logger_ss.log(Status.INFO, "successfully verified CopyRightTextInFooterSection");
	}

}
