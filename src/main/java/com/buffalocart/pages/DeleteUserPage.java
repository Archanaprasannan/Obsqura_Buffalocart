package com.buffalocart.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.WaitUtility;
import com.buffalocart.utilities.WaitUtility.LocatorType;

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
	
	private final String _deletealert = "//div[@class='swal-modal']";
	@FindBy(xpath = _deletealert)
	private WebElement deletealertwindow;
	
	

	/*** UserActionMethods 
	 * @return ***/
	public UsersPage  clickOnAlertwindow() {
		PageUtility.clickOnElement(acceptalert);
		return new UsersPage(driver);
	}
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}
	
	public void getSoftWaitDeleteAlertWindow()
	{
		WaitUtility.waitForelement(driver,deletealertwindow,LocatorType.Xpath);
	}
}
