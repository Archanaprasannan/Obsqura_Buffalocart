package com.buffalocart.Test;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.DeleteUserPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SidebarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UpdateUsersPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.pages.ViewUserPage;
import com.buffalocart.utilities.ExcelUtility;

public class ViewUserTest extends Base{
	LoginPage login;
	HomePage home;
	ExcelUtility excel;
	SidebarPage sidebar;
	UserManagementPage usermanagement;
	UsersPage users;
	UpdateUsersPage updateusers;
	SignoutPage signout;
	DeleteUserPage deleteuser;
	ViewUserPage viewuser;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 19, description = "TC_019_Verify  the details displayed on view user page", enabled = true)
		public void verifyDetailsDisplayedOnViewuserPage() throws IOException, InterruptedException {
			excel = new ExcelUtility(path, "Login");
			login = new LoginPage(driver);
			login.enterUsername(excel.getStringCellData(1, 0));
			login.enternumericPassword((int)excel.getNumericCellData(1, 1));
			home = login.clickOnLoginButton();
			home.clickOnEndTour();
			sidebar = home.clickOnSidebar();
			usermanagement = sidebar.clickOnUserManagementModule();
			users = usermanagement.clickOnUsersSubmodule();
			users.getHardwait();
			viewuser=users.ClickonViewButton("felixmathew@gmail.com");
			viewuser.getHardWait();
			String actualProfileName=viewuser.getProfileName();
			String actualEmail=viewuser.getEmail();
			String actualRole=viewuser.getRole();
			String actualUsername=viewuser.getUsername();
			excel = new ExcelUtility(path, "ViewUser");
			String expectedProfileName=excel.getStringCellData(1, 0);
			String expectedEmail="Email:"+ excel.getStringCellData(1, 1);
			String expectedRole="Role:"+ excel.getStringCellData(1, 2);
			String expectedUsername="Username:"+ excel.getStringCellData(1, 3);
			SoftAssert softassert=new SoftAssert();
			softassert.assertEquals(actualProfileName, expectedProfileName, "Invalid profilename");
			softassert.assertEquals(actualEmail, expectedEmail, "Invalid email");
			softassert.assertEquals(actualRole, expectedRole, "Invalid Role");
			softassert.assertEquals(actualUsername, expectedUsername, "Invalid username");
			softassert.assertAll();
			signout = home.clickOnUserMenu();
			login = signout.clickOnSignoutButton();
		}
}
