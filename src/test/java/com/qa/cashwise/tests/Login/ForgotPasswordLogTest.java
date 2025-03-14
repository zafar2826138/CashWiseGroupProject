package com.qa.cashwise.tests.Login;

import com.qa.cashwise.pages.Login.ForgotPassword;
import com.qa.cashwise.tests.TestBase;
import org.testng.annotations.Test;

public class ForgotPasswordLogTest extends TestBase {
    @Test
    public void forgotPassword() throws InterruptedException {
       ForgotPassword forgot=new ForgotPassword(driver);
       forgot.forgotPasswordFunctionality("Logotype","Ссылка для сброса пароля отправлена!","@gmail");
    }
}
