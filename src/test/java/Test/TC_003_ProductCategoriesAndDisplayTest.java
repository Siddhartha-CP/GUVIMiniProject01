package Test;

import Pages.LoginPage;
import Pages.ProductDisplayPage;
import Base.ProjectSpecMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_003_ProductCategoriesAndDisplayTest extends ProjectSpecMethods {

    @Test
    public void verifyHomePageElements() {
    	
        launchingAndLoadingURL();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.enterUsername("Firsttest1");
        loginPage.enterPassword("firsttest1?");
        loginPage.clickConfirmLogin();

        ProductDisplayPage displayPage = new ProductDisplayPage(driver);

        boolean isWelcomeUserDisplayed = displayPage.isWelcomeUserDisplayed();
        Assert.assertTrue(isWelcomeUserDisplayed, "Welcome message is not displayed");
        if (isWelcomeUserDisplayed) {
            System.out.println("Welcome user is displayed");
        }

        boolean isHomeMenuDisplayed = displayPage.isHomeMenuDisplayed();
        Assert.assertTrue(isHomeMenuDisplayed, "Home menu is not displayed");
        if (isHomeMenuDisplayed) {
            System.out.println("Home menu is displayed");
        }

        boolean isContactMenuDisplayed = displayPage.isContactMenuDisplayed();
        Assert.assertTrue(isContactMenuDisplayed, "Contact menu is not displayed");
        if (isContactMenuDisplayed) {
            System.out.println("Contact menu is displayed");
        }

        boolean isAboutUsMenuDisplayed = displayPage.isAboutUsMenuDisplayed();
        Assert.assertTrue(isAboutUsMenuDisplayed, "About us menu is not displayed");
        if (isAboutUsMenuDisplayed) {
            System.out.println("About us menu is displayed");
        }

        boolean isCartMenuDisplayed = displayPage.isCartMenuDisplayed();
        Assert.assertTrue(isCartMenuDisplayed, "Cart menu is not displayed");
        if (isCartMenuDisplayed) {
            System.out.println("Cart menu is displayed");
        }

        boolean isLogoutMenuDisplayed = displayPage.isLogoutMenuDisplayed();
        Assert.assertTrue(isLogoutMenuDisplayed, "Logout menu is not displayed");
        if (isLogoutMenuDisplayed) {
            System.out.println("Logout menu is displayed");
        }

        boolean isPhonesCategoryDisplayed = displayPage.isPhonesCategoryDisplayed();
        Assert.assertTrue(isPhonesCategoryDisplayed, "Phones category is not displayed");
        if (isPhonesCategoryDisplayed) {
            System.out.println("Phones category is displayed");
        }

        boolean isLaptopsCategoryDisplayed = displayPage.isLaptopsCategoryDisplayed();
        Assert.assertTrue(isLaptopsCategoryDisplayed, "Laptops category is not displayed");
        if (isLaptopsCategoryDisplayed) {
            System.out.println("Laptops category is displayed");
        }

        boolean isMonitorsCategoryDisplayed = displayPage.isMonitorsCategoryDisplayed();
        Assert.assertTrue(isMonitorsCategoryDisplayed, "Monitors category is not displayed");
        if (isMonitorsCategoryDisplayed) {
            System.out.println("Monitors category is displayed");
        }

        boolean isAppLogoDisplayed = displayPage.isAppLogoDisplayed();
        Assert.assertTrue(isAppLogoDisplayed, "App logo is not displayed");
        if (isAppLogoDisplayed) {
            System.out.println("App logo is displayed");
        }

        closeBrowser();
    }
}
