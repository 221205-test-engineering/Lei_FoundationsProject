package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "steps")
public class BugCatcherRunner {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ManagerPage managerPage;
    public static MatrixPage matrixPage;
    public static TesterPage testerPage;
    public static TestCasePage testCasePage;
    public static DefectReportPage defectReportPage;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        managerPage = new ManagerPage(driver);
        matrixPage = new MatrixPage(driver);
        testerPage = new TesterPage(driver);
        testCasePage = new TestCasePage(driver);
        defectReportPage = new DefectReportPage(driver);

    }

    @AfterClass
    public static void teardown(){driver.quit();}
}
