package Page;

import Helpers.BaseFunctions;
import Helpers.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static Helpers.BaseConstants.DRIVER;
import static org.testng.AssertJUnit.assertTrue;

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

    public void getIDOcrData() {
        // Use a HashMap to store the final key-value pairs
        Map<String, String> idOcrData = new HashMap<>();

        // Locate all elements that end with "id-info"
        for (WebElement idInfoClass : DRIVER.findElements(By.cssSelector("[class$='id-info']"))) {
            // Locate all "dinamic-field" child elements of the current "id-info" section
            for (WebElement dynamicField : idInfoClass.findElements(By.className("dinamic-field"))) {
                try {

                    // Directly fetch text of the first and second spans to form key-value pairs
                    String key = dynamicField.findElement(By.xpath("./span[1]")).getText();
                    String value = dynamicField.findElement(By.xpath("./span[2]")).getText();

                    // Store the key-value pair in the map, overwriting duplicate keys
                    idOcrData.put(key, value);
                } catch (NoSuchElementException ignored) {
                    // Ignore fields that don't have the required structure (missing spans)
                }
            }
        }

        // Output the final key-value map OR do further processing
        System.out.println("Final ID OCR Data: " + idOcrData);
    }

    public String getIDFieldValue(String field) {
        WebElement spanElement = DRIVER.findElement(By.xpath("//span[@class='span-title' and text()='" + field + "']/following-sibling::span"));
        return spanElement.getText();
    }

}