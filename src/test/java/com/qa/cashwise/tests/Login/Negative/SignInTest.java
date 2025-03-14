package com.qa.cashwise.tests.Login.Negative;

import com.qa.cashwise.pages.Login.Negative.SignInPage;
import com.qa.cashwise.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends TestBase {

    @Test(dataProvider = "signInData",dataProviderClass = SignInTestData.class)
    public void signInWithNegativeCredentials (String email, String password,String  expectedErrorMessage) throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.negativeSignInFunctionality1(email, password);
        Assert.assertEquals(signInPage.errorMessage1(),expectedErrorMessage);


    }

}
