package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefectReportPage {

    public WebDriver driver;
    public DefectReportPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"defectReport\"]/textarea[1]")
    public WebElement drDescInput;

    @FindBy(xpath = "//*[@id=\"defectReport\"]/textarea[2]")
    public WebElement drStepsInput;


    @FindBy(xpath = "//*[@id=\"defectReport\"]/input[2]")
    public WebElement severityBar;

    @FindBy(xpath = "//*[@id=\"defectReport\"]/input[3]")
    public WebElement priorityBar;

    @FindBy(xpath = "/html/body/div[1]/form/button")
    public WebElement repDefButton;

    @FindBy(xpath = "/html/body/div[3]/div/div")
    public WebElement drModal;
}
