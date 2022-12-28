package steps.defect;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

import static org.junit.Assert.*;
import static runners.BugCatcherRunner.*;

public class ReportDefNegResultSI {

    @When("The employee types in description with")
    public void the_employee_types_in_description_with(String docString) {
        // Write code here that turns the phrase above into concrete actions
        defectReportPage.drDescInput.sendKeys(docString);
    }

    @When("The employee selects high priority")
    public void the_employee_selects_high_priority() {
        // Write code here that turns the phrase above into concrete actions
        defectReportPage.priorityBar.sendKeys("3");
    }

    @When("The employee selects low severity")
    public void the_employee_selects_low_severity() {
        // Write code here that turns the phrase above into concrete actions
        defectReportPage.severityBar.sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT);
    }

    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears() {
        // Write code here that turns the phrase above into concrete actions
        try {
            driver.switchTo().alert().accept();
            fail("was present from scenario 1");
        } catch (NoAlertPresentException e){
        }

    }

    @When("The employee types in steps with")
    public void the_employee_types_in_steps_with(String docString) {
        // Write code here that turns the phrase above into concrete actions
        defectReportPage.drStepsInput.sendKeys(docString);
    }
}
