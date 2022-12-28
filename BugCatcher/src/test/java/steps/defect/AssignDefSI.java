package steps.defect;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ManagerPage;
import runners.BugCatcherRunner;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AssignDefSI {

    public WebDriver driver = BugCatcherRunner.driver;
    public ManagerPage managerPage = BugCatcherRunner.managerPage;

    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        // using explicit wait until the button shows up
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(managerPage.selectButton));
        assertEquals(true, managerPage.selectButton.isDisplayed());
    }

    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        // Write code here that turns the phrase above into concrete actions
        managerPage.selectButton.click();
    }

    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(true, managerPage.description.isDisplayed());
    }

    @When("The manager selects a tester from the drop down list")
    public void the_manager_selects_a_tester_from_the_drop_down_list() {
        // Write code here that turns the phrase above into concrete actions
//        Select dropEmployee = new Select(driver.findElement(By.xpath("//div/input")));
//        dropEmployee.selectByIndex(1);
        driver.findElement(By.xpath("//div/input")).sendKeys("ryeGuy");
    }

    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        // Write code here that turns the phrase above into concrete actions
        managerPage.assignButton.click();
    }

    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        // Write code here that turns the phrase above into concrete actions
       int x=1; // big loool
    }
}
