package steps.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import runners.BugCatcherRunner;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginNegSI {

    public WebDriver driver = BugCatcherRunner.driver;
    public LoginPage loginPage = BugCatcherRunner.loginPage;

    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.usernameInput.sendKeys("g8tor");
    }

    @When("The employee types in chomp!! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.passwordInput.sendKeys("chomp");
    }

    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        // Switch to alert and copy the message
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        assertEquals("Wrong password for User", alertMessage); // could use a contain "text" here?
        //Also needed to accept the alert as it crashes the program
        driver.switchTo().alert().accept();
    }

    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.usernameInput.sendKeys("sicEmDawgs");
    }

    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.passwordInput.sendKeys("natchamps");
    }

    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
        // Switch to alert and copy the message
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        assertEquals("Username not found", alertMessage);
        //Also needed to accept the alert as it crashes the program
        driver.switchTo().alert().accept();
    }
}
