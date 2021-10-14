package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.TableUtility;

public class SalesCommisionAgentPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public SalesCommisionAgentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	
	private final String _addbutton = "//button[@class='btn btn-primary btn-modal pull-right']";
	@FindBy(xpath = _addbutton)
	private WebElement addbutton;
	
	private final String _relement = "//table[@id='users_table']//tbody//tr";
	@FindBy(xpath = _relement)
	private List<WebElement> rElement;
	
	private final String _celement = "//table[@id='users_table']//tbody//tr//td";
	@FindBy(xpath = _celement)
	private List<WebElement> cElement;
	
	
	/*** UserActionMethods ***/
	public String getSalesCommisionAgentPageTitle()
	{
		return PageUtility.getPageTitle(driver);
	}
	public AddSalesCommisionAgentPage clickOnAddButton()
	{
		PageUtility.clickOnElement(addbutton);
		return new AddSalesCommisionAgentPage(driver);
	}
	public List<ArrayList<String>> getTableData()
	{
		return TableUtility.gridData(rElement, cElement);
		
	}
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}

}
