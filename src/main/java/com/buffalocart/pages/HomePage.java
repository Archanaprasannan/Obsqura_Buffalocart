package com.buffalocart.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.WaitUtility;
import com.buffalocart.utilities.WaitUtility.LocatorType;

public class HomePage {
	WebDriver driver;

	/*** PageConstructor ***/
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	private final String _endTourButton = "//div[@class='popover-navigation']//button[3]";
	//button[class='btn btn-default btn-sm']
	@FindBy(xpath = _endTourButton)
	private WebElement endTourButton;

	private final String _homelogotitle = "//span[@class='logo-lg']";
	@FindBy(xpath = _homelogotitle)
	WebElement homelogotitle;

	private final String _usermenu = "//li[@class='dropdown user user-menu']";
	@FindBy(xpath = _usermenu)
	WebElement usermenu;

	private final String _date = "//div[@class='m-8 pull-left mt-15 hidden-xs']//strong";
	@FindBy(xpath = _date)
	WebElement date;

	private final String _sidebar = "//ul[@class='sidebar-menu']";
	@FindBy(xpath = _sidebar)
	WebElement sidebar;

	/*** UserActionMethods ***/
	public HomePage clickOnEndTour() {
		PageUtility.clickOnElement(endTourButton);
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

	public String getHomepageDate() {
		return PageUtility.getElementText(date);
	}

	public SidebarPage clickOnSidebar() {
		PageUtility.clickOnElement(sidebar);
		return new SidebarPage(driver);
	}
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}
	

}
