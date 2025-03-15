package com.qa.cashwise.pages.SignIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;
import utils.ConfigReader;

public class ForgotPassword {
    public ForgotPassword(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[.='Sign in']")
    WebElement signInButton1;
    @FindBy(xpath = "//input[@id='email_input_text']")
    WebElement email;
    @FindBy(xpath = "//span[contains(text(),'Forgot password?')]")
    WebElement forgotPasswordButton;
    @FindBy(xpath = "//input[@id='email_input_text']")
    WebElement emailBox;
    @FindBy(xpath = "//button[contains(text(),'Отправить')]")
    WebElement sendBox;
    @FindBy(xpath = "//p[contains(text(),'Logotype')]")
    WebElement header;
    @FindBy(xpath = "//p[contains(text(),'Ссылка для сброса пароля отправлена!')]")
    WebElement messageSendLink;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/span")
    WebElement messageSended;
    public void forgotPasswordFunctionality(String expectedHeader,String expectedMessageLink,String messagecontains) throws InterruptedException {
signInButton1.click();
Thread.sleep(2000);
email.sendKeys(ConfigReader.ReadProperty("email"));
forgotPasswordButton.click();
emailBox.sendKeys(ConfigReader.ReadProperty("email"));
sendBox.click();
Thread.sleep(3000);
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
       Assert.assertEquals(BrowserUtils.getText(messageSendLink),expectedMessageLink);
       Assert.assertTrue(BrowserUtils.getText(messageSended).contains(messagecontains));
    }
}
