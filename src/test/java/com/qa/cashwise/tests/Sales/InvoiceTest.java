package com.qa.cashwise.tests.Sales;

import com.qa.cashwise.pages.Sales.InvoicePage;
import com.qa.cashwise.tests.TestBase;
import org.testng.annotations.Test;


public class InvoiceTest extends TestBase {
    @Test
    public void invoiceDataTesting() throws InterruptedException {
        InvoicePage invoicePage =new InvoicePage(driver);
        invoicePage.signIn(driver);
        invoicePage.invoiceFunctionality(driver);
    }
}
