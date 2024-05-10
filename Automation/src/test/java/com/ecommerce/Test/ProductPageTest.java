package com.ecommerce.Test;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductPage;
import TestBase.Base;
import TestUtils.SeleniumHelper;

public class ProductPageTest extends Base {
	public LoginPage login;
	public SeleniumHelper helper;
	public ProductPage product;

	public ProductPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test(priority = 1)
	public void logintowebsitetest() throws IOException
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
	
	@Test(priority = 2)
	public void Verifyproductpagetest() throws IOException, InterruptedException
	{
		login= new LoginPage(driver);
		helper= new SeleniumHelper(driver);
		product= new ProductPage(driver);
		helper.elementclick(login.signuploginbtn);
		login.loginwithvalidcredentials("shankar1098@gmail.com", "shan198");
		helper.elementclick(login.loginbtn);
		helper.elementclick(product.productlink);
		 Thread.sleep(3000);
		helper.scrolldown(900);
	    System.out.println(product.allproducttext());
	    Assert.assertEquals(product.allproducttext(), "ALL PRODUCTS");
	    System.out.println(product.allproducts.size());
	    for(WebElement product:product.allproducts)
	    {
	    	String allproducttext= product.getText();
	    	System.out.println(allproducttext);
	    	
	    }
	    product.firstproduct.click();
	    Thread.sleep(3000);
	    
	}

}
