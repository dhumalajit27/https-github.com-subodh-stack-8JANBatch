package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;


public class zerodalogin {

	
	@FindBy(xpath="//input[@id='userid']")private WebElement username;
	@FindBy(xpath="//input[@id=\"password\"]")private WebElement password;
	@FindBy(xpath="//button[@type=\"submit\"]")private WebElement click;
	@FindBy(xpath="//a[text()=\"Forgot user ID or password?\"]")private WebElement forgot;
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signup;
	@FindBy(xpath="//input[@id=\"pin\"]")private WebElement pinnumber;
	@FindBy(xpath="//button[@type=\"submit\"]")private WebElement continueto;
	
	public zerodalogin(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void enteruser(String user)
	{
		username.sendKeys(user);
	}
	
	public void enterpass(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clicksubmit()
	{
		click.click();
	}
	
	public void clickforgot()
	{
		forgot.click();
	}

	public void enterpin(String pin,WebDriver driver)
	{
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
		//WebElement w=wait.until(ExpectedConditions.visibilityOf(pinnumber));
		
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(3000));
		wait.pollingEvery(Duration.ofMillis(100));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(pinnumber));
		pinnumber.sendKeys(pin );
	} 
	
	public void presscontinue()
	{
		continueto.click();
	}
	
	public void signup()
	{
		signup.click();
	}
}


