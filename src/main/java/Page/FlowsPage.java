package Page;

import Helpers.BaseConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

import static Helpers.BaseConstants.DRIVER;
import static Helpers.BaseConstants.GeneratedFlowName;

public class FlowsPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(), 'New')]")
    private WebElement newButton;

    @FindBy(xpath = "//input[@name='flowName']")
    private WebElement FindAFlow;

    @FindBy(xpath = "//div[starts-with(@class, 'menu-list')]//button")
    private WebElement FlowActions;





    @FindBy(xpath = "//input[contains(@id, 'name')]")
    private WebElement flowNameInput;

    @FindBy(xpath = "//button[contains(text(), 'Next: Select modules')]")
    private WebElement NewFlowNextButton;

    @FindBy(xpath = "//input[@placeholder='Find a module']")
    private WebElement findModuleInput;

    @FindBy(xpath = "//img[@alt='add']")
    private WebElement addModule;

    @FindBy(xpath = "//button[contains(text(), 'Save flow')]")
    private WebElement SaveFlowButton;

    @FindBy(xpath = "//button[contains(text(), 'Confirm')]")
    private WebElement ConfirmButton;



    public FlowsPage() {
        // wait30.until(ExpectedConditions.visibilityOf(AddFilterButton));
        PageFactory.initElements(DRIVER, this);
    }


    public void iClickOnNewFlowButton() {
        SingleClick(newButton);
    }

    public void iClickOnConfirmButton() {
        SingleClick(ConfirmButton);
    }

    public void iEnterFlowName(String flowName) {
        clearAndSendKeys(flowNameInput, flowName);
    }

    public void iCreateAutomationFlowName() {
        GeneratedFlowName = "AutoFlow" + (1000000 + new Random().nextInt(9000000));
        clearAndSendKeys(flowNameInput, GeneratedFlowName);
    }


    public void iClickOnNewFlowNextButton() {
        SingleClick(NewFlowNextButton);
    }

    public void iAddModuleName(String moduleName) {
        clearAndSendKeys(findModuleInput, moduleName);
        SingleClick(addModule);
    }

    public void iClickOnSaveFlowButton() {
        SingleClick(SaveFlowButton);
    }

    public void iSearchForMyFlow() {
        clearAndSendKeys(FindAFlow, GeneratedFlowName);
    }

    public void iDoActionOnFlow(String flowName, String action) {
        clearAndSendKeys(FindAFlow, flowName);
        SingleClick(FlowActions);
        WebElement actionElement = DRIVER.findElement(By.xpath("//li[span[text()='" + action + "']]"));
        SingleClick(actionElement);
    }

}
