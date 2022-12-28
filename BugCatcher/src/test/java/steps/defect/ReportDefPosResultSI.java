package steps.defect;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DefectReportPage;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.junit.Assert.*;
import static runners.BugCatcherRunner.*;

public class ReportDefPosResultSI {

    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("https://bugcatcher-dan.coe.revaturelabs.com/?dev=22");
        loginPage.usernameInput.sendKeys("g8tor");
        loginPage.passwordInput.sendKeys("chomp!");
        loginPage.loginButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.titleContains("Home"));
        managerPage.reportdefectLink.click();
    }

    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() {
        // Write code here that turns the phrase above into concrete actions
        SimpleDateFormat todaysDate = new SimpleDateFormat("MM-dd-yyyy");

        String date = todaysDate.format(new Date());
        testerPage.dateInput.sendKeys(date);
    }

    @When("The employee types in Description with")
    public void the_employee_types_in_description_with(String docString) {
        // Write code here that turns the phrase above into concrete actions
        defectReportPage.drDescInput.sendKeys(docString);
    }

    @When("The employee types in Steps with")
    public void the_employee_types_in_steps_with(String docString) {
        // Write code here that turns the phrase above into concrete actions
        defectReportPage.drStepsInput.sendKeys(docString);
    }

    @When("The employee selects {string} priority")
    public void the_employee_selects_priority(String string) {
        // Write code here that turns the phrase above into concrete actions
        defectReportPage.priorityBar.sendKeys(string);
    }

    @When("The employee selects {string} severity")
    public void the_employee_selects_severity(String string) {
        // Write code here that turns the phrase above into concrete actions
        defectReportPage.severityBar.sendKeys(string);
    }

    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(defectReportPage.repDefButton));
        defectReportPage.repDefButton.click();
    }

    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        assertTrue(driver.switchTo().alert().getText().contains("Confirm"));
    }

    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() {
        // Write code here that turns the phrase above into concrete actions
        driver.switchTo().alert().accept();
    }

    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(defectReportPage.drModal));
        assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/div/h4")).getText().contains("Defect"));
    }

    @When("The employee clicks close")
    public void the_employee_clicks_close() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("/html/body/div[3]/div/div/button")).click();
    }

    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        // Write code here that turns the phrase above into concrete actions
        //new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                //.invisibilityOf(driver.findElement(By.xpath("/html/body/div[3]/div/div"))));
        //driver.findElement(By.xpath("/html/body/div[3]/div/div")).c;

        //assertEquals(true, driver.getTitle().contains("Case")); // to change

        try {
            driver.findElement(By.xpath("/html/body/div[3]/div/div")).isDisplayed();
            fail() ;
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }


    }
}
