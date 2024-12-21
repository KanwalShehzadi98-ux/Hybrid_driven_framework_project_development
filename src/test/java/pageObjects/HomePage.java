package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//1. Constructor
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	//2. Locators
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement account;
	@FindBy(xpath="(//a[normalize-space()='Register'])[1]") WebElement register;
	@FindBy(xpath="(//a[normalize-space()='Login'])[1]") WebElement login;
	
	//3. Action Methods
	public void clickAccount() {
		account.click();
	}
	
	public void clickRegister() {
		register.click();
	}
	
	public void clickLogin() {
		login.click();
	}
}
