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
import com.buffalocart.pages.DeleteSalesCommisionAgentPage;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SalesCommisionAgentPage;
import com.buffalocart.pages.SidebarPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.pages.UpdateSalesCommisionAgentPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utilities.ExcelUtility;

public class DeleteSalesCommisionAgentTest extends Base{
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

	@Test(priority = 30, description = "TC_30_Verify user can delete a Sales Commission Agents ", enabled = true)

	public void verifyUserCanDeleteSalesCommissionAgents() throws IOException, InterruptedException {
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
		addsalescommisionagent.enterPrefix(excel.getStringCellData(3, 0));
		addsalescommisionagent.enterFirstname(excel.getStringCellData(3, 1));
		addsalescommisionagent.enterLastname(excel.getStringCellData(3, 2));
		addsalescommisionagent.enterEmail(excel.getStringCellData(3, 3));
		addsalescommisionagent.enterContact(excel.getNumericCellData(3, 4));
		addsalescommisionagent.enterAddress(excel.getStringCellData(3, 5));
		addsalescommisionagent.enterSalesPercentage(excel.getNumericCellData(3, 6));
		salescommisionagent=addsalescommisionagent.clickOnSaveButton();
		//salescommisionagent.getHardWait();
		//salescommisionagent.getSoftWaitsalesagenttable();
		salescommisionagent.getSoftWaitDeletesalesagent();
		deletesales=salescommisionagent.ClickonDeleteButton(excel.getStringCellData(3, 3));
		//deletesales.getHardWait();
		deletesales.getSoftWaitsalesagentdeletewindowvisibility();
		salescommisionagent=deletesales.clickOnOkButton();
		//salescommisionagent.getHardWait();
		List<ArrayList<String>> updateTableData = salescommisionagent.getTableData();
		System.out.println(updateTableData);
		boolean status = false;
		for (int i = 0; i < updateTableData.size(); i++) {
			if (!updateTableData.get(i).equals(excel.getStringCellData(3, 7)));
			status = true;
			break;
		}
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(status, "Delete Sales agent Failed");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		
}
}
