package steps.defect;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static runners.BugCatcherRunner.*;

public class DefStatSI {

    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page() {
        // I need to add the other testerzzzzz
        driver.navigate().to("https://bugcatcher-dan.coe.revaturelabs.com/?dev=22");
        loginPage.usernameInput.sendKeys("ryeGuy");
        loginPage.passwordInput.sendKeys("coolbeans");
        loginPage.loginButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.titleContains("Home"));

    }

    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(true, testerPage.listOfDefects.isDisplayed());
    }

    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() {
        // Write code here that turns the phrase above into concrete actions
        testerPage.currentStatus.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(testerPage.changeStatButton));
        testerPage.changeStatButton.click();
        testerPage.statOptions.click();

    }

    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(testerPage.statOptions.getText(), testerPage.currentStatus.getText());
    }
}
