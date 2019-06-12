package qa.SignIn.LoginPage.versaPay;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePageTest{
	LoginPage loginTest;
	@BeforeClass
	public void beforeClassInLandingPage() {
		loginTest = PageFactory.initElements(driver, LoginPage.class);
	}
	@BeforeMethod
	public void beforeMethodInLandingPage() {
		loginTest.clickOnSignIn();
		loginTest.windowHandles();
	}

	
	@Test 
	public void TC_02_loginWithEmptyEmailorPhone() {
		loginTest.clearUsernameField();
		loginTest.setUserName("");
		loginTest.clickNextButton();
		Assert.assertTrue(loginTest.isErrorMessageDisplayed());
	}
	@Test
	public void TC_03_loginWithSpecialCharInEmailorPhone() {
		loginTest.clearUsernameField();
		loginTest.setUserName("$");
		loginTest.clickNextButton();
		Assert.assertTrue(loginTest.isErrorMessageDisplayed());
	}
	@Test 
	public void TC_04_loginWithEmptyPassword() throws InterruptedException {
	
		loginTest.clearUsernameField();
		loginTest.setUserName("versapay.qa.test@gmail.com");
		loginTest.clickNextButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(passwordField))).clear();
		driver.findElement(By.cssSelector(passwordField)).sendKeys("");
		loginTest.clickNextButton();
		
		Assert.assertTrue(loginTest.isPasswordErrorMessageDisplayed());
	}
	@Test
	public void TC_05_loginWithWrongPassword() throws InterruptedException {
		loginTest.clearUsernameField();
		loginTest.clearUsernameField();
		loginTest.setUserName("versapay.qa.test@gmail.com");
		loginTest.clickNextButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(passwordField))).clear();
		driver.findElement(By.cssSelector(passwordField)).sendKeys("wrongPassword");
		loginTest.clickNextButton();
		Assert.assertTrue(driver.findElement(By.cssSelector("[class='GQ8Pzc']")).isDisplayed());
	}
	@Test 
	public void TC_06_ResetWithRegisteredEmail() throws InterruptedException {
		loginTest.clickForgotEmail();
		loginTest.enterEmailOrPhoneNumber("versapay.qa.test@gmail.com");
		loginTest.clickNextButton();
	}
	
	@Test 
	public void TC_07_ResetWithLastPasswordUsed() throws InterruptedException {
		loginTest.clearUsernameField();
		loginTest.setUserName("versapay.qa.test@gmail.com");
		loginTest.clickNextButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(forgotPassword))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(passwordField))).clear();
		driver.findElement(By.cssSelector(passwordField)).sendKeys("ILoveApples");
		Thread.sleep(5000);
	}
	@Test
	public void TC_08_loginWithCorrectUserIdAndPassword() {
	
		loginTest.clearUsernameField();
		loginTest.setUserName("versapay.qa.test@gmail.com");
		loginTest.clickNextButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(passwordField))).clear();
		driver.findElement(By.cssSelector(passwordField)).sendKeys("ILoveApples");
		loginTest.clickNextButton();
	}
	@AfterMethod
	public void AfterMethodInLandingPage() {
		loginTest.closeCurrentTab();
		loginTest.switchToBaseWindow();
	}
}
