package Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.ProjectSpecMethods;
import Pages.LoginPage;

public class TC_002_LoginTest extends ProjectSpecMethods {

    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        launchingAndLoadingURL();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void verifyLoginFunctionality() {
    	
        Assert.assertTrue(loginPage.isLoginButtonVisible(), "Login button is not visible");
        System.out.println("Login button is visible");

        Assert.assertTrue(loginPage.isLoginButtonClickable(), "Login button is not clickable");
        System.out.println("Login button is clickable");

        loginPage.loginWithCredentials("Firsttest1", "firsttest1?");

        Assert.assertTrue(loginPage.isWelcomeUserVisible(), "User is not logged in");
        System.out.println("User successfully logged in");
    }

    @AfterMethod
    public void tearDown() {
        takeScreenshotOnFailure("TC_002_LoginTest");
        closeBrowser();
    }
}
