package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//label[@for='gender-male']")
	WebElement btn_radio_male;
	
	@FindBy(xpath="//label[@for='gender-female']")
	WebElement btn_radio_female;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement input_firstname;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement input_lastname;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement input_email;
	
	@FindBy(xpath="//select[@name='DateOfBirthDay']")
	WebElement select_dob_day;
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']") 
	WebElement select_dob_month;
	
	@FindBy(xpath="//select[@name='DateOfBirthYear']") 
	WebElement select_dob_year;
		
	@FindBy(xpath="//input[@id='Company']")
	WebElement input_companyname;
	
	@FindBy(xpath="//label[@for='Newsletter']") WebElement check_newsletter;
	
	@FindBy(xpath="//input[@id='Password']") WebElement input_password;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']") WebElement input_cnf_password;
	
	@FindBy(xpath="//button[@id='register-button']") WebElement btn_register;
	
	@FindBy(xpath="//div[normalize-space()='Your registration completed']") WebElement cnf_msg;
	
	@FindBy(xpath="//li[normalize-space()='The specified email already exists']") WebElement email_exists_error;
	
	
	//Actions
	
	public void SelectGender(String gender) {
		if (gender.equals("male")) {
			btn_radio_male.click();
		} else {
			btn_radio_female.click();
		}
	}
	
	public void EnterFirstName(String firstName) {
		input_firstname.sendKeys(firstName);
	}
	
	public void EnterLastName(String lastName) {
		input_lastname.sendKeys(lastName);
	}
	
	public void SelectDobDay(String day) {
		List<WebElement>dates = driver.findElements(By.xpath("//select[@name='DateOfBirthDay']//option"));
		for(WebElement d:dates) {
			if(day.equals(d.getText())) {
				d.click();
			}
		}
	}
	
	public void SelectDobMonth(String month) {
		List<WebElement>months = driver.findElements(By.xpath("//select[@name='DateOfBirthMonth']//option"));
		for(WebElement d:months) {
			if(month.equals(d.getText())) {
				d.click();
			}
		}
	}
	
	public void SelectDobYear(String year) {
		List<WebElement>years = driver.findElements(By.xpath("//select[@name='DateOfBirthMonth']//option"));
		for(WebElement d:years) {
			if(year.equals(d.getText())) {
				d.click();
			}
		}
	}
	
	public void EnterEmail(String email) {
		input_email.sendKeys(email);
	}
	
	public void EnterCompanyName(String company) {
		input_companyname.sendKeys(company);
	}
	
	public void EnterPassword(String pwd) {
		input_password.sendKeys(pwd);
		input_cnf_password.sendKeys(pwd);
	}
	
	public void ClickRegister() {
		btn_register.click();
	}	
	
	public boolean getCnfMessage() {
		String status = cnf_msg.getText();
		boolean success = false;
		if (status.equals("Your registration completed")) {
			success = true;
		}
		
		return success;		
	}
	
	public boolean getErrorMessage() {
		String error = email_exists_error.getText();
		boolean errorStatus = false;
		if (error.equals("The specified email already exists")) {
			errorStatus = true;
		}
		return errorStatus;
		
	}
	
}
