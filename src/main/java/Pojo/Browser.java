package Pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

public static WebDriver openbowser(String url) {
		
		ChromeOptions option=new ChromeOptions();
		
		option.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver","E:\\JAVA\\zeroda\\src\\main\\resources\\chromedriver.exe");
		
         WebDriver driver=new ChromeDriver(option);
        // driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
         
       
         driver.get(url);
         
         driver.manage().window().maximize();
         return driver;
}
}