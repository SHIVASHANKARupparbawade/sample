package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Base;

public class ProductPage extends Base {

	public ProductPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath="//a[@href='/products']")
	public WebElement productlink;
	
	@FindBy(xpath="//div[@class='col-sm-4']")
	public WebElement allproducttext;
	
	@FindBy(xpath="//div[@class='productinfo text-center']")
	public List<WebElement> allproducts;
	
	@FindBy(xpath="(//a[contains(text(),'View Product')])[1]")
	public WebElement firstproduct;
	
	
	public String allproducttext()
	{
		return allproducttext.getText();
	}
	
	

}
