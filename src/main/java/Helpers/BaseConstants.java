package Helpers;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class BaseConstants {

    public static WebDriver DRIVER;

    public static String BROWSER;
    public static String ENV;

    public static int DefaultImplicitlyWait = 120;

    public static boolean ISLOCALTEST;

    public static TestUser USER;

    public static Map<String, String> sessionCellsMapped = new HashMap<>();

    public static Map<String, String> identityCellsMapped = new HashMap<>();

    public static String sessionUserFieldValue;

    public static String GeneratedFlowName;


}
