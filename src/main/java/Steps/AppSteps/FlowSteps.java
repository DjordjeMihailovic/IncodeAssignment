package Steps.AppSteps;

import Helpers.Table;
import Page.BasePage;
import Page.FlowsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.Map;

import static Helpers.BaseConstants.GeneratedFlowName;
import static org.testng.AssertJUnit.assertEquals;

public class FlowSteps extends BasePage {

    @And("I create a basic flow with Modules {string}")
    public void iCreateABasicFlowWithModules(String modules) {

        new FlowsPage().iClickOnNewFlowButton();
        new FlowsPage().iCreateAutomationFlowName();
        new FlowsPage().iClickOnNewFlowNextButton();

        String[] moduleNames = modules.split(", ");
            for (String moduleName : moduleNames) {
                new FlowsPage().iAddModuleName(moduleName);
            }

    }

    @And("I click on Save Flow")
    public void iClickOnSaveFlow() {
        // not ideal
        forcedwait(3);
        new FlowsPage().iClickOnSaveFlowButton();
    }


    @And("I do Action {string} on my Flow")
    public void iDoActionOnMyFlow(String action) {
        new FlowsPage().iDoActionOnFlow(GeneratedFlowName, action);
            if (action.equals("Delete flow")) {
                new FlowsPage().iClickOnConfirmButton();
            }
    }

    @Then("My Flow should be created successfully")
    public void myFlowShouldBeCreatedSuccessfully() {
        new FlowsPage().iSearchForMyFlow();
        Map<String, String> presentFlow = new Table().getHeaderToCellMappingForRow(0);

        assertEquals("My Flow was not created successfully", GeneratedFlowName, presentFlow.get("NAME"));
    }

}
