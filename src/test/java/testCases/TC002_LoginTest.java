package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		try 
		{
			logger.info("***** Starting Login Test Case *****");
			
			HomePage page = new HomePage(driver);
			page.clickAccount();
			logger.info("----- Clicked Account ------");
			page.clickLogin();
			logger.info("----- Clicked Login ------");
		
			LoginPage obj = new LoginPage(driver);
			logger.info("----- Entered Username ------");
			obj.setUsername("kanwalfayyaz9854@gmail.com");
			logger.info("----- Entered Password ------");
			obj.setPassword("kanwal123");
			obj.clickButton();
			logger.info("----- Clicked Login Button ------");
		
			logger.info("----- Verifying Login ------");
			MyAccountPage account = new MyAccountPage(driver);
			boolean value = account.checkHeading();
			Assert.assertTrue(value);
			//Assert.assertEquals(value,true,"Login Failed"); //If false Login failed will be printed
		}
		catch(Exception e) {
			logger.error("Test  Failed");
			logger.debug("Some Error Occured");
			Assert.fail();
		}
		
		logger.info("****** Ending Login Test Case");

	}	
}
