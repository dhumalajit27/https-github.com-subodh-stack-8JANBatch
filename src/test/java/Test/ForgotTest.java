package Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.Forgotpassword;
import POM.zerodalogin;
import Pojo.Browser;
import Utility.Excel;

public class ForgotTest {
	WebDriver driver;
	
	@BeforeMethod
	public void openBowser()
	{
		driver=Browser.openbowser("https://kite.zerodha.com/");
	}

	@Test
	public void forgottest()
	{
		zerodalogin Zerodalogin=new zerodalogin(driver);
		Zerodalogin.clickforgot();
		Forgotpassword forgotpassword=new Forgotpassword(driver);
		forgotpassword.enterusername("ajit");
		forgotpassword.enterpassword("27");
		forgotpassword.pressreset();
	}
}
