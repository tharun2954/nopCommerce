package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//input[@id='Email']") WebElement input_email;
	@FindBy(xpath="//input[@id='Password']") WebElement input_password;
	@FindBy(xpath="//button[normalize-space()='Log in']") WebElement btn_login;
	@FindBy(xpath="//a[normalize-space()='Log out']") WebElement cnf_msg;
	//Actions
	
	public void EnterEmail(String email) {
		input_email.sendKeys(email);
	}
	
	public void EnterPassword(String pwd) {
		input_password.sendKeys(pwd);
	}
	
	public void ClickLogin() {
		btn_login.click();
	}
	
	public boolean GetCnfMsg() {
		String status = cnf_msg.getText();
		boolean success = false;
		if (status.equals("Log out")) {
			success = true;
		}
		return success;
	}
	
	
}
