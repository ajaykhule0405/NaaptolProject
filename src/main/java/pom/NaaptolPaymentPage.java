package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptolPaymentPage {
	
	@FindBy (xpath = "//label[@for='Cash On Delivery_radiobtn']")private WebElement cashOnDelivery;
	@FindBy (xpath = "//label[@for='UPI_radiobtn']")private WebElement upipayment;
	@FindBy (xpath = "//label[@for='Net Banking_radiobtn']")private WebElement netBanking;
	@FindBy (xpath = "//label[@for='Credit Card_radiobtn']")private WebElement creditCard;
	@FindBy (xpath = "//label[@for='Debit Card_radiobtn']")private WebElement debitCard;
	@FindBy (xpath = "//label[@for='Cash Card / Mobile Wallet_radiobtn']")private WebElement mobileWallet;
	@FindBy (xpath = "//input[@id='terms-condition-panel']")private WebElement inputCheckBox;
	@FindBy (xpath = "//a[@class='red_button_normal']")private WebElement clickHereToPlaceOrder;

	public NaaptolPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectCashOnDelivery()
	{
		cashOnDelivery.click();
	}
	
	public void selectUPIPayment()
	{
		upipayment.click();
	}
	
	public void selectNetBanking()
	{
		netBanking.click();
	}
	
	public void selectCreditCard()
	{
		creditCard.clear();
	}
	
	public void selectDebitCard()
	{
		debitCard.click();
	}
	
	public void sekectMobileWallet()
	{
		mobileWallet.click();
	}
	
	public void clickOnInoutCheckBox()
	{
		inputCheckBox.click();
	}
	
	public void clickOnPlaceOrder()
	{
		clickHereToPlaceOrder.click();
	}

	
}
