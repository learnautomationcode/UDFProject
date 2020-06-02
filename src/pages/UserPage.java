package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserPage {

	WebDriver driver;

	@FindBy(linkText = "User Management")
	WebElement linkUser;

	@FindBy(css = ".btn.btn-success.btn-sm.ml-2.btn-icon")
	WebElement btnAdd;

	@FindBy(id = "user_id")
	WebElement txtUserID;
	@FindBy(id = "user_name")
	WebElement txtUserName;
	@FindBy(id = "password")
	WebElement txtPassword;
	@FindBy(id = "re_password")
	WebElement txtRePassword;
	@FindBy(id = "user_group")
	WebElement drpUserGrp;
	@FindBy(id = "tenant")
	WebElement txtTenant;

	@FindBy(xpath = "(//div[@class='k-grid-content k-virtual-content'])[1]")
	WebElement tableDBSelection;

	public UserPage(WebDriver driver) {
		this.driver = driver;

	}

	public void AddUser() {

		linkUser.click();

		btnAdd.click();
		// txtUserID.sendKeys("u1");
		// txtUserName.sendKeys("u1");
		// txtPassword.sendKeys("Batch@123");
		// txtRePassword.sendKeys("Batch@123");
		// drpUserGrp.click();
		//
		// drpUserGrp.sendKeys("m" + Keys.ENTER);
		 //txtTenant.sendKeys("t1");

		getDbValues();
	}

	public void getDbValues() {
		
		ArrayList<String> a=new ArrayList<String>();
		a.add("QAS21211IR5");
		a.add("QAS21211IR4");
		a.add("QAS11211IR3");
	
		for(int k=0;k<a.size();k++)
		{
		int rowcount = tableDBSelection
				.findElements(By
						.xpath("(//div[@class='k-grid-content k-virtual-content'])[1]//tr[contains(@class,'k-master-row')]"))
				.size();

		int count = tableDBSelection
				.findElements(By
						.xpath("(//div[@class='k-grid-content k-virtual-content'])[1]//tr[contains(@class,k-master-row)]//td[3]"))
				.size();

		for (int i = 0; i < count; i++) {
			String text = tableDBSelection
					.findElements(By
							.xpath("(//div[@class='k-grid-content k-virtual-content'])[1]//tr[contains(@class,'k-master-row')]//td[3]"))
					.get(i).getText();

			if (text.equalsIgnoreCase(a.get(k))) {
				
				int rowcount1 = tableDBSelection
						.findElements(By
								.xpath("(//div[@class='k-grid-content k-virtual-content'])[1]//tr[contains(@class,'k-master-row')]"))
						.size();

				int count1 = tableDBSelection
						.findElements(By
								.xpath("(//div[@class='k-grid-content k-virtual-content'])[1]//tr[contains(@class,k-master-row)]//td[2]"))
						.size();
				
				for (int i1 = i; i1 < count1; i1++) {
					WebElement ele = tableDBSelection
							.findElements(By
									.xpath("(//div[@class='k-grid-content k-virtual-content'])[1]//tr[contains(@class,'k-master-row')]//td[2]"))
							.get(i1);
					ele.click();;
					break;
				}
			
		}
		}
	}

	}}
