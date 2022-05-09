package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgotpassword {
	
	@FindBy(xpath="//input[@placeholder=\"User ID\"]")private WebElement username;
	@FindBy(xpath="//input[@placeholder=\"PAN\"]")private WebElement password;
	@FindBy(xpath="//label[@for=\"radio-55\"]")private WebElement rememberuserid;
	@FindBy(xpath="//label[@for=\"radio-56\"]")private WebElement forgotuserid;
	@FindBy(xpath="//label[@for=\"radio-60\"]")private WebElement receiveonemail;
	@FindBy(xpath="//label[@for=\"radio-61\"]")private WebElement receiveonsms;
	@FindBy(xpath="//button[@type=\"submit\"]")private WebElement reset;
	
	public Forgotpassword(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterusername(String user)
	{
		username.sendKeys(user);
	}
	
	public void enterpassword(String pass)
	{
		password.sendKeys(pass);
	}

	public void pressreset()
	{
		reset.click();
	}
}
