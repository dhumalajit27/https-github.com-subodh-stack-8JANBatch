package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup {

	@FindBy(xpath="//input[@id=\"user_mobile\"]")private WebElement mobilenumber;
	@FindBy(xpath="//img[@class=\"logo-img\"]")private WebElement logo;
	
	
	public Signup(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void mobilenumber(String number)
	{
		mobilenumber.sendKeys(number);
	}
	
	public String getpagetitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public boolean logodisplayed()
	{
		return logo.isDisplayed();
	}
}
