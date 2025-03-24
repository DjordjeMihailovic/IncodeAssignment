package Helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Map;


import static Helpers.BaseConstants.*;

public class BaseFunctions {

    protected static JavascriptExecutor js = (JavascriptExecutor) DRIVER;
    public static WebDriverWait wait30 = new WebDriverWait(DRIVER, Duration.ofSeconds(30));

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

    public void validateFieldForMap(String key, Map<String, String> map, String value) {
        String expectedValue = map.get(key).toLowerCase();
        String actualValue = value.toLowerCase();
        System.out.println(actualValue);
        System.out.println(expectedValue);
        System.out.println("==========");

        Assert.assertEquals(actualValue, expectedValue, "Mismatch for " + key + ". Expected: " + expectedValue + ", Found: " + actualValue);
    }

    public void CrossValidateMapsForKey(String key, Map<String, String> referenceMap, Map<String, String> targetMap) {
        String expectedValue = referenceMap.get(key).toLowerCase();
        String actualValue = targetMap.get(key).toLowerCase();
        System.out.println(actualValue);
        System.out.println(expectedValue);
        System.out.println("==========");

        Assert.assertEquals(actualValue, expectedValue, "Mismatch for key: " + key + ". Expected: " + expectedValue + ", Found: " + actualValue);
    }




}


