package com.buffalocart.Test;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.AddUsersPage;
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
	AddUsersPage adduser;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	@Test(priority = 18, description = "TC_018_Verify user can delete a user", enabled = true)
	public void verifyUserCanDeleteUser() throws IOException, InterruptedException {
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
		excel = new ExcelUtility(path, "DeleteUser");
		adduser.enterPrefix();
		adduser.enterfirstname(excel.getStringCellData(1, 1));
		adduser.enterLastname(excel.getStringCellData(1,2));
		adduser.enterEmail(excel.getStringCellData(1,3));
		adduser.enteruserName(excel.getStringCellData(1,5));
		adduser.enterPassword(excel.getStringCellData(1,6));
		adduser.enterConfirmPassword(excel.getStringCellData(1,7));
		adduser.enterSalesPercentage(excel.getNumericCellData(1,8));
		users = adduser.clickOnSaveButton();
		//users.getHardwait();
		users.getSoftWaitDeleteusertable();
		
	
		deleteuser=users.ClickonDeleteButton(excel.getStringCellData(1,5));
		//deleteuser.getHardWait();
		deleteuser.getSoftWaitDeleteAlertWindow();
		users=deleteuser.clickOnAlertwindow();
		users.getSoftWaitusersmenuclickable();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		
	}
	 
}
