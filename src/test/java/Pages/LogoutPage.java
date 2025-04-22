package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Log out']") 
    private WebElement logoutButton;

    @FindBy(xpath = "//a[text()='Home ']") 
    private WebElement homePage;


    public boolean isLogoutButtonVisible() {
        return logoutButton.isDisplayed();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public boolean isRedirectedToHomePage() {
        return homePage.isDisplayed();
    }
}
