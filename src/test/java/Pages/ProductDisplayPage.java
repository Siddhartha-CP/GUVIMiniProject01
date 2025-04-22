package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDisplayPage {

    private WebDriver driver;

    public ProductDisplayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='nameofuser' and starts-with(text(), 'Welcome')]")
    private WebElement welcomeUser;

    @FindBy(xpath = "//a[@id='nava']//img")
    private WebElement appLogo;

    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    private WebElement homeMenu;

    @FindBy(xpath ="//a[contains(text(), 'Contact')]")
    private WebElement contactMenu;

    @FindBy(xpath = "//a[contains(text(), 'About us')]")
    private WebElement aboutUsMenu;

    @FindBy(xpath = "//a[contains(text(), 'Cart')]")
    private WebElement cartMenu;

    @FindBy(xpath = "//a[contains(text(), 'Log out')]")
    private WebElement logoutMenu;

    @FindBy(xpath = "//a[text()='Phones']")
    private WebElement phonesCategory;

    @FindBy(xpath = "//a[text()='Laptops']")
    private WebElement laptopsCategory;

    @FindBy(xpath = "//a[text()='Monitors']")
    private WebElement monitorsCategory;
    
    @FindBy(xpath = "//a[text()='Samsung galaxy s6']")
    private static WebElement productLink; 

    public boolean isWelcomeUserDisplayed() {
        return welcomeUser.isDisplayed();
    }

    public boolean isAppLogoDisplayed() {
        return appLogo.isDisplayed();
    }

    public boolean isHomeMenuDisplayed() {
        return homeMenu.isDisplayed();
    }

    public boolean isContactMenuDisplayed() {
        return contactMenu.isDisplayed();
    }

    public boolean isAboutUsMenuDisplayed() {
        return aboutUsMenu.isDisplayed();
    }

    public boolean isCartMenuDisplayed() {
        return cartMenu.isDisplayed();
    }

    public boolean isLogoutMenuDisplayed() {
        return logoutMenu.isDisplayed();
    }

    public boolean isPhonesCategoryDisplayed() {
        return phonesCategory.isDisplayed();
    }

    public boolean isLaptopsCategoryDisplayed() {
        return laptopsCategory.isDisplayed();
    }

    public boolean isMonitorsCategoryDisplayed() {
        return monitorsCategory.isDisplayed();
    }
    
    public static void clickOnProduct(String productName) {
    	productLink.click(); 
    }
    
    
}
