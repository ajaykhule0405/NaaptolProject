package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	
	public void switchToWindow(String expectedTitle)
	{
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterate = handles.iterator();
		while(iterate.hasNext())
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			
			String handle = iterate.next();
			driver.switchTo().window(handle);
			if(driver.getTitle().equals(expectedTitle))
			{
				break;
			}
		}
	}

}
