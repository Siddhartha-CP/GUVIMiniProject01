package Base;

import Utils.UtilityClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectSpecMethods extends UtilityClass {

    public void launchingAndLoadingURL() {
        launchBrowser("chrome", "https://www.demoblaze.com/");
    }

    public void closeBrowser() {
        driver.quit(); 
    }

    public void takeScreenshotOnFailure(String testName) {
      
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("screenshots/" + testName + "_" + timestamp + ".png");

        try {
            FileHandler.copy(screenshot, destination);
            System.out.println("Screenshot saved: " + destination.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
