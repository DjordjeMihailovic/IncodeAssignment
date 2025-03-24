package Page;

import Helpers.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;


import static Helpers.BaseConstants.DRIVER;
import static org.junit.Assert.assertTrue;

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

    @FindBy(xpath = "//button[text()='Add face to Database']")
    private WebElement addFaceToDatabaseButton;


    public SingleSessionPage() {
        PageFactory.initElements(DRIVER, this);
    }


    public void theRowValuesShouldMatchWithValuesOnTheSingleSessionPage(Map<String, String> Map) {
        new BaseFunctions().validateFieldForMap("FLOW", Map, Flow.getText());
        new BaseFunctions().validateFieldForMap("SESSION ID", Map, SessionId.getText());
        new BaseFunctions().validateFieldForMap("STARTED AT", Map, SessionStart.getText());
        new BaseFunctions().validateFieldForMap("COMPLETED AT", Map, SessionEnd.getText());
        new BaseFunctions().validateFieldForMap("SESSION STATUS", Map, SessionStatus.getText());
        new BaseFunctions().validateFieldForMap("NAME", Map, FullNameOcr.getText());
        // more could be added; Gov Validation etc.; I need to know all possible states of a created Session on Sessions Page
    }

    public void AddFaceToDatabase() {
        if (addFaceToDatabaseButton.isEnabled()) {
            SingleClick(addFaceToDatabaseButton);
        }
        WebElement faceToDatabaseTextElement = DRIVER.findElement(By.xpath("//*[text()='Face in database']"));
        assertTrue("Could not find add the Face to Database", faceToDatabaseTextElement.isDisplayed());

    }

    public String getIDFieldValue(String field) {
        WebElement spanElement = DRIVER.findElement(By.xpath("//span[@class='span-title' and text()='" + field + "']/following-sibling::span"));
        return spanElement.getText();
    }

}