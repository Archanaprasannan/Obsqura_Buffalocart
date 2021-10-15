package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.TableUtility;

public class UpdateUsersPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public UpdateUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	
	private final String _editlastname = "//input[@id='last_name']";
	@FindBy(xpath = _editlastname)
	private WebElement editlastname;
	
	private final String _updateButton = "submit_user_button";
	@FindBy(id = _updateButton)
	private WebElement updateButton;
	
	
	
	/*** UserActionMethods ***/
	
	public String getEditUserspageTitle()
	{
		return PageUtility.getPageTitle(driver);
	}
	
	
	public void enterEditUsersLastname(String lastname)
	{
		 PageUtility.enterText(editlastname, lastname);
	}
	
	public UsersPage clickOnUpdateButton()
	{
		 PageUtility.clickOnElement(updateButton);
		 return new UsersPage(driver);
	}
	
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}
	
	
	
}
