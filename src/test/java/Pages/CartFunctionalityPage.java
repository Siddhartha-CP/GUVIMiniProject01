package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartFunctionalityPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartFunctionalityPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void waitForCartToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));
    }

    public List<WebElement> getCartItems() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));
        return driver.findElements(By.xpath("//tr"));
    }

    public String getTotalPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalp")));
        return driver.findElement(By.id("totalp")).getText();
    }

    public void deleteFirstProduct() {
        WebElement deleteLink = driver.findElement(By.xpath("//a[text()='Delete']"));
        wait.until(ExpectedConditions.elementToBeClickable(deleteLink));
        deleteLink.click();
        wait.until(ExpectedConditions.stalenessOf(deleteLink));
    }
    
    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    public void clickOnPlaceOrder() {
    	placeOrderButton.click(); 
 }
}
    
    
    

