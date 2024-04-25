package test;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.NaaptolHomePage;
import utility.Reports;

@Listeners (test.Listeners.class)

public class NaaptolHomePageTest extends BaseTest {
	
	@BeforeMethod
	public void launcBrowser()
	{
		driver=LaunchBrowser.openBrowser();
	}
	
	
	@BeforeTest
	public void configureReports()
	{
		reports = Reports.createReport();
	}
	
	@Test
	public void clickOnRegisterAndLoginButton() 
	{
		test =reports.createTest("Registet_Button_Functionality");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.clickOnRegisterButton();
		System.out.println(naaptolHomePage.getRegisterText());
		
	}
	
	@Test
	public void clickonTrackOrder()
	{
		test =reports.createTest("Click_On_TrackOrder");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.clickOnTrackOrderButton();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.naaptol.com/customer-support/track-order.html");		
	}
	
	@Test
	public void searchProductWithShoppingCategories() throws InterruptedException
	{
		test =reports.createTest("Search_Product_With_Shopping_Catagory");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.selectShoppingCatageriesDropDown(driver);
		Thread.sleep(2000);
		naaptolHomePage.selectSubCatageries(driver);
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.naaptol.com/shop-online/computers-peripherals.html");
	}
	
	@Test
	public void searchProductFromSearchTab()
	{
		test =reports.createTest("Search_Product_From_SearchFunctionality");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductNameSearchTab("Mobiles");
		naaptolHomePage.clickOnSeachIcon();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.naaptol.com/search.html?type=srch_catlg&kw=Mobiles");
	}
	
	@Test
	public void clickOnItemsButton()
	{
		test =reports.createTest("Cart_Functionality");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.clickOnItemsIcon();
		String cartHeading = naaptolHomePage.getCartHeadingText();
		System.out.println(cartHeading);
		Assert.assertEquals(cartHeading, "My Shopping Cart: At present, you have (0) items.");
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
