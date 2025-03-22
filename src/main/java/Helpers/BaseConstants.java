package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseConstants {

    public static String CLIENT;
    public static WebDriver DRIVER;

    public static String URL;
    public static String BROWSER;
    public static String ENV;

    public static ChromeOptions chromeOptions;

    public static int DefaultImplicitlyWait = 120;

    public static boolean ISLOCALTEST;

    public static TestUser USER;

}
