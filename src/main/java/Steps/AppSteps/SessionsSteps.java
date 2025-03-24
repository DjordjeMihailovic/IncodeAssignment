package Steps.AppSteps;

import Helpers.BaseConstants;
import Helpers.BaseFunctions;
import Page.SessionsPage;
import Page.SingleSessionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class SessionsSteps extends BaseFunctions {


    @And("I extract the Session data for id {string}")
    public void iExtractSessionData(String value) {
        BaseConstants.sessionCellsMapped = new SessionsPage().getSessionTableDataForRowWithValue(value);
    }

    @And("I click on the Session containing id {string}")
    public void iClickOnTheSession(String value) {
        new SessionsPage().iClickOnSessionRowWithValue(value);
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
