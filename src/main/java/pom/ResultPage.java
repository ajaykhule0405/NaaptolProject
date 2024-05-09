package pom;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
	
	@FindBy (xpath = "//div[@class='grid_Square ']")private List<WebElement> product;
	@FindBy (xpath = "//a[@class='bt_compare icon chat quickFancyBox']//span")private List<WebElement> quickview;
	@FindBy (xpath = "//div[@class='item_title']")private List<WebElement> productTitle;
	@FindBy (xpath = "//a[@id='cart-panel-button-0']")private WebElement clickHereToBuyButton;
	@FindBy (xpath = "//div[@class='item_title']//a")private List<WebElement> productName;
	@FindBy (xpath = "//div[@id='square_Details']//h1")private WebElement productTitlleOnResultPage;
	
	public ResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickOnProducts(int index)
	{
		product.get(index).click();
	}
	
	public void addProductUsingQuickViewButtion(WebDriver driver,int index)
	{
		Actions action = new Actions(driver);
		action.moveToElement(product.get(index));
		action.perform();
		quickview.get(index).click();
	}
	
	
	public void clickOnClickHereToBuyButton()
	{
		clickHereToBuyButton.click();
	}
	
	public String getProductNameOnResultPage()
	{
		return productTitlleOnResultPage.getText();
	}
	
	public String getProductName(int index)
	{
		return productName.get(index).getText();
	}

}
