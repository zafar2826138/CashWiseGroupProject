package com.qa.cashwise.tests.Sales;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import com.qa.cashwise.pages.Login.LoginPage;
import com.qa.cashwise.pages.Sales.ProductAndServicesPage;
import com.qa.cashwise.tests.TesBase;

public class ProductAndServicesTest extends TesBase {


    @Test
    public void validateAddProductAndServicesFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Faker faker = new Faker();
        loginPage.signIn(driver);
        ProductAndServicesPage productAndServicesPage = new ProductAndServicesPage(driver);
        productAndServicesPage.goToProductServicePage();
        productAndServicesPage.addProductAndServices(driver, "apple2", "22", "new california");
    }


}
