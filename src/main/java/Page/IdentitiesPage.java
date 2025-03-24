package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static Helpers.BaseConstants.DRIVER;


public class IdentitiesPage extends BasePage {

    @FindBy(xpath = "//button[text()='Add Filter']")
    private WebElement AddFilterButton;

    public IdentitiesPage() {
        PageFactory.initElements(DRIVER, this);
    }

}

