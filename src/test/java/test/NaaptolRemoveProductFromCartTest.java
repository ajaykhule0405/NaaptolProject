package test;

import org.testng.Assert;
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
import pom.ResultPage;
import utility.Reports;

public class NaaptolRemoveProductFromCartTest extends BaseTest {
	
	@BeforeMethod
	public void openBrowser()
	{
		driver = LaunchBrowser.openBrowser();
	}
	
	@BeforeTest
	public void configureReports()
	{
		reports =Reports.createReport();
	}
	
	@Test
	public void removeProductFromCart()
	{
		test = reports.createTest("Remove_Product_From_Crat");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductNameSearchTab("Mobiles");
		naaptolHomePage.clickOnSeachIcon();
		
		ResultPage resultPage = new ResultPage(driver);
		resultPage.addProductUsingQuickViewButtion(driver, 0);
		
		NaaptolProductDescription naaptolProductDescription = new NaaptolProductDescription(driver);
		naaptolProductDescription.clickOnBuyButton();
		
		NaaptolCartPage naaptolCartPage = new NaaptolCartPage(driver);
		naaptolCartPage.clickOnRemoveButton(0);
		int productInCart = naaptolCartPage.getProductInCart()-1;
		Assert.assertEquals(productInCart, 0);
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
}
