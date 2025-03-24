package Steps.Hooks;

import Helpers.TestUser;
import static Helpers.BaseConstants.*;
import static java.util.concurrent.TimeUnit.SECONDS;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Begin_Test {

    @Before
    public void BeginScenario(Scenario scenario) throws FileNotFoundException {

        USER = new TestUser("Bob");

        // These are used for when executing in CI/CD env like Jenkins; I would pass these parameters from there
        BROWSER = System.getProperty("browser");
        ENV = System.getProperty("env");

        // This will check if a BROWSER exists; if not it will assume that the test is run locally
        // and proceed with build from the CONFIG file, taking the value of first variable found
        ISLOCALTEST = (BROWSER == null);

        if (ISLOCALTEST) {

            String value = new Scanner(new File("data/config")).useDelimiter("\\Z").next();
            try {
                System.out.println("Reading config file");
                BROWSER = StringUtils.substringBetween(value, "BROWSER = \"", "\";");
                ENV = StringUtils.substringBetween(value, "env = \"", "\";");

            } catch (Exception e) {
                System.out.println("Could not read config file");
            }
        }

        System.out.println("Test began, opening browser " + BROWSER + "\nTesting scenario: " + scenario.getName());
        DRIVER = buildForBrowser(BROWSER);

    }

    private WebDriver buildForBrowser(String browser) {
        WebDriver driver = null;
        BROWSER = browser;
        switch (BROWSER) {
            case "chrome":
                ChromeOptions localchromeOptions = new ChromeOptions();

                localchromeOptions.addArguments("--start-maximized");
                localchromeOptions.addArguments("--window-size=1920x1080");
                localchromeOptions.addArguments("--disable-gpu");
                localchromeOptions.addArguments("--no-sandbox");
                localchromeOptions.addArguments("--incognito");

                driver = new ChromeDriver(localchromeOptions);
                break;

                // I could not get headless to work properly, please use regular chrome
            case "headlesschrome":
                ChromeOptions headlesschromeOptions = new ChromeOptions();

                headlesschromeOptions.addArguments("--headless");
                headlesschromeOptions.addArguments("--window-size=1920x1080");
                headlesschromeOptions.addArguments("--disable-gpu");
                headlesschromeOptions.addArguments("--disable-dev-shm-usage"); // Helps with stability
                headlesschromeOptions.addArguments("--no-sandbox");
                headlesschromeOptions.addArguments("--incognito");
                headlesschromeOptions.addArguments("--font-render-hinting=none");

                driver = new ChromeDriver(headlesschromeOptions);
                break;

            default:
                System.err.println("Browser type '" + BROWSER + "' is not supported. Please use 'chrome' or 'headlesschrome'.");
                throw new IllegalArgumentException("Unsupported browser type: " + BROWSER);

        }

        driver.manage().timeouts().implicitlyWait(DefaultImplicitlyWait, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, SECONDS);
        driver.manage().timeouts().setScriptTimeout(120, SECONDS);
        return driver;

    }

}

