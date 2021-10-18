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

	private final String _usermanagement = "//ul[@class='sidebar-menu']//li//span";
	@FindBy(xpath = _usermanagement)
	private List<WebElement> usermanagement;// 38

	/*
	 * private final String _usermanagement =
	 * "//li[@class='treeview']//a/span[@class='title']";
	 * 
	 * @FindBy(xpath = _usermanagement) private List<WebElement> usermanagement;// 4
	 */

	/*** UserActionMethods ***/
	public UserManagementPage clickOnUserManagementModule() {
		for (int i = 0; i < usermanagement.size(); i++) {
			String value = usermanagement.get(i).getText();
			if (value.equals("User Management")) {
				PageUtility.clickOnElement(usermanagement.get(i));
			}
		}

		return new UserManagementPage(driver);

	}
	
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}

}
