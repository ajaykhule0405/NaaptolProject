package pom;

import java.util.List;

import org.checkerframework.checker.index.qual.SubstringIndexBottom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptolCartPage {
	
	@FindBy (xpath = "//a[@class='link_Continue']")private WebElement continueShopping;
	@FindBy (xpath = "//a[text()='Proceed to Checkout']")private List<WebElement> proceedToChechout;
	@FindBy (xpath = "//div[@id='cartItems']//h2")private List<WebElement> productTitle;
	@FindBy (xpath = "//div[@id='cartItems']//ul")private List<WebElement> productCount;
	@FindBy (xpath = "(//ul[@id='cartTotal']//li)[1]")private WebElement cartAmount;
	@FindBy (xpath = "//li[@class='totalCart']")private WebElement cartTotalAmount;
	@FindBy (xpath = "(//ul[@id='cartTotal']//li)[2]")private WebElement voucherAmount;
	@FindBy (xpath = "//input[@id='cvName']")private WebElement voucherCodeSearchBox;
	@FindBy (xpath = "//a[@id='cvApplybtn']")private WebElement applyButton;
	@FindBy (xpath = "//a[text()='Remove']")private List<WebElement> removeButton;
	@FindBy (xpath = "//span[contains(text(),'You have No Items in Cart !!! ')]")private WebElement cartText;
	
	
	public NaaptolCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String  getProductTitle(int index)
	{
		return productTitle.get(index).getText();
	}
	
	public int  getProductInCart()
	{
		return productCount.size();
	}
	
	public void clickOnContinueShoppingButton()
	{
		continueShopping.click();
	}
	
	public void proceedToCheckoutButton(int index)
	{
		proceedToChechout.get(index).click();
	}
	
	public double getCartAmount()
	{
		String amount =cartAmount.getText();
		String data = amount.substring(12);
		double currentAmount= Double.parseDouble(data);
		return currentAmount;
	}
	
	public double getVoucherAmount()
	{
		String amount = voucherAmount.getText();
		String data = amount.substring(28);
		double totalVoucherAmount = Double.parseDouble(data);
		return totalVoucherAmount;
	}

	public double getTotalAmountOfCart()
	{
		String amount = cartTotalAmount.getText();
		String data = amount.substring(14);
		double totalAmount = Double.parseDouble(data);
		return totalAmount;
	}
	
	public void enterVoucherCode(String code)
	{
		voucherCodeSearchBox.sendKeys(code);
	}
	
	public void clickOnApplyButton()
	{
		applyButton.click();
	}
	
	public void clickOnRemoveButton(int index)
	{
		removeButton.get(index).click();
	}
	
	public String getEmptyCartText()
	{
		return cartText.getText();
	}
}
