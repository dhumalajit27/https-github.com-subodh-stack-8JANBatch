package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;

public class Homepage {
	
	@FindBy(xpath="//input[@icon=\"search\"]")private WebElement Searchtext;
	@FindBy(xpath="//span[text()='M&M']")private WebElement MandMshare;
	@FindBy(xpath="//button[@class=\"button-blue buy\"]")private WebElement Buybutton;
	@FindBy(xpath="//div[@class=\"vddl-list list-flat\"]//span//span//span[@class=\"nice-name\"]")private List<WebElement> stocks;
	public Homepage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public void share(WebDriver driver)
	{
		Actions act =new Actions(driver);
		act.moveToElement(MandMshare);
		act.perform();
	}
	
	public void buybutton()
	{
		Buybutton.click();
	}
	
	public void selectstock(WebDriver driver,String stockname) 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOf(MandMshare));
		
		for(int i=0;i<stocks.size();i++)
		{
			WebElement aa=stocks.get(i);
			
			String text=aa.getText();
			
			if(text.equalsIgnoreCase(stockname))
			{
				Actions act=new Actions(driver);
				act.moveToElement(stocks.get(i));
				act.perform();
			}
		}
	}
}
