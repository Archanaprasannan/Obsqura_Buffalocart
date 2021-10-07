package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class ResetPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public ResetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	private final String _email = "email";
	@FindBy(id = _email)
	private WebElement invalidemail;

	private final String _resetLinkButton = "//button[@class='btn btn-primary']";
	@FindBy(xpath = _resetLinkButton)
	private WebElement resetLinkButton;

	private final String _errormessage = "//span[@class='help-block']//strong";
	@FindBy(xpath = _errormessage)
	private WebElement errormessage;

	/*** UserActionMethods ***/

	public void enterEmail(String email) {
		PageUtility.enterText(invalidemail, email);
	}

	public void clickOnResetLinkButton() {
		PageUtility.clickOnElement(resetLinkButton);
	}

	public String getErrorMessage() {
		return PageUtility.getElementText(errormessage);
	}
}
