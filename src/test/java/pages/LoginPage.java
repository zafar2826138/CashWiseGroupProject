package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    WebDriver driver;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(name = "username")
    public WebElement username;
    @FindBy(name = "password")
    public WebElement pass;
    @FindBy(css = "button[type=submit]")
    public WebElement login;
    @FindBy(xpath = "//div[@class='oxd-alert oxd-alert--error']")
    public WebElement invalidLog;

    public void login(String usnm, String pwd) {
        username.sendKeys(usnm);
        pass.sendKeys(pwd);
        login.click();

    }
}

