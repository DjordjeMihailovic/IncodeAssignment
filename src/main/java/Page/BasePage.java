package Page;

import Helpers.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Helpers.BaseConstants.DRIVER;

public class BasePage extends BaseFunctions {

    public void ClickOnTheNavMenuItem(String item) {
        WebElement navLink = DRIVER.findElement(By.xpath("//a[contains(text(),'" + item + "')]"));
        SingleClick(navLink);
    }

}
