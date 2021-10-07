package com.buffalocart.extentreport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport {
	public ExtentReports extent;
	public ExtentTest extentTest;
	

	@BeforeTest
	public void setExtentReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "//test-output//ExtentReport.html", true);
		extentTest = extent.startTest("verifyHomeTitle");
		extent.addSystemInfo("Host Name", "Demo Automation");
		extent.addSystemInfo("Environment", "Automation Testing");

	}

	@AfterTest
	public void endReport() {
		// close the connection
		extent.flush();
		// release the extent reference
		//extent.close();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

}
