package Test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.Signup;
import POM.zerodalogin;
import Pojo.Browser;
import Utility.Excel;
import Utility.Reports;
@Listeners(ListnerTest.class)
public class logintest extends BaseTest {

	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeClass
	public void addtestreport()
	{
		reports=Reports.addreports();
	}
	
	
	
	
	@BeforeMethod
	public void launchBrowser() {
		
		 driver=Browser.openbowser("https://kite.zerodha.com/");
	}
	
	@Test
	public void loginwithvalidcredential() throws EncryptedDocumentException, IOException
	
	{
		test= reports.createTest("loginwithvalidcredential");
		zerodalogin Zerodalogin=new zerodalogin(driver);
		Zerodalogin.enteruser(Excel.getdata(1, 0, "cre"));
		Zerodalogin.enterpass(Excel.getdata(1, 1, "cre"));
		Zerodalogin.clicksubmit();
		Zerodalogin.enterpin(Excel.getdata(1, 2, "cre"), driver);
		Zerodalogin.presscontinue();
		Assert.assertTrue(false); 
}
	
	@Test
	
	public void checkforgot()
	{
		zerodalogin Zerodalogin=new zerodalogin(driver);
		Zerodalogin.clickforgot();
	}
	
	@Test
	public void signup()
	{
		test=reports.createTest("signup");
		zerodalogin Zerodalogin=new zerodalogin(driver);
		
		Zerodalogin.signup();
		
		ArrayList<String> list=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		Signup signup=new Signup(driver);
		String actualTitle=signup.getpagetitle(driver);
		String expectedTitle="Signup and open a Zerodha trading and demat account online and start investing – Zerodha";
		SoftAssert softassert=new SoftAssert(); 
		softassert.assertEquals(actualTitle,expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle);//hard
		Assert.assertTrue(signup.logodisplayed());//hard
		signup.mobilenumber("8879798967");
		softassert.assertAll();
	}
	
	
	@AfterMethod
	public void captureresult(ITestResult result )
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,result.getName());
		}
		else{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterClass
	public void flushresult()
	{
		reports.flush();
	}
	
	}


