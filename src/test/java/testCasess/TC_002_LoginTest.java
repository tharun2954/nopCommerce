package testCasess;

import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.TestBase;

public class TC_002_LoginTest extends TestBase{
	@Test
	public void loginTest() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String email = rb.getString("email");
		String pwd = rb.getString("pwd");
		
		logger.info("Starting login test....");
		
		HomePage hp = new HomePage(driver);
		logger.info("Clicked login");
		hp.ClickLogin();
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Entered email.......");
		lp.EnterEmail(email);
		logger.info("Entered Password......");
		lp.EnterPassword(pwd);
		
		logger.info("Clicked login button");
		lp.ClickLogin();
		
		boolean status = lp.GetCnfMsg();
		if(status) {
			Assert.assertEquals(true, status);
			logger.info("Login Test success....");
		} else {
			Assert.assertEquals(true, status);
			logger.info("Test Failed");
		}
		
	}
}
