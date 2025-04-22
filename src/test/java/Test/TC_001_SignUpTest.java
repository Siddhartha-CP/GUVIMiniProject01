package Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.ProjectSpecMethods;
import Pages.SignUpPage;
import Utils.UtilityClass;

public class TC_001_SignUpTest extends ProjectSpecMethods {

    SignUpPage signUpPage;

    @BeforeMethod
    public void setup() {
        launchingAndLoadingURL();
        signUpPage = new SignUpPage(UtilityClass.driver);
    }

    @Test
    public void verifySignUpButtonFunctionality() {
        Assert.assertTrue(signUpPage.isSignUpButtonVisible(), "SignUp button should be visible.");
        System.out.println("Sign Up button is visible");

        Assert.assertTrue(signUpPage.isSignUpButtonClickable(), "SignUp button should be clickable.");
        System.out.println("Sign Up button is clickable");

        signUpPage.clickSignUpButton();
        Assert.assertTrue(signUpPage.isSignUpModalVisible(), "SignUp modal should be visible.");
        System.out.println("Sign Up modal is displayed");
    }
    @AfterMethod
    public void tearDown() {
        takeScreenshotOnFailure("TC_001_SignUpTest");
        closeBrowser();
  }
}
