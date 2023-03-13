package com.fidexio.step_definitions;

import com.fidexio.pages.LoginPage;
import com.fidexio.utils.BrowserUtils;
import com.fidexio.utils.ConfigurationReader;
import com.fidexio.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    String currentUsername, currentPassword;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("User enters valid email {string}")
    public void user_enters_valid_email(String email) {
    loginPage.email.sendKeys(email);
    }

    @When("User enters valid password {string}")
    public void user_enters_valid_password(String password) {
        loginPage.password.sendKeys(password);

    }
    @When("User clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginBtn.click();

    }
    @Then("User should be on the homepage")
    public void user_should_be_on_the_homepage() {
        Driver.getDriver().manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "#Inbox - Odoo";
        Assert.assertTrue(expectedTitle.equals(actualTitle));
    }

    @When("User enters invalid email {string}")
    public void user_enters_invalid_email(String email) {
        loginPage.email.sendKeys(email);
    }
    @When("User enters invalid password {string}")
    public void user_enters_invalid_password(String password) {
    loginPage.password.sendKeys(password);
    }
    @Then("User should see warning message")
    public void user_should_see_warning_message() {
    Assert.assertTrue(loginPage.warningMessage.isDisplayed());
    Assert.assertEquals("Wrong login/password", loginPage.warningMessage.getText());
    }


    @When("User enters empty email {string}")
    public void user_enters_empty_email(String email) {
        loginPage.email.sendKeys(email);
    }
    @When("User enters  empty password {string}")
    public void user_enters_empty_password(String password) {
        loginPage.password.sendKeys(password);
    }
    @Then("user should see {string} validation message")
    public void user_should_see_validation_message(String string) {

        if (loginPage.email.getAttribute("required").equals("required")) {
            Assert.assertEquals("Please fill out this field.",loginPage.email.getAttribute("validationMessage"));
        }

        if (loginPage.password.getAttribute("required").equals("required")) {
            Assert.assertEquals("Please fill out this field.",loginPage.password.getAttribute("validationMessage"));
        }

             //   BrowserUtils.isAttributePresent(loginPage.email, "required");
             //   BrowserUtils.isAttributePresent(loginPage.password, "required");
    }

}
