package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
  public WebDriver driver;
  
 private By signin = By.cssSelector("a[href*='sign_in']");  // create Object first
 private By title = By.cssSelector("div[class='text-center']");
 private By navbar = By.cssSelector("ul[class='nav navbar-nav navbar-right']");
 private By header = By.cssSelector("div[class*='video-banner'] h3");
  
  public LandingPage(WebDriver driver) 
  {
	this.driver = driver;               
  }

public LoginPage getLogin()
  {
	  //return driver.findElement(signin);  // Create it's method.
	driver.findElement(signin).click();
	LoginPage lp2 = new LoginPage(driver);  // you can also write --> return new LoginPage(driver)
	return lp2;
  }
public WebElement getTitle()
{
	return driver.findElement(title);
}

public WebElement getNav()
{
	return driver.findElement(navbar);
}
public WebElement getHeader()
{
	return driver.findElement(header);
}
}
