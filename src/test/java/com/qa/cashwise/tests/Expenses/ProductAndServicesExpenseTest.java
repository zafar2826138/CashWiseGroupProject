package com.qa.cashwise.tests.Expenses;

import com.qa.cashwise.pages.Expenses.ProductAndServicesExpensePage;
import com.qa.cashwise.pages.Login.Negative.SignInPage;
import com.qa.cashwise.tests.TestBase;

import org.testng.annotations.Test;
import utils.ConfigReader;

public class ProductAndServicesExpenseTest extends TestBase {

    @Test
    public void addProductAndServicesInExpenses() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        ProductAndServicesExpensePage productAndServicesExpensePage = new ProductAndServicesExpensePage(driver);
        signInPage.positiveSignInFunctionality(ConfigReader.ReadProperty("cashwise_email"), ConfigReader.ReadProperty("cashwise_password"));


        productAndServicesExpensePage.openProductAndServicesFromExpenses();
        productAndServicesExpensePage.addProductAndServicesFunctionality();
        productAndServicesExpensePage.deleteTheProduct();

    }

}
