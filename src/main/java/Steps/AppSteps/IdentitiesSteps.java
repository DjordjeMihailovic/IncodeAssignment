package Steps.AppSteps;

import Helpers.BaseConstants;
import Helpers.Table;
import Page.BasePage;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class IdentitiesSteps extends BasePage {


    Table table = new Table();


    @Then("Newly Added Users {string} is present on the Identities Page")
    public void newlyAddedUsersIsPresentOnTheIdentitiesPage(String column) {
        List<String> columnValues = table.getColumnValues(column);
        String value = BaseConstants.sessionUserFieldValue.toLowerCase();

        assertTrue("The value '" + value + "' is not found in the column values: " + columnValues, columnValues.contains(value));
    }

}
