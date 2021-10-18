package com.buffalocart.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.AddRolesPage;
import com.buffalocart.pages.AddUsersPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.RolesPage;
import com.buffalocart.pages.SidebarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UpdateRolesPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utilities.ExcelUtility;

public class UpdateRolesTest extends Base {
	LoginPage login;
	HomePage home;
	ExcelUtility excel;
	SidebarPage sidebar;
	UserManagementPage usermanagement;
	RolesPage roles;
	UpdateRolesPage updateroles;
	SignoutPage signout;
	UsersPage users;
	AddUsersPage adduser;
	AddRolesPage addroles;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 23, description = "TC_023_Verify Edit Role page title", enabled = true)
	public void verifyEditRolespageTitle() throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		roles = usermanagement.clickOnRolesSubmodule();
		updateroles = roles.ClickonEditButton("Sales Executive");
		String actualTitle = updateroles.getEditRolesPageTitle();
		String expectedTitle = "Edit Role - Reobeen HHC";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle, "Invalid editroles Page title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

	}

	@Test(priority = 24, description = "TC_024_Verify user can update a role ", enabled = true)
	public void verifyUserCanUpdateRole() throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		roles = usermanagement.clickOnRolesSubmodule();
		addroles = roles.clickOnAddRoles();
		addroles.clickOnRoleName();
		excel = new ExcelUtility(path, "Roles");
		addroles.enterRoleName(excel.getStringCellData(1, 0));
		addroles.clickOnUserPermissionSelectAllCheckbox();
		addroles.clickOnRolesPermissionSelectAllCheckbox();
		roles = addroles.clickOnSaveButton();
		roles.getHardWait();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		// home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		roles = usermanagement.clickOnRolesSubmodule();
		excel = new ExcelUtility(path, "Roles");
		updateroles = roles.ClickonEditButton(excel.getStringCellData(1, 0));
		updateroles.getHardWait();
		updateroles.clickOnRoleName();
		updateroles.enterupdateRoleName(excel.getStringCellData(2, 0));
		// updateroles.editUserPermissionSelectAllCheckbox();
		// updateroles.editCustomerPermissionSelectAllCheckbox();
		roles = updateroles.clickOnUpdateButton();
		roles.getHardWait();

		List<ArrayList<String>> updateTableData = roles.getTableData();
		// System.out.println(updateTableData);
		boolean status = false;
		for (int i = 0; i < updateTableData.size(); i++) {
			if (updateTableData.get(i).equals(excel.getStringCellData(2, 0)))
				;
			status = true;
			break;
		}
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(status, "Edit role Failed");
		softassert.assertAll();
		roles.getHardWait();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
	}
}
