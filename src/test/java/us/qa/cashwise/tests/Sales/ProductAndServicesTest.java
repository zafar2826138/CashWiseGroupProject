package us.qa.cashwise.tests.Sales;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import us.qa.cashwise.pages.Login.LoginPage;
import us.qa.cashwise.pages.Sales.ProductAndServicesPage;
import us.qa.cashwise.tests.TesBase;

public class ProductAndServicesTest extends TesBase {


    @Test
    public void validateAddProductAndServicesFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(driver);
        ProductAndServicesPage productAndServicesPage = new ProductAndServicesPage(driver);
        productAndServicesPage.goToProductServicePage();
        productAndServicesPage.addProductAndServices(driver, "Apple", "22", "new california");
    }


}
