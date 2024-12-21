package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
		
	//1. Constructor
	public RegistrationPage(WebDriver driver){
		super(driver);
	}
	
	//2. Locators
	@FindBy(xpath="//input[@id='input-firstname']") WebElement firstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement confirmPassword;
	@FindBy(xpath="//input[@value='0']") WebElement newsletter;
	@FindBy(xpath="//input[@name='agree']") WebElement policy;
	@FindBy(xpath="//input[@value='Continue']") WebElement continueBtn;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmMsg;
	
	//3. Action Methods
	public void setFirstname(String firstName) {
		firstname.sendKeys(firstName);
	}
	
	public void setLastname(String lastName) {
		lastname.sendKeys(lastName);
	}
	
	public void setEmail(String e) {
		email.sendKeys(e);
	}
	
	public void setTelephone(String telePhone) {
		telephone.sendKeys(telePhone);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void setConfirm(String cpwd) {
		confirmPassword.sendKeys(cpwd);
	}
	
	public void setNewsletter() {
		newsletter.click();
	}
	
	public void policyCheck() {
		policy.click();
	}
	
	public void clickContinue() {
		
		//1. Click
		continueBtn.click();
		
		//2. Submit
		//continueBtn.submit();
		
		//3. Actions
		//Actions act = new Actions(driver);
		//act.moveToElement(continueBtn).click().perform();
		
		//4.Javascript Executor
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", continueBtn);
		
		//5. Keyboard
		//continueBtn.sendKeys(Keys.RETURN);
		
		//6. Explicit wait
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
	}
	
	public String message() {
		try {
			return confirmMsg.getText();
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
}
