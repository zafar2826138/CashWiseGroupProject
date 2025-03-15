package com.qa.cashwise.pages.Sales;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;
import utils.ConfigReader;

public class InvoicePage {
    public InvoicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Sign in']")
    WebElement signInButton1;
    @FindBy(xpath = "//input[@id='email_input_text']")
    WebElement email;
    @FindBy(xpath = "//label[.='Password']")
    WebElement password;
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    WebElement signInButton2;
    @FindBy(xpath="//div[@id='panel1a-header']")
    WebElement sales;
    @FindBy(xpath="//a[contains(text(),'Invoice')]")
    WebElement invoice;
    @FindBy(xpath="//button[contains(text(),'Create invoice')]")
    WebElement createInvoice;
    @FindBy(xpath = "//input[@id='invoice_title_input_text']")
    WebElement invoiceName;
    @FindBy(xpath = "//div[@class=' css-1d8n9bt']")
    WebElement whom;
    @FindBy(css = "#react-select-5-option-0")
    WebElement whomOption;
    @FindBy(xpath=" /html/body/div/div/div/main/form/header/div/div[1]/div[3]/div[2]/div/div/input")
    WebElement Payuntil;
    @FindBy(xpath = "/html/body/div/div/div/main/form/header/div/div[1]/div[4]/div/div/textarea[1]")
    WebElement description;
    @FindBy(xpath = "//p[contains(text(),'Market')]")
    WebElement companyName;
    @FindBy(xpath = "//button[@aria-label='Choose date']")
    WebElement date;
    @FindBy(xpath = "/html/body/div/div/div/main/form/div/div/button")
    WebElement selectProduct;
    @FindBy(xpath = "/html/body/div/div/div/main/form/div/div/div/div/div[2]/div[1]/div[1]/div/div")
    WebElement cleaning;
@FindBy(xpath = "//*[@id=\"main\"]/div/button")
WebElement save;
    public void signIn(WebDriver driver) throws InterruptedException {
        signInButton1.click();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.sendKeys(email, "Batchseven@gmail.com").perform();
        actions.sendKeys(password, "batch7").perform();
        actions.click(signInButton2).perform();
    }public void invoiceFunctionality(WebDriver driver) throws InterruptedException {
        sales.click();
        invoice.click();
        createInvoice.click();
        Thread.sleep(3000);
        invoiceName.sendKeys(ConfigReader.ReadProperty("invoice_name"));
        Thread.sleep(3000);
        Actions actions=new Actions(driver);
        actions.click(whom).perform();  Thread.sleep(3000);
        whomOption.click();
        Payuntil.sendKeys("20/03/2025");
actions.sendKeys(Keys.ENTER);
   Assert.assertEquals(BrowserUtils.getText(companyName),"Market");
 Assert.assertEquals(BrowserUtils.getText(whom),"CodeWise");
description.sendKeys("Hello");
selectProduct.click();
cleaning.click();
        save.click();




    }}

