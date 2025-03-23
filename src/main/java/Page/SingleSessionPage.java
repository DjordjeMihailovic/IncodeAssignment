package Page;

import Helpers.BaseFunctions;
import Helpers.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

import static Helpers.BaseConstants.DRIVER;

public class SingleSessionPage extends BasePage {

    @FindBy(xpath = "//span[@class='span-title' and contains(text(),'flow')]/div")
    private WebElement Flow;

    @FindBy(xpath = "//span[@class='span-title' and contains(text(),'session id')]/div")
    private WebElement SessionId;

    @FindBy(xpath = "//span[@class='span-title' and contains(text(),'session start')]/span")
    private WebElement SessionStart;

    @FindBy(xpath = "//span[@class='span-title' and contains(text(),'session end')]/span")
    private WebElement SessionEnd;

    @FindBy(xpath = "//span[@class='span-title' and contains(text(),'session status')]/span")
    private WebElement SessionStatus;

    @FindBy(xpath = "//span[@class='span-title' and contains(text(),'Full Name (OCR)')]/following-sibling::span")
    private WebElement FullNameOcr;


    public SingleSessionPage() {
        PageFactory.initElements(DRIVER, this);
    }


    public void theRowValuesShouldMatchWithValuesOnTheSingleSessionPage (Map<String, String> Map) {
        new BaseFunctions().validateFieldForMap("FLOW", Map, Flow);
        new BaseFunctions().validateFieldForMap("SESSION ID", Map, SessionId);
        new BaseFunctions().validateFieldForMap("STARTED AT", Map, SessionStart);
        new BaseFunctions().validateFieldForMap("COMPLETED AT", Map, SessionEnd);
        new BaseFunctions().validateFieldForMap("SESSION STATUS", Map, SessionStatus);
        new BaseFunctions().validateFieldForMap("NAME", Map, FullNameOcr);
        // more could be added; Gov Validation etc.; I need to know all possible states of a created Session on Sessions Page
    }
}
