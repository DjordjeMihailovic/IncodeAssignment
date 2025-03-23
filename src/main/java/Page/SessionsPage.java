package Page;

import Helpers.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

import static Helpers.BaseConstants.DRIVER;

public class SessionsPage extends BasePage {

    @FindBy(xpath = "//button[text()='Add Filter']")
    private WebElement AddFilterButton;


    public SessionsPage() {
        wait30.until(ExpectedConditions.visibilityOf(AddFilterButton));
        PageFactory.initElements(DRIVER, this);
    }

}


