package com.buffalocart.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class DeleteUserPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public DeleteUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/

	private final String _acceptalert = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
	@FindBy(xpath = _acceptalert)
	private WebElement acceptalert;

	/*** UserActionMethods 
	 * @return ***/
	public UsersPage  clickOnAlertwindow() {
		PageUtility.clickOnElement(acceptalert);
		return new UsersPage(driver);
	}
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}
}
