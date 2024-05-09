package com.ecommerce.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.RegisterPage;
import TestBase.Base;
import TestUtils.SeleniumHelper;

public class RegisterPageTest extends Base {
	public RegisterPage register;
	public SeleniumHelper helper;

	public RegisterPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test(priority = 1)
	public void validatetitle() throws IOException
	{
		 helper= new SeleniumHelper(driver);
		 register= new RegisterPage(driver);
		String hometitle= helper.gettitle();
		System.out.println(hometitle);
		Assert.assertEquals(hometitle, "Automation Exercise");
	}
	
	@Test(priority = 2)
	public void validateregisterpage() throws InterruptedException, IOException
	{
		 helper= new SeleniumHelper(driver);
		 register= new RegisterPage(driver);
		helper.elementclick(register.signuploginbtn);
		Thread.sleep(3000);
		helper.sendtexttoelement(register.signupname, "shankar");
		helper.sendtexttoelement(register.signupmail, "shankar1098@gmail.com");
		helper.elementclick(register.signupbtn);
		helper.elementclick(register.radiobtn);
		helper.sendtexttoelement(register.passwordfield, "shan198");
		helper.selectbyvaluedropdown(register.daysdropdown, "10");
		helper.selectbyvisibletext(register.monthsdropdown, "January");
		helper.selectbyvaluedropdown(register.yearsdropdown, "1996");
		helper.scrolldown(500);
		boolean a= helper.elementclick(register.newslettercheckbox);
		Assert.assertEquals(a, true);
		boolean b= helper.elementclick(register.optioncheckbox);
		Assert.assertEquals(a, true);
		register.validateaddressinformation("shiva", "xyz", "abc", "bangalore", "hyderabad");
		helper.selectbyvisibletext(register.countrydropdown, "India");
		register.secondaddressinformation("maharastra", "latur", "413517", "345678908");
		helper.scrolldowninelemen(register.createaccountbtn);
		helper.elementclick(register.createaccountbtn);
		String acctext= register.validateaccountcreatedtext();
		System.out.println(acctext);
		Assert.assertEquals(acctext, "ACCOUNT CREATED!");
		
	}

}
