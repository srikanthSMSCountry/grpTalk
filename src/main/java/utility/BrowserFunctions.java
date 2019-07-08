package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import GT.GT.*;
import utility.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BrowserFunctions {
	public static WebDriver driver;
	public static ExtentReports extent ;
	public static ExtentTest logger_ss;
	public String grpTalksPage = "";
	public static String currentUrl = "";
	@BeforeTest
	@Parameters({"browser","url"})
	public void setup(@Optional("IamBrowser") String browser, @Optional("IamUrl") String url) throws Exception{
		grpTalksPage = url;
		if(browser.equalsIgnoreCase("firefox")){
			ExtentHtmlReporter reporter = new ExtentHtmlReporter("GrpTalk_Report_On_Firefox.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			logger_ss = extent.createTest("FireFox Test");
			System.setProperty("webdriver.gecko.driver",CommonMethods.passingData("driverLocation")+"geckodriver.exe");
			driver = new FirefoxDriver();
			logger_ss.log(Status.INFO, "Firefox Browser Launched");
		}
		
		else if(browser.equalsIgnoreCase("chrome")){
			ExtentHtmlReporter reporter = new ExtentHtmlReporter("GrpTalk_Report_On_Chrome.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			logger_ss = extent.createTest("Chrome Test");
			System.setProperty("webdriver.chrome.driver",CommonMethods.passingData("driverLocation")+"chromedriver.exe");
			driver = new ChromeDriver();
			logger_ss.log(Status.INFO, "Chrome Browser Launched");
		}
		
		else if(browser.equalsIgnoreCase("Edge")){
			ExtentHtmlReporter reporter = new ExtentHtmlReporter("GrpTalk_Report_On_Edge.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			logger_ss = extent.createTest("Edge Test");
			System.setProperty("webdriver.edge.driver",CommonMethods.passingData("driverLocation")+"MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			logger_ss.log(Status.INFO, "Edge Browser Launched");
		}
		else{
			//throw new Exception("Browser is not correct");
			ExtentHtmlReporter reporter = new ExtentHtmlReporter("GrpTalk_Report_On_Chrome.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			logger_ss = extent.createTest("Chrome Test");
			System.setProperty("webdriver.chrome.driver",CommonMethods.passingData("driverLocation")+"chromedriver.exe");
			driver = new ChromeDriver();
			logger_ss.log(Status.INFO, "Chrome Browser Launched");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    switch(url){  
	        case "stagingUrl":  
	        	driver.get(CommonMethods.passingData("stagingUrl"));
	    		logger_ss.log(Status.INFO, "Staging GrpTalk home page opend");
	    		currentUrl = CommonMethods.passingData("stagingUrl");
	    		Thread.sleep(10000); 
	            break;  
	        case "productionUrl":  
	        	driver.get(CommonMethods.passingData("productionUrl"));
	    		logger_ss.log(Status.INFO, "Production GrpTalk home page opend");
	    		currentUrl = CommonMethods.passingData("productionUrl");
	    		Thread.sleep(10000);
	            break;  
	        case "localUrl":  
	        	driver.get(CommonMethods.passingData("localUrl"));
	    		logger_ss.log(Status.INFO, "Local GrpTalk home page opend");
	    		currentUrl = CommonMethods.passingData("localUrl");
	    		Thread.sleep(10000);
	            break;
	        case "stagingHomePage":  
	        	driver.get(CommonMethods.passingData("stagingHomePage"));
	        	logger_ss.log(Status.INFO, "stagingHomePage opend");
	        	currentUrl = CommonMethods.passingData("stagingHomePage");
	    		Thread.sleep(10000); 
	            break;
	        case "stagingWebHomePage":  
	        	driver.get(CommonMethods.passingData("stagingHomePage")+"/login");
	        	logger_ss.log(Status.INFO, "stagingWebHomePage opend");
	        	currentUrl = CommonMethods.passingData("stagingHomePage");
	    		Thread.sleep(10000); 
	            break;
	        case "productionWebHomePage":  
	        	driver.get(CommonMethods.passingData("productionWebHomePage"));
	        	logger_ss.log(Status.INFO, "productionWebHomePage opend");
	        	currentUrl = CommonMethods.passingData("productionWebHomePage");
	    		Thread.sleep(10000); 
	            break;
	        case "productionHomePage":  
	        	driver.get(CommonMethods.passingData("productionHomePage"));
	        	logger_ss.log(Status.INFO, "productionHomePage opend");
	        	currentUrl = CommonMethods.passingData("productionHomePage");
	    		Thread.sleep(10000); 
	            break;
	        case "localWebHomePage":  
	        	driver.get(CommonMethods.passingData("loacalHomePage")+"/login");
	        	logger_ss.log(Status.INFO, "localWebHomePage opend");
	        	currentUrl = CommonMethods.passingData("loacalHomePage");
	    		Thread.sleep(10000); 
	            break;
	        case "loacalHomePage":  
	        	driver.get(CommonMethods.passingData("loacalHomePage"));
	        	logger_ss.log(Status.INFO, "loacalHomePage opend");
	        	currentUrl = CommonMethods.passingData("loacalHomePage");
	    		Thread.sleep(10000); 
	            break;
	           
	        default :  
	        	driver.get(CommonMethods.passingData("stagingUrl"));
	    		logger_ss.log(Status.INFO, "Staging GrpTalk home page opend");
	    		currentUrl = CommonMethods.passingData("stagingUrl");
	    		Thread.sleep(10000);
	            break;
	    }  
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InterruptedException {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("TestCase failed");
			String temp = CommonMethods.getScreenshot();
			logger_ss.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}else{
			System.out.println("TestCase passed");
		}
		extent.flush();
		CommonMethods.handleAlert();
		GrpTalks grpTalks = new GrpTalks();
		navigateToGrpTalksPage();
		CommonMethods.handleAlert();

		try{
			if(driver.findElements(By.xpath("//*[@id='date']//label")).size()!=0){
				grpTalks.closeLiveGroupCallOfRecentlySavedGrpTalkGroup1();
				navigateToGrpTalksPage();
			}
			if(driver.findElements(By.xpath("//*[contains(@grpcallname,'Test_')]")).size()!=0){
				grpTalks.deleteSavedGrp();
				navigateToGrpTalksPage();
				Thread.sleep(1000);
			}
		}
		catch(Exception e){
			//System.out.println("Unable to hangUp live GrpCall or unable to delete saved Grps");
		}
	}
	
	public void navigateToGrpTalksPage(){
	    switch(grpTalksPage){  
        	case "stagingUrl":
        		driver.navigate().to(CommonMethods.passingData("stagingGrpTalksPage"));
        		break;  
        	case "productionUrl":
        		driver.navigate().to(CommonMethods.passingData("productionGrpTalksPage"));
        		break;  
        	case "localUrl": 
        		driver.navigate().to(CommonMethods.passingData("localGrpTalksPage"));
        		break;
	        case "stagingHomePage":  
	        	driver.navigate().to(CommonMethods.passingData("stagingHomePage"));
	            break;
	        case "stagingWebHomePage":  
	        	driver.navigate().to(CommonMethods.passingData("stagingWebHomePage"));
	            break;
	        case "productionWebHomePage":  
	        	driver.navigate().to(CommonMethods.passingData("productionWebHomePage"));
	            break;
	        case "productionHomePage":  
	        	driver.navigate().to(CommonMethods.passingData("productionHomePage"));
	            break;
	        case "localWebHomePage":  
	        	driver.navigate().to(CommonMethods.passingData("localWebHomePage"));
	            break;
	        case "loacalHomePage":  
	        	driver.navigate().to(CommonMethods.passingData("loacalHomePage"));
	            break;
        	default:
        		driver.navigate().to(CommonMethods.passingData("stagingGrpTalksPage"));
        		break;
	    }  
	}
	
	@AfterTest
	@Parameters("browser")
	public void closeBrowser1(@Optional("IamOptional") String browser) throws Exception {
			driver.quit();
	}
}