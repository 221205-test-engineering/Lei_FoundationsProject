package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPage {

    public WebDriver driver;
    public ManagerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[1]")
    public WebElement matricesLink;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[2]")
    public WebElement testcasesLink;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[3]")
    public WebElement reportdefectLink;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[4]")
    public WebElement defectoverviewLink;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[5]")
    public WebElement logoutLink;

    @FindBy(xpath = "//*[@id=\"root\"]/button")
    public WebElement createMatrix;

    @FindBy(xpath = "//*[@id=\"root\"]/input")
    public WebElement matrixTitleInput;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset/button")
    public  WebElement addRqrmtButton;

    @FindBy(xpath = "//*[@id=\"root\"]/button")
    public WebElement saveMatrixButton;

    @FindBy(xpath = "//table/tbody/tr[1]/td[last()]/button")
    public WebElement selectButton;

    @FindBy(xpath = "//div/button[text()=\"Assign\"]")
    public WebElement assignButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/h4")
    public WebElement description;
}
