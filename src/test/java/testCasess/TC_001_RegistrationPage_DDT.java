package testCasess;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.TestBase;
import utilities.DataProviders;

/*
 * ResourceBundle rb = ResourceBundle.getBundle("config")     //automatically detects config.properties file inside resources
 * rb.getString("appURL");
 * rb.getString("email");
 * rb.getString("password");
 */

public class TC_001_RegistrationPage_DDT extends TestBase {
	@Test(dataProvider = "RegistrationData", dataProviderClass = DataProviders.class)
	public void test_registration_DDT(String gender, String pwd, String lastName, String firstName, String email,
			String company, String day, String month, String year) {
		logger.debug("Automation logs......");
		logger.info("Starting logs...........");
		logger.info("");
		logger.info("");
		logger.info("");

		HomePage hp = new HomePage(driver);
		logger.info("Clicking register....");
		hp.ClickRegister();
		System.out.println(gender);

		RegisterPage rp = new RegisterPage(driver);
		logger.info("selecting gender.......");
		rp.SelectGender(gender);
		logger.info("entered first name");
		rp.EnterFirstName(firstName);
		logger.info("entered lastname");
		rp.EnterLastName(lastName);
		logger.info("entered email");
		rp.EnterEmail(email);
		logger.info("selecting day in dob");
		rp.SelectDobDay(day);
		logger.info("selecting month in dob");
		rp.SelectDobMonth(month);
		logger.info("selecting year in dob");
		rp.SelectDobYear(year);

		rp.EnterCompanyName(company);
		logger.info("entered password");
		rp.EnterPassword(pwd);
		logger.info("entered cnf pwd");
		rp.ClickRegister();

		boolean status = rp.getCnfMessage();
		boolean errorStatus = rp.getErrorMessage();

		if (status) {
			Assert.assertEquals(true, status);
			System.out.println("Test Passed!!!!!!" + "for user : " + firstName);
			logger.info("TC_001_Registration Test Passed");
		} else if (errorStatus) {
			Assert.assertEquals(true, status);
			System.out.println("Test Passed....");
			logger.info("email already exists.........");
		}
		else {
			Assert.assertEquals(true, status);
			System.out.println("Test Failed!!!!!!");
			logger.info("TC_001_Registration Test Failed");
		}
	}

}
