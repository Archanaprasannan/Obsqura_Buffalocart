package com.buffalocart.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.utilities.ExcelUtility;

public class HomeTest extends Base {
	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	@Test(priority = 6, description = "TC_006_Verify home page title", enabled = true)
	public void verifyHomepageTitle() throws IOException
	{
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		login.enterPassword(excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		String actualTitle=home.getHomepageTitle();
		String expectedTitle="Home - Reobeen HHC";
		Assert.assertEquals(actualTitle, expectedTitle, "Invalid home page title");
	}

}
