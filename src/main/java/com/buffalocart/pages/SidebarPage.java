package com.buffalocart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class SidebarPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public SidebarPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/

	private final String _usermanagementsub = "//ul[@class='sidebar-menu']//li//span";
	@FindBy(xpath = _usermanagementsub)
	private List<WebElement> usermanagementsub;// 4

	/*** UserActionMethods ***/
	public UserManagementPage clickOnUserManagementModule() {
		for (int i = 0; i < usermanagementsub.size(); i++) {
			String value = usermanagementsub.get(i).getText();
			if (value.equals("User Management")) {
				PageUtility.clickOnElement(usermanagementsub.get(i));

			}

		}
		return new UserManagementPage(driver);
	}

}
