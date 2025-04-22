package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUpPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

 
    @FindBy(id = "signin2")
    private WebElement signUpButton;

    @FindBy(id = "signInModalLabel")
    private WebElement signUpModal;

 
    public boolean isSignUpButtonVisible() {
        return signUpButton.isDisplayed();
    }

    public boolean isSignUpButtonClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        return signUpButton.isEnabled();
    }

    public void clickSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }

    public boolean isSignUpModalVisible() {
        wait.until(ExpectedConditions.visibilityOf(signUpModal));
        return signUpModal.isDisplayed();
    }
}
