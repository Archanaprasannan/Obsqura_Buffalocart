package com.buffalocart.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.RolesPage;
import com.buffalocart.pages.SalesCommisionAgentPage;
import com.buffalocart.pages.SidebarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.utilities.ExcelUtility;

public class SalesCommisionAgentTest  extends Base{
	LoginPage login;
	HomePage home;
	ExcelUtility excel;
	SidebarPage sidebar;
	UserManagementPage usermanagement;
	SalesCommisionAgentPage salescommisionagentpage;
	SignoutPage signout;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 27, description = "TC_027_Verify Sales Commission Agents page title", enabled = true)
	public void verifySalesCommisionAgentpageTitle() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enternumericPassword((int)excel.getNumericCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		sidebar = home.clickOnSidebar();
		usermanagement = sidebar.clickOnUserManagementModule();
		salescommisionagentpage=usermanagement.clickOnSalesCommsionAgentSubmodule();
		String actualTitle = salescommisionagentpage.getSalesCommisionAgentPageTitle();
		String expectedTitle = "Sales Commission Agents - Reobeen HHC";
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle, "Invalid Sales commission agents page title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

	}
	
	
}
