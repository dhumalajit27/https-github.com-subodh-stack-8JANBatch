package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.ScreenShot;

public class ListnerTest extends BaseTest implements ITestListener {
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("Started"+result.getName());
	}
	
	
	public void onTestSucess(ITestResult result)
	{
		System.out.println("Test succesful"+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		
		try {
			ScreenShot.takeshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkip(ITestResult result)
	{
		System.out.println("test skip"+result.getName());
	}
}
  