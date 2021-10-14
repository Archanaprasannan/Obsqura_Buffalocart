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

	private final String _usermanagementsub = "//li[@class='treeview  active']//i[contains(@class,'fa fa')]//following-sibling::span[@class='title']";
	@FindBy(xpath = _usermanagementsub)
	private List<WebElement> usermanagementsubmodules;// 4

	/*** UserActionMethods ***/
	public List<String> getUserManagementSubModules() {

		List<String> submodules = new ArrayList<String>();
		for (int i = 1; i < usermanagementsubmodules.size(); i++) {
			String submodulevalue = usermanagementsubmodules.get(i).getText();
			submodules.add(submodulevalue);
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

	public RolesPage clickOnRolesSubmodule() {
		for (int i = 0; i < usermanagementsubmodules.size(); i++) {
			String value = usermanagementsubmodules.get(i).getText();
			if (value.equals("Roles")) {
				PageUtility.clickOnElement(usermanagementsubmodules.get(i));

			}

		}
		return new RolesPage(driver);
	}

	public SalesCommisionAgentPage clickOnSalesCommsionAgentSubmodule() {
		for (int i = 0; i < usermanagementsubmodules.size(); i++) {
			String value = usermanagementsubmodules.get(i).getText();
			if (value.equals("Sales Commission Agents")) {
				PageUtility.clickOnElement(usermanagementsubmodules.get(i));

			}

		}
		return new SalesCommisionAgentPage(driver);
	}
}
