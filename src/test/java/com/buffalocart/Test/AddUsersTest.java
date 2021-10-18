package com.buffalocart.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.AddUsersPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SidebarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.WaitUtility;

public class AddUsersTest extends Base {
	LoginPage login;
	HomePage home;
	ExcelUtility excel;
	SidebarPage sidebar;
	UserManagementPage usermanagement;
	UsersPage users;
	AddUsersPage adduser;
	SignoutPage signout;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	 @Test(priority = 12, description = "TC_012_Verify the error message displayed without filling mandatory fields in add user form", enabled = true)

	public void verifyErrorMessageDisplayedWithoutFillingMandatoryFields() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		users = usermanagement.clickOnUsersSubmodule();
		adduser = users.clickOnAddUsers();
		excel = new ExcelUtility(path, "AddUser");
		adduser.enterPrefix();
		adduser.enterLastname(excel.getStringCellData(1, 2));
		adduser.enteruserName(excel.getStringCellData(1, 5));
		adduser.enterSalesPercentage(excel.getNumericCellData(1, 8));
		adduser.clickOnSaveButton();
		SoftAssert softassert = new SoftAssert();
		String actualErrorMessage = adduser.getErrorMessage();
		String expectedErrorMessage = "This field is required.";
		softassert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid error message");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
	}

	 @Test(priority = 14, description = "TC_014_Verify Add Users page title", enabled = true)
	public void verifyAddUserspageTitle() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		users = usermanagement.clickOnUsersSubmodule();
		adduser = users.clickOnAddUsers();
		SoftAssert softassert = new SoftAssert();
		String actualUsersPageTitle = adduser.getAddUserspageTitle();
		String expectedUsersPageTitle = "Add user - Reobeen HHC";
		softassert.assertEquals(actualUsersPageTitle, expectedUsersPageTitle, "Invalid add userpage title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
	}

	@Test(priority = 15, description = "TC_014_Verify User can AddUser Details",enabled = true)
	public void verifyUserCanAddUserDetails() throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		users = usermanagement.clickOnUsersSubmodule();
		adduser = users.clickOnAddUsers();
		excel = new ExcelUtility(path, "AddUser");
		adduser.enterPrefix();
		adduser.enterfirstname(excel.getStringCellData(2, 1));
		adduser.enterLastname(excel.getStringCellData(2,2));
		adduser.enterEmail(excel.getStringCellData(2,3));
		adduser.enteruserName(excel.getStringCellData(2,5));
		adduser.enterPassword(excel.getStringCellData(2,6));
		adduser.enterConfirmPassword(excel.getStringCellData(2,7));
		adduser.enterSalesPercentage(excel.getNumericCellData(2,8));
		users = adduser.clickOnSaveButton();
		users.getHardWait();
		List<ArrayList<String>> data = users.getTableData();
		users.getHardWait();
		System.out.println(data);
		boolean status = false;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals(excel.getStringCellData(1, 3)));
			status = true;
			break;
		}
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(status, "Add user Failed");
		softassert.assertAll();
		users.getHardWait();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		

	}
}
