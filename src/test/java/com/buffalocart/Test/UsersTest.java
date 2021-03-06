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

public class UsersTest extends Base {
	LoginPage login;
	HomePage home;
	ExcelUtility excel;
	SidebarPage sidebar;
	UserManagementPage usermanagement;
	UsersPage users;
	SignoutPage signout;
	AddUsersPage adduser;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 10, description = "TC_010_Verify Users page title", enabled= true)
	public void verifyUserspageTitle() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enternumericPassword((int)excel.getNumericCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		users = usermanagement.clickOnUsersSubmodule();
		String actualTitle = users.getUsersPageTitle();
		String expectedTitle = "Users - Reobeen HHC";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle, "Invalid Userpage title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
	}
	@Test(priority = 11, description = "TC_011_Verify user search", enabled = true)
	public void verifyUserSearch() throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enternumericPassword((int)excel.getNumericCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		users = usermanagement.clickOnUsersSubmodule();
		users.clickOnSearchBar();
		users.enterDataToSearchBar("felix mathew");
		List<ArrayList<String>> data = users.getTableData();
		//users.getHardWait();
		users.getSoftWaitusertable();
		System.out.println(data);
		System.out.println("datas are :" + data);
		excel = new ExcelUtility(path, "AddUser");
		boolean searchStatus = false;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals(excel.getStringCellData(1, 3)));
			searchStatus = true;
			break;
		}
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(searchStatus, "search Failed");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
	}

	@Test(priority = 13, description = "TC_013_Verify user login with newly added user", enabled = true)
	public void verifyUserLoginWithNewlyAddedUser() throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enternumericPassword((int)excel.getNumericCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		users = usermanagement.clickOnUsersSubmodule();
		adduser = users.clickOnAddUsers();
		excel = new ExcelUtility(path, "AddUser");
		adduser.enterPrefix();
		adduser.enterfirstname(excel.getStringCellData(1, 1));
		adduser.enterLastname(excel.getStringCellData(1, 2));
		adduser.enterEmail(excel.getStringCellData(1, 3));
		adduser.enteruserName(excel.getStringCellData(1, 5));
		adduser.enterPassword(excel.getStringCellData(1, 6));
		adduser.enterConfirmPassword(excel.getStringCellData(1, 7));
		adduser.enterSalesPercentage(excel.getNumericCellData(1, 8));
		users = adduser.clickOnSaveButton();
		//users.getSoftWaitUsersLogo();
		users.getHardwait();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		login.enterUsername(excel.getStringCellData(1, 5));
		login.enterPassword(excel.getStringCellData(1, 6));
		home = login.clickOnLoginButton();
		//home.clickOnEndTour();
		Boolean logoDisplayStatus = home.getHomePageLogoStatus();
		SoftAssert softassert=new SoftAssert();
		softassert.assertTrue(logoDisplayStatus, "Login failed");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		
	}

}
