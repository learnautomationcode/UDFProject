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
import testcases.BaseTest;

public class UserGroupPage {

	
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


	@FindBy(tagName = "td")
	List<WebElement> tdcount;

	public UserGroupPage(WebDriver driver) {
		this.driver = driver;

	}

	public void addUserGroup(XSSFRow row) {

		linkUserGroup.click();

		btnAdd.click();

		txtUser.sendKeys(row.getCell(0).toString());

		txtDescription.sendKeys(row.getCell(1).toString());

		// drpRole.click();

		drpRole.sendKeys(row.getCell(2).toString());

		// drpRole.click();

		txtPassword.sendKeys(row.getCell(3).toString());

		btnSave.click();

	}

	public void UpdateUserGroup(XSSFRow row) throws Exception {

		
		addUserGroup(row);
		//ExcelUtil.setExcelFileSheet("UserGroupUpdate");
		ExcelUtil.setExcelFileSheet("UserGroupUpdate");
	
	 ExcelUtil.setRowNumber(2);
		//System.out.println(row.getRowNum());
			
		linkUserGroup.click();

		// btnAdd.click();

		UserGroupSearch.clear();
		//UserGroupSearch.sendKeys(row.getCell(0).toString());
		UserGroupSearch.sendKeys(ExcelUtil.getRowData(2).getCell(0).toString());

		// txtUser.sendKeys("user12");
		Grid.click();
		txtDescription.clear();
		//txtDescription.sendKeys(row.getCell(1).toString());
		txtDescription.sendKeys(ExcelUtil.getRowData(2).getCell(1).toString());

		drpRole.click();
		//drpRole.sendKeys(row.getCell(2).toString());
		drpRole.sendKeys(ExcelUtil.getRowData(2).getCell(2).toString());

		//txtPassword.sendKeys(row.getCell(3).toString());
		txtPassword.sendKeys(ExcelUtil.getRowData(2).getCell(3).toString());

		btnSave.click();

	}

	public void SearchAndDeleteUserGroup(XSSFRow row) throws InterruptedException {

		linkUserGroup.click();
		for (int k = 1; k < tdcount.size()-1; k++) {
			System.out.println(tdcount.size());
			String UserGroup = row.getCell(0).toString();
			UserGroupSearch.click();
			UserGroupSearch.sendKeys(UserGroup);

			driver.findElement(By.xpath("//td[@role='gridcell']")).click();

			BaseTest.wait.until(ExpectedConditions.elementToBeClickable(btnDelete));
			btnDelete.click();

			BaseTest.wait.until(ExpectedConditions.elementToBeClickable(btnYes));

			btnYes.click();

		}

	}

}
