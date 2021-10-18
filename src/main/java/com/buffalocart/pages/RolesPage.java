package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.TableUtility;
import com.buffalocart.utilities.WaitUtility;
import com.buffalocart.utilities.WaitUtility.LocatorType;

public class RolesPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public RolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	private final String _addbutton = "//a[@class='btn btn-block btn-primary']";
	@FindBy(xpath = _addbutton)
	private WebElement addbutton;

	private final String _editRolesbutton = "//i[@class='glyphicon glyphicon-edit']";
	@FindBy(xpath = _editRolesbutton)
	private WebElement editRolesbutton;

	private final String _rElement = "//table[@id='roles_table']//tbody//tr";
	@FindBy(xpath = _rElement)
	private List<WebElement> rElement;

	private final String _cElement = "//table[@id='roles_table']//tbody//tr//td";
	@FindBy(xpath = _cElement)
	private List<WebElement> cElement;

	/*** UserActionMethods ***/
	public String getRolesPageTitle() {
		return PageUtility.getPageTitle(driver);
	}

	public AddRolesPage clickOnAddRoles() {
		PageUtility.clickOnElement(addbutton);
		return new AddRolesPage(driver);
	}

	public UpdateRolesPage clickOnEditRolesButton() {
		PageUtility.clickOnElement(editRolesbutton);
		return new UpdateRolesPage(driver);
	}

	public List<ArrayList<String>> getTableData() throws InterruptedException {
		PageUtility.hardWait();
		return TableUtility.gridData(rElement, cElement);

	}

	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();

	}
	public void getWait() throws InterruptedException {
		WaitUtility.waitForElement(driver, _addbutton, LocatorType.Xpath);

	}
	public UpdateRolesPage ClickonEditButton(String user) throws InterruptedException {
		PageUtility.hardWait();
		List<ArrayList<WebElement>> grid=TableUtility.actionData(rElement, cElement);
		System.out.println(grid);
		OUTER: for(int i=0;i<grid.size();i++)
		{
			for(int j=0;j<grid.get(0).size();j++)
			{
				String data=grid.get(i).get(j).getText();
				if(data.equals(user))
				{
					WebElement editbutton=driver.findElement(By.xpath("//table[@id='roles_table']//tbody//tr["+(i+1)+"]//td[2]//a[1]"));
					PageUtility.clickOnElement(editbutton);
					break OUTER;
				}
			}
		}
		return new UpdateRolesPage(driver);
	}
	
	public DeleteRolesPage ClickonDeleteButton(String user) {
		List<ArrayList<WebElement>> grid=TableUtility.actionData(rElement, cElement);
		System.out.println(grid);
		OUTER: for(int i=0;i<grid.size();i++)
		{
			for(int j=0;j<grid.get(0).size();j++)
			{
				String data=grid.get(i).get(j).getText();
				if(data.equals(user))
				{
					WebElement deletebutton=driver.findElement(By.xpath("//table[@id='roles_table']//tbody//tr["+(i+1)+"]//td[2]//button"));
					PageUtility.clickOnElement(deletebutton);
					break OUTER;
				}
			}
		}
		return new DeleteRolesPage(driver);
	}
}
