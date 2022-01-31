package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword 
{
	public WebDriver driver;
	By textdetails = By.id("user_email");
	By sendinstructions = By.cssSelector("input[type='submit']");
	
	public ForgotPassword(WebDriver driver) 
	{
		this.driver = driver;
	}

	public WebElement getTextDetails()
	{
		 return driver.findElement(textdetails);
	}
	
	public WebElement getInstructions()
	{
		return driver.findElement(sendinstructions);
	}

	
}
