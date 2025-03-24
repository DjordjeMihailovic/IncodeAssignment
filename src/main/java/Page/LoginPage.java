package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Helpers.BaseConstants.DRIVER;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log In']")
    private WebElement loginButton;

    @FindBy(css = ".forgot-password")
    private WebElement forgotPassword;

    @FindBy(xpath = "//button[text()='Send Reset Link']")
    private WebElement ResetPasswordButton;


    public LoginPage() {
        PageFactory.initElements(DRIVER, this);
    }

    public void LoginAsUser (String username, String password) {
        clearAndSendKeys(emailField, username);
        // yuk, but I got this for now
        emailField.sendKeys(Keys.TAB);
        clearAndSendKeys(passwordField, password);
        SingleClick(loginButton);
    }



}
