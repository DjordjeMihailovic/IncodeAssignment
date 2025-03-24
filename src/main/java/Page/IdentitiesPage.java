package Page;

import Helpers.BaseConstants;
import Helpers.Table;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

import static Helpers.BaseConstants.DRIVER;
import static Helpers.BaseFunctions.wait30;

public class IdentitiesPage {

    @FindBy(xpath = "//button[text()='Add Filter']")
    private WebElement AddFilterButton;

    public IdentitiesPage() {
        wait30.until(ExpectedConditions.visibilityOf(AddFilterButton));
        PageFactory.initElements(DRIVER, this);
    }


    public void CheckSessionUserDataAgainstIdentity () {


    }
}
