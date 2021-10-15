package com.buffalocart.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.AddSalesCommisionAgentPage;
import com.buffalocart.pages.AddUsersPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SalesCommisionAgentPage;
import com.buffalocart.pages.SidebarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UpdateSalesCommisionAgentPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utilities.ExcelUtility;

public class UpdateSalesCommisionAgentTest extends Base{

	LoginPage login;
	HomePage home;
	ExcelUtility excel;
	SidebarPage sidebar;
	UserManagementPage usermanagement;
	UsersPage users;
	AddUsersPage adduser;
	SignoutPage signout;
	AddSalesCommisionAgentPage addsalescommisionagent;
	SalesCommisionAgentPage salescommisionagent;
	UpdateSalesCommisionAgentPage updatesales;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	
	
	 @Test(priority = 29, description = "TC_029_Verify Edit sales agent details ", enabled = true)

		public void verifyEditSalesagentDetails() throws IOException, InterruptedException {
			excel = new ExcelUtility(path, "Login");
			login = new LoginPage(driver);
			login.enterUsername(excel.getStringCellData(1, 0));
			login.enterPassword(excel.getStringCellData(1, 1));
			home = login.clickOnLoginButton();
			home.clickOnEndTour();
			sidebar = home.clickOnSidebar();
			usermanagement = sidebar.clickOnUserManagementModule();
			salescommisionagent=usermanagement.clickOnSalesCommsionAgentSubmodule();
			updatesales=salescommisionagent.ClickonEditButton("Mr Vinod Micheal");
			updatesales.getHardWait();
			excel = new ExcelUtility(path, "SalesCommsionAgent");
			updatesales.enterLastname(" R");
			salescommisionagent=updatesales.clickOnUpdateButton();
			List<ArrayList<String>> updateTableData = salescommisionagent.getTableData();
			System.out.println(updateTableData);
			boolean status = false;
			for (int i = 0; i < updateTableData.size(); i++) {
				if (updateTableData.get(i).equals("Mr Eric Mathew D"));
				status = true;
				break;
			}
			SoftAssert softassert = new SoftAssert();
			softassert.assertTrue(status, "Edit Sales agent Failed");
			softassert.assertAll();
			users.getHardWait();
			signout = home.clickOnUserMenu();
			login = signout.clickOnSignoutButton();
			
}

}