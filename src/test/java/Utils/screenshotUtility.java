package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screenshotUtility {

    public static void captureScreenshot(WebDriver driver, ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String fileName = result.getName() + "_" + timestamp + ".png";
            File destination = new File("screenshots/" + fileName);

            try {
                FileUtils.copyFile(source, destination);
                System.out.println(" Screenshot taken: " + destination.getAbsolutePath());
            } catch (IOException e) {
                System.out.println(" Failed to save screenshot: " + e.getMessage());
            }
        }
    }
}
