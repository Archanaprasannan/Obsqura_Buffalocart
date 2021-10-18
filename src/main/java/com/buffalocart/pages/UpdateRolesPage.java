package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class UpdateRolesPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public UpdateRolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	
	private final String _editrole = "name";
	@FindBy(id = _editrole)
	private WebElement editrole;
	
	private final String _updateButton = "//button[@class='btn btn-primary pull-right']";
	@FindBy(xpath = _updateButton)
	private WebElement updateButton;
	
	private final String _UserselectAll ="//*[@id='role_add_form']/div[3]/div[2]/div/label";
	@FindBy(xpath = _UserselectAll)
	private WebElement UserSelectAll;
	
	private final String _customerSelectAll ="//*[@id='role_add_form']/div[6]/div[2]/div/label";
	@FindBy(xpath = _customerSelectAll)
	private WebElement customerSelectAll;
	
	
	/*** UserActionMethods ***/
	public String getEditRolesPageTitle()
	{
		return PageUtility.getPageTitle(driver);
	}
	
	
	
	public void clickOnRoleName()
	{
		 PageUtility.clickOnElement(editrole);
	}
	public void enterupdateRoleName(String rolename)
	{
		 PageUtility.enterText(editrole, rolename);
	}
	
	public RolesPage clickOnUpdateButton()
	{
		 PageUtility.clickOnElement(updateButton);
		 return new RolesPage(driver);
	}
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}
	public void editCustomerPermissionSelectAllCheckbox() {
		PageUtility.clickOnElement(customerSelectAll);
	}
	public void editUserPermissionSelectAllCheckbox() {
		PageUtility.clickOnElement(UserSelectAll);
	}
}
