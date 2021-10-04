package com.buffalocart.automationcore;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.buffalocart.constants.Constants;
import com.buffalocart.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	public static Properties properties;
	FileReader f;
	public Base()  {
		
		try {
			f = new FileReader(System.getProperty("user.dir") +Constants.CONFIG_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		properties = new Properties();
		try {
			properties.load(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testInitialize(String browserName, String url) throws Exception {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else {
			throw new Exception("Invalid Browser Name");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(WaitUtility.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		driver.get(url);

	}

	@BeforeMethod
		public void setUp() throws Exception {
			String browsername = properties.getProperty("browser");
			String url = properties.getProperty("url");
			testInitialize(browsername, url);
		}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		driver.close();
	}
	
}
