package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NaaptolTrackOrder {
	
	@FindBy (xpath = "//section[@id='static_Data']//h2")private WebElement trackOrderPageHeadingtext;
	@FindBy (xpath = "//input[@id='orderId']")private WebElement orderId;
	@FindBy (xpath = "//input[@id='mobileNumber']")private WebElement mobileNumber;
	@FindBy (xpath = "//input[@id='emailId']")private WebElement emailId;
	@FindBy (xpath = "//a[@id='trackOrderSubmit']")private WebElement submitButton;
	@FindBy (xpath = "//a[@id='clearFormId']")private WebElement clearButton;
	@FindBy (xpath = "(//div[@class='staticContent']//a)[1]")private WebElement feedbackOption;
	@FindBy (xpath = "(//div[@class='staticContent']//a)[2]")private WebElement contactUsOption;

	

}
