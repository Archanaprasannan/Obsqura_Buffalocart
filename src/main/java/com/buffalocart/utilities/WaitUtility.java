package com.buffalocart.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long PAGE_LOAD_WAIT = 100;
	public static final long EXPLICIT_WAIT = 70;
	public static final long IMPLICIT_WAIT = 20;
	public static final long FLUENT_WAIT = 20;

	public enum LocatorType {
		Id, Xpath, Cssselector, Name, Classname, Tagname, Linktext, Partiallinktext
	}

	public static void waitForElement(WebDriver driver, String target, Enum locatortype) {
		WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(EXPLICIT_WAIT));
		if (locatortype.equals(LocatorType.Id)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
		} else if (locatortype.equals(LocatorType.Xpath)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(target)));
		}else if (locatortype.equals(LocatorType.Cssselector)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(target)));
		}else if (locatortype.equals(LocatorType.Name)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(target)));
		}else if (locatortype.equals(LocatorType.Classname)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(target)));
		}else if (locatortype.equals(LocatorType.Tagname)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(target)));
		}else if (locatortype.equals(LocatorType.Linktext)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(target)));
		}else if (locatortype.equals(LocatorType.Partiallinktext)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(target)));
		}
	}
	public static void waitForelement(WebDriver driver, WebElement target, Enum locatortype) {
		WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(EXPLICIT_WAIT));
		
			wait.until(ExpectedConditions.visibilityOf(target));

		//else if (locatortype.equals(LocatorType.Xpath)) {
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(target.getText())));
			//wait.until(ExpectedConditions.visibilityOf(target));
			
}
		
	}

