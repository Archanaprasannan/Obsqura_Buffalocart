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
	
	private final String _userchechbox = "//div[@class='icheckbox_square-blue hover']";
	@FindBy(xpath = _userchechbox)
	private WebElement userchechbox;
	
	private final String _savebutton = "//button[@class='btn btn-primary pull-right']";
	@FindBy(xpath = _savebutton)
	private WebElement savebutton;
	
	
	
	
	
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
	public void clickOnUserCheckBox()
	{
		PageUtility.clickOnElement(userchechbox);
	}
	public RolesPage clickOnSaveButton()
	{
		PageUtility.clickOnElement(savebutton);
		return new RolesPage(driver);
	}
	
	
}
