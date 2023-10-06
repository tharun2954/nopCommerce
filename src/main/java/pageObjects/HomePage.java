package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//a[normalize-space()='Register']") 
	WebElement link_register;
	
	@FindBy(xpath="//a[normalize-space()='Log in']")
	WebElement link_login;
	
	@FindBy(xpath="//span[normalize-space()='Wishlist']")
	WebElement link_wishlist;
	
	@FindBy(id="small-searchterms") 
	WebElement search_input_box;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement button_search;
	
	@FindBy(xpath="//body/div/div/ul[1]/li[1]/a[1]")
	WebElement link_computers;
	
	@FindBy(xpath="//body/div/div/ul[1]/li[2]/a[1]")
	WebElement lini_electronics;
	
	@FindBy(xpath="//body/div/div/ul[1]/li[3]/a[1]")
	WebElement lini_apparel;
	
	@FindBy(xpath="//body/div/div/ul[1]/li[4]/a[1]")
	WebElement lini_digital_downloads;
	
	@FindBy(xpath="//body/div/div/ul[1]/li[5]/a[1]")
	WebElement lini_books;
	
	@FindBy(xpath="//body/div/div/ul[1]/li[6]/a[1]")
	WebElement lini_jewelry;

	@FindBy(xpath="//body/div/div/ul[1]/li[7]/a[1]")
	WebElement link_giftcards;
	
	@FindBy(xpath="//a[@href='/nopcommerce-new-release'][normalize-space()='details']") WebElement news_nopcommerce_details_button;
	//Actions
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public void ClickRegister() {
		link_register.click();
	}
	
	public void ClickLogin() {
		link_login.click();
	}
	
	public void SearchProduct(String item) {
		search_input_box.sendKeys(item);
		//to press enter or click search icon or button : 2 ways
		//1st
		search_input_box.submit();
		//2nd
		//button_search.click();
	}
	
	public void nopCommerceNewsDetails() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView({block: 'center'})", news_nopcommerce_details_button);
		Thread.sleep(5000);
		//news_nopcommerce_details_button.click();
		//checking page scrolling
		js.executeScript("arguments[0].scrollIntoView({block: 'start'})", link_register);
	}
	
	

}
