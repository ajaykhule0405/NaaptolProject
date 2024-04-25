package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptolProductDescription {
	
	@FindBy (xpath = "//a[@id='cart-panel-button-0']")private WebElement clickHereToBuy; 
	@FindBy (xpath = "//input[@id='pincodeDeliveryId_0']")private WebElement enterPinCode;
	@FindBy (xpath = "(//a[@class='button_1'])[3]")private WebElement checkButton;
	@FindBy (xpath = "//div[@id='square_Details']//h1")private WebElement productName;
	
	public NaaptolProductDescription(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBuyButton()
	{
		clickHereToBuy.click();
	}
	
	public void enterPinCide()
	{
		enterPinCode.sendKeys();
	}
	
	public void clickOnCheckButton()
	{
		checkButton.click();
	}
	
	public String  getProductName()
	{
		return productName.getText();
	}
}
