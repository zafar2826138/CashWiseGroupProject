package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;
import pages.PIMPage;
import utilities.Driver;

public class PIMTest {
    LoginPage login = new LoginPage();
    PIMPage pim = new PIMPage();
    CommonPage common = new CommonPage();
    WebDriver driver = Driver.getDriver();

    @BeforeMethod
    public void login(){
        login.login("Admin","admin123");
    }
    @Test
    public void verifyAdminCanCreateEmployee(){
        common.pimTab.click();
        pim.addEmployee();
        String expectedName = pim.firstName+" "+pim.lastName;

    }
}
