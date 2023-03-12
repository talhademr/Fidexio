package com.fidexio.step_definitions;

import com.fidexio.pages.LoginPage;
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

public class LoginFunctionalityStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("environment"));
    }

    @When("User enters valid email {string}")
    public void userEntersValidEmail(String arg0) {
        loginPage.email.sendKeys(arg0);
    }

    @And("User enters valid password {string}")
    public void userEntersValidPassword(String arg0) {
        loginPage.password.sendKeys(arg0);
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
        loginPage.loginBtn.click();
    }

    @Then("User should be on the homepage")
    public void userShouldBeOnTheHomepage() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        String expectedTitle = "#Inbox - Odoo";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
