package com.buffalocart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.WaitUtility;
import com.buffalocart.utilities.WaitUtility.LocatorType;

public class AddSalesCommisionAgentPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public AddSalesCommisionAgentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	
	private final String _sales = "//form[@id='sale_commission_agent_form']";
	@FindBy(xpath = _sales)
	private WebElement sales;
	
	private final String _prefix = "surname";
	@FindBy(id = _prefix)
	private WebElement prefix;
	
	private final String _firstname = "first_name";
	@FindBy(id = _firstname)
	private WebElement firstname;
	
	private final String _lastname = "last_name";
	@FindBy(id = _lastname)
	private WebElement lastname;
	
	private final String _email = "email";
	@FindBy(id = _email)
	private WebElement email;
	
	private final String _contactno = "contact_no";
	@FindBy(id = _contactno)
	private WebElement contactno;
	
	private final String _address = "address";
	@FindBy(id = _address)
	private WebElement address;
	
	private final String _percentage = "cmmsn_percent";
	@FindBy(id = _percentage)
	private WebElement salespercentage;
	
	
	private final String _save = "//button[@class='btn btn-primary']";
	@FindBy(xpath = _save)
	private WebElement save;
	
	
	/*** UserActionMethods ***/
	
	public void clickOnWindow()
	{
		PageUtility.clickOnElement(sales);
	}
	public void enterPrefix(String prefixvalue)
	{
		PageUtility.enterText(prefix, prefixvalue);
	}
	public void enterFirstname(String firstName)
	{
		PageUtility.enterText(firstname, firstName);
	}
	public void enterLastname(String lastName)
	{
		PageUtility.enterText(lastname, lastName);
	}
	public void enterEmail(String eMail)
	{
		PageUtility.enterText(email, eMail);
	}
	public void enterContact(double contact)
	{
		long l = (new Double(contact)).longValue();
		PageUtility.enterNumericText(contactno, l);
	}
	
	public void enterAddress(String addres)
	{
		PageUtility.enterText(address, addres);
	}
	
	public void enterSalesPercentage(double percentage)
	
	{
		String s=String.valueOf(percentage);
		PageUtility.enterText(salespercentage, s);
	}
	
	public SalesCommisionAgentPage clickOnSaveButton()
	{
		PageUtility.clickOnElement(save);
		return new SalesCommisionAgentPage(driver);
	}
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}
	
	public void getSoftWait() throws InterruptedException {
	WaitUtility.waitForElement(driver, sales.getText(), LocatorType.Xpath);
	}
	
	
	
}
