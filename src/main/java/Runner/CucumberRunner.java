package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/Features",
        glue = "Steps",
        plugin = {"pretty","json:target/cucumber-reports/cucumber.json"},
        tags = "@AutomationAssignment")

public class CucumberRunner {}


