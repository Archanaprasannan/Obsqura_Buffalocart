package com.buffalocart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.buffalocart.utilities.PageUtility;
import com.buffalocart.utilities.TableUtility;

public class AddUsersPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public AddUsersPage(WebDriver driver) {
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
	
	private final String _email = "input#email";
	@FindBy(css = _email)
	private WebElement email;
	
	private final String _roleDropdown = "role";
	@FindBy(id = _roleDropdown)
	private WebElement roleDropdown;
	
	private final String _role = "input#email";
	@FindBy(css = _role)
	private WebElement role;
	
	private final String _username = "username";
	@FindBy(id = _username)
	private WebElement username;
	
	private final String _password = "password";
	@FindBy(id = _password)
	private WebElement password;
	
	private final String _confirmpassword = "confirm_password";
	@FindBy(id = _confirmpassword)
	private WebElement confirmPassword;
	
	private final String _salespercentage = "cmmsn_percent";
	@FindBy(id = _salespercentage)
	private WebElement salespercentage;

	private final String _save = "submit_user_button";
	@FindBy(id = _save)
	private WebElement save;
	
	public void selectRole(String role) {
		PageUtility.selectDropdownbyText(roleDropdown,role );
	}
	
	private final String _errormessage = "first_name-error";
	@FindBy(id = _errormessage)
	private WebElement errormessage;
	
	private final String _relement = "//table[@id='users_table']//tbody//tr";
	@FindBy(xpath = _relement)
	private List<WebElement> rElement;
	
	private final String _celement = "//table[@id='users_table']//tbody//tr//td";
	@FindBy(xpath = _celement)
	private List<WebElement> cElement;
	
	private final String _addUserRole = "//select[@id='role']";
	@FindBy(xpath = _addUserRole)
	private WebElement addUserRole;
	
	
	

	/*** UserActionMethods ***/

	public void enterPrefix() {
		//PageUtility.enterText(prefix, value);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String data="document.getElementById('surname').value='Mr';";
		PageUtility.enterTextToElement(js, data);
	}
	
	public void enterfirstname(String firstName) {
		PageUtility.enterText(firstname, firstName);
	}
	

	public void enterLastname(String lastName) {
		PageUtility.enterText(lastname, lastName);
	}

	public void enterEmail(String eMail) {
		PageUtility.enterText(email, eMail);
	}

	public void enteruserName(String userName) {
		PageUtility.enterText(username, userName);
	}
	
	public void enterPassword(String passWord) {
		PageUtility.enterText(password, passWord);
	}
	
	public void enterConfirmPassword(String confirmpassWord) {
		PageUtility.enterText(confirmPassword, confirmpassWord);
	}

	public void enterSalesPercentage(double percentage) {
		String s=String.valueOf(percentage);  
		PageUtility.enterText(salespercentage, s);
	}

	public UsersPage clickOnSaveButton() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script="document.getElementById('submit_user_button').click();";
		PageUtility.clickElement(js, script);
		//js.executeScript("document.getElementById('newsletter-email').value='test@gmail.com'");
		//js.executeScript("document.getElementById('newsletter-subscribe-button').click()");
	//PageUtility.clickOnElement(save);
		return new UsersPage(driver);
	}
	public String getErrorMessage()
	{
		return PageUtility.getElementText(errormessage);
	}
	public void getHardWait() throws InterruptedException {
		PageUtility.hardWait();
	}
	public String getAddUserspageTitle()
	{
		return PageUtility.getPageTitle(driver);
	}
	public List<ArrayList<String>> getTableData()
	{
		return TableUtility.gridData(rElement, cElement);
		
	}
	public List<String> getOptionsFromRoleDropdown()
	{
		Select select = new Select(addUserRole);
		List<WebElement> roles=PageUtility.getDropdownOptions(select);
		List<String> actualroles = new ArrayList<String>();
		for (int i = 0; i <roles.size(); i++) {
			actualroles.add(roles.get(i).getText());
	}
		return actualroles;
	
	
	

	}}
