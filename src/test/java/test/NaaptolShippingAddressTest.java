package test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.NaaptolCartPage;
import pom.NaaptolHomePage;
import pom.NaaptolProductDescription;
import pom.NaaptolShippingAddress;
import pom.ResultPage;
import utility.Reports;

public class NaaptolShippingAddressTest extends BaseTest{
	
	@BeforeMethod
	public void openBrowser()
	{
		driver = LaunchBrowser.openBrowser();
	}
	
	@BeforeTest
	public void report()
	{
		reports = Reports.createReport();
	}
	
	@Test
	public void enterAllTheDetails() throws InterruptedException
	{
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductNameSearchTab("Mobiles");
		naaptolHomePage.clickOnSeachIcon();
		
		ResultPage resultPage = new ResultPage(driver);
		resultPage.addProductUsingQuickViewButtion(driver, 0);
		
		NaaptolProductDescription naaptolProductDescription = new NaaptolProductDescription(driver);
		//String productName = naaptolProductDescription.getProductName();
		
		Thread.sleep(5000);
		naaptolProductDescription.clickOnBuyButton();
		
		NaaptolCartPage naaptolCartPage = new NaaptolCartPage(driver);
		naaptolCartPage.proceedToCheckoutButton(1);
		
		
		NaaptolShippingAddress naaptolShippingAddress = new NaaptolShippingAddress(driver);
		naaptolShippingAddress.selectTitle(1);
		naaptolShippingAddress.enterFirstName("Ajay");
		naaptolShippingAddress.enterLastName("Khule");
		naaptolShippingAddress.enterAddress("Ashta");
		naaptolShippingAddress.enterLandMark("near society");
		naaptolShippingAddress.enterMobileNumber("8530531074");
		naaptolShippingAddress.enterPincode("416416");
		naaptolShippingAddress.selectState("MAHARASHTRA");
		naaptolShippingAddress.selectCity("PALUS");
		naaptolShippingAddress.enterLandLineNumber("0233");
		
		naaptolShippingAddress.clickOnAddNewAddressButton();
	}
	
	
	@AfterMethod
	public void testRsult(ITestResult result)
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
	{
		
	}
	
	
	@AfterTest
	public void publishReport()
	{
		reports.flush();
	}

}
