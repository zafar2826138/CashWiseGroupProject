package com.qa.cashwise.tests.Sales;

import com.github.javafaker.Faker;
import com.qa.cashwise.pages.Sales.ClientsPage;
import com.qa.cashwise.pages.SignIn.Negative.SignInPage;
import com.qa.cashwise.tests.TestBase;
import org.testng.annotations.Test;


import utils.ConfigReader;


public class ClientsTest extends TestBase {
    @Test
    public void validateSalesFunctionality() throws InterruptedException {
Faker faker = new Faker();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.positiveSignInFunctionality(ConfigReader.ReadProperty("cashwise_email"), ConfigReader.ReadProperty("cashwise_password"));

        Thread.sleep(2000);
        ClientsPage salesPageTestVersion = new ClientsPage(driver);
        salesPageTestVersion.sales("Mika", "Jamal", faker.internet().emailAddress(), "3242342300", "bulvard 32");


    }
}