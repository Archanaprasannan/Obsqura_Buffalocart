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
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		String actualTitle = home.getHomepageTitle();
		String expectedTitle = "Home - Reobeen HHC";
		Assert.assertEquals(actualTitle, expectedTitle, "Invalid home page title");
	}

	@Test(priority = 7, description = "TC_007_Verify date displayed in home page ", enabled = true)

	public void VerifyDateDisplayedInHomepage() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		String actualDate = home.getHomepageDate();
		String expectedDate = "10/07/2021";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualDate, expectedDate, "invalid date");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();
	}

}
