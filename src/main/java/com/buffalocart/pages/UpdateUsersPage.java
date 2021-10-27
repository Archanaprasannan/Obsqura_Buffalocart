package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.TableUtility;
import com.buffalocart.utilities.WaitUtility;
import com.buffalocart.utilities.WaitUtility.LocatorType;

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
	
	
	private final String _edittable = "//div[@class='box-body']";
	@FindBy(xpath = _edittable)
	private WebElement edittable;
	
	private final String _editpage = "//div[@class=' content-wrapper ']";
	@FindBy(xpath = _editpage)
	private WebElement editpage;
	
	
	
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
	
	/*public void getSoftWaitEditpage() throws InterruptedException {
		WaitUtility.waitForelement(driver, edittable, LocatorType.Xpath);
	}*/
	
	public void getSoftWaitEditusertable()
	{
		WaitUtility.waitForelementVisibility(driver,edittable,LocatorType.Xpath);
	}
	
	
	
}
