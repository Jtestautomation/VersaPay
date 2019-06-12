package qa.SignIn.LoginPage.versaPay;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	Set <String> setWindow;
	protected String baseWindow;
	Iterator<String> itr;
	String childWindow;
	WebDriverWait wait;

	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
	}
	public void windowHandles() {

		baseWindow = driver.getWindowHandle();

		setWindow = driver.getWindowHandles();
		itr= setWindow.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if(!baseWindow.equals(childWindow)){
				driver.switchTo().window(childWindow);
			}
		}
	}
	public void switchToBaseWindow() {
		
	driver.switchTo().window(baseWindow);
	}
	
	public void closeCurrentTab() {
		driver.close();
	}
}