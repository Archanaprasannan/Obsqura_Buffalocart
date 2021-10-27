package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.WaitUtility;
import com.buffalocart.utilities.WaitUtility.LocatorType;

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
	
	private final String _deletealert = "//div[@class='swal-modal']";
	@FindBy(xpath = _deletealert)
	private WebElement deletealertwindow;
	
	
	
	
	
	/*** UserActionMethods ***/
	public RolesPage clickOnDeleteButton()
	{
		PageUtility.clickOnElement(deleterole);
		return new RolesPage(driver);
	}
	
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}
	
	public void getSoftWaitDeleteAlertWindow()
	{
		WaitUtility.waitForelementVisibility(driver,deletealertwindow,LocatorType.Xpath);
	
}
}
