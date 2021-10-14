package com.buffalocart.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableUtility {

	public void gettable(WebDriver driver)
	{
		List<WebElement>rows=driver.findElements(By.xpath("//table[@id='users_table']//tbody//tr"));
		int rowcount=rows.size();
		
	}
}
