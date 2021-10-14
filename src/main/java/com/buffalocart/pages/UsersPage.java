package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.TableUtility;
import com.buffalocart.utilities.WaitUtility;
import com.buffalocart.utilities.WaitUtility.LocatorType;

public class UsersPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	private final String _searchbar = "//input[@class='form-control input-sm']";
	@FindBy(xpath = _searchbar)
	private WebElement searchbar;

	private final String _addbutton = "//a[@class='btn btn-block btn-primary']";
	@FindBy(xpath = _addbutton)
	private WebElement addbutton;

	private final String _deletebutton = "//i[@class='glyphicon glyphicon-trash']";
	@FindBy(xpath = _deletebutton)
	private WebElement deletebutton;

	private final String _relement = "//table[@id='users_table']//tbody//tr";
	@FindBy(xpath = _relement)
	private List<WebElement> rElement;

	private final String _celement = "//table[@id='users_table']//tbody//tr//td";
	@FindBy(xpath = _celement)
	private List<WebElement> cElement;

	/*** UserActionMethods ***/
	public String getUsersPageTitle() {
		return PageUtility.getPageTitle(driver);
	}

	public void clickOnSearchBar() {
		PageUtility.clickOnElement(searchbar);
	}

	public void enterDataToSearchBar(String value) {
		PageUtility.enterText(searchbar, value);
	}

	public AddUsersPage clickOnAddUsers() {
		PageUtility.clickOnElement(addbutton);
		return new AddUsersPage(driver);
	}

	public List<ArrayList<String>> getTableData() {
		return TableUtility.gridData(rElement, cElement);

	}

	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}

	public UpdateUsersPage ClickonEditButton(String user) {
		List<ArrayList<WebElement>> grid=TableUtility.actionData(rElement, cElement);
		System.out.println(grid);
		OUTER: for(int i=0;i<grid.size();i++)
		{
			for(int j=0;j<grid.get(0).size();j++)
			{
				String data=grid.get(i).get(j).getText();
				if(data.equals(user))
				{
					WebElement editbutton=driver.findElement(By.xpath("//table[@id='users_table']//tbody//tr["+(i+1)+"]//td[5]//a[1]"));
					PageUtility.clickOnElement(editbutton);
					break OUTER;
				}
			}
		}
		return new UpdateUsersPage(driver);
	}
	
	public ViewUserPage ClickonViewButton(String user) {
		List<ArrayList<WebElement>> grid=TableUtility.actionData(rElement, cElement);
		System.out.println(grid);
		OUTER: for(int i=0;i<grid.size();i++)
		{
			for(int j=0;j<grid.get(0).size();j++)
			{
				String data=grid.get(i).get(j).getText();
				if(data.equals(user))
				{
					WebElement viewbutton=driver.findElement(By.xpath("//table[@id='users_table']//tbody//tr["+(i+1)+"]//td[5]//a[2]"));
					PageUtility.clickOnElement(viewbutton);
					break OUTER;
				}
			}
		}
		return new ViewUserPage(driver);
	}
}
