package com.buffalocart.Test;

import java.io.IOException;
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
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utilities.ExcelUtility;

public class RolesTest extends Base {
	LoginPage login;
	HomePage home;
	ExcelUtility excel;
	SidebarPage sidebar;
	UserManagementPage usermanagement;
	RolesPage roles;
	SignoutPage signout;
	UsersPage users;
	AddUsersPage adduser;
	AddRolesPage addroles;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 20, description = "TC_020_Verify Roles page title", enabled = true)
	public void verifyRolespageTitle() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enternumericPassword((int)excel.getNumericCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		roles = usermanagement.clickOnRolesSubmodule();
		SoftAssert softassert = new SoftAssert();
		String actualTitle = roles.getRolesPageTitle();
		String expectedTitle = "Roles - Reobeen HHC";
		softassert.assertEquals(actualTitle, expectedTitle, "Invalid Userpage title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
	}

	@Test(priority = 26, description = "TC_026_Verify whether the added role in Role page is listed in roles field in user add page", enabled = true)
	public void verifyAddedRoleInUserAddpage() throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enternumericPassword((int)excel.getNumericCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		roles = usermanagement.clickOnRolesSubmodule();
		addroles = roles.clickOnAddRoles();
		addroles.clickOnRoleName();
		excel = new ExcelUtility(path, "Roles");
		addroles.enterRoleName(excel.getStringCellData(2, 0));
		addroles.clickOnUserPermissionSelectAllCheckbox();
		addroles.clickOnRolesPermissionSelectAllCheckbox();
		roles = addroles.clickOnSaveButton();
		roles.getHardWait();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		excel = new ExcelUtility(path, "Login");
		//login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enternumericPassword((int)excel.getNumericCellData(1, 1));
		home = login.clickOnLoginButton();
		//home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		users = usermanagement.clickOnUsersSubmodule();
		adduser = users.clickOnAddUsers();
		List<String> actualRoleNames = adduser.getOptionsFromRoleDropdown();
		System.out.println(actualRoleNames);
		boolean actualRoleName = false;
		excel = new ExcelUtility(path, "Roles");
		for (int i = 0; i < actualRoleNames.size(); i++) {
			if (actualRoleNames.get(i).equals(excel.getStringCellData(2, 0))) {
				actualRoleName = true;
				break;
			}
		}
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(actualRoleName, "Rolename not found in user add page");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

	}
}
