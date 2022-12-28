package steps.testcases;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;
import static runners.BugCatcherRunner.*;

public class TestCasesSI {

    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("https://bugcatcher-dan.coe.revaturelabs.com/?dev=22");
        loginPage.usernameInput.sendKeys("ryeGuy");
        loginPage.passwordInput.sendKeys("coolbeans");
        loginPage.loginButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(testerPage.testcasesLink));
        testerPage.testcasesLink.click();
    }

    @When("The tester types Description into input with")
    public void the_tester_types_description_into_input_with(String docString) {
        // Write code here that turns the phrase above into concrete actions
        testCasePage.tcDescriptionInput.sendKeys(docString);
    }

    @When("The tester types Steps into input with")
    public void the_tester_types_steps_into_input_with(String docString) {
        // Write code here that turns the phrase above into concrete actions
        testCasePage.tcStepsInput.sendKeys(docString);
        tcTableSize = driver.findElements(By.xpath("//table/tbody/tr")).size();
        System.out.println(tcTableSize);
    }

    public static int tcTableSize; // move it up
    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        testCasePage.submitButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        // I need to change this lol
        new WebDriverWait(driver,Duration.ofSeconds(5));
        int newtcTableSize = driver.findElements(By.xpath("//table/tbody/tr")).size();
        System.out.println(newtcTableSize);
        assertTrue(newtcTableSize > tcTableSize);

    }

    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("UNEXECUTED",
                driver.findElement(By
                                .xpath("//tr[last()]/td[text()=\"UNEXECUTED\"]"))
                        .getText());
    }

    @When("The tester presses on details")
    public void the_tester_presses_on_details() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(testCasePage.detailButton));
        testCasePage.detailButton.click();
    }

    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(testCasePage.tcModal));
        assertEquals(true ,
                driver.findElement(By.xpath("/html/body/div[3]/div/div/h3"))
                        .getText().contains("Case"));

    }

    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("No One", driver.findElement(By
                .xpath("/html/body/div[3]/div/div/p[6]")).getText()); // could use last() later
    }

    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("/html/body/div[3]/div/div/button[1]")).click();
    }

    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {
        // Write code here that turns the phrase above into concrete actions

        try {
            driver.findElement(By.xpath("/html/body/div[3]/div/div")).isDisplayed();
            fail() ;
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
        }

    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(testCasePage.editButtonModal));
        testCasePage.editButtonModal.click();
    }

    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.titleContains("Case Editor"));
        assertEquals("Case Editor", driver.getTitle());
    }

    @When("The tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() {
        // Write code here that turns the phrase above into concrete actions

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(testCasePage.editButtonCE));
        testCasePage.editButtonCE.click();
    }

    @When("The tester types in {string} into the description text area")
    public void the_tester_types_in_into_the_description_text_area(String string) {
        // Write code here that turns the phrase above into concrete actions
        testCasePage.modalDescription.clear();
        testCasePage.modalDescription.sendKeys(string);
    }

    @When("The tester types in {string} into the steps text area")
    public void the_tester_types_in_into_the_steps_text_area(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"root\"]/fieldset[1]/textarea[2]"))
                .clear();
        driver.findElement(By.xpath("//*[@id=\"root\"]/fieldset[1]/textarea[2]"))
                .sendKeys(string);
    }

    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"root\"]/fieldset[1]/input")).click();
    }

    @When("The tester selects {string} for performed from drop down")
    public void the_tester_selects_for_performed_from_drop_down(String string) {
        // Write code here that turns the phrase above into concrete actions
        Select dropTester = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/fieldset[1]/select")));
        dropTester.selectByVisibleText(string);
    }

    @When("The tester selects {string} for test result from drop down")
    public void the_tester_selects_for_test_result_from_drop_down(String string) {
        // Write code here that turns the phrase above into concrete actions
        Select dropResult = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/fieldset[2]/select")));
        dropResult.selectByVisibleText(string);
    }

    @When("The tester types in {string} into the summary text area")
    public void the_tester_types_in_into_the_summary_text_area(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"root\"]/fieldset[2]/textarea"))
                .sendKeys(string);
    }

    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"root\"]/button[2]")).click();
    }

    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        String confirmationAlert = driver.switchTo().alert().getText();
        assertEquals(true, confirmationAlert.contains("Are you sure"));
    }

    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() {
        // Write code here that turns the phrase above into concrete actions
        driver.switchTo().alert().accept();
    }

    @Then("An alert says the test case has been saved")
    public void an_alert_says_the_test_case_has_been_saved() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        String savedTC = driver.switchTo().alert().getText();
        assertEquals(true, savedTC.contains("Saved"));
        driver.switchTo().alert().accept();
    }

    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"root\"]/button[1]")).click();
    }

    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        // Write code here that turns the phrase above into concrete actions
        testCasePage.modalDescription.getText(); // will change that
    }
}
