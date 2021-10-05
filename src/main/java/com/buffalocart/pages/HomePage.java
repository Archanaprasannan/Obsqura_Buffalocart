package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class HomePage {
	WebDriver driver;

	/*** PageConstructor ***/
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	private final String _endtour = "//button[@class='btn btn-default btn-sm']";
	@FindBy(xpath = _endtour)
	WebElement endtour;

	private final String _homelogotitle = "//span[@class='logo-lg']";
	@FindBy(xpath = _homelogotitle)
	WebElement homelogotitle;

	private final String _usermenu = "//a[@class='dropdown-toggle']//span";
	@FindBy(xpath = _usermenu)
	WebElement usermenu;

	/*** UserActionMethods ***/
	public HomePage clickOnEndTour() {
		PageUtility.clickOnElement(endtour);
		return new HomePage(driver);
	}

	public boolean getHomePageLogoStatus() {
		return PageUtility.isElementDisplayed(homelogotitle);
	}

	public SignoutPage clickOnUserMenu() {
		PageUtility.clickOnElement(usermenu);
		return new SignoutPage(driver);
	}

	public String getHomepageTitle() {
		return PageUtility.getPageTitle(driver);
	}

}
