package steps.matrix;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.ManagerPage;
import pages.MatrixPage;
import runners.BugCatcherRunner;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MatrixSI {

    public WebDriver driver = BugCatcherRunner.driver;
    public LoginPage loginPage = BugCatcherRunner.loginPage;
    public ManagerPage managerPage = BugCatcherRunner.managerPage;
    public MatrixPage matrixPage = BugCatcherRunner.matrixPage;
    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=22");
        loginPage.usernameInput.sendKeys("g8tor");
        loginPage.passwordInput.sendKeys("chomp!");
        loginPage.loginButton.click();

    }

    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleContains("Home"));
        assertEquals("Manager Home", driver.getTitle());

    }

    @When("The manager chooses to create a new matrix")
    public void the_manager_chooses_to_create_a_new_matrix() {
        // Write code here that turns the phrase above into concrete actions
        managerPage.createMatrix.click();
    }

    @When("The manager creates a title for the matrix")
    public void the_manager_creates_a_title_for_the_matrix() {
        // Write code here that turns the phrase above into concrete actions
        managerPage.matrixTitleInput.sendKeys("Test Matrix");
    }

    @When("The manager adds requirements to the matrix")
    public void the_manager_adds_requirements_to_the_matrix() {
        // Write code here that turns the phrase above into concrete actions
        managerPage.addRqrmtButton.click();
    }

    @When("The manager saves the matrix")
    public void the_manager_saves_the_matrix() {
        // Write code here that turns the phrase above into concrete actions
        managerPage.saveMatrixButton.click();
    }

    @Then("An alert with a success message should appear")
    public void an_alert_with_a_success_message_should_appear() {
        // Since the prompt was ambiguous about what specifically should be in the alert I just went with
        // checking if the alert message contains the string "created"
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        String successMatrixAlert = driver.switchTo().alert().getText();
        assertEquals(true, successMatrixAlert.contains("created"));
        driver.switchTo().alert().accept();
    }

    @Given("The manager is on the matrix homepage")
    public void the_manager_is_on_the_matrix_homepage() {
        // Write code here that turns the phrase above into concrete actions
        managerPage.matricesLink.click();
    }

    @Given("The manager has selected the matrix")
    public void the_manager_has_selected_the_matrix() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(matrixPage.showButton));
        matrixPage.showButton.click();
    }

    @When("The manager adds a defect")
    public void the_manager_adds_a_defect() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(matrixPage.editButton));
        matrixPage.editButton.click();
        matrixPage.defectInput.sendKeys("910");
        matrixPage.addDefectButton.click();
    }

    @When("The manager confirms their changes")
    public void the_manager_confirms_their_changes() {
        // Write code here that turns the phrase above into concrete actions
        matrixPage.saveRequirementButton.click();
    }

    @When("The manager adds a Test Cases")
    public void the_manager_adds_a_test_cases() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(matrixPage.editButton));
        matrixPage.editButton.click();
        matrixPage.testlistInput.sendKeys("810");
        matrixPage.addTestButton.click();
    }


    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        String savedMessage = driver.switchTo().alert().getText();
        assertEquals(true, savedMessage.contains("Saved"));
        driver.switchTo().alert().accept();
    }

}
