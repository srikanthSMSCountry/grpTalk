package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.apache.commons.io.FileUtils;
import utility.BrowserFunctions;

public class CommonMethods extends BrowserFunctions {

	static String text;
	private static final ExpectedCondition<Alert> TRUE = null;

	public static void clickMethod(By loactor) {
		driver.findElement(loactor).click();
	}

	public static String getTextMethod(By loactor) {
		return driver.findElement(loactor).getText();
	}

	public static boolean isDisplayedMethod(By loactor) throws InterruptedException {
		Thread.sleep(1000);
		explicitWaitForElementVisibility(loactor);
		return driver.findElement(loactor).isDisplayed();
	}

	public static void sendKeysMethod(By loactor, String text) {
		driver.findElement(loactor).sendKeys(passingData(text));
	}

	public static void handleAlert() throws InterruptedException {
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			Thread.sleep(1000);
			alert.accept();
			Thread.sleep(2000);
			driver.navigate().to(CommonMethods.passingData("homePageUrl"));
		}
	}

	public static boolean elementExistsOrNot(By loactor) throws InterruptedException {
		boolean exists = false;
		int threadCount = 0;
		while (threadCount < 5) {
//			try {
//					driver.findElement(loactor);
//					System.out.println("found the locator");
//					exists = true;
//					break;	
//				
//			} catch (Exception e) {
//				System.out.println("Got Exception");
//				e.printStackTrace();
//				Thread.sleep(1000);
//				exists = false;
//				threadCount++;	
//			}
			if(driver.findElement(loactor).isDisplayed()){
				exists = true;
				break;	
			}else{
				Thread.sleep(1000);
				exists = false;
			}
			threadCount++;
		}
		return exists;
	}
//	public static boolean elementExistsOrNot(WebElement element) throws InterruptedException {
//		boolean exists = false;
//		int threadCount = 0;
//		while (threadCount < 5) {
//			try {
//				WebElement ele = driver.findElement(element);
//				exists = true;
//				break;
//			} catch (Exception e) {
//				Thread.sleep(1000);
//				exists = false;
//				threadCount++;
//			}
//		}
//		return exists;
//	}

//	public boolean elementValueChangedOrNot(By loactor) throws InterruptedException {
//	boolean exists = false;
//	int threadCount =0;
//	while(threadCount<5) {
//		try {
//			String ele = driver.findElement(loactor).getText();
//			int i = Integer.parseInt(ele.replaceAll("[^0-9]", ""));
//			if(i!=)
//			exists = true;
//			break;
//		} catch (Exception e) {
//			Thread.sleep(1000);
//			exists = false;
//			threadCount++;
//		}
//	}
//	return exists;
//}

	// public boolean elementExistsOrNot(int seconds, int counter, String xpath)
	// throws InterruptedException {
	// boolean exists = false;
	//
	// while(!exists && counter != 0) {
	// try {
	// exists = By.xpath(xpath). != null;
	// } catch (Throwable t) {
	// Thread.sleep(seconds * 1000);
	// counter--;
	// }
	// }
	// return exists;
	//
	// }

	public static boolean verifyText(By loactor, String text) {
		if (driver.findElement(loactor).getText().toLowerCase().contains(text.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isAlertPresent() throws InterruptedException {
		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (TimeoutException eTO) {
			foundAlert = false;
		}
		return foundAlert;
	}

	public static void explicitWaitForElementVisibility(By locator) {
		By element = locator;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public static void explicitWaitForClickableElement(WebDriver driver, WebElement ele) {
		WebElement element = ele;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void explicitWaitForAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static String passingData(String text) {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();
		try {
			Object object = parser.parse(new FileReader(userDirectory + "\\src\\main\\java\\utility\\TestData.json"));
			jsonObject = (JSONObject) object;
			text = (String) jsonObject.get(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public static String getScreenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

	public static void getUploadFile(String filepath) throws InterruptedException, AWTException {
		String s = filepath;
		Thread.sleep(2000);
		setClipboardData(s);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}

	public static void setClipboardData(String string) throws InterruptedException {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Thread.sleep(2000);
	}
	
	public static boolean elementExistsOrNot1(By loactor) throws InterruptedException {
		boolean exists = false;
		int threadCount = 0;
		while (threadCount <= 5) {
		try {
		boolean result1 = driver.findElement(loactor).isDisplayed();
		System.out.println("found the locator: " + result1);
		if (result1 == true) {
		exists = true;
		Assert.assertTrue(true);
		break;
		}
		} catch (Exception e) {
		System.out.println("Got Exception");
		e.printStackTrace();
		Thread.sleep(1000);
		exists = false;
		if(threadCount ==5){
		Assert.assertTrue(false);
		}
		threadCount++;
		}
		}
		return exists;
		}



}
