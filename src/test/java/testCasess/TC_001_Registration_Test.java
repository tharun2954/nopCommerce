package testCasess;

import java.util.ResourceBundle;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.TestBase;

/*
 * ResourceBundle rb = ResourceBundle.getBundle("config")     //automatically detects config.properties file inside resources
 * rb.getString("appURL");
 * rb.getString("email");
 * rb.getString("password");
 */

public class TC_001_Registration_Test extends TestBase {
	@Test
	public void test_registration() throws InterruptedException {
		logger.debug("Automation logs......");
		logger.info("Starting logs...........");
		logger.info("");
		logger.info("");
		logger.info("");
		
		HomePage hp = new HomePage(driver);
		hp.nopCommerceNewsDetails();
		ResourceBundle rb = ResourceBundle.getBundle("config");
		logger.info("Clicking register....");
		hp.ClickRegister();
		logger.info("selecting gender.......");
		String gender = rb.getString("gender");
		logger.info("entered first name");
		String firstName = rb.getString("firstName");
		logger.info("entered lastname");
		String lastName = rb.getString("lastName");
		logger.info("selecting day in dob");
		String day = rb.getString("dobDay");
		logger.info("selecting month in dob");
		String month = rb.getString("dobMonth");
		logger.info("selecting year in dob");
		String year = rb.getString("dobYear");
		logger.info("entered email.");
		String email = rb.getString("email");
		logger.info("entered email");
		String company = rb.getString("company");
		logger.info("entered password");
		String pswd = rb.getString("pwd");
		logger.info("entered cnf pwd");
		
		
		
		
		RegisterPage rp = new RegisterPage(driver);
		rp.SelectGender(gender);
		rp.EnterFirstName(firstName);
		rp.EnterLastName(lastName);
		rp.EnterEmail(email);
		rp.SelectDobDay(day);
		rp.SelectDobMonth(month);
		rp.SelectDobYear(year);
		rp.EnterCompanyName(company);
		rp.EnterPassword(pswd);
		rp.ClickRegister();

		boolean status = rp.getCnfMessage();

		Assert.assertEquals(true, status);
		if (status){
			System.out.println("Test Passed!!!!!!");
			logger.info("TC_001_Registration Test Passed");
		} else {
			System.out.println("Test Failed!!!!!!");
			logger.info("TC_001_Registration Test Failed");
		}
	}

}
