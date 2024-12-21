package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() {
		
		try 
		{
		logger.info("***** Starting TC001_AccountRegistrationTest ******");
		HomePage obj1 = new HomePage(driver);
		obj1.clickAccount();
		logger.info("----- Clicked Account -----");
		obj1.clickRegister();
		logger.info("----- Register Account -----");
		
		logger.info("----- Providing customer details -----");
		RegistrationPage obj2 = new RegistrationPage(driver);
		obj2.setFirstname(randomStrings().toUpperCase());
		obj2.setLastname(randomStrings().toUpperCase());
		obj2.setEmail(randomStrings()+"@gmail.com");
		obj2.setTelephone(randomNumbers());
		String pswd = randomAlphaNumeric();
		obj2.setPassword(pswd);
		obj2.setConfirm(pswd);
		obj2.setNewsletter();
		obj2.policyCheck();
		obj2.clickContinue();
		String myMessage = obj2.message();
		
		Thread.sleep(5000);
		logger.info("----- Validating Expected Message -----");
		if(myMessage.equals("Your Account Has Been Created!!!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		}
		catch(Exception e) {
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		
		logger.info("***** Ending TC001_AccountRegistrationTest ******");
	}
	

}
