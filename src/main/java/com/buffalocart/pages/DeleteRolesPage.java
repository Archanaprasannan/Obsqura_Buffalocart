package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class DeleteRolesPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public DeleteRolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	
	private final String _deleterole = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
	@FindBy(xpath = _deleterole)
	private WebElement deleterole;
	
	
	
	
	/*** UserActionMethods ***/
	public RolesPage clickOnDeleteButton()
	{
		PageUtility.clickOnElement(deleterole);
		return new RolesPage(driver);
	}
	
}
