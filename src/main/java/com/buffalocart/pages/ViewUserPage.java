package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class ViewUserPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public ViewUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	private final String _profilename = "//div[@class='col-md-12']/h3";
	@FindBy(xpath = _profilename)
	private WebElement profilename;

	private final String _email = "//div[@class='row']/div[2]/p[1]";
	@FindBy(xpath = _email)
	private WebElement email;

	private final String _role = "//div[@class='row']/div[2]/p[2]";
	@FindBy(xpath = _role)
	private WebElement role;

	private final String _username = "//div[@class='row']/div[2]/p[3]";
	@FindBy(xpath = _username)
	private WebElement username;

	/*** UserActionMethods ***/
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}

	public String getProfileName() {
		return PageUtility.getElementText(profilename);
	}

	public String getEmail() {
		return PageUtility.getElementText(email);
	}

	public String getRole() {
		return PageUtility.getElementText(role);
	}

	public String getUsername() {
		return PageUtility.getElementText(username);
	}

}
