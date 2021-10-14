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
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.RolesPage;
import com.buffalocart.pages.SidebarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.utilities.ExcelUtility;

public class AddRolesTest extends Base{
	LoginPage login;
	HomePage home;
	ExcelUtility excel;
	SidebarPage sidebar;
	UserManagementPage usermanagement;
	RolesPage roles;
	AddRolesPage addroles;
	SignoutPage signout;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 21, description = "TC_021_Verify Add Roles page title", enabled = true)
	public void verifyRolespageTitle() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		roles=usermanagement.clickOnRolesSubmodule();
		addroles=roles.clickOnAddRoles();
		String actualTitle=addroles.getAddRolesPageTitle();
		String expectedTitle="Add Role - Reobeen HHC";
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(actualTitle,expectedTitle,"Invalid addroles Page title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
}
	
	@Test(priority = 22, description = "TC_022_Verify  user can add roles ", enabled = true)
	public void VerifyUserCanAddRoles () throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		roles=usermanagement.clickOnRolesSubmodule();
		addroles=roles.clickOnAddRoles();
		addroles.clickOnRoleName();
		addroles.enterRoleName("Accountant");
		//addroles.clickOnUserCheckBox();
		roles=addroles.clickOnSaveButton();
		roles.getHardWait();
		List<ArrayList<String>> data = roles.getTableData();
		System.out.println(data);
		boolean status = false;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals("Accountant"));
			status = true;
			break;
		}
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(status, "Add userrole Failed");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		}
	}
