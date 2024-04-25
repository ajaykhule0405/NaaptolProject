package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports createReport()
	{
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("extentreport.html");
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Testing", "Regression");
		extentReports.setSystemInfo("Created By", "Ajay");
		
		return extentReports;
		
	}

}
