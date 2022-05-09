package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.Homepage;
import POM.zerodalogin;
import Pojo.Browser;
import Utility.Excel;

public class HomeTest {

	WebDriver driver;
	@BeforeMethod
	
	public void browserandsignup() throws EncryptedDocumentException, IOException
	{
		driver=Browser.openbowser("https://kite.zerodha.com/");
		
		zerodalogin Zerodalogin=new zerodalogin(driver);
		Zerodalogin.enteruser(Excel.getdata(1, 0, "cre"));
		Zerodalogin.enterpass(Excel.getdata(1, 1, "cre"));
		Zerodalogin.clicksubmit();
		Zerodalogin.enterpin(Excel.getdata(1, 2, "cre"), driver);
		Zerodalogin.presscontinue();
	}
	
	@Test
	
	public void share()
	{
		Homepage obj=new Homepage(driver);
		obj.share(driver);
		obj.buybutton();
	}
	
	@Test
	public void stocklist()
	{
		Homepage obj=new Homepage(driver);
		
		obj.selectstock(driver, "techm");
		
		obj.buybutton();
		
	}
}
