package com.qa.cashwise.pages.SignIn.Negative;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;
import utils.ConfigReader;

public class SignInPage {
    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Sign in']")
    WebElement signInButton;

    @FindBy(css = "#email_input_text")
    WebElement email;

    @FindBy(css = "#password_input_text")
    WebElement password;


    @FindBy(xpath = "//div[@error='1']//p")
    WebElement errorInputMessage;



    @FindBy(xpath = "(//form/button)[2]")
    WebElement signInButton2;

    @FindBy(xpath = "//*[@id=\"header\"]/h2")
    WebElement titleOfTheCompany;


    // @Parameters({"errorEmailMessage", "errorPasswordMessage"})
    public void negativeSignInFunctionality1(String email, String password) throws InterruptedException {

        signInButton.click();
        //Thread.sleep(2000);
        this.email.sendKeys(email);
       // Thread.sleep(2000);
        this.password.sendKeys(password);
      //  Thread.sleep(1500);
        this.signInButton2.click();
        //Thread.sleep(1500);
    }

    public String errorMessage1() {
        return BrowserUtils.getText(errorInputMessage);//it will return the error message
    }

    public void positiveSignInFunctionality(String email, String password) throws InterruptedException {

        signInButton.click();
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        signInButton2.click();
        Thread.sleep(2000);
//        Assert.assertEquals(BrowserUtils.getText(titleOfTheCompany), "IT company");
        Assert.assertEquals(BrowserUtils.getText(titleOfTheCompany), ConfigReader.ReadProperty("cashwiseUser_businessName"));
    }
}


