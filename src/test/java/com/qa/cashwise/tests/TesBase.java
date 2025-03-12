package com.qa.cashwise.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverHelper;

import java.time.Duration;

public class TesBase {
    protected WebDriver driver = DriverHelper.getDriver();
    @BeforeMethod
    public void setup(){

      driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.ReadProperty("cashwiseURL"));

    }
    @AfterMethod
    public void tearDown(){
    //    driver.quit();
    }
}
