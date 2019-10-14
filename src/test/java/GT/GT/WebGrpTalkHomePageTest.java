package GT.GT;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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

public class WebGrpTalkHomePageTest extends BrowserFunctions{
	public static Logger logger = Logger.getLogger(WebGrpTalkHomePageTest.class);
	
	@BeforeClass
	public void beforeCalss(){
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("GrpTalk_Report_Of_WebHomePage.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger_ss = extent.createTest("GrpTalkWebHomePageTest");
		logger_ss.log(Status.INFO, "GrpTalkWebHomePageTest");
	}
	
	@Test
	public void verifyVisibilityOfImgQRCodeOnWebGrpTalkPage(){
		logger_ss = extent.createTest("verifyVisibilityOfImgQRCodeOnWebGrpTalkPage","verifyVisibilityOfImgQRCodeOnWebGrpTalkPage");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		Assert.assertTrue(homePage.visibilityOfImgQRCode());
		logger_ss.log(Status.INFO, "Successfully verfied visibilityOfImgQRCode");
	}
	
	@Test
	public void verifyGrpTalkEmailAndContactDisplayedInHeaderScetion(){
		logger_ss = extent.createTest("verifyGrpTalkEmailAndContactDisplayedInHeaderScetion","verifyGrpTalkEmailAndContactDisplayedInHeaderScetion");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		Assert.assertTrue(homePage.visibilityOfGrpTalkEmail());
		logger_ss.log(Status.INFO, "Successfully verfied visibilityOfGrpTalkEmail");
		Assert.assertTrue(homePage.visibilityOfGrpTalkContactNumber());
		logger_ss.log(Status.INFO, "Successfully verfied visibilityOfGrpTalkContactNumber");
		Assert.assertEquals(homePage.grpTalkEmail(), "hello@grptalk.com");
		logger_ss.log(Status.INFO, "Successfully verfied GrpTalkEmail");
		Assert.assertEquals(homePage.grpTalkContactNumber(), "+91-40-47475544");
		logger_ss.log(Status.INFO, "Successfully verfied GrpTalkContact");
		logger_ss.log(Status.INFO, "Successfully verfied GrpTalkEmailAndContactDisplayedInHeaderScetion");
	}
	
	@Test
	public void verifyPlayStoreTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyPlayStoreTabFunctionality","verifyPlayStoreTabFunctionality");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickPlayStoreTab();
		logger_ss.log(Status.INFO, "clicked on PlayStoreTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get Current Url");
		Assert.assertEquals(url, "https://play.google.com/store/apps/details?id=com.mobile.android.grptalk");
		logger_ss.log(Status.INFO, "verfied current url");
		logger_ss.log(Status.INFO, "Successfully verfied PlayStoreTabFunctionality");
	}
	
	@Test
	public void verifyGrpTalkLogoFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyGrpTalkLogoFunctionality","verifyGrpTalkLogoFunctionality");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		Thread.sleep(5000);
		homePage.clickGrpTalkLogo();
		logger_ss.log(Status.INFO, "Clicked on grpTalk logo");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get Current Url");
		Assert.assertEquals(url, "http://staging.grptalk.com/");
		logger_ss.log(Status.INFO, "verfied current url");
		logger_ss.log(Status.INFO, "Successfully verfied GrpTalkLogoFunctionality");
	}
	
	@Test
	public void verifyAppStoreTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyAppStoreTabFunctionality","verifyAppStoreTabFunctionality");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickAppStoreTab();
		logger_ss.log(Status.INFO, "Clicked on AppStoreTab");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get Current Url");
		Assert.assertEquals(url, "https://apps.apple.com/in/app/grptalk/id1074172134?ls=1");
		logger_ss.log(Status.INFO, "verfied current url");
		logger_ss.log(Status.INFO, "Successfully verfied AppStoreTabFunctionality");
	}
	
	@Test
	public void verifyFeaturesTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyFeaturesTabFunctionality","verifyFeaturesTabFunctionality");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		String url=homePage.featuresTabFunctionality();
		logger_ss.log(Status.INFO, "clicked on features tab and get current url");
		Assert.assertEquals(url, currentUrl+"/Features");
		logger_ss.log(Status.INFO, "verfied current url");
		logger_ss.log(Status.INFO, "Successfully verfied AppStoreTabFunctionality");
	}
	
	@Test
	public void verifyHowItWorksTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyFeaturesTabFunctionality","verifyFeaturesTabFunctionality");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		String url=homePage.howItWorksTabFunctionality();
		logger_ss.log(Status.INFO, "clicked on howItWorks tab and get current url");
		Assert.assertEquals(url, currentUrl+"/how-it-works");
		logger_ss.log(Status.INFO, "verfied current url");
		logger_ss.log(Status.INFO, "Successfully verfied HowItWorksTabFunctionality");
	}
	
	@Test
	public void verifyPricingTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyPricingTabFunctionality","verifyPricingTabFunctionality");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
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
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		String url=homePage.customerStoriesTabFunctionality();
		logger_ss.log(Status.INFO, "clicked on customerStories tab and get current url");
		Assert.assertEquals(url, currentUrl+"/Customer-Stories");
		logger_ss.log(Status.INFO, "verfied current url");
		logger_ss.log(Status.INFO, "Successfully verfied customerStoriesTabFunctionality");
	}
	
	@Test
	public void verifySolutionsTabFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifySolutionsTabFunctionality","verifySolutionsTabFunctionality");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		driver.navigate().refresh();
		String url=homePage.sloutionsTabFunctionality();
		logger_ss.log(Status.INFO, "clicked on solutions tab and get current url");
		Assert.assertEquals(url, currentUrl+"/Solutions.aspx");
		logger_ss.log(Status.INFO, "verfied current url");
		logger_ss.log(Status.INFO, "Successfully verfied Solutions Tab Functionality");

	}
	
	@Test
	public void verifyWebLoginFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyWebLoginFunctionality","verifyWebLoginFunctionality");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickWebLoginTab();
		logger_ss.log(Status.INFO, "clicked on WebLoginTab");
		//homePage.switchToNewTab();
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get current url");
		Assert.assertTrue(homePage.visibilityOfImgQRCode());
		logger_ss.log(Status.INFO, "verified visibilityOfImgQRCode");
		Assert.assertEquals(url, "https://web.grptalk.com/");
		logger_ss.log(Status.INFO, "verfied current url");
		logger_ss.log(Status.INFO, "Successfully verfied WebLoginFunctionality");
		//homePage.closeCurrentTab();
		//homePage.switchToDefaultTab();
		//Assert.assertEquals(homePage.getCurrentUrl(), "https://web.grptalk.com/");
	}
	
	@Test
	public void verifyContactSalesButtonFunctionality() throws InterruptedException{
		logger_ss = extent.createTest("verifyContactSalesButtonFunctionality","verifyContactSalesButtonFunctionality");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickContactSalesTab();
		logger_ss.log(Status.INFO, "clicked on ContactSalesTab with out enter email");
//		Assert.assertEquals(homePage.getAlertTextForEmail(), "Please Enter Your Email");
//		logger_ss.log(Status.INFO, "verified AlertTextForEmail");
//		homePage.acceptAlert();
//		logger_ss.log(Status.INFO, "accepted the Alert");
		homePage.enterEmail();
		logger_ss.log(Status.INFO, "entered email");
		homePage.clickContactSalesTab();
		logger_ss.log(Status.INFO, "clicked on ContactSalesTab");
		Assert.assertEquals(homePage.succesMsgOnAlert(), "Thanks for your interest in grptalk. Our team will get in touch with you shortly.");
		logger_ss.log(Status.INFO, "verified succesMsgOnAlert");
		homePage.clickOkButtonOnOverlay();
		logger_ss.log(Status.INFO, "clicked on OkButtonOnOverlay");
		Assert.assertTrue(homePage.visibiltyOfcontactSalesTab());
		logger_ss.log(Status.INFO, "verified visibiltyOfcontactSalesTab");
		logger_ss.log(Status.INFO, "Successfully verfied ContactSalesButtonFunctionality");
	}
	
	@Test
	public void verifyHomeLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyHomeLinkInFooterSection","verifyHomeLinkInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickHomeLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on HomeLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "getCurrentUrl");
		Assert.assertEquals(url, currentUrl+"/");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified HomeLinkInFooterSection");
	}
	
	@Test
	public void verifyAboutLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyAboutLinkInFooterSection","verifyAboutLinkInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickAboutLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on AboutLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, currentUrl+"/About-us");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified AboutLinkInFooterSection");
	}
	
	@Test
	public void verifyHowItWorksLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyHowItWorksLinkInFooterSection","verifyHowItWorksLinkInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickHowItWorksLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on HowItWorksLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, currentUrl+"/how-it-works");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified HowItWorksLinkInFooterSection");
	}
	
	@Test
	public void verifyPricingLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyPricingLinkInFooterSection","verifyPricingLinkInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickPricingLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on PricingLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, currentUrl+"/Pricing");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified PricingLinkInFooterSection");
	}
	
	@Test
	public void verifyFeaturesLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyFeaturesLinkInFooterSection","verifyFeaturesLinkInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickFeaturesLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on FeaturesLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, currentUrl+"/Features");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified FeaturesLinkInFooterSection");
	}
	
	@Test
	public void verifyWebLoginLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyWebLoginLinkInFooterSection","verifyWebLoginLinkInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickWebLoginLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on WebLoginLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, "https://web.grptalk.com/");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified WebLoginLinkInFooterSection");
	}
	
	@Test
	public void verifyCustomerStoriesLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyCustomerStoriesLinkInFooterSection","verifyCustomerStoriesLinkInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickCustomerStoriesLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on CustomerStoriesLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, currentUrl+"/Customer-Stories");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified CustomerStoriesLinkInFooterSection");
	}
	
	@Test
	public void verifyBlogLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyBlogLinkInFooterSection","verifyBlogLinkInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		String loginWeburl = currentUrl+"/login";
		homePage.clickBlogLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on BlogLinkInFooterSection");
		homePage.switchToNewTab();
		logger_ss.log(Status.INFO, "switched to new window");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, "https://www.grptalk.com/blog/");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		homePage.closeCurrentTab();
		logger_ss.log(Status.INFO, "closed current tab");
		homePage.switchToDefaultTab();
		logger_ss.log(Status.INFO, "switched to default window");
		String grpTalkURL=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(grpTalkURL, loginWeburl);
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified BlogLinkInFooterSection");
	}
	
	@Test
	public void verifyFunctionalityOfFacebookLogoInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyFunctionalityOfFacebookLogoInFooterSection","verifyFunctionalityOfFacebookLogoInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		String loginWeburl = currentUrl+"/login";
		homePage.clickFacebookLogoInFooterSection();
		logger_ss.log(Status.INFO, "clicked on FacebookLogoInFooterSection");
		homePage.switchToNewTab();
		logger_ss.log(Status.INFO, "switched to new window");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, "https://www.facebook.com/grptalkconferencing/");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		homePage.closeCurrentTab();
		logger_ss.log(Status.INFO, "closed current tab");
		homePage.switchToDefaultTab();
		logger_ss.log(Status.INFO, "switched to default window");
		String grpTalkURL=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(grpTalkURL, loginWeburl);
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified FunctionalityOfFacebookLogoInFooterSection");
	}
	
	@Test
	public void verifyFunctionalityOfTwitterLogoInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyFunctionalityOfTwitterLogoInFooterSection","verifyFunctionalityOfTwitterLogoInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		String loginWeburl = currentUrl+"/login";
		homePage.clickTwitterLogoInFooterSection();
		logger_ss.log(Status.INFO, "clicked on TwitterLogoInFooterSection");
		homePage.switchToNewTab();
		logger_ss.log(Status.INFO, "switched to new window");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, "https://twitter.com/grptalk");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		homePage.closeCurrentTab();
		logger_ss.log(Status.INFO, "closed current tab");
		homePage.switchToDefaultTab();
		logger_ss.log(Status.INFO, "switched to default window");
		String grpTalkURL=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(grpTalkURL, loginWeburl);
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified FunctionalityOf TwitterLogoInFooterSection");
	}
	
	@Test
	public void verifyFunctionalityOfYoutubeLogoInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyFunctionalityOfYoutubeLogoInFooterSection","verifyFunctionalityOfYoutubeLogoInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		String loginWeburl = currentUrl+"/login";
		homePage.clickYoutubeLogoInFooterSection();
		logger_ss.log(Status.INFO, "clicked on YoutubeLogoInFooterSection");
		homePage.switchToNewTab();
		logger_ss.log(Status.INFO, "switched to new window");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, "https://www.youtube.com/channel/UC1hgEdzMlNtp9P4cl_hR0zQ");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		homePage.closeCurrentTab();
		logger_ss.log(Status.INFO, "closed current tab");
		homePage.switchToDefaultTab();
		logger_ss.log(Status.INFO, "switched to default window");
		String grpTalkURL=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(grpTalkURL, loginWeburl);
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified FunctionalityOfYoutubeLogoInFooterSection");
	}
	
	@Test
	public void verifyContactLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyContactLinkInFooterSection","verifyContactLinkInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickContactLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on ContactLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, currentUrl+"/Contact-us");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified ContactLinkInFooterSection");
	}
	
		
	@Test
	public void verify_FAQ_LinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verify_FAQ_LinkInFooterSection","verify_FAQ_LinkInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.click_FAQ_LinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on FAQ LinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, currentUrl+"/faqs");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified FAQ LinkInFooterSection");
	}	
	
	@Test
	public void verifyTermsAndConditionsLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyTermsAndConditionsLinkInFooterSection","verifyTermsAndConditionsLinkInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickTermsAndConditionsLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on TermsAndConditionsLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, currentUrl+"/terms-and-conditions");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified TermsAndConditionsLinkInFooterSection");
	}	
	
	@Test
	public void verifyPrivacyAndDataUsageLinkInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyPrivacyAndDataUsageLinkInFooterSection","verifyPrivacyAndDataUsageLinkInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		homePage.clickPrivacyAndDataUsageLinkInFooterSection();
		logger_ss.log(Status.INFO, "clicked on PrivacyAndDataUsageLinkInFooterSection");
		String url=homePage.getCurrentUrl();
		logger_ss.log(Status.INFO, "get CurrentUrl");
		Assert.assertEquals(url, currentUrl+"/Privacy");
		logger_ss.log(Status.INFO, "verified CurrentUrl");
		logger_ss.log(Status.INFO, "Successfully verified PrivacyAndDataUsageLinkInFooterSection");
	}	
	
	@Test
	public void verifyCopyRightTextInFooterSection() throws InterruptedException{
		logger_ss = extent.createTest("verifyCopyRightTextInFooterSection","verifyCopyRightTextInFooterSection");
		WebGrpTalkHomePage homePage = new WebGrpTalkHomePage();
		Assert.assertEquals(homePage.copyRightTextInFooterSection(), "COPYRIGHT 2018 GRPTALK BY TELEBU. ALL RIGHTS RESERVED.");
		logger_ss.log(Status.INFO, "get copyRightTextInFooterSection and compared");
		logger_ss.log(Status.INFO, "Successfully verified CopyRightTextInFooterSection");
	}
}
