package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class LoginPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	private final String _username = "username";
	@FindBy(id = _username)
	private WebElement username;

	private final String _password = "password";
	@FindBy(id = _password)
	private WebElement password;

	private final String _login = "//button[@class='btn btn-primary']";
	@FindBy(xpath = _login)
	private WebElement loginbutton;

	private final String _invalidloginmessage = "//span[@class='help-block']//strong";
	@FindBy(xpath = _invalidloginmessage)
	private WebElement invalidloginmessage;
	
	private final String _remembermecheckbox = "//input[@name='remember']";
	@FindBy(xpath = _remembermecheckbox)
	private WebElement remembermecheckbox;
	
	private final String _loginlogo = "//div[@class='panel-heading']";
	@FindBy(xpath = _loginlogo)
	private WebElement panelheadinglogin;
	
	private final String _forgotpassword = "//a[@class='btn btn-link']";
	@FindBy(xpath = _forgotpassword)
	private WebElement forgotpassword;
	
	
	/*** UserActionMethods ***/
	public String getLoginpageTitle() {
		return PageUtility.getPageTitle(driver);
	}

	public void enterUsername(String uName) {
		PageUtility.enterText(username, uName);
	}

	public void enterPassword(String pName) {
		PageUtility.enterText(password, pName);
	}

	public HomePage clickOnLoginButton() {
		PageUtility.clickOnElement(loginbutton);
		return new HomePage(driver);
	}
	public String getInvalidLoginMessage()
	{
		return PageUtility.getElementText(invalidloginmessage);
	}
	
	public void clickOnRememebermeCheckbox()
	{
		PageUtility.clickOnElement(remembermecheckbox);
	}
	public boolean getRemembermeStatus()
	{
		return PageUtility.isElementSelected(remembermecheckbox);
	}
	public boolean getLoginlogoStatus()
	{
		return PageUtility.isElementDisplayed(panelheadinglogin);
	}
	public ResetPage clickOnForgotPasswordButton()
	{
		PageUtility.clickOnElement(forgotpassword);
		return new ResetPage(driver);
	}
}
