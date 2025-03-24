package Steps.AppSteps;

import Helpers.BaseConstants;
import Helpers.BaseFunctions;
import Helpers.Table;
import Page.SessionsPage;
import Page.SingleSessionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.Map;

public class SessionsSteps extends BaseFunctions {


    @And("I extract the {int}. Session data")
    public void iExtractSessionData(int number) {
        int rowIndex = number - 1;
        BaseConstants.sessionCellsMapped = new SessionsPage().getSessionTableDataForRow(rowIndex);
    }

    @And("I click on the {int}. Session")
    public void iClickOnTheSession(int num) {
        new SessionsPage().iClickOnSessionRow(num);
    }

    @Then("The Session row values should match with values on the Single Session Page")
    public void theRowValuesShouldMatchWithValuesOnTheSingleSessionPage() {
        new SingleSessionPage().theRowValuesShouldMatchWithValuesOnTheSingleSessionPage(BaseConstants.sessionCellsMapped);
        System.out.println(new SingleSessionPage().getIDFieldValue("birth date "));
    }

    @And("I make sure that the Face is added to Database")
    public void iMakeSureThatTheFaceIsAddedToDatabase() {
        new SingleSessionPage().AddFaceToDatabase();
    }


    @And("I save the {string} field value of the User in Single Session Page")
    public void iSaveTheOfTheUserInSingleSessionPage(String field) {
       BaseConstants.sessionUserFieldValue = new SingleSessionPage().getIDFieldValue(field);
    }
}
