package genericLibraries;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains all reusable methods to perform web driver actions 
 * @author vennela
 */

public class WebDriverUtility {
	WebDriver driver;
	/**
	 * This method is used to launch user desired browser
	 * @param browser
	 * @return 
	 * @return
	 */
	public WebDriver launchBrowser(String browser) {
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
			driver =new ChromeDriver();
			break;
		
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "Edge" :
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			default:
				System.out.println("Invalid browser info");
	}
		driver.manage().window().maximize();
		return driver;
			
		
		
	}
	/**
	 * this method is use to navigate to the application
	 * @param url
	 */
	public void navigateToApp(String url) {
		driver.get(url);
	}
	/**
	 * This method is an implicitly wait statement
	 * @param time
	 */
	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	/**
	 * This method is used to wait until element is visible
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement explicitWait(long time,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.visibilityOf(element)); 
			
		}
	/**
	 * This method is used to wait until element is enabled
	 * @param element
	 * @param time
	 * @return 
	 */
	public WebElement explicitWait(WebElement element,long time) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used until title of the web page appears
	 * @param title
	 * @param time
	 * @return
	 */
	public Boolean explicitWait(String title,long time) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.titleContains(title)); 
	}
	/**
	 * This method is used to mouse hover to an element
	 * @param element
	 */
	public void mouseHoverToElement(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method is used to double click on an element
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * This method is used to right click on an element
	 * @param element
	 */
	public void rightClick(WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method is used to drag and drop an element
	 * @param element
	 * @param target
	 */
	public void dragAndDropElement(WebElement element,WebElement target) {
		Actions action=new Actions(driver);
		action.dragAndDrop(element,target).perform();
	
		
	}
	public void takeScreenshot(WebDriver dfriver,String ClassName,JavaUtility jutil) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/"+ ClassName + "_"+ jutil.getCurrentTime());
		try {
			FileUtils.copyFile(src, dest);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
/**
 * This method is used to scroll till element
 * @param element
 */
	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	/**
	 *  This method is used to handle alert
	 * @param status
	 */
	public void handleAlert(String status) {
		Alert alert=driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok"))
			alert.accept();
		else
			alert.dismiss();
	}
	
	public void handleChildBrowser() {
		set<String>set=driver.getWindowHandles();
		for(String  WindowID() : set){
			driver.switchTo().window(windowID);
		}
	}
public String getparentWindowID() {
	return driver.getWindowHandle();
}
/**
 * This method is used to switch to specified window
 * @param windowID
 */
public void SwitchToWindow(String windowID) {
	driver.switchTo().window(windowID);
}
/**
 * This method is used to close current window
 */
public void closeCurrentWindow() {
	driver.close();
}
/**
 * This method is used to close all the windows
 */
public void closeAllWindows() {
	driver.quit();
}
}
	
	
		
			
	
	


