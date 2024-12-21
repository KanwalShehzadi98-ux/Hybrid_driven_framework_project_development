package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	//1. Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
		
	//2. Locators 
	@FindBy(xpath="//input[@id='input-email']") WebElement username;
	@FindBy(xpath="(//input[@id='input-password'])[1]") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement button;
	
	//3. Action Methods
	public void setUsername(String user) {
		username.sendKeys(user);
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickButton() {
		button.click();
	}
}
