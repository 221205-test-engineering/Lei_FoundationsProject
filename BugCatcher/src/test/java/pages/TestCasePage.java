package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasePage {

    public WebDriver driver;
    public TestCasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form/fieldset/textarea[1]")
    public WebElement tcDescriptionInput;

    @FindBy(xpath = "//form/fieldset/textarea[2]")
    public WebElement tcStepsInput;

    @FindBy(xpath = "//fieldset/button")
    public WebElement submitButton;

    @FindBy(xpath = "//table/tbody/tr[last()]/td[last()]")
    public WebElement detailButton;

    @FindBy(xpath = "/html/body/div[3]/div/div")
    public WebElement tcModal;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[1]/textarea[1]")
    public WebElement modalDescription;

    @FindBy(xpath = "/html/body/div[3]/div/div/button[2]/a")
    public WebElement editButtonModal;

    @FindBy(xpath = "/html/body/div/button")
    public WebElement editButtonCE;
}
