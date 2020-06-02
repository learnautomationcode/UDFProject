package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import res.ExcelUtil;
import res.Utility;
import testcases.BaseTest;

public class UserGroupPageXML {

	
	WebDriver driver;

	@FindBy(linkText = "User Group")
	WebElement linkUserGroup;

	@FindBy(css = ".btn.btn-success.btn-sm.ml-2.btn-icon")
	WebElement btnAdd;

	@FindBy(id = "UserGroupId")
	WebElement txtUser;

	@FindBy(xpath = "//*[@class='User group exists']")
	WebElement UserGroupExists;

	@FindBy(xpath = "//input[@id='search']")
	WebElement UserGroupSearch;

	@FindBy(id = "UserGroupDesc")
	WebElement txtDescription;
	@FindBy(css = "span.k-dropdown-wrap.k-state-default")
	WebElement drpRole;
	@FindBy(id = "mapped_Password")
	WebElement txtPassword;
	@FindBy(css = "button.btn.btn-success.btn-sm.d-flex.align-items-center.mr-2")
	WebElement btnSave;
	@FindBy(css = "button.btn.btn-danger.btn-sm.d-flex.align-items-center.mr-2")
	WebElement btnDelete;

	@FindBy(xpath = "//*[@id='content-area']/div/app-user-group/kendo-dialog/div[2]/kendo-dialog-actions/button[1]")
	WebElement btnYes;
	
	@FindBy(xpath = "//td[@role='gridcell']")
	WebElement Grid;


	@FindBy(xpath = "//tr[@role='row']")
	List<WebElement> tdcount;

	public UserGroupPageXML(WebDriver driver) {
		this.driver = driver;

	}

	public void addUserGroup(String id,String description,String role,String password) {

		linkUserGroup.click();

		btnAdd.click();

		txtUser.sendKeys(id);

		txtDescription.sendKeys(description);

		// drpRole.click();

		drpRole.sendKeys(role);

		// drpRole.click();

		txtPassword.sendKeys(password);

		btnSave.click();

	}

	public void UpdateUserGroup(String id,String description,String role,String password) throws Exception {

		
		addUserGroup(id,description,role,password);
			
		// String updateid=Utility.getTestDataFromXMLFile("TestCase/UserGroupUpdate/updateid");
		 String updateid=id;
			String updatedescription=Utility.getTestDataFromXMLFile("TestCase/UserGroupUpdate/updatedescription");
			String updaterole=Utility.getTestDataFromXMLFile("TestCase/UserGroupUpdate/updaterole");
			String updatepassword=Utility.getTestDataFromXMLFile("TestCase/UserGroupUpdate/updatepassword");
			
			
		
		linkUserGroup.click();

		// btnAdd.click();

		UserGroupSearch.clear();
		//UserGroupSearch.sendKeys(row.getCell(0).toString());
		UserGroupSearch.sendKeys(updateid);

		// txtUser.sendKeys("user12");
		Grid.click();
		txtDescription.clear();
		//txtDescription.sendKeys(row.getCell(1).toString());
		txtDescription.sendKeys(updatedescription);

		drpRole.click();
		//drpRole.sendKeys(row.getCell(2).toString());
		drpRole.sendKeys(updaterole);

		//txtPassword.sendKeys(row.getCell(3).toString());
		txtPassword.sendKeys(updatepassword);

		btnSave.click();

	}

	public void SearchAndDeleteUserGroup(String id,String description,String role,String password) throws InterruptedException {

		//linkUserGroup.click();
		//for (int k = 1; k < tdcount.size(); k++) {
			//System.out.println(tdcount.size());
		//while(id.equals(id))
		//{
		addUserGroup(id,description,role,password);
		
		String UserGroup = id;
		BaseTest.wait.until(ExpectedConditions.elementToBeClickable(UserGroupSearch));
		
			UserGroupSearch.click();
			UserGroupSearch.sendKeys(UserGroup);

			driver.findElement(By.xpath("//td[@role='gridcell']")).click();

			BaseTest.wait.until(ExpectedConditions.elementToBeClickable(btnDelete));
			btnDelete.click();

			BaseTest.wait.until(ExpectedConditions.elementToBeClickable(btnYes));

			btnYes.click();

	//	}

	}

	
	public void SearchAndDeleteMultiUserGroup(String id,String description,String role,String password) throws InterruptedException {

		linkUserGroup.click();
		for (int k = 0; k <40; k++) {
			System.out.println(tdcount.size());
		
		//addUserGroup(id,description,role,password);
		
		String UserGroup = id;
		if(UserGroup.equals(id))
		{
		BaseTest.wait.until(ExpectedConditions.elementToBeClickable(UserGroupSearch));
		
			UserGroupSearch.click();
			UserGroupSearch.sendKeys(UserGroup);

			driver.findElement(By.xpath("//td[@role='gridcell']")).click();

			BaseTest.wait.until(ExpectedConditions.elementToBeClickable(btnDelete));
			btnDelete.click();

			BaseTest.wait.until(ExpectedConditions.elementToBeClickable(btnYes));

			btnYes.click();
		}
		else
		{
			break;
		}
		}

	}

}
