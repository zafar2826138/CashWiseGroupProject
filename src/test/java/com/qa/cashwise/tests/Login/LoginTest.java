package com.qa.cashwise.tests.Login;

import org.testng.annotations.Test;
import com.qa.cashwise.pages.Login.LoginPage;
import com.qa.cashwise.tests.TesBase;

public class LoginTest extends TesBase {
    @Test
    public void loginHappyPath() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(driver);

    }
}
