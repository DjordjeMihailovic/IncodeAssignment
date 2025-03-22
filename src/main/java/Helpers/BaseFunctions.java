package Helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

import static Helpers.BaseConstants.*;

public class BaseFunctions {

    protected static JavascriptExecutor js = (JavascriptExecutor) DRIVER;
    protected static WebDriverWait wait30 = new WebDriverWait(DRIVER, Duration.ofSeconds(30));

    public void navigateToSite() {
        DRIVER.navigate().to(ENV);
    }

    public static void waitForElementToBeInteractable(WebElement element) {
        wait30.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void forcedwait(double seconds) {
        long secondsToWait = (long) (seconds * 1000);
        try {
            Thread.sleep(secondsToWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clearAndSendKeys (WebElement textbox, String text) {
        waitForElementToBeInteractable(textbox);
        textbox.clear();
        textbox.sendKeys(text);
    }

    public static void SingleClick(WebElement element) {
        waitForElementToBeInteractable(element);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    protected void waitForPageToLoad() {

    }
}
