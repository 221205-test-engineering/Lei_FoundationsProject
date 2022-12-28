package steps.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import runners.BugCatcherRunner;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginPosSI {

    public WebDriver driver = BugCatcherRunner.driver;
    public LoginPage loginPage = BugCatcherRunner.loginPage;

    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        BugCatcherRunner.driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=22");// why bugcatcher first?
    }

    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String username) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.usernameInput.sendKeys(username);
    }

    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.passwordInput.sendKeys(password);
    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        // At this point it was printing their role + "Home" so I put the title into an array
        loginPage.loginButton.click();
    }

    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String role) {
        // Write code here that turns the phrase above into concrete actions
        //String arr[] = driver.getTitle().split(" ");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleContains("Home"));
        assertEquals(role, driver.getTitle().split(" ")[0]);

    }

    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_on_the_home_page(String fname, String lname) {

        // Located the Web element on the homepage containing the users names needed to use getText
       WebElement firstLast = driver.findElement(By.xpath("//*[@id=\"root\"]/nav/p"));
       // assertEquals("Welcome " + fname + " " + lname, firstLast.getText());
        assertEquals(fname + " " + lname, driver
                .findElement(By.xpath("//*[@id=\"root\"]/nav/p"))
                .getText().split(" ", 2)[1]);
    }
}
