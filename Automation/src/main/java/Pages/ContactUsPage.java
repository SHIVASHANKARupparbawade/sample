package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Base;

public class ContactUsPage extends Base {

	public ContactUsPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[normalize-space()='Contact us']")
	public WebElement contactuslink;
	
	
	
	@FindBy(xpath="//h2[normalize-space()='Get In Touch']")
	public WebElement contactustext;
	
	@FindBy(name="name")
	public WebElement contactname;
	@FindBy(name="email")
	public WebElement contactemail;
	@FindBy(name="subject")
	public WebElement contactsubject;
	@FindBy(name="message")
	public WebElement contactmessage;
	
	@FindBy(name="upload_file")
	public WebElement contactupload;
	
	@FindBy(name="submit")
	public WebElement submit;
	
	@FindBy(xpath="//div[@class='status alert alert-success']")
	public WebElement contactsuccessmsg;
	
	public void validatecontactform(String cname,String cemail,String csubject,String cmessage,String path)
	{
		contactname.sendKeys(cname);
		contactemail.sendKeys(cemail);
		contactsubject.sendKeys(csubject);
		contactmessage.sendKeys(cmessage);
		contactupload.sendKeys(path);
		
	}
	public String validatecontacttext()
	{
		return contactustext.getText();
	}
	
	public String validatecontactsucessmessage()
	{
		return contactsuccessmsg.getText();
	}
	

}
