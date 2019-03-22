package GT.GT;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.Assert;
import org.testng.ITestResult;

public class HomePageTest{
	public static Logger logger = Logger.getLogger(CreatingGroupTest.class);
	
	public static WebDriver driver;
	ExtentReports extent ;
	ExtentTest logger_ss;
	//public static Logger logger = Logger.getLogger(AudioTest.class);
	String downloadFilepath="D:\\grpTalk\\TestDataFiles\\downloads\\";
	StringBuilder sb = new StringBuilder();

	@BeforeSuite
	public void initialioseBrowser() throws InterruptedException {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("smsc_report.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger_ss = extent.createTest("BeforeTest");
		System.setProperty("webdriver.chrome.driver", "D:\\GrpTalk\\Drivers\\chromedriver.exe");
		System.out.println(System.getProperty("user.dir"));
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(cap);
		//driver = new ChromeDriver();
		logger_ss.log(Status.INFO, "Chrome Browser Launched Successfully");
		//logger.info("Started in Chrome Browser");
		// driver = new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get("http://ec2-34-216-45-200.us-west-2.compute.amazonaws.com/#/competitive-trends/702");
		driver.manage().window().maximize();
		driver.get("https://www.grptalk.com/");
		logger_ss.log(Status.INFO, "GrpTalk home page opend successfully");
		Thread.sleep(6000);
	}

	@AfterSuite
	public void closeBrowser() {
	driver.quit();
	logger_ss.log(Status.INFO, "Browser closed successfully");
	}
	
	
	@Test
	public void verifyGrpTalkEmailAndContactDisplayedInHeaderScetion(){
		logger_ss = extent.createTest("verifyGrpTalkEmailAndContactDisplayedInHeaderScetion","verifyGrpTalkEmailAndContactDisplayedInHeaderScetion");
		HomePage homePage = new HomePage(driver);
		homePage.visibilityOfGrpTalkEmail();
		logger_ss.log(Status.INFO, "verfied visibilityOfGrpTalkEmail");
		homePage.visibilityOfGrpTalkContactNumber();
		logger_ss.log(Status.INFO, "verfied visibilityOfGrpTalkContactNumber");
		Assert.assertEquals(homePage.grpTalkEmail(), "hello@grptalk.com");
		logger_ss.log(Status.INFO, "Successfully verfied GrpTalkEmail");
		Assert.assertEquals(homePage.grpTalkContactNumber(), "+91-40-38119919");
		logger_ss.log(Status.INFO, "Successfully verfied GrpTalkContact");
		logger_ss.log(Status.INFO, "Successfully verfied GrpTalkEmailAndContactDisplayedInHeaderScetion");
	}
	
	@Test
	public void verifyFeaturesTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyFeaturesTabFunctionality","verifyFeaturesTabFunctionality");
		HomePage homePage = new HomePage(driver);
		String url=homePage.featuresTabFunctionality();
		logger_ss.log(Status.INFO, "clicked on featuresTab and get current url");
		Assert.assertEquals(url, "https://www.grptalk.com/Features");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied FeaturesTabFunctionality");
	}
	
	@Test
	public void verifyHowItWorksTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyHowItWorksTabFunctionality","verifyHowItWorksTabFunctionality");
		HomePage homePage = new HomePage(driver);
		String url=homePage.howItWorksTabFunctionality();
		logger_ss.log(Status.INFO, "clicked on howItWorksTab and get current url");
		Assert.assertEquals(url, "https://www.grptalk.com/how-it-works");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied HowItWorksTabFunctionality");
	}
	
	@Test
	public void verifyPricingTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyPricingTabFunctionality","verifyPricingTabFunctionality");
		HomePage homePage = new HomePage(driver);
		String textMessage=homePage.pricingTabFunctionality();
		Assert.assertTrue(textMessage.contains("Thank you for submitting your details."));
		logger_ss.log(Status.INFO, "clicked on pricing tab and verfied PricingTabFunctionality");
		String url= homePage.pricingTabURL();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, "https://www.grptalk.com/Pricing");
		logger_ss.log(Status.INFO, "verfied current url");
		logger_ss.log(Status.INFO, "Successfully verfied PricingTabFunctionality");
	}
	
	@Test
	public void verifyCustomerStoriesTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyCustomerStoriesTabFunctionality","verifyCustomerStoriesTabFunctionality");
		HomePage homePage = new HomePage(driver);
		String url=homePage.customerStoriesTabFunctionality();
		logger_ss.log(Status.INFO, "clicked on ustomerStories tab and get current url");
		Assert.assertEquals(url, "https://www.grptalk.com/Customer-Stories");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied CustomerStoriesTabFunctionality");
	}
	
	@Test
	public void verifySolutionsTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifySolutionsTabFunctionality","verifySolutionsTabFunctionality");
		HomePage homePage = new HomePage(driver);
		driver.navigate().refresh();
		String url=homePage.solutionsTabFunctionality();
		logger_ss.log(Status.INFO, "clicked on solutions tab and get current url");
		Assert.assertEquals(url, "https://www.grptalk.com/Solutions.aspx");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied solutions tab Functionality");
	}
	
	@Test
	public void verifyAppStoreTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyAppStoreTabFunctionality","verifyAppStoreTabFunctionality");
		HomePage homePage = new HomePage(driver);
		homePage.clickAppStoreTab();
		logger_ss.log(Status.INFO, "clicked on AppStoreTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, "https://itunes.apple.com/in/app/grptalk/id1074172134?ls=1&mt=8");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied AppStoreTabFunctionality");
	}
	
	@Test
	public void verifyPlayStoreTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyPlayStoreTabFunctionality","verifyPlayStoreTabFunctionality");
		HomePage homePage = new HomePage(driver);
		homePage.clickPlayStoreTab();
		logger_ss.log(Status.INFO, "clicked on PlayStoreTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, "https://play.google.com/store/apps/details?id=com.mobile.android.grptalk");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied PlayStoreTabFunctionality");
	}
	
	@Test
	public void verifyStartDemoFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyStartDemoFunctionality","verifyStartDemoFunctionality");
		HomePage homePage = new HomePage(driver);
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
		HomePage homePage = new HomePage(driver);
		homePage.clickWebLoginTab();
		logger_ss.log(Status.INFO, "clicked on web login tab");
		//homePage.switchToNewTab();
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertTrue(homePage.visibilityOfImgQRCode());
		logger_ss.log(Status.INFO, "verified visibilityOfImgQRCode ");
		Assert.assertEquals(url, "https://web.grptalk.com/");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "Successfully verfied WebLoginFunctionality");
		//homePage.closeCurrentTab();
		//homePage.switchToDefaultTab();
		//Assert.assertEquals(homePage.getCurrentUrl(), "https://www.grptalk.com/");
	}
	
	
	@Test
	public void verifyYouTubeVideoFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyYouTubeVideoFunctionality","verifyYouTubeVideoFunctionality");
		HomePage homePage = new HomePage(driver);
		//homePage.clickPlayButtonForYoutubeVideo();
		Assert.assertTrue(homePage.visibilityOfYoutubeVideo());
		logger_ss.log(Status.INFO, "Successfully verfied YouTubeVideoFunctionality");
	}
	
	@Test
	public void verifyContactSalesButtonFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyContactSalesButtonFunctionality","verifyContactSalesButtonFunctionality");
		HomePage homePage = new HomePage(driver);
		homePage.clickContactSalesTab();
		logger_ss.log(Status.INFO, "clicked on ContactSalesTab without entered email");
		Assert.assertEquals(homePage.getAlertTextForEmail(), "Please Enter Your Email");
		logger_ss.log(Status.INFO, "verified AlertText ");
		homePage.acceptAlert();
		logger_ss.log(Status.INFO, "Accepted AlertText ");
		homePage.enterEmail();
		logger_ss.log(Status.INFO, "Entered email ");
		homePage.clickContactSalesTab();
		logger_ss.log(Status.INFO, "clicked on ContactSalesTab");
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
		HomePage homePage = new HomePage(driver);
		homePage.clickScanQRCodeTab();
		logger_ss.log(Status.INFO, "clicked on ScanQRCodeTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, "https://web.grptalk.com/");
		logger_ss.log(Status.INFO, "verified current url");
		Assert.assertTrue(homePage.visibilityOfImgQRCode());
		logger_ss.log(Status.INFO, "verified visibilityOfImgQRCode");
		logger_ss.log(Status.INFO, "successfully verified ScanQRCodeTabFunctionality");
	}
	
	@Test
	public void verifyHomeLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyHomeLinkInFooterSection","verifyHomeLinkInFooterSection");
		HomePage homePage = new HomePage(driver);
		homePage.clickHomeLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on HomeLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, "https://www.grptalk.com/");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified HomeLinkInFooterSection");
	}
	
	@Test
	public void verifyAboutLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyAboutLinkInFooterSection","verifyAboutLinkInFooterSection");
		HomePage homePage = new HomePage(driver);
		homePage.clickAboutLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on AboutLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, "https://www.grptalk.com/About-us");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified AboutLinkInFooterSection");
	}
	
	@Test
	public void verifyHowItWorksLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyHowItWorksLinkInFooterSection","verifyHowItWorksLinkInFooterSection");
		HomePage homePage = new HomePage(driver);
		homePage.clickHowItWorksLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on HowItWorksLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, "https://www.grptalk.com/how-it-works");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified HowItWorksLinkInFooterSection");
	}
	
	@Test
	public void verifyPricingLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyPricingLinkInFooterSection","verifyPricingLinkInFooterSection");
		HomePage homePage = new HomePage(driver);
		homePage.clickPricingLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on PricingLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, "https://www.grptalk.com/Pricing");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified PricingLinkInFooterSection");
	}
	
	@Test
	public void verifyFeaturesLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyFeaturesLinkInFooterSection","verifyFeaturesLinkInFooterSection");
		HomePage homePage = new HomePage(driver);
		homePage.clickFeaturesLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on FeaturesLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, "https://www.grptalk.com/Features");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified FeaturesLinkInFooterSection");
	}
	
	@Test
	public void verifyWebLoginLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyWebLoginLinkInFooterSection","verifyWebLoginLinkInFooterSection");
		HomePage homePage = new HomePage(driver);
		homePage.clickWebLoginLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on WebLoginLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, "https://web.grptalk.com/");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified WebLoginLinkInFooterSection");
	}
	
	@Test
	public void verifyCustomerStoriesLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyCustomerStoriesLinkInFooterSection","verifyCustomerStoriesLinkInFooterSection");
		HomePage homePage = new HomePage(driver);
		homePage.clickCustomerStoriesLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on CustomerStoriesLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, "https://www.grptalk.com/Customer-Stories");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified CustomerStoriesLinkInFooterSection");
	}
	
	@Test
	public void verifyBlogLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyBlogLinkInFooterSection","verifyBlogLinkInFooterSection");
		HomePage homePage = new HomePage(driver);
		homePage.clickBlogLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on BlogLinkInFooterSection");
		homePage.switchToNewTab();
		logger_ss.log(Status.INFO, "switched ToNewTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, "https://www.grptalk.com/blog/");
		logger_ss.log(Status.INFO, "verified current url");
		homePage.closeCurrentTab();
		logger_ss.log(Status.INFO, "closed current tab");
		homePage.switchToDefaultTab();
		logger_ss.log(Status.INFO, "switched ToDefaultTab");
		String grpTalkURL=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(grpTalkURL, "https://www.grptalk.com/");
		logger_ss.log(Status.INFO, "verified current url");
		logger_ss.log(Status.INFO, "successfully verified BlogLinkInFooterSection");
	}
	
	@Test
	public void verifyFunctionalityOfFacebookLogoInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyFunctionalityOfFacebookLogoInFooterSection","verifyFunctionalityOfFacebookLogoInFooterSection");
		HomePage homePage = new HomePage(driver);
		homePage.clickFacebookLogoInFooterSection();
		logger_ss.log(Status.INFO, "clicked on FacebookLogoInFooterSection");
		homePage.switchToNewTab();
		logger_ss.log(Status.INFO, "switched ToNewTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "getCurrentUrl");
		Assert.assertEquals(url, "https://www.facebook.com/grptalkconferencing/");
		logger_ss.log(Status.INFO, "verified current url");
		homePage.closeCurrentTab();
		logger_ss.log(Status.INFO, "closed CurrentTab");
		homePage.switchToDefaultTab();
		logger_ss.log(Status.INFO, "switched ToDefaultTab");
		String grpTalkURL=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "getCurrentUrl");
		Assert.assertEquals(grpTalkURL, "https://www.grptalk.com/");
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
		HomePage homePage = new HomePage(driver);
		homePage.clickTwitterLogoInFooterSection();
		logger_ss.log(Status.INFO, "clicked on TwitterLogoInFooterSection");
		homePage.switchToNewTab();
		logger_ss.log(Status.INFO, "switched ToNewTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "getCurrentUrl");
		Assert.assertEquals(url, "https://twitter.com/grptalk");
		logger_ss.log(Status.INFO, "verified current url");
		homePage.closeCurrentTab();
		logger_ss.log(Status.INFO, "closed CurrentTab");
		homePage.switchToDefaultTab();
		logger_ss.log(Status.INFO, "switched ToDefaultTab");
		String grpTalkURL=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(grpTalkURL, "https://www.grptalk.com/");
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
	
	@Test(priority=5)
	public void verifyChatFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyChatFunctionality","verifyChatFunctionality");
		HomePage homePage = new HomePage(driver);
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
		HomePage homePage = new HomePage(driver);
		homePage.clickYoutubeLogoInFooterSection();
		logger_ss.log(Status.INFO, "clicked on YoutubeLogoInFooterSection");
		homePage.switchToNewTab();
		logger_ss.log(Status.INFO, "switched ToNewTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, "https://www.youtube.com/channel/UC1hgEdzMlNtp9P4cl_hR0zQ");
		logger_ss.log(Status.INFO, "verified current url");
		homePage.closeCurrentTab();
		logger_ss.log(Status.INFO, "closed current tab");
		homePage.switchToDefaultTab();
		logger_ss.log(Status.INFO, "switched to DefaultTab");
		String grpTalkURL=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(grpTalkURL, "https://www.grptalk.com/");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "successfully verified FunctionalityOfYoutubeLogoInFooterSection");
	}
	
	
	@Test
	public void verifyContactLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyContactLinkInFooterSection","verifyContactLinkInFooterSection");
		HomePage homePage = new HomePage(driver);
		homePage.clickContactLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on ContactLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, "https://www.grptalk.com/contact-us");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "successfully verified ContactLinkInFooterSection");
	}
	
		
	@Test
	public void verify_FAQ_LinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verify_FAQ_LinkInFooterSection","verify_FAQ_LinkInFooterSection");
		HomePage homePage = new HomePage(driver);
		homePage.click_FAQ_LinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on FAQ_LinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, "https://www.grptalk.com/faqs");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "successfully verified ContactLinkInFooterSection");
	}	
	
	@Test
	public void verifyTermsAndConditionsLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyTermsAndConditionsLinkInFooterSection","verifyTermsAndConditionsLinkInFooterSection");
		HomePage homePage = new HomePage(driver);
		homePage.clickTermsAndConditionsLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on TermsAndConditionsLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, "https://www.grptalk.com/terms-and-conditions");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "successfully verified TermsAndConditionsLinkInFooterSection");
	}	
	
	@Test
	public void verifyPrivacyAndDataUsageLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyPrivacyAndDataUsageLinkInFooterSection","verifyPrivacyAndDataUsageLinkInFooterSection");
		HomePage homePage = new HomePage(driver);
		homePage.clickPrivacyAndDataUsageLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on PrivacyAndDataUsageLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, "https://www.grptalk.com/Privacy");
		logger_ss.log(Status.INFO, "verified Current Url");
		logger_ss.log(Status.INFO, "successfully verified PrivacyAndDataUsageLinkInFooterSection");
	}	
	
	@Test
	public void verifyRequest_A_PriceTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyRequest_A_PriceTabFunctionality","verifyRequest_A_PriceTabFunctionality");
		HomePage homePage = new HomePage(driver);
		String textMessage=homePage.request_A_PriceTabFunctionality();
		Assert.assertTrue(textMessage.contains("Thank you for submitting your details."));
		logger_ss.log(Status.INFO, "clicked on pricing tab and verfied PricingTabFunctionality");
		String url= homePage.pricingTabURL();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertEquals(url, "https://www.grptalk.com/Pricing");
		logger_ss.log(Status.INFO, "verfied current url");
		logger_ss.log(Status.INFO, "Successfully verfied PricingTabFunctionality");
	}
	
	@Test
	public void verifyCopyRightTextInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyCopyRightTextInFooterSection","verifyCopyRightTextInFooterSection");
		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(homePage.copyRightTextInFooterSection(), "COPYRIGHT 2018 GRPTALK BY TELEBU. ALL RIGHTS RESERVED.");
		logger_ss.log(Status.INFO, "get copyRightTextInFooterSection and verified");
		logger_ss.log(Status.INFO, "successfully verified CopyRightTextInFooterSection");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InterruptedException {
		System.out.println("This is after method");
		if (result.getStatus() == ITestResult.FAILURE) {
			String temp = Utility.getScreenshot(driver);
			logger_ss.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		extent.flush();
	//	Utility.handleAlert(driver);
	//	HomePage homePage = new HomePage(driver);
		driver.navigate().to("https://www.grptalk.com/");
		driver.navigate().refresh();
		Thread.sleep(2000);
//		Utility.handleAlert(driver);
//		Thread.sleep(2000);
//		try{
//			if(driver.findElements(By.xpath("//*[@id='date']//label")).size()!=0){
//				crtgrp.closeLiveGroupCallOfRecentlySavedGrpTalkGroup1();
//				System.out.println("successfully hangUp live GrpCall");
//				Thread.sleep(2000);
//				
//			}
//			if(driver.findElements(By.xpath("//*[contains(@grpcallname,'Test153')]")).size()!=0){
//				crtgrp.deleteSavedGrp();
//				System.out.println("successfully deleted saved Grp");
//			}
//			driver.navigate().refresh();
//		}
//		
//		catch(Exception e){
//			System.out.println("Unable to hangUp live GrpCall or unable to delete saved Grps");
//		}
//	}
	}	
}
