package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= {"Sanity","Regression","Master"})
	public void verify_loginDDT(String name,String pwd, String exp) //we get these 3 from excel.
	{
		logger.info("***** Started Testing TC003_LoginDataDrivenTest *****");
		
		HomePage obj1 = new HomePage(driver);
		
		logger.info("---- Clicked Account ----");
		obj1.clickAccount();
		
		logger.info("---- Clicked Login ----");
		obj1.clickLogin();
		
		logger.info("---- Set Username & Password ----");
		LoginPage obj2 = new LoginPage(driver);
		obj2.setUsername(name);
		obj2.setPassword(pwd);
		obj2.clickButton();
		
		logger.info("---- Checked Account Heading ----");
		MyAccountPage obj3 = new MyAccountPage(driver);
		boolean targetPage = obj3.checkHeading();
		
		/*
		 * Data is valid   - login success - test pass - logout
		 *                 - login fail    - test fail
		 * Data is invalid - login success - test fail 
		 *                 - login fail    - test pass - logout
		 */
		
		logger.info("---- Validation ----");
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage == true) {
				obj3.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		else {
			if(targetPage == true) {
				obj3.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
	}
}
