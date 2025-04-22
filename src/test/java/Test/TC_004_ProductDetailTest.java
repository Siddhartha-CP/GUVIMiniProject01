package Test;

import Base.ProjectSpecMethods;
import Pages.ProductDetailsPage;
import Pages.ProductDisplayPage;
import Pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_004_ProductDetailTest extends ProjectSpecMethods {

    @Test
    public void verifyProductDetailAndAddToCart() {
        launchingAndLoadingURL();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.enterUsername("Firsttest1");
        loginPage.enterPassword("firsttest1?");
        loginPage.clickConfirmLogin();

        ProductDisplayPage homePage = new ProductDisplayPage(driver);
        Assert.assertTrue(homePage.isWelcomeUserDisplayed(), "Login failed - Welcome message not displayed");

        ProductDisplayPage.clickOnProduct("Samsung galaxy s6");

        ProductDetailsPage productPage = new ProductDetailsPage(driver);

        String title = productPage.getProductTitle();
        String price = productPage.getProductPrice();
        String description = productPage.getProductDescription();

        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Description: " + description);

        Assert.assertTrue(title.toLowerCase().contains("samsung"), "Title mismatch");
        Assert.assertTrue(price.contains("$"), "Price format incorrect");
        Assert.assertFalse(description.isEmpty(), "Description is empty");

        productPage.clickAddToCart();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        productPage.clickCartMenu();

        System.out.println("Product is successfully added to the cart!");
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();  
        }
    }
}
