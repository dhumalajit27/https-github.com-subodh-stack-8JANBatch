package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	
	public static ExtentReports addreports() {
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("ajit.html");
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(htmlreport);
		reports.setSystemInfo("Env", "SIT");
		reports.setSystemInfo("testing", "functional");
		return reports;
	}
}
