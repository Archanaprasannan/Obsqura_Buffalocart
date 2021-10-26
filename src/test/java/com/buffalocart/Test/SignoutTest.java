package com.buffalocart.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.utilities.ExcelUtility;

public class SignoutTest extends Base {
	HomePage home;
	ExcelUtility excel;
	LoginPage login;
	SignoutPage signout;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 8, description = "TC_008_Verify whether user is navigating to login page by clicking on Sign out button", enabled = true)
	public void verifyUserNavigatingToLoginPageByClickingOnSignout() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enternumericPassword((int)excel.getNumericCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
		boolean actualLoginlogoStatus = login.getLoginlogoStatus();
		Assert.assertTrue(actualLoginlogoStatus, "unable to navigate to loginpage");
		
	}
}
