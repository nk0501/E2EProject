package Academy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base 
{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void Before() throws Exception
	{
		driver = intializeBrowser();
		log.info(" Driver is initialized");
	}
	@Test(dataProvider="getData")
	public void BasepageNavigation(String uname, String upassword) throws Exception
	{
		
		String urlname = prop.getProperty("url");
		driver.get(urlname);  
		log.info(" Directed to Home Page ");
		LandingPage lp = new LandingPage(driver);   // If you create Object, constructor is invoked in the LandingPage.
		LoginPage lp2 = lp.getLogin();             // return the object 
		                                          //LoginPage lp2 = new LoginPage(driver);
		lp2.getemail().sendKeys(uname);
		lp2.getpassword().sendKeys(upassword);
		lp2.getLogin().click(); 
		ForgotPassword lp3 = lp2.getForgot();
		lp3.getTextDetails().sendKeys("Nayan@gmail.com");
		lp3.getInstructions().click();
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		// Creating an Object data of type Object .
		
		data[0][0] = "nayan.kumar@gmail.com" ;
		data[0][1] = "%Nayan%" ;
		data[1][0] = "mili.baranwal@gmail.com" ;
		data[1][1] = "%mili%" ;
		
		return data;
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
