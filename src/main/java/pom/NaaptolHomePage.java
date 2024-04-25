package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NaaptolHomePage {
	
	@FindBy (xpath = "//a[@id='login-panel-link']")private WebElement registerLoginButton;
	@FindBy (xpath = "//a[text()='Track Order']")private WebElement trackOrder;
	@FindBy (xpath = "//select[@id='localization_dropdown']")private WebElement languageDropDown;
	@FindBy (xpath = "//div[@class='cate_head']")private WebElement shoppingCatagories;
	@FindBy (xpath = "//input[@id='header_search_text']")private WebElement searchTab;
	@FindBy (xpath = "(//a[@href='javascript:autoSuggestion.headerSearch()'])[2]")private WebElement searchIcon;
	@FindBy (xpath = "(//a[@id='cart-panel-link'])[2]")private WebElement items;
	@FindBy (xpath = "(//p[@class='heading']")private WebElement registerText;
	@FindBy (xpath = "//h1[text()='My Shopping Cart: ']")private WebElement cartHeading;
	@FindBy (xpath = "//div[@id='mainMenuContent']//div")private List<WebElement> catagories;
	@FindBy (xpath = "(//span[@class='catIconMenu computers'])[1]")private WebElement subCatagories;
	
	public NaaptolHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnRegisterButton()
	{
		registerLoginButton.click();
	}
	
	public void clickOnTrackOrderButton()
	{
		trackOrder.click();
	}
	
	public void selectLanguageDropDowm(int index)
	{
		Select select = new Select(languageDropDown);
		select.selectByIndex(index);
	}
	
	public void selectShoppingCatageriesDropDown(WebDriver driver)
	{
		//shoppingCatagories.get(index).click();
		Actions action = new Actions(driver);
		action.moveToElement(shoppingCatagories);
		action.perform();
		
	}
	
	public void selectSubCatageries(WebDriver driver)
	{

        Actions action = new Actions(driver);
		action.moveToElement(subCatagories);
		action.click();
		action.perform();
		//subCatagories.click();
	}
	
	public void enterProductNameSearchTab(String values)
	{
		 searchTab.sendKeys(values);
	}
	
	public void clickOnSeachIcon()
	{
		searchIcon.click();
	}
	
	public void clickOnItemsIcon()
	{
		items.click();
	}
	
	public String getRegisterText()
	
	{
		return registerText.getText();
	}
	
	public String getCartHeadingText()
	{
		return cartHeading.getText();
	}
	
	
	

}
