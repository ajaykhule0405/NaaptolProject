package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptolLoginRegistration {
	
	@FindBy (xpath = "//input[@id='registration-basic-panel-mobile']")private WebElement mobileNumber;
	@FindBy (xpath = "//input[@id='registration-basic-panel-submit']")private WebElement continueButton;
	@FindBy (xpath = "//input[@id='registration-otp-panel-otp']")private WebElement otp;
	@FindBy (xpath = "//input[@id='registration-otp-panel-submit']")private WebElement submitButton;
	
	public NaaptolLoginRegistration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobileNumber(String number)
	{
		mobileNumber.sendKeys(number);
	}
	
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	
	public void enterOTP(String otpNumber)
	{
		otp.sendKeys(otpNumber);
	}
	
	public void clickOnSubmitButton()
	{
		submitButton.click();
	}
	
	
}
