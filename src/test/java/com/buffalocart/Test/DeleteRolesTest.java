package com.buffalocart.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.DeleteRolesPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.RolesPage;
import com.buffalocart.pages.SidebarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UpdateRolesPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.utilities.ExcelUtility;

public class DeleteRolesTest extends Base{
	LoginPage login;
	HomePage home;
	ExcelUtility excel;
	SidebarPage sidebar;
	UserManagementPage usermanagement;
	RolesPage roles;
	UpdateRolesPage updateroles;
	SignoutPage signout;
	DeleteRolesPage deleterole;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	
	@Test(priority = 25, description = "TC_025_Verify user can delete a role", enabled = true)
	public void verifyUserCanDeleteRole () throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		roles=usermanagement.clickOnRolesSubmodule();
		deleterole=roles.ClickonDeleteButton("Chief Accountant");
		roles=deleterole.clickOnDeleteButton();
		roles.getHardWait();
		List<ArrayList<String>> updateTableData = roles.getTableData();
		//System.out.println(updateTableData);
		boolean status = false;
		for (int i = 0; i < updateTableData.size(); i++) {
			if (!updateTableData.get(i).equals("Chief Accountant"));
			status = true;
			break;
		}
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(status, "Edit user Failed");
		softassert.assertAll();
		roles.getHardWait();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
}
	}