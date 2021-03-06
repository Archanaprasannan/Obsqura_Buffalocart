package com.buffalocart.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.AddSalesCommisionAgentPage;
import com.buffalocart.pages.AddUsersPage;
import com.buffalocart.pages.DeleteSalesCommisionAgentPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SalesCommisionAgentPage;
import com.buffalocart.pages.SidebarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.PageUtility;

public class AddSalesCommisionAgentTest extends Base{
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
	DeleteSalesCommisionAgentPage deletesales;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	
	 @Test(priority = 28, description = "TC_028_Verify user can add sales agent ", enabled = true)

		public void verifyUserCanAddSalesagent() throws IOException, InterruptedException {
			excel = new ExcelUtility(path, "Login");
			login = new LoginPage(driver);
			login.enterUsername(excel.getStringCellData(1, 0));
			login.enternumericPassword((int)excel.getNumericCellData(1, 1));
			home = login.clickOnLoginButton();
			home.clickOnEndTour();
			sidebar = home.clickOnSidebar();
			usermanagement = sidebar.clickOnUserManagementModule();
			salescommisionagent=usermanagement.clickOnSalesCommsionAgentSubmodule();
			addsalescommisionagent=salescommisionagent.clickOnAddButton();
			addsalescommisionagent.getSoftWaitAddSalesAgentWindow();
			//addsalescommisionagent.getHardWait();
			excel = new ExcelUtility(path, "SalesCommsionAgent");
			addsalescommisionagent.enterPrefix(excel.getStringCellData(1, 0));
			addsalescommisionagent.enterFirstname(excel.getStringCellData(1, 1));
			addsalescommisionagent.enterLastname(excel.getStringCellData(1, 2));
			addsalescommisionagent.enterEmail(excel.getStringCellData(1, 3));
			addsalescommisionagent.enterContact(excel.getNumericCellData(1, 4));
			addsalescommisionagent.enterAddress(excel.getStringCellData(1, 5));
			addsalescommisionagent.enterSalesPercentage(excel.getNumericCellData(1, 6));
			salescommisionagent=addsalescommisionagent.clickOnSaveButton();
			//salescommisionagent.getHardWait();
			salescommisionagent.getSoftWaitsalesagenttable();
			List<ArrayList<String>> data = salescommisionagent.getTableData();	
			//salescommisionagent.getHardWait();
			salescommisionagent.getSoftWaitsalesagenttable();
			System.out.println(data);
			
			boolean status = false;
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).equals(excel.getStringCellData(1, 3)));
				status = true;
				break;
			}
			SoftAssert softassert = new SoftAssert();
			softassert.assertTrue(status, "Add user Failed");
			softassert.assertAll();
			deletesales=salescommisionagent.ClickonDeleteButton(excel.getStringCellData(1, 3));
			//deletesales.getHardWait();
			deletesales.getSoftWaitsalesagentdeletewindowvisibility();
			salescommisionagent=deletesales.clickOnOkButton();
			signout = home.clickOnUserMenu();
			login = signout.clickOnSignoutButton();
			
	 }
}
