package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
	public static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		
		String pathname = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(pathname);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Testing Results");
		
	    extent = new ExtentReports();
	    extent.attachReporter(reporter);
	    extent.setSystemInfo("Tester","Nayan Kumar");
	    return extent;
	}

}
