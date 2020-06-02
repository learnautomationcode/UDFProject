package pages;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.helpers.XSSFRowShifter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import res.ExcelUtil;





public class LoginPage {
	
	
	//public static ThreadLocal<WebDriver> dr1=new ThreadLocal<WebDriver>();
	//public static ThreadLocal<String> ele=new ThreadLocal<String>();

	WebDriver driver;
	
	@FindBy(id="UserName") WebElement txtUsername;
	@FindBy(id="Password") WebElement txtPassword;
	//@com.paulhammant.ngwebdriver.ByAngularButtonText.FindBy(buttonText="Connect") WebElement btnLogin;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		//dr1.set(driver);
		
	}
	
	
//	public void Login(XSSFRow row) throws Exception
//	{
//		
//		txtUsername.sendKeys(row.getCell(0).toString());
//		txtPassword.sendKeys(row.getCell(1).toString());
//		
//	}

	public void setUsername(String user)
	{
//		synchronized(dr1)
//		{
			///ele.set(user);
			txtUsername.sendKeys(user);
			
		
		//}
	
		
	}
	
	public void setPassword(String password)
	{
//		synchronized(dr1)
//		{
		//ele.set(password);
			txtPassword.sendKeys(password);
		//}	
		
	
		
	}
	
	public void Login()
	{
//		synchronized(dr1)
//		{
		//ele.set(btnLogin);
		//	btnLogin.click();
		
		//}
		
	}
	

}
