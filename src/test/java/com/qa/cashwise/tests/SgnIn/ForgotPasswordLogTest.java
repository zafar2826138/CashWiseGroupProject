package com.qa.cashwise.tests.SgnIn;

import com.qa.cashwise.pages.SignIn.ForgotPassword;
import com.qa.cashwise.tests.TestBase;
import org.testng.annotations.Test;

public class ForgotPasswordLogTest extends TestBase {
    @Test
    public void forgotPassword() throws InterruptedException {
       ForgotPassword forgot=new ForgotPassword(driver);
       forgot.forgotPasswordFunctionality("Logotype","Ссылка для сброса пароля отправлена!","@gmail");
    }
}
