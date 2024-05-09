package TestUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.Base;

public class SeleniumHelper extends Base {
	 public WebDriver driver;
	public WebDriverWait wait;
	public Select select;
	public JavascriptExecutor js;
	public Alert alert;

	public SeleniumHelper(WebDriver driver) throws IOException {
		this.driver=driver;
		
	}
	
	public static long  pageloadtimeout=80;
	public static long  implicitlywait=90;
	
	
	
	public  void visibilityofsingleelement(WebElement element,long seconds)
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public  void switchtoframe(By locator,long seconds)
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	public  void elementclickable(By locator,long seconds)
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void selectbyindex(WebElement ele,int index)
	{
		 select= new Select(ele);
		select.selectByIndex(index);
	}
	
	public void selectbyvisibletext(WebElement dropdowns, String dropdowntext)
	{
		select= new Select(dropdowns);
		select.selectByVisibleText(dropdowntext);
	}
	
	public void selectbyvaluedropdown(WebElement dropdown,String index)
	{
		select= new Select(dropdown);
		select.selectByValue(index);
	}
	public String gettitle()
	{
		return driver.getTitle();
	}
	
	public boolean elementclick(WebElement element)
	{
		element.click();
		return true;
	}
	public void clearelement(WebElement element)
	{
		element.clear();
	}
	public void sendtexttoelement(WebElement element,String text)
	{
		element.sendKeys(text);
	}
	
	public void scrolldown(int distance)
	{
	    js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+distance+")");
		
	}
	
	public void scrolldowninelemen(WebElement element)
	{
		 js= (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void waitforalert(int seconds)
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void switchtoalert()
	{
		 alert= driver.switchTo().alert();
	}
	public void acceptallert()
	{
		alert.accept();
	}
	public void dismissalert()
	{
		alert.dismiss();
	}
	
	public String gettextofalert()
	{
		return alert.getText();
	}
	

}
