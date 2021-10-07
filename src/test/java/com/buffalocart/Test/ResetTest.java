package com.buffalocart.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.ResetPage;
import com.buffalocart.utilities.ExcelUtility;

public class ResetTest extends Base {
	LoginPage login;
	ResetPage reset;
	ExcelUtility excel;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;

	@Test(priority = 5, description = "TC_005_Verify error meesage displyed on  Reset Password page with invalid email id", enabled = true)
	public void VerifyErrorMessageDisplyedOnResetpasswordWithInvalidEmailId() throws IOException {
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		reset = login.clickOnForgotPasswordButton();
		reset.enterEmail(excel.getStringCellData(2, 0));
		reset.clickOnResetLinkButton();
		String actualErrorMessage = reset.getErrorMessage();
		String expectedErrorMessage = "We can't find a user with that e-mail address.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "invalid error message");
	}
}
