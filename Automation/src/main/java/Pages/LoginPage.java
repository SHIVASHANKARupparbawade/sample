package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Base;

public class LoginPage extends Base {

	public LoginPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h2[normalize-space()='Login to your account']")
	public WebElement loginpagetext;
	
	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	public WebElement signuploginbtn;
	
	@FindBy(name="email")
	public WebElement loginemail;
	
	@FindBy(name="password")
	public WebElement loginpassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	public WebElement loginbtn;
	
	@FindBy(xpath="//div//li//a[contains(text(),'Logged in as')]")
	public WebElement afterlogintext;
	
	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']")
	public WebElement invalidlogintext;
	
	public void loginwithvalidcredentials(String email,String pass)
	{
		loginemail.sendKeys(email);
		loginpassword.sendKeys(pass);
		
	}
	public String validateloginpagetext()
	{
		return loginpagetext.getText();
	}
	public String validateloggedintext()
	{
		return afterlogintext.getText();
	}
	public void loginwithinvalidcredentials(String email,String pass)
	{
		loginemail.clear();
		loginemail.sendKeys(email);
		loginpassword.clear();
		loginpassword.sendKeys(pass);
		
	}
	public String validateinvalidtext()
	{
		return invalidlogintext.getText();
	}
	
	
	

}
