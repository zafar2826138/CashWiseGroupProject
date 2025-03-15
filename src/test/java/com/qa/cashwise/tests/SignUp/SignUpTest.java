package com.qa.cashwise.tests.SignUp;

import com.qa.cashwise.pages.SignUp.SignUpPage;
import com.qa.cashwise.tests.TestBase;
import org.testng.annotations.Test;


public class SignUpTest extends TestBase {
    @Test
    public void signUpTest() throws InterruptedException {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSignUpButton();
        signUpPage.sendEmailAndPasswordInfo();
        signUpPage.clickContinueButton();
        signUpPage.sendUserInfo(driver);
        signUpPage.validationOfClientInfo();
    }
}
