package Steps.AppSteps;

import Helpers.BaseConstants;
import Helpers.BaseFunctions;
import Helpers.Table;
import Page.BasePage;
import Page.SessionsPage;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class IdentitiesSteps extends BasePage {

    private Map<String, String> identitiesCellMapping;

    Table table = new Table();


    @Then("Newly Added Users {string} is present on the Identities Page")
    public void newlyAddedUsersIsPresentOnTheIdentitiesPage(String column) {
        List<String> columnValues = table.getColumnValues(column);
        String value = BaseConstants.sessionUserFieldValue.toLowerCase();

        System.out.println(value);
        System.out.println(columnValues);

        assertTrue(columnValues.contains(value), "The value '" + value + "' is not found in the column values: " + columnValues);


    }
}
