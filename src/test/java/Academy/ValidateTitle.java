package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base 
{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage lp;
	@BeforeTest
	public void initialize() throws Exception
	{
		driver = intializeBrowser(); 
		log.info("Driver is initialized");
		String urlname = prop.getProperty("url");
		driver.get(urlname);
		log.info("Navigated to the desired url");
	}
	
	@Test
	public void TitlePage() throws Exception
	{
		lp = new LandingPage(driver);
		String expected = lp.getTitle().getText();
		Assert.assertEquals(expected, "FEATURED COURSES");
		log.info("Successfully validated the content");
	}
	@Test
	public void validateHeader()
	{
		String expected2 = lp.getHeader().getText();
		Assert.assertNotSame(expected2, "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
