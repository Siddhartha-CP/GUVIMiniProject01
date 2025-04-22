package Test;

import Base.ProjectSpecMethods;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.ProductDisplayPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_007_LogoutTest extends ProjectSpecMethods {

    @BeforeMethod
    public void setUp() {
        launchingAndLoadingURL();
    }

    @Test
    public void verifyLogoutFunctionality() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.enterUsername("Siddha@855.com");
        loginPage.enterPassword("Siddha@2954");
        loginPage.clickConfirmLogin();

        ProductDisplayPage displayPage = new ProductDisplayPage(driver);
        Assert.assertTrue(displayPage.isWelcomeUserDisplayed(), "Login failed!");

        LogoutPage logoutPage = new LogoutPage(driver);
        
        if (logoutPage.isLogoutButtonVisible()) {
            System.out.println("Logout button is visible.");
        } else {
            System.out.println("Logout button is not visible.");
        }

        logoutPage.clickLogoutButton();

        if (logoutPage.isRedirectedToHomePage()) {
            System.out.println("Logout successful");
        } else {
            System.out.println("Logout failed");
        }
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}
