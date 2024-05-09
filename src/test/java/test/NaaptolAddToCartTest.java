package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.NaaptolCartPage;
import pom.NaaptolHomePage;
import pom.NaaptolProductDescription;
import pom.ResultPage;
import utility.Reports;
import utility.ScreenShot;
@Listeners (test.Listeners.class)

public class NaaptolAddToCartTest extends BaseTest {
	
	@BeforeMethod
	public void openBrowser ()
	{
		driver = LaunchBrowser.openBrowser();
	}
	
	@BeforeTest
	public void configureReports()
	{
		reports = Reports.createReport();
	}
	
	@Test
	public void addSingleProductToCartUsingQuickview() throws InterruptedException
	{
		test =reports.createTest("addSingleProductTocart");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductNameSearchTab("Mobiles");
		naaptolHomePage.clickOnSeachIcon();
		
		Thread.sleep(2000);
		ResultPage resultPage = new ResultPage(driver);
		resultPage.addProductUsingQuickViewButtion(driver, 0);
		
		NaaptolProductDescription naaptolProductDescription = new NaaptolProductDescription(driver);
		String productName = naaptolProductDescription.getProductName();
		naaptolProductDescription.clickOnBuyButton();
		
		NaaptolCartPage naaptolCartPage = new NaaptolCartPage(driver);
		
		Assert.assertEquals(naaptolCartPage.getProductTitle(0), productName);
	}
	
	@Test
	public void getProductsCountInCart() throws InterruptedException
	{

		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductNameSearchTab("Mobiles");
		naaptolHomePage.clickOnSeachIcon();
		
		ResultPage resultPage = new ResultPage(driver);
		resultPage.addProductUsingQuickViewButtion(driver, 0);
		
		Thread.sleep(2000);
		NaaptolProductDescription naaptolProductDescription = new NaaptolProductDescription(driver);
		naaptolProductDescription.clickOnBuyButton();
		
		NaaptolCartPage naaptolCartPage = new NaaptolCartPage(driver);
		int count = naaptolCartPage.getProductInCart();
		Assert.assertEquals(count, 1);
	}
	
	@Test
	public void addMultipleProductsToCartUsingQuickview() throws InterruptedException
	{
		test = reports.createTest("Add_Product_Using_Quick_View");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductNameSearchTab("Mobiles");
		naaptolHomePage.clickOnSeachIcon();
		
		Thread.sleep(2000);
		ResultPage resultPage = new ResultPage(driver);
		resultPage.addProductUsingQuickViewButtion(driver, 0);
		NaaptolProductDescription naaptolProductDescription = new NaaptolProductDescription(driver);
		naaptolProductDescription.clickOnBuyButton();
		
		NaaptolCartPage naaptolCartPage = new NaaptolCartPage(driver);
		naaptolCartPage.clickOnContinueShoppingButton();
		
		Thread.sleep(2000);
		resultPage.addProductUsingQuickViewButtion(driver,2);
		naaptolProductDescription.clickOnBuyButton();
		
		Thread.sleep(1000);
		int count = naaptolCartPage.getProductInCart();
		System.out.println(count);
		Assert.assertEquals(count , 2);

	}
	
	@Test
	public void verifyContinueShoppingFunctionalityOnCartPage()
	{
		test = reports.createTest("Verify_Continue_Shopping_Functionality");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.clickOnItemsIcon();
		
		NaaptolCartPage naaptolCartPage = new NaaptolCartPage(driver);
		naaptolCartPage.clickOnContinueShoppingButton();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.naaptol.com/");
	}
	
	@Test
	public void addSingleProduct()
	{
		test = reports.createTest("Add_Single_Product");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductNameSearchTab("Mobiles");
		naaptolHomePage.clickOnSeachIcon();
		
		ResultPage resultPage = new ResultPage(driver);
		String productName = resultPage.getProductName(0);
		resultPage.clickOnProducts(0);
		switchToWindow("Buy Bluetooth Calling Smart Watch with Neckband And Mobile Stand (SC6) Online at Best Price in India on Naaptol.com");
		String productNameOnResultPage = resultPage.getProductNameOnResultPage();
		resultPage.clickOnClickHereToBuyButton();
		Assert.assertEquals(productName, productNameOnResultPage);
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
	public void publishReport()
	{
		reports.flush();
	}
	
	
}
