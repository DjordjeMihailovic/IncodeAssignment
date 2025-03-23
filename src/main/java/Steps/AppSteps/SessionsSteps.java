package Steps.AppSteps;

import Helpers.BaseFunctions;
import Helpers.Table;
import Page.SingleSessionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.Map;

public class SessionsSteps extends BaseFunctions {

    private Map<String, String> sessionsCellMapping;

    @And("I extract the {int}. Session data")
    public void iOpenTheSession(int number) {
        Table table = new Table();
        sessionsCellMapping = table.getHeaderToCellMapping(number);
    }

    @And("I click on the {int}. Session")
    public void iClickOnTheSession(int num) {
        Table.ClickOnRow(num);
    }

    @Then("The Session row values should match with values on the Single Session Page")
    public void theRowValuesShouldMatchWithValuesOnTheSingleSessionPage() {
        new SingleSessionPage().theRowValuesShouldMatchWithValuesOnTheSingleSessionPage(sessionsCellMapping);
    }
}
