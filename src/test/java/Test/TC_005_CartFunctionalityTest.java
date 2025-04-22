package Test;

import Base.ProjectSpecMethods;
import Pages.CartFunctionalityPage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductDisplayPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class TC_005_CartFunctionalityTest extends ProjectSpecMethods {

    @Test
    public void verifyCartFunctionality() {
        launchingAndLoadingURL();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.enterUsername("Siddha@855.com");
        loginPage.enterPassword("Siddha@2954");
        loginPage.clickConfirmLogin();

        ProductDisplayPage displayPage = new ProductDisplayPage(driver);
        Assert.assertTrue(displayPage.isWelcomeUserDisplayed(), "Login failed!");

        driver.findElement(By.linkText("Samsung galaxy s6")).click();

        ProductDetailsPage productPage = new ProductDetailsPage(driver);
        productPage.clickAddToCart();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        productPage.clickCartMenu();

        CartFunctionalityPage cartPage = new CartFunctionalityPage(driver);
        cartPage.waitForCartToLoad();

        String priceBefore = cartPage.getTotalPrice();
        System.out.println("Total price before deletion: $" + priceBefore);

        cartPage.deleteFirstProduct();
        System.out.println("Product has been deleted from the cart.");

        cartPage.waitForCartToLoad();

        try {
            String priceAfter = cartPage.getTotalPrice();
            System.out.println("Total price after deletion: $" + priceAfter);

            if (priceAfter.trim().isEmpty() || priceAfter.trim().equals("0")) {
                System.out.println("Your cart is now empty.");
            } else {
                System.out.println("Cart still has items.");
            }
        } catch (Exception e) {
            System.out.println("Your cart is now empty (no total price displayed).");
        }

        driver.quit();
    }
}
