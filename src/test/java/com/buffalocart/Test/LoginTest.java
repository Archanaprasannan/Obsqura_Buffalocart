package com.buffalocart.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.TestListener;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SignoutPage;
import com.buffalocart.utilities.ExcelUtility;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginTest extends Base {
	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	SignoutPage signout;
	//ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 1, description = "TC_001_Verify login page title", enabled = true)
	public void verifyLoginpageTitle() {
		//extentTest.get().assignCategory("Sanity");
		login = new LoginPage(driver);
		String actualTitle = login.getLoginpageTitle();
		String expectedTitle = "Login - Demo POS";
		Assert.assertEquals(actualTitle, expectedTitle, "Invalid login page title");
		//extentTest.get().log(Status.PASS, "Add user Test passed");
	}

	@Test(priority = 2, description = "TC_002_Verify user login with valid user credentials", enabled = true)
	public void verifyUserLoginWithValidUserCredentials() throws IOException, InterruptedException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(1, 0));
		//int value=(int) excel.getNumericCellData(1, 1);
		//String s=String.valueOf(value);  
		//System.out.println(s);
		login.enternumericPassword((int)excel.getNumericCellData(1, 1));
		home = login.clickOnLoginButton();
		home.clickOnEndTour();
		boolean actualHomeLogostatus = home.getHomePageLogoStatus();
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(actualHomeLogostatus, "Login failed");
		softassert.assertAll();
		signout = home.clickOnUserMenu();
		login = signout.clickOnSignoutButton();

	}

	@Test(priority = 3, description = "TC_003_Verify the error message displayed for user login with invalid credentials", enabled = true)
	public void verifyUserLoginWithInvalidUserCredentials() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterUsername(excel.getStringCellData(2, 0));
		login.enterPassword(excel.getStringCellData(2, 1));
		login.clickOnLoginButton();
		String actualTextStatus = login.getInvalidLoginMessage();
		String expectedTextStatus = "These credentials do not match our records.";
		Assert.assertEquals(actualTextStatus, expectedTextStatus, "Successful Login");
	}

	@Test(priority = 4, description = "TC_004_Verify User is able to click on rememeberme Checkbox", enabled = true)
	public void verifyUserAbleToClickOnRememeberMeCheckbox() throws IOException {
		login = new LoginPage(driver);
		login.clickOnRememebermeCheckbox();
		boolean checkboxStatus = login.getRemembermeStatus();
		Assert.assertTrue(checkboxStatus, "Unable to check the Rememeberme checkbox");
	}

}
