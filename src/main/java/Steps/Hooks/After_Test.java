package Steps.Hooks;

import Helpers.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import static Helpers.BaseConstants.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class After_Test {

    @After
    public void tearDown(Scenario scenario) {
        // Capture the current timestamp for logging
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // Check if the scenario failed
        if (scenario.isFailed()) {
            System.err.println("Test failed at: " + timestamp);
            System.err.println("Failing scenario: " + scenario.getName());
            System.err.println("Running on browser: " + BROWSER + ", environment: " + ENV);

            // Call the Screenshot utility to take and save the screenshot
            Screenshot.takeScreenshot(DRIVER, scenario.getName());
        } else {
            System.out.println("Test passed at: " + timestamp);
            System.out.println("Scenario: " + scenario.getName() + " completed successfully.");
        }

        // Log test finish time
        System.out.println("Test finished at: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("===============================================");
        DRIVER.quit();
        DRIVER = null; // Set it to null after quitting to avoid reuse
        }

}
