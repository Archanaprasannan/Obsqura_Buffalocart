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
import com.buffalocart.utilities.CalendarUtility;
import com.buffalocart.utilities.ExcelUtility;

public class HomeTest extends Base {
	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SignoutPage signout;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 6, description = "TC_006_Verify home page title", enabled = true)
	public void verifyHomepageTitle() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enternumericPassword((int)excel.getNumericCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		SoftAssert softassert = new SoftAssert();
		String actualTitle = home.getHomepageTitle();
		String expectedTitle = "Home - Reobeen HHC";
		softassert.assertEquals(actualTitle, expectedTitle, "Invalid home page title");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
	}

	@Test(priority = 7, description = "TC_007_Verify date displayed in home page ", enabled = true)

	public void VerifyDateDisplayedInHomepage() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enternumericPassword((int)excel.getNumericCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		String actualDate = home.getHomepageDate();
		String expectedDate = CalendarUtility.getCurrentDate();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualDate, expectedDate, "invalid date");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
	}

}
