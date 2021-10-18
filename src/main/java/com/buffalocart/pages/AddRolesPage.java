package com.buffalocart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class AddRolesPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public AddRolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	private final String _rolename = "name";
	@FindBy(id = _rolename)
	private WebElement roleName;
	
	private final String _savebutton = "//button[@class='btn btn-primary pull-right']";
	@FindBy(xpath = _savebutton)
	private WebElement savebutton;
	
	private final String _UserselectAll ="//*[@id='role_add_form']/div[3]/div[2]/div/label";
	@FindBy(xpath = _UserselectAll)
	private WebElement UserSelectAll;
	

	private final String _RolesSelectAll ="//*[@id='role_add_form']/div[4]/div[2]/div/label";
	@FindBy(xpath = _RolesSelectAll)
	private WebElement RolesSelectAll;
	
	
	/*** UserActionMethods ***/
	public String getAddRolesPageTitle()
	{
		return PageUtility.getPageTitle(driver);
	}
	
	public void clickOnRoleName()
	{
		PageUtility.clickOnElement(roleName);
	}
	public void enterRoleName(String name)
	{
		PageUtility.enterText(roleName, name);
	}

	public RolesPage clickOnSaveButton()
	{
		PageUtility.clickOnElement(savebutton);
		return new RolesPage(driver);
	}
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}
	
	public void clickOnUserPermissionSelectAllCheckbox() {
		PageUtility.clickOnElement(UserSelectAll);
	}
	public void clickOnRolesPermissionSelectAllCheckbox() {
		PageUtility.clickOnElement(RolesSelectAll);
	}
	
}
