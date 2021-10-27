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
	
	private final String _rElement = "//table[@id='sales_commission_agent_table']//tbody//tr";
	@FindBy(xpath = _rElement)
	private List<WebElement> salesrElement;

	private final String _cElement = "//table[@id='sales_commission_agent_table']//tbody//tr//td";
	@FindBy(xpath = _cElement)
	private List<WebElement> salescElement;
	
	private final String _salesagenttable = "//table[@id='sales_commission_agent_table']";
	@FindBy(xpath = _salesagenttable)
	private WebElement salesagenttable;
	
	private final String _salesagentEdibutton = "//table[@id='sales_commission_agent_table']//tbody//tr//td[6]//button[1]";
	@FindBy(xpath = _salesagentEdibutton)
	private WebElement salesagentEdibutton;
	
	private final String _salesagentdeletebutton = "//table[@id='sales_commission_agent_table']//tbody//tr//td[6]//button[2]";
	@FindBy(xpath = _salesagentdeletebutton)
	private WebElement salesagentdeletebutton;
	
	
	/*** UserActionMethods ***/
	public UpdateSalesCommisionAgentPage ClickonEditButton(String user) {
		List<ArrayList<WebElement>> grid=TableUtility.actionData(salesrElement, salescElement);
		System.out.println(grid);
		OUTER: for(int i=0;i<grid.size();i++)
		{
			for(int j=0;j<grid.get(0).size();j++)
			{
				String data=grid.get(i).get(j).getText();
				if(data.equals(user))
				{
					WebElement editbutton=driver.findElement(By.xpath("//table[@id='sales_commission_agent_table']//tbody//tr["+(i+1)+"]//td[6]//button[1]"));
					PageUtility.clickOnElement(editbutton);
					break OUTER;
				}
			}
		}
		return new UpdateSalesCommisionAgentPage(driver);
	}
	
	public DeleteSalesCommisionAgentPage ClickonDeleteButton(String user) {
		List<ArrayList<WebElement>> grid=TableUtility.actionData(salesrElement, salescElement);
		System.out.println(grid);
		OUTER: for(int i=0;i<grid.size();i++)
		{
			for(int j=0;j<grid.get(0).size();j++)
			{
				String data=grid.get(i).get(j).getText();
				if(data.equals(user))
				{
					WebElement deletebutton=driver.findElement(By.xpath("//table[@id='sales_commission_agent_table']//tbody//tr["+(i+1)+"]//td[6]//button[2]"));
					PageUtility.clickOnElement(deletebutton);
					break OUTER;
				}
			}
		}
		return new DeleteSalesCommisionAgentPage(driver);
	}


	public String getSalesCommisionAgentPageTitle()
	{
		return PageUtility.getPageTitle(driver);
	}
	public AddSalesCommisionAgentPage clickOnAddButton()
	{
		PageUtility.clickOnElement(addbutton);
		return new AddSalesCommisionAgentPage(driver);
	}
	public List<ArrayList<String>> getTableData() throws InterruptedException
	
	{
		PageUtility.hardWait();
		return TableUtility.gridData(salesrElement,  salescElement);
		
	}
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}
	
	public void getSoftWaitsalesagenttable()
	{
		WaitUtility.waitForelementVisibility(driver,salesagenttable,LocatorType.Xpath);
	}
	
	public void getSoftWaitEditsalesagent()
	{
		WaitUtility.waitForelementVisibility(driver,salesagentEdibutton,LocatorType.Xpath);
	}
	
	public void getSoftWaitDeletesalesagent()
	{
		WaitUtility.waitForelementTobeClickable(driver,salesagentdeletebutton,LocatorType.Xpath);
	}
	
	
}
