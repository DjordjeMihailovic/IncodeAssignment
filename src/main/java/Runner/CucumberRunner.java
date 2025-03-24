package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/java/Features",
        glue = "Steps",
        plugin = {"pretty","json:target/cucumber-reports/cucumber.json"},
        tags = "@AutomationAssignment")

public class CucumberRunner extends AbstractTestNGCucumberTests {}


