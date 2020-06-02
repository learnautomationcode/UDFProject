package testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.paulhammant.ngwebdriver.ByAngular;
//import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import res.Utility;

public class BaseTest {

	public static ThreadLocal<WebDriver> dr=new ThreadLocal<WebDriver>();
public static WebDriver driver=null;
 public static WebDriverWait wait=null;
  JavascriptExecutor js;
 static int temp=0;
	 //NgWebDriver ngdriver;
LoginPage lpage;

public static ExtentReports extent= new ExtentReports(System.getProperty("user.dir")+ "\\Reports\\ExtentReportsTestNG.html", true);;
public static ExtentTest test;
	//@BeforeMethod
	public void BrowserSetup() throws IOException, InterruptedException {
		
	//if(temp==0)
	//	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\res\\data.properties");
		
		Properties p=new Properties();
		
		p.load(fis);
		
		String browser=p.getProperty("browser");
		String url=p.getProperty("url");
				
				
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver=new ChromeDriver(option);
		dr.set(driver);
		
		
		}
		else if(browser.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
		//driver = new FirefoxDriver();
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//getDriver().manage().window().maximize();
		//ngdriver = new NgWebDriver((JavascriptExecutor) driver);
	//	ngdriver.waitForAngularRequestsToFinish();
		//getDriver().get(url);
		
		
		}
		
		
		dr.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dr.get().manage().window().maximize();
		//ngdriver = new NgWebDriver((JavascriptExecutor) driver);
		//ngdriver.waitForAngularRequestsToFinish();
		String xmlpath=Utility.getTestDataFromXMLFile("Common/AppUrl");
		dr.get().get(xmlpath);
		js=(JavascriptExecutor)dr.get();
		//getRuntimeMessages("info","Page Launched");
		 wait=new WebDriverWait(dr.get(), 20);
		// temp++;
	//	}
//	else
	//{
//		setWebDriver(driver);
//		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//		getDriver().manage().window().maximize();
//		//ngdriver = new NgWebDriver((JavascriptExecutor) driver);
//		//ngdriver.waitForAngularRequestsToFinish();
//		//getDriver().get(url);
//		
//		 wait=new WebDriverWait(getDriver(), 20);
	//}
		

	}
	
	public   void getRuntimeMessages(String msgtype, String msg) throws InterruptedException {
		// Check for jQuery on the page, add it if need be
				js.executeScript("if (!window.jQuery) {"
						+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
						+ "jquery.src = 'http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
						+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
				
		Thread.sleep(3000);

		// Use jQuery to add jquery-growl to the page
		js.executeScript("$.getScript('http://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");
		//js.executeScript("$.getScript('C:/Workspace/jquery/jquerygrowl/jquery.growl.js')");

		// js.executeScript("$.getScript('/Users/NaveenKhunteta/Documents/workspace/Test/src/testcases/jquery.growl.js')");

		// Use jQuery to add jquery-growl styles to the page
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"http://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		
		Thread.sleep(3000);

		// jquery-growl w/ no frills
		//	js.executeScript("$.growl({ title: 'GET', message: '/' });");

		if (msgtype.equals("error")) {
			js.executeScript("$.growl.error({ title: 'ERROR', message: '" + msg + "' });");

		} else if (msgtype.equals("info")) {
		js.executeScript("$.growl.notice({ title: 'Info', message: '" + msg + "' });");
		//	js.executeScript("$.growl.notice({  message: '" + msg + "' });");

		} else if (msgtype.equals("warning")) {
			js.executeScript("$.growl.warning({ title: 'Warning!', message: '" + msg + "' });");

		}
		// jquery-growl w/ colorized output
//				js.executeScript("$.growl.error({ title: 'ERROR', message: 'Some exception is coming' });");
//				js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//				js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
//	

	}



public void getScreenshot(ITestResult result) throws IOException
{
	//if(itr.getStatus()>1)
	//{
	TakesScreenshot scrShot = ((TakesScreenshot)dr.get());

	// Call getScreenshotAs method to create image file

	File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

	// Move image file to new destination

	String dest = System.getProperty("user.dir") + "\\" + result.getName() + "error.png";
	File DestFile = new File(dest);

	String imgpath = dest;

	// Copy file at destination

	FileUtils.copyFile(SrcFile, DestFile);

	
	
	

//	
}

//@AfterMethod
public void tearDown(){
	
//	File src=((TakesScreenshot)dr.get()).getScreenshotAs(OutputType.FILE);
//	FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
//	
	

	
	dr.get().close();
	dr.get().quit();
}
}