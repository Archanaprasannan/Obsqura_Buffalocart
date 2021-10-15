package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.TableUtility;

public class UpdateSalesCommisionAgentPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public UpdateSalesCommisionAgentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	
	private final String _lastname = "last_name";
	@FindBy(id = _lastname)
	private WebElement lastName;
	
	private final String _updatebutton = "//button[@class='btn btn-primary']";
	@FindBy(xpath = _updatebutton)
	private WebElement updatebutton;
	
	
	/*** UserActionMethods ***/
	
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}
	public SalesCommisionAgentPage clickOnUpdateButton()
	{
		PageUtility.clickOnElement(updatebutton);
		return new SalesCommisionAgentPage(driver);
	}
	public void enterLastname(String stringCellData) {
		PageUtility.enterText(updatebutton, stringCellData);
		
	}
}
