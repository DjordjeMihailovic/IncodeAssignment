package Helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

    public static void takeScreenshot(WebDriver driver, String scenarioName) {
        // Only take screenshots if the driver supports TakesScreenshot
        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define the directory and file name for the screenshot
            String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String sanitizedScenarioName = scenarioName.replaceAll("\\s+", "_");
            String screenshotPath = screenshotDir + sanitizedScenarioName + "_" + timestamp + ".png";

            try {
                // Ensure the directory exists
                FileHandler.createDir(new File(screenshotDir));

                // Save the screenshot file
                FileHandler.copy(screenshot, new File(screenshotPath));
                System.out.println("Screenshot saved: " + screenshotPath);

            } catch (IOException e) {
                System.err.println("Failed to save screenshot: " + e.getMessage());
            }
        } else {
            System.err.println("Driver does not support taking screenshots.");
        }
    }
}
