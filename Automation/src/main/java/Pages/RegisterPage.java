package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Base;
import TestUtils.SeleniumHelper;

public class RegisterPage extends Base {
	
	public SeleniumHelper helper;

	public RegisterPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	public WebElement signuploginbtn;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	public WebElement signupname;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	public WebElement signupmail;
	
	@FindBy(xpath="//button[normalize-space()='Signup']")
	public WebElement signupbtn;
	
	@FindBy(id="id_gender1")
	public WebElement radiobtn;
	
	@FindBy(id="password")
	public WebElement passwordfield;
	
	@FindBy(id="days")
	public WebElement daysdropdown;
	
	@FindBy(id="months")
	public WebElement monthsdropdown;
	@FindBy(id="years")
	public WebElement yearsdropdown;
	
	@FindBy(id="newsletter")
	public WebElement newslettercheckbox;
	
	@FindBy(id="optin")
	public WebElement optioncheckbox;
	
	@FindBy(id="first_name")
	public WebElement firstnamefield;
	
	@FindBy(id="last_name")
	public WebElement lastnamefield;
	
	@FindBy(id="company")
	public WebElement companyfield;
	
	@FindBy(id="address1")
	public WebElement address1field;
	
	@FindBy(id="address2")
	public WebElement address2field;
	
	@FindBy(id="country")
	public WebElement countrydropdown;
	
	@FindBy(id="state")
	public WebElement statefield;
	@FindBy(id="city")
	public WebElement cityfield;
	@FindBy(id="zipcode")
	public WebElement zipcodefield;
	@FindBy(id="mobile_number")
	public WebElement mobilenumberfield;
	
	@FindBy(xpath="//button[normalize-space()='Create Account']")
	public WebElement createaccountbtn;
	
	@FindBy(xpath="//b[normalize-space()='Account Created!']")
	public WebElement accounttext;
	public void validateaddressinformation(String fname,String lname,String comapny,String add1,String add2)
	{
		firstnamefield.sendKeys(fname);
		lastnamefield.sendKeys(lname);
		companyfield.sendKeys(comapny);
		address1field.sendKeys(add1);
		address2field.sendKeys(add2);
	}
	
	public void secondaddressinformation(String state,String city,String zipcode,String mobilenumber)
	{
		statefield.sendKeys(state);
		cityfield.sendKeys(city);
		zipcodefield.sendKeys(zipcode);
		mobilenumberfield.sendKeys(mobilenumber);
	}
	public String validateaccountcreatedtext()
	{
		return accounttext.getText();
	}
	
	
	

}
