package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TesterPage {

    public WebDriver driver;
    public TesterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[2]")
    public WebElement testcasesLink;

    // tester defect report page... it should be in another POM

    @FindBy(xpath = "//*[@id=\"defectReport\"]/input[1]")
    public WebElement dateInput;

    @FindBy(xpath = "//*[@id=\"root\"]/ul")
    public WebElement listOfDefects;

    @FindBy(xpath = "/html/body/div[1]/ul/li/div/span/p/b[last()]")
    public WebElement currentStatus;

    @FindBy(xpath = "/html/body/div/ul/li/div/div/div/div[1]/span/button")
    public WebElement changeStatButton;

    @FindBy(xpath = "/html/body/div[1]/ul/li/div/div/div/div[1]/div/div/button")
    public WebElement statOptions;
}
