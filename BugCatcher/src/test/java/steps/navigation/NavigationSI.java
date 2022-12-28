package steps.navigation;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ManagerPage;
import runners.BugCatcherRunner;

import java.nio.file.WatchEvent;

import static org.junit.Assert.*;

public class NavigationSI {

    public WebDriver driver = BugCatcherRunner.driver;
    public ManagerPage managerPage = BugCatcherRunner.managerPage;

    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
        //need to  check the links
        //assertEquals( link, driver.findElement(By.xpath("//nav/a")).getText());
        //assertEquals("Home", driver.getTitle());
       assertTrue(driver.findElement(By.xpath("/html/body/div/nav/a")).isDisplayed());
    }

    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() {
        // Write code here that turns the phrase above into concrete actions
        managerPage.matricesLink.click();
    }

    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("Matrix Dashboard", driver.getTitle());
    }

    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().back();
    }

    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("Home", driver.getTitle());
        //assertEquals("Home" , driver.getTitle().split(" ")[1]);
    }

    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() {
        // Write code here that turns the phrase above into concrete actions
        managerPage.testcasesLink.click();
    }

    @When("The manager clicks on {string}")
    public void the_manager_clicks_on(String link) {
        // Write code here that turns the phrase above into concrete actions
        managerPage.driver.findElement(By.linkText(link)).click();

    }

    @Then("The title of page should be {string}")
    public void the_title_of_page_should_be(String title) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(title, driver.getTitle());
    }
}
