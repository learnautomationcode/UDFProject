package pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;




public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='app-detail text-center']/p") WebElement msgWelcome;
	@FindBy(xpath="	//*[@id='content-area']/app-header/nav/div/kendo-menu/ul/li/span/a/span[1]") WebElement profileIcon;
	@FindBy(xpath="//button[text()='Logout']") WebElement btnLogout;
	@FindBy(xpath="//button[text()='Yes']") WebElement btnYes;


	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public WebElement welcomeMsg()
	{
		return msgWelcome;
		
		
	}
	
	
	public void checkMenus()
	{
		int linkscount = driver.findElements(By.tagName("a")).size();
		System.out.println(linkscount);

		for (int i = 0; i < linkscount - 1; i++) {
			String clicklinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			driver.findElements(By.tagName("a")).get(i).sendKeys(clicklinks);
			// Thread.sleep(2000);

		}

		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
			System.out.println(driver.getTitle());

		}

		driver.switchTo().window(driver.getWindowHandle());

	}
	
	public void Logout(){
		
		profileIcon.click();
		btnLogout.click();
		btnYes.click();
		
		
	
	}
	

		
	}
	
	
	


