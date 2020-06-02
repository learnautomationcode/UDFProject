package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;

public class UDFUtility extends BaseTest {

	public static WebDriver driver;
	// enter value into text box

	// OPen Browser
	public static void OpenBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver = new ChromeDriver(opt);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	    driver.get(url);
	    

	    
	}

	public static void setText(String locatorValue, String value) {

		// By locatorname=locator;
		driver.findElement(By.xpath(locatorValue)).sendKeys(value);

	}
	
	
	public static void selectValueFromDropdown(String locatorValue, String value) {

		// By locatorname=locator;
		new Select(driver.findElement(By.xpath(locatorValue))).selectByVisibleText(value);;

	}
	

	public static By byLocator(String locatorname) {

		return By.xpath(locatorname);

	}

	public static void click(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void checkTestCase(String Actual) {
		Assert.assertTrue(driver.getCurrentUrl().contains(Actual));
	}
	
	public void checkStatus(String Actual,String Expected) {
		Assert.assertEquals(Actual,Expected);
	}

}
