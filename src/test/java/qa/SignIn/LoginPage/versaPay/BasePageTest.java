package qa.SignIn.LoginPage.versaPay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import qa.SignIn.LoginPage.versaPay.Utilities.ReadProperties;
import qa.SignIn.LoginPage.versaPay.constants.Constants;

public class BasePageTest implements Constants {

	WebDriver driver;
	ReadProperties configFile;
	WebDriverWait wait;


	@Parameters({ "browser" })
	@BeforeSuite 
	public void setUpInParent(@Optional(browser_name) String browser) {
		configFile = new ReadProperties(config_file_path);
		String chrome_path = configFile.getPropertyValue(browser_name);
		String url_location = configFile.getPropertyValue(browser_url);
		if (browser.equalsIgnoreCase(browser_name)) {
			System.setProperty(webdriver_chrome_driver, chrome_path);
			driver = new ChromeDriver();
			driver.get(url_location);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		}
		wait=new WebDriverWait(driver, 5);
	}

	@AfterSuite
	public void afterMethodInBaseTest() {
		driver.quit();
	}
}
