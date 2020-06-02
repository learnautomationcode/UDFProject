package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

import testcases.BaseTest;

public class RolePage {

	WebDriver driver;

	@FindBy(linkText = "Roles")
	WebElement linkRoles;
	
	@FindBy(css = ".btn.btn-success.btn-sm.ml-2.btn-icon")
	WebElement btnAdd;

	@FindBy(id = "RoleId")
	WebElement txtRoleId;
	
	@FindBy(xpath="//*[@class='User group exists']")
	WebElement UserGroupExists;
	
	@FindBy(xpath="//input[@id='search']")
	WebElement UserGroupSearch;
	
	
	@FindBy(id = "RoleDesc")
	WebElement txtRoleDescription;

	@FindBy(id = "tenant")
	WebElement txtTenant;
	@FindBy(css = "button.btn.btn-primary.btn-sm.mr-2.btn-icon")
	WebElement btnSearch;
	
	@FindBy(xpath = "(//span[@class='checkbox'])[3]")
	WebElement chkEnableFilter;
	
	@FindBy(xpath = "//*[@id='content-area']/div/app-user-roles/kendo-dialog/div[2]/div/div/kendo-grid/div/div/div/table/thead/tr[2]/td[1]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input")
	WebElement txtProductId;
	
	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[3]")
	WebElement ClickProductId;
	
	
	@FindBy(css = "button.btn.btn-success.btn-sm.d-flex.align-items-center.mr-2")
	WebElement btnSave;

	
	@FindBy(css = "input#search")
	WebElement txtSearch;
	
	@FindBy(xpath="//*[@id='content-area']/div/app-user-roles/div/div[2]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr/td[1]") 
	WebElement valGrid;
	
	@FindBy(tagName="td") 
	List<WebElement> tdcount;

	@FindBy(css = "button.btn.btn-danger.btn-sm.d-flex.align-items-center.mr-2")
	WebElement btnDelete;

	@FindBy(xpath = "//*[@id='content-area']/div/app-user-group/kendo-dialog/div[2]/kendo-dialog-actions/button[1]")
	WebElement btnYes;

	
	public RolePage(WebDriver driver) {
		this.driver = driver;

	}

	public void addRole() {

//		linkRoles.click();
//
//		btnAdd.click();
//
//		txtRoleId.sendKeys(user);
//
//		txtRoleDescription.sendKeys("user6");
//		
//		
//		txtTenant.sendKeys("Batch@123");

		btnSearch.click();
		
		chkEnableFilter.click();
	//	BaseTest b=new BaseTest();
	//b.wait.until(ExpectedConditions.elementToBeClickable(txtProductId));
		txtProductId.click();
		txtProductId.sendKeys("CNF");
		
		ClickProductId.click();
		btnSave.click();
		
	}
	
		
	public void SearchRole() {
		
		addRole();

		linkRoles.click();
		
		txtSearch.sendKeys("CNF");
		
		valGrid.click();
		
	
	}
	
public void UpdateRole(String user) {
		
	//	addRole(user);

		linkRoles.click();

	//btnAdd.click();
		
		txtSearch.clear();
		txtSearch.sendKeys(user);

		//txtUser.sendKeys("user12");
		
		
		valGrid.click();
		txtRoleId.sendKeys(user);
		//
//				txtRoleDescription.sendKeys("user6");
//				
//				
//				txtTenant.sendKeys("Batch@123");

				btnSearch.click();
				
				chkEnableFilter.click();
			//	BaseTest b=new BaseTest();
			//b.wait.until(ExpectedConditions.elementToBeClickable(txtProductId));
				txtProductId.click();
				txtProductId.sendKeys("CNF");
				
				ClickProductId.click();
				btnSave.click();

	}
	
	
public void DeleteRoles() throws InterruptedException {

	linkRoles.click();
	for (int k = 1; k < tdcount.size(); k++) {
		System.out.println(tdcount.size());
		String Role = "user";
		txtSearch.click();
		txtSearch.sendKeys(Role);

		driver.findElement(By.xpath("//td[@role='gridcell']")).click();

		BaseTest.wait.until(ExpectedConditions.elementToBeClickable(btnDelete));
		btnDelete.click();

		BaseTest.wait.until(ExpectedConditions.elementToBeClickable(btnYes));

		btnYes.click();

	}

}
	
	
	
	
	
	

}
