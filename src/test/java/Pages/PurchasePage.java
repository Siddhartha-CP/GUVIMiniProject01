package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchasePage {

    WebDriver driver;
    WebDriverWait wait;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='name']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement countryField;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@id='card']")
    private WebElement cardField;

    @FindBy(xpath = "//input[@id='month']")
    private WebElement monthField;

    @FindBy(xpath = "//input[@id='year']")
    private WebElement yearField;

    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    private WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//button[@class='btn btn-success' and text()='Place Order']")
    private WebElement placeOrderButton;

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public boolean isUserNameFieldDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(userNameField));
        return userNameField.isDisplayed();
    }

    public boolean isCountryFieldDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(countryField));
        return countryField.isDisplayed();
    }

    public boolean isCityFieldDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(cityField));
        return cityField.isDisplayed();
    }

    public void enterUserDetails(String name, String country, String city) {
        userNameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
    }

    public void enterPaymentDetails(String card, String month, String year) {
        cardField.sendKeys(card);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
    }

    public void clickPurchaseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseButton));
        purchaseButton.click();
    }

    public String getConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        return confirmationMessage.getText();
    }
} 
