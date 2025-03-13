package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Driver;

import java.time.Duration;

public class LoginTest {
    @Test (groups = {"login"})
    public void testSuccess(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPagen = new LoginPage();
        loginPagen.login("Admin", "admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
    @Test
    public void testUnSuccess(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPagen = new LoginPage();
        loginPagen.login("Admin", "adm123");
        Assert.assertTrue(loginPagen.invalidLog.isDisplayed());
    }
}
