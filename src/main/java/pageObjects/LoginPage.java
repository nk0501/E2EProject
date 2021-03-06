package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	public WebDriver driver;
	
	By email = By.id("user_email");
	By password = By.id("user_password");
	By login = By.cssSelector("input[type='submit']");
	By forgotpass = By.cssSelector("a[href*='password/new']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver =driver; 
	}

	public WebElement getemail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public ForgotPassword getForgot()
	{
		driver.findElement(forgotpass).click();
		ForgotPassword lp3 = new ForgotPassword(driver);
		return lp3;
	}
	

}
