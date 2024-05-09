package TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import TestUtils.SeleniumHelper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static  WebDriver driver;
	public static Properties prop;
	

	
	public  Base() throws IOException
	{
		 prop= new Properties();
		 FileInputStream file= new FileInputStream("C:\\Users\\shivs\\git\\repository\\Automation\\src\\main\\java\\com\\Toolsqa\\Config\\config.properties");
		 prop.load(file);
	}
	@BeforeMethod
	public static void initalization()
	{
		
		
		String browsername= prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}
		else if(browsername.equals("firefox"))
		  {
			  WebDriverManager.firefoxdriver().setup();
			  driver= new FirefoxDriver();
		  }
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(SeleniumHelper.pageloadtimeout));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SeleniumHelper.implicitlywait));
		  driver.get(prop.getProperty("url"));
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

	
	
	
	
	

}
