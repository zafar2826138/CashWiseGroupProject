package us.qa.cashwise.tests.Login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import us.qa.cashwise.pages.Login.LoginPage;
import us.qa.cashwise.tests.TesBase;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginTest extends TesBase {
    @Test
    public void loginHappyPath() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(driver);

    }
}
