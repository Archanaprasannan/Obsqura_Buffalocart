package com.buffalocart.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SidebarPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.utilities.ExcelUtility;

public class UserManagementTest extends Base {
	LoginPage login;
	HomePage home;
	ExcelUtility excel;
	SidebarPage sidebar;
	UserManagementPage usermanagement;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 9, description = "TC_009_Verify the Usermanagement sub tabs", enabled = true)
	public void verifyUserManagementSubTabs() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		List<String> actualValues = usermanagement.getUserManagementSubModules();
		System.out.println("values are :" + actualValues);
		excel = new ExcelUtility(path, "UserManagement");
		List<String> expectedvalues = excel.getListCellData();
		System.out.println("values are :" + expectedvalues);
		//expectedvalues.add("Users");
		//expectedvalues.add("Roles");
		//expectedvalues.add("Sales Commission Agents");

		Assert.assertEquals(actualValues, expectedvalues, "invalid submodules");

	}
}
