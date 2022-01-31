package Academy;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener
{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
    WebDriver driver =null;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());	// create an entry and store it in the test which we are using later on.
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) 
	{
		extentTest.get().log(Status.PASS,"Test Passed");
		//test.log(Status.PASS,"Test Passed");	This line is replaced by above .
	}

	public void onTestFailure(ITestResult result) 
	{
		extentTest.get().fail(result.getThrowable());
		String testMethodName = result.getMethod().getMethodName(); // to know the method which got failed.
		
		// To access the fields of the class inside which the method got failed, we need to use the below one time statement . 
		//Here field is "driver".
		
		try 
		{
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch(Exception e)
		{
			
		}
		try 
		{
			extentTest.get().addScreenCaptureFromPath(getScreenshot(testMethodName,driver), testMethodName);
			//getScreenshot(testMethodName,driver);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}                              // call the method from the base class to capture the screenshot.
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context)
	{
		extent.flush();	
	}

}
