package com.ecommerce.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContactUsPage;
import TestBase.Base;
import TestUtils.SeleniumHelper;

public class ContactusPageTest extends Base {
	public ContactUsPage contact;
	public SeleniumHelper helper;
	

	public ContactusPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test(priority = 1)
	public void clickoncontactus() throws IOException, InterruptedException
	{
		contact= new ContactUsPage(driver);
		helper= new SeleniumHelper(driver);
		helper.elementclick(contact.contactuslink);
		
		System.out.println(contact.validatecontacttext());
		Assert.assertEquals(contact.validatecontacttext(), "GET IN TOUCH");
		contact.validatecontactform("shiva", "shankar1098@gmail.com", "message", "validmessage", "C:\\Users\\shivs\\OneDrive\\Documents\\Screenshot (198).png");
		helper.scrolldowninelemen(contact.submit);
		helper.elementclick(contact.submit);
		Thread.sleep(3000);
		
		helper.switchtoalert();
		Thread.sleep(3000);
		String alerttext= helper.gettextofalert();
		System.out.println(alerttext);
		helper.acceptallert();
		
		System.out.println(contact.validatecontactsucessmessage());
		
		
	}

}
