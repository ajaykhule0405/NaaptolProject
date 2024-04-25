package test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.NaaptolLoginRegistration;

public class NaaptolLoginRegistrationTest extends BaseTest {
	
	@BeforeMethod
	public void openBrowser()
	{
		driver = LaunchBrowser.openBrowser();
	}
	
	@Test
	public void verifyLoginFunctionality()
	{
		test = reports.createTest("Verify_Login_Functionality");
		NaaptolLoginRegistration naaptolLoginRegistration = new NaaptolLoginRegistration(driver);
		naaptolLoginRegistration.enterMobileNumber("8530531074");
		naaptolLoginRegistration.clickOnContinueButton();
		naaptolLoginRegistration.enterOTP("203255");
		naaptolLoginRegistration.clickOnSubmitButton();
	}
	
	@AfterMethod
	public void testResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterTest
	public void publishReports()
	{
		reports.flush();
	}
	{
		
	}

}
