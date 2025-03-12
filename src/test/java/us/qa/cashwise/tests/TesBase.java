package us.qa.cashwise.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverHelper;

public class TesBase {
    WebDriver driver = DriverHelper.getDriver();
    @BeforeMethod
    public void setup(){

        driver.get(ConfigReader.ReadProperty("cashwiseURL"));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
