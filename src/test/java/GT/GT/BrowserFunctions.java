package GT.GT;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BrowserFunctions {
	public static WebDriver driver;
	ExtentReports extent ;
	ExtentTest logger_ss;
	//public static Logger logger = Logger.getLogger(AudioTest.class);
	String downloadFilepath = "D:\\grpTalk\\TestDataFiles\\downloads\\";
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
		logger_ss.log(Status.INFO, "Chrome Browser Launched Successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://web.grptalk.com/index.aspx?automationKey=914067297230_84939");
		logger_ss.log(Status.INFO, "GrpTalk home page opend successfully");
		Thread.sleep(2000);
	}
	
	@AfterSuite
	public void closeBrowser() {
	driver.quit();
	}

}