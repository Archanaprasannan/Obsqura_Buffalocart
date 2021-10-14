package com.buffalocart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utilities.PageUtility;

public class AddSalesCommisionAgentPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public AddSalesCommisionAgentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
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
	@FindBy(id = _save)
	private WebElement save;
	
	
	/*** UserActionMethods ***/
	
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
	public void enterContact(String contact)
	{
		PageUtility.enterText(contactno, contact);
	}
	
	public void enterAddress(String addres)
	{
		PageUtility.enterText(address, addres);
	}
	
	public void enterSalesPercentage(String percentage)
	{
		PageUtility.enterText(salespercentage, percentage);
	}
	
	public SalesCommisionAgentPage clickOnSaveButton()
	{
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		PageUtility.clickOnElement(save);
		return new SalesCommisionAgentPage(driver);
	}
	
	
	
	
}
