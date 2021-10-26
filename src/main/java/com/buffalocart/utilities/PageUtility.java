package com.buffalocart.utilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void clickOnElement(WebElement element) {
		element.click();
	}
	
	public static void clickElement(JavascriptExecutor js,String script) {
		js.executeScript(script);
	}
	public static int getSizeOfElement(List<WebElement>element) {
		return element.size();
	}

	public static void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}
	public static void enterNumericText(WebElement element, long value) {
		String s=String.valueOf(value);
		element.sendKeys(s);
	}
	
	public static void enterTextToElement(JavascriptExecutor js,String value) {
		js.executeScript(value);
	}
	
	public static void clickOnsaveButton(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	
	public static List<WebElement> getDropdownOptions(Select select) {
		return select.getOptions();
	}
	public static void hardWait() throws InterruptedException
	{
		Thread.sleep(30000);
	}

	public static String getElementText(WebElement element) {
		return element.getText();
	}
	
	/*public static String getDateElementText(Date date) {
		return ((Alert) date).getText();
	}*/

	public String getAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public void moveToElement(WebElement element, Actions action) {
		action.moveToElement(element);
	}

	public void doubleClickOnElement(WebElement element, Actions action) {
		action.doubleClick(element);
	}

	public void rightClickOnElement(WebElement element, Actions action) {
		action.contextClick(element);
	}

	public void selectDropdownOption(String element, Select select) {
		select.selectByValue(element);
	}

	public void dragAndDrop(WebElement source, WebElement target, Actions action) {
		action.dragAndDrop(source, target);
	}

	public void clickAndHold(WebElement element, Actions action) {
		action.clickAndHold(element);
	}

	public static void acceptAlert(Alert alert) {
		alert.accept();
	}

	public void dismissAlert(WebElement element, Alert alert) {
		alert.dismiss();
	}

	public void enterTextOnAlert(WebElement element, Alert alert, String text) {
		alert.sendKeys(text);
	}

	public String getAlertText(Alert alert) {
		return alert.getText();
	}

	public String multipleWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public void checkBox(WebElement element) {
		element.click();
	}

	public static boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public static boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public static void selectDropdownbyText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	

}
