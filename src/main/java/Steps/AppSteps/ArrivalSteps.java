package Steps.AppSteps;

import Helpers.TestUser;
import Page.BasePage;
import Page.LoginPage;
import io.cucumber.java.en.Given;

import static Helpers.BaseConstants.USER;

public class ArrivalSteps extends BasePage {

    //This class ( could ) incorporate multiple pages and steps to arrive at a testing area in a specific state

    @Given("^I goto (Site|Sessions|Identities|Authentications|Analytics|Flows|Workflows|Compliance|Users|Status|Configuration) as (Bob|Admin)$")
    public void iGoToTheSiteAndNavigateTo(String navBarElement, String usertype) {
        navigateToSite();
        USER = new TestUser(usertype);
        new LoginPage().LoginAsUser(USER.getUsername(), USER.getPassword());
        ClickOnTheNavMenuItem(navBarElement);
    }

    @Given("^I navigate to (Site|Sessions|Identities|Authentications|Analytics|Flows|Workflows|Compliance|Users|Status|Configuration)")
    public void iGoNavigateTo(String navBarElement) {
        ClickOnTheNavMenuItem(navBarElement);
    }
}
