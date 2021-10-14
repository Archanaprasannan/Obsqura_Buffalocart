package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ViewUserPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public ViewUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	/*** UserActionMethods ***/
}
