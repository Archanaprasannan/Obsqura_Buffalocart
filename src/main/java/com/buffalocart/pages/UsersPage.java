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
	
	private final String _userstable = "//table[@id='users_table']";
	@FindBy(xpath = _userstable)
	private WebElement userstable;
	
	private final String _userslogo = "//section[@class='content-header']";
	@FindBy(xpath = _userslogo)
	private WebElement userslogo;
	
	private final String _edittable = "//table[@id='users_table']//tbody//tr//td[5]//a[1]";
	@FindBy(xpath = _edittable)
	private WebElement edittable;
	
	
	
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

	public List<ArrayList<String>> getTableData() throws InterruptedException {
		PageUtility.hardWait();
		//WaitUtility.waitForelement(driver,userstable,LocatorType.Xpath);
		return TableUtility.gridData(rElement, cElement);

	}

	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}

	public UpdateUsersPage ClickonEditButton(String user) throws InterruptedException {
		List<ArrayList<WebElement>> grid=TableUtility.actionData(rElement, cElement);
		PageUtility.hardWait();
		//WaitUtility.waitForelement(driver, userstable, LocatorType.Xpath);
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
	
	public ViewUserPage ClickonViewButton(String user) throws InterruptedException {
		List<ArrayList<WebElement>> grid=TableUtility.actionData(rElement, cElement);
		PageUtility.hardWait();
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
	public DeleteUserPage ClickonDeleteButton(String user) {
		List<ArrayList<WebElement>> grid=TableUtility.actionData(rElement, cElement);
		System.out.println(grid);
		OUTER: for(int i=0;i<grid.size();i++)
		{
			for(int j=0;j<grid.get(0).size();j++)
			{
				String data=grid.get(i).get(j).getText();
				if(data.equals(user))
				{
					WebElement deletebutton=driver.findElement(By.xpath("//table[@id='users_table']//tbody//tr["+(i+1)+"]//td[5]//button"));
					PageUtility.clickOnElement(deletebutton);
					break OUTER;
				}
			}
		}
		return new DeleteUserPage(driver);
}
	
	public void getHardwait() throws InterruptedException
	{
		PageUtility.hardWait();
	}
	
	public void getSoftWaitusertable()
	{
		WaitUtility.waitForelement(driver,userstable,LocatorType.Xpath);
	}
	public void getSoftWaitEditusertable()
	{
		WaitUtility.waitForelement(driver,edittable,LocatorType.Xpath);
	}
	public void getSoftWaitUsersLogo()
	{
		WaitUtility.waitForelement(driver,userslogo , LocatorType.Xpath);
	}
}
