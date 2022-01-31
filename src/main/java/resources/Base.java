package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base 
{
	public  WebDriver driver;
	public  Properties prop;
	public  WebDriver  intializeBrowser() throws Exception
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	    prop = new Properties();
	    prop.load(fis);
	    String browserName = prop.getProperty("browser");
	    
	    ChromeOptions options= new ChromeOptions();
	    options.setBinary(path)
	    
// Above line is commented because we are trying to invoke browser from mvn command directly . See below lines of code.
	    
	    // mvn test -Dbrowser=chrome ;
	    //String browserName = System.getProperty("browser");  // to run the command from cmd using mvn command .
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Chrome90\\chromedriver.exe");
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("headless");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
		}
		else if(browserName.equals("firefox"))
		{
			// initial firefox
		}
		else if(browserName.equals("Internet Explorer"))
		{
			// Initialize IE
		}
		
driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
return driver;
	}
	public String getScreenshot(String testCaseName,WebDriver driver) throws Exception
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationfile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(src, new File(destinationfile));
		return destinationfile;
	}

}
