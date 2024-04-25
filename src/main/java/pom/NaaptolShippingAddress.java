package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NaaptolShippingAddress {
	
	@FindBy (xpath = "//a[text()='Step 1: Select Shipping Address']")private WebElement step1;
	@FindBy (xpath = "//select[@id='fktitle_id']")private WebElement title;
	@FindBy (xpath = "//input[@id='firstName']")private WebElement firstName; 
	@FindBy (xpath = "//input[@id='lastName']")private WebElement lastName;
	@FindBy (xpath = "//textarea[@id='address']")private WebElement address;
	@FindBy (xpath = "//input[@id='landmark']")private WebElement landmark;
	@FindBy (xpath = "//input[@id='pincode']")private WebElement pincode;
	@FindBy (xpath = "//select[@id='state']")private WebElement state;
	@FindBy (xpath = "//select[@id='city']")private WebElement city;
	@FindBy (xpath = "//input[@id='mobile']")private WebElement mobileNumber;
	@FindBy (xpath = "//input[@id='landline']")private WebElement landLineNumber;
	@FindBy (xpath = "//a[text()='Save & Proceed']")private WebElement saveAndProceedButton;
	@FindBy (xpath = "//span[text()=' Ship to This Address ']")private WebElement shipToThisAddressButton;
	@FindBy (xpath = "//a[text()='Add New Address']")private WebElement addNewAddress;
	@FindBy (xpath = "//a[text()='Edit Address']")private WebElement editAdress;
	
	
	
	public NaaptolShippingAddress(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectTitle(int index)
	{
		Select select = new Select(title);
		select.selectByIndex(index);;
	}
	
	public void enterFirstName(String fName)
	{
		firstName.sendKeys(fName);
	}
	
	public void enterLastName(String lName)
	{
		lastName.sendKeys(lName);
	}
	
	public void enterAddress(String add)
	{
		address.sendKeys(add);
	}
	
	public void enterLandMark(String lMark)
	{
		landmark.sendKeys(lMark);
	}
	
	public void enterPincode(String postalcode)
	{
		pincode.sendKeys(postalcode);
	}
	
	public void selectState(String stateName)
	{
		Select select = new Select(state);
		select.selectByValue(stateName);
	}
	
	public void selectCity(String cityName)
	{
		Select select = new Select(city);
		select.selectByValue(cityName);
	}
	
	
	public void enterMobileNumber(String  contactNumber)
	{
		mobileNumber.sendKeys(contactNumber);
	}
	
	public void enterLandLineNumber(String landLine)
	{
		landLineNumber.sendKeys(landLine);
	}
	
	public void clickOnSaveAndProceedButton()
	{
		saveAndProceedButton.click();
	}
	
	public void clickOnShipToThisAddressButton()
	{
		shipToThisAddressButton.click();
	}
	
	public void clickOnAddNewAddressButton()
	{
		addNewAddress.click();
	}
	
	public void clickOnEditAddressButton()
	{
		editAdress.click();
	}
}
