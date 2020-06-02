package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UDFDemo extends UDFUtility {

	Properties prop;

	@BeforeMethod
	public void init() throws IOException {
		prop = new Properties();

		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir") + "/data.properties"));

		prop.load(fis);
		
		OpenBrowser(prop.getProperty("url"));

		
	}
	
	
//	@AfterMethod
//	public void TearDown()
//	{
//		
//	}
	

	@Test
	public void Login() throws IOException {
		
		
		setText(prop.getProperty("username_xpath"), prop.getProperty("username"));

		setText(prop.getProperty("password_xpath"), prop.getProperty("password"));

		click(prop.getProperty("loginclick"));


		checkTestCase(prop.getProperty("actual"));
	}

	@Test
	public void searchUser() {

		
		setText(prop.getProperty("username_xpath"), prop.getProperty("usernameforsearch"));

		setText(prop.getProperty("password_xpath"), prop.getProperty("password"));

		click(prop.getProperty("loginclick"));

		click(prop.getProperty("AdminMenu_xpath"));

		setText(prop.getProperty("Searchbox_xpath"), prop.getProperty("searchvalue"));

		click(prop.getProperty("Searchbtn_xpath"));

		checkStatus(prop.getProperty("searchvalue"),prop.getProperty("expectedgridval"));

	}

	// @Test
	public void checkBrokenLinks() throws InterruptedException, MalformedURLException, IOException {
		OpenBrowser(prop.getProperty("url"));

		setText(prop.getProperty("username_xpath"), prop.getProperty("username"));

		setText(prop.getProperty("password_xpath"), prop.getProperty("password"));

		click(prop.getProperty("loginclick"));

		// Thread.sleep(10000);

		// list of all links
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		Thread.sleep(20000);

		System.out.println("All links available: " + linkslist.size());

		// list of all active links
		List<WebElement> activelinks = new ArrayList<WebElement>();

		// iterate the link list: exclude all links which doesnot contain href
		for (int i = 0; i < linkslist.size(); i++) {
			Thread.sleep(500);
			System.out.println(linkslist.get(i).getAttribute("href"));
			if (linkslist.get(i).getAttribute("href") != null
					&& (!linkslist.get(i).getAttribute("href").contains("javascript"))) {

				activelinks.add(linkslist.get(i));

			}

		}

		// check the size of active links list
		System.out.println("active links count: " + activelinks.size());

		// check href url with HTTP connection api
		for (int j = 0; j < activelinks.size(); j++) {
			HttpURLConnection con = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href"))
					.openConnection();

			con.connect();
			String msg = con.getResponseMessage();
			con.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href") + "---->" + msg);
		}

	}
	
	

}
