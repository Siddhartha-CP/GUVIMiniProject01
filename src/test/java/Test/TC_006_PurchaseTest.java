package Test;

import Base.ProjectSpecMethods;
import Pages.CartFunctionalityPage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductDisplayPage;
import Pages.PurchasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_006_PurchaseTest extends ProjectSpecMethods {

    @Test
    public void verifyPurchaseFlow() {
        launchingAndLoadingURL();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.enterUsername("Siddha@855.com");
        loginPage.enterPassword("Siddha@2954");
        loginPage.clickConfirmLogin();

        ProductDisplayPage displayPage = new ProductDisplayPage(driver);
        Assert.assertTrue(displayPage.isWelcomeUserDisplayed(), "Login failed!");

        ProductDisplayPage.clickOnProduct("Samsung galaxy s6");

        ProductDetailsPage productPage = new ProductDetailsPage(driver);
        productPage.clickAddToCart();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        productPage.clickCartMenu();

        CartFunctionalityPage cartPage = new CartFunctionalityPage(driver);
        cartPage.waitForCartToLoad();
        cartPage.clickOnPlaceOrder();

        PurchasePage purchasePage = new PurchasePage(driver);
        Assert.assertTrue(purchasePage.isUserNameFieldDisplayed(), "Name field not displayed!");
        Assert.assertTrue(purchasePage.isCountryFieldDisplayed(), "Country field not displayed!");
        Assert.assertTrue(purchasePage.isCityFieldDisplayed(), "City field not displayed!");

        purchasePage.enterUserDetails("Siddhartha C", "India", "Bengaluru");
        purchasePage.enterPaymentDetails("8553702954", "10", "2025");
        purchasePage.clickPurchaseButton();

        String confirmation = purchasePage.getConfirmationMessage();
        System.out.println("Confirmation Message: " + confirmation);
        Assert.assertTrue(confirmation.contains("Thank you for your purchase!"));

        driver.quit();
    }
}
