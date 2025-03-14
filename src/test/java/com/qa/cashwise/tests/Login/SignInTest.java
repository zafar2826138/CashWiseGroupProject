package com.qa.cashwise.tests.Login;

import com.qa.cashwise.pages.Login.SignInPage;
import com.qa.cashwise.tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignInTest extends TestBase {


        @Test
        public void validateSignInFunctionality() throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://cashwise.us/main");


            SignInPage signInPage = new SignInPage(driver);


            signInPage.clickSignInButton();
            Thread.sleep(2000);

            signInPage.enterEmail("test1234567890@gmail.com");
            signInPage.enterPassword("test1234567890@gmail.com");
            signInPage.clickLoginButton();

            Thread.sleep(2000);


            String actualTitle = driver.getTitle();
            String expectedTitle = "Cashwise";
            Assert.assertEquals(actualTitle, expectedTitle, "Title did not match");

            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = "https://cashwise.us/dashboard/infographics";
            Assert.assertEquals(actualUrl, expectedUrl, "URL did not match");



        }
}
