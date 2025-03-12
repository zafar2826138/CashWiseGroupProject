package us.qa.cashwise.pages.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.ConfigReader;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[.='Sign in']")
    WebElement signInButton1;
    @FindBy(xpath = "(//label[.='Email'])[2]")
    WebElement email;
    @FindBy(xpath = "//label[.='Password']")
    WebElement password;
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    WebElement signInButton2;

    public void signIn(WebDriver driver) throws InterruptedException {
        signInButton1.click();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(email, "Batchseven@gmail.com").perform();
        actions.sendKeys(password, "batch7").perform();
        actions.click(signInButton2).perform();
    }
}
