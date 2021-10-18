package com.buffalocart.Test;

import java.io.IOException;

import org.testng.annotations.Test;

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
		public void verifyDetailsDisplayedOnViewuserPage() throws IOException {
			excel = new ExcelUtility(path, "Login");
			login = new LoginPage(driver);
			login.enterUsername(excel.getStringCellData(1, 0));
			login.enterPassword(excel.getStringCellData(1, 1));
			home = login.clickOnLoginButton();
			home.clickOnEndTour();
			sidebar = home.clickOnSidebar();
			usermanagement = sidebar.clickOnUserManagementModule();
			users = usermanagement.clickOnUsersSubmodule();
			viewuser=users.ClickonViewButton("alenmathew@gmail.com");
			
		}
}
