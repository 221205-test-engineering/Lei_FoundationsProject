package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MatrixPage {

    public WebDriver driver;
    public MatrixPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[1]")
    public WebElement showButton;

//    @FindBy(xpath = "//*[@id=\"collapsible-trigger-1671901071489\"]/button")
//    public WebElement showButton;

    @FindBy(xpath = "//ul[1]/li[last()]/button")
    public WebElement addTestButton;

    @FindBy(xpath = "//ul[2]/li[last()]/button")
    public WebElement addDefectButton;

    @FindBy(xpath = "//td[last()]/button")
    public WebElement editButton;

    @FindBy(xpath = "//input[@list = \"testlist\"]")
    public WebElement testlistInput;

    @FindBy(xpath = "//input[@list = \"defectlist\"]")
    public WebElement defectInput;

    @FindBy(xpath = "//button[text()=\"Save Requirements\"]")
    public WebElement saveRequirementButton;
}
