package qa.SignIn.LoginPage.versaPay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage  {



	@FindBy(xpath = "(//div[@class='h-c-header__cta']/ul/li/following-sibling::li/a[contains(text(),'            Sign in')])[1]")
	WebElement signInElement;

	@FindBy(xpath="//content/span[text()='Next']")
	WebElement nextButton;

	WebDriverWait wait;
	WebElement passwordInputField;

	@FindBy(id="identifierId")
	WebElement usernameInputField;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextElement;

	@FindBy(css = "[jsname='Cuz2Ue']")
	WebElement forgotEmailLink;

	@FindBy(css = "[name='identifier']")
	WebElement emailField;

	@FindBy(css = "[class='TQGan']")
	WebElement emailErrorPage;

	@FindBy(xpath = "//span[text()='Forgot password?']")
	WebElement forgotPassword;

	@FindBy(css = "[class='GQ8Pzc']")
	WebElement passwordErrorPage;


	public LoginPage(WebDriver driver) {

		super(driver);

	}

	public void clickOnSignIn() {
		signInElement.click();
	}

	public String getUrlChildWindow() {
		return driver.getTitle();
	}

	public void clickOnNext() {
		nextButton.click();
	}
	public void setUserName(String userName) {
		usernameInputField.sendKeys(userName);
	}

	public void clickNextButton() {

		nextElement.click();
	}
	public void clearUsernameField() {
		usernameInputField.clear();
	}
	public void clickForgotEmail() {
		forgotEmailLink.click();
	}
	public void enterEmailOrPhoneNumber(String userEmail) {
		emailField.sendKeys(userEmail);
	}
	public void clickForgotPassword() {

		forgotPassword.click();
	}
	public Boolean isErrorMessageDisplayed() {

		return emailErrorPage.isDisplayed();

	}
	public Boolean isPasswordErrorMessageDisplayed() {

		return emailErrorPage.isDisplayed();

	}
}
