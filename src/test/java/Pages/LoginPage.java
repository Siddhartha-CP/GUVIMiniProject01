package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @FindBy(id = "login2")
    private WebElement loginButton;

    @FindBy(id = "logInModal")
    private WebElement loginModal;

    @FindBy(id = "loginusername")
    private WebElement usernameInput;

    @FindBy(id = "loginpassword")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement confirmLoginButton;

    @FindBy(id = "nameofuser")
    private WebElement welcomeUser;

    // Actions
    public boolean isLoginButtonVisible() {
        return loginButton.isDisplayed();
    }

    public boolean isLoginButtonClickable() {
        return loginButton.isEnabled();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isLoginModalVisible() {
        wait.until(ExpectedConditions.visibilityOf(loginModal));
        return loginModal.isDisplayed();
    }

    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickConfirmLogin() {
        confirmLoginButton.click();
    }

    public boolean isWelcomeUserVisible() {
        wait.until(ExpectedConditions.visibilityOf(welcomeUser));
        return welcomeUser.isDisplayed();
    }

    public void loginWithCredentials(String username, String password) {
        clickLoginButton();

        wait.until(driver -> loginModal.isDisplayed() &&
                loginModal.getAttribute("style").contains("display: block"));

        enterUsername(username);
        enterPassword(password);
        clickConfirmLogin();
    }
}
