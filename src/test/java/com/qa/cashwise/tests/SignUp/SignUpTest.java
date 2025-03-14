package com.qa.cashwise.tests.SignUp;

import com.qa.cashwise.pages.SignUp.ClientDashBoardPage;
import com.qa.cashwise.pages.SignUp.SignUpPage;
import com.qa.cashwise.tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.ConfigReader;



public class SignUpTest extends TestBase {
    @Test
    public void signUpTest() throws InterruptedException {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSignUpButton();
        signUpPage.sendEmailAndPasswordInfo();
        signUpPage.clickContinueButton();
        signUpPage.sendUserInfo(driver);
        ClientDashBoardPage clientDashBoardPage = new ClientDashBoardPage(driver);
        clientDashBoardPage.validationOfClientInfo(ConfigReader.ReadProperty("cashwiseNameOfCompany"));

    }
}
