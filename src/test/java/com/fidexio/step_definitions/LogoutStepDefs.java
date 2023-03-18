package com.fidexio.step_definitions;

import com.fidexio.pages.LoginPage;
import com.fidexio.pages.Logout_Page;
import com.fidexio.utils.BrowserUtils;
import com.fidexio.utils.ConfigurationReader;
import com.fidexio.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutStepDefs {
    LoginPage loginPage = new LoginPage();
    Logout_Page logoutPage = new Logout_Page();

    @Given("User goes to the login page")
    public void user_goes_to_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @Given("User logged in with valid credentials")
    public void user_logged_in_with_valid_credentials() {
        loginPage.email.sendKeys("salesmanager99@info.com");
        loginPage.password.sendKeys("salesmanager");
        loginPage.loginBtn.click();
    }

    @Then("User sees the home page")
    public void user_sees_the_home_page() {
        BrowserUtils.waitForElement(logoutPage.userNameButton);
        Assert.assertTrue(logoutPage.userNameButton.isDisplayed());
    }

    @When("User clicks the username button")
    public void user_clicks_the_username_button() {
        logoutPage.userNameButton.click();
    }

    @When("User clicks the logout button")
    public void user_clicks_the_logout_button() {
        logoutPage.logoutButton.click();

    }

    @Then("User goes back to login page")
    public void user_goes_back_to_login_page() {
        Assert.assertTrue(loginPage.email.isDisplayed());
    }

    @And("User clicks back button")
    public void userClicksBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("User can not go to the home page again")
    public void userCanNotGoToTheHomePageAgain() {
        Assert.assertTrue(logoutPage.logoutMessage.isDisplayed());
    }


}
