package testBase;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/*
 *ResourceBundle rb = ResourceBundle.getBundle("config")     //automatically detects config.properties file inside resources
 * rb.getString("appURL");
 * rb.getString("email");
 * rb.getString("password");
 */
public class TestBase {
	
	public static WebDriver driver;
	public Logger logger;
	
	ResourceBundle rb = ResourceBundle.getBundle("config");
	String url = rb.getString("url");
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		if (br.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		
		//Log4j2;
		logger=LogManager.getLogger(this.getClass());
		
		logger.info("Opening url ");
		
		//now launching driver
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String captureScreen(String tname) throws IOException {

		/*Date dt=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
		String timeStamp=df.format(dt);
		*/
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}
