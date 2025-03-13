package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import utilities.Driver;


public class ParBankTest {
    @Test
    public void test1() throws InterruptedException {
        Driver.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
        RegisterPB register = new RegisterPB();
        register.registration();
        LogIn login = new LogIn();
        login.setLogIn();
        AvailableBalance balanceCheck = new AvailableBalance();

    }

}

