package GT.GT;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class Utility {
	private static final ExpectedCondition<Alert> TRUE = null;
	
	public static String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		return path;
	}
	
	public static void handleAlert(WebDriver driver)throws InterruptedException{
        if(isAlertPresent(driver)){
            Alert alert = driver.switchTo().alert();
            Thread.sleep(1000);
            alert.accept();
            Thread.sleep(2000);
           // System.out.println("successfully closed the alert");
            driver.navigate().to("https://web.grptalk.com/MyGrpTalks.aspx");
          }
    }
	
    public static boolean isAlertPresent(WebDriver driver)  throws InterruptedException{
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
           // System.out.println("Alert is not present");
        }
        return foundAlert;
    }
	
	public static void explicitWaitForElementVisibility(WebDriver driver,By ele){
		By element = ele;
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public static void explicitWaitForClickableElement(WebDriver driver,WebElement ele){
		WebElement element = ele;
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void explicitWaitForAlert(WebDriver driver){
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void getUploadFile(String filepath) throws InterruptedException, AWTException {
		String s= filepath;
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
}      
