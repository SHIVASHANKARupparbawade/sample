package ExtentReports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener implements ITestListener  {
	  private static ExtentReports extent;
	    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	    public WebDriver driver;

	    @Override
	    public void onStart(ITestContext context) {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	        htmlReporter.config().setDocumentTitle("Test Report");
	        htmlReporter.config().setReportName("Extent Reports");
	        htmlReporter.config().setTheme(Theme.STANDARD);

	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Host Name", "YourHost");
	        extent.setSystemInfo("Environment", "YourEnvironment");
	        extent.setSystemInfo("User Name", "YourName");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        if (extent != null) {
	            extent.flush();
	        }
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
	        test.set(extentTest);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.get().log(Status.PASS, "Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
	    }
	    public static void captureScreenshot(WebDriver driver) throws IOException {
	        // Convert WebDriver object to TakesScreenshot
	    	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\shivs\\git\\repository\\Automation.png"));
	    
	    
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.get().log(Status.SKIP, "Test Skipped");
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // You can add custom logic for handling this case if needed
	    }

	    @Override
	    public void onTestFailedWithTimeout(ITestResult result) {
	        onTestFailure(result);
	    }
}
