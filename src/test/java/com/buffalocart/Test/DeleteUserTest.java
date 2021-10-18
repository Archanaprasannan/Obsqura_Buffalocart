package com.buffalocart.Test;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
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
import com.buffalocart.utilities.ExcelUtility;

public class DeleteUserTest extends Base{
	LoginPage login;
	HomePage home;
	ExcelUtility excel;
	SidebarPage sidebar;
	UserManagementPage usermanagement;
	UsersPage users;
	UpdateUsersPage updateusers;
	SignoutPage signout;
	DeleteUserPage deleteuser;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	@Test(priority = 18, description = "TC_018_Verify user can delete a user", enabled = true)
	public void verifyDeleteUserpageTitle() throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		users = usermanagement.clickOnUsersSubmodule();
		excel = new ExcelUtility(path, "AddUser");
		users.getHardwait();
		deleteuser=users.ClickonDeleteButton(excel.getStringCellData(2, 3));
		//deleteuser.getHardWait();
		users=deleteuser.clickOnAlertwindow();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		
	}
	 
}
