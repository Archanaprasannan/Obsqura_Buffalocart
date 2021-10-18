package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class SignoutPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public SignoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	private final String _signout = "//div[@class='pull-right']/a";
	@FindBy(xpath = _signout)
	WebElement signout;

	/*** UserActionMethods ***/
	public LoginPage clickOnSignoutButton() {
		PageUtility.clickOnElement(signout);
		return new LoginPage(driver);
	}
}
