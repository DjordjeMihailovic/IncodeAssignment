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

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        if (scenario.isFailed()) {
            System.err.println("Test failed at: " + timestamp);
            System.err.println("Failing scenario: " + scenario.getName());
            System.err.println("Running on browser: " + BROWSER + ", environment: " + ENV);
            Screenshot.takeScreenshot(DRIVER, scenario.getName());

        } else {
            System.out.println("Test passed at: " + timestamp);
            System.out.println("Scenario: " + scenario.getName() + " completed successfully.");
        }

        System.out.println("Test finished at: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("===============================================");
        DRIVER.quit();
    }

}
