package com.buffalocart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.WaitUtility;
import com.buffalocart.utilities.WaitUtility.LocatorType;

public class DeleteSalesCommisionAgentPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public DeleteSalesCommisionAgentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	
	private final String _deleteButton = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
	@FindBy(xpath = _deleteButton)
	private WebElement okButton;
	
	private final String _deleteButtonwindow = "//div[@class='swal-modal']";
	@FindBy(xpath = _deleteButtonwindow)
	private WebElement deleteButtonwindow;

	
	
	/*** UserActionMethods ***/
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}
	public SalesCommisionAgentPage clickOnOkButton()
	{
		PageUtility.clickOnElement(okButton);
		return new SalesCommisionAgentPage(driver);
	}
	
	public void getSoftWaitsalesagentdeletewindowvisibility()
	{
		WaitUtility.waitForelementTobeClickable(driver,deleteButtonwindow,LocatorType.Xpath);
	}
	
}
