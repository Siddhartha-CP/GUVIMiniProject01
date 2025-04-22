package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='name']")
    private WebElement productTitle;

    @FindBy(xpath = "//h3[@class='price-container']")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@id='more-information']//p")
    private WebElement productDescription;

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(id = "cartur")
    private WebElement cartMenu;

    public String getProductTitle() {
        wait.until(ExpectedConditions.visibilityOf(productTitle));
        return productTitle.getText();
    }

    public String getProductPrice() {
        wait.until(ExpectedConditions.visibilityOf(productPrice));
        return productPrice.getText();
    }

    public String getProductDescription() {
        wait.until(ExpectedConditions.visibilityOf(productDescription));
        return productDescription.getText();
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void clickCartMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(cartMenu)).click();
    }

    public String getCartCount() {
        wait.until(ExpectedConditions.visibilityOf(cartMenu)); 
        String cartText = cartMenu.getText();
        return cartText.replaceAll("[^0-9]", "");  
    }
}
