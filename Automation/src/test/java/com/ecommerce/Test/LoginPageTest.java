package com.ecommerce.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import TestBase.Base;
import TestUtils.SeleniumHelper;

public class LoginPageTest extends Base {
	public LoginPage login;
	public SeleniumHelper helper;

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test(priority=1)
	public void validatelogintext() throws IOException
	{
		login= new LoginPage(driver);
		helper= new SeleniumHelper(driver);
		helper.elementclick(login.signuploginbtn);
		
		String logtext= login.validateloginpagetext();
		System.out.println(logtext);
		Assert.assertEquals(logtext,"Login to your account");
	}
	@Test(priority = 2)
	public void LoginUserwithcorrectemailandpassword() throws IOException
	{
		login= new LoginPage(driver);
		helper= new SeleniumHelper(driver);
		helper.elementclick(login.signuploginbtn);
		login.loginwithvalidcredentials("shankar1098@gmail.com", "shan198");
		helper.elementclick(login.loginbtn);
		String loggedintext= login.validateloggedintext();
		System.out.println(loggedintext);
		Assert.assertEquals(loggedintext, "Logged in as shankar");
	}
	@Test(priority = 3)
	public void  LoginUserwithincorrectemailandpassword() throws IOException
	{
		login= new LoginPage(driver);
		helper= new SeleniumHelper(driver);
		helper.elementclick(login.signuploginbtn);
		String logtext= login.validateloginpagetext();
		System.out.println(logtext);
		Assert.assertEquals(logtext,"Login to your account");
		login.loginwithinvalidcredentials("shankar1097@gmail.com", "shan123");
		helper.elementclick(login.loginbtn);
		String invalidtext= login.validateinvalidtext();
		System.out.println(invalidtext);
		Assert.assertEquals(invalidtext, "Your email or password is incorrect!");
	}

}
