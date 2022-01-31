package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigation extends Base
{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@Test
	public void validateNavigationBar() throws Exception
	{
		driver = intializeBrowser();
		String urlname = prop.getProperty("url");
		driver.get(urlname);
		LandingPage lp = new LandingPage(driver);
		boolean bool = lp.getNav().isDisplayed();
		Assert.assertTrue(bool);
		log.info("Navigation bar is DISPLAYED 2");
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
