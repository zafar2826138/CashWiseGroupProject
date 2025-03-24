package com.qa.cashwise.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverHelper;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver = DriverHelper.getDriver();
    ChromeOptions options = new ChromeOptions();

    @BeforeMethod
    public void setup() {
        options.addArguments("--headless");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.ReadProperty("cashwise_url"));

    }

    @AfterMethod
    public void tearDown() {
            driver.quit();
    }
}
