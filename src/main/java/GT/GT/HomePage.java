package GT.GT;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserFunctions;

public class HomePage extends BrowserFunctions{
	
	By grpTalkEmail 				= By.xpath("//*[@class='col-sm-6 col-xs-12 hidden-xs']//*[@class='hdrlnkeml']");
	By grpTalkContactNumber 		= By.xpath("//*[@class='col-sm-6 col-xs-9 contctusheads']//*[@class='hdrlnkeml']");
	By grpTalkLogo 					= By.xpath("//*[@alt='grptalk-logo']");
	By featuresTab 					= By.xpath("//*[@class='nav navbar-nav navbar-right']//*[@title='Features']");
	By howItWorksTab 				= By.xpath("//*[@class='nav navbar-nav navbar-right']//*[@title='How grptalk Works']");
	By pricingTab 					= By.xpath("//*[@class='nav navbar-nav navbar-right']//*[@title='Plans and Pricings of grp talk']");
	By customerStoriesTab			= By.xpath("//*[@class='nav navbar-nav navbar-right']//*[@title='Case Study']");
	//By blogTab 						= By.xpath("//*[@class='nav navbar-nav navbar-right']//*[@title='Blog']");
	By webLoginTab 					= By.xpath("//*[@class='nav navbar-nav navbar-right']//*[@class='page-scroll btn-pink']");
	By mobileNumberField 			= By.id("txtNumber");
	By startDemoButton 				= By.id("subscribe-button");
	By beginChatOption 				= By.xpath("//*[@class='_1ZSagdd_Wbj_ZKw0RkZfOn']");
	By typeMessageField 			= By.className("enter-to-send");
	By closeChatOption 				= By.xpath("//*[@class='_2So8ItJQ9P6IqaCUlCO-2f flex-center DISMISS _3S6qOFxcrgO0yM2f9_l6JZ _364Vk0R65B1GXViJwyA9fM']");
	By youtubeVideo 				= By.className("youtube");
	By youTubeVideoBlock 			= By.xpath("//*[@id='543851444']");
	By playButtonForYoutubeVideo 	= By.className("play-button");
	By buttonForYoutubePlayingVideo = By.className("ytp-youtube-button ytp-button yt-uix-sessionlink");
	By blogTab1 					= By.xpath("//*[@class='navbar navbar-default navbar-shrink']//*[@id='bs-example-navbar-collapse-1']//li[5]//*[@id='lnkSolutions']");
	By emailField 					= By.id("txtEmail2");
	By contactSalesButton 			= By.id("btnGetDemo2");
	By appStoreButton 				= By.xpath("//a[1][@class='page-scroll btn btn-primary app-store appDownloadClick']");
	By googlePlayButton 			= By.xpath("//a[2][@class='page-scroll btn btn-primary app-store appDownloadClick']");
	By scanQRCode 					= By.id("scanCode");
	By requestPriceButton 			= By.id("btnGetDemo");
	By scrollUpButton 				= By.className("scroll icon");
	By grpTalkLogoInFooterSection 	= By.id("footerClick");
	By copyRightTextInFooterSection = By.xpath("//*[@class='col-sm-6']");
	By homeLinkInFooterSection 		= By.xpath("//*[@class='mr-xs']//*[@class='f-cont-li-01']//li[1]//a[1]");
	By aboutLinkInFooterSection 	= By.xpath("//*[@class='f-cont-li-01\']/li[2]");
	By howItWorksLinkInFooterSection= By.xpath("//*[@class='f-cont-li-01']//*[@href='/how-it-works']");
	By pricingLinkInFooterSection 	= By.xpath("//*[@class='f-cont-li-01']//*[@href='/Pricing']");
	By featuresLinkInFooterSection 	= By.xpath("//*[@class='col-md-2 col-sm-4 col-xs-12 f-cont-menu clearfix']//*[@title='Features']");
	By webLoginLinkInFooterSection 	= By.xpath("//*[@class='col-md-2 col-sm-3 col-xs-12 f-cont-menu clearfix']//*[@href='https://web.grptalk.com']");
	By customerStoriesLinkInFooterSection = By.xpath("//*[@class='col-md-2 col-sm-3 col-xs-12 f-cont-menu clearfix']//*[@title='Case Study']");
	By blogLinkInFooterSection 		= By.xpath("//*[@class='col-md-2 col-sm-3 col-xs-12 f-cont-menu clearfix']//*[@target='_blank']");
    By nameForPricingPlan 			= By.id("txtName");
    By mobileForPricingPlan 		= By.id("txtMobile");
    By emailForPricingPlan 			= By.id("txtEmail3");
    By sendButtonOnPricingPage 		= By.id("4thSend");
    By textMessageForSubmittedDetailsForPricing = By.xpath("//*[@id='divThankU']//*[@class='text-center']");
	By contactLinkInFooterSection 	= By.xpath("//*[@class='col-md-12 col-xs-12 f-cont-menu']//*[@href='/contact-us']");
	By FAQsLinkInFooterSection 		= By.xpath("//*[@class='col-md-12 col-xs-12 f-cont-menu']//*[@href='/faqs']");
	By TermsAndConditionsLinkInFooterSection = By.xpath("//*[@class='col-md-12 col-xs-12 f-cont-menu']//*[@href='/terms-and-conditions']");
	By PrivacyAndDataUsageLinkInFooterSection = By.xpath("//*[@class='col-md-12 col-xs-12 f-cont-menu']//*[@href='/Privacy']");
	By fbLogoInFooterSection 		= By.xpath("//*[@class='col-sm-5 clearfix text-right']//*[@class='bgSocialIcon fb']");
	By twitterLogoInFooterSection 	= By.xpath("//*[@class='col-sm-5 clearfix text-right']//*[@class='bgSocialIcon twitter']");
	By youtubeLogoInFooterSection 	= By.xpath("//*[@class='col-sm-5 clearfix text-right']//*[@class='bgSocialIcon youtube']");
	By textAboutGrpTalkInFooterSection = By.xpath("//*[@class='col-md-4 col-sm-12 col-xs-12 grp_logo']/p");
	By textOnFeaturesPage 			= By.id("bannerHeading1");
	By textOnHowItWorksPage 		= By.id("bannerHeading1");
	By textOnPricingPage 			= By.id("bannerHeading1");
	By participantsTabOnPricingPage = By.xpath("//*[@class='box g3-5 participants']");
    By conferenceCallsPerMonthTabOnPricingPage = By.xpath("//*[@class='box c5-10 conference']");
    By minutesTabOnPricingPage 		= By.xpath("//*[@class='box t30-45 minutes']");
    By completeButtonOnPricingPage 	= By.id("btnComplete");
    By totalMinutesPerMonthOnPrcingPage = By.className("txtGradient");
    By textOnCustomerStoriesPage 	= By.id("bannerHeading1");
    By textOnBlogPage 				= By.xpath("//*[@id='bannerHeading1']");
    By overlay 						= By.xpath("//*[@class='btn btn-primary app-store']");
    By imgQRCodeOnWebGrpTalkPage 	= By.id("imgQrCode");
    By textDisplayedOnChatBox		= By.className("Linkify");
    By chatFrame 					= By.xpath("//*[@id='drift-widget-container']//*[@id='drift-widget']");
    By chatBox 						= By.xpath("//*[@class='hoverl_6R']");
    By textOnChatBox 				= By.xpath("//*[@id='jcont_content_wrapper']//*[@class='headerBox_2k']//*[@class='agentName_1D __url_ut']");
    By nameFieldOnChat 				= By.xpath("//*[@class='body_2s']//*[@type='text']");
    By phoneFieldOnChat 			= By.xpath("//*[@class='body_2s']//*[@type='tel']");
    By emailFieldOnChat 			= By.xpath("//*[@class='body_2s']//*[@type='email']");
    By messageFieldOnChat 			= By.xpath("//*[@class='body_2s']//*[@class='inputField_G5 _textarea_In']");
    By startCahtButtonOnChatbox 	= By.xpath("//*[@class='body_2s']//*[@class='text_Xc']");
    By sentTextInChat 				= By.xpath("//*[@class='main_2b __client_1w']//*[@class='message_20 _green_Tb']//*[@class='text_14']");
    By closingChatOption 			= By.xpath("//*[@class='closeIcon_1U']");
    
	public void closingChatOption(){
		driver.findElement(closingChatOption).click();
	}
	
	public String startChatByEnteringDetails() throws InterruptedException{
		driver.findElement(nameFieldOnChat).sendKeys("testing");
		driver.findElement(phoneFieldOnChat).sendKeys("914067297230");
		driver.findElement(emailFieldOnChat).sendKeys("srikanth.korada@smscountry.com");
		Thread.sleep(1000);
		driver.findElement(messageFieldOnChat).sendKeys("Hi");
		driver.findElement(startCahtButtonOnChatbox).click();
		Thread.sleep(1000);
		return driver.findElement(sentTextInChat).getText();
	}
	
	public void clickChatOption() throws InterruptedException{
		driver.findElement(chatBox).click();
		Thread.sleep(2000);
	}
	
	public String textOnChatBox(){
		return driver.findElement(textOnChatBox).getText();
	}
	
	public boolean visibilityOfChatMessageField(){
		return driver.findElement(typeMessageField).isDisplayed();
	}
	
	
	public void clickPlayStoreTab(){
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(googlePlayButton));
 		actions.perform();
		driver.findElement(googlePlayButton).click();
	}
	
	public void clickAppStoreTab() throws InterruptedException{
		Thread.sleep(1000);
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(appStoreButton));
 		actions.perform();
		driver.findElement(appStoreButton).click();
	}
	
	public void clickBeginChatOption(){
		driver.switchTo().frame("drift-widget");
		driver.findElement(beginChatOption).click();
	}
	
	public boolean visibilityOfMessageFieldInChat(){
		return driver.findElement(typeMessageField).isDisplayed();
	}
	
	public boolean visibilityOfChatOption(){
		return driver.findElement(beginChatOption).isDisplayed();
	}
	
	public void clickCloseChatOption(){
		driver.findElement(closeChatOption).click();
	}
	
	public String textDisplayedOnChatBox(){
		return driver.findElement(textDisplayedOnChatBox).getText();
	}
	
	public void clickAboutLinkInFooterSection(){
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(aboutLinkInFooterSection));
 		actions.perform();
		driver.findElement(aboutLinkInFooterSection).click();
	}
	
	public void clickHowItWorksLinkInFooterSection(){
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(howItWorksLinkInFooterSection));
 		actions.perform();
		driver.findElement(howItWorksLinkInFooterSection).click();
	}
	
	public void clickPricingLinkInFooterSection(){
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(pricingLinkInFooterSection));
 		actions.perform();
		driver.findElement(pricingLinkInFooterSection).click();
	}
	
	public void clickFeaturesLinkInFooterSection(){
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(featuresLinkInFooterSection));
 		actions.perform();
		driver.findElement(featuresLinkInFooterSection).click();
	}
	
	public void clickWebLoginLinkInFooterSection(){
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(webLoginLinkInFooterSection));
 		actions.perform();
		driver.findElement(webLoginLinkInFooterSection).click();
	}
	
	public void clickCustomerStoriesLinkInFooterSection(){
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(customerStoriesLinkInFooterSection));
 		actions.perform();
		driver.findElement(customerStoriesLinkInFooterSection).click();
	}
	
	public void clickContactLinkInFooterSection(){
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(contactLinkInFooterSection));
 		actions.perform();
		driver.findElement(contactLinkInFooterSection).click();
	}
	
	public void click_FAQ_LinkInFooterSection(){
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(FAQsLinkInFooterSection));
 		actions.perform();
		driver.findElement(FAQsLinkInFooterSection).click();
	}
	
	public void clickTermsAndConditionsLinkInFooterSection(){
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(TermsAndConditionsLinkInFooterSection));
 		actions.perform();
		driver.findElement(TermsAndConditionsLinkInFooterSection).click();
	}
	
	public void clickPrivacyAndDataUsageLinkInFooterSection(){
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(PrivacyAndDataUsageLinkInFooterSection));
 		actions.perform();
		driver.findElement(PrivacyAndDataUsageLinkInFooterSection).click();
	}
	
	public void clickBlogLinkInFooterSection() throws InterruptedException{
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(blogLinkInFooterSection));
 		actions.perform();
		driver.findElement(blogLinkInFooterSection).click();
		Thread.sleep(3000);
	}
	
	
	public void clickFacebookLogoInFooterSection() throws InterruptedException{
		
		Actions actions=new Actions(driver);
 		//actions.moveToElement(driver.findElement(fbLogoInFooterSection));
 		//actions.perform();
 		//actions.moveToElement(driver.findElement(chatBox));
 		//actions.perform();
 		//driver.findElement(chatBox).click();
 		actions.moveToElement(driver.findElement(fbLogoInFooterSection)).perform();
 		driver.findElement(fbLogoInFooterSection).click();
		Thread.sleep(3000);
	}
	
	public void clickTwitterLogoInFooterSection() throws InterruptedException{
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(twitterLogoInFooterSection));
 		actions.perform();
		driver.findElement(twitterLogoInFooterSection).click();
		Thread.sleep(3000);
	}
	
	public void clickYoutubeLogoInFooterSection() throws InterruptedException{
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(youtubeLogoInFooterSection));
 		actions.perform();
		driver.findElement(youtubeLogoInFooterSection).click();
		Thread.sleep(3000);
	}
	
	public void clickHomeLinkInFooterSection(){
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(homeLinkInFooterSection));
 		actions.perform();
		driver.findElement(homeLinkInFooterSection).click();
	}
	
	public String copyRightTextInFooterSection(){
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(copyRightTextInFooterSection));
 		actions.perform();
		return driver.findElement(copyRightTextInFooterSection).getText();
	}
	
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(historyButtonOnMyGrpTalks));
	
	public Boolean visibilityOfGrpTalkLogo(){
		return driver.findElement(grpTalkLogo).isDisplayed();
	}
	
	public Boolean visibilityOfGrpTalkEmail(){
		return driver.findElement(grpTalkEmail).isDisplayed();
	}
	
	public String grpTalkEmail(){
		return driver.findElement(grpTalkEmail).getText();
	}
	
	public String grpTalkContactNumber(){
		return driver.findElement(grpTalkContactNumber).getText();
	}
	
	public Boolean visibilityOfGrpTalkContactNumber(){
		return driver.findElement(grpTalkContactNumber).isDisplayed();
	}
	
	public void clickGrpTalkContactNumber() throws InterruptedException{
		driver.findElement(grpTalkContactNumber).click();
		Thread.sleep(30000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(10000);
	}
	
	public String featuresTabFunctionality(){
		WebDriverWait wait=new WebDriverWait(driver, 5);
		driver.findElement(featuresTab).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(textOnFeaturesPage,"Focus On Your Conference Calls"));
		return driver.getCurrentUrl();
		
	}
	
	public String howItWorksTabFunctionality(){
		WebDriverWait wait=new WebDriverWait(driver, 5);
		driver.findElement(howItWorksTab).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(textOnHowItWorksPage,"How grptalk works?"));
		return driver.getCurrentUrl();
		
	}
	
	public String pricingTabFunctionality() throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver, 5);
		driver.findElement(pricingTab).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(textOnPricingPage,"Find a conference call plan that's right for you"));
		driver.findElement(participantsTabOnPricingPage).click();
		driver.findElement(conferenceCallsPerMonthTabOnPricingPage).click();
		driver.findElement(minutesTabOnPricingPage).click();
		driver.findElement(completeButtonOnPricingPage).click();
		driver.findElement(nameForPricingPlan).sendKeys("Testing");
		driver.findElement(mobileForPricingPlan).sendKeys("914067297230");
		driver.findElement(emailForPricingPlan).sendKeys("srikanth.korada@smscountry.com");
		driver.findElement(sendButtonOnPricingPage).click();
		Thread.sleep(1000);
		return driver.findElement(textMessageForSubmittedDetailsForPricing).getText();
	}
	
	public String request_A_PriceTabFunctionality() throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver, 5);
		driver.findElement(requestPriceButton).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(textOnPricingPage,"Find a conference call plan that's right for you"));
		driver.findElement(participantsTabOnPricingPage).click();
		driver.findElement(conferenceCallsPerMonthTabOnPricingPage).click();
		driver.findElement(minutesTabOnPricingPage).click();
		driver.findElement(completeButtonOnPricingPage).click();
		driver.findElement(nameForPricingPlan).sendKeys("Testing");
		driver.findElement(mobileForPricingPlan).sendKeys("914067297230");
		driver.findElement(emailForPricingPlan).sendKeys("srikanth.korada@smscountry.com");
		driver.findElement(sendButtonOnPricingPage).click();
		Thread.sleep(1000);
		return driver.findElement(textMessageForSubmittedDetailsForPricing).getText();
	}
	
	public String pricingTabURL(){
		return driver.getCurrentUrl();
	}
	
	public String customerStoriesTabFunctionality(){
		WebDriverWait wait=new WebDriverWait(driver, 5);
		driver.findElement(customerStoriesTab).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(textOnCustomerStoriesPage,"Here’s How We Simplify Audio Conferencing"));
		return driver.getCurrentUrl();
	}
	
	public String solutionsTabFunctionality() throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver, 5);
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(blogTab1));
		actions.perform();
		driver.findElement(blogTab1).click();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(textOnBlogPage));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(textOnBlogPage,"Audio Conferencing Solutions"));
		return driver.getCurrentUrl();
	}
	
	
	public void clickStartDemoTab() throws InterruptedException{
		driver.findElement(startDemoButton).click();
		Thread.sleep(1000);
		
	}
	public void clickOkButtonOnOverlay() throws InterruptedException{
		driver.findElement(overlay).click();
		Thread.sleep(1000);
	}
	
	public void clickContactSalesTab() throws InterruptedException{
		driver.findElement(contactSalesButton).click();
		Thread.sleep(1000);
	}
	
	public void acceptAlert(){
		driver.switchTo().alert().accept();
	}
	
	public void enterMobileNumber(){
		driver.findElement(mobileNumberField).sendKeys("4038119607");
	}
	
	public void enterEmail(){
		driver.findElement(emailField).sendKeys("srikanth42k@gmail.com");
	}
	
	public boolean visibiltyOfStartDemoTab() throws InterruptedException{
		return driver.findElement(startDemoButton).isDisplayed();
	}
	
	public boolean visibiltyOfcontactSalesTab() throws InterruptedException{
		return driver.findElement(contactSalesButton).isDisplayed();
	}
	
	
	By successMsgOnAlert = By.id("alertMsg");
	
	public String succesMsgOnAlert(){
		return driver.findElement(successMsgOnAlert).getText();
	}
	
	public String getAlertText(){
		return driver.switchTo().alert().getText();
	}
	
	public String getAlertTextForEmail(){
		return driver.switchTo().alert().getText();
	}
	
	public void  clickWebLoginTab(){
		driver.findElement(webLoginTab).click();
	}
	
	public void switchToNewTab() throws InterruptedException{
		Set<String> AllwindowHandles=driver.getWindowHandles();
		String w1=(String) AllwindowHandles.toArray()[0];
		String w2=(String) AllwindowHandles.toArray()[1];
		driver.switchTo().window(w2);
		System.out.println(w2);

		Thread.sleep(2000);
	}
	
	public boolean visibilityOfImgQRCode(){
		return driver.findElement(imgQRCodeOnWebGrpTalkPage).isDisplayed();
	}
	
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	public void switchToDefaultTab() throws InterruptedException{
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	}
	
	public void closeCurrentTab(){
		driver.close();
	}
	
	public void clickPlayButtonForYoutubeVideo() throws InterruptedException{
		Actions actions=new Actions(driver);
 		actions.moveToElement(driver.findElement(playButtonForYoutubeVideo));
 		actions.perform();
		driver.findElement(playButtonForYoutubeVideo).click();
		Thread.sleep(3000);
	}
	
	public boolean visibilityOfYoutubeVideo(){
		return driver.findElement(youTubeVideoBlock).isDisplayed();
	}
	
	public void clickScanQRCodeTab(){
		driver.findElement(scanQRCode).click();
	}
}














