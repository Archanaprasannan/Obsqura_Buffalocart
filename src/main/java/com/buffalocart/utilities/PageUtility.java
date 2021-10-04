package com.buffalocart.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static String getElementText(WebElement element) {
		return element.getText();
	}

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

	public void acceptAlert(WebElement element, Alert alert) {
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

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
}
