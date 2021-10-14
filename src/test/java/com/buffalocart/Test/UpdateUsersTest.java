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
import com.buffalocart.pages.DeleteUserPage;
import com.buffalocart.pages.UpdateUsersPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SidebarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.TableUtility;

public class UpdateUsersTest extends Base {
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

	@Test(priority = 16, description = "TC_016_Verify Edit User page title", enabled = true)
	public void verifyEditUserpageTitle() throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		users = usermanagement.clickOnUsersSubmodule();
		updateusers=users.ClickonEditButton("felixmathew@gmail.com");
		//updateusers.getHardWait();
		String actualTitle=updateusers.getEditUserspageTitle();
		System.out.println(actualTitle);
		String expectedTitle="Edit user - Reobeen HHC";
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle, "invalid");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		
	}
	 
	@Test(priority = 17, description = "TC_017_Verify user can edit the user details ", enabled = true)
	public void verifyUserCanEditUserDetails() throws IOException, InterruptedException
	{
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		users = usermanagement.clickOnUsersSubmodule();
		updateusers=users.ClickonEditButton("felixmathew@gmail.com");
		updateusers.enterEditUsersLastname(" D");
		users=updateusers.clickOnUpdateButton();
		users.getHardWait();
		List<ArrayList<String>> updateTableData = users.getTableData();
		//System.out.println(updateTableData);
		boolean status = false;
		for (int i = 0; i < updateTableData.size(); i++) {
			if (updateTableData.get(i).equals("Mr Felix Mathew D"));
			status = true;
			break;
		}
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(status, "Edit user Failed");
		softassert.assertAll();
		users.getHardWait();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		
	}
}
