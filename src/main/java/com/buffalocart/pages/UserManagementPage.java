package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class UserManagementPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public UserManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/

	private final String _usermanagementsub = "//ul[@class='sidebar-menu']//li//span";
	@FindBy(xpath = _usermanagementsub)
	private List<WebElement> usermanagementsubmodules;// 38

	/*** UserActionMethods ***/
	public List<String> getUserManagementSubModules() {

		List<String> submodules = new ArrayList<String>();
		for (int i = 0; i < usermanagementsubmodules.size(); i++) {
			String webelementValue = PageUtility.getElementText(usermanagementsubmodules.get(i));
			if ((webelementValue.equals("Users")) || (webelementValue.equals("Roles"))
					|| (webelementValue.equals("Sales Commission Agents"))) {
				submodules.add(webelementValue);
			}

		}
		return submodules;
	}

	public UsersPage clickOnUsersSubmodule() {
		for (int i = 0; i < usermanagementsubmodules.size(); i++) {
			String value = usermanagementsubmodules.get(i).getText();
			if (value.equals("Users")) {
				PageUtility.clickOnElement(usermanagementsubmodules.get(i));

			}

		}
		return new UsersPage(driver);
	}
}
