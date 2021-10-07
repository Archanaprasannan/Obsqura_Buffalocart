package com.buffalocart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class UsersPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	private final String _searchbar = "//input[@class='form-control input-sm']";
	@FindBy(xpath = _searchbar)
	private WebElement searchbar;//

	/*** UserActionMethods ***/
	public String getUsersPageTitle() {
		return PageUtility.getPageTitle(driver);
	}
	public void clickOnSearchBar()
	{
		PageUtility.clickOnElement(searchbar);
	}
}
