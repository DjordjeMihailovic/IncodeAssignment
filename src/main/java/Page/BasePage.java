package Page;

import Helpers.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Helpers.BaseConstants.DRIVER;

public class BasePage extends BaseFunctions {

    public static void ClickOnTheNavMenuItem(String item) {
        // Locate the link using the href attribute and passed item
        WebElement navLink = DRIVER.findElement(By.linkText(item));
        SingleClick(navLink);
    }

}
