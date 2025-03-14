package com.qa.cashwise.tests.Login.Negative;

import org.testng.annotations.DataProvider;

public class SignInTestData {

    @DataProvider(name = "signInData")
    public Object[][] getData() {
        return new Object[][]{

//                {"project@gmail", "project123","Please enter a valid email address"},
//                {"project@gmail.com", "pro","Password must be at least 6 characters"}
                {"dossimovaib@gmail", "Indira123","Please enter a valid email address"},
                {"dossimovaib@gmail.com", "Ind","Password must be at least 6 characters"}

        };
    }
}
