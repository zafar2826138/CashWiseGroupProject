package com.qa.cashwise.tests.Sales;

import com.github.javafaker.Faker;
import com.qa.cashwise.pages.SignIn.Negative.SignInPage;
import org.testng.annotations.Test;
import com.qa.cashwise.pages.Sales.ProductAndServicesPage;
import com.qa.cashwise.tests.TestBase;
import utils.ConfigReader;

public class ProductAndServicesTest extends TestBase {


    @Test
    public void validateAddProductAndServicesFunctionality() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        Faker faker = new Faker();
        signInPage.positiveSignInFunctionality(ConfigReader.ReadProperty("cashwise_email"), ConfigReader.ReadProperty("cashwise_password"));
        ProductAndServicesPage productAndServicesPage = new ProductAndServicesPage(driver);
        productAndServicesPage.goToProductServicePage();
        productAndServicesPage.addProductAndServices(driver, faker.funnyName().name(), faker.number().digit(), faker.country().name());
    }


}
